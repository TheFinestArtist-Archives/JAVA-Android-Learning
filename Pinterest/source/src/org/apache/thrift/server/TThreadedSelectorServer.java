// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            AbstractNonblockingServer, Invocation

public class TThreadedSelectorServer extends AbstractNonblockingServer
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/server/TThreadedSelectorServer.getName());
    private AcceptThread acceptThread;
    private final Args args;
    private final ExecutorService invoker;
    private final Set selectorThreads = new HashSet();
    private volatile boolean stopped_;

    public TThreadedSelectorServer(Args args1)
    {
        super(args1);
        stopped_ = false;
        args1.validate();
        ExecutorService executorservice;
        if (args1.executorService == null)
        {
            executorservice = createDefaultExecutor(args1);
        } else
        {
            executorservice = args1.executorService;
        }
        invoker = executorservice;
        args = args1;
    }

    private static BlockingQueue createDefaultAcceptQueue(int i)
    {
        if (i == 0)
        {
            return new LinkedBlockingQueue();
        } else
        {
            return new ArrayBlockingQueue(i);
        }
    }

    protected static ExecutorService createDefaultExecutor(Args args1)
    {
        if (args1.workerThreads > 0)
        {
            return Executors.newFixedThreadPool(args1.workerThreads);
        } else
        {
            return null;
        }
    }

    protected SelectorThreadLoadBalancer createSelectorThreadLoadBalancer(Collection collection)
    {
        return new SelectorThreadLoadBalancer(collection);
    }

    protected Runnable getRunnable(AbstractNonblockingServer.FrameBuffer framebuffer)
    {
        return new Invocation(framebuffer);
    }

    protected void gracefullyShutdownInvokerPool()
    {
        long l;
        long l1;
        invoker.shutdown();
        l1 = args.stopTimeoutUnit.toMillis(args.stopTimeoutVal);
        l = System.currentTimeMillis();
_L2:
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        invoker.awaitTermination(l1, TimeUnit.MILLISECONDS);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        long l2 = System.currentTimeMillis();
        l1 -= l2 - l;
        l = l2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void joinThreads()
    {
        acceptThread.join();
        for (Iterator iterator = selectorThreads.iterator(); iterator.hasNext(); ((SelectorThread)iterator.next()).join()) { }
    }

    protected boolean requestInvoke(AbstractNonblockingServer.FrameBuffer framebuffer)
    {
        framebuffer = getRunnable(framebuffer);
        if (invoker != null)
        {
            try
            {
                invoker.execute(framebuffer);
            }
            // Misplaced declaration of an exception variable
            catch (AbstractNonblockingServer.FrameBuffer framebuffer)
            {
                LOGGER.warn("ExecutorService rejected execution!", framebuffer);
                return false;
            }
            return true;
        } else
        {
            framebuffer.run();
            return true;
        }
    }

    protected boolean startThreads()
    {
        int i = 0;
        do
        {
            Iterator iterator;
            try
            {
                if (i >= args.selectorThreads)
                {
                    break;
                }
                selectorThreads.add(new SelectorThread(args.acceptQueueSizePerThread));
            }
            catch (IOException ioexception)
            {
                LOGGER.error("Failed to start threads!", ioexception);
                return false;
            }
            i++;
        } while (true);
        acceptThread = new AcceptThread((TNonblockingServerTransport)serverTransport_, createSelectorThreadLoadBalancer(selectorThreads));
        for (iterator = selectorThreads.iterator(); iterator.hasNext(); ((SelectorThread)iterator.next()).start()) { }
        acceptThread.start();
        return true;
    }

    public void stop()
    {
        stopped_ = true;
        stopListening();
        if (acceptThread != null)
        {
            acceptThread.wakeupSelector();
        }
        if (selectorThreads != null)
        {
            Iterator iterator = selectorThreads.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                SelectorThread selectorthread = (SelectorThread)iterator.next();
                if (selectorthread != null)
                {
                    selectorthread.wakeupSelector();
                }
            } while (true);
        }
    }

    protected void waitForShutdown()
    {
        try
        {
            joinThreads();
        }
        catch (InterruptedException interruptedexception)
        {
            LOGGER.error("Interrupted while joining threads!", interruptedexception);
        }
        gracefullyShutdownInvokerPool();
    }







    private class Args extends AbstractNonblockingServer.AbstractNonblockingServerArgs
    {

        private AcceptPolicy acceptPolicy;
        private int acceptQueueSizePerThread;
        private ExecutorService executorService;
        public int selectorThreads;
        private TimeUnit stopTimeoutUnit;
        private int stopTimeoutVal;
        private int workerThreads;

        public Args acceptPolicy(AcceptPolicy acceptpolicy)
        {
            acceptPolicy = acceptpolicy;
            return this;
        }

        public Args acceptQueueSizePerThread(int i)
        {
            acceptQueueSizePerThread = i;
            return this;
        }

        public Args executorService(ExecutorService executorservice)
        {
            executorService = executorservice;
            return this;
        }

        public AcceptPolicy getAcceptPolicy()
        {
            return acceptPolicy;
        }

        public int getAcceptQueueSizePerThread()
        {
            return acceptQueueSizePerThread;
        }

        public ExecutorService getExecutorService()
        {
            return executorService;
        }

        public int getSelectorThreads()
        {
            return selectorThreads;
        }

        public TimeUnit getStopTimeoutUnit()
        {
            return stopTimeoutUnit;
        }

        public int getStopTimeoutVal()
        {
            return stopTimeoutVal;
        }

        public int getWorkerThreads()
        {
            return workerThreads;
        }

        public Args selectorThreads(int i)
        {
            selectorThreads = i;
            return this;
        }

        public Args stopTimeoutUnit(TimeUnit timeunit)
        {
            stopTimeoutUnit = timeunit;
            return this;
        }

        public Args stopTimeoutVal(int i)
        {
            stopTimeoutVal = i;
            return this;
        }

        public void validate()
        {
            if (selectorThreads <= 0)
            {
                throw new IllegalArgumentException("selectorThreads must be positive.");
            }
            if (workerThreads < 0)
            {
                throw new IllegalArgumentException("workerThreads must be non-negative.");
            }
            if (acceptQueueSizePerThread <= 0)
            {
                throw new IllegalArgumentException("acceptQueueSizePerThread must be positive.");
            } else
            {
                return;
            }
        }

        public Args workerThreads(int i)
        {
            workerThreads = i;
            return this;
        }







        public Args(TNonblockingServerTransport tnonblockingservertransport)
        {
            super(tnonblockingservertransport);
            selectorThreads = 2;
            workerThreads = 5;
            stopTimeoutVal = 60;
            stopTimeoutUnit = TimeUnit.SECONDS;
            executorService = null;
            acceptQueueSizePerThread = 4;
            class AcceptPolicy extends Enum
            {

                private static final AcceptPolicy $VALUES[];
                public static final AcceptPolicy FAIR_ACCEPT;
                public static final AcceptPolicy FAST_ACCEPT;

                public static AcceptPolicy valueOf(String s)
                {
                    return (AcceptPolicy)Enum.valueOf(org/apache/thrift/server/TThreadedSelectorServer$Args$AcceptPolicy, s);
                }

                public static AcceptPolicy[] values()
                {
                    return (AcceptPolicy[])$VALUES.clone();
                }

                static 
                {
                    FAIR_ACCEPT = new AcceptPolicy("FAIR_ACCEPT", 0);
                    FAST_ACCEPT = new AcceptPolicy("FAST_ACCEPT", 1);
                    $VALUES = (new AcceptPolicy[] {
                        FAIR_ACCEPT, FAST_ACCEPT
                    });
                }

                private AcceptPolicy(String s, int i)
                {
                    super(s, i);
                }
            }

            acceptPolicy = AcceptPolicy.FAST_ACCEPT;
        }
    }


    private class SelectorThreadLoadBalancer
    {

        private Iterator nextThreadIterator;
        final TThreadedSelectorServer this$0;
        private final Collection threads;

        public SelectorThread nextThread()
        {
            if (!nextThreadIterator.hasNext())
            {
                nextThreadIterator = threads.iterator();
            }
            return (SelectorThread)nextThreadIterator.next();
        }

        public SelectorThreadLoadBalancer(Collection collection)
        {
            this$0 = TThreadedSelectorServer.this;
            super();
            if (collection.isEmpty())
            {
                throw new IllegalArgumentException("At least one selector thread is required");
            } else
            {
                threads = Collections.unmodifiableList(new ArrayList(collection));
                nextThreadIterator = threads.iterator();
                return;
            }
        }
    }


    private class AcceptThread extends Thread
    {

        private final Selector acceptSelector = SelectorProvider.provider().openSelector();
        private final TNonblockingServerTransport serverTransport;
        final TThreadedSelectorServer this$0;
        private final SelectorThreadLoadBalancer threadChooser;

        private TNonblockingTransport doAccept()
        {
            TNonblockingTransport tnonblockingtransport;
            try
            {
                tnonblockingtransport = (TNonblockingTransport)serverTransport.accept();
            }
            catch (TTransportException ttransportexception)
            {
                TThreadedSelectorServer.LOGGER.warn("Exception trying to accept!", ttransportexception);
                return null;
            }
            return tnonblockingtransport;
        }

        private void doAddAccept(SelectorThread selectorthread, TNonblockingTransport tnonblockingtransport)
        {
            if (!selectorthread.addAcceptedConnection(tnonblockingtransport))
            {
                tnonblockingtransport.close();
            }
        }

        private void handleAccept()
        {
            final TNonblockingTransport client;
            final SelectorThread targetThread;
label0:
            {
                client = doAccept();
                if (client != null)
                {
                    targetThread = threadChooser.nextThread();
                    if (args.acceptPolicy != Args.AcceptPolicy.FAST_ACCEPT && invoker != null)
                    {
                        break label0;
                    }
                    doAddAccept(targetThread, client);
                }
                return;
            }
            try
            {
                class _cls1
                    implements Runnable
                {

                    final AcceptThread this$1;
                    final TNonblockingTransport val$client;
                    final SelectorThread val$targetThread;

                    public void run()
                    {
                        doAddAccept(targetThread, client);
                    }

                _cls1()
                {
                    this$1 = AcceptThread.this;
                    targetThread = selectorthread;
                    client = tnonblockingtransport;
                    super();
                }
                }

                invoker.submit(new _cls1());
                return;
            }
            catch (RejectedExecutionException rejectedexecutionexception)
            {
                TThreadedSelectorServer.LOGGER.warn("ExecutorService rejected accept registration!", rejectedexecutionexception);
            }
            client.close();
        }

        private void select()
        {
            acceptSelector.select();
_L2:
            SelectionKey selectionkey;
            for (Iterator iterator = acceptSelector.selectedKeys().iterator(); !stopped_ && iterator.hasNext();)
            {
                selectionkey = (SelectionKey)iterator.next();
                iterator.remove();
                if (selectionkey.isValid())
                {
                    if (!selectionkey.isAcceptable())
                    {
                        break MISSING_BLOCK_LABEL_90;
                    }
                    handleAccept();
                }
            }

              goto _L1
            IOException ioexception;
            ioexception;
            TThreadedSelectorServer.LOGGER.warn("Got an IOException while selecting!", ioexception);
_L1:
            return;
            TThreadedSelectorServer.LOGGER.warn((new StringBuilder("Unexpected state in select! ")).append(selectionkey.interestOps()).toString());
              goto _L2
        }

        public void run()
        {
            if (eventHandler_ != null)
            {
                eventHandler_.preServe();
            }
            while (!stopped_) 
            {
                select();
            }
            break MISSING_BLOCK_LABEL_59;
            Object obj;
            obj;
            TThreadedSelectorServer.LOGGER.error("run() exiting due to uncaught error", ((Throwable) (obj)));
            stop();
            return;
            stop();
            return;
            obj;
            stop();
            throw obj;
        }

        public void wakeupSelector()
        {
            acceptSelector.wakeup();
        }


        public AcceptThread(TNonblockingServerTransport tnonblockingservertransport, SelectorThreadLoadBalancer selectorthreadloadbalancer)
        {
            this$0 = TThreadedSelectorServer.this;
            super();
            serverTransport = tnonblockingservertransport;
            threadChooser = selectorthreadloadbalancer;
            serverTransport.registerSelector(acceptSelector);
        }
    }


    private class SelectorThread extends AbstractNonblockingServer.AbstractSelectThread
    {

        private final BlockingQueue acceptedQueue;
        final TThreadedSelectorServer this$0;

        private void processAcceptedConnections()
        {
            do
            {
                if (stopped_)
                {
                    break;
                }
                TNonblockingTransport tnonblockingtransport = (TNonblockingTransport)acceptedQueue.poll();
                if (tnonblockingtransport == null)
                {
                    break;
                }
                registerAccepted(tnonblockingtransport);
            } while (true);
        }

        private void registerAccepted(TNonblockingTransport tnonblockingtransport)
        {
            SelectionKey selectionkey = null;
            SelectionKey selectionkey1 = tnonblockingtransport.registerSelector(selector, 1);
            selectionkey = selectionkey1;
            if (!processorFactory_.isAsyncProcessor()) goto _L2; else goto _L1
_L1:
            selectionkey = selectionkey1;
            Object obj = new AbstractNonblockingServer.AsyncFrameBuffer(TThreadedSelectorServer.this, tnonblockingtransport, selectionkey1, this);
_L3:
            selectionkey = selectionkey1;
            try
            {
                selectionkey1.attach(obj);
                return;
            }
            catch (IOException ioexception)
            {
                TThreadedSelectorServer.LOGGER.warn("Failed to register accepted connection to selector!", ioexception);
            }
            break MISSING_BLOCK_LABEL_93;
_L2:
            selectionkey = selectionkey1;
            obj = new AbstractNonblockingServer.FrameBuffer(TThreadedSelectorServer.this, tnonblockingtransport, selectionkey1, this);
              goto _L3
            if (selectionkey != null)
            {
                cleanupSelectionKey(selectionkey);
            }
            tnonblockingtransport.close();
            return;
        }

        private void select()
        {
            Iterator iterator;
            selector.select();
            iterator = selector.selectedKeys().iterator();
_L5:
            if (stopped_ || !iterator.hasNext()) goto _L2; else goto _L1
_L1:
            SelectionKey selectionkey;
            selectionkey = (SelectionKey)iterator.next();
            iterator.remove();
            if (selectionkey.isValid()) goto _L4; else goto _L3
_L3:
            cleanupSelectionKey(selectionkey);
              goto _L5
            IOException ioexception;
            ioexception;
            TThreadedSelectorServer.LOGGER.warn("Got an IOException while selecting!", ioexception);
_L2:
            return;
_L4:
label0:
            {
                if (!selectionkey.isReadable())
                {
                    break label0;
                }
                handleRead(selectionkey);
            }
              goto _L5
label1:
            {
                if (!selectionkey.isWritable())
                {
                    break label1;
                }
                handleWrite(selectionkey);
            }
              goto _L5
            TThreadedSelectorServer.LOGGER.warn((new StringBuilder("Unexpected state in select! ")).append(selectionkey.interestOps()).toString());
              goto _L5
        }

        public boolean addAcceptedConnection(TNonblockingTransport tnonblockingtransport)
        {
            try
            {
                acceptedQueue.put(tnonblockingtransport);
            }
            // Misplaced declaration of an exception variable
            catch (TNonblockingTransport tnonblockingtransport)
            {
                TThreadedSelectorServer.LOGGER.warn("Interrupted while adding accepted connection!", tnonblockingtransport);
                return false;
            }
            selector.wakeup();
            return true;
        }

        public void run()
        {
            while (!stopped_) 
            {
                select();
                processAcceptedConnections();
                processInterestChanges();
            }
            break MISSING_BLOCK_LABEL_45;
            Object obj;
            obj;
            TThreadedSelectorServer.LOGGER.error("run() exiting due to uncaught error", ((Throwable) (obj)));
            stop();
            return;
            for (Iterator iterator = selector.keys().iterator(); iterator.hasNext(); cleanupSelectionKey((SelectionKey)iterator.next())) { }
            break MISSING_BLOCK_LABEL_93;
            iterator;
            stop();
            throw iterator;
            stop();
            return;
        }

        public SelectorThread()
        {
            this(((BlockingQueue) (new LinkedBlockingQueue())));
        }

        public SelectorThread(int i)
        {
            this(TThreadedSelectorServer.createDefaultAcceptQueue(i));
        }

        public SelectorThread(BlockingQueue blockingqueue)
        {
            this$0 = TThreadedSelectorServer.this;
            super(TThreadedSelectorServer.this);
            acceptedQueue = blockingqueue;
        }
    }

}
