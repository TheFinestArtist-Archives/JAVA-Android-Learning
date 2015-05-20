// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import com.pinterest.kit.application.Resources;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls0
    implements Runnable
{

    final PinMarkletFragment this$0;

    public void run()
    {
        showWaitDialog(Resources.string(0x7f0e02c5, new Object[] {
            PinMarkletFragment.access$100(PinMarkletFragment.this, PinMarkletFragment.access$000(PinMarkletFragment.this))
        }));
    }

    A()
    {
        this$0 = PinMarkletFragment.this;
        super();
    }
}
