// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.kit.tasks.BackgroundTask;
import java.util.List;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            FriendSearchAdapter

class this._cls0 extends BackgroundTask
{

    List contactItems;
    final FriendSearchAdapter this$0;

    public void onFinish()
    {
        if (contactItems != null && !contactItems.isEmpty())
        {
            FriendSearchAdapter.access$100(FriendSearchAdapter.this, FriendSearchAdapter.access$000(FriendSearchAdapter.this), contactItems);
        }
        setSpinnerState(false);
    }

    public void run()
    {
        contactItems = getContactList();
    }

    ()
    {
        this$0 = FriendSearchAdapter.this;
        super();
    }
}
