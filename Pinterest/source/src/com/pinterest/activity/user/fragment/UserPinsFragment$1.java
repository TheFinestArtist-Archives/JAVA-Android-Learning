// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.fragment;

import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.user.fragment:
//            UserPinsFragment

class this._cls0
    implements android.view.r
{

    final UserPinsFragment this$0;

    public void onClick(View view)
    {
        view = new Navigation(Location.SEARCH, "");
        view.putExtra("com.pinterest.EXTRA_SEARCH_MODE", "VALUE_SEARCH_LOCAL");
        Events.post(view);
    }

    ()
    {
        this$0 = UserPinsFragment.this;
        super();
    }
}
