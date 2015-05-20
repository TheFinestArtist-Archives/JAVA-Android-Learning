// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.sendapin.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EmptySearchCell extends RelativeLayout
{

    private TextView _textEt;

    public EmptySearchCell(Context context)
    {
        super(context);
    }

    public EmptySearchCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public EmptySearchCell(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        _textEt = (TextView)findViewById(0x7f0b01c7);
    }

    public void setText(int i)
    {
        _textEt.setText(i);
    }

    public void setText(String s)
    {
        _textEt.setText(s);
    }
}
