// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.fragment;

import android.os.Handler;

// Referenced classes of package com.pinterest.fragment:
//            PinGridFragment

class this._cls0
    implements Runnable
{

    final PinGridFragment this$0;

    public void run()
    {
        PinGridFragment.access$000(PinGridFragment.this);
        if (isAdded() && isActive() && PinGridFragment.access$100(PinGridFragment.this) != null)
        {
            PinGridFragment.access$100(PinGridFragment.this).postDelayed(this, 30000L);
        }
    }

    ()
    {
        this$0 = PinGridFragment.this;
        super();
    }
}
