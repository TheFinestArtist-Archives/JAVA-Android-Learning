// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            AbstractNonblockingServer, TServerEventHandler, ServerContext

public class context_
{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
    protected ByteBuffer buffer_;
    protected final ServerContext context_;
    protected final TMemoryInputTransport frameTrans_ = new TMemoryInputTransport();
    protected final TProtocol inProt_;
    protected final TTransport inTrans_;
    protected final TProtocol outProt_;
    protected final TTransport outTrans_;
    protected final TByteArrayOutputStream response_ = new TByteArrayOutputStream();
    protected final ctThread selectThread_;
    protected final SelectionKey selectionKey_;
    protected tate state_;
    final AbstractNonblockingServer this$0;
    protected final TNonblockingTransport trans_;

    private boolean internalRead()
    {
        int i;
        try
        {
            i = trans_.read(buffer_);
        }
        catch (IOException ioexception)
        {
            LOGGER.warn("Got an IOException in internalRead!", ioexception);
            return false;
        }
        return i >= 0;
    }

    private void prepareRead()
    {
        selectionKey_.interestOps(1);
        buffer_ = ByteBuffer.allocate(4);
        state_ = tate.READING_FRAME_SIZE;
    }

    public void changeSelectInterests()
    {
        if (state_ == tate.AWAITING_REGISTER_WRITE)
        {
            selectionKey_.interestOps(4);
            state_ = tate.WRITING;
            return;
        }
        if (state_ == tate.AWAITING_REGISTER_READ)
        {
            prepareRead();
            return;
        }
        if (state_ == tate.AWAITING_CLOSE)
        {
            close();
            selectionKey_.cancel();
            return;
        } else
        {
            LOGGER.error((new StringBuilder("changeSelectInterest was called, but state is invalid (")).append(state_).append(")").toString());
            return;
        }
    }

    public void close()
    {
        if (state_ == tate.READING_FRAME || state_ == tate.READ_FRAME_COMPLETE)
        {
            readBufferBytesAllocated.addAndGet(-buffer_.array().length);
        }
        trans_.close();
        if (eventHandler_ != null)
        {
            eventHandler_.deleteContext(context_, inProt_, outProt_);
        }
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
            processorFactory_.getProcessor(inTrans_).process(inProt_, outProt_);
            responseReady();
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
        state_ = tate.AWAITING_CLOSE;
        requestSelectInterestChange();
    }

    public boolean isFrameFullyRead()
    {
        return state_ == tate.READ_FRAME_COMPLETE;
    }

    public boolean read()
    {
        if (state_ != tate.READING_FRAME_SIZE) goto _L2; else goto _L1
_L1:
        if (internalRead()) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        if (buffer_.remaining() != 0) goto _L6; else goto _L5
_L5:
        int i = buffer_.getInt(0);
        if (i <= 0)
        {
            LOGGER.error((new StringBuilder("Read an invalid frame size of ")).append(i).append(". Are you using TFramedTransport on the client side?").toString());
            return false;
        }
        if ((long)i > MAX_READ_BUFFER_BYTES)
        {
            LOGGER.error((new StringBuilder("Read a frame size of ")).append(i).append(", which is bigger than the maximum allowable buffer size for ALL connections.").toString());
            return false;
        }
        if (readBufferBytesAllocated.get() + (long)i > MAX_READ_BUFFER_BYTES)
        {
            return true;
        }
        readBufferBytesAllocated.addAndGet(i + 4);
        buffer_ = ByteBuffer.allocate(i + 4);
        buffer_.putInt(i);
        state_ = tate.READING_FRAME;
_L2:
        if (state_ == tate.READING_FRAME)
        {
            if (internalRead())
            {
                if (buffer_.remaining() == 0)
                {
                    selectionKey_.interestOps(0);
                    state_ = tate.READ_FRAME_COMPLETE;
                }
                return true;
            }
        } else
        {
            LOGGER.error((new StringBuilder("Read was called but state is invalid (")).append(state_).append(")").toString());
            return false;
        }
        if (true) goto _L3; else goto _L6
_L6:
        return true;
    }

    protected void requestSelectInterestChange()
    {
        if (Thread.currentThread() == selectThread_)
        {
            changeSelectInterests();
            return;
        } else
        {
            selectThread_.requestSelectInterestChange(this);
            return;
        }
    }

    public void responseReady()
    {
        readBufferBytesAllocated.addAndGet(-buffer_.array().length);
        if (response_.len() == 0)
        {
            state_ = tate.AWAITING_REGISTER_READ;
            buffer_ = null;
        } else
        {
            buffer_ = ByteBuffer.wrap(response_.get(), 0, response_.len());
            state_ = tate.AWAITING_REGISTER_WRITE;
        }
        requestSelectInterestChange();
    }

    public boolean write()
    {
        if (state_ == tate.WRITING)
        {
            int i;
            try
            {
                i = trans_.write(buffer_);
            }
            catch (IOException ioexception)
            {
                LOGGER.warn("Got an IOException during write!", ioexception);
                return false;
            }
            if (i < 0)
            {
                return false;
            }
            if (buffer_.remaining() == 0)
            {
                prepareRead();
            }
            return true;
        } else
        {
            LOGGER.error((new StringBuilder("Write was called, but state is invalid (")).append(state_).append(")").toString());
            return false;
        }
    }

    public ctThread(TNonblockingTransport tnonblockingtransport, SelectionKey selectionkey, ctThread ctthread)
    {
        this$0 = AbstractNonblockingServer.this;
        super();
        state_ = tate.READING_FRAME_SIZE;
        trans_ = tnonblockingtransport;
        selectionKey_ = selectionkey;
        selectThread_ = ctthread;
        buffer_ = ByteBuffer.allocate(4);
        inTrans_ = inputTransportFactory_.getTransport(frameTrans_);
        outTrans_ = outputTransportFactory_.getTransport(new TIOStreamTransport(response_));
        inProt_ = inputProtocolFactory_.getProtocol(inTrans_);
        outProt_ = outputProtocolFactory_.getProtocol(outTrans_);
        if (eventHandler_ != null)
        {
            context_ = eventHandler_.createContext(inProt_, outProt_);
            return;
        } else
        {
            context_ = null;
            return;
        }
    }
}
