// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings;

import com.pinterest.api.model.User;

// Referenced classes of package com.pinterest.activity.settings:
//            AccountSettingsFragment

class > extends com.pinterest.api.remote.e
{

    final AccountSettingsFragment this$0;

    public void onSuccess(User user)
    {
        super.onSuccess(user);
        AccountSettingsFragment.access$000(AccountSettingsFragment.this);
    }

    (boolean flag)
    {
        this$0 = AccountSettingsFragment.this;
        super(flag);
    }
}
