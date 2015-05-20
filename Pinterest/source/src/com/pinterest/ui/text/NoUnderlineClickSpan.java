// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class NoUnderlineClickSpan extends ClickableSpan
{

    public NoUnderlineClickSpan()
    {
    }

    public void onClick(View view)
    {
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setUnderlineText(false);
    }
}
