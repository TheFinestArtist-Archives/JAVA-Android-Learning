// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.MyUser;

// Referenced classes of package com.pinterest.api.remote:
//            AnalyticsApi

public class  extends ApiResponseHandler
{

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        onTokenFail();
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        AnalyticsApi.a("login");
        apiresponse = (PinterestJsonObject)apiresponse.getData();
        if (apiresponse == null)
        {
            try
            {
                onFailure(new Throwable(""), new PinterestJsonObject());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ApiResponse apiresponse)
            {
                onFailure(new Throwable(""), new PinterestJsonObject());
            }
            break MISSING_BLOCK_LABEL_80;
        }
        MyUser.setAccessToken(apiresponse.a("access_token", ""));
        onTokenSaved();
        return;
    }

    public void onTokenFail()
    {
    }

    public void onTokenSaved()
    {
    }

    public ()
    {
    }

    public (boolean flag)
    {
        super(flag);
    }
}
