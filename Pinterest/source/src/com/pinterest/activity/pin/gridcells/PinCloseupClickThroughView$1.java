// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.gridcells;

import android.view.View;
import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.experiences.Experience;

// Referenced classes of package com.pinterest.activity.pin.gridcells:
//            PinCloseupClickThroughView

class this._cls0
    implements android.view.oseupClickThroughView._cls1
{

    final PinCloseupClickThroughView this$0;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.WEBSITE_BUTTON, ComponentType.MODAL_PIN, _pin.getUid(), _pin.getLoggingAuxData());
        PinCloseupClickThroughView.gotoPinLink(getContext(), PinCloseupClickThroughView.access$000(PinCloseupClickThroughView.this), _pin, _apiTag);
        int i = EducationHelper.b();
        if (i == Experience.ANDROID_CLICKTHROUGH_ED.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_TABLET.getValue() || i == Experience.ANDROID_CLICKTHROUGH_ED_HELPER_TABLET.getValue())
        {
            Events.post(new EducationEvent(com.pinterest.activity.task.education.event.ER_TABLET));
        }
    }

    ()
    {
        this$0 = PinCloseupClickThroughView.this;
        super();
    }
}
