// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviterHeaderView

public class I
{

    public static void inject(butterknife.eaderView eaderview, InviterHeaderView inviterheaderview, Object obj)
    {
        inviterheaderview._inviteAllRl = eaderview._inviteAllRl(obj, 0x7f0b02bd, "field '_inviteAllRl'");
        inviterheaderview._contactsNum = (TextView)eaderview._contactsNum(obj, 0x7f0b02be, "field '_contactsNum'");
        inviterheaderview._inviteAllCb = (CheckBox)eaderview._inviteAllCb(obj, 0x7f0b02c0, "field '_inviteAllCb'");
        inviterheaderview._inviteAllTv = (TextView)eaderview._inviteAllTv(obj, 0x7f0b02bf, "field '_inviteAllTv'");
        inviterheaderview._mailIv = (ImageView)eaderview._mailIv(obj, 0x7f0b02bc, "field '_mailIv'");
    }

    public static void reset(InviterHeaderView inviterheaderview)
    {
        inviterheaderview._inviteAllRl = null;
        inviterheaderview._contactsNum = null;
        inviterheaderview._inviteAllCb = null;
        inviterheaderview._inviteAllTv = null;
        inviterheaderview._mailIv = null;
    }

    public I()
    {
    }
}
