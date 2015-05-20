// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TMemoryBuffer;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncClient, AsyncMethodCallback

public abstract class TAsyncMethodCall
{

    private static final int INITIAL_MEMORY_BUFFER_SIZE = 128;
    private static AtomicLong sequenceIdCounter = new AtomicLong(0L);
    private final AsyncMethodCallback callback;
    protected final TAsyncClient client;
    private ByteBuffer frameBuffer;
    private final boolean isOneway;
    private final TProtocolFactory protocolFactory;
    private long sequenceId;
    private ByteBuffer sizeBuffer;
    private final byte sizeBufferArray[] = new byte[4];
    private long startTime;
    private State state;
    protected final TNonblockingTransport transport;

    protected TAsyncMethodCall(TAsyncClient tasyncclient, TProtocolFactory tprotocolfactory, TNonblockingTransport tnonblockingtransport, AsyncMethodCallback asyncmethodcallback, boolean flag)
    {
        state = null;
        startTime = System.currentTimeMillis();
        transport = tnonblockingtransport;
        callback = asyncmethodcallback;
        protocolFactory = tprotocolfactory;
        client = tasyncclient;
        isOneway = flag;
        sequenceId = sequenceIdCounter.getAndIncrement();
    }

    private void cleanUpAndFireCallback(SelectionKey selectionkey)
    {
        state = State.RESPONSE_READ;
        selectionkey.interestOps(0);
        selectionkey.attach(null);
        client.onComplete();
        callback.onComplete(this);
    }

    private void doConnecting(SelectionKey selectionkey)
    {
        if (!selectionkey.isConnectable() || !transport.finishConnect())
        {
            throw new IOException("not connectable or finishConnect returned false after we got an OP_CONNECT");
        } else
        {
            registerForFirstWrite(selectionkey);
            return;
        }
    }

    private void doReadingResponseBody(SelectionKey selectionkey)
    {
        if (transport.read(frameBuffer) < 0)
        {
            throw new IOException("Read call frame failed");
        }
        if (frameBuffer.remaining() == 0)
        {
            cleanUpAndFireCallback(selectionkey);
        }
    }

    private void doReadingResponseSize()
    {
        if (transport.read(sizeBuffer) < 0)
        {
            throw new IOException("Read call frame size failed");
        }
        if (sizeBuffer.remaining() == 0)
        {
            state = State.READING_RESPONSE_BODY;
            frameBuffer = ByteBuffer.allocate(TFramedTransport.decodeFrameSize(sizeBufferArray));
        }
    }

    private void doWritingRequestBody(SelectionKey selectionkey)
    {
label0:
        {
            if (transport.write(frameBuffer) < 0)
            {
                throw new IOException("Write call frame failed");
            }
            if (frameBuffer.remaining() == 0)
            {
                if (!isOneway)
                {
                    break label0;
                }
                cleanUpAndFireCallback(selectionkey);
            }
            return;
        }
        state = State.READING_RESPONSE_SIZE;
        sizeBuffer.rewind();
        selectionkey.interestOps(1);
    }

    private void doWritingRequestSize()
    {
        if (transport.write(sizeBuffer) < 0)
        {
            throw new IOException("Write call frame size failed");
        }
        if (sizeBuffer.remaining() == 0)
        {
            state = State.WRITING_REQUEST_BODY;
        }
    }

    public TAsyncClient getClient()
    {
        return client;
    }

    protected ByteBuffer getFrameBuffer()
    {
        return frameBuffer;
    }

    protected long getSequenceId()
    {
        return sequenceId;
    }

    protected long getStartTime()
    {
        return startTime;
    }

    protected State getState()
    {
        return state;
    }

    public long getTimeoutTimestamp()
    {
        return client.getTimeout() + startTime;
    }

    public boolean hasTimeout()
    {
        return client.hasTimeout();
    }

    protected boolean isFinished()
    {
        return state == State.RESPONSE_READ;
    }

