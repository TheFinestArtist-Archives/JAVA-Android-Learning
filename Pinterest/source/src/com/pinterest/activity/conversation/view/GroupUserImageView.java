// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.conversation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.pinterest.api.model.Conversation;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.network.image.ImageCache;
import java.util.Collections;
import java.util.List;

public class GroupUserImageView extends View
{

    private static final int MAX_IMAGES = 3;
    private static final String TAG = "GroupUserImageView";
    private Paint _bgPaint;
    private Bitmap _bitmaps[];
    private Paint _bmpPaint;
    private int _borderColor;
    private String _externalUserEmail;
    private Paint _ovalPaint;
    private Path _ovalPath;
    private Rect _srcRect;
    private Rect _textBounds;
    private Paint _textPaint;
    private List _urls;
    private Rect rects[];

    public GroupUserImageView(Context context)
    {
        this(context, null, 0);
    }

    public GroupUserImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GroupUserImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _bitmaps = new Bitmap[3];
        rects = new Rect[3];
        _srcRect = new Rect();
        _textBounds = new Rect();
        _ovalPath = new Path();
        _urls = Collections.emptyList();
        _borderColor = -1;
        init();
    }

    private void drawCharacter(Canvas canvas)
    {
        if (_externalUserEmail != null)
        {
            canvas.drawRect(rects[0], _bgPaint);
            int i = rects[0].centerX();
            int j = (int)((float)rects[0].centerY() + _textPaint.descent());
            canvas.drawText(_externalUserEmail.substring(0, 1), i, j, _textPaint);
        }
    }

    private void drawImage(Canvas canvas, Bitmap bitmap, Rect rect)
    {
label0:
        {
            if (rect != null && !rect.isEmpty())
            {
                if (bitmap == null)
                {
                    break label0;
                }
                _srcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                int i = _srcRect.width() - rect.width();
                int j = _srcRect.height() - rect.height();
                if (i > 0)
                {
                    Rect rect1 = _srcRect;
                    rect1.left = rect1.left + i / 2;
                    rect1 = _srcRect;
                    rect1.right = rect1.right - i / 2;
                }
                if (j > 0)
                {
                    Rect rect2 = _srcRect;
                    rect2.top = rect2.top + j / 2;
                    rect2 = _srcRect;
                    rect2.bottom = rect2.bottom - j / 2;
                }
                canvas.drawBitmap(bitmap, _srcRect, rect, _bmpPaint);
            }
            return;
        }
        canvas.drawRect(rect, _bgPaint);
    }

    private void prepareForReuse()
    {
        boolean flag = false;
        _urls.clear();
        _externalUserEmail = null;
        int i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= _bitmaps.length)
            {
                break;
            }
            _bitmaps[i] = null;
            i++;
        } while (true);
        for (; j < rects.length; j++)
        {
            rects[j].setEmpty();
        }

        _textBounds.setEmpty();
        requestLayout();
    }

    private void setBitmap(String s, Bitmap bitmap)
    {
        int j = Math.min(_urls.size(), 3);
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    if (!((String)_urls.get(i)).equals(s))
                    {
                        break label0;
                    }
                    _bitmaps[i] = bitmap;
                    postInvalidateDelayed(1L);
                }
                return;
            }
            i++;
        } while (true);
    }

    private void setImageUrls(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        _urls = list1;
        int j = Math.min(_urls.size(), 3);
        for (int i = 0; i < j; i++)
        {
            list = (String)_urls.get(i);
            ImageCache.loadImage(new GroupUserCacheableImage(list), list);
        }

    }

    public void init()
    {
        _bmpPaint = new Paint();
        _bmpPaint.setAntiAlias(true);
        _bmpPaint.setStyle(android.graphics.Paint.Style.FILL);
        _bgPaint = new Paint();
        _bgPaint.setColor(Resources.color(0x7f090043));
        _bgPaint.setAntiAlias(true);
        _bgPaint.setStyle(android.graphics.Paint.Style.FILL);
        _textPaint = new TextPaint();
        _textPaint.setColor(-1);
        _textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        _textPaint.setTextSize(Resources.dimension(0x7f0a0062));
        _textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        _ovalPaint = new Paint();
        _ovalPaint.setColor(_borderColor);
        _ovalPaint.setAntiAlias(true);
        _ovalPaint.setStyle(android.graphics.Paint.Style.FILL);
        for (int i = 0; i < rects.length; i++)
        {
            rects[i] = new Rect();
        }

        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        for (int i = 0; i < rects.length; i++)
        {
            drawImage(canvas, _bitmaps[i], rects[i]);
        }

        drawCharacter(canvas);
        canvas.drawPath(_ovalPath, _ovalPaint);
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        k = android.view.View.MeasureSpec.getSize(i);
        l = k / 2;
        if (_urls.size() > 1) goto _L2; else goto _L1
_L1:
        rects[0].set(0, 0, k, k);
_L4:
        if (_ovalPath.isEmpty())
        {
            _ovalPath.addRect(0.0F, 0.0F, k + 1, k, android.graphics.Path.Direction.CW);
            _ovalPath.addOval(new RectF(0.0F, 0.0F, k, k), android.graphics.Path.Direction.CW);
            _ovalPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        }
        super.onMeasure(i, j);
        setMeasuredDimension(k, k);
        return;
_L2:
        if (_urls.size() == 2)
        {
            rects[0].set(0, 0, l - 1, k);
            rects[1].set(l + 1, 0, k, k);
        } else
        if (_urls.size() > 2)
        {
            rects[0].set(0, 0, l - 1, k);
            rects[1].set(l + 1, 0, k, l - 1);
            rects[2].set(l + 1, l + 1, k, k);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setBorderColor(int i)
    {
        _borderColor = i;
        _ovalPaint.setColor(i);
        postInvalidate();
    }

    public void setConversation(Conversation conversation)
    {
        List list;
label0:
        {
            conversation.getUid();
            prepareForReuse();
            if (conversation != null)
            {
                list = conversation.getConversationImageUrls();
                if (list != null && !list.isEmpty())
                {
                    break label0;
                }
                conversation = conversation.getCachedEmailList();
                if (conversation != null && !conversation.isEmpty())
                {
                    _externalUserEmail = (String)conversation.get(0);
                }
            }
            return;
        }
        setImageUrls(list);
    }


    private class GroupUserCacheableImage
        implements CachableImage
    {

        private Object imageTag;
        private WeakReference parentView;
        private String url;

        public Object getImageTag()
        {
            return imageTag;
        }

        public boolean getIsLarge()
        {
            return false;
        }

        public Transformation getTransformation()
        {
            return null;
        }

        public String getUrl()
        {
            return url;
        }

        public void onBitmapFailed(Drawable drawable)
        {
        }

        public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
        {
            if (bitmap != null && parentView.get() != null)
            {
                ((GroupUserImageView)parentView.get()).setBitmap(url, bitmap);
            }
        }

        public void onPrepareLoad(Drawable drawable)
        {
        }

        public void setBitmap(Bitmap bitmap, boolean flag)
        {
        }

        public void setImageTag(Object obj)
        {
            imageTag = obj;
        }

        public void setIsLarge(boolean flag)
        {
        }

        public void setTransformation(Transformation transformation)
        {
        }

        public void setUrl(String s)
        {
            url = s;
        }

        public GroupUserCacheableImage(String s)
        {
            parentView = new WeakReference(GroupUserImageView.this);
            url = s;
        }
    }

}
