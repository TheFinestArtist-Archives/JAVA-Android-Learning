// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

final class PicassoDrawable extends BitmapDrawable
{

    private static final Paint e = new Paint();
    Drawable a;
    long b;
    boolean c;
    int d;
    private final boolean f;
    private final float g;
    private final Picasso.LoadedFrom h;

    private PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedfrom, boolean flag, boolean flag1)
    {
        super(context.getResources(), bitmap);
        d = 255;
        f = flag1;
        g = context.getResources().getDisplayMetrics().density;
        h = loadedfrom;
        boolean flag2;
        if (loadedfrom != Picasso.LoadedFrom.a && !flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            a = drawable;
            c = true;
            b = SystemClock.uptimeMillis();
        }
    }

    private static Path a(Point point, int i)
    {
        Point point1 = new Point(point.x + i, point.y);
        Point point2 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point1.x, point1.y);
        path.lineTo(point2.x, point2.y);
        return path;
    }

    static void a(ImageView imageview, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedfrom, boolean flag, boolean flag1)
    {
        Drawable drawable = imageview.getDrawable();
        if (drawable instanceof AnimationDrawable)
        {
            ((AnimationDrawable)drawable).stop();
        }
        imageview.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedfrom, flag, flag1));
    }

    static void a(ImageView imageview, Drawable drawable)
    {
        imageview.setImageDrawable(drawable);
        if (imageview.getDrawable() instanceof AnimationDrawable)
        {
            ((AnimationDrawable)imageview.getDrawable()).start();
        }
    }

    public final void draw(Canvas canvas)
    {
        if (c) goto _L2; else goto _L1
_L1:
        super.draw(canvas);
_L4:
        if (f)
        {
            e.setColor(-1);
            canvas.drawPath(a(new Point(0, 0), (int)(16F * g)), e);
            e.setColor(h.d);
            canvas.drawPath(a(new Point(0, 0), (int)(15F * g)), e);
        }
        return;
_L2:
        float f1 = (float)(SystemClock.uptimeMillis() - b) / 200F;
        if (f1 >= 1.0F)
        {
            c = false;
            a = null;
            super.draw(canvas);
        } else
        {
            if (a != null)
            {
                a.draw(canvas);
            }
            super.setAlpha((int)(f1 * (float)d));
            super.draw(canvas);
            super.setAlpha(d);
            if (android.os.Build.VERSION.SDK_INT <= 10)
            {
                invalidateSelf();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void onBoundsChange(Rect rect)
    {
        if (a != null)
        {
            a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public final void setAlpha(int i)
    {
        d = i;
        if (a != null)
        {
            a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        if (a != null)
        {
            a.setColorFilter(colorfilter);
        }
        super.setColorFilter(colorfilter);
    }

}
