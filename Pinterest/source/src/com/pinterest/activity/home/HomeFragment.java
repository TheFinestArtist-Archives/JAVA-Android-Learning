// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.adapter.PinterestBaseAdapter;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;
import com.pinterest.experience.Experiences;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.ui.grid.PinterestGridView;
import com.pinterest.ui.megaphone.HomeFeedMegaphoneEvent;
import com.pinterest.ui.megaphone.HomeNagEvent;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagHideAndUpdateEvent;
import com.pinterest.ui.megaphone.NagUtils;

public class HomeFragment extends PinGridFragment
{

    private Runnable _eduRunnable;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    Runnable _finishFeedRunnable;
    private boolean _firstLoad;
    private Handler _handler;
    private com.pinterest.api.remote.PinApi.HomePinFeedApiResponseHandler _homeFeedHandler;

    public HomeFragment()
    {
        _firstLoad = true;
        _eventsSubscriber = new _cls1();
        _homeFeedHandler = new _cls3(gridResponseHandler);
        _finishFeedRunnable = new _cls4();
        setCompactCells(true);
        _movingSpeed = 0.0F;
        _layoutId = 0x7f030089;
        _placementId = Experiences.a;
        _emptyMessage = Resources.string(0x7f0e023f);
        _handler = new Handler(Looper.getMainLooper());
    }

    private void loadNetworkData()
    {
        MyUserApi.a(_homeFeedHandler, null, getApiTag());
    }

    private void navigateUri(String s)
    {
        Location.navigateUri(getActivity(), s);
    }

    private void pollHomeFeedReady()
    {
        if (isActive())
        {
            _handler.postDelayed(_finishFeedRunnable, 1500L);
        }
    }

    private void setViewToScreenHeight(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        layoutparams.height = (int)Device.getScreenHeight() - Constants.ACTIONBAR_HEIGHT;
        view.setLayoutParams(layoutparams);
    }

    protected void loadData()
    {
        MyUserApi.a(getApiTag());
        if (!_firstLoad)
        {
            loadNetworkData();
            return;
        }
        final PinterestJsonObject cachedFeedData = DiskCache.getJsonObject("MY_HOME_FEED");
        if (cachedFeedData == null)
        {
            loadNetworkData();
            return;
        } else
        {
            (new _cls2()).execute();
            return;
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (_gridVw != null && (float)_gridVw.getScrollY() <= Resources.dimension(0x7f0a0034) && _adapter != null && ((PinGridAdapter)_adapter).getCount() > 0 && !_refreshing && !((PinGridAdapter)_adapter).isLoading())
        {
            refresh();
        }
    }

    protected void onDeactivate()
    {
        EducationHelper.a(_eduRunnable);
        super.onDeactivate();
    }

    public void onDestroyView()
    {
        _nagView = null;
        super.onDestroyView();
        Events.unregister(_eventsSubscriber);
    }

    public void onPause()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/User$UpdateEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$NUXCompletedEvent, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, com/pinterest/ui/megaphone/HomeNagEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$UndoRebuildFeedEvent, com/pinterest/ui/megaphone/NagHideAndUpdateEvent, com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent
        });
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Events.register(_eventsSubscriber, com/pinterest/api/model/User$UpdateEvent, new Class[] {
            com/pinterest/activity/nux/fragment/NUXEndScreenFragment$NUXCompletedEvent, com/pinterest/ui/grid/PinGridCell$ImageLoadEvent, com/pinterest/ui/megaphone/HomeNagEvent, com/pinterest/activity/nux/fragment/NUXEndScreenFragment$UndoRebuildFeedEvent, com/pinterest/ui/megaphone/NagHideAndUpdateEvent
        });
        Events.registerSticky(_eventsSubscriber, com/pinterest/ui/megaphone/HomeFeedMegaphoneEvent, new Class[0]);
        NagUtils.showNag(getPlacementId(), new HomeNagEvent(), 0x7f060009);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _actionBar.setLogo(DrawableUtils.tintIcon(0x7f020119, 0x7f090061));
        _actionBar.setNavigationIcon(null);
        _nagView = (MegaphoneView)_gridVw.addHeaderView(0x7f030100);
    }









