// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;

// Referenced classes of package org.apache.thrift:
//            TProcessor, TException

public class TMultiplexedProcessor
    implements TProcessor
{

    private final Map SERVICE_PROCESSOR_MAP = new HashMap();

    public TMultiplexedProcessor()
    {
    }

    public boolean process(TProtocol tprotocol, TProtocol tprotocol1)
    {
        TMessage tmessage = tprotocol.readMessageBegin();
        if (tmessage.type != 1 && tmessage.type != 4)
        {
            throw new TException("This should not have happened!?");
        }
        int i = tmessage.name.indexOf(":");
        if (i < 0)
        {
            throw new TException((new StringBuilder("Service name not found in message name: ")).append(tmessage.name).append(".  Did you forget to use a TMultiplexProtocol in your client?").toString());
        }
        String s = tmessage.name.substring(0, i);
        TProcessor tprocessor = (TProcessor)SERVICE_PROCESSOR_MAP.get(s);
        if (tprocessor == null)
        {
            throw new TException((new StringBuilder("Service name not found: ")).append(s).append(".  Did you forget to call registerProcessor()?").toString());
        } else
        {
            return tprocessor.process(new StoredMessageProtocol(tprotocol, new TMessage(tmessage.name.substring(s.length() + 1), tmessage.type, tmessage.seqid)), tprotocol1);
        }
    }

    public void registerProcessor(String s, TProcessor tprocessor)
    {
        SERVICE_PROCESSOR_MAP.put(s, tprocessor);
    }

    private class StoredMessageProtocol extends TProtocolDecorator
    {

        TMessage messageBegin;
        final TMultiplexedProcessor this$0;

        public TMessage readMessageBegin()
        {
            return messageBegin;
        }

        public StoredMessageProtocol(TProtocol tprotocol, TMessage tmessage)
        {
            this$0 = TMultiplexedProcessor.this;
            super(tprotocol);
            messageBegin = tmessage;
        }
    }

}
