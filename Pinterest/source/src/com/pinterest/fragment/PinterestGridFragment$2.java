// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.support.v4.widget.SwipeRefreshLayout;

// Referenced classes of package com.pinterest.fragment:
//            PinterestGridFragment

class this._cls0
    implements android.support.v4.widget.reshListener
{

    final PinterestGridFragment this$0;

    public void onRefresh()
    {
        if (PinterestGridFragment.access$600(PinterestGridFragment.this))
        {
            return;
        } else
        {
            _swipeVw.setRefreshing(true);
            refresh();
            return;
        }
    }

    RefreshListener()
    {
        this$0 = PinterestGridFragment.this;
        super();
    }
}
