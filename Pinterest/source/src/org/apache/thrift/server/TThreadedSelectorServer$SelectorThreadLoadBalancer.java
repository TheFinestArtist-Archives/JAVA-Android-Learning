// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package org.apache.thrift.server:
//            TThreadedSelectorServer

public class threads
{

    private Iterator nextThreadIterator;
    final TThreadedSelectorServer this$0;
    private final Collection threads;

    public threads nextThread()
    {
        if (!nextThreadIterator.hasNext())
        {
            nextThreadIterator = threads.iterator();
        }
        return (threads)nextThreadIterator.next();
    }

    public Q(Collection collection)
    {
        this$0 = TThreadedSelectorServer.this;
        super();
        if (collection.isEmpty())
        {
            throw new IllegalArgumentException("At least one selector thread is required");
        } else
        {
            threads = Collections.unmodifiableList(new ArrayList(collection));
            nextThreadIterator = threads.iterator();
            return;
        }
    }
}
