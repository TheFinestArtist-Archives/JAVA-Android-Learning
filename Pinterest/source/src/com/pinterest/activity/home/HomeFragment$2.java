// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.home;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.PinFeed;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.home:
//            HomeFragment

class t> extends BackgroundTask
{

    PinFeed _cachedFeed;
    final HomeFragment this$0;
    final PinterestJsonObject val$cachedFeedData;

    public void onFinish()
    {
        HomeFragment.access$1502(HomeFragment.this, false);
        HomeFragment.access$1600(HomeFragment.this).onSuccess(_cachedFeed);
        refresh();
    }

    public void run()
    {
        _cachedFeed = new PinFeed(val$cachedFeedData, null);
        _cachedFeed.setCached(true);
    }

    ApiResponseHandler()
    {
        this$0 = final_homefragment;
        val$cachedFeedData = PinterestJsonObject.this;
        super();
    }
}
