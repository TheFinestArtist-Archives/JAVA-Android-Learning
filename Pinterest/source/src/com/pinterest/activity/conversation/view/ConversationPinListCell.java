// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.conversation.view;

import android.content.Context;
import android.util.AttributeSet;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Device;
import com.pinterest.ui.grid.PinGridCell;

public class ConversationPinListCell extends PinGridCell
{

    private static final float MAX_STRETCH_RATIO = 1.3F * Device.getDensity();

    public ConversationPinListCell(Context context)
    {
        this(context, null);
    }

    public ConversationPinListCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void adjustLayoutBounds(Pin pin)
    {
        Object obj = pin.getImageMediumWidth();
        Integer integer1 = pin.getImageMediumHeight();
        if (obj != null && integer1 != null)
        {
            float f = Device.getScreenWidth() / 2.0F;
            Integer integer = ((Integer) (obj));
            pin = integer1;
            if ((float)((Integer) (obj)).intValue() < f)
            {
                float f1 = f / (float)((Integer) (obj)).intValue();
                f = f1;
                if (f1 > MAX_STRETCH_RATIO)
                {
                    f = MAX_STRETCH_RATIO;
                }
                integer = Integer.valueOf(Math.round((float)((Integer) (obj)).intValue() * f));
                pin = Integer.valueOf(Math.round(f * (float)integer1.intValue()));
            }
            obj = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
            obj.width = integer.intValue();
            obj.height = pin.intValue();
        }
    }

    private void init()
    {
        setRenderUser(false);
        setRenderSource(false);
        setRenderOnto(false);
        setRenderDomain(false);
    }

    public void setPin(String s)
    {
        setVisibility(8);
        s = ModelHelper.getPin(s);
        if (s != null)
        {
            adjustLayoutBounds(s);
            setPin(((Pin) (s)), false);
            setVisibility(0);
        }
    }

}
