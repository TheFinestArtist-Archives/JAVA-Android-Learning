// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.os.Bundle;
import com.pinterest.api.ApiResponseHandler;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardBaseDialog

public class BoardMakePublicDialog extends BoardBaseDialog
{

    private ApiResponseHandler onBoardMadePublic;

    public BoardMakePublicDialog()
    {
        onBoardMadePublic = new _cls2(true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f0e02db);
        setMessage(0x7f0e02da);
        setPositiveButton(0x7f0e02dc, new _cls1());
        setNegativeButton(0x7f0e008f, null);
    }


    private class _cls2 extends ApiResponseHandler
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
            Events.postSticky(new com.pinterest.events.FeedEvents.MyBoardsInvalidated());
            Application.showToastShort(0x7f0e0085);
            Pinalytics.a(EventType.BOARD_SET_PUBLIC, _board.getUid());
        }

        _cls2(boolean flag)
        {
            this$0 = BoardMakePublicDialog.this;
            super(flag);
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BoardMakePublicDialog this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_SECRET, ComponentType.MODAL_DIALOG, _boardUid);
            ModelHelper.updateBoard(_board, null, null, null, Boolean.valueOf(false), null, onBoardMadePublic, null);
            dismiss();
        }

        _cls1()
        {
            this$0 = BoardMakePublicDialog.this;
            super();
        }
    }

}
