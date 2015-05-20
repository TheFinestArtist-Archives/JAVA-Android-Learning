// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.education.EducationHelper;
import com.pinterest.schemas.experiences.Placement;

// Referenced classes of package com.pinterest.activity.user:
//            UserBoardsFragment

class eResponseHandler extends com.pinterest.api.remote.enceResponseHandler
{

    final UserBoardsFragment this$0;

    public void onSuccess()
    {
        UserBoardsFragment.access$2602(UserBoardsFragment.this, true);
        if (isActive())
        {
            UserBoardsFragment.access$2702(UserBoardsFragment.this, EducationHelper.a(Placement.ANDROID_USER_PROFILE_TAKEOVER, UserBoardsFragment.this));
        }
    }

    eResponseHandler()
    {
        this$0 = UserBoardsFragment.this;
        super();
    }
}
