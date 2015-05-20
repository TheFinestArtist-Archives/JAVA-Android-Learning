// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import com.pinterest.activity.explore.adapter.ExploreInterestsAdapter;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.InterestsFeed;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.explore:
//            ExploreFragment

class edApiResponse extends com.pinterest.api.remote.estsFeedApiResponse
{

    final ExploreFragment this$0;

    public void onSuccess(Feed feed)
    {
        feed = (ArrayList)((InterestsFeed)feed).getItems();
        if (ExploreFragment.access$000(ExploreFragment.this) != null)
        {
            ExploreFragment.access$000(ExploreFragment.this).setTrendingInterests(feed);
        }
    }

    erestsAdapter()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
