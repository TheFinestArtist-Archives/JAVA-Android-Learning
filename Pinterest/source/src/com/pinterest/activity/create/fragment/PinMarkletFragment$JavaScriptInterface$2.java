// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.support.v4.app.FragmentActivity;
import com.pinterest.base.Application;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        if (isAdded())
        {
            Application.showToast(0x7f0e0215);
            hideWaitDialog();
            getActivity().finish();
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
