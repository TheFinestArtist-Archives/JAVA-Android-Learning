// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.pinterest.activity.notifications.adapter.NetworkStoryAdapter;
import com.pinterest.activity.notifications.adapter.StoryAdapter;
import com.pinterest.activity.notifications.view.MaxWidthListView;
import com.pinterest.activity.task.fragment.ListFragment;
import com.pinterest.adapter.LoadMoreListener;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.StoryFeed;
import com.pinterest.api.remote.BaseApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.api.remote.NetworkStoryApi;
import com.pinterest.base.Events;
import com.pinterest.experience.Experiences;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagUtils;

// Referenced classes of package com.pinterest.activity.notifications:
//            NotificationCount

public class NetworkStoryFragment extends ListFragment
    implements LoadMoreListener
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private com.pinterest.api.remote.NetworkStoryApi.StoriesFeedApiResponse onFeedLoaded;

    public NetworkStoryFragment()
    {
        onFeedLoaded = new _cls2();
        _eventsSubscriber = new _cls3();
    }

    protected void loadData()
    {
        NetworkStoryApi.a(onFeedLoaded, getApiTag());
        updateEmptyContent();
    }

    public void loadMore()
    {
        if (_adapter != null)
        {
            Object obj = ((StoryAdapter)_adapter).getDataSource();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((Feed) (obj)).getNextUrl();
            }
            if (obj != null)
            {
                BaseApi.e(((String) (obj)), onFeedLoaded, getApiTag());
            }
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (NotificationCount.getUnseenNetworkStoryCount() != 0)
        {
            NotificationCount.setUnseenNetworkStoryCount(0);
            MyUserApi.b(getApiTag());
        }
        if (!isNagShown() && isDataNonEmpty())
        {
            NagUtils.showNag(getPlacementId(), new NagEvent(null), 0x7f06000b);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030073;
        _placementId = Experiences.e;
        _adapter = new NetworkStoryAdapter();
        ((StoryAdapter)_adapter).setListener(this);
    }

    public void onDestroyView()
    {
        _nagView = null;
        super.onDestroyView();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/notifications/NetworkStoryFragment$NagEvent
        });
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (_adapter != null && ((StoryAdapter)_adapter).getDataSource() != null)
        {
            ((StoryAdapter)_adapter).getDataSource().saveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        if (bundle != null)
        {
            ((StoryAdapter)_adapter).setDataSource((StoryFeed)Feed.restoreInstanceState(bundle));
        }
        _emptyView.setRefreshAction(new _cls1());
        _footerView.setState(2);
        _listView = (MaxWidthListView)view.findViewById(0x7f0b013e);
        _listView.addHeaderView(new View(getActivity()));
        _listView.addFooterView(_footerView, null, false);
        _listView.setEmptyView(view.findViewById(0x7f0b013f));
        _listView.setAdapter(_adapter);
        Events.register(_eventsSubscriber, com/pinterest/activity/notifications/NetworkStoryFragment$NagEvent, new Class[0]);
    }

    protected void updateEmptyContent()
    {
        _emptyLeftImage = 0x7f02015e;
        _emptyCenterImage = 0x7f02015d;
        _emptyRightImage = 0x7f02015f;
        _emptyFanUtilParams = (new com.pinterest.ui.anim.FanAnimationUtil.FanUtilParams()).setMode(com.pinterest.ui.anim.FanAnimationUtil.FanUtilParams.Orientation.VERTICAL).setRotation(0.0F).setFanDistanceMultiplier(0.8F);
        _emptyMessage = Resources.string(0x7f0e01fd);
    }














/*
    static MegaphoneView access$2002(NetworkStoryFragment networkstoryfragment, MegaphoneView megaphoneview)
    {
        networkstoryfragment._nagView = megaphoneview;
        return megaphoneview;
    }

*/











    private class _cls2 extends com.pinterest.api.remote.NetworkStoryApi.StoriesFeedApiResponse
    {

        final NetworkStoryFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            setEmptyContent(access$000);
        }

        public void onStart()
        {
            super.onStart();
            if (access$000 != null && ((StoryAdapter)access$000).getCount() > 0)
            {
                AdapterFooterView.setState(, 0);
                AdapterEmptyView.setState(
// JavaClassFileOutputException: get_constant: invalid tag

        public void onSuccess(Feed feed)
        {
            onSuccess(feed);
            if (access$000 != null)
            {
                if (((StoryAdapter)access$000).getCount() > 0)
                {
                    ((StoryAdapter)access$000).appendItems((StoryFeed)feed);
                } else
                {
                    ((StoryAdapter)access$000).setDataSource((StoryFeed)feed);
                    AdapterEmptyView.setState(
// JavaClassFileOutputException: get_constant: invalid tag

        _cls2()
        {
            this$0 = NetworkStoryFragment.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.base.Events.EventsSubscriber
    {

        final NetworkStoryFragment this$0;

        public void onEventMainThread(NagEvent nagevent)
        {
            PLog.a("NetworkStoryFragment.NagEvent", new Object[0]);
            if (
// JavaClassFileOutputException: get_constant: invalid tag

        _cls3()
        {
            this$0 = NetworkStoryFragment.this;
            super();
        }
    }


    private class NagEvent extends BaseNagEvent
    {

        private NagEvent()
        {
        }

        NagEvent(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final NetworkStoryFragment this$0;

        public void onClick(View view)
        {
            refresh();
        }

        _cls1()
        {
            this$0 = NetworkStoryFragment.this;
            super();
        }
    }

}
