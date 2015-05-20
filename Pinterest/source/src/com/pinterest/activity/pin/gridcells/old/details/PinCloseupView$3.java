// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import android.graphics.Bitmap;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseupView

class this._cls0 extends com.pinterest.ui.imageview.eListener
{

    final PinCloseupView this$0;

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.m m)
    {
        Events.post(new ageLoadEvent(PinCloseupView.access$100(PinCloseupView.this)));
    }

    ageLoadEvent()
    {
        this$0 = PinCloseupView.this;
        super();
    }
}
