// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.app.Activity;
import android.view.View;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.ui.actionsheet.ActionSheetFragment;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsListAdapter, InviteUtil

class val.item
    implements android.view.FriendsListAdapter._cls1._cls2
{

    final is._cls0 this$1;
    final TypeAheadItem val$item;

    public void onClick(View view)
    {
        NewFindFriendsListAdapter.access$000(_fld0).dismiss();
        InviteUtil.inviteUserSMS((Activity)NewFindFriendsListAdapter.access$100(_fld0), val$item.getTitle(), val$item.getIdentifier(), NewFindFriendsListAdapter.access$200(_fld0));
    }

    ()
    {
        this$1 = final_;
        val$item = TypeAheadItem.this;
        super();
    }
}
