// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.pinterest.activity.pin.view.PinCloseupView;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinMetadata;
import com.pinterest.api.model.Place;

public abstract class PinCloseupSubView extends LinearLayout
{

    protected String _apiTag;
    protected Rect _padding;
    protected Pin _pin;
    protected PinMetadata _pinMetadata;
    protected Place _pinPlace;
    protected String _pinUid;

    public PinCloseupSubView(Context context)
    {
        this(context, null);
    }

    public PinCloseupSubView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PinCloseupSubView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _padding = new Rect();
        init();
        initView();
    }

    private void updateViewInternal()
    {
        setPadding(_padding.left, _padding.top, _padding.right, _padding.bottom);
    }

    protected FragmentManager getFragmentManager()
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent instanceof PinCloseupView)
        {
            return ((PinCloseupView)viewparent).getFragmentManager();
        } else
        {
            return null;
        }
    }

    protected void init()
    {
    }

    protected void initView()
    {
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void setPin(Pin pin)
    {
        _pin = pin;
        if (_pin != null)
        {
            _pinUid = _pin.getUid();
            _pinMetadata = _pin.getMetadata();
            _pinPlace = _pin.getPlace();
            if (shouldUpdateView())
            {
                updateViewInternal();
                updateView();
                return;
            }
        }
    }

    protected abstract boolean shouldUpdateView();

    protected void updateView()
    {
    }
}
