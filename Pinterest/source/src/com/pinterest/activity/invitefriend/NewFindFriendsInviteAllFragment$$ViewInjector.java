// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.ListView;
import com.pinterest.ui.actionbar.ActionBar;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsInviteAllFragment

public class 
{

    public static void inject(butterknife.lFragment lfragment, NewFindFriendsInviteAllFragment newfindfriendsinviteallfragment, Object obj)
    {
        newfindfriendsinviteallfragment._listView = (ListView)lfragment._listView(obj, 0x7f0b0172, "field '_listView'");
        newfindfriendsinviteallfragment._actionBar = (ActionBar)lfragment._actionBar(obj, 0x7f0b0061, "field '_actionBar'");
    }

    public static void reset(NewFindFriendsInviteAllFragment newfindfriendsinviteallfragment)
    {
        newfindfriendsinviteallfragment._listView = null;
        newfindfriendsinviteallfragment._actionBar = null;
    }

    public ()
    {
    }
}
