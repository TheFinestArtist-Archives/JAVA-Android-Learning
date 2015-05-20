// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.pinterest.activity.notifications.adapter.StoryAdapter;
import com.pinterest.activity.notifications.view.MaxWidthListView;
import com.pinterest.activity.task.fragment.ListFragment;
import com.pinterest.adapter.LoadMoreListener;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.BaseApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;

// Referenced classes of package com.pinterest.activity.notifications:
//            NotificationCount

public abstract class BaseNotificationFragment extends ListFragment
    implements LoadMoreListener
{

    protected com.pinterest.api.remote.MyUserApi.NotificationFeedApiResponse onNotificationsLoaded;

    public BaseNotificationFragment()
    {
        onNotificationsLoaded = new _cls2();
    }

    protected abstract StoryAdapter createAdapter();

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
                BaseApi.e(((String) (obj)), onNotificationsLoaded, getApiTag());
            }
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (NotificationCount.getUnseenYourStoryCount() != 0)
        {
            NotificationCount.setUnseenYourStoryCount(0);
            MyUserApi.b(getApiTag());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030073;
        _adapter = createAdapter();
        ((StoryAdapter)_adapter).setListener(this);
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
            ((StoryAdapter)_adapter).setDataSource(Feed.restoreInstanceState(bundle));
        }
        _emptyView.setRefreshAction(new _cls1());
        _footerView.setState(2);
        _listView = (MaxWidthListView)view.findViewById(0x7f0b013e);
        _listView.addFooterView(_footerView, null, false);
        _listView.setEmptyView(view.findViewById(0x7f0b013f));
        _listView.setAdapter(_adapter);
    }

    protected void updateEmptyContent()
    {
        _emptyLeftImage = 0x7f02015e;
        _emptyCenterImage = 0x7f02015d;
        _emptyRightImage = 0x7f02015f;
        _emptyFanUtilParams = (new com.pinterest.ui.anim.FanAnimationUtil.FanUtilParams()).setMode(com.pinterest.ui.anim.FanAnimationUtil.FanUtilParams.Orientation.VERTICAL).setRotation(0.0F).setFanDistanceMultiplier(0.8F);
        _emptyMessage = Resources.string(0x7f0e01fe);
    }



















    private class _cls2 extends com.pinterest.api.remote.MyUserApi.NotificationFeedApiResponse
    {

        final BaseNotificationFragment this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            setEmptyContent(access$1700);
        }

        public void onStart()
        {
            super.onStart();
            if (access$1700 != null && ((StoryAdapter)access$1700).getCount() > 0)
            {
                AdapterFooterView.setState(getCount, 0);
                AdapterEmptyView.setState(access$000, 2);
                return;
            } else
            {
                AdapterEmptyView.setState(access$000, 0);
                AdapterFooterView.setState(getCount, 2);
                return;
            }
        }

        public void onSuccess(Feed feed)
        {
            super.onSuccess(feed);
            if (access$1700 != null)
            {
                if (((StoryAdapter)access$1700).getCount() > 0)
                {
                    ((StoryAdapter)access$1700).appendItems(feed);
                } else
                {
                    ((StoryAdapter)access$1700).setDataSource(feed);
                    AdapterEmptyView.setState(access$000, 1);
                }
                ((StoryAdapter)access$1700).finishedLoading();
            } else
            {
                AdapterEmptyView.setState(access$000, 2);
            }
            AdapterFooterView.setState(getCount, 1);
            setEmptyContent(access$1700);
        }

        _cls2()
        {
            this$0 = BaseNotificationFragment.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BaseNotificationFragment this$0;

        public void onClick(View view)
        {
            refresh();
        }

        _cls1()
        {
            this$0 = BaseNotificationFragment.this;
            super();
        }
    }

}
