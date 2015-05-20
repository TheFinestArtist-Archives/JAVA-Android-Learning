// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocolFactory, TCompactProtocol, TProtocol

public class maxNetworkBytes_
    implements TProtocolFactory
{

    private final long maxNetworkBytes_;

    public TProtocol getProtocol(TTransport ttransport)
    {
        return new TCompactProtocol(ttransport, maxNetworkBytes_);
    }

    public _cls9()
    {
        maxNetworkBytes_ = -1L;
    }

    public maxNetworkBytes_(int i)
    {
        maxNetworkBytes_ = i;
    }
}
