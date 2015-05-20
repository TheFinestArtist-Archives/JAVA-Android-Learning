// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.pinterest.api.model.Pin;
import org.apache.commons.lang3.StringUtils;

public class CreateBoardListHeaderEdit extends FrameLayout
{

    private String _description;
    private TextView _editDescription;

    public CreateBoardListHeaderEdit(Context context)
    {
        this(context, null);
    }

    public CreateBoardListHeaderEdit(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _description = "";
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f0300dd, this);
        _editDescription = (TextView)findViewById(0x7f0b012f);
    }

    public String getDescriptionText()
    {
        return _description;
    }

    public void setDescriptionText(String s)
    {
        _description = s;
        if (StringUtils.isNotEmpty(Pin.cleanDescription(_description)))
        {
            _editDescription.setText(_description);
            return;
        } else
        {
            _editDescription.setText(0x7f0e0140);
            return;
        }
    }
}
