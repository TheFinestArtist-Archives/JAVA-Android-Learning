// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncClientManager, TAsyncMethodCall, TAsyncClient

class setDaemon extends Thread
{

    private volatile boolean running;
    private final Selector selector = SelectorProvider.provider().openSelector();
    final TAsyncClientManager this$0;
    private final TreeSet timeoutWatchSet = new TreeSet(new allTimeoutComparator(null));

    private void startPendingMethods()
    {
        do
        {
            TAsyncMethodCall tasyncmethodcall = (TAsyncMethodCall)TAsyncClientManager.access$200(TAsyncClientManager.this).poll();
            if (tasyncmethodcall == null)
            {
                break;
            }
            try
            {
                tasyncmethodcall.start(selector);
                TAsyncClient tasyncclient = tasyncmethodcall.getClient();
                if (tasyncclient.hasTimeout() && !tasyncclient.hasError())
                {
                    timeoutWatchSet.add(tasyncmethodcall);
                }
            }
            catch (Exception exception)
            {
                TAsyncClientManager.access$100().warn("Caught exception in TAsyncClientManager!", exception);
                tasyncmethodcall.onError(exception);
            }
        } while (true);
    }

    private void timeoutMethods()
    {
        Iterator iterator = timeoutWatchSet.iterator();
        long l = System.currentTimeMillis();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TAsyncMethodCall tasyncmethodcall = (TAsyncMethodCall)iterator.next();
            if (l < tasyncmethodcall.getTimeoutTimestamp())
            {
                break;
            }
            iterator.remove();
            tasyncmethodcall.onError(new TimeoutException((new StringBuilder("Operation ")).append(tasyncmethodcall.getClass()).append(" timed out after ").append(l - tasyncmethodcall.getStartTime()).append(" ms.").toString()));
        } while (true);
    }

    private void transitionMethods()
    {
        try
        {
            Iterator iterator = selector.selectedKeys().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                SelectionKey selectionkey = (SelectionKey)iterator.next();
                iterator.remove();
                if (selectionkey.isValid())
                {
                    TAsyncMethodCall tasyncmethodcall = (TAsyncMethodCall)selectionkey.attachment();
                    tasyncmethodcall.transition(selectionkey);
                    if (tasyncmethodcall.isFinished() || tasyncmethodcall.getClient().hasError())
                    {
                        timeoutWatchSet.remove(tasyncmethodcall);
                    }
                }
            } while (true);
        }
        catch (ClosedSelectorException closedselectorexception)
        {
            TAsyncClientManager.access$100().error("Caught ClosedSelectorException in TAsyncClientManager!", closedselectorexception);
        }
    }

    public void finish()
    {
        running = false;
        selector.wakeup();
    }

    public Selector getSelector()
    {
        return selector;
    }

    public void run()
    {
_L7:
        if (!running) goto _L2; else goto _L1
_L1:
        if (timeoutWatchSet.size() != 0) goto _L4; else goto _L3
_L3:
        selector.select();
_L5:
        Object obj;
        transitionMethods();
        timeoutMethods();
        startPendingMethods();
        continue; /* Loop/switch isn't completed */
_L4:
        long l = ((TAsyncMethodCall)timeoutWatchSet.first()).getTimeoutTimestamp() - System.currentTimeMillis();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        selector.select(l);
        continue; /* Loop/switch isn't completed */
        obj;
        try
        {
            TAsyncClientManager.access$100().error("Caught IOException in TAsyncClientManager!", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            TAsyncClientManager.access$100().error("Ignoring uncaught exception in SelectThread", ((Throwable) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
        selector.selectNow();
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public allTimeoutComparator()
    {
        this$0 = TAsyncClientManager.this;
        super();
        running = true;
        setName((new StringBuilder("TAsyncClientManager#SelectorThread ")).append(getId()).toString());
        setDaemon(true);
    }
}
