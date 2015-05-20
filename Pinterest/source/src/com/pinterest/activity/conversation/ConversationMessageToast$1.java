// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.conversation;

import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.model.ConversationMessage;
import com.pinterest.base.Events;

// Referenced classes of package com.pinterest.activity.conversation:
//            ConversationMessageToast

class this._cls0
    implements android.view.ersationMessageToast._cls1
{

    final ConversationMessageToast this$0;

    public void onClick(View view)
    {
        Events.post(new Navigation(Location.CONVERSATION, ConversationMessageToast.access$000(ConversationMessageToast.this).getConversationId()));
    }

    ()
    {
        this$0 = ConversationMessageToast.this;
        super();
    }
}
