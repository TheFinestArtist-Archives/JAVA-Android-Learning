// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.widget.TextView;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.kit.utils.LocaleUtils;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0 extends ApiResponseHandler
{

    final AccountSettingsFragment this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        apiresponse = (PinterestJsonObject)apiresponse.getData();
        String s = LocaleUtils.getCountryFromCode(apiresponse.a("country", ""));
        if (_country != null)
        {
            _country.setText(s);
        }
        User user = MyUser.get();
        if (user == null)
        {
            return;
        } else
        {
            user.setPersonalizeFromOffsiteBrowsing(apiresponse.a("personalize_from_offsite_browsing"));
            user.setAdsCustomizeFromConversion(apiresponse.a("ads_customize_from_conversion"));
            user.setExcludeFromSearch(apiresponse.a("exclude_from_search"));
            user.setHideFromNews(apiresponse.a("hide_from_news"));
            LocaleUtils.saveLocale(LocaleUtils.getLang(), s);
            MyUser.saveUserSettingsMe(apiresponse);
            return;
        }
    }

    ()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
