// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.kit.utils.FontUtils;

public class PTextView extends TextView
{

    private int _iconTint;
    private com.pinterest.kit.utils.FontUtils.TypefaceId _typefaceId;

    public PTextView(Context context)
    {
        super(context);
        _typefaceId = com.pinterest.kit.utils.FontUtils.TypefaceId.REGULAR;
        _iconTint = 0x7f090043;
        init();
    }

    public PTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _typefaceId = com.pinterest.kit.utils.FontUtils.TypefaceId.REGULAR;
        _iconTint = 0x7f090043;
        init();
    }

    public PTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _typefaceId = com.pinterest.kit.utils.FontUtils.TypefaceId.REGULAR;
        _iconTint = 0x7f090043;
        init();
    }

    private void updateCompoundDrawables()
    {
        Drawable adrawable[] = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(adrawable[0], adrawable[1], adrawable[2], adrawable[3]);
    }

    public com.pinterest.kit.utils.FontUtils.TypefaceId getTypefaceId()
    {
        return _typefaceId;
    }

    protected void init()
    {
        FontUtils.setFont(_typefaceId, this);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3)
    {
        super.setCompoundDrawablesWithIntrinsicBounds(DrawableUtils.tintIcon(drawable, _iconTint), DrawableUtils.tintIcon(drawable1, _iconTint), DrawableUtils.tintIcon(drawable2, _iconTint), DrawableUtils.tintIcon(drawable3, _iconTint));
    }

    public void setIconTint(int i)
    {
        _iconTint = i;
        updateCompoundDrawables();
    }

    public void setTypefaceId(com.pinterest.kit.utils.FontUtils.TypefaceId typefaceid)
    {
        _typefaceId = typefaceid;
        FontUtils.setFont(typefaceid, this);
    }
}
