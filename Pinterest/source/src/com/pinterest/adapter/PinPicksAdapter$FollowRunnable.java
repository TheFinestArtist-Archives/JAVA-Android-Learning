// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import java.util.AbstractMap;

// Referenced classes of package com.pinterest.adapter:
//            PinPicksAdapter

public class onComplete
    implements Runnable
{

    private FollowRunnableComplete onComplete;
    private User user;

    public void run()
    {
        class _cls1 extends ApiResponseHandler
        {

            final PinPicksAdapter.FollowRunnable this$0;

            public void onFailure(Throwable throwable, ApiResponse apiresponse)
            {
                super.onFailure(throwable, apiresponse);
                throwable = ModelHelper.getUser(user.getUid());
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
                    if (onComplete != null)
                    {
                        onComplete.onComplete();
                    }
                }
            }

            public void onSuccess(ApiResponse apiresponse)
            {
                super.onSuccess(apiresponse);
                if (user.getFollowing())
                {
                    apiresponse = EventType.USER_FOLLOW;
                } else
                {
                    apiresponse = EventType.USER_UNFOLLOW;
                }
                Pinalytics.a(apiresponse, user.getUid());
            }

            _cls1()
            {
                this$0 = PinPicksAdapter.FollowRunnable.this;
                super();
            }
        }

        ModelHelper.followUser(user.getUid(), user.getFollowing(), new _cls1(), null);
        class FollowRunnableComplete
        {

            public abstract void onComplete();

            public FollowRunnableComplete()
            {
            }
        }

        if (onComplete != null)
        {
            onComplete.onComplete();
        }
        PinPicksAdapter.access$000().remove(user);
    }



    public FollowRunnableComplete(User user1, FollowRunnableComplete followrunnablecomplete)
    {
        user = user1;
        onComplete = followrunnablecomplete;
    }
}
