// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.makeramen;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.pinterest.kit.application.Resources;

// Referenced classes of package com.makeramen:
//            RoundedDrawable

public class RoundedImageView extends ImageView
{

    public static final int DEFAULT_BORDER = 0;
    public static final int DEFAULT_RADIUS = 0;
    public static final String TAG = "RoundedImageView";
    private static final android.widget.ImageView.ScaleType sScaleTypeArray[];
    private Drawable mBackgroundDrawable;
    private ColorStateList mBorderColor;
    private int mBorderWidth;
    private int mCornerRadius;
    private Drawable mDrawable;
    private boolean mOval;
    private boolean mRoundBackground;
    private android.widget.ImageView.ScaleType mScaleType;

    public RoundedImageView(Context context)
    {
        super(context);
        mRoundBackground = false;
        mOval = false;
        mCornerRadius = 0;
        mBorderWidth = 0;
        mBorderColor = ColorStateList.valueOf(0xff000000);
    }

    public RoundedImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRoundBackground = false;
        mOval = false;
        setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        if (isInEditMode())
        {
            mCornerRadius = 3;
        } else
        {
            mCornerRadius = (int)Resources.dimension(0x7f0a0069);
        }
        mBorderWidth = -1;
        if (mCornerRadius < 0)
        {
            mCornerRadius = 0;
        }
        if (mBorderWidth < 0)
        {
            mBorderWidth = 0;
        }
        mBorderColor = ColorStateList.valueOf(0xff000000);
        mRoundBackground = false;
        mOval = false;
        if (mDrawable instanceof RoundedDrawable)
        {
            updateDrawableAttrs((RoundedDrawable)mDrawable);
        }
        if (mRoundBackground)
        {
            if (!(mBackgroundDrawable instanceof RoundedDrawable))
            {
                setBackgroundDrawable(mBackgroundDrawable);
            }
            if (mBackgroundDrawable instanceof RoundedDrawable)
            {
                updateDrawableAttrs((RoundedDrawable)mBackgroundDrawable);
            }
        }
    }

    private void updateDrawableAttrs(RoundedDrawable roundeddrawable)
    {
        roundeddrawable.a(mScaleType);
        roundeddrawable.a(mCornerRadius);
        roundeddrawable.a(mBorderWidth);
        roundeddrawable.a(mBorderColor);
        roundeddrawable.a(mOval);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorder()
    {
        return mBorderWidth;
    }

    public int getBorderColor()
    {
        return mBorderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors()
    {
        return mBorderColor;
    }

    public int getCornerRadius()
    {
        return mCornerRadius;
    }

    public android.widget.ImageView.ScaleType getScaleType()
    {
        return mScaleType;
    }

    public boolean isOval()
    {
        return mOval;
    }

    public boolean isRoundBackground()
    {
        return mRoundBackground;
    }

    public void setBackground(Drawable drawable)
    {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        if (mRoundBackground && drawable != null)
        {
            mBackgroundDrawable = RoundedDrawable.a(drawable, mCornerRadius, mBorderWidth, mBorderColor);
            updateDrawableAttrs((RoundedDrawable)mBackgroundDrawable);
        } else
        {
            mBackgroundDrawable = drawable;
        }
        super.setBackgroundDrawable(mBackgroundDrawable);
    }

    public void setBorderColor(int i)
    {
        setBorderColors(ColorStateList.valueOf(i));
    }

    public void setBorderColors(ColorStateList colorstatelist)
    {
        if (!mBorderColor.equals(colorstatelist))
        {
            ColorStateList colorstatelist1;
            if (colorstatelist != null)
            {
                colorstatelist1 = colorstatelist;
            } else
            {
                colorstatelist1 = ColorStateList.valueOf(0xff000000);
            }
            mBorderColor = colorstatelist1;
            if (mDrawable instanceof RoundedDrawable)
            {
                ((RoundedDrawable)mDrawable).a(colorstatelist);
            }
            if (mRoundBackground && (mBackgroundDrawable instanceof RoundedDrawable))
            {
                ((RoundedDrawable)mBackgroundDrawable).a(colorstatelist);
            }
            if (mBorderWidth > 0)
            {
                invalidate();
                return;
            }
        }
    }

    public void setBorderWidth(int i)
    {
        if (mBorderWidth == i)
        {
            return;
        }
        mBorderWidth = i;
        if (mDrawable instanceof RoundedDrawable)
        {
            ((RoundedDrawable)mDrawable).a(i);
        }
        if (mRoundBackground && (mBackgroundDrawable instanceof RoundedDrawable))
        {
            ((RoundedDrawable)mBackgroundDrawable).a(i);
        }
        invalidate();
    }

    public void setCornerRadius(int i)
    {
        if (mCornerRadius != i)
        {
            mCornerRadius = i;
            if (mDrawable instanceof RoundedDrawable)
            {
                ((RoundedDrawable)mDrawable).a(i);
            }
            if (mRoundBackground && (mBackgroundDrawable instanceof RoundedDrawable))
            {
                ((RoundedDrawable)mBackgroundDrawable).a(i);
                return;
            }
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            mDrawable = new RoundedDrawable(bitmap, mCornerRadius, mBorderWidth, mBorderColor);
            updateDrawableAttrs((RoundedDrawable)mDrawable);
        } else
        {
            mDrawable = null;
        }
        super.setImageDrawable(mDrawable);
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (drawable != null)
        {
            mDrawable = RoundedDrawable.a(drawable, mCornerRadius, mBorderWidth, mBorderColor);
            updateDrawableAttrs((RoundedDrawable)mDrawable);
        } else
        {
            mDrawable = null;
        }
        super.setImageDrawable(mDrawable);
    }

    public void setImageResource(int i)
    {
        super.setImageResource(i);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean flag)
    {
        mOval = flag;
        if (mDrawable instanceof RoundedDrawable)
        {
            ((RoundedDrawable)mDrawable).a(flag);
        }
        if (mRoundBackground && (mBackgroundDrawable instanceof RoundedDrawable))
        {
            ((RoundedDrawable)mBackgroundDrawable).a(flag);
        }
        invalidate();
    }

    public void setRoundBackground(boolean flag)
    {
        if (mRoundBackground == flag)
        {
            return;
        }
        mRoundBackground = flag;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mBackgroundDrawable instanceof RoundedDrawable)
        {
            updateDrawableAttrs((RoundedDrawable)mBackgroundDrawable);
        } else
        {
            setBackgroundDrawable(mBackgroundDrawable);
        }
_L4:
        invalidate();
        return;
_L2:
        if (mBackgroundDrawable instanceof RoundedDrawable)
        {
            ((RoundedDrawable)mBackgroundDrawable).a(0);
            ((RoundedDrawable)mBackgroundDrawable).a(0.0F);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == null)
        {
            throw new NullPointerException();
        }
        if (mScaleType == scaletype) goto _L2; else goto _L1
_L1:
        mScaleType = scaletype;
        _cls1.a[scaletype.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 165
    //                   2 165
    //                   3 165
    //                   4 165
    //                   5 165
    //                   6 165
    //                   7 165;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        super.setScaleType(scaletype);
_L6:
        if ((mDrawable instanceof RoundedDrawable) && ((RoundedDrawable)mDrawable).a() != scaletype)
        {
            ((RoundedDrawable)mDrawable).a(scaletype);
        }
        if ((mBackgroundDrawable instanceof RoundedDrawable) && ((RoundedDrawable)mBackgroundDrawable).a() != scaletype)
        {
            ((RoundedDrawable)mBackgroundDrawable).a(scaletype);
        }
        setWillNotCacheDrawing(true);
        requestLayout();
        invalidate();
_L2:
        return;
_L4:
        super.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        sScaleTypeArray = (new android.widget.ImageView.ScaleType[] {
            android.widget.ImageView.ScaleType.MATRIX, android.widget.ImageView.ScaleType.FIT_XY, android.widget.ImageView.ScaleType.FIT_START, android.widget.ImageView.ScaleType.FIT_CENTER, android.widget.ImageView.ScaleType.FIT_END, android.widget.ImageView.ScaleType.CENTER, android.widget.ImageView.ScaleType.CENTER_CROP, android.widget.ImageView.ScaleType.CENTER_INSIDE
        });
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
                a[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 6;
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
