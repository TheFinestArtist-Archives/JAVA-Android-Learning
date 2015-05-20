// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.notify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DialogTitleView extends FrameLayout
{

    public TextView subTitleTv;
    public TextView textTv;
    public View titleDivider;
    public TextView titleTv;

    public DialogTitleView(Context context)
    {
        this(context, null);
    }

    public DialogTitleView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DialogTitleView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f03011f, this);
        titleTv = (TextView)findViewById(0x7f0b0065);
        subTitleTv = (TextView)findViewById(0x7f0b0201);
        textTv = (TextView)findViewById(0x7f0b02a6);
        titleDivider = findViewById(0x7f0b02a7);
    }

    public void setHeight(int i)
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.height = i;
        setLayoutParams(layoutparams);
    }
}
