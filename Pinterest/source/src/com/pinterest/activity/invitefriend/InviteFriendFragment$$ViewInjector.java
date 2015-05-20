// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.ListView;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendFragment

public class 
{

    public static void inject(butterknife.dFragment dfragment, InviteFriendFragment invitefriendfragment, Object obj)
    {
        invitefriendfragment._listView = (ListView)dfragment._listView(obj, 0x7f0b0172, "field '_listView'");
    }

    public static void reset(InviteFriendFragment invitefriendfragment)
    {
        invitefriendfragment._listView = null;
    }

    public ()
    {
    }
}
