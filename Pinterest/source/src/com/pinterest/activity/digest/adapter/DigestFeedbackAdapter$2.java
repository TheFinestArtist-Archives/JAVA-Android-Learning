// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.digest.adapter:
//            DigestFeedbackAdapter

class val.userId extends ApiResponseHandler
{

    final DigestFeedbackAdapter this$0;
    final String val$userId;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        throwable = ModelHelper.getUser(val$userId);
        if (throwable != null)
        {
            boolean flag;
            if (!throwable.getFollowing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            throwable.setFollowing(flag);
            ModelHelper.updateUser(throwable);
        }
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        Pinalytics.a(EventType.USER_UNFOLLOW, val$userId);
    }

    ()
    {
        this$0 = final_digestfeedbackadapter;
        val$userId = String.this;
        super();
    }
}
