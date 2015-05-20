// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.kit.autoupdate.AutoUpdateManager;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.digest:
//            DigestFragment

class this._cls1
    implements android.view.r
{

    final ctivity this$1;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.UPDATE_BUTTON, ComponentType.NAG);
        if (getActivity() != null)
        {
            AutoUpdateManager.a().startUpdate(getActivity());
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
