// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.dialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ReportBugView extends LinearLayout
{

    private EditText _messageTv;
    private EditText _titleTv;

    public ReportBugView(Context context)
    {
        super(context);
        init();
    }

    public ReportBugView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f03013e, this);
        _titleTv = (EditText)findViewById(0x7f0b0065);
        _messageTv = (EditText)findViewById(0x7f0b00d0);
    }

    public String getMessageText()
    {
        return String.valueOf(_messageTv.getText());
    }

    public String getTitleText()
    {
        return String.valueOf(_titleTv.getText());
    }
}
