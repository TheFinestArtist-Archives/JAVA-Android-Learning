// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.featured;

import com.pinterest.api.model.User;

// Referenced classes of package com.pinterest.activity.featured:
//            FeaturedBoardFragment, FeaturedHeaderView

class this._cls0 extends com.pinterest.api.remote.ment._cls1
{

    final FeaturedBoardFragment this$0;

    public void onSuccess(User user)
    {
        super.onSuccess(user);
        _headerView.setUser(user);
    }

    ()
    {
        this$0 = FeaturedBoardFragment.this;
        super();
    }
}
