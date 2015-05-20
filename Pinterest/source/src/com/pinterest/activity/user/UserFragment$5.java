// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.User;

// Referenced classes of package com.pinterest.activity.user:
//            UserFragment

class <init> extends com.pinterest.base.bscriber
{

    final UserFragment this$0;

    public void onEventMainThread(com.pinterest.api.model.t t)
    {
        t = t.getUser();
        if (t == null || !UserFragment.access$700(UserFragment.this).getId().equals(t.getUid()))
        {
            return;
        } else
        {
            UserFragment.access$402(UserFragment.this, t);
            UserFragment.access$500(UserFragment.this);
            return;
        }
    }

    n()
    {
        this$0 = UserFragment.this;
        super();
    }
}
