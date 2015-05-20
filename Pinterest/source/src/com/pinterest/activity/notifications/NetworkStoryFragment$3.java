// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.notifications;

import com.pinterest.kit.log.PLog;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.megaphone.MegaphoneView;
import com.pinterest.ui.megaphone.NagUtils;

// Referenced classes of package com.pinterest.activity.notifications:
//            NetworkStoryFragment

class this._cls0 extends com.pinterest.base.
{

    final NetworkStoryFragment this$0;

    public void onEventMainThread(gEvent gevent)
    {
        PLog.a("NetworkStoryFragment.NagEvent", new Object[0]);
        if (NetworkStoryFragment.access$1900(NetworkStoryFragment.this) == null)
        {
            NetworkStoryFragment.access$2002(NetworkStoryFragment.this, (MegaphoneView)ViewHelper.viewById(getActivity(), 0x7f030100));
            NetworkStoryFragment.access$2200(NetworkStoryFragment.this).setListViewParent(NetworkStoryFragment.access$2100(NetworkStoryFragment.this));
        }
        NagUtils.showNagFromEvent(NetworkStoryFragment.this, NetworkStoryFragment.access$2300(NetworkStoryFragment.this), gevent);
    }

    gEvent()
    {
        this$0 = NetworkStoryFragment.this;
        super();
    }
}
