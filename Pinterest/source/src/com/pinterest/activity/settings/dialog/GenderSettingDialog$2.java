// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings.dialog;

import com.pinterest.activity.task.dialog.LoadingDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.User;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.EventType;
import java.util.HashMap;

// Referenced classes of package com.pinterest.activity.settings.dialog:
//            GenderSettingDialog

class  extends com.pinterest.api.remote.esponse
{

    final GenderSettingDialog this$0;
    final String val$gender;
    final User val$me;
    final String val$oldGender;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        val$me.setGender(val$oldGender);
        Events.post(new DialogEvent(null));
    }

    public void onStart()
    {
        super.onStart();
        Events.post(new DialogEvent(new LoadingDialog()));
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        apiresponse = new HashMap();
        apiresponse.put("label", val$gender);
        Pinalytics.a(EventType.USER_GENDER_CHANGED, null, apiresponse);
        Application.showToastShort(0x7f0e01bc);
        Events.post(new DialogEvent(null));
    }

    ()
    {
        this$0 = final_gendersettingdialog;
        val$gender = s;
        val$me = user;
        val$oldGender = String.this;
        super();
    }
}
