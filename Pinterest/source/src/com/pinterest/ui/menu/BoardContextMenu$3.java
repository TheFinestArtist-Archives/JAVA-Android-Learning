// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.ui.menu:
//            BoardContextMenu

class val.isFollowing
    implements android.view.r
{

    final BoardContextMenu this$0;
    final boolean val$isFollowing;

    public void onClick(View view)
    {
        boolean flag1 = true;
        Pinalytics.a(ElementType.PIN_BOARD_FOLLOW, ComponentType.NAVIGATION, BoardContextMenu.access$000(BoardContextMenu.this).getUid());
        view = String.valueOf(BoardContextMenu.access$000(BoardContextMenu.this).getUid());
        class _cls1 extends com.pinterest.api.remote.BoardApi.BoardFollowApiResponse
        {

            final BoardContextMenu._cls3 this$1;

            public void onFailure(Board board)
            {
                BoardContextMenu.access$002(this$0, board);
            }

            public void onSuccess(Board board)
            {
                BoardContextMenu.access$002(this$0, board);
                if (isFollowing)
                {
                    board = EventType.BOARD_UNFOLLOW;
                } else
                {
                    board = EventType.BOARD_FOLLOW;
                }
                Pinalytics.a(board, BoardContextMenu.access$000(this$0).getUid());
            }

            _cls1(Board board)
            {
                this$1 = BoardContextMenu._cls3.this;
                super(board);
            }
        }

        boolean flag;
        if (!val$isFollowing)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        BoardApi.a(view, flag, new _cls1(BoardContextMenu.access$000(BoardContextMenu.this)), null);
        view = BoardContextMenu.access$000(BoardContextMenu.this);
        if (!val$isFollowing)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.setFollowing(Boolean.valueOf(flag));
    }

    _cls1()
    {
        this$0 = final_boardcontextmenu;
        val$isFollowing = Z.this;
        super();
    }
}
