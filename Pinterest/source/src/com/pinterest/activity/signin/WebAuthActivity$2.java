// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin;

import com.pinterest.base.Application;
import com.pinterest.base.Device;
import org.scribe.exceptions.OAuthException;

// Referenced classes of package com.pinterest.activity.signin:
//            WebAuthActivity

class val.e
    implements Runnable
{

    final WebAuthActivity this$0;
    final Exception val$e;

    public void run()
    {
        if (!Device.hasInternet())
        {
            Application.showToast(0x7f0e030d);
        } else
        if (val$e instanceof OAuthException)
        {
            Application.showToast(0x7f0e02c7);
        } else
        {
            Application.showToast(errorStringId);
        }
        finish();
    }

    ()
    {
        this$0 = final_webauthactivity;
        val$e = Exception.this;
        super();
    }
}
