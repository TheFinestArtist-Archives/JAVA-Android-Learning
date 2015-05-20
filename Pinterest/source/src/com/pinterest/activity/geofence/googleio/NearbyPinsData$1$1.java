// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.model.Feed;
import com.pinterest.api.model.PinFeed;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsData

class val.feed extends BackgroundTask
{

    final back.onPlacesLoaded this$0;
    final Feed val$feed;

    public void run()
    {
        java.util.List list = NearbyPinsData.access$000(((PinFeed)val$feed).getItems());
        cb.onPlacesLoaded(list);
    }

    back()
    {
        this$0 = final_back;
        val$feed = Feed.this;
        super();
    }
}
