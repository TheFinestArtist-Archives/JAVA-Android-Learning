// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.activity.user:
//            UserBoardsFragment

class ponse extends com.pinterest.api.remote.Response
{

    final UserBoardsFragment this$0;

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (MyUser.isUserMe(UserBoardsFragment.access$000(UserBoardsFragment.this).getId()))
        {
            MyUserApi.a(UserBoardsFragment.access$100(UserBoardsFragment.this), UserBoardsFragment.access$200(UserBoardsFragment.this));
        }
        UserApi.a(Integer.toString(Placement.ANDROID_USER_PROFILE_TAKEOVER.getValue()), UserBoardsFragment.access$300(UserBoardsFragment.this).getId(), UserBoardsFragment.access$400(UserBoardsFragment.this), UserBoardsFragment.access$500(UserBoardsFragment.this));
    }

    ponse(FeedApiResponseHandler feedapiresponsehandler)
    {
        this$0 = UserBoardsFragment.this;
        super(feedapiresponsehandler);
    }
}
