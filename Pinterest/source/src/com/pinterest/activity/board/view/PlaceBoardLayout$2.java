// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import android.view.View;

// Referenced classes of package com.pinterest.activity.board.view:
//            PlaceBoardLayout

class it> extends android.support.v4.widget.back
{

    final PlaceBoardLayout this$0;

    public int clampViewPositionVertical(View view, int i, int j)
    {
        j = getPaddingTop();
        int k = getHeight();
        int l = PlaceBoardLayout.access$000(PlaceBoardLayout.this).getHeight();
        int i1 = PlaceBoardLayout.access$000(PlaceBoardLayout.this).getPaddingBottom();
        return Math.min(Math.max(i, j), k - l - i1);
    }

    public int getViewVerticalDragRange(View view)
    {
        if (view == PlaceBoardLayout.access$200(PlaceBoardLayout.this))
        {
            return PlaceBoardLayout.access$300(PlaceBoardLayout.this);
        } else
        {
            return 0;
        }
    }

    public void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        PlaceBoardLayout.access$102(PlaceBoardLayout.this, j);
        requestLayout();
    }

    public boolean tryCaptureView(View view, int i)
    {
        return view == PlaceBoardLayout.access$200(PlaceBoardLayout.this);
    }

    ()
    {
        this$0 = PlaceBoardLayout.this;
        super();
    }
}
