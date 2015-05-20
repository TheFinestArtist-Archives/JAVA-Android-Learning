// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.os.Bundle;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.view.ModifiedViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.activity.invitefriend.NewFindFriendsViewAdapter;
import com.pinterest.activity.task.fragment.ViewPagerFragment;
import com.pinterest.base.Application;
import com.pinterest.base.Device;
import com.pinterest.experiment.Experiments;
import com.pinterest.ui.tab.TabBar;

public class NewFindFriendsFragment extends ViewPagerFragment
{

    TabBar _tabBar;
    private android.support.v4.view.ModifiedViewPager.OnPageChangeListener onPageChanged;
    private com.pinterest.ui.tab.TabBar.Listener onTabChanged;

    public NewFindFriendsFragment()
    {
        onPageChanged = new _cls1();
        onTabChanged = new _cls2();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030091;
        _menuId = 0x7f100005;
        setHasOptionsMenu(Device.hasHardwareMenuKey(Application.context()));
        _viewAdapter = new NewFindFriendsViewAdapter(getChildFragmentManager());
        _offScreenLimit = _viewAdapter.getCount();
        Experiments.a("android_new_find_friends");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _viewPager.setCurrentItem(0);
        _viewPager.setOnPageChangeListener(onPageChanged);
        _tabBar.setCurrentIndex(0);
        _tabBar.setListener(onTabChanged);
        _actionBar.setTitle(0x7f0e0222);
    }


    private class _cls1
        implements android.support.v4.view.ModifiedViewPager.OnPageChangeListener
    {

        final NewFindFriendsFragment this$0;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            _tabBar.setPagerScroll(i, f);
        }

        public void onPageSelected(int i)
        {
            _tabBar.setCurrentIndex(i);
            Pinalytics.a(NewFindFriendsFragment.this);
        }

        _cls1()
        {
            this$0 = NewFindFriendsFragment.this;
            super();
        }
    }


    private class _cls2
        implements com.pinterest.ui.tab.TabBar.Listener
    {

        final NewFindFriendsFragment this$0;

        public void onTabReselected(int i)
        {
            scrollActiveFragmentToTop();
            BaseFragment basefragment = getActiveFragment();
            if (basefragment != null)
            {
                basefragment.refresh();
            }
        }

        public void onTabSelected(int i)
        {
            
// JavaClassFileOutputException: get_constant: invalid tag

        _cls2()
        {
            this$0 = NewFindFriendsFragment.this;
            super();
        }
    }

}
