// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Constants;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.ui.grid.user:
//            UserGridCell

class this._cls0
    implements android.view.tener
{

    final UserGridCell this$0;

    public void onClick(View view)
    {
        if (UserGridCell.access$000(UserGridCell.this) == null)
        {
            return;
        }
        Pinalytics.a(ElementType.USER_FOLLOW, ComponentType.USER_FEED, UserGridCell.access$000(UserGridCell.this).getUid());
        boolean flag = Constants.isTrue(Boolean.valueOf(UserGridCell.access$000(UserGridCell.this).getFollowing()));
        view = UserGridCell.this;
        String s = UserGridCell.access$000(UserGridCell.this).getUid();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        UserGridCell.access$002(view, ModelHelper.followUser(s, flag, null, null));
        updateFollowButton();
    }

    ()
    {
        this$0 = UserGridCell.this;
        super();
    }
}
