// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Board;
import com.pinterest.base.Application;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardDeleteDialog

class <init> extends ApiResponseHandler
{

    final BoardDeleteDialog this$0;

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        Application.showToastShort(Resources.string(0x7f0e006f, new Object[] {
            _board.getName()
        }));
        Pinalytics.a(EventType.BOARD_DELETE, _boardUid);
    }

    private ()
    {
        this$0 = BoardDeleteDialog.this;
        super(0x7f0e0191);
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
