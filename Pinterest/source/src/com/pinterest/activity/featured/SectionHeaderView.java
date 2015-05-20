// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.pinterest.ui.imageview.NonRoundWebImageView;
import com.pinterest.ui.text.PTextView;

public class SectionHeaderView extends FrameLayout
{

    private int _dominantColor;
    NonRoundWebImageView _image;
    PTextView _subTitle;
    PTextView _title;

    public SectionHeaderView(Context context)
    {
        this(context, null);
    }

    public SectionHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _dominantColor = 0xff0000ff;
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f030124, this);
        ButterKnife.a(this);
    }

    private void updateView()
    {
        _image.setBackgroundColor(_dominantColor);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        updateView();
    }

    public void setSubtitle(String s)
    {
        _subTitle.setText(s);
    }

    public void setTitle(String s)
    {
        _title.setText(s);
    }
}
