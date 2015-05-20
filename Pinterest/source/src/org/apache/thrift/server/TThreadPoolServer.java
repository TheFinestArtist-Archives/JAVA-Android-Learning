// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServer, TServerEventHandler

public class TThreadPoolServer extends TServer
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/server/TThreadPoolServer.getName());
    private ExecutorService executorService_;
    private final TimeUnit stopTimeoutUnit;
    private final long stopTimeoutVal;
    private volatile boolean stopped_;

    public TThreadPoolServer(Args args)
    {
        super(args);
        stopped_ = false;
        stopTimeoutUnit = args.stopTimeoutUnit;
        stopTimeoutVal = args.stopTimeoutVal;
        if (args.executorService != null)
        {
            args = args.executorService;
        } else
        {
            args = createDefaultExecutorService(args);
        }
        executorService_ = args;
    }

    private static ExecutorService createDefaultExecutorService(Args args)
    {
        SynchronousQueue synchronousqueue = new SynchronousQueue();
        return new ThreadPoolExecutor(args.minWorkerThreads, args.maxWorkerThreads, 60L, TimeUnit.SECONDS, synchronousqueue);
    }

    public void serve()
    {
        WorkerProcess workerprocess;
        Object obj;
        RejectedExecutionException rejectedexecutionexception;
        try
        {
            serverTransport_.listen();
        }
        catch (TTransportException ttransportexception)
        {
            LOGGER.error("Error occurred during listening.", ttransportexception);
            return;
        }
        if (eventHandler_ != null)
        {
            eventHandler_.preServe();
        }
        stopped_ = false;
        setServing(true);
        if (stopped_)
        {
            break; /* Loop/switch isn't completed */
        }
        workerprocess = new WorkerProcess(serverTransport_.accept(), null);
_L1:
        executorService_.execute(workerprocess);
        continue; /* Loop/switch isn't completed */
        rejectedexecutionexception;
        LOGGER.warn("ExecutorService rejected client 1 times(s)", rejectedexecutionexception);
        TimeUnit.SECONDS.sleep(1L);
          goto _L1
        obj;
        try
        {
            LOGGER.warn("Interrupted while waiting to place client on executor queue.");
            Thread.currentThread().interrupt();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (!stopped_)
            {
                LOGGER.warn("Transport error occurred during acceptance of message.", ((Throwable) (obj)));
            }
        }
        if (true) goto _L3; else goto _L2
_L3:
        break MISSING_BLOCK_LABEL_33;
_L2:
        long l;
        long l1;
        executorService_.shutdown();
        l1 = stopTimeoutUnit.toMillis(stopTimeoutVal);
        l = System.currentTimeMillis();
_L5:
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        executorService_.awaitTermination(l1, TimeUnit.MILLISECONDS);
        setServing(false);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        long l2 = System.currentTimeMillis();
        l1 -= l2 - l;
        l = l2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void stop()
    {
        stopped_ = true;
        serverTransport_.interrupt();
    }




    private class Args extends TServer.AbstractServerArgs
    {

        public ExecutorService executorService;
        public int maxWorkerThreads;
        public int minWorkerThreads;
        public TimeUnit stopTimeoutUnit;
        public int stopTimeoutVal;

        public Args executorService(ExecutorService executorservice)
        {
            executorService = executorservice;
            return this;
        }

        public Args maxWorkerThreads(int i)
        {
            maxWorkerThreads = i;
            return this;
        }

        public Args minWorkerThreads(int i)
        {
            minWorkerThreads = i;
            return this;
        }

        public Args(TServerTransport tservertransport)
        {
            super(tservertransport);
            minWorkerThreads = 5;
            maxWorkerThreads = 0x7fffffff;
            stopTimeoutVal = 60;
            stopTimeoutUnit = TimeUnit.SECONDS;
        }
    }


    private class WorkerProcess
        implements Runnable
    {

        private TTransport client_;
        final TThreadPoolServer this$0;

        public void run()
        {
            Object obj7;
            Object obj9;
            Object obj12;
            obj9 = null;
            obj12 = null;
            obj7 = null;
            Object obj;
            TProcessor tprocessor;
            tprocessor = processorFactory_.getProcessor(client_);
            obj = inputTransportFactory_.getTransport(client_);
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj8;
            Object obj10;
            Object obj11;
            boolean flag;
            try
            {
                obj1 = outputTransportFactory_.getTransport(client_);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj4 = null;
                obj5 = null;
                obj8 = null;
                obj10 = null;
                obj11 = obj;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj1 = null;
                obj2 = null;
                obj3 = null;
                obj5 = obj;
                obj4 = null;
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj1 = null;
                obj2 = null;
                obj3 = null;
                obj5 = obj;
                obj4 = null;
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
            try
            {
_L3:
                obj2 = inputProtocolFactory_.getProtocol(((TTransport) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                obj4 = null;
                obj5 = null;
                obj8 = null;
                obj10 = obj1;
                obj11 = obj;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj3 = null;
                obj2 = null;
                obj5 = obj;
                obj4 = obj1;
                obj7 = null;
                obj = null;
                obj1 = obj3;
                obj3 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj3 = null;
                obj2 = null;
                obj5 = obj;
                obj4 = obj1;
                obj7 = null;
                obj = null;
                obj1 = obj3;
                obj3 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                obj3 = outputProtocolFactory_.getProtocol(((TTransport) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj3)
            {
                obj4 = null;
                obj5 = null;
                obj8 = obj2;
                obj10 = obj1;
                obj11 = obj;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj7 = null;
                obj5 = obj;
                obj4 = obj1;
                obj3 = obj2;
                obj2 = null;
                obj = null;
                obj1 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj7 = null;
                obj5 = obj;
                obj4 = obj1;
                obj3 = obj2;
                obj2 = null;
                obj = null;
                obj1 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                obj6 = getEventHandler();
            }
            catch (TTransportException ttransportexception)
            {
                ttransportexception = null;
                obj5 = obj3;
                obj8 = obj2;
                obj10 = obj1;
                obj11 = obj;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj5 = obj;
                obj4 = obj1;
                obj7 = obj2;
                obj2 = obj3;
                obj1 = null;
                obj = null;
                obj3 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj6)
            {
                obj5 = obj;
                obj4 = obj1;
                obj7 = obj2;
                obj2 = obj3;
                obj1 = null;
                obj = null;
                obj3 = obj7;
                continue; /* Loop/switch isn't completed */
            }
            if (obj6 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            obj7 = ((TServerEventHandler) (obj6)).createContext(((org.apache.thrift.protocol.TProtocol) (obj2)), ((org.apache.thrift.protocol.TProtocol) (obj3)));
_L2:
            if (obj6 == null)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            obj12 = obj7;
            ((TServerEventHandler) (obj6)).processContext(((ServerContext) (obj7)), ((TTransport) (obj)), ((TTransport) (obj1)));
            obj9 = obj7;
            obj4 = obj6;
            obj5 = obj3;
            obj8 = obj2;
            obj10 = obj1;
            obj11 = obj;
            obj12 = obj7;
            if (stopped_)
            {
                break MISSING_BLOCK_LABEL_207;
            }
            obj12 = obj7;
            flag = tprocessor.process(((org.apache.thrift.protocol.TProtocol) (obj2)), ((org.apache.thrift.protocol.TProtocol) (obj3)));
            if (flag) goto _L2; else goto _L1
_L1:
            obj11 = obj;
            obj10 = obj1;
            obj8 = obj2;
            obj5 = obj3;
            obj4 = obj6;
            obj9 = obj7;
_L8:
            if (obj4 != null)
            {
                ((TServerEventHandler) (obj4)).deleteContext(((ServerContext) (obj9)), ((org.apache.thrift.protocol.TProtocol) (obj8)), ((org.apache.thrift.protocol.TProtocol) (obj5)));
            }
            if (obj11 != null)
            {
                ((TTransport) (obj11)).close();
            }
            if (obj10 != null)
            {
                ((TTransport) (obj10)).close();
            }
            return;
            obj6;
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj4 = null;
            obj5 = null;
            obj = null;
_L6:
            TThreadPoolServer.LOGGER.error("Thrift error occurred during processing of message.", ((Throwable) (obj6)));
            obj10 = obj4;
            obj11 = obj5;
            obj9 = obj;
            obj4 = obj1;
            obj5 = obj2;
            obj8 = obj3;
            continue; /* Loop/switch isn't completed */
            obj6;
            obj1 = null;
            obj2 = null;
            obj3 = null;
            obj4 = null;
            obj5 = null;
            obj = null;
_L4:
            TThreadPoolServer.LOGGER.error("Error occurred during processing of message.", ((Throwable) (obj6)));
            obj10 = obj4;
            obj11 = obj5;
            obj9 = obj;
            obj4 = obj1;
            obj5 = obj2;
            obj8 = obj3;
            continue; /* Loop/switch isn't completed */
            obj8;
            obj5 = obj;
            obj4 = obj1;
            obj7 = obj2;
            obj2 = obj3;
            obj1 = obj6;
            obj = null;
            obj6 = obj8;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
            obj9;
            obj5 = obj;
            obj4 = obj1;
            obj8 = obj2;
            obj2 = obj3;
            obj1 = obj6;
            obj = obj7;
            obj6 = obj9;
            obj3 = obj8;
            if (true) goto _L4; else goto _L3
            obj8;
            obj5 = obj;
            obj4 = obj1;
            obj7 = obj2;
            obj2 = obj3;
            obj1 = obj6;
            obj = null;
            obj6 = obj8;
            obj3 = obj7;
            continue; /* Loop/switch isn't completed */
            obj9;
            obj5 = obj;
            obj4 = obj1;
            obj8 = obj2;
            obj2 = obj3;
            obj1 = obj6;
            obj = obj7;
            obj6 = obj9;
            obj3 = obj8;
            if (true) goto _L6; else goto _L5
_L5:
            obj;
            obj4 = null;
            obj5 = null;
            obj8 = null;
            obj10 = null;
            obj11 = null;
            continue; /* Loop/switch isn't completed */
            TTransportException ttransportexception1;
            ttransportexception1;
            obj9 = obj12;
            ttransportexception1 = ((TTransportException) (obj6));
            obj5 = obj3;
            obj8 = obj2;
            obj10 = obj1;
            obj11 = obj;
            if (true) goto _L8; else goto _L7
_L7:
        }

        private WorkerProcess(TTransport ttransport)
        {
            this$0 = TThreadPoolServer.this;
            super();
            client_ = ttransport;
        }

        WorkerProcess(TTransport ttransport, _cls1 _pcls1)
        {
            this(ttransport);
        }
    }

}
