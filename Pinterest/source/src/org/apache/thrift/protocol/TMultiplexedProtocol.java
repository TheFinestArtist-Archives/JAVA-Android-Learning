// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


// Referenced classes of package org.apache.thrift.protocol:
//            TProtocolDecorator, TMessage, TProtocol

public class TMultiplexedProtocol extends TProtocolDecorator
{

    public static final String SEPARATOR = ":";
    private final String SERVICE_NAME;

    public TMultiplexedProtocol(TProtocol tprotocol, String s)
    {
        super(tprotocol);
        SERVICE_NAME = s;
    }

    public void writeMessageBegin(TMessage tmessage)
    {
        if (tmessage.type == 1 || tmessage.type == 4)
        {
            super.writeMessageBegin(new TMessage((new StringBuilder()).append(SERVICE_NAME).append(":").append(tmessage.name).toString(), tmessage.type, tmessage.seqid));
            return;
        } else
        {
            super.writeMessageBegin(tmessage);
            return;
        }
    }
}
