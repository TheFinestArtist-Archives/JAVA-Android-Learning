// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.activity.invitefriend.events.TabChangedEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.ui.tab.TabBar;
import com.pinterest.ui.text.PButton;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFragment

class this._cls0
    implements android.support.v4.view..OnPageChangeListener
{

    final InviteFragment this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        InviteFragment.access$000(InviteFragment.this).setPagerScroll(i, f);
    }

    public void onPageSelected(int i)
    {
        Events.post(new TabChangedEvent(InviteFragment.access$100(InviteFragment.this).getText()));
        InviteFragment.access$000(InviteFragment.this).setCurrentIndex(i);
        if (i == 1)
        {
            InviteFragment.access$200(InviteFragment.this).setVisibility(8);
        } else
        {
            InviteFragment.access$200(InviteFragment.this).setVisibility(0);
        }
        Pinalytics.a(InviteFragment.this);
    }

    Event()
    {
        this$0 = InviteFragment.this;
        super();
    }
}
