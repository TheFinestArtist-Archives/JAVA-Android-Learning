// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardMakePublicDialog

class this._cls0
    implements android.view.oardMakePublicDialog._cls1
{

    final BoardMakePublicDialog this$0;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.BOARD_SECRET, ComponentType.MODAL_DIALOG, _boardUid);
        ModelHelper.updateBoard(_board, null, null, null, Boolean.valueOf(false), null, BoardMakePublicDialog.access$000(BoardMakePublicDialog.this), null);
        dismiss();
    }

    A()
    {
        this$0 = BoardMakePublicDialog.this;
        super();
    }
}
