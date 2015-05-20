// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            AbstractNonblockingServer

public class TNonblockingServer extends AbstractNonblockingServer
{

    private SelectAcceptThread selectAcceptThread_;
    private volatile boolean stopped_;

    public TNonblockingServer(AbstractNonblockingServer.AbstractNonblockingServerArgs abstractnonblockingserverargs)
    {
        super(abstractnonblockingserverargs);
        stopped_ = false;
    }

    public boolean isStopped()
    {
        return selectAcceptThread_.isStopped();
    }

    protected void joinSelector()
    {
        try
        {
            selectAcceptThread_.join();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    protected boolean requestInvoke(AbstractNonblockingServer.FrameBuffer framebuffer)
    {
        framebuffer.invoke();
        return true;
    }

    protected boolean startThreads()
    {
        try
        {
            selectAcceptThread_ = new SelectAcceptThread((TNonblockingServerTransport)serverTransport_);
            selectAcceptThread_.start();
        }
        catch (IOException ioexception)
        {
            LOGGER.error("Failed to start selector thread!", ioexception);
            return false;
        }
        return true;
    }

    public void stop()
    {
        stopped_ = true;
        if (selectAcceptThread_ != null)
        {
            selectAcceptThread_.wakeupSelector();
        }
    }

    protected void waitForShutdown()
    {
        joinSelector();
    }



/*
    static boolean access$002(TNonblockingServer tnonblockingserver, boolean flag)
    {
        tnonblockingserver.stopped_ = flag;
        return flag;
    }

*/

    private class SelectAcceptThread extends AbstractNonblockingServer.AbstractSelectThread
    {

        private final TNonblockingServerTransport serverTransport;
        final TNonblockingServer this$0;

        private void handleAccept()
        {
            SelectionKey selectionkey;
            Object obj;
            selectionkey = null;
            obj = null;
            TNonblockingTransport tnonblockingtransport = (TNonblockingTransport)serverTransport.accept();
            selectionkey = ((SelectionKey) (obj));
            SelectionKey selectionkey1 = tnonblockingtransport.registerSelector(selector, 1);
            selectionkey = selectionkey1;
            if (!processorFactory_.isAsyncProcessor()) goto _L2; else goto _L1
_L1:
            selectionkey = selectionkey1;
            obj = new AbstractNonblockingServer.AsyncFrameBuffer(TNonblockingServer.this, tnonblockingtransport, selectionkey1, this);
_L4:
            TTransportException ttransportexception;
            selectionkey = selectionkey1;
            try
            {
                selectionkey1.attach(obj);
                return;
            }
            catch (TTransportException ttransportexception1)
            {
                obj = tnonblockingtransport;
                ttransportexception = ttransportexception1;
            }
            break MISSING_BLOCK_LABEL_103;
_L2:
            selectionkey = selectionkey1;
            obj = new AbstractNonblockingServer.FrameBuffer(TNonblockingServer.this, tnonblockingtransport, selectionkey1, this);
            if (true) goto _L4; else goto _L3
_L3:
_L5:
            LOGGER.warn("Exception trying to accept!", ttransportexception);
            ttransportexception.printStackTrace();
            if (selectionkey != null)
            {
                cleanupSelectionKey(selectionkey);
            }
            if (obj != null)
            {
                ((TNonblockingTransport) (obj)).close();
                return;
            } else
            {
                return;
            }
            ttransportexception;
            obj = null;
              goto _L5
        }

        private void select()
        {
            Iterator iterator;
            selector.select();
            iterator = selector.selectedKeys().iterator();
_L5:
            if (stopped_ || !iterator.hasNext()) goto _L2; else goto _L1
_L1:
            SelectionKey selectionkey;
            selectionkey = (SelectionKey)iterator.next();
            iterator.remove();
            if (selectionkey.isValid()) goto _L4; else goto _L3
_L3:
            cleanupSelectionKey(selectionkey);
              goto _L5
            IOException ioexception;
            ioexception;
            LOGGER.warn("Got an IOException while selecting!", ioexception);
_L2:
            return;
_L4:
label0:
            {
                if (!selectionkey.isAcceptable())
                {
                    break label0;
                }
                handleAccept();
            }
              goto _L5
label1:
            {
                if (!selectionkey.isReadable())
                {
                    break label1;
                }
                handleRead(selectionkey);
            }
              goto _L5
label2:
            {
                if (!selectionkey.isWritable())
                {
                    break label2;
                }
                handleWrite(selectionkey);
            }
              goto _L5
            LOGGER.warn((new StringBuilder("Unexpected state in select! ")).append(selectionkey.interestOps()).toString());
              goto _L5
        }

        public boolean isStopped()
        {
            return stopped_;
        }

        public void run()
        {
            if (eventHandler_ != null)
            {
                eventHandler_.preServe();
            }
            while (!stopped_) 
            {
                select();
                processInterestChanges();
            }
            break MISSING_BLOCK_LABEL_69;
            Object obj;
            obj;
            LOGGER.error("run() exiting due to uncaught error", ((Throwable) (obj)));
            stopped_ = true;
            return;
            for (Iterator iterator = selector.keys().iterator(); iterator.hasNext(); cleanupSelectionKey((SelectionKey)iterator.next())) { }
            break MISSING_BLOCK_LABEL_119;
            iterator;
            stopped_ = true;
            throw iterator;
            stopped_ = true;
            return;
        }

        public SelectAcceptThread(TNonblockingServerTransport tnonblockingservertransport)
        {
            this$0 = TNonblockingServer.this;
            super(TNonblockingServer.this);
            serverTransport = tnonblockingservertransport;
            tnonblockingservertransport.registerSelector(selector);
        }
    }

}
