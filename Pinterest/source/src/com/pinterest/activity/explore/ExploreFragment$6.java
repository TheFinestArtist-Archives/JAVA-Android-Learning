// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import com.pinterest.activity.explore.adapter.ExploreInterestsAdapter;
import com.pinterest.activity.explore.util.ExploreInterestsData;
import com.pinterest.kit.tasks.BackgroundTask;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.explore:
//            ExploreFragment

class this._cls0 extends BackgroundTask
{

    ArrayList interests;
    final ExploreFragment this$0;

    public void onFinish()
    {
        if (interests != null && interests.size() > 0 && ExploreFragment.access$000(ExploreFragment.this) != null)
        {
            ExploreFragment.access$000(ExploreFragment.this).setDataSource(interests);
        }
    }

    public void run()
    {
        interests = ExploreInterestsData.getExploreDataBlocking();
    }

    stsData()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
