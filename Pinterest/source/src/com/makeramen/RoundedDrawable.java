// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.makeramen;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;

public class RoundedDrawable extends Drawable
{

    private final RectF a;
    private final RectF b;
    private float c;
    private final RectF d;
    private final Bitmap e;
    private final BitmapShader f;
    private final Paint g;
    private final int h;
    private final int i;
    private final RectF j;
    private final Paint k;
    private boolean l;
    private float m;
    private ColorStateList n;
    private android.widget.ImageView.ScaleType o;
    private final Matrix p;

    public RoundedDrawable(Bitmap bitmap, float f1)
    {
        this(bitmap, f1, (byte)0);
    }

    private RoundedDrawable(Bitmap bitmap, float f1, byte byte0)
    {
        this(bitmap, f1, 0, null);
    }

    public RoundedDrawable(Bitmap bitmap, float f1, int i1, ColorStateList colorstatelist)
    {
        a = new RectF();
        b = new RectF();
        d = new RectF();
        j = new RectF();
        l = false;
        o = android.widget.ImageView.ScaleType.FIT_XY;
        p = new Matrix();
        m = i1;
        if (colorstatelist == null)
        {
            colorstatelist = ColorStateList.valueOf(0xff000000);
        }
        n = colorstatelist;
        e = bitmap;
        h = e.getWidth();
        i = e.getHeight();
        d.set(0.0F, 0.0F, h, i);
        c = f1;
        f = new BitmapShader(e, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        f.setLocalMatrix(p);
        g = new Paint();
        g.setStyle(android.graphics.Paint.Style.FILL);
        g.setAntiAlias(true);
        g.setShader(f);
        k = new Paint();
        k.setStyle(android.graphics.Paint.Style.STROKE);
        k.setAntiAlias(true);
        k.setColor(n.getColorForState(getState(), 0xff000000));
        k.setStrokeWidth(i1);
    }

    private static Bitmap a(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable)
        {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        int i1 = drawable.getIntrinsicWidth();
        int j1 = drawable.getIntrinsicHeight();
        if (i1 > 0 && j1 > 0)
        {
            Bitmap bitmap = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } else
        {
            return null;
        }
    }

    public static Drawable a(Drawable drawable, float f1, int i1, ColorStateList colorstatelist)
    {
label0:
        {
            Object obj = drawable;
            if (drawable != null)
            {
                if (!(drawable instanceof TransitionDrawable))
                {
                    break label0;
                }
                drawable = (TransitionDrawable)drawable;
                int k1 = drawable.getNumberOfLayers();
                obj = new Drawable[k1];
                int j1 = 0;
                while (j1 < k1) 
                {
                    Drawable drawable1 = drawable.getDrawable(j1);
                    if (drawable1 instanceof ColorDrawable)
                    {
                        obj[j1] = drawable1;
                    } else
                    {
                        obj[j1] = new RoundedDrawable(a(drawable.getDrawable(j1)), f1, i1, colorstatelist);
                    }
                    j1++;
                }
                obj = new TransitionDrawable(((Drawable []) (obj)));
            }
            return ((Drawable) (obj));
        }
        Bitmap bitmap = a(drawable);
        if (bitmap != null)
        {
            return new RoundedDrawable(bitmap, f1, i1, colorstatelist);
        } else
        {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
    }

    private void b()
    {
        float f1;
        f1 = 0.0F;
        j.set(a);
        b.set(m, m, j.width() - m, j.height() - m);
        _cls1.a[o.ordinal()];
        JVM INSTR tableswitch 1 6: default 100
    //                   1 212
    //                   2 326
    //                   3 537
    //                   4 783
    //                   5 902
    //                   6 1021;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        j.set(a);
        b.set(m + 0.0F, 0.0F + m, j.width() - m, j.height() - m);
        p.set(null);
        p.setRectToRect(d, b, android.graphics.Matrix.ScaleToFit.FILL);
_L9:
        j.inset(m / 2.0F, m / 2.0F);
        f.setLocalMatrix(p);
        return;
_L2:
        j.set(a);
        b.set(m, m, j.width() - m, j.height() - m);
        p.set(null);
        p.setTranslate((int)((b.width() - (float)h) * 0.5F + 0.5F), (int)((b.height() - (float)i) * 0.5F + 0.5F));
        continue; /* Loop/switch isn't completed */
_L3:
        j.set(a);
        b.set(m, m, j.width() - m, j.height() - m);
        p.set(null);
        float f3;
        float f5;
        if ((float)h * b.height() > b.width() * (float)i)
        {
            f5 = b.height() / (float)i;
            f3 = (b.width() - (float)h * f5) * 0.5F;
        } else
        {
            f5 = b.width() / (float)h;
            f1 = b.height();
            float f7 = i;
            f3 = 0.0F;
            f1 = (f1 - f7 * f5) * 0.5F;
        }
        p.setScale(f5, f5);
        p.postTranslate((float)(int)(f3 + 0.5F) + m, (float)(int)(f1 + 0.5F) + m);
        continue; /* Loop/switch isn't completed */
_L4:
        p.set(null);
        float f2;
        float f4;
        float f6;
        if ((float)h <= a.width() && (float)i <= a.height())
        {
            f2 = 1.0F;
        } else
        {
            f2 = Math.min(a.width() / (float)h, a.height() / (float)i);
        }
        f4 = (int)((a.width() - (float)h * f2) * 0.5F + 0.5F);
        f6 = (int)((a.height() - (float)i * f2) * 0.5F + 0.5F);
        p.setScale(f2, f2);
        p.postTranslate(f4, f6);
        j.set(d);
        p.mapRect(j);
        b.set(j.left + m, j.top + m, j.right - m, j.bottom - m);
        p.setRectToRect(d, b, android.graphics.Matrix.ScaleToFit.FILL);
        continue; /* Loop/switch isn't completed */
_L5:
        j.set(d);
        p.setRectToRect(d, a, android.graphics.Matrix.ScaleToFit.CENTER);
        p.mapRect(j);
        b.set(j.left + m, j.top + m, j.right - m, j.bottom - m);
        p.setRectToRect(d, b, android.graphics.Matrix.ScaleToFit.FILL);
        continue; /* Loop/switch isn't completed */
_L6:
        j.set(d);
        p.setRectToRect(d, a, android.graphics.Matrix.ScaleToFit.END);
        p.mapRect(j);
        b.set(j.left + m, j.top + m, j.right - m, j.bottom - m);
        p.setRectToRect(d, b, android.graphics.Matrix.ScaleToFit.FILL);
        continue; /* Loop/switch isn't completed */
_L7:
        j.set(d);
        p.setRectToRect(d, a, android.graphics.Matrix.ScaleToFit.START);
        p.mapRect(j);
        b.set(j.left + m, j.top + m, j.right - m, j.bottom - m);
        p.setRectToRect(d, b, android.graphics.Matrix.ScaleToFit.FILL);
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected final android.widget.ImageView.ScaleType a()
    {
        return o;
    }

    public final void a(float f1)
    {
        c = f1;
    }

    public final void a(int i1)
    {
        m = i1;
        k.setStrokeWidth(m);
    }

    public final void a(ColorStateList colorstatelist)
    {
        if (colorstatelist == null)
        {
            colorstatelist = ColorStateList.valueOf(0);
        }
        n = colorstatelist;
        k.setColor(n.getColorForState(getState(), 0xff000000));
    }

    public final void a(android.widget.ImageView.ScaleType scaletype)
    {
        android.widget.ImageView.ScaleType scaletype1 = scaletype;
        if (scaletype == null)
        {
            scaletype1 = android.widget.ImageView.ScaleType.FIT_XY;
        }
        if (o != scaletype1)
        {
            o = scaletype1;
            b();
        }
    }

    public final void a(boolean flag)
    {
        l = flag;
    }

    public void draw(Canvas canvas)
    {
        if (l)
        {
            if (m > 0.0F)
            {
                canvas.drawOval(j, k);
                canvas.drawOval(b, g);
                return;
            } else
            {
                canvas.drawOval(b, g);
                return;
            }
        }
        if (m > 0.0F)
        {
            canvas.drawRoundRect(j, c, c, k);
            canvas.drawRoundRect(b, Math.max(c - m, 0.0F), Math.max(c - m, 0.0F), g);
            return;
        } else
        {
            canvas.drawRoundRect(b, c, c, g);
            return;
        }
    }

    public int getIntrinsicHeight()
    {
        return i;
    }

    public int getIntrinsicWidth()
    {
        return h;
    }

    public int getOpacity()
    {
        return -3;
    }

    public boolean isStateful()
    {
        return n.isStateful();
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        a.set(rect);
        b();
    }

    protected boolean onStateChange(int ai[])
    {
        int i1 = n.getColorForState(ai, 0);
        if (k.getColor() != i1)
        {
            k.setColor(i1);
            return true;
        } else
        {
            return super.onStateChange(ai);
        }
    }

    public void setAlpha(int i1)
    {
        g.setAlpha(i1);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        g.setColorFilter(colorfilter);
        invalidateSelf();
    }

    private class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[android.widget.ImageView.ScaleType.values().length];
            try
            {
                a[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                a[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                a[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                a[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                a[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
