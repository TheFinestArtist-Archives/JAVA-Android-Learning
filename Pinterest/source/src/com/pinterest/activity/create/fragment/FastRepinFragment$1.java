// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            FastRepinFragment

class val.repinDupView
    implements android.view.animation.istener
{

    final FastRepinFragment this$0;
    final View val$repinDupView;

    public void onAnimationEnd(Animation animation)
    {
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        val$repinDupView.setVisibility(0);
    }

    ()
    {
        this$0 = final_fastrepinfragment;
        val$repinDupView = View.this;
        super();
    }
}
