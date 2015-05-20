// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.kit.data.DiskWatcher;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.pin.fragment:
//            PinFragment

class this._cls0 extends DiskWatcher
{

    final PinFragment this$0;

    protected void onEvent(int i)
    {
        EventType eventtype = EventType.PIN_SCREENSHOT;
        String s;
        if (PinFragment.access$000(PinFragment.this) != null)
        {
            s = PinFragment.access$100(PinFragment.this).getId();
        } else
        {
            s = "0";
        }
        Pinalytics.a(eventtype, s);
    }

    (String s, int i)
    {
        this$0 = PinFragment.this;
        super(s, i);
    }
}
