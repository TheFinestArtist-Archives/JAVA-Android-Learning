// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer, Invocation

public class THsHaServer extends TNonblockingServer
{

    private final Args args;
    private final ExecutorService invoker;

    public THsHaServer(Args args1)
    {
        super(args1);
        ExecutorService executorservice;
        if (args1.executorService == null)
        {
            executorservice = createInvokerPool(args1);
        } else
        {
            executorservice = args1.executorService;
        }
        invoker = executorservice;
        args = args1;
    }

    protected static ExecutorService createInvokerPool(Args args1)
    {
        int i = args1.workerThreads;
        int j = args1.stopTimeoutVal;
        args1 = args1.stopTimeoutUnit;
        LinkedBlockingQueue linkedblockingqueue = new LinkedBlockingQueue();
        return new ThreadPoolExecutor(i, i, j, args1, linkedblockingqueue);
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

    protected boolean requestInvoke(AbstractNonblockingServer.FrameBuffer framebuffer)
    {
        try
        {
            framebuffer = getRunnable(framebuffer);
            invoker.execute(framebuffer);
        }
        // Misplaced declaration of an exception variable
        catch (AbstractNonblockingServer.FrameBuffer framebuffer)
        {
            LOGGER.warn("ExecutorService rejected execution!", framebuffer);
            return false;
        }
        return true;
    }

    protected void waitForShutdown()
    {
        joinSelector();
        gracefullyShutdownInvokerPool();
    }

    private class Args extends AbstractNonblockingServer.AbstractNonblockingServerArgs
    {

        private ExecutorService executorService;
        private TimeUnit stopTimeoutUnit;
        private int stopTimeoutVal;
        private int workerThreads;

        public Args executorService(ExecutorService executorservice)
        {
            executorService = executorservice;
            return this;
        }

        public ExecutorService getExecutorService()
        {
            return executorService;
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

        public Args workerThreads(int i)
        {
            workerThreads = i;
            return this;
        }





        public Args(TNonblockingServerTransport tnonblockingservertransport)
        {
            super(tnonblockingservertransport);
            workerThreads = 5;
            stopTimeoutVal = 60;
            stopTimeoutUnit = TimeUnit.SECONDS;
            executorService = null;
        }
    }

}
