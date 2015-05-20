// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast;

import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.task.toast:
//            RepinToast

class this._cls0
    implements android.view.istener
{

    final RepinToast this$0;

    public void onClick(View view)
    {
        Events.post(new Navigation(Location.BOARD, RepinToast.access$000(RepinToast.this).getBoard()));
    }

    ()
    {
        this$0 = RepinToast.this;
        super();
    }
}