    protected void onError(Exception exception)
    {
        client.onError(exception);
        callback.onError(exception);
        state = State.ERROR;
    }

    protected void prepareMethodCall()
    {
        TMemoryBuffer tmemorybuffer = new TMemoryBuffer(128);
        write_args(protocolFactory.getProtocol(tmemorybuffer));
        int i = tmemorybuffer.length();
        frameBuffer = ByteBuffer.wrap(tmemorybuffer.getArray(), 0, i);
        TFramedTransport.encodeFrameSize(i, sizeBufferArray);
        sizeBuffer = ByteBuffer.wrap(sizeBufferArray);
    }

    void registerForFirstWrite(SelectionKey selectionkey)
    {
        state = State.WRITING_REQUEST_SIZE;
        selectionkey.interestOps(4);
    }

    void start(Selector selector)
    {
        if (!transport.isOpen()) goto _L2; else goto _L1
_L1:
        state = State.WRITING_REQUEST_SIZE;
        selector = transport.registerSelector(selector, 4);
_L4:
        selector.attach(this);
        return;
_L2:
        state = State.CONNECTING;
        SelectionKey selectionkey = transport.registerSelector(selector, 8);
        selector = selectionkey;
        if (transport.startConnect())
        {
            registerForFirstWrite(selectionkey);
            selector = selectionkey;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void transition(SelectionKey selectionkey)
    {
        if (!selectionkey.isValid())
        {
            selectionkey.cancel();
            onError(new TTransportException("Selection key not valid!"));
            return;
        }
        _cls1..SwitchMap.org.apache.thrift.async.TAsyncMethodCall.State[state.ordinal()];
        JVM INSTR tableswitch 1 5: default 151
    //                   1 123
    //                   2 129
    //                   3 134
    //                   4 140
    //                   5 145;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Exception exception;
        throw new IllegalStateException((new StringBuilder("Method call in state ")).append(state).append(" but selector called transition method. Seems like a bug...").toString());
_L2:
        try
        {
            doConnecting(selectionkey);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            selectionkey.cancel();
            selectionkey.attach(null);
            onError(exception);
            return;
        }
_L3:
        doWritingRequestSize();
        return;
_L4:
        doWritingRequestBody(selectionkey);
        return;
_L5:
        doReadingResponseSize();
        return;
_L6:
        doReadingResponseBody(selectionkey);
        return;
    }

    protected abstract void write_args(TProtocol tprotocol);


    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State CONNECTING;
        public static final State ERROR;
        public static final State READING_RESPONSE_BODY;
        public static final State READING_RESPONSE_SIZE;
        public static final State RESPONSE_READ;
        public static final State WRITING_REQUEST_BODY;
        public static final State WRITING_REQUEST_SIZE;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(org/apache/thrift/async/TAsyncMethodCall$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            CONNECTING = new State("CONNECTING", 0);
            WRITING_REQUEST_SIZE = new State("WRITING_REQUEST_SIZE", 1);
            WRITING_REQUEST_BODY = new State("WRITING_REQUEST_BODY", 2);
            READING_RESPONSE_SIZE = new State("READING_RESPONSE_SIZE", 3);
            READING_RESPONSE_BODY = new State("READING_RESPONSE_BODY", 4);
            RESPONSE_READ = new State("RESPONSE_READ", 5);
            ERROR = new State("ERROR", 6);
            $VALUES = (new State[] {
                CONNECTING, WRITING_REQUEST_SIZE, WRITING_REQUEST_BODY, READING_RESPONSE_SIZE, READING_RESPONSE_BODY, RESPONSE_READ, ERROR
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[];

        static 
        {
            $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State = new int[State.values().length];
            try
            {
                $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[State.CONNECTING.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[State.WRITING_REQUEST_SIZE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[State.WRITING_REQUEST_BODY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[State.READING_RESPONSE_SIZE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$org$apache$thrift$async$TAsyncMethodCall$State[State.READING_RESPONSE_BODY.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
