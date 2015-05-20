// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.api.model.SearchFilter;
import com.pinterest.base.Colors;

public class GuidedSearchTokenView extends LinearLayout
{

    private static final String DEFAULT_COLOR = "#545454";
    private int _dominantColor;
    private boolean _isFront;
    private String _query;
    ImageView _removeToken;
    private SearchFilter _searchFilter;
    ImageView _tokenIcon;
    LinearLayout _tokenLayout;
    LinearLayout _tokenNameWrapper;
    TextView _tokenText;

    public GuidedSearchTokenView(Context context)
    {
        super(context);
        _dominantColor = 0;
    }

    public GuidedSearchTokenView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _dominantColor = 0;
    }

    public int getDominantColor()
    {
        return _dominantColor;
    }

    public String getQuery()
    {
        return _query;
    }

    public ImageView getRemoveToken()
    {
        return _removeToken;
    }

    public SearchFilter getSearchFilter()
    {
        return _searchFilter;
    }

    public LinearLayout getTokenNameWrapper()
    {
        return _tokenNameWrapper;
    }

    public TextView getTokenText()
    {
        return _tokenText;
    }

    public boolean isFront()
    {
        return _isFront;
    }

    protected void onFinishInflate()
    {
        ButterKnife.a(this);
        super.onFinishInflate();
    }

    public void setDominantColor(int i)
    {
        _dominantColor = i;
    }

    public void setFront(boolean flag)
    {
        _isFront = flag;
    }

    public void setQuery(String s)
    {
        _query = s;
    }

    public void setSearchFilter(SearchFilter searchfilter)
    {
        _searchFilter = searchfilter;
    }

    public void updateUI()
    {
        _tokenText.setText(_query);
        if (_dominantColor == 0)
        {
            _dominantColor = Color.parseColor("#545454");
        }
        if (Colors.isBright(_dominantColor))
        {
            _dominantColor = Colors.darker(_dominantColor, 0.20000000000000001D);
        }
        float f = getResources().getDimension(0x7f0a0069);
        ShapeDrawable shapedrawable = new ShapeDrawable(new RoundRectShape(new float[] {
            f, f, f, f, f, f, f, f
        }, null, null));
        shapedrawable.getPaint().setColor(_dominantColor);
        _tokenLayout.setBackgroundDrawable(shapedrawable);
        if (_searchFilter != null)
        {
            if (com.pinterest.api.model.SearchFilter.MODES.MAKE.getValue().equalsIgnoreCase(_searchFilter.getTypeValue()))
            {
                _tokenIcon.setImageResource(0x7f020152);
            } else
            if (com.pinterest.api.model.SearchFilter.MODES.SHOP.getValue().equalsIgnoreCase(_searchFilter.getTypeValue()))
            {
                _tokenIcon.setImageResource(0x7f020153);
                return;
            }
        }
    }
}
