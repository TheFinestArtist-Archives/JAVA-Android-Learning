// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.view;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.user.view:
//            FollowUserButton

class this._cls0 extends ApiResponseHandler
{

    final FollowUserButton this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        throwable = FollowUserButton.access$000(FollowUserButton.this);
        boolean flag;
        if (!FollowUserButton.access$000(FollowUserButton.this).getFollowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        throwable.setFollowing(flag);
    }

    public void onFinish()
    {
        super.onFinish();
        setLoading(false);
        FollowUserButton.access$102(FollowUserButton.this, false);
    }

    public void onStart()
    {
        super.onStart();
        setLoading(true);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        if (FollowUserButton.access$000(FollowUserButton.this).getFollowing())
        {
            apiresponse = EventType.USER_FOLLOW;
        } else
        {
            apiresponse = EventType.USER_UNFOLLOW;
        }
        Pinalytics.a(apiresponse, FollowUserButton.access$000(FollowUserButton.this).getUid());
        ModelHelper.updateUser(FollowUserButton.access$000(FollowUserButton.this));
        Events.post(new com.pinterest.api.model.t(FollowUserButton.access$000(FollowUserButton.this)));
    }

    _cls9()
    {
        this$0 = FollowUserButton.this;
        super();
    }
}
