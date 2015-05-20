// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.dialog;

import android.app.Activity;
import android.os.Bundle;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;

public class BoardShareDialog extends BaseDialog
{

    private static final String BOARD_UID = "boardUid";
    private Board _board;
    ApiResponseHandler onFeedback;

    public BoardShareDialog(Board board)
    {
        onFeedback = new ApiResponseHandler();
        _board = board;
        Bundle bundle = getArguments();
        board = bundle;
        if (bundle == null)
        {
            board = new Bundle();
        }
        board.putString("boardUid", _board.getUid());
        setArguments(board);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = new BoardShareView(activity);
        activity.setBoard(_board);
        setContent(activity, 0);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null && _board == null)
        {
            _board = ModelHelper.getBoard(bundle.getString("boardUid", null));
        }
    }

    private class BoardShareView extends LinearLayout
        implements android.view.View.OnClickListener
    {

        private Board _board;
        final BoardShareDialog this$0;

        private void init()
        {
            setOrientation(1);
            inflate(getContext(), 0x7f03003d, this);
            findViewById(0x7f0b009a).setOnClickListener(this);
            findViewById(0x7f0b009b).setOnClickListener(this);
            findViewById(0x7f0b009c).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131427482: 
                Pinalytics.a(ElementType.BOARD_SHARE_FACEBOOK_BUTTON, ComponentType.MODAL_DIALOG);
                SocialUtils.startShare(getContext(), _board, null, "com.facebook.katana");
                dismiss();
                return;

            case 2131427483: 
                Pinalytics.a(ElementType.BOARD_SHARE_COPY_LINK_BUTTON, ComponentType.MODAL_DIALOG);
                view = (new StringBuilder()).append(StringUtils.removeEnd(Resources.string(0x7f0e0381), "/")).append(_board.getUrl()).toString();
                Device.copyToClipboard(getContext(), view);
                Events.post(new ToastEvent(new SimpleToast(Resources.string(0x7f0e04a8))));
                dismiss();
                return;

            case 2131427484: 
                SocialUtils.startShare(getContext(), _board, null, null);
                break;
            }
            Pinalytics.a(ElementType.BOARD_SHARE_OTHER_BUTTON, ComponentType.MODAL_DIALOG);
            dismiss();
        }

        public void setBoard(Board board)
        {
            _board = board;
        }

        public BoardShareView(Context context)
        {
            this(context, null);
        }

        public BoardShareView(Context context, AttributeSet attributeset)
        {
            this$0 = BoardShareDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
