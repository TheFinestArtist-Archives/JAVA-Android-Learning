// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.kit.tasks.IntervalRunner;
import com.pinterest.schemas.event.EventBatch;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package com.pinterest.analytics:
//            Pinalytics

final class r.IntervalCallback extends com.pinterest.kit.tasks.r.IntervalCallback
{

    private EventBatch a;
    private final BaseApiResponseHandler b = new _cls1();

    static EventBatch a(lback lback)
    {
        return lback.a;
    }

    private void a()
    {
        EventBatch eventbatch = Pinalytics.g();
        eventbatch;
        JVM INSTR monitorenter ;
        if (Pinalytics.g().events != null && Pinalytics.g().events.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        TByteArrayOutputStream tbytearrayoutputstream;
        TBinaryProtocol tbinaryprotocol;
        a = Pinalytics.g().deepCopy();
        tbytearrayoutputstream = new TByteArrayOutputStream();
        tbinaryprotocol = new TBinaryProtocol(new TIOStreamTransport(tbytearrayoutputstream));
        a.setReportTime(System.currentTimeMillis() * 0xf4240L);
        a.write(tbinaryprotocol);
        byte abyte0[] = tbytearrayoutputstream.toByteArray();
        AnalyticsApi.a(abyte0, b);
        IntervalRunner.instance().removeCallback(Pinalytics.h());
        int i = abyte0.length / 1000;
          goto _L1
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L1
        obj;
        eventbatch;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final void onInterval()
    {
        a();
    }

    public final void onStop()
    {
        a();
    }

    ler()
    {
        class _cls1 extends BaseApiResponseHandler
        {

            final Pinalytics._cls1 a;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                if (apiresponse.getCode() != 15) goto _L2; else goto _L1
_L1:
                String.valueOf(apiresponse);
                if (Pinalytics.g() == null) goto _L4; else goto _L3
_L3:
                throwable = Pinalytics.g();
                throwable;
                JVM INSTR monitorenter ;
                List list;
                if (Pinalytics._cls1.a(a) == null)
                {
                    break MISSING_BLOCK_LABEL_74;
                }
                list = Pinalytics._cls1.a(a).getEvents();
                if (list == null)
                {
                    break MISSING_BLOCK_LABEL_64;
                }
                Pinalytics.g().getEvents().removeAll(list);
                Pinalytics._cls1.a(a).clear();
                throwable;
                JVM INSTR monitorexit ;
_L4:
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
                        throwable = (new StringBuilder()).append("ContextAPI: ").append(String.valueOf(throwable)).toString();
                    } else
                    {
                        throwable = (new StringBuilder()).append("ContextAPI: ").append("Failure! See logs for details.").toString();
                    }
                    Application.showDebugErrorToast(throwable);
                }
_L6:
                IntervalRunner.instance().addCallback(Pinalytics.h());
                return;
                apiresponse;
                throwable;
                JVM INSTR monitorexit ;
                throw apiresponse;
_L2:
                apiresponse.getMessageDisplay();
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                super.onSuccess(apiresponse);
                if (Pinalytics.g() == null) goto _L2; else goto _L1
_L1:
                apiresponse = Pinalytics.g();
                apiresponse;
                JVM INSTR monitorenter ;
                List list;
                if (Pinalytics._cls1.a(a) == null)
                {
                    break MISSING_BLOCK_LABEL_65;
                }
                list = Pinalytics._cls1.a(a).getEvents();
                if (list == null)
                {
                    break MISSING_BLOCK_LABEL_55;
                }
                Pinalytics.g().getEvents().removeAll(list);
                Pinalytics._cls1.a(a).clear();
                apiresponse;
                JVM INSTR monitorexit ;
_L2:
                IntervalRunner.instance().addCallback(Pinalytics.h());
                return;
                Exception exception;
                exception;
                apiresponse;
                JVM INSTR monitorexit ;
                throw exception;
            }

            _cls1()
            {
                a = Pinalytics._cls1.this;
                super();
            }
        }

    }
}
