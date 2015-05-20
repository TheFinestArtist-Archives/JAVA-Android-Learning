// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.explore;

import android.widget.AbsListView;
import com.pinterest.kit.network.image.ImageCache;

// Referenced classes of package com.pinterest.activity.explore:
//            ExploreFragment

class this._cls0
    implements android.widget.llListener
{

    final ExploreFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i == 0 || i == 1)
        {
            ImageCache.resumeTag("ExploreSubInterestImage");
            return;
        } else
        {
            ImageCache.pauseTag("ExploreSubInterestImage");
            return;
        }
    }

    ()
    {
        this$0 = ExploreFragment.this;
        super();
    }
}
