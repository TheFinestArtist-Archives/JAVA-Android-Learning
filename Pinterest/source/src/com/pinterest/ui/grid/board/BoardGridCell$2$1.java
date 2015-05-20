// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.board;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.ui.grid.board:
//            BoardGridCell

class piResponse extends com.pinterest.api.remote.owApiResponse
{

    final is._cls0 this$1;
    final EventType val$ev;
    final boolean val$isCurrentlyFollowing;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        if (BoardGridCell.access$100(_fld0) != null)
        {
            throwable = BoardGridCell.access$100(_fld0);
            boolean flag;
            if (!val$isCurrentlyFollowing)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            throwable.setFollowing(Boolean.valueOf(flag));
            ModelHelper.setBoard(BoardGridCell.access$100(_fld0));
            updateFollowButton();
            if (BoardGridCell.access$200(_fld0) != null)
            {
                BoardGridCell.access$200(_fld0).onBoardChanged(BoardGridCell.access$100(_fld0));
            }
        }
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        Pinalytics.a(val$ev, BoardGridCell.access$100(_fld0).getUid());
    }

    ener(boolean flag)
    {
        this$1 = final_ener;
        val$ev = EventType.this;
        val$isCurrentlyFollowing = flag;
        super(final_board);
    }
}
