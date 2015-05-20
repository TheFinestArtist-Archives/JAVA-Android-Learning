// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendFragment

public class InviteViewAdapter extends FixedFragmentStatePagerAdapter
{

    public static final int COUNT = 2;
    private InviteFriendFragment _friendList;

    public InviteViewAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public int getCount()
    {
        return 2;
    }

    public Fragment getItem(int i)
    {
        _friendList = new InviteFriendFragment();
        _friendList.setTabPosition(i);
        return _friendList;
    }
}
