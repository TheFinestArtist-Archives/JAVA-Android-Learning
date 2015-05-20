// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.activity.invitefriend.events.InviteCountChangeEvent;
import com.pinterest.activity.invitefriend.events.InviteCreateEvent;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsInviteAllFragment, NewFindFriendsInviteAllHeaderView, InviteFriendAdapter

class this._cls0 extends com.pinterest.base.iteAllFragment._cls1
{

    final NewFindFriendsInviteAllFragment this$0;

    public void onEventMainThread(InviteCountChangeEvent invitecountchangeevent)
    {
        if (NewFindFriendsInviteAllFragment.access$100(NewFindFriendsInviteAllFragment.this) != null)
        {
            NewFindFriendsInviteAllFragment.access$100(NewFindFriendsInviteAllFragment.this).updateFriendsCount(invitecountchangeevent.count);
        }
    }

    public void onEventMainThread(InviteCreateEvent invitecreateevent)
    {
        NewFindFriendsInviteAllFragment.access$000(NewFindFriendsInviteAllFragment.this).bulkInvite();
    }

    ()
    {
        this$0 = NewFindFriendsInviteAllFragment.this;
        super();
    }
}
