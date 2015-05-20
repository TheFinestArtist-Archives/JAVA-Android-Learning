// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import com.pinterest.activity.pin.view.PinCloseupAccessoryActionBar;
import com.pinterest.api.model.Pin;

// Referenced classes of package com.pinterest.activity.pin.fragment:
//            PinFragment

class this._cls0 extends com.pinterest.base.ubscriber
{

    final PinFragment this$0;

    public void onEventMainThread(com.pinterest.api.model.t t)
    {
        t = t.getPin();
        if (t.equals(_pin))
        {
            PinFragment.access$300(PinFragment.this);
            if (PinFragment.access$200(PinFragment.this) != null)
            {
                PinFragment.access$200(PinFragment.this).setPin(t);
                return;
            }
        }
    }

    yActionBar()
    {
        this$0 = PinFragment.this;
        super();
    }
}
