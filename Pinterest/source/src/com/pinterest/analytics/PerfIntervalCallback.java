// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.kit.tasks.IntervalRunner;
import java.util.List;

// Referenced classes of package com.pinterest.analytics:
//            PerfBatch

public class PerfIntervalCallback
{

    private String a;
    private String b;
    private PerfBatch c;
    private List d;
    private final com.pinterest.kit.tasks.IntervalRunner.IntervalCallback e = new _cls1();
    private final BaseApiResponseHandler f = new _cls2();

    public PerfIntervalCallback(String s, String s1, PerfBatch perfbatch)
    {
        a = s1;
        b = s;
        c = perfbatch;
    }

    static PerfBatch a(PerfIntervalCallback perfintervalcallback)
    {
        return perfintervalcallback.c;
    }

    static List a(PerfIntervalCallback perfintervalcallback, List list)
    {
        perfintervalcallback.d = list;
        return list;
    }

    static List b(PerfIntervalCallback perfintervalcallback)
    {
        return perfintervalcallback.d;
    }

    static String c(PerfIntervalCallback perfintervalcallback)
    {
        return perfintervalcallback.a;
    }

    static BaseApiResponseHandler d(PerfIntervalCallback perfintervalcallback)
    {
        return perfintervalcallback.f;
    }

    static com.pinterest.kit.tasks.IntervalRunner.IntervalCallback e(PerfIntervalCallback perfintervalcallback)
    {
        return perfintervalcallback.e;
    }

    static void f(PerfIntervalCallback perfintervalcallback)
    {
        if (perfintervalcallback.c != null)
        {
            synchronized (perfintervalcallback.c)
            {
                if (perfintervalcallback.d != null)
                {
                    perfintervalcallback.c.a(perfintervalcallback.d);
                    perfintervalcallback.d.clear();
                }
            }
            return;
        } else
        {
            return;
        }
        perfintervalcallback;
        perfbatch;
        JVM INSTR monitorexit ;
        throw perfintervalcallback;
    }

    public final void a()
    {
        IntervalRunner.instance().addCallback(e);
    }

    private class _cls1 extends com.pinterest.kit.tasks.IntervalRunner.IntervalCallback
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

        _cls1()
        {
            a = PerfIntervalCallback.this;
            super();
        }
    }


    private class _cls2 extends BaseApiResponseHandler
    {

        final PerfIntervalCallback a;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            if (apiresponse.getCode() == 15)
            {
                String.valueOf(apiresponse);
                PerfIntervalCallback.f(a);
                if (ApplicationInfo.isNonProduction())
                {
                    PinterestJsonObject pinterestjsonobject = apiresponse.getDeveloperError();
                    if (pinterestjsonobject != null)
                    {
                        apiresponse = pinterestjsonobject.a("message", "");
                        throwable = apiresponse;
                        if (StringUtils.isBlank(apiresponse))
                        {
                            throwable = String.valueOf(pinterestjsonobject);
                        }
                        throwable = (new StringBuilder()).append("BatchPerformanceAPI: ").append(String.valueOf(throwable)).toString();
                    } else
                    {
                        throwable = (new StringBuilder()).append("BatchPerformanceAPI: ").append("Failure! See logs for details.").toString();
                    }
                    Application.showDebugErrorToast(throwable);
                }
            } else
            {
                apiresponse.getMessageDisplay();
            }
            IntervalRunner.instance().addCallback(PerfIntervalCallback.e(a));
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            PerfIntervalCallback.f(a);
            IntervalRunner.instance().addCallback(PerfIntervalCallback.e(a));
        }

        _cls2()
        {
            a = PerfIntervalCallback.this;
            super();
        }
    }

}
