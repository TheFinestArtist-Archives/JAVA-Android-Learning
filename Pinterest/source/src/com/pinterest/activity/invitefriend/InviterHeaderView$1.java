// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.view.View;
import android.widget.CheckBox;
import com.pinterest.activity.invitefriend.events.SelectAllEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.kit.log.PLog;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviterHeaderView

class this._cls0
    implements android.view.
{

    final InviterHeaderView this$0;

    public void onClick(View view)
    {
        PLog.a((new StringBuilder("_inviteAllClicked: ")).append(_inviteAllCb.isChecked()).toString(), new Object[0]);
        Pinalytics.a(ElementType.INVITE_ALL_TOGGLE, ComponentType.BULK_INVITE);
        Events.post(new SelectAllEvent(_inviteAllCb.isChecked()));
    }

    t()
    {
        this$0 = InviterHeaderView.this;
        super();
    }
}
