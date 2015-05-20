// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import android.widget.TextView;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonArray;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class this._cls0 extends ApiResponseHandler
{

    final AccountSettingsFragment this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        if (_notifTv != null)
        {
            if ((apiresponse = ((ApiResponse) (apiresponse.getData()))) instanceof PinterestJsonArray)
            {
                AccountSettingsFragment.access$1402(AccountSettingsFragment.this, (PinterestJsonArray)apiresponse);
                if (AccountSettingsFragment.access$1400(AccountSettingsFragment.this).a() != 0)
                {
                    _notifTv.setVisibility(0);
                    AccountSettingsFragment.access$1500(AccountSettingsFragment.this);
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = AccountSettingsFragment.this;
        super();
    }
}
