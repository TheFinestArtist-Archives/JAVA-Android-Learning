// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.view.View;
import com.pinterest.activity.board.view.PersonListCell;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.Set;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendAdapter

class val.listCell
    implements android.view.
{

    final FindFriendAdapter this$0;
    final PersonListCell val$listCell;
    final TypeAheadItem val$user;

    public void onClick(View view)
    {
        if (FindFriendAdapter.access$000(FindFriendAdapter.this).add(val$user.getUid()))
        {
            view = val$user;
            boolean flag;
            if (!val$user.isFollowedByMe())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setFollowedByMe(flag);
            Pinalytics.a(ElementType.USER_FOLLOW, ComponentType.USER_FEED);
            FindFriendAdapter.access$100(FindFriendAdapter.this, val$listCell, val$user);
            FindFriendAdapter.access$200(FindFriendAdapter.this, val$user);
        }
    }

    ()
    {
        this$0 = final_findfriendadapter;
        val$user = typeaheaditem;
        val$listCell = PersonListCell.this;
        super();
    }
}
