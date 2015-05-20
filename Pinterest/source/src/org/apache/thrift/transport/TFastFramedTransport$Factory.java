// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportFactory, TFastFramedTransport, TTransport

public class maxLength extends TTransportFactory
{

    private final int initialCapacity;
    private final int maxLength;

    public TTransport getTransport(TTransport ttransport)
    {
        return new TFastFramedTransport(ttransport, initialCapacity, maxLength);
    }

    public ()
    {
        this(1024, 0xfa0000);
    }

    public <init>(int i)
    {
        this(i, 0xfa0000);
    }

    public <init>(int i, int j)
    {
        initialCapacity = i;
        maxLength = j;
    }
}
