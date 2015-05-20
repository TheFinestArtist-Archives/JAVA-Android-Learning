// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import com.pinterest.activity.explore.adapter.ExploreAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.CategoryFeed;
import com.pinterest.api.model.Feed;
import com.pinterest.ui.grid.AdapterEmptyView;
import com.pinterest.ui.grid.AdapterFooterView;

// Referenced classes of package com.pinterest.activity.explore:
//            ExploreFragment

class edApiResponse extends com.pinterest.api.remote.riesFeedApiResponse
{

    final ExploreFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        AdapterEmptyView.setState(ExploreFragment.access$2000(ExploreFragment.this), 1);
        ExploreFragment.access$2200(ExploreFragment.this, ExploreFragment.access$2100(ExploreFragment.this));
    }

    public void onStart()
    {
        super.onStart();
        if (ExploreFragment.access$300(ExploreFragment.this) != null && ((ExploreAdapter)ExploreFragment.access$400(ExploreFragment.this)).getCount() > 0)
        {
            AdapterFooterView.setState(ExploreFragment.access$500(ExploreFragment.this), 0);
            AdapterEmptyView.setState(ExploreFragment.access$600(ExploreFragment.this), 2);
            return;
        } else
        {
            AdapterEmptyView.setState(ExploreFragment.access$700(ExploreFragment.this), 0);
            AdapterFooterView.setState(ExploreFragment.access$800(ExploreFragment.this), 2);
            return;
        }
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (ExploreFragment.access$900(ExploreFragment.this) != null)
        {
            if (((ExploreAdapter)ExploreFragment.access$1000(ExploreFragment.this)).getCount() > 0)
            {
                ((ExploreAdapter)ExploreFragment.access$1100(ExploreFragment.this)).setDataSource((CategoryFeed)feed);
            } else
            {
                ((ExploreAdapter)ExploreFragment.access$1200(ExploreFragment.this)).setDataSource((CategoryFeed)feed);
                AdapterEmptyView.setState(ExploreFragment.access$1300(ExploreFragment.this), 1);
            }
            if (ExploreFragment.access$1400(ExploreFragment.this) != null)
            {
                ((ExploreAdapter)ExploreFragment.access$1500(ExploreFragment.this)).finishedLoading();
            }
        } else
        {
            AdapterEmptyView.setState(ExploreFragment.access$1600(ExploreFragment.this), 2);
        }
        AdapterFooterView.setState(ExploreFragment.access$1700(ExploreFragment.this), 1);
        ExploreFragment.access$1900(ExploreFragment.this, ExploreFragment.access$1800(ExploreFragment.this));
    }

    pter(boolean flag, boolean flag1)
    {
        this$0 = ExploreFragment.this;
        super(flag, flag1);
    }
}
