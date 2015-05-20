// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.data.DiskCache;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0 extends ApiResponseHandler
{

    final AccountSettingsFragment this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        DiskCache.setJsonObject("COUNTRIES", (PinterestJsonObject)apiresponse.getData());
        if (!AccountSettingsFragment.access$2200(AccountSettingsFragment.this))
        {
            AccountSettingsFragment.access$700(AccountSettingsFragment.this);
        }
    }

    ()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
