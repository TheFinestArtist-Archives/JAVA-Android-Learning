// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.pinterest.activity.pin.gridcells.old.details.PinCloseupView;
import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.education.EducationHelper;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.experiences.Experience;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupSubView, PinCloseupClickThroughView

public class PinCloseupImageView extends PinCloseupSubView
    implements android.view.View.OnClickListener
{

    private PinCloseupView _imageVw;

    public PinCloseupImageView(Context context)
    {
        super(context);
    }

    protected void init()
    {
        _padding.bottom = Constants.MARGIN_HALF;
    }

    protected void initView()
    {
        setBackgroundColor(Colors.WHITE);
        removeAllViews();
        _imageVw = new PinCloseupView(getContext());
        _imageVw.setOnPinClickListener(this);
        addView(_imageVw, -1, -2);
    }

    public void onClick(View view)
    {
        String s = _pin.getClickThroughUrl();
        Pinalytics.a(ElementType.PIN_SOURCE_IMAGE, ComponentType.MODAL_PIN, _pin.getUid(), _pin.getLoggingAuxData());
        StopWatch.get().start("clickthrough_verify");
        PinCloseupClickThroughView.gotoPinLink(view.getContext(), s, _pin, _apiTag);
        int i = EducationHelper.b();
        if (i == Experience.ANDROID_CLICKTHROUGH_ED.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_TABLET.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER_TABLET.getValue())
        {
            Events.post(new EducationEvent(com.pinterest.activity.task.education.event.EducationEvent.Type.NEXT));
        }
    }

    protected void onDetachedFromWindow()
    {
        _imageVw.setOnPinClickListener(null);
        super.onDetachedFromWindow();
    }

    protected boolean shouldUpdateView()
    {
        return true;
    }

    protected void updateView()
    {
        _imageVw.setPin(_pin);
    }
}
