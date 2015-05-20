// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.pin;

import android.graphics.Bitmap;
import com.pinterest.kit.utils.ImageUtils;
import com.squareup.picasso.Transformation;

public class PinImageTransformation
    implements Transformation
{

    public static final String KEY = "PinImageTransformation";
    public static final int MAX_HEIGHT = 2000;

    public PinImageTransformation()
    {
    }

    public static boolean shouldTransform(int i)
    {
        return i > 2000;
    }

    public String key()
    {
        return "PinImageTransformation";
    }

    public Bitmap transform(Bitmap bitmap)
    {
        return ImageUtils.bitmapToExactFit(bitmap, bitmap.getWidth(), 2000, 0, true, false);
    }
}
