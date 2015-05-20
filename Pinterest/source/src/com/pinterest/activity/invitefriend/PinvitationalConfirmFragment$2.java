// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.base.Events;
import java.util.HashSet;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalConfirmFragment

class this._cls0 extends BaseApiResponseHandler
{

    final PinvitationalConfirmFragment this$0;

    public void onSuccess(String s)
    {
        super.onSuccess(s);
        Events.post(new InviteSendEvent(true, new HashSet(_invitees)));
    }

    ()
    {
        this$0 = PinvitationalConfirmFragment.this;
        super();
    }
}
