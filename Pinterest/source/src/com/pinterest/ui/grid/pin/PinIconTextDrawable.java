// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.pin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.webkit.URLUtil;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.ui.grid.CachableRoundedBitmap;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.ui.grid.pin:
//            PinCellDrawable

public class PinIconTextDrawable extends PinCellDrawable
{

    public static final Bitmap FEEDBACK_ICON = ((BitmapDrawable)Resources.drawable(0x7f020110)).getBitmap();
    private Bitmap icon;
    private CachableRoundedBitmap image;
    private View parent;
    private boolean renderfeedbackIcon;
    private boolean reverseOrder;
    private String subTitle;
    private String title;

    public PinIconTextDrawable(View view)
    {
        title = "";
        subTitle = "";
        reverseOrder = false;
        renderfeedbackIcon = false;
        parent = view;
        image = new CachableRoundedBitmap(view);
    }

    public void draw(Canvas canvas)
    {
        if (pressed)
        {
            canvas.drawRect(getBounds(), touchPaint);
        }
        int i1 = y + padding.top;
        int k = (int)((float)i1 + nameSize + (float)DP3);
        int j = (int)((float)i1 + nameSize * 2.0F + (float)DP4);
        int j1 = (ICON_IMAGE_SIZE + PADDING_IMAGE + padding.left) - DP1;
        int k1 = width;
        int l1 = PADDING_IMAGE;
        int i;
        int i2;
        int j2;
        if (renderfeedbackIcon && icon != null)
        {
            i = ICON_SIZE + padding.right + DP2;
        } else
        {
            i = 0;
        }
        i2 = width;
        j2 = PADDING_IMAGE;
        if (reverseOrder)
        {
            int l = k - DP2;
            k = j;
            j = l;
        }
        if (isOval())
        {
            image.draw(canvas, padding.left - DP2, i1 - DP2, ICON_IMAGE_SIZE + DP2, ICON_IMAGE_SIZE + DP2);
        } else
        {
            image.draw(canvas, padding.left, i1, ICON_IMAGE_SIZE, ICON_IMAGE_SIZE);
        }
        canvas.drawText(ellipsize(title, paintBold, k1 - l1 - j1), j1, k, paintBold);
        canvas.drawText(ellipsize(subTitle, paintLight, i2 - j2 - j1 - i), j1, j, paintLight);
        if (renderfeedbackIcon && icon != null)
        {
            canvas.drawBitmap(icon, width - i, (y + height) - padding.right - ICON_SIZE - 1, blankPaint);
        }
    }

    public Rect getIconBounds()
    {
        if (renderfeedbackIcon)
        {
            return new Rect(width - ICON_SIZE - padding.right - DP8, getBounds().top, getBounds().right, getBounds().bottom);
        } else
        {
            return new Rect();
        }
    }

    public boolean isOval()
    {
        return image.isOval();
    }

    public void loadImage(String s)
    {
        if (image.bitmap == null || !image.getUrl().equals(s))
        {
            if (URLUtil.isValidUrl(s))
            {
                ImageCache.loadImage(image, s);
            } else
            if (StringUtils.isNumeric(s))
            {
                image.setBitmap(BitmapFactory.decodeResource(parent.getResources(), Integer.parseInt(s)), false);
                return;
            }
        }
    }

    public void measure()
    {
        setHeight(padding.top + ICON_IMAGE_SIZE + DIVIDER_HEIGHT + padding.bottom);
    }

    public void prepareForReuse()
    {
        super.prepareForReuse();
        reverseOrder = false;
        image.bitmap = null;
        renderfeedbackIcon = false;
    }

    public void setIcon(Bitmap bitmap)
    {
        icon = bitmap;
    }

    public void setOval(boolean flag)
    {
        image.setOval(flag);
    }

    public void setReverseOrder(boolean flag)
    {
        reverseOrder = flag;
    }

    public void setSubTitle(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        subTitle = s1;
    }

    public void setTitle(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        title = s1;
    }

    public void showFeedbackIcon(boolean flag)
    {
        renderfeedbackIcon = flag;
    }

}
