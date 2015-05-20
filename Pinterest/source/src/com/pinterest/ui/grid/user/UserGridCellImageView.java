// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.pinterest.api.model.User;
import com.pinterest.kit.network.image.ImageCache;
import com.pinterest.ui.grid.CachableRoundedBitmap;
import java.util.ArrayList;
import java.util.List;

public class UserGridCellImageView extends View
{

    private static final int NUM_SUB_IMAGES = 4;
    private List _cellImgs;
    private int _coverHeight;
    private CachableRoundedBitmap _coverImg;
    private int _coverWidth;
    private int _iconPadding;
    private int _iconSize;
    private User _user;

    public UserGridCellImageView(Context context)
    {
        this(context, null);
    }

    public UserGridCellImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public UserGridCellImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void drawCover(Canvas canvas)
    {
        _coverImg.draw(canvas, 0.0F, 0.0F, _coverWidth, _coverHeight);
    }

    private void drawIcons(Canvas canvas)
    {
        boolean flag = false;
        int k = _coverWidth + _iconPadding;
        for (int i = 0; i < 2; i++)
        {
            ((CachableRoundedBitmap)_cellImgs.get(i)).draw(canvas, (_iconSize + _iconPadding) * i + k, 0.0F, _iconSize, _iconSize);
        }

        int l = _iconSize;
        int i1 = _iconPadding;
        for (int j = ((flag) ? 1 : 0); j < 2; j++)
        {
            ((CachableRoundedBitmap)_cellImgs.get(j + 2)).draw(canvas, (_iconSize + _iconPadding) * j + k, l + i1, _iconSize, _iconSize);
        }

    }

    private void init()
    {
        _coverImg = new CachableRoundedBitmap(this);
        _cellImgs = new ArrayList();
        for (int i = 0; i < 4; i++)
        {
            _cellImgs.add(new CachableRoundedBitmap(this));
        }

        _iconPadding = getResources().getDimensionPixelSize(0x7f0a0033);
    }

    private void loadImages()
    {
        ImageCache.loadImage(_coverImg, _user.getImageMediumUrl());
        List list = _user.getPinThumbnailsList();
        int i = 0;
        while (i < _cellImgs.size()) 
        {
            CachableRoundedBitmap cachableroundedbitmap = (CachableRoundedBitmap)_cellImgs.get(i);
            if (i < list.size())
            {
                ImageCache.loadImage(cachableroundedbitmap, (String)list.get(i));
            } else
            {
                cachableroundedbitmap.setUrl("");
                cachableroundedbitmap.setBitmap(null, true);
            }
            i++;
        }
    }

    public User getUser()
    {
        return _user;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawCover(canvas);
        drawIcons(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        _coverWidth = (k - _iconPadding) / 2;
        _coverHeight = _coverWidth;
        int l = _coverHeight;
        _iconSize = (_coverWidth - _iconPadding) / 2;
        super.onMeasure(i, j);
        setMeasuredDimension(k, l + 0);
    }

    public void prepareForReuse()
    {
        ImageCache.clean(_coverImg);
        _coverImg.setBitmap(null, false);
        _coverImg.setUrl(null);
        for (int i = 0; i < _cellImgs.size(); i++)
        {
            CachableRoundedBitmap cachableroundedbitmap = (CachableRoundedBitmap)_cellImgs.get(i);
            ImageCache.clean(cachableroundedbitmap);
            cachableroundedbitmap.setBitmap(null, false);
            cachableroundedbitmap.setUrl(null);
        }

        invalidate();
    }

    public void setUser(User user, boolean flag)
    {
        boolean flag1;
        if (_user != null && _user.equals(user))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        _user = user;
        if (user != null && !flag && !flag1)
        {
            prepareForReuse();
            loadImages();
        }
    }
}
