// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TNonblockingServer, TServerEventHandler

public class selector extends ctThread
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
        obj = new ffer(TNonblockingServer.this, tnonblockingtransport, selectionkey1, this);
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
        obj = new <init>(TNonblockingServer.this, tnonblockingtransport, selectionkey1, this);
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
        if (TNonblockingServer.access$000(TNonblockingServer.this) || !iterator.hasNext()) goto _L2; else goto _L1
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
        return TNonblockingServer.access$000(TNonblockingServer.this);
    }

    public void run()
    {
        if (eventHandler_ != null)
        {
            eventHandler_.preServe();
        }
        for (; !TNonblockingServer.access$000(TNonblockingServer.this); processInterestChanges())
        {
            select();
        }

        break MISSING_BLOCK_LABEL_69;
        Object obj;
        obj;
        LOGGER.error("run() exiting due to uncaught error", ((Throwable) (obj)));
        TNonblockingServer.access$002(TNonblockingServer.this, true);
        return;
        for (Iterator iterator = selector.keys().iterator(); iterator.hasNext(); cleanupSelectionKey((SelectionKey)iterator.next())) { }
        break MISSING_BLOCK_LABEL_119;
        iterator;
        TNonblockingServer.access$002(TNonblockingServer.this, true);
        throw iterator;
        TNonblockingServer.access$002(TNonblockingServer.this, true);
        return;
    }

    public ffer(TNonblockingServerTransport tnonblockingservertransport)
    {
        this$0 = TNonblockingServer.this;
        super(TNonblockingServer.this);
        serverTransport = tnonblockingservertransport;
        tnonblockingservertransport.registerSelector(selector);
    }
}
