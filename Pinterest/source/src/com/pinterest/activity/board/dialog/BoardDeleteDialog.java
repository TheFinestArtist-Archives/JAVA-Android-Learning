// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.os.Bundle;
import com.pinterest.api.model.ModelHelper;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardBaseDialog

public class BoardDeleteDialog extends BoardBaseDialog
{

    public BoardDeleteDialog()
    {
    }

    private void deleteBoard()
    {
        ModelHelper.deleteBoard(_boardUid, new BoardDeleteResponseHandler(null), null);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f0e018c);
        setMessage(0x7f0e0183);
        setPositiveButton(0x7f0e0186, new _cls1());
        setNegativeButton(0x7f0e008f, null);
    }


    private class BoardDeleteResponseHandler extends ApiResponseHandler
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

        private BoardDeleteResponseHandler()
        {
            this$0 = BoardDeleteDialog.this;
            super(0x7f0e0191);
        }

        BoardDeleteResponseHandler(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BoardDeleteDialog this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_DELETE_BUTTON, ComponentType.MODAL_DIALOG, _boardUid);
            deleteBoard();
            dismiss();
        }

        _cls1()
        {
            this$0 = BoardDeleteDialog.this;
            super();
        }
    }

}
