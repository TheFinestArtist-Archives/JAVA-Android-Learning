// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.DigestFeed;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class val.cachedFeedData extends BackgroundTask
{

    DigestFeed _cachedFeed;
    final DigestFragment this$0;
    final PinterestJsonObject val$cachedFeedData;

    public void onFinish()
    {
        DigestFragment.access$402(DigestFragment.this, false);
        DigestFragment.access$500(DigestFragment.this).onSuccess(_cachedFeed);
        refresh();
    }

    public void run()
    {
        _cachedFeed = new DigestFeed(val$cachedFeedData, null);
        _cachedFeed.setCached(true);
    }

    eedApiResponseHandler()
    {
        this$0 = final_digestfragment;
        val$cachedFeedData = PinterestJsonObject.this;
        super();
    }
}
