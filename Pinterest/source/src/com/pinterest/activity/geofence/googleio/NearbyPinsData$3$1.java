// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.geofence.googleio;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonArray;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.Pin;
import com.pinterest.kit.tasks.BackgroundTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pinterest.activity.geofence.googleio:
//            NearbyPinsData

class val.data extends BackgroundTask
{

    final back.onPlacesLoaded this$0;
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
            obj = (new ApiResponse(val$data.c(String.format("GET:/v3/boards/%s/pins/", new Object[] {
                obj
            })))).getData();
            if (obj instanceof PinterestJsonArray)
            {
                arraylist.addAll(NearbyPinsData.access$000(Pin.makeAll((PinterestJsonArray)obj)));
            }
        } while (true);
        cb.onPlacesLoaded(arraylist);
    }

    back()
    {
        this$0 = final_back;
        val$data = PinterestJsonObject.this;
        super();
    }
}
