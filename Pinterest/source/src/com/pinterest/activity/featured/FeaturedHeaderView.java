// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.pinterest.api.model.User;
import com.pinterest.base.Colors;
import com.pinterest.ui.grid.user.UserGridCell;
import com.pinterest.ui.imageview.NonRoundWebImageView;
import com.pinterest.ui.text.PTextView;

public class FeaturedHeaderView extends FrameLayout
{

    private static final String TEMP_HEADER_URL = "http://media-cache-cd0.pinimg.com/600x/96/28/6c/96286c3e3f5b5f4f205384af546149e2.jpg";
    private int _dominantColor;
    NonRoundWebImageView _image;
    private int _imageSize;
    PTextView _subTitle;
    PTextView _title;
    UserGridCell _userCell;

    public FeaturedHeaderView(Context context)
    {
        this(context, null);
    }

    public FeaturedHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _dominantColor = Colors.LIGHT_GRAY;
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f030123, this);
        ButterKnife.a(this);
    }

    private void updateView()
    {
        _image.setBackgroundColor(_dominantColor);
        _image.loadUrl("http://media-cache-cd0.pinimg.com/600x/96/28/6c/96286c3e3f5b5f4f205384af546149e2.jpg");
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        updateView();
    }

    public void setUser(User user)
    {
        _userCell.setUser(user, false);
    }
}
