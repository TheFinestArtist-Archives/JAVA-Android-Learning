// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.interest.view;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Interest;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.interest.view:
//            FollowInterestButton

class this._cls0 extends ApiResponseHandler
{

    final FollowInterestButton this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        throwable = FollowInterestButton.access$000(FollowInterestButton.this);
        boolean flag;
        if (!FollowInterestButton.access$000(FollowInterestButton.this).getFollowing().booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        throwable.setFollowing(Boolean.valueOf(flag));
    }

    public void onFinish()
    {
        super.onFinish();
        setLoading(false);
        FollowInterestButton.access$102(FollowInterestButton.this, false);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        ModelHelper.setInterest(FollowInterestButton.access$000(FollowInterestButton.this));
        Events.post(new com.pinterest.api.model.nit>(FollowInterestButton.access$000(FollowInterestButton.this), FollowInterestButton.access$000(FollowInterestButton.this).getFollowing()));
        Events.post(new com.pinterest.activity.user.fragment.agment.UpdateEvent());
    }

    agment.UpdateEvent()
    {
        this$0 = FollowInterestButton.this;
        super();
    }
}
