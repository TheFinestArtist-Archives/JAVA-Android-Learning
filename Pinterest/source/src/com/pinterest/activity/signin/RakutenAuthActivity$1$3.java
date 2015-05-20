// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin;

import com.pinterest.base.Application;
import com.pinterest.base.Device;

// Referenced classes of package com.pinterest.activity.signin:
//            RakutenAuthActivity

class this._cls1
    implements Runnable
{

    final sh this$1;

    public void run()
    {
        if (!Device.hasInternet())
        {
            Application.showToast(0x7f0e030d);
        } else
        {
            Application.showToast(0x7f0e02ce);
        }
        finish();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
