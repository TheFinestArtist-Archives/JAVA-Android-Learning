// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.api.ApiHttpClient;
import com.pinterest.api.model.Batch;
import com.pinterest.api.model.BatchRequest;
import com.pinterest.kit.tasks.IntervalRunner;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.analytics:
//            PerfIntervalCallback, PerfBatch, PerfEvent

class Callback extends com.pinterest.kit.tasks.Callback
{

    final PerfIntervalCallback a;

    private void a()
    {
        PerfBatch perfbatch = PerfIntervalCallback.a(a);
        perfbatch;
        JVM INSTR monitorenter ;
        PerfIntervalCallback.a(a, PerfIntervalCallback.a(a).a());
        if (PerfIntervalCallback.b(a) != null && PerfIntervalCallback.b(a).size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = new Batch();
        for (Iterator iterator = PerfIntervalCallback.b(a).iterator(); iterator.hasNext(); ((Batch) (obj)).add(((PerfEvent)iterator.next()).a().toRequest())) { }
        break MISSING_BLOCK_LABEL_113;
        obj;
        perfbatch;
        JVM INSTR monitorexit ;
        throw obj;
        ApiHttpClient.post(PerfIntervalCallback.c(a), ((Batch) (obj)).toRequestParam(), PerfIntervalCallback.d(a), false, null);
        IntervalRunner.instance().removeCallback(PerfIntervalCallback.e(a));
        PerfIntervalCallback.b(a).size();
          goto _L1
    }

    public void onInterval()
    {
        a();
    }

    public void onStop()
    {
        a();
    }

    Callback(PerfIntervalCallback perfintervalcallback)
    {
        a = perfintervalcallback;
        super();
    }
}
