// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.schemas.event.EventType;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendAdapter

class val.user extends ApiResponseHandler
{

    final FindFriendAdapter this$0;
    final TypeAheadItem val$user;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        throwable = val$user;
        boolean flag;
        if (!val$user.isFollowedByMe())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        throwable.setFollowedByMe(flag);
        FindFriendAdapter.access$000(FindFriendAdapter.this).remove(val$user.getUid());
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        if (val$user.isFollowedByMe())
        {
            apiresponse = EventType.USER_FOLLOW;
        } else
        {
            apiresponse = EventType.USER_UNFOLLOW;
        }
        Pinalytics.a(apiresponse, val$user.getUid());
        apiresponse = ModelHelper.getUser(val$user.getUid());
        if (apiresponse != null)
        {
            ModelHelper.updateUser(apiresponse);
        }
        FindFriendAdapter.access$000(FindFriendAdapter.this).remove(val$user.getUid());
    }

    ()
    {
        this$0 = final_findfriendadapter;
        val$user = TypeAheadItem.this;
        super();
    }
}
