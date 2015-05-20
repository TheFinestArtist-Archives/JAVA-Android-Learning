// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.analytics;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.base.Application;
import com.pinterest.base.ApplicationInfo;
import com.pinterest.kit.tasks.IntervalRunner;
import com.pinterest.schemas.event.EventBatch;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.analytics:
//            Pinalytics

class r extends BaseApiResponseHandler
{

    final k a;

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
        if (k(a) == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        list = a(a).getEvents();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        Pinalytics.g().getEvents().removeAll(list);
        getEvents(a).clear();
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
        if (r.onSuccess(a) == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        list = a(a).getEvents();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        Pinalytics.g().getEvents().removeAll(list);
        getEvents(a).clear();
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

    r(r r)
    {
        a = r;
        super();
    }
}
