// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.thrift.transport.TServerTransport;

public class stopTimeoutUnit extends rgs
{

    public ExecutorService executorService;
    public int maxWorkerThreads;
    public int minWorkerThreads;
    public TimeUnit stopTimeoutUnit;
    public int stopTimeoutVal;

    public rgs executorService(ExecutorService executorservice)
    {
        executorService = executorservice;
        return this;
    }

    public executorService maxWorkerThreads(int i)
    {
        maxWorkerThreads = i;
        return this;
    }

    public maxWorkerThreads minWorkerThreads(int i)
    {
        minWorkerThreads = i;
        return this;
    }

    public rgs(TServerTransport tservertransport)
    {
        super(tservertransport);
        minWorkerThreads = 5;
        maxWorkerThreads = 0x7fffffff;
        stopTimeoutVal = 60;
        stopTimeoutUnit = TimeUnit.SECONDS;
    }
}
