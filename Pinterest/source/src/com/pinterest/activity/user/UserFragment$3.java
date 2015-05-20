// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.api.model.User;

// Referenced classes of package com.pinterest.activity.user:
//            UserFragment

class ponse extends com.pinterest.api.remote.Response
{

    final UserFragment this$0;

    public void onSuccess(User user)
    {
        UserFragment.access$402(UserFragment.this, user);
        UserFragment.access$500(UserFragment.this);
    }

    ponse()
    {
        this$0 = UserFragment.this;
        super();
    }
}
