// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import com.pinterest.activity.pin.adapter.IconTextListAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.SocialUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.pin.view:
//            PinCloseupAccessoryActionBar

class val.adapter
    implements android.widget.
{

    final PinCloseupAccessoryActionBar this$0;
    final IconTextListAdapter val$adapter;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i >= 0 && i < val$adapter.getCount())
        {
            if (i != val$adapter.getCount() - 1)
            {
                adapterview = (com.pinterest.activity.pin.adapter..adapter)val$adapter.getItem(i);
                Pinalytics.a(ElementType.SHARE_SOCIAL_BUTTON, ComponentType.NAVIGATION, ((com.pinterest.activity.pin.adapter..adapter) (adapterview)).ta);
                SocialUtils.startShare(getContext(), PinCloseupAccessoryActionBar.access$000(PinCloseupAccessoryActionBar.this), ((com.pinterest.activity.pin.adapter.s._cls0) (adapterview)).xt, ((com.pinterest.activity.pin.adapter.xt) (adapterview)).ta);
            } else
            {
                PinCloseupAccessoryActionBar.access$100(PinCloseupAccessoryActionBar.this);
            }
        }
        if (PinCloseupAccessoryActionBar.access$200(PinCloseupAccessoryActionBar.this) != null)
        {
            PinCloseupAccessoryActionBar.access$200(PinCloseupAccessoryActionBar.this).dismiss();
        }
    }

    ()
    {
        this$0 = final_pincloseupaccessoryactionbar;
        val$adapter = IconTextListAdapter.this;
        super();
    }
}
