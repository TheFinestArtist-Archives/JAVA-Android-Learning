// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;

// Referenced classes of package com.google.android.gms.internal:
//            jx

public final class jz extends Button
{

    public jz(Context context)
    {
        this(context, null);
    }

    public jz(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0x1010048);
    }

    private int b(int i, int j, int k)
    {
        switch (i)
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unknown color scheme: ")).append(i).toString());

        case 1: // '\001'
            j = k;
            // fall through

        case 0: // '\0'
            return j;
        }
    }

    private void b(Resources resources, int i, int j)
    {
        switch (i)
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unknown button size: ")).append(i).toString());

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_79;

        case 0: // '\0'
        case 1: // '\001'
            i = b(j, com.google.android.gms.R.drawable.common_signin_btn_text_dark, com.google.android.gms.R.drawable.common_signin_btn_text_light);
            break;
        }
_L1:
        if (i == -1)
        {
            throw new IllegalStateException("Could not find background resource!");
        } else
        {
            setBackgroundDrawable(resources.getDrawable(i));
            return;
        }
        i = b(j, com.google.android.gms.R.drawable.common_signin_btn_icon_dark, com.google.android.gms.R.drawable.common_signin_btn_icon_light);
          goto _L1
    }

    private void c(Resources resources)
    {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14F);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int)(f * 48F + 0.5F));
        setMinWidth((int)(f * 48F + 0.5F));
    }

    private void c(Resources resources, int i, int j)
    {
        setTextColor(resources.getColorStateList(b(j, com.google.android.gms.R.color.common_signin_btn_text_dark, com.google.android.gms.R.color.common_signin_btn_text_light)));
        switch (i)
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unknown button size: ")).append(i).toString());

        case 0: // '\0'
            setText(resources.getString(com.google.android.gms.R.string.common_signin_button_text));
            return;

        case 1: // '\001'
            setText(resources.getString(com.google.android.gms.R.string.common_signin_button_text_long));
            return;

        case 2: // '\002'
            setText(null);
            break;
        }
    }

    public final void a(Resources resources, int i, int j)
    {
        boolean flag;
        if (i >= 0 && i < 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.a(flag, "Unknown button size %d", new Object[] {
            Integer.valueOf(i)
        });
        if (j >= 0 && j < 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jx.a(flag, "Unknown color scheme %s", new Object[] {
            Integer.valueOf(j)
        });
        c(resources);
        b(resources, i, j);
        c(resources, i, j);
    }
}
