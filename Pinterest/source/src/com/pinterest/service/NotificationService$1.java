// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import com.pinterest.api.remote.WidgetApi;
import com.pinterest.appwidget.MccMnc;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.service:
//            NotificationService

class this._cls0
    implements Runnable
{

    final NotificationService this$0;

    public void run()
    {
        MccMnc mccmnc = Device.getNetworkOperatorFromConfig();
        WidgetApi.b(mccmnc.mcc, mccmnc.mnc, onNotifLoad);
    }

    ()
    {
        this$0 = NotificationService.this;
        super();
    }
}
