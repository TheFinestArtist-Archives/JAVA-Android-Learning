// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class PinvitationalConfettiView extends RelativeLayout
{

    private static final int SCROLL_ANIMATION_DURATION = 45000;
    private static final int SHOW_ANIMATION_DURATION = 500;

    public PinvitationalConfettiView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(0, 0);
    }

    public void playAnimation(int i)
    {
        measure(0, 0);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(500L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(this, "translationY", new float[] {
            (float)(i - getMeasuredHeight()), 0.0F
        });
        objectanimator1.setDuration(45000L);
        objectanimator1.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, objectanimator1
        });
        animatorset.start();
    }
}
