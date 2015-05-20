// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.activity.invitefriend.events.InviteCreateEvent;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.invitefriend.events.SelectAllEvent;
import com.pinterest.activity.invitefriend.events.TabChangedEvent;
import com.pinterest.kit.log.PLog;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendFragment, InviterHeaderView, InviteFriendAdapter

class this._cls0 extends com.pinterest.base.
{

    final InviteFriendFragment this$0;

    public void onEventMainThread(tactsChangeEvent tactschangeevent)
    {
        if (InviteFriendFragment.access$200(InviteFriendFragment.this) != null)
        {
            InviteFriendFragment.access$200(InviteFriendFragment.this).updateContactsNum(tactschangeevent.size);
        }
    }

    public void onEventMainThread(InviteCreateEvent invitecreateevent)
    {
        PLog.a((new StringBuilder("INVITER Invite send btn clicked ")).append(invitecreateevent.isSendBtnClicked).toString(), new Object[0]);
        if (invitecreateevent.isSendBtnClicked)
        {
            InviteFriendFragment.access$000(InviteFriendFragment.this).bulkInvite(InviteFriendFragment.access$100(InviteFriendFragment.this));
        }
        InviteFriendFragment.access$000(InviteFriendFragment.this).refresh();
    }

    public void onEventMainThread(InviteSendEvent invitesendevent)
    {
        InviteFriendFragment.access$000(InviteFriendFragment.this).updateInviteList(invitesendevent);
    }

    public void onEventMainThread(SelectAllEvent selectallevent)
    {
        selectAll(selectallevent.isSelectAll);
        InviteFriendFragment.access$000(InviteFriendFragment.this).refresh();
        InviteFriendFragment.access$102(InviteFriendFragment.this, selectallevent.isSelectAll);
    }

    public void onEventMainThread(TabChangedEvent tabchangedevent)
    {
        InviteFriendFragment.access$000(InviteFriendFragment.this).onSearchQueryChanged(tabchangedevent.getSearchQuery());
    }

    t()
    {
        this$0 = InviteFriendFragment.this;
        super();
    }
}
