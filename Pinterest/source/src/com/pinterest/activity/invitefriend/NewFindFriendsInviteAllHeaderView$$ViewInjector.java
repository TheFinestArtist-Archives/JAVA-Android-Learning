// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsInviteAllHeaderView

public class _cls1
{

    public static void inject(butterknife.eaderView eaderview, final NewFindFriendsInviteAllHeaderView target, Object obj)
    {
        target._friendsCount = (TextView)eaderview._friendsCount(obj, 0x7f0b0248, "field '_friendsCount'");
        class _cls1 extends DebouncingOnClickListener
        {

            final NewFindFriendsInviteAllHeaderView val$target;

            public final void doClick(View view)
            {
                target.onSendBtnClick();
            }

            _cls1()
            {
                target = newfindfriendsinviteallheaderview;
                super();
            }
        }

        eaderview.eaderView(obj, 0x7f0b0145, "method 'onSendBtnClick'").setOnClickListener(new _cls1());
    }

    public static void reset(NewFindFriendsInviteAllHeaderView newfindfriendsinviteallheaderview)
    {
        newfindfriendsinviteallheaderview._friendsCount = null;
    }

    public _cls1()
    {
    }
}
