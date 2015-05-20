// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift:
//            TBase

public abstract class AsyncProcessFunction
{

    final String methodName;

    public AsyncProcessFunction(String s)
    {
        methodName = s;
    }

    public abstract Object getEmptyArgsInstance();

    public String getMethodName()
    {
        return methodName;
    }

    public abstract AsyncMethodCallback getResultHandler(org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer asyncframebuffer, int i);

    protected abstract boolean isOneway();

    public void sendResponse(org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer asyncframebuffer, TBase tbase, byte byte0, int i)
    {
        TProtocol tprotocol = asyncframebuffer.getOutputProtocol();
        tprotocol.writeMessageBegin(new TMessage(getMethodName(), byte0, i));
        tbase.write(tprotocol);
        tprotocol.writeMessageEnd();
        tprotocol.getTransport().flush();
        asyncframebuffer.responseReady();
    }

    public abstract void start(Object obj, Object obj1, AsyncMethodCallback asyncmethodcallback);
}
