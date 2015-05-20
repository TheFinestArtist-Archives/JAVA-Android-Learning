// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.TextView;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsHeaderView

public class 
{

    public static void inject(butterknife.eaderView eaderview, NewFindFriendsHeaderView newfindfriendsheaderview, Object obj)
    {
        newfindfriendsheaderview._friendsCount = (TextView)eaderview._friendsCount(obj, 0x7f0b0248, "field '_friendsCount'");
        newfindfriendsheaderview._inviteAllTv = (TextView)eaderview._inviteAllTv(obj, 0x7f0b0249, "field '_inviteAllTv'");
    }

    public static void reset(NewFindFriendsHeaderView newfindfriendsheaderview)
    {
        newfindfriendsheaderview._friendsCount = null;
        newfindfriendsheaderview._inviteAllTv = null;
    }

    public ()
    {
    }
}
