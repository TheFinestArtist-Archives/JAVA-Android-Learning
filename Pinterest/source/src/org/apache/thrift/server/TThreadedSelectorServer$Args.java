// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.transport.TNonblockingServerTransport;

public class AcceptPolicy.FAST_ACCEPT extends tractNonblockingServerArgs
{

    private AcceptPolicy acceptPolicy;
    private int acceptQueueSizePerThread;
    private ExecutorService executorService;
    public int selectorThreads;
    private TimeUnit stopTimeoutUnit;
    private int stopTimeoutVal;
    private int workerThreads;

    public AcceptPolicy acceptPolicy(AcceptPolicy acceptpolicy)
    {
        acceptPolicy = acceptpolicy;
        return this;
    }

    public acceptPolicy acceptQueueSizePerThread(int i)
    {
        acceptQueueSizePerThread = i;
        return this;
    }

    public acceptQueueSizePerThread executorService(ExecutorService executorservice)
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

    public workerThreads selectorThreads(int i)
    {
        selectorThreads = i;
        return this;
    }

    public selectorThreads stopTimeoutUnit(TimeUnit timeunit)
    {
        stopTimeoutUnit = timeunit;
        return this;
    }

    public stopTimeoutUnit stopTimeoutVal(int i)
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

    public acceptQueueSizePerThread workerThreads(int i)
    {
        workerThreads = i;
        return this;
    }







    public t(TNonblockingServerTransport tnonblockingservertransport)
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
