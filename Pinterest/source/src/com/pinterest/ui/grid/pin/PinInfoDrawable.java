// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.pin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.view.View;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.Place;
import com.pinterest.base.Colors;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.ui.grid.CachableRoundedBitmap;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.ui.grid.pin:
//            PinCellDrawable

public class PinInfoDrawable extends PinCellDrawable
{

    public static final int ICON_PADDING = (int)Resources.dimension(0x7f0a00b4);
    public static final int MAX_DESCRIPTION_LINES = Resources.integer(0x7f0c0018).intValue();
    private boolean _renderLargePin;
    private boolean _renderSocial;
    private String commentCount;
    private Bitmap commentIcon;
    private LimitedLayout descLayout;
    private TextPaint descPaint;
    private float descSize;
    private String description;
    private boolean hasCounts;
    private boolean hasDescription;
    private boolean hasPlaceData;
    private boolean hasRichData;
    private int iconRowOffset;
    private String likeCount;
    private Bitmap likeIcon;
    private TextPaint metaPaint;
    private float metaSize;
    private String repinCount;
    private Bitmap repinIcon;
    private CachableRoundedBitmap siteIcon;
    private String siteName;

    public PinInfoDrawable(View view)
    {
        description = "";
        _renderSocial = true;
        _renderLargePin = false;
        repinIcon = ((BitmapDrawable)Resources.drawable(0x7f020141)).getBitmap();
        likeIcon = ((BitmapDrawable)Resources.drawable(0x7f020127)).getBitmap();
        commentIcon = ((BitmapDrawable)Resources.drawable(0x7f0200f9)).getBitmap();
        iconRowOffset = likeIcon.getHeight() + DP4;
        descSize = Resources.dimension(0x7f0a00f9);
        descPaint = new TextPaint(1);
        descPaint.setColor(Colors.TEXT_DARK);
        descPaint.setTextSize(descSize);
        descPaint.setStyle(android.graphics.Paint.Style.FILL);
        descPaint.setTypeface(Typeface.DEFAULT);
        metaSize = Resources.dimension(0x7f0a00f9);
        metaPaint = new TextPaint(1);
        metaPaint.setColor(Colors.TEXT_LIGHT);
        metaPaint.setTextSize(metaSize);
        metaPaint.setStyle(android.graphics.Paint.Style.FILL);
        metaPaint.setTypeface(Typeface.DEFAULT);
        siteIcon = new CachableRoundedBitmap(view);
    }

    private void updateDescriptionLayout(String s)
    {
        do
        {
            if (_renderLargePin)
            {
                descSize = Resources.dimension(0x7f0a00f4);
            } else
            {
                descSize = Resources.dimension(0x7f0a00f9);
            }
            descPaint.setTextSize(descSize);
            descLayout = new LimitedLayout(s, descPaint, Math.max(50, width - padding.left - padding.right), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, Math.round((double)descSize * 0.33000000000000002D), false);
            if (descLayout.getActualLineCount() > descLayout.getLineCount())
            {
                description = description.substring(0, descLayout.getLineStart(descLayout.getLineCount()) - 3);
                description = StringUtils.removeEnd(description, ".");
                description = StringUtils.removeEnd(description, ",");
                description = StringUtils.removeEnd(description, " ");
                description = (new StringBuilder()).append(description).append("\u2026").toString();
                s = description;
            } else
            {
                return;
            }
        } while (true);
    }

    public void draw(Canvas canvas)
    {
label0:
        {
            int k = y;
            int i = k;
            if (hasDescription)
            {
                i = k + padding.top;
                canvas.save();
                canvas.translate(padding.left, i);
                descLayout.draw(canvas);
                canvas.restore();
                i += descLayout.getHeight();
            }
            if (!hasRichData)
            {
                k = i;
                if (!hasPlaceData)
                {
                    break label0;
                }
            }
            int l = padding.left;
            int j1;
            if (hasDescription)
            {
                k = ICON_PADDING;
            } else
            {
                k = padding.top;
            }
            i += k;
            k = iconRowOffset + ICON_PADDING + l;
            if (siteIcon.bitmap != null)
            {
                sharedMatrix.reset();
                float f = (float)DP11 / (float)siteIcon.bitmap.getWidth();
                sharedMatrix.postScale(f, f, 0.0F, 0.0F);
                sharedMatrix.postTranslate(padding.left, i);
                canvas.drawBitmap(siteIcon.bitmap, sharedMatrix, blankPaint);
            }
            canvas.drawText(ellipsize(siteName, metaPaint, width - ((padding.left + k) - DP1)), k, ((float)i + metaSize) - (float)DP1, metaPaint);
            k = i + iconRowOffset;
        }
        if (hasCounts && _renderSocial)
        {
            int i1 = padding.left;
            int j;
            if (hasDescription || hasRichData || hasPlaceData)
            {
                j = ICON_PADDING;
            } else
            {
                j = padding.top;
            }
            j1 = (k + j) - DP1;
            if (repinCount != null)
            {
                canvas.drawBitmap(repinIcon, i1, DP2 + j1, iconPaint);
                j = repinIcon.getWidth() + ICON_PADDING + i1;
                canvas.drawText(repinCount, j, (float)j1 + metaSize, metaPaint);
                j = (int)((float)j + (metaPaint.measureText(repinCount) + (float)PADDING_IMAGE));
            } else
            {
                j = i1;
            }
            k = j;
            if (likeCount != null)
            {
                canvas.drawBitmap(likeIcon, j, DP2 + j1, iconPaint);
                j += likeIcon.getWidth() + ICON_PADDING;
                canvas.drawText(likeCount, j, (float)j1 + metaSize, metaPaint);
                k = (int)((float)j + (metaPaint.measureText(likeCount) + (float)PADDING_IMAGE));
            }
            if (commentCount != null)
            {
                canvas.drawBitmap(commentIcon, k, DP2 + j1, iconPaint);
                j = commentIcon.getWidth();
                i1 = ICON_PADDING;
                canvas.drawText(commentCount, k + (j + i1), (float)j1 + metaSize, metaPaint);
                metaPaint.measureText(commentCount);
            }
        }
    }

