// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.utils;

import android.animation.ObjectAnimator;
import android.view.View;
import com.pinterest.ui.spring.SpringInterpolator;

public class AnimationUtils
{

    public AnimationUtils()
    {
    }

    public static ObjectAnimator spinAnimate(View view, AnimationListener animationlistener)
    {
        view = ObjectAnimator.ofFloat(view, "rotation", new float[] {
            0.0F, 360F
        });
        view.setDuration(1000L);
        view.setRepeatCount(-1);
        view.setRepeatMode(1);
        view.addListener(animationlistener);
        return view;
    }

    public static ObjectAnimator springAnimate(View view, String s, float f, float f1, float f2, float f3)
    {
        SpringInterpolator springinterpolator = new SpringInterpolator(f2, f3);
        view = ObjectAnimator.ofFloat(view, s, new float[] {
            f, f1
        });
        view.setDuration(springinterpolator.getDuration());
        view.setRepeatCount(0);
        view.setInterpolator(springinterpolator);
        return view;
    }

    public static ObjectAnimator springAnimate(View view, String s, int i, int j, float f, float f1)
    {
        return springAnimate(view, s, i, j, f, f1);
    }
}
