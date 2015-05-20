// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.larvalabs.svgandroid;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;

public class SVG
{

    private final Picture a;
    private final RectF b;
    private RectF c;
    private PictureDrawable d;

    SVG(Picture picture, RectF rectf)
    {
        c = null;
        d = null;
        a = picture;
        b = rectf;
    }

    public final Picture a()
    {
        return a;
    }

    final void a(RectF rectf)
    {
        c = rectf;
    }
}