    public void loadSiteIcon(String s)
    {
        if (siteIcon.bitmap == null || !siteIcon.getUrl().equals(s))
        {
            ImageCache.loadImage(siteIcon, s);
        }
    }

    public void measure()
    {
        int l;
label0:
        {
            updateDescriptionLayout(description);
            int i = 0;
            if (hasDescription)
            {
                int k = descLayout.getHeight() + 0;
                i = k;
                if (!hasCounts)
                {
                    i = k;
                    if (!hasRichData)
                    {
                        i = k;
                        if (!hasPlaceData)
                        {
                            i = k - DP2;
                        }
                    }
                }
            }
            if (!hasRichData)
            {
                l = i;
                if (!hasPlaceData)
                {
                    break label0;
                }
            }
            l = i;
            if (hasDescription)
            {
                l = i + ICON_PADDING;
            }
            l += iconRowOffset;
        }
        int j;
label1:
        {
label2:
            {
                j = l;
                if (!hasCounts)
                {
                    break label1;
                }
                j = l;
                if (!_renderSocial)
                {
                    break label1;
                }
                if (!hasDescription && !hasRichData)
                {
                    j = l;
                    if (!hasPlaceData)
                    {
                        break label2;
                    }
                }
                j = l + ICON_PADDING;
            }
            j += iconRowOffset;
        }
        l = j;
        if (j != 0)
        {
            l = j + (padding.top + padding.bottom);
        }
        setHeight(l);
    }

    public void prepareForReuse()
    {
        super.prepareForReuse();
        siteIcon.bitmap = null;
    }

    public void setPin(Pin pin)
    {
        Object obj = null;
        if (pin == null)
        {
            return;
        }
        String s;
        boolean flag;
        if (pin.getLikeCountDisplay() != 0)
        {
            s = String.valueOf(pin.getLikeCountDisplay());
        } else
        {
            s = null;
        }
        likeCount = s;
        if (pin.getRepinCountDisplay() != 0)
        {
            s = String.valueOf(pin.getRepinCountDisplay());
        } else
        {
            s = null;
        }
        repinCount = s;
        s = obj;
        if (pin.getCommentCountDisplay() != 0)
        {
            s = String.valueOf(pin.getCommentCountDisplay());
        }
        commentCount = s;
        if (likeCount != null || repinCount != null || commentCount != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasCounts = flag;
        hasPlaceData = pin.hasPlaceGridData();
        if (hasPlaceData)
        {
            siteName = pin.getPlace().getSourceName();
        }
        hasRichData = pin.hasRichPinGridData();
        if (hasRichData)
        {
            siteName = pin.getRichSiteName();
        }
        hasDescription = StringUtils.isNotEmpty(pin.getCleanDescription());
        description = StringUtils.defaultString(pin.getDescription());
        updateDescriptionLayout(description);
    }

    public void setRenderLargePin(boolean flag)
    {
        _renderLargePin = flag;
    }

    public void setRenderSocial(boolean flag)
    {
        _renderSocial = flag;
    }


    private class LimitedLayout extends StaticLayout
    {

        public int getActualLineCount()
        {
            return super.getLineCount();
        }

        public int getLineCount()
        {
            int j = super.getLineCount();
            int i = j;
            if (j >= PinInfoDrawable.MAX_DESCRIPTION_LINES)
            {
                i = PinInfoDrawable.MAX_DESCRIPTION_LINES;
            }
            return i;
        }

        public LimitedLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, android.text.Layout.Alignment alignment, float f, 
                float f1, boolean flag)
        {
            super(charsequence, i, j, textpaint, k, alignment, f, f1, flag);
        }

        public LimitedLayout(CharSequence charsequence, int i, int j, TextPaint textpaint, int k, android.text.Layout.Alignment alignment, float f, 
                float f1, boolean flag, android.text.TextUtils.TruncateAt truncateat, int l)
        {
            super(charsequence, i, j, textpaint, k, alignment, f, f1, flag, truncateat, l);
        }

        public LimitedLayout(CharSequence charsequence, TextPaint textpaint, int i, android.text.Layout.Alignment alignment, float f, float f1, boolean flag)
        {
            super(charsequence, textpaint, i, alignment, f, f1, flag);
        }
    }

}
