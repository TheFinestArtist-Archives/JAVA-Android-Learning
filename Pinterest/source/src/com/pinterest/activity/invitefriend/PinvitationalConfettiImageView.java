// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.pinterest.base.Device;

public class PinvitationalConfettiImageView extends ImageView
{

    public PinvitationalConfettiImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getResources().getDrawable(0x7f0201a8);
        i = (int)Device.getScreenWidth();
        setMeasuredDimension(i, (drawable.getIntrinsicHeight() * i) / drawable.getIntrinsicWidth());
    }
}
