// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.activity.board.view:
//            FollowBoardButton

class se extends com.pinterest.api.remote.ApiResponse
{

    final FollowBoardButton this$0;

    public void onFailure(Board board)
    {
        FollowBoardButton.access$002(FollowBoardButton.this, board);
        updateDisplay();
    }

    public void onFinish()
    {
        super.onFinish();
        setLoading(false);
    }

    public void onStart()
    {
        super.onStart();
        setLoading(true);
    }

    public void onSuccess(Board board)
    {
        FollowBoardButton.access$002(FollowBoardButton.this, board);
        if (FollowBoardButton.access$000(FollowBoardButton.this).getFollowing().booleanValue())
        {
            board = EventType.BOARD_FOLLOW;
        } else
        {
            board = EventType.BOARD_UNFOLLOW;
        }
        Pinalytics.a(board, FollowBoardButton.access$000(FollowBoardButton.this).getUid());
        updateDisplay();
    }

    se(Board board)
    {
        this$0 = FollowBoardButton.this;
        super(board);
    }
}
