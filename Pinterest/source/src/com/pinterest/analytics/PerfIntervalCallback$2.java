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
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.analytics:
//            PerfIntervalCallback

class  extends BaseApiResponseHandler
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

    (PerfIntervalCallback perfintervalcallback)
    {
        a = perfintervalcallback;
        super();
    }
}
