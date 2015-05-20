// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import com.pinterest.activity.notifications.adapter.StoryAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;

// Referenced classes of package com.pinterest.activity.notifications:
//            BaseNotificationFragment

class init> extends com.pinterest.api.remote.piResponse
{

    final BaseNotificationFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        BaseNotificationFragment.access$1700(BaseNotificationFragment.this, BaseNotificationFragment.access$1600(BaseNotificationFragment.this));
    }

    public void onStart()
    {
        super.onStart();
        if (BaseNotificationFragment.access$000(BaseNotificationFragment.this) != null && ((StoryAdapter)BaseNotificationFragment.access$100(BaseNotificationFragment.this)).getCount() > 0)
        {
            AdapterFooterView.setState(BaseNotificationFragment.access$200(BaseNotificationFragment.this), 0);
            AdapterEmptyView.setState(BaseNotificationFragment.access$300(BaseNotificationFragment.this), 2);
            return;
        } else
        {
            AdapterEmptyView.setState(BaseNotificationFragment.access$400(BaseNotificationFragment.this), 0);
            AdapterFooterView.setState(BaseNotificationFragment.access$500(BaseNotificationFragment.this), 2);
            return;
        }
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (BaseNotificationFragment.access$600(BaseNotificationFragment.this) != null)
        {
            if (((StoryAdapter)BaseNotificationFragment.access$700(BaseNotificationFragment.this)).getCount() > 0)
            {
                ((StoryAdapter)BaseNotificationFragment.access$800(BaseNotificationFragment.this)).appendItems(feed);
            } else
            {
                ((StoryAdapter)BaseNotificationFragment.access$900(BaseNotificationFragment.this)).setDataSource(feed);
                AdapterEmptyView.setState(BaseNotificationFragment.access$1000(BaseNotificationFragment.this), 1);
            }
            ((StoryAdapter)BaseNotificationFragment.access$1100(BaseNotificationFragment.this)).finishedLoading();
        } else
        {
            AdapterEmptyView.setState(BaseNotificationFragment.access$1200(BaseNotificationFragment.this), 2);
        }
        AdapterFooterView.setState(BaseNotificationFragment.access$1300(BaseNotificationFragment.this), 1);
        BaseNotificationFragment.access$1500(BaseNotificationFragment.this, BaseNotificationFragment.access$1400(BaseNotificationFragment.this));
    }

    ()
    {
        this$0 = BaseNotificationFragment.this;
        super();
    }
}
