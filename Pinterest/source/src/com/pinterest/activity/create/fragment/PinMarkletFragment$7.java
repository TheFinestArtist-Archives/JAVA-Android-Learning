// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.log.PLog;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls0 extends ApiResponseHandler
{

    final PinMarkletFragment this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        PLog.a((new StringBuilder("checkUrlResponse: ")).append(apiresponse).toString(), new Object[0]);
        if (getView() != null && getActivity() != null)
        {
            apiresponse = ((PinterestJsonObject)apiresponse.getData()).a("action", "");
            if ("ALLOW".equals(apiresponse))
            {
                PinMarkletFragment.access$1302(PinMarkletFragment.this, Boolean.TRUE);
                PinMarkletFragment.access$1200(PinMarkletFragment.this);
            } else
            if ("BLOCK".equals(apiresponse) || "WARN".equals(apiresponse))
            {
                PinMarkletFragment.access$1302(PinMarkletFragment.this, Boolean.FALSE);
                hideWaitDialog();
                PinMarkletFragment.access$1400(PinMarkletFragment.this);
                return;
            }
        }
    }

    A(boolean flag)
    {
        this$0 = PinMarkletFragment.this;
        super(flag);
    }
}
