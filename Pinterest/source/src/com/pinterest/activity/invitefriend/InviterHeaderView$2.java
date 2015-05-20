// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.widget.CheckBox;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.invitefriend.events.SingleCheckEvent;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviterHeaderView

class this._cls0 extends com.pinterest.base.ber
{

    final InviterHeaderView this$0;

    public void onEventMainThread(InviteSendEvent invitesendevent)
    {
        _inviteAllCb.setChecked(false);
    }

    public void onEventMainThread(SingleCheckEvent singlecheckevent)
    {
        _inviteAllCb.setChecked(singlecheckevent.isAllChecked());
    }

    ent()
    {
        this$0 = InviterHeaderView.this;
        super();
    }
}
