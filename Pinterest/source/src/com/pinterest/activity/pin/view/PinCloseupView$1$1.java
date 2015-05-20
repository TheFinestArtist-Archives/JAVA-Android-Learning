// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import com.pinterest.activity.pin.fragment.PinSwipeFragment;
import com.pinterest.education.EducationHelper;
import com.pinterest.schemas.experiences.Placement;

class esponseHandler extends com.pinterest.api.remote.rienceResponseHandler
{

    final _PIN_CLOSEUP_TAKEOVER this$1;

    public void onSuccess()
    {
        PinSwipeFragment.setEduRunnable(EducationHelper.a(Placement.ANDROID_PIN_CLOSEUP_TAKEOVER));
    }

    t()
    {
        this$1 = this._cls1.this;
        super();
    }
}
