// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook:
//            Response, RequestBatch

final class 
    implements Runnable
{

    final ArrayList val$callbacks;
    final RequestBatch val$requests;

    public final void run()
    {
        Pair pair;
        for (Iterator iterator = val$callbacks.iterator(); iterator.hasNext(); ((llback)pair.first).onCompleted((Response)pair.second))
        {
            pair = (Pair)iterator.next();
        }

        for (Iterator iterator1 = val$requests.getCallbacks().iterator(); iterator1.hasNext(); ((ch.Callback)iterator1.next()).onBatchCompleted(val$requests)) { }
    }

    ch()
    {
        val$callbacks = arraylist;
        val$requests = requestbatch;
        super();
    }
}
