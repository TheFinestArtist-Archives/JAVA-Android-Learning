// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.adapter;

import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.pinterest.activity.pin.fragment.PinFragment;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Feed;

public class PinSwipeAdapter extends FixedFragmentStatePagerAdapter
{

    private Feed _dataSource;

    public PinSwipeAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
    }

    public int getCount()
    {
        if (_dataSource == null)
        {
            return 0;
        } else
        {
            return _dataSource.getCount();
        }
    }

    public Fragment getItem(int i)
    {
        if (_dataSource != null && i < _dataSource.getCount())
        {
            PinFragment pinfragment = new PinFragment();
            pinfragment.setNavigation(new Navigation(Location.PIN, _dataSource.get(i)));
            return pinfragment;
        } else
        {
            return null;
        }
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public void setDataSource(Feed feed)
    {
        _dataSource = feed;
        notifyDataSetChanged();
    }
}
