// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.apache.thrift.server:
//            AbstractNonblockingServer

public abstract class this._cls0 extends Thread
{

    protected final Set selectInterestChanges = new HashSet();
    protected final Selector selector = SelectorProvider.provider().openSelector();
    final AbstractNonblockingServer this$0;

    protected void cleanupSelectionKey(SelectionKey selectionkey)
    {
        this._cls0 _lcls0 = (this._cls0)selectionkey.attachment();
        if (_lcls0 != null)
        {
            _lcls0._mth0();
        }
        selectionkey.cancel();
    }

    protected void handleRead(SelectionKey selectionkey)
    {
        this._cls0 _lcls0 = (this._cls0)selectionkey.attachment();
        if (!_lcls0._mth0())
        {
            cleanupSelectionKey(selectionkey);
        } else
        if (_lcls0.llyRead() && !requestInvoke(_lcls0))
        {
            cleanupSelectionKey(selectionkey);
            return;
        }
    }

    protected void handleWrite(SelectionKey selectionkey)
    {
        if (!((cleanupSelectionKey)selectionkey.attachment()).cleanupSelectionKey())
        {
            cleanupSelectionKey(selectionkey);
        }
    }

    protected void processInterestChanges()
    {
        Set set = selectInterestChanges;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = selectInterestChanges.iterator(); iterator.hasNext(); ((selectInterestChanges)iterator.next()).ectInterests()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        selectInterestChanges.clear();
        set;
        JVM INSTR monitorexit ;
    }

    public void requestSelectInterestChange(selectInterestChanges selectinterestchanges)
    {
        synchronized (selectInterestChanges)
        {
            selectInterestChanges.add(selectinterestchanges);
        }
        selector.wakeup();
        return;
        selectinterestchanges;
        set;
        JVM INSTR monitorexit ;
        throw selectinterestchanges;
    }

    public void wakeupSelector()
    {
        selector.wakeup();
    }

    public ()
    {
        this$0 = AbstractNonblockingServer.this;
        super();
    }
}
