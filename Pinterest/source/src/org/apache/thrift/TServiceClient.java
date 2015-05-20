// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift:
//            TApplicationException, TBase

public abstract class TServiceClient
{

    protected TProtocol iprot_;
    protected TProtocol oprot_;
    protected int seqid_;

    public TServiceClient(TProtocol tprotocol)
    {
        this(tprotocol, tprotocol);
    }

    public TServiceClient(TProtocol tprotocol, TProtocol tprotocol1)
    {
        iprot_ = tprotocol;
        oprot_ = tprotocol1;
    }

    public TProtocol getInputProtocol()
    {
        return iprot_;
    }

    public TProtocol getOutputProtocol()
    {
        return oprot_;
    }

    protected void receiveBase(TBase tbase, String s)
    {
        TMessage tmessage = iprot_.readMessageBegin();
        if (tmessage.type == 3)
        {
            tbase = TApplicationException.read(iprot_);
            iprot_.readMessageEnd();
            throw tbase;
        }
        if (tmessage.seqid != seqid_)
        {
            throw new TApplicationException(4, (new StringBuilder()).append(s).append(" failed: out of sequence response").toString());
        } else
        {
            tbase.read(iprot_);
            iprot_.readMessageEnd();
            return;
        }
    }

    protected void sendBase(String s, TBase tbase)
    {
        TProtocol tprotocol = oprot_;
        int i = seqid_ + 1;
        seqid_ = i;
        tprotocol.writeMessageBegin(new TMessage(s, (byte)1, i));
        tbase.write(oprot_);
        oprot_.writeMessageEnd();
        oprot_.getTransport().flush();
    }
}
