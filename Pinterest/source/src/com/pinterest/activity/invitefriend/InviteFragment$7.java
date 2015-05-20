// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.res.Resources;
import android.text.Html;
import android.widget.TextView;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.ui.ViewHelper;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalData, InviteFragment

class this._cls0 extends ApiResponseHandler
{

    final InviteFragment this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        apiresponse = ((ApiResponse) (apiresponse.getData()));
        if (apiresponse instanceof PinterestJsonObject)
        {
            int i = ((PinterestJsonObject)apiresponse).a("remaining_quota", 0);
            PinvitationalData.setQuota(i);
            apiresponse = getResources().getQuantityString(0x7f0d0000, i);
            InviteFragment.access$800(InviteFragment.this).setText(Html.fromHtml(String.format(apiresponse, new Object[] {
                Integer.valueOf(i)
            })));
            ViewHelper.setVisibility(InviteFragment.access$800(InviteFragment.this), true);
        }
    }

    ()
    {
        this$0 = InviteFragment.this;
        super();
    }
}
