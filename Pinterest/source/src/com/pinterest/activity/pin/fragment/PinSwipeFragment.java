// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import android.os.Bundle;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.view.ModifiedViewPager;
import android.view.View;
import com.pinterest.activity.pin.adapter.PinSwipeAdapter;
import com.pinterest.activity.task.fragment.ViewPagerFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.PinFeed;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;

public class PinSwipeFragment extends ViewPagerFragment
{

    private static final String SOURCE_PIN_FEED = "__SOURCE_PIN_FEED";
    private static Runnable _eduRunnable;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private Feed _sourceFeed;

    public PinSwipeFragment()
    {
        _eventsSubscriber = new _cls2();
    }

    public static void setEduRunnable(Runnable runnable)
    {
        _eduRunnable = runnable;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300a2;
        _viewAdapter = new PinSwipeAdapter(getChildFragmentManager());
        if (_sourceFeed == null && bundle != null)
        {
            _sourceFeed = Feed.restoreInstanceState(bundle, "__SOURCE_PIN_FEED");
        }
        ((PinSwipeAdapter)_viewAdapter).setDataSource(_sourceFeed);
    }

    public void onDestroyView()
    {
        EducationHelper.a(_eduRunnable);
        Events.unregister(_eventsSubscriber);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        if (_sourceFeed != null && _sourceFeed.getAbsCount() > 0)
        {
            _sourceFeed.saveInstanceState(bundle1, "__SOURCE_PIN_FEED");
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _viewPager.setOnPageChangeListener(new _cls1());
        Events.registerSticky(_eventsSubscriber, com/pinterest/api/model/Pin$UpdateEvent, new Class[] {
            com/pinterest/activity/pin/gridcells/old/details/PinCloseupView$ImageLoadEvent
        });
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _sourceFeed = (PinFeed)navigation.getExtra("com.pinterest.EXTRA_FEED");
        _initialItem = navigation.getIntParcelable("com.pinterest.EXTRA_PIN_POSITION");
    }





    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final PinSwipeFragment this$0;

        public void onEventMainThread(com.pinterest.activity.pin.gridcells.old.details.PinCloseupView.ImageLoadEvent imageloadevent)
        {
            if (imageloadevent.getPin() == null || imageloadevent.getPin().equals(_sourceFeed.get(get)))
            {
                StopWatch.get().complete("pin_closeup");
                Events.unregister(_eventsSubscriber, new Class[] {
                    com/pinterest/activity/pin/gridcells/old/details/PinCloseupView$ImageLoadEvent
                });
            }
        }

        public void onEventMainThread(com.pinterest.api.model.Pin.UpdateEvent updateevent)
        {
            if (updateevent.wasDeleted())
            {
                access$100.notifyDataSetChanged();
            }
            Events.removeStickyEvent(updateevent);
        }

        _cls2()
        {
            this$0 = PinSwipeFragment.this;
            super();
        }
    }


    private class _cls1 extends android.support.v4.view.ModifiedViewPager.SimpleOnPageChangeListener
    {

        final PinSwipeFragment this$0;

        public void onPageSelected(int i)
        {
            Pinalytics.a(PinSwipeFragment.this);
        }

        _cls1()
        {
            this$0 = PinSwipeFragment.this;
            super();
        }
    }

}
