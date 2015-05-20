// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonObject;
import java.util.List;

final class val.cb extends com.pinterest.api.remote.Response
{

    final llback val$cb;
    final List val$ids;

    public final void onSuccess(final ApiResponse data)
    {
        super.onSuccess(data);
        data = (PinterestJsonObject)data.getData();
        class _cls1 extends BackgroundTask
        {

            final NearbyPinsData._cls3 this$0;
            final PinterestJsonObject val$data;

            public void run()
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = ids.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (String)iterator.next();
                    obj = (new ApiResponse(data.c(String.format("GET:/v3/boards/%s/pins/", new Object[] {
                        obj
                    })))).getData();
                    if (obj instanceof PinterestJsonArray)
                    {
                        arraylist.addAll(NearbyPinsData.access$000(Pin.makeAll((PinterestJsonArray)obj)));
                    }
                } while (true);
                cb.onPlacesLoaded(arraylist);
            }

            _cls1()
            {
                this$0 = NearbyPinsData._cls3.this;
                data = pinterestjsonobject;
                super();
            }
        }

        if (data != null)
        {
            (new _cls1()).execute();
        }
    }

    llback()
    {
        val$ids = list;
        val$cb = llback;
        super();
    }
}
