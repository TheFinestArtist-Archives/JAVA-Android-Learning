// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0 extends ApiResponseHandler
{

    final AccountSettingsFragment this$0;

    public void onFinish()
    {
        super.onFinish();
        AccountSettingsFragment.access$2000(AccountSettingsFragment.this);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        Pinalytics.a(EventType.USER_DISABLE_TWITTER, "0");
        Preferences.user().set("PREF_CONNETED_TWITTER", false);
    }

    (boolean flag)
    {
        this$0 = AccountSettingsFragment.this;
        super(flag);
    }
}
