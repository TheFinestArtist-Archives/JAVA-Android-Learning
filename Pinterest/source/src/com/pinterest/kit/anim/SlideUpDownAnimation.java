// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.anim;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SlideUpDownAnimation extends Animation
{

    private static final String TAG = "SlideUpDownAnimation";
    private boolean slideIn;
    private int targetHeight;
    private View view;

    public SlideUpDownAnimation(View view1, boolean flag, int i)
    {
        view = view1;
        targetHeight = i;
        slideIn = flag;
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i;
        if (slideIn)
        {
            i = (int)((float)targetHeight * f);
        } else
        {
            i = (int)((float)targetHeight * (1.0F - f));
        }
        view.getLayoutParams().height = i;
        view.requestLayout();
    }

    public void initialize(int i, int j, int k, int l)
    {
        super.initialize(i, j, k, l);
        view.setVisibility(0);
    }

    public boolean willChangeBounds()
    {
        return true;
    }
}
