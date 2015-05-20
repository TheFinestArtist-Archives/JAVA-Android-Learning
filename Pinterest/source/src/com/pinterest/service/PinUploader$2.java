// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.service;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Application;
import com.pinterest.kit.notification.NotificationHelper;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.service:
//            PinUploader

class piResponse extends com.pinterest.api.remote.esponse
{

    final PinUploader this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        throwable = ((Throwable) (apiresponse.getData()));
        if ((throwable instanceof PinterestJsonObject) && ((PinterestJsonObject)throwable).a("param_name", "").equalsIgnoreCase("sdk_client_id"))
        {
            PinUploader.access$902(PinUploader.this, 10);
            Application.showToast(0x7f0e040f);
            NotificationHelper.cancelNotifPinUpload();
            PinUploader.access$600(PinUploader.this);
            return;
        }
        if (PinUploader.access$900(PinUploader.this) > 3)
        {
            PinUploader.access$500(PinUploader.this, 0x7f0e0316);
            PinUploader.access$600(PinUploader.this);
            return;
        } else
        {
            PinUploader.access$1100(PinUploader.this);
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        int _tmp = PinUploader.access$908(PinUploader.this);
        PinUploader.access$500(PinUploader.this, 0x7f0e0319);
    }

    public void onSuccess(Pin pin)
    {
        super.onSuccess(pin);
        Pinalytics.a(EventType.PIN_CREATE, pin.getUid());
        if (pin != null && pin.getBoard() != null)
        {
            (new owNotifTask(PinUploader.this, null)).execute(new Pin[] {
                pin
            });
        }
    }

    owNotifTask()
    {
        this$0 = PinUploader.this;
        super();
    }
}
