// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore.util;

import com.pinterest.api.model.Interest;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.explore.util:
//            ExploreInterestsData

final class  extends BackgroundTask
{

    boolean isJsonCached;

    public final void onFinish()
    {
        super.onFinish();
        if (!isJsonCached)
        {
            ExploreInterestsData.get().refreshFromServer();
        }
    }

    public final void run()
    {
        com.pinterest.api.PinterestJsonArray pinterestjsonarray = DiskCache.getJsonArray("EXPLORE_TOPIC_DATA");
        if (pinterestjsonarray != null)
        {
            ExploreInterestsData.access$002(ExploreInterestsData.get(), Interest.makeAllFromExploreData(pinterestjsonarray, false));
            isJsonCached = true;
        }
    }

    ()
    {
    }
}
