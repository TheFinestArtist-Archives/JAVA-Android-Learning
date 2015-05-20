// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.model.BoardFeed;
import com.pinterest.api.model.Feed;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsData

final class it> extends com.pinterest.api.remote.dApiResponse
{

    final llback val$cb;

    public final void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        NearbyPinsData.access$100((BoardFeed)feed, val$cb);
    }

    llback()
    {
        val$cb = llback;
        super();
    }
}
