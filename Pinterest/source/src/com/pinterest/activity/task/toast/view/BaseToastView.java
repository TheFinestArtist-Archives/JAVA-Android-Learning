// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.pinterest.ui.imageview.WebImageView;

public class BaseToastView extends FrameLayout
{

    public Button actionBt;
    public ImageView arrow;
    public View divider;
    public WebImageView messageIc;
    public TextView subtitleTv;
    public TextView titleTv;
    public TextView topTv;

    public BaseToastView(Context context)
    {
        this(context, null);
    }

    public BaseToastView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f03013b, this, true);
        topTv = (TextView)findViewById(0x7f0b02d1);
        divider = findViewById(0x7f0b02d2);
        titleTv = (TextView)findViewById(0x7f0b0065);
        subtitleTv = (TextView)findViewById(0x7f0b0201);
        messageIc = (WebImageView)findViewById(0x7f0b01d8);
        actionBt = (Button)findViewById(0x7f0b023a);
        actionBt.setText(0x7f0e04c7);
        arrow = (ImageView)findViewById(0x7f0b0230);
        messageIc.setOval(true);
    }
}
