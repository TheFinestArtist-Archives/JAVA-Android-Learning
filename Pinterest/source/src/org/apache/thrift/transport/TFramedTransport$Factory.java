// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportFactory, TFramedTransport, TTransport

public class maxLength_ extends TTransportFactory
{

    private int maxLength_;

    public TTransport getTransport(TTransport ttransport)
    {
        return new TFramedTransport(ttransport, maxLength_);
    }

    public ()
    {
        maxLength_ = 0xfa0000;
    }

    public maxLength_(int i)
    {
        maxLength_ = i;
    }
}
