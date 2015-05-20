// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.contacts;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.base.Application;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.contacts:
//            UploadContactsUtil

final class loadContactsCancelledEvent extends ApiResponseHandler
{

    public final void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        UploadContactsUtil.unsetAccountsStoredContacts();
        Events.post(new loadContactsCancelledEvent());
    }

    public final void onSuccess(ApiResponse apiresponse)
    {
        Application.showToast(0x7f0e011c);
    }

    loadContactsCancelledEvent(boolean flag)
    {
        super(flag);
    }
}
