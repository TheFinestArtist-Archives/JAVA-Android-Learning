// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;

public class ContextMenuEduTooltip extends LinearLayout
{

    private static final int ANCHOR_MARGIN_TOP = (int)(-9F * Device.getDensity());
    public static final float MAX_WIDTH = Math.min(Resources.dimension(0x7f0a00ae), 0.7F * Device.getScreenWidth());
    private static final int PADDING_LR = (int)Resources.dimension(0x7f0a005b);
    private static final int PADDING_TB = (int)Resources.dimension(0x7f0a005c);
    private TextView _toolTip;

    public ContextMenuEduTooltip(Context context)
    {
        this(context, null);
    }

    public ContextMenuEduTooltip(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    private int getAnchorTopMargin()
    {
        float f = Device.getDensity();
        int j = Math.round(9F * f) * -1;
        int i = j;
        if ((double)f > 1.3300000000000001D)
        {
            i = j;
            if ((double)f < 1.3400000000000001D)
            {
                i = j - 1;
            }
        }
        return i;
    }

    private void init(Context context)
    {
        setOrientation(1);
        setGravity(1);
        _toolTip = new TextView(context);
        Object obj = new android.widget.FrameLayout.LayoutParams((int)MAX_WIDTH, -2);
        _toolTip.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        _toolTip.setGravity(17);
        _toolTip.setBackgroundResource(0x7f0200c9);
        _toolTip.setLineSpacing(0.0F, 1.15F);
        _toolTip.setPadding(PADDING_LR, PADDING_TB, PADDING_LR, PADDING_TB - 1);
        addView(_toolTip);
        context = new ImageView(context);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, getAnchorTopMargin(), 0, 0);
        context.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        context.setImageResource(0x7f0200c4);
        addView(context);
    }

    public int getViewHeight()
    {
        int j = super.getMeasuredHeight();
        int i = j;
        if (j == 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            measure(i, i);
            i = super.getMeasuredHeight();
        }
        return i;
    }

    public void setText(String s)
    {
        _toolTip.setText(Html.fromHtml(s), android.widget.TextView.BufferType.SPANNABLE);
    }

}
