// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.model.Feed;

final class val.cb extends com.pinterest.api.remote.Response
{

    final llback val$cb;

    public final void onSuccess(final Feed feed)
    {
        super.onSuccess(feed);
        class _cls1 extends BackgroundTask
        {

            final NearbyPinsData._cls1 this$0;
            final Feed val$feed;

            public void run()
            {
                java.util.List list = NearbyPinsData.access$000(((PinFeed)feed).getItems());
                cb.onPlacesLoaded(list);
            }

            _cls1()
            {
                this$0 = NearbyPinsData._cls1.this;
                feed = feed1;
                super();
            }
        }

        (new _cls1()).execute();
    }

    llback()
    {
        val$cb = llback;
        super();
    }
}
