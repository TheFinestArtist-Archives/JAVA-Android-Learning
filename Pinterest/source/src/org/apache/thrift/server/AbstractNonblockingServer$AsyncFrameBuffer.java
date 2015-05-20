// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import org.apache.thrift.TBaseAsyncProcessor;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            AbstractNonblockingServer, TServerEventHandler

public class ead extends ead
{

    final AbstractNonblockingServer this$0;

    public TProtocol getInputProtocol()
    {
        return inProt_;
    }

    public TProtocol getOutputProtocol()
    {
        return outProt_;
    }

    public void invoke()
    {
        frameTrans_.reset(buffer_.array());
        response_.reset();
        try
        {
            if (eventHandler_ != null)
            {
                eventHandler_.processContext(context_, inTrans_, outTrans_);
            }
            ((TBaseAsyncProcessor)processorFactory_.getProcessor(inTrans_)).process(this);
            return;
        }
        catch (TException texception)
        {
            LOGGER.warn("Exception while invoking!", texception);
        }
        catch (Throwable throwable)
        {
            LOGGER.error("Unexpected throwable while invoking!", throwable);
        }
        state_ = AWAITING_CLOSE;
        requestSelectInterestChange();
    }

    public ead(TNonblockingTransport tnonblockingtransport, SelectionKey selectionkey, ead ead)
    {
        this$0 = AbstractNonblockingServer.this;
        super(AbstractNonblockingServer.this, tnonblockingtransport, selectionkey, ead);
    }
}
