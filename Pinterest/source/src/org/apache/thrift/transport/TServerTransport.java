// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportException, TTransport

public abstract class TServerTransport
{

    public TServerTransport()
    {
    }

    public final TTransport accept()
    {
        TTransport ttransport = acceptImpl();
        if (ttransport == null)
        {
            throw new TTransportException("accept() may not return NULL");
        } else
        {
            return ttransport;
        }
    }

    protected abstract TTransport acceptImpl();

    public abstract void close();

    public void interrupt()
    {
    }

    public abstract void listen();
}