/*
    static boolean access$1502(HomeFragment homefragment, boolean flag)
    {
        homefragment._firstLoad = flag;
        return flag;
    }

*/





/*
    static Runnable access$1902(HomeFragment homefragment, Runnable runnable)
    {
        homefragment._eduRunnable = runnable;
        return runnable;
    }

*/











    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final HomeFragment this$0;

        public void onEventMainThread(com.pinterest.activity.nux.fragment.NUXEndScreenFragment.NUXCompletedEvent nuxcompletedevent)
        {
            PLog.a("NUXCompletedEvent", new Object[0]);
            refresh();
        }

        public void onEventMainThread(com.pinterest.activity.nux.fragment.NUXEndScreenFragment.UndoRebuildFeedEvent undorebuildfeedevent)
        {
            
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(com.pinterest.api.model.User.UpdateEvent updateevent)
        {
        }

        public void onEventMainThread(com.pinterest.ui.grid.PinGridCell.ImageLoadEvent imageloadevent)
        {
            StopWatch.get().complete("ttrfp", ((PinGridAdapter)
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(HomeFeedMegaphoneEvent homefeedmegaphoneevent)
        {
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(HomeNagEvent homenagevent)
        {
            NagUtils.showNagFromEvent(HomeFragment.this, 
// JavaClassFileOutputException: get_constant: invalid tag

        public void onEventMainThread(NagHideAndUpdateEvent naghideandupdateevent)
        {
            
// JavaClassFileOutputException: get_constant: invalid tag

        _cls1()
        {
            this$0 = HomeFragment.this;
            super();
        }


        class _cls1
            implements android.view.View.OnClickListener
        {

            final _cls1 this$1;

            public void onClick(View view)
            {
                Pinalytics.a(ElementType.UPDATE_BUTTON, ComponentType.NAG);
                if (getActivity() != null)
                {
                    AutoUpdateManager.a().startUpdate(getActivity());
                }
            }

                _cls1()
                {
                    this$1 = _cls1.this;
                    Object();
                }
        }


        class _cls2
            implements android.view.View.OnClickListener
        {

            final _cls1 this$1;

            public void onClick(View view)
            {
                Pinalytics.a(ElementType.CANCEL_BUTTON, ComponentType.NAG);
            }

                _cls2()
                {
                    this$1 = _cls1.this;
                    Object();
                }
        }

    }


    private class _cls3 extends com.pinterest.api.remote.PinApi.HomePinFeedApiResponseHandler
    {

        final HomeFragment this$0;

        public void onSuccess(Feed feed)
        {
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        _cls3(FeedApiResponseHandler feedapiresponsehandler)
        {
            this$0 = HomeFragment.this;
            super(feedapiresponsehandler);
        }
    }


    private class _cls4
        implements Runnable
    {

        final HomeFragment this$0;

        public void run()
        {
            InterestsApi.a(new _cls1(), getApiTag());
        }

        _cls4()
        {
            this$0 = HomeFragment.this;
            super();
        }
    }


    private class _cls2 extends BackgroundTask
    {

        PinFeed _cachedFeed;
        final HomeFragment this$0;
        final PinterestJsonObject val$cachedFeedData;

        public void onFinish()
        {
            _firstLoad = false;
            _homeFeedHandler.onSuccess(_cachedFeed);
            refresh();
        }

        public void run()
        {
            _cachedFeed = new PinFeed(cachedFeedData, null);
            _cachedFeed.setCached(true);
        }

        _cls2()
        {
            this$0 = HomeFragment.this;
            cachedFeedData = pinterestjsonobject;
            super();
        }
    }

}
