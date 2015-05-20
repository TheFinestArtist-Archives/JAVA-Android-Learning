// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolDecorator;

// Referenced classes of package org.apache.thrift:
//            TMultiplexedProcessor

class messageBegin extends TProtocolDecorator
{

    TMessage messageBegin;
    final TMultiplexedProcessor this$0;

    public TMessage readMessageBegin()
    {
        return messageBegin;
    }

    public (TProtocol tprotocol, TMessage tmessage)
    {
        this$0 = TMultiplexedProcessor.this;
        super(tprotocol);
        messageBegin = tmessage;
    }
}
