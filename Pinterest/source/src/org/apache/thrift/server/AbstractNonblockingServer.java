// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.server:
//            TServer

public abstract class AbstractNonblockingServer extends TServer
{

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
    final long MAX_READ_BUFFER_BYTES;
    final AtomicLong readBufferBytesAllocated = new AtomicLong(0L);

    public AbstractNonblockingServer(AbstractNonblockingServerArgs abstractnonblockingserverargs)
    {
        super(abstractnonblockingserverargs);
        MAX_READ_BUFFER_BYTES = abstractnonblockingserverargs.maxReadBufferBytes;
    }

    protected abstract boolean requestInvoke(FrameBuffer framebuffer);

    public void serve()
    {
        while (!startThreads() || !startListening()) 
        {
            return;
        }
        setServing(true);
        waitForShutdown();
        setServing(false);
        stopListening();
    }

    protected boolean startListening()
    {
        try
        {
            serverTransport_.listen();
        }
        catch (TTransportException ttransportexception)
        {
            LOGGER.error("Failed to start listening on server socket!", ttransportexception);
            return false;
        }
        return true;
    }

    protected abstract boolean startThreads();

    protected void stopListening()
    {
        serverTransport_.close();
    }

    protected abstract void waitForShutdown();

    private class AbstractNonblockingServerArgs extends TServer.AbstractServerArgs
    {

        public long maxReadBufferBytes;

        public AbstractNonblockingServerArgs(TNonblockingServerTransport tnonblockingservertransport)
        {
            super(tnonblockingservertransport);
            maxReadBufferBytes = 0x7fffffffffffffffL;
            transportFactory(new org.apache.thrift.transport.TFramedTransport.Factory());
        }
    }

}
