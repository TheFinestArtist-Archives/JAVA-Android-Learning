// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.transport.TNonblockingTransport;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TThreadedSelectorServer

public class acceptedQueue extends tThread
{

    private final BlockingQueue acceptedQueue;
    final TThreadedSelectorServer this$0;

    private void processAcceptedConnections()
    {
        do
        {
            if (TThreadedSelectorServer.access$500(TThreadedSelectorServer.this))
            {
                break;
            }
            TNonblockingTransport tnonblockingtransport = (TNonblockingTransport)acceptedQueue.poll();
            if (tnonblockingtransport == null)
            {
                break;
            }
            registerAccepted(tnonblockingtransport);
        } while (true);
    }

    private void registerAccepted(TNonblockingTransport tnonblockingtransport)
    {
        SelectionKey selectionkey = null;
        SelectionKey selectionkey1 = tnonblockingtransport.registerSelector(selector, 1);
        selectionkey = selectionkey1;
        if (!processorFactory_.isAsyncProcessor()) goto _L2; else goto _L1
_L1:
        selectionkey = selectionkey1;
        Object obj = new fer(TThreadedSelectorServer.this, tnonblockingtransport, selectionkey1, this);
_L3:
        selectionkey = selectionkey1;
        try
        {
            selectionkey1.attach(obj);
            return;
        }
        catch (IOException ioexception)
        {
            TThreadedSelectorServer.access$600().warn("Failed to register accepted connection to selector!", ioexception);
        }
        break MISSING_BLOCK_LABEL_93;
_L2:
        selectionkey = selectionkey1;
        obj = new init>(TThreadedSelectorServer.this, tnonblockingtransport, selectionkey1, this);
          goto _L3
        if (selectionkey != null)
        {
            cleanupSelectionKey(selectionkey);
        }
        tnonblockingtransport.close();
        return;
    }

    private void select()
    {
        Iterator iterator;
        selector.select();
        iterator = selector.selectedKeys().iterator();
_L5:
        if (TThreadedSelectorServer.access$500(TThreadedSelectorServer.this) || !iterator.hasNext()) goto _L2; else goto _L1
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
        TThreadedSelectorServer.access$600().warn("Got an IOException while selecting!", ioexception);
_L2:
        return;
_L4:
label0:
        {
            if (!selectionkey.isReadable())
            {
                break label0;
            }
            handleRead(selectionkey);
        }
          goto _L5
label1:
        {
            if (!selectionkey.isWritable())
            {
                break label1;
            }
            handleWrite(selectionkey);
        }
          goto _L5
        TThreadedSelectorServer.access$600().warn((new StringBuilder("Unexpected state in select! ")).append(selectionkey.interestOps()).toString());
          goto _L5
    }

    public boolean addAcceptedConnection(TNonblockingTransport tnonblockingtransport)
    {
        try
        {
            acceptedQueue.put(tnonblockingtransport);
        }
        // Misplaced declaration of an exception variable
        catch (TNonblockingTransport tnonblockingtransport)
        {
            TThreadedSelectorServer.access$600().warn("Interrupted while adding accepted connection!", tnonblockingtransport);
            return false;
        }
        selector.wakeup();
        return true;
    }

    public void run()
    {
        for (; !TThreadedSelectorServer.access$500(TThreadedSelectorServer.this); processInterestChanges())
        {
            select();
            processAcceptedConnections();
        }

        break MISSING_BLOCK_LABEL_45;
        Object obj;
        obj;
        TThreadedSelectorServer.access$600().error("run() exiting due to uncaught error", ((Throwable) (obj)));
        stop();
        return;
        for (Iterator iterator = selector.keys().iterator(); iterator.hasNext(); cleanupSelectionKey((SelectionKey)iterator.next())) { }
        break MISSING_BLOCK_LABEL_93;
        iterator;
        stop();
        throw iterator;
        stop();
        return;
    }

    public fer()
    {
        this(((BlockingQueue) (new LinkedBlockingQueue())));
    }

    public <init>(int i)
    {
        this(TThreadedSelectorServer.access$1100(i));
    }

    public <init>(BlockingQueue blockingqueue)
    {
        this$0 = TThreadedSelectorServer.this;
        super(TThreadedSelectorServer.this);
        acceptedQueue = blockingqueue;
    }
}
