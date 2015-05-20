// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.search.fragment;

import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;

// Referenced classes of package com.pinterest.activity.search.fragment:
//            GuidedPinSearchFragment

class this._cls0 extends com.pinterest.base.PinSearchFragment._cls3
{

    final GuidedPinSearchFragment this$0;

    public void onEventMainThread(com.pinterest.ui.grid. )
    {
        StopWatch.get().complete("search_ttrfp");
        Events.unregister(GuidedPinSearchFragment.access$300(GuidedPinSearchFragment.this), new Class[] {
            com/pinterest/ui/grid/PinGridCell$ImageLoadEvent
        });
    }

    ()
    {
        this$0 = GuidedPinSearchFragment.this;
        super();
    }
}
