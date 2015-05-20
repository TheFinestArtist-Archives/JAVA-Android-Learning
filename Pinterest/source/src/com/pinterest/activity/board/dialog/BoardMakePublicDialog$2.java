// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardMakePublicDialog

class this._cls0 extends ApiResponseHandler
{

    final BoardMakePublicDialog this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        Application.showToast(0x7f0e0086);
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        _board.setSecret(Boolean.valueOf(false));
        ModelHelper.setBoard(_board);
        Events.postSticky(new com.pinterest.events.idated());
        Application.showToastShort(0x7f0e0085);
        Pinalytics.a(EventType.BOARD_SET_PUBLIC, _board.getUid());
    }

    A(boolean flag)
    {
        this$0 = BoardMakePublicDialog.this;
        super(flag);
    }
}
