// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocolFactory, TBinaryProtocol, TProtocol

public class strictWrite_
    implements TProtocolFactory
{

    protected boolean strictRead_;
    protected boolean strictWrite_;

    public TProtocol getProtocol(TTransport ttransport)
    {
        return new TBinaryProtocol(ttransport, strictRead_, strictWrite_);
    }

    public ()
    {
        this(false, true);
    }

    public <init>(boolean flag, boolean flag1)
    {
        strictRead_ = false;
        strictWrite_ = true;
        strictRead_ = flag;
        strictWrite_ = flag1;
    }
}
