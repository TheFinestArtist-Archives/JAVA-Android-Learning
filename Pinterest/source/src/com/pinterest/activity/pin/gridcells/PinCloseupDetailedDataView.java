// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.widget.TextView;
import com.pinterest.api.model.PinMetadata;
import com.pinterest.api.model.Place;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView, PinCloseupRichDataView

public class PinCloseupDetailedDataView extends PinCloseupSubView
{

    private CharSequence _metadataText;
    private TextView _metadataTv;
    private PinCloseupRichDataView _metadataVw;

    public PinCloseupDetailedDataView(Context context)
    {
        super(context);
    }

    private boolean updateMetadataText()
    {
        android.text.Spanned spanned = null;
        if (_pinMetadata != null)
        {
            spanned = _pinMetadata.getMetadataDisplay();
        }
        Object obj = spanned;
        if (spanned == null)
        {
            obj = spanned;
            if (_pinPlace != null)
            {
                obj = _pinPlace.getMetadataDisplay();
            }
        }
        boolean flag;
        if (!StringUtils.equals(_metadataText, ((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _metadataText = ((CharSequence) (obj));
        return flag;
    }

    protected void init()
    {
        _padding.left = Constants.MARGIN;
        _padding.right = Constants.MARGIN;
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        setOrientation(1);
        _metadataTv = new TextView(getContext(), null, 0x7f0f01a7);
        _metadataTv.setTextSize(0, Resources.dimension(0x7f0a00f6));
        _metadataTv.setVisibility(8);
        addView(_metadataTv, -1, -2);
        _metadataVw = new PinCloseupRichDataView(getContext());
        _metadataVw.setVisibility(8);
        addView(_metadataVw, -1, -2);
    }

    protected boolean shouldUpdateView()
    {
        return BooleanUtils.or(new boolean[] {
            updateMetadataText()
        });
    }

    protected void updateView()
    {
        boolean flag = false;
        PinCloseupRichDataView pincloseuprichdataview;
        if (StringUtils.isNotBlank(_metadataText))
        {
            _metadataTv.setText(_metadataText);
            _metadataTv.setVisibility(0);
        } else
        {
            _metadataTv.setVisibility(8);
        }
        _metadataVw.setPin(_pin);
        pincloseuprichdataview = _metadataVw;
        if (_pinMetadata != null)
        {
            flag = true;
        }
        ViewHelper.setVisibility(pincloseuprichdataview, flag);
    }
}
