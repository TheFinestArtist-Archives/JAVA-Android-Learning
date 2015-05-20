// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.async;

import java.nio.channels.Selector;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.async:
//            TAsyncMethodCall

public class TAsyncClientManager
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/async/TAsyncClientManager.getName());
    private final ConcurrentLinkedQueue pendingCalls = new ConcurrentLinkedQueue();
    private final SelectThread selectThread = new SelectThread();

    public TAsyncClientManager()
    {
        selectThread.start();
    }

    public void call(TAsyncMethodCall tasyncmethodcall)
    {
        if (!isRunning())
        {
            throw new TException("SelectThread is not running");
        } else
        {
            tasyncmethodcall.prepareMethodCall();
            pendingCalls.add(tasyncmethodcall);
            selectThread.getSelector().wakeup();
            return;
        }
    }

    public boolean isRunning()
    {
        return selectThread.isAlive();
    }

    public void stop()
    {
        selectThread.finish();
    }




    private class SelectThread extends Thread
    {
        private class TAsyncMethodCallTimeoutComparator
            implements Comparator
        {

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((TAsyncMethodCall)obj, (TAsyncMethodCall)obj1);
            }

            public int compare(TAsyncMethodCall tasyncmethodcall, TAsyncMethodCall tasyncmethodcall1)
            {
                if (tasyncmethodcall.getTimeoutTimestamp() == tasyncmethodcall1.getTimeoutTimestamp())
                {
                    return (int)(tasyncmethodcall.getSequenceId() - tasyncmethodcall1.getSequenceId());
                } else
                {
                    return (int)(tasyncmethodcall.getTimeoutTimestamp() - tasyncmethodcall1.getTimeoutTimestamp());
                }
            }

            private TAsyncMethodCallTimeoutComparator()
            {
            }

            TAsyncMethodCallTimeoutComparator(_cls1 _pcls1)
            {
                this();
            }
        }


        private volatile boolean running;
        private final Selector selector = SelectorProvider.provider().openSelector();
        final TAsyncClientManager this$0;
        private final TreeSet timeoutWatchSet = new TreeSet(new TAsyncMethodCallTimeoutComparator(null));

        private void startPendingMethods()
        {
            do
            {
                TAsyncMethodCall tasyncmethodcall = (TAsyncMethodCall)pendingCalls.poll();
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
                    TAsyncClientManager.LOGGER.warn("Caught exception in TAsyncClientManager!", exception);
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
                TAsyncClientManager.LOGGER.error("Caught ClosedSelectorException in TAsyncClientManager!", closedselectorexception);
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
                TAsyncClientManager.LOGGER.error("Caught IOException in TAsyncClientManager!", ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                TAsyncClientManager.LOGGER.error("Ignoring uncaught exception in SelectThread", ((Throwable) (obj)));
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

        public SelectThread()
        {
            this$0 = TAsyncClientManager.this;
            super();
            running = true;
            setName((new StringBuilder("TAsyncClientManager#SelectorThread ")).append(getId()).toString());
            setDaemon(true);
        }
    }

}
