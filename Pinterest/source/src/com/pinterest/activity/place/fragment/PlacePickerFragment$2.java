// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.place.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.activity.place.fragment:
//            PlacePickerFragment

class this._cls0
    implements android.view.balLayoutListener
{

    final PlacePickerFragment this$0;

    public void onGlobalLayout()
    {
        View view = getView();
        if (view != null && getActivity() != null)
        {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            view.setMinimumWidth((int)(Device.getScreenWidth() * 0.9F));
            view.setMinimumHeight((int)(Device.getScreenHeight() * 0.9F));
        }
    }

    A()
    {
        this$0 = PlacePickerFragment.this;
        super();
    }
}
