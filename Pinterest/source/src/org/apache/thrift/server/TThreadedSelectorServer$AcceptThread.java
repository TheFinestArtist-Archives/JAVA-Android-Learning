// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.server:
//            TThreadedSelectorServer, TServerEventHandler

public class acceptSelector extends Thread
{

    private final Selector acceptSelector = SelectorProvider.provider().openSelector();
    private final TNonblockingServerTransport serverTransport;
    final TThreadedSelectorServer this$0;
    private final dLoadBalancer threadChooser;

    private TNonblockingTransport doAccept()
    {
        TNonblockingTransport tnonblockingtransport;
        try
        {
            tnonblockingtransport = (TNonblockingTransport)serverTransport.accept();
        }
        catch (TTransportException ttransportexception)
        {
            TThreadedSelectorServer.access$600().warn("Exception trying to accept!", ttransportexception);
            return null;
        }
        return tnonblockingtransport;
    }

    private void doAddAccept(d d, TNonblockingTransport tnonblockingtransport)
    {
        if (!d.addAcceptedConnection(tnonblockingtransport))
        {
            tnonblockingtransport.close();
        }
    }

    private void handleAccept()
    {
        final TNonblockingTransport client;
        final d targetThread;
label0:
        {
            client = doAccept();
            if (client != null)
            {
                targetThread = threadChooser.nextThread();
                if (_mth00(TThreadedSelectorServer.access$700(TThreadedSelectorServer.this)) != licy.FAST_ACCEPT && TThreadedSelectorServer.access$900(TThreadedSelectorServer.this) != null)
                {
                    break label0;
                }
                doAddAccept(targetThread, client);
            }
            return;
        }
        try
        {
            class _cls1
                implements Runnable
            {

                final TThreadedSelectorServer.AcceptThread this$1;
                final TNonblockingTransport val$client;
                final TThreadedSelectorServer.SelectorThread val$targetThread;

                public void run()
                {
                    doAddAccept(targetThread, client);
                }

            _cls1()
            {
                this$1 = TThreadedSelectorServer.AcceptThread.this;
                targetThread = selectorthread;
                client = tnonblockingtransport;
                super();
            }
            }

            TThreadedSelectorServer.access$900(TThreadedSelectorServer.this).submit(new _cls1());
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            TThreadedSelectorServer.access$600().warn("ExecutorService rejected accept registration!", rejectedexecutionexception);
        }
        client.close();
    }

    private void select()
    {
        acceptSelector.select();
_L2:
        SelectionKey selectionkey;
        for (Iterator iterator = acceptSelector.selectedKeys().iterator(); !TThreadedSelectorServer.access$500(TThreadedSelectorServer.this) && iterator.hasNext();)
        {
            selectionkey = (SelectionKey)iterator.next();
            iterator.remove();
            if (selectionkey.isValid())
            {
                if (!selectionkey.isAcceptable())
                {
                    break MISSING_BLOCK_LABEL_90;
                }
                handleAccept();
            }
        }

          goto _L1
        IOException ioexception;
        ioexception;
        TThreadedSelectorServer.access$600().warn("Got an IOException while selecting!", ioexception);
_L1:
        return;
        TThreadedSelectorServer.access$600().warn((new StringBuilder("Unexpected state in select! ")).append(selectionkey.interestOps()).toString());
          goto _L2
    }

    public void run()
    {
        if (eventHandler_ != null)
        {
            eventHandler_.preServe();
        }
        for (; !TThreadedSelectorServer.access$500(TThreadedSelectorServer.this); select()) { }
        break MISSING_BLOCK_LABEL_59;
        Object obj;
        obj;
        TThreadedSelectorServer.access$600().error("run() exiting due to uncaught error", ((Throwable) (obj)));
        stop();
        return;
        stop();
        return;
        obj;
        stop();
        throw obj;
    }

    public void wakeupSelector()
    {
        acceptSelector.wakeup();
    }


    public dLoadBalancer(TNonblockingServerTransport tnonblockingservertransport, dLoadBalancer dloadbalancer)
    {
        this$0 = TThreadedSelectorServer.this;
        super();
        serverTransport = tnonblockingservertransport;
        threadChooser = dloadbalancer;
        serverTransport.registerSelector(acceptSelector);
    }
}
