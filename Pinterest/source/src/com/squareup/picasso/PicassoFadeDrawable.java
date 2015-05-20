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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;

public class PicassoFadeDrawable extends BitmapDrawable
{

    private static final Paint e = new Paint();
    Drawable a;
    long b;
    boolean c;
    int d;
    private boolean f;
    private final float g;
    private final Picasso.LoadedFrom h;

    public PicassoFadeDrawable(Context context, Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
        super(context.getResources(), bitmap);
        d = 255;
        g = context.getResources().getDisplayMetrics().density;
        h = loadedfrom;
        boolean flag;
        if (loadedfrom != Picasso.LoadedFrom.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
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

    public void draw(Canvas canvas)
    {
        if (!c)
        {
            super.draw(canvas);
        } else
        {
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
                setAlpha((int)(f1 * (float)d));
                super.draw(canvas);
                setAlpha(d);
            }
        }
        if (f)
        {
            e.setColor(-1);
            canvas.drawPath(a(new Point(0, 0), (int)(16F * g)), e);
            e.setColor(h.d);
            canvas.drawPath(a(new Point(0, 0), (int)(15F * g)), e);
        }
    }

    protected void onBoundsChange(Rect rect)
    {
        if (a != null)
        {
            a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i)
    {
        if (a != null)
        {
            a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        if (a != null)
        {
            a.setColorFilter(colorfilter);
        }
        super.setColorFilter(colorfilter);
    }

}
