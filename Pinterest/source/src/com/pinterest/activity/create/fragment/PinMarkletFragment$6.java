// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import android.support.v4.app.FragmentActivity;
import com.pinterest.base.Application;
import com.pinterest.kit.application.Resources;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            PinMarkletFragment

class this._cls0
    implements Runnable
{

    final PinMarkletFragment this$0;

    public void run()
    {
        if (PinMarkletFragment.access$400(PinMarkletFragment.this) != Boolean.TRUE)
        {
            Application.showToast(Resources.string(0x7f0e0365));
            if (isAdded())
            {
                hideWaitDialog();
                getActivity().finish();
            }
        }
    }

    A()
    {
        this$0 = PinMarkletFragment.this;
        super();
    }
}
