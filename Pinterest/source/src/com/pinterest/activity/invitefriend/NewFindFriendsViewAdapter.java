// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.pinterest.activity.task.fragment.BaseFragment;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsContactFragment

public class NewFindFriendsViewAdapter extends FixedFragmentStatePagerAdapter
{

    public static final int COUNT = 4;
    private BaseFragment _fragments[];

    public NewFindFriendsViewAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        _fragments = new BaseFragment[4];
        _fragments[0] = new NewFindFriendsContactFragment();
        for (int i = 1; i < _fragments.length; i++)
        {
            _fragments[i] = new BaseFragment();
        }

    }

    public int getCount()
    {
        return 4;
    }

    public Fragment getItem(int i)
    {
        return _fragments[i];
    }
}
