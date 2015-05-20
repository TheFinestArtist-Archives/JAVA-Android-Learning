// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.adapter;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.digest.adapter:
//            DigestFeedbackAdapter

class > extends com.pinterest.api.remote.esponse
{

    final DigestFeedbackAdapter this$0;
    final String val$boardId;

    public void onSuccess(Board board)
    {
        Pinalytics.a(EventType.BOARD_UNFOLLOW, val$boardId);
    }

    (String s)
    {
        this$0 = final_digestfeedbackadapter;
        val$boardId = s;
        super(Board.this);
    }
}
