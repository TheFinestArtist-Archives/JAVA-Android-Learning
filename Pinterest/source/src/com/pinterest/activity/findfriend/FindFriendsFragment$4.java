// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.widget.AbsListView;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendsFragment

class this._cls0
    implements android.widget.stener
{

    final FindFriendsFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 1 && FindFriendsFragment.access$000(FindFriendsFragment.this) != null)
        {
            Device.hideSoftKeyboard(FindFriendsFragment.access$000(FindFriendsFragment.this));
        }
    }

    ()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
