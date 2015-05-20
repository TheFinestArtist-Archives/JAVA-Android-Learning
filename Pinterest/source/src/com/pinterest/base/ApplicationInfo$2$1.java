// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.base;

import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.kit.log.PLog;

class r extends BaseApiResponseHandler
{

    final er.set this$0;

    public void onSuccess(PinterestJsonObject pinterestjsonobject)
    {
        super.onSuccess(pinterestjsonobject);
        PLog.a("Report install successful", new Object[0]);
        AnalyticsApi.a("yozio_submit");
        Preferences.persisted().set("PREF_FIRST_LAUNCH", false);
    }

    er()
    {
        this$0 = this._cls0.this;
        super();
    }
}
