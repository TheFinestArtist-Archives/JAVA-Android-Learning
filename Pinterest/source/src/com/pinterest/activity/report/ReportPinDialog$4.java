// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.report;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.base.Application;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.report:
//            ReportPinDialog

class this._cls0 extends ApiResponseHandler
{

    final ReportPinDialog this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        if (apiresponse != null)
        {
            Application.showToast(apiresponse.getMessageDisplay());
            return;
        } else
        {
            Application.showToast(0x7f0e03f8);
            return;
        }
    }

    public void onStart()
    {
        Application.showToast(0x7f0e03f9);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        Pinalytics.a(EventType.PIN_FLAG, _pinId);
        Application.showToast(0x7f0e03fa);
    }

    ()
    {
        this$0 = ReportPinDialog.this;
        super();
    }
}
