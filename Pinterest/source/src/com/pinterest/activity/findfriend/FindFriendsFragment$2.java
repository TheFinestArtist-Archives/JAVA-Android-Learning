// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import com.pinterest.base.Device;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendsFragment

class this._cls0
    implements Runnable
{

    final FindFriendsFragment this$0;

    public void run()
    {
        FindFriendsFragment.access$000(FindFriendsFragment.this).requestFocusFromTouch();
        Device.showSoftKeyboard(FindFriendsFragment.access$000(FindFriendsFragment.this));
    }

    ()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
