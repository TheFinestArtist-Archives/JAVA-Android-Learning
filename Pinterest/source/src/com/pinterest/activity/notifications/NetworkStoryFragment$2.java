// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import com.pinterest.activity.notifications.adapter.StoryAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.StoryFeed;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.megaphone.NagUtils;

// Referenced classes of package com.pinterest.activity.notifications:
//            NetworkStoryFragment

class nse extends com.pinterest.api.remote.FeedApiResponse
{

    final NetworkStoryFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        NetworkStoryFragment.access$1800(NetworkStoryFragment.this, NetworkStoryFragment.access$1700(NetworkStoryFragment.this));
    }

    public void onStart()
    {
        super.onStart();
        if (NetworkStoryFragment.access$000(NetworkStoryFragment.this) != null && ((StoryAdapter)NetworkStoryFragment.access$100(NetworkStoryFragment.this)).getCount() > 0)
        {
            AdapterFooterView.setState(NetworkStoryFragment.access$200(NetworkStoryFragment.this), 0);
            AdapterEmptyView.setState(NetworkStoryFragment.access$300(NetworkStoryFragment.this), 2);
            return;
        } else
        {
            AdapterEmptyView.setState(NetworkStoryFragment.access$400(NetworkStoryFragment.this), 0);
            AdapterFooterView.setState(NetworkStoryFragment.access$500(NetworkStoryFragment.this), 2);
            return;
        }
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (NetworkStoryFragment.access$600(NetworkStoryFragment.this) != null)
        {
            if (((StoryAdapter)NetworkStoryFragment.access$700(NetworkStoryFragment.this)).getCount() > 0)
            {
                ((StoryAdapter)NetworkStoryFragment.access$800(NetworkStoryFragment.this)).appendItems((StoryFeed)feed);
            } else
            {
                ((StoryAdapter)NetworkStoryFragment.access$900(NetworkStoryFragment.this)).setDataSource((StoryFeed)feed);
                AdapterEmptyView.setState(NetworkStoryFragment.access$1000(NetworkStoryFragment.this), 1);
                if (isActive() && !isNagShown())
                {
                    NagUtils.showNag(getPlacementId(), new gEvent(null), 0x7f06000b);
                }
            }
            ((StoryAdapter)NetworkStoryFragment.access$1200(NetworkStoryFragment.this)).finishedLoading();
        } else
        {
            AdapterEmptyView.setState(NetworkStoryFragment.access$1300(NetworkStoryFragment.this), 2);
        }
        AdapterFooterView.setState(NetworkStoryFragment.access$1400(NetworkStoryFragment.this), 1);
        NetworkStoryFragment.access$1600(NetworkStoryFragment.this, NetworkStoryFragment.access$1500(NetworkStoryFragment.this));
    }

    gEvent()
    {
        this$0 = NetworkStoryFragment.this;
        super();
    }
}
