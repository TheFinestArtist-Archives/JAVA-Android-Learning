// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.view.View;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupRichDataView

class this._cls0
    implements android.view.inCloseupRichDataView._cls2
{

    final PinCloseupRichDataView this$0;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.PHONE_BUTTON, null, _pin.getUid());
        ActivityHelper.goIntentView(getContext(), (new StringBuilder("tel:")).append(_pinPlace.getPhone()).toString());
    }

    ()
    {
        this$0 = PinCloseupRichDataView.this;
        super();
    }
}
