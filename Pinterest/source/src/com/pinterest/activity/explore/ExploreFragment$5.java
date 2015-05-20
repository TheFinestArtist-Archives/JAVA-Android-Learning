// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import com.pinterest.activity.explore.adapter.ExploreAdapter;
import com.pinterest.kit.tasks.BackgroundResult;
import java.util.List;

// Referenced classes of package com.pinterest.activity.explore:
//            ExploreFragment

class this._cls0 extends BackgroundResult
{

    final ExploreFragment this$0;

    public void onFinish(Object obj)
    {
        if ((obj instanceof List) && ExploreFragment.access$100(ExploreFragment.this) != null)
        {
            ((ExploreAdapter)ExploreFragment.access$200(ExploreFragment.this)).setRecentCategories((List)obj);
        }
    }

    pter()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
