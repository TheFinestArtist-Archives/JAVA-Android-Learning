// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells.old.details;

import com.pinterest.ui.imageview.WebImageView;

// Referenced classes of package com.pinterest.activity.pin.gridcells.old.details:
//            PinCloseupView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (PinCloseupView.access$300(_fld0) != null)
        {
            removeView(PinCloseupView.access$300(_fld0));
            PinCloseupView.access$300(_fld0).setBitmap(null, false);
            PinCloseupView.access$302(_fld0, null);
        }
    }

    I()
    {
        this$1 = this._cls1.this;
        super();
    }
}
