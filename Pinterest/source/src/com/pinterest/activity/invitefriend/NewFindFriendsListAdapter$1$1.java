// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import com.pinterest.activity.invitefriend.events.InviteFriendEvent;
import com.pinterest.activity.search.model.TypeAheadItem;
import com.pinterest.activity.task.event.ToastEvent;
import com.pinterest.activity.task.toast.BulkInviteSendToast;
import com.pinterest.base.Events;
import com.pinterest.ui.actionsheet.ActionSheetFragment;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsListAdapter

class val.item
    implements android.view.FriendsListAdapter._cls1._cls1
{

    final val.item this$1;
    final TypeAheadItem val$item;

    public void onClick(View view)
    {
        NewFindFriendsListAdapter.access$000(_fld0).dismiss();
        Events.post(new ToastEvent(new BulkInviteSendToast(new InviteFriendEvent(val$item.getIdentifier()), false)));
    }

    ()
    {
        this$1 = final_;
        val$item = TypeAheadItem.this;
        super();
    }
}
