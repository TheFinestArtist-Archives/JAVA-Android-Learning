// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingTransport;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncMethodCall, TAsyncClientManager

public abstract class TAsyncClient
{

    protected TAsyncMethodCall ___currentMethod;
    private Exception ___error;
    protected final TAsyncClientManager ___manager;
    protected final TProtocolFactory ___protocolFactory;
    private long ___timeout;
    protected final TNonblockingTransport ___transport;

    public TAsyncClient(TProtocolFactory tprotocolfactory, TAsyncClientManager tasyncclientmanager, TNonblockingTransport tnonblockingtransport)
    {
        this(tprotocolfactory, tasyncclientmanager, tnonblockingtransport, 0L);
    }

    public TAsyncClient(TProtocolFactory tprotocolfactory, TAsyncClientManager tasyncclientmanager, TNonblockingTransport tnonblockingtransport, long l)
    {
        ___protocolFactory = tprotocolfactory;
        ___manager = tasyncclientmanager;
        ___transport = tnonblockingtransport;
        ___timeout = l;
    }

    protected void checkReady()
    {
        if (___currentMethod != null)
        {
            throw new IllegalStateException((new StringBuilder("Client is currently executing another method: ")).append(___currentMethod.getClass().getName()).toString());
        }
        if (___error != null)
        {
            throw new IllegalStateException("Client has an error!", ___error);
        } else
        {
            return;
        }
    }

    public Exception getError()
    {
        return ___error;
    }

    public TProtocolFactory getProtocolFactory()
    {
        return ___protocolFactory;
    }

    public long getTimeout()
    {
        return ___timeout;
    }

    public boolean hasError()
    {
        return ___error != null;
    }

    public boolean hasTimeout()
    {
        return ___timeout > 0L;
    }

    protected void onComplete()
    {
        ___currentMethod = null;
    }

    protected void onError(Exception exception)
    {
        ___transport.close();
        ___currentMethod = null;
        ___error = exception;
    }

    public void setTimeout(long l)
    {
        ___timeout = l;
    }
}
