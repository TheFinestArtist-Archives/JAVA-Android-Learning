// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package android.support.v4.widget:
//            SwipeRefreshLayout, CircleImageView

class this._cls0 extends Animation
{

    final SwipeRefreshLayout this$0;

    public void applyTransformation(float f, Transformation transformation)
    {
        int i;
        int j;
        int k;
        if (!SwipeRefreshLayout.access$1100(SwipeRefreshLayout.this))
        {
            i = (int)(SwipeRefreshLayout.access$1200(SwipeRefreshLayout.this) - (float)Math.abs(mOriginalOffsetTop));
        } else
        {
            i = (int)SwipeRefreshLayout.access$1200(SwipeRefreshLayout.this);
        }
        j = mFrom;
        i = (int)((float)(i - mFrom) * f);
        k = SwipeRefreshLayout.access$400(SwipeRefreshLayout.this).getTop();
        SwipeRefreshLayout.access$900(SwipeRefreshLayout.this, (i + j) - k, false);
    }

    ()
    {
        this$0 = SwipeRefreshLayout.this;
        super();
    }
}
