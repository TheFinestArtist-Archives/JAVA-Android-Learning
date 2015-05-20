// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Application;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.kit.tasks.BackgroundTask;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.pin.view:
//            PinCloseupAccessoryActionBar

class saved extends BackgroundTask
{

    private boolean saved;
    final PinCloseupAccessoryActionBar this$0;

    public void onFinish()
    {
        super.onFinish();
        Pinalytics.a(EventType.PIN_SAVE_TO_DEVICE, PinCloseupAccessoryActionBar.access$000(PinCloseupAccessoryActionBar.this).getUid());
        int i;
        int j;
        if (saved)
        {
            i = 0x7f0e0369;
        } else
        {
            i = 0x7f0e0368;
        }
        if (saved)
        {
            j = 0;
        } else
        {
            j = 0x7f0200fa;
        }
        Application.showToast(i, j);
    }

    public void run()
    {
        saved = ImageCache.saveImageToGallery(PinCloseupAccessoryActionBar.access$000(PinCloseupAccessoryActionBar.this).getImageLargeUrl());
    }

    ()
    {
        this$0 = PinCloseupAccessoryActionBar.this;
        super();
        saved = false;
    }
}
