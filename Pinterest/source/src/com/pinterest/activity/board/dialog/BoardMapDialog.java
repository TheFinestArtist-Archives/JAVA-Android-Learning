// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.pinterest.api.model.Board;

// Referenced classes of package com.pinterest.activity.board.dialog:
//            BoardBaseDialog

public class BoardMapDialog extends BoardBaseDialog
{

    private com.pinterest.api.remote.BoardApi.BoardEditMapResponseHandler onBoardMapEdit;

    public BoardMapDialog()
    {
        onBoardMapEdit = new com.pinterest.api.remote.BoardApi.BoardEditMapResponseHandler(_board);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setTitle(0x7f0e0026);
        bundle = (ViewGroup)LayoutInflater.from(getActivity()).inflate(0x7f030040, null);
        final CheckBox blockCb = (CheckBox)bundle.findViewById(0x7f0b00a0);
        final boolean isChecked = _board.isPlaceBoard();
        blockCb.setChecked(isChecked);
        blockCb.setText(0x7f0e0396);
        ((TextView)bundle.findViewById(0x7f0b00a1)).setText(0x7f0e0397);
        setContent(bundle);
        setPositiveButton(0x7f0e040b, new _cls1());
        setNegativeButton(0x7f0e008f, null);
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BoardMapDialog this$0;
        final CheckBox val$blockCb;
        final boolean val$isChecked;

        public void onClick(View view)
        {
            if (blockCb.isChecked() != isChecked)
            {
                if (blockCb.isChecked())
                {
                    view = "places";
                } else
                {
                    view = "default";
                }
                BoardApi.a(_boardUid, null, null, null, null, view, null, onBoardMapEdit, null);
            }
            dismiss();
        }

        _cls1()
        {
            this$0 = BoardMapDialog.this;
            blockCb = checkbox;
            isChecked = flag;
            super();
        }
    }

}
