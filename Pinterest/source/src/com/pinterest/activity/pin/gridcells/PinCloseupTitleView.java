// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.PinMetadata;
import com.pinterest.api.model.Place;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.imageview.WebImageView;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView

public class PinCloseupTitleView extends PinCloseupSubView
{

    private WebImageView _attrIconIv;
    private String _attrIconUrl;
    private CharSequence _attrTitleText;
    private TextView _attrTitleTv;
    private LinearLayout _attrWrapper;
    private String _titleText;
    private TextView _titleTv;

    public PinCloseupTitleView(Context context)
    {
        super(context);
    }

    private boolean updateAttrIconUrl()
    {
        String s = null;
        boolean flag;
        if (_pin.hasAttribution())
        {
            s = _pin.getAttrProviderIconUrl();
        } else
        if (_pinMetadata != null)
        {
            s = _pinMetadata.getImageUrl();
        } else
        if (StringUtils.isNotBlank(_pin.getRichSiteName()))
        {
            s = _pin.getRichIcon();
        } else
        if (_pin.getHasPlace() == Boolean.TRUE)
        {
            s = _pin.getPlace().getSourceIcon();
        }
        if (!StringUtils.equals(_attrIconUrl, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _attrIconUrl = s;
        return flag;
    }

    private boolean updateAttrTitleText()
    {
        Object obj = null;
        boolean flag;
        if (_pin.hasAttribution())
        {
            obj = _pin.getAttributionHtml();
        } else
        if (_pinMetadata != null)
        {
            obj = StringUtils.defaultString(_pinMetadata.getWebsiteName(), _pin.getDomain());
        } else
        if (StringUtils.isNotBlank(_pin.getRichSiteName()))
        {
            obj = StringUtils.defaultString(_pin.getRichSiteName(), _pin.getDomain());
        } else
        if (_pin.getHasPlace() == Boolean.TRUE)
        {
            obj = _pin.getPlace().getSourceName();
        }
        if (!StringUtils.equals(_attrTitleText, ((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _attrTitleText = ((CharSequence) (obj));
        return flag;
    }

    private boolean updateTitleText()
    {
        String s = null;
        boolean flag;
        if (_pinMetadata != null && StringUtils.isNotBlank(_pinMetadata.getTitle()))
        {
            s = _pinMetadata.getTitle();
        } else
        if (StringUtils.isNotBlank(_pin.getRichTitle()))
        {
            s = _pin.getRichTitle();
        } else
        if (_pinPlace != null)
        {
            s = _pin.getPlace().getName();
        }
        if (!StringUtils.equals(_titleText, s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _titleText = s;
        return flag;
    }

    protected void init()
    {
        _padding.left = Constants.MARGIN;
        _padding.top = Constants.MARGIN_HALF;
        _padding.right = Constants.MARGIN;
        _padding.bottom = Constants.MARGIN_HALF;
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        setOrientation(1);
        _attrWrapper = new LinearLayout(getContext());
        _attrWrapper.setOrientation(0);
        _attrWrapper.setVisibility(8);
        addView(_attrWrapper, -1, -2);
        int i = (int)Device.dpToPixel(16F);
        _attrIconIv = new WebImageView(getContext());
        _attrIconIv.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        _attrWrapper.addView(_attrIconIv, i, i);
        _attrTitleTv = new TextView(getContext(), null, 0x7f0f01a7);
        _attrTitleTv.setTextSize(0, Resources.dimension(0x7f0a00f6));
        _attrTitleTv.setPadding(Constants.MARGIN_HALF, 0, 0, 0);
        _attrWrapper.addView(_attrTitleTv, -1, -2);
        _titleTv = new TextView(getContext(), null, 0x7f0f0176);
        _titleTv.setTypeface(null, 1);
        _titleTv.setTextSize(0, Resources.dimension(0x7f0a00fa));
        _titleTv.setVisibility(8);
        addView(_titleTv, -1, -2);
    }

    protected boolean shouldUpdateView()
    {
        return BooleanUtils.or(new boolean[] {
            updateAttrIconUrl(), updateAttrTitleText(), updateTitleText()
        });
    }

    protected void updateView()
    {
        if (ModelHelper.isValid(_attrTitleText))
        {
            _attrIconIv.loadUrl(_attrIconUrl);
            _attrTitleTv.setText(_attrTitleText);
            _attrWrapper.setVisibility(0);
        } else
        {
            _attrWrapper.setVisibility(8);
        }
        if (ModelHelper.isValid(_titleText))
        {
            _titleTv.setText(_titleText);
            _titleTv.setVisibility(0);
            return;
        } else
        {
            _titleTv.setVisibility(8);
            return;
        }
    }
}
