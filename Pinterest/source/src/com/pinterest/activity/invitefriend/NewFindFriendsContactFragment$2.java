// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;


// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsContactFragment, NewFindFriendsHeaderView

class this._cls0 extends com.pinterest.base.ontactFragment._cls2
{

    final NewFindFriendsContactFragment this$0;

    public void onEventMainThread(geEvent geevent)
    {
        if (NewFindFriendsContactFragment.access$000(NewFindFriendsContactFragment.this) != null)
        {
            NewFindFriendsContactFragment.access$000(NewFindFriendsContactFragment.this).updateFriendsCount(geevent.size);
        }
    }

    geEvent()
    {
        this$0 = NewFindFriendsContactFragment.this;
        super();
    }
}
