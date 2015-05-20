// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.board;

import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Application;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.events.BoardFollowEvent;
import com.pinterest.events.FollowEvent;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.ui.grid.board:
//            BoardGridCell

class this._cls0
    implements android.view.ener
{

    final BoardGridCell this$0;

    public void onClick(View view)
    {
        boolean flag = true;
        boolean flag1 = true;
        if (BoardGridCell.access$100(BoardGridCell.this) != null)
        {
            Pinalytics.a(ElementType.BOARD_FOLLOW, ComponentType.FLOWED_BOARD, BoardGridCell.access$100(BoardGridCell.this).getUid());
            Events.post(new BoardFollowEvent(_followTv, BoardGridCell.access$100(BoardGridCell.this).getUid()));
            if (BoardGridCell.access$000(BoardGridCell.this))
            {
                view = BoardGridCell.access$100(BoardGridCell.this);
                if (!BoardGridCell.access$100(BoardGridCell.this).getFollowing().booleanValue())
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                view.setFollowing(Boolean.valueOf(flag));
                Events.post(new FollowEvent(BoardGridCell.access$100(BoardGridCell.this).getUid(), BoardGridCell.access$100(BoardGridCell.this).getFollowing().booleanValue()));
            } else
            {
                boolean flag2 = Constants.isTrue(BoardGridCell.access$100(BoardGridCell.this).getFollowing());
                if (!flag2)
                {
                    view = EventType.BOARD_FOLLOW;
                } else
                {
                    view = EventType.BOARD_UNFOLLOW;
                }
                if (BoardGridCell.access$100(BoardGridCell.this).getUser() != null && view == EventType.BOARD_FOLLOW && BoardGridCell.access$100(BoardGridCell.this).getUser().getBlocked() == Boolean.TRUE)
                {
                    Application.showToast(0x7f0e0060);
                    return;
                }
                BoardGridCell boardgridcell = BoardGridCell.this;
                String s = BoardGridCell.access$100(BoardGridCell.this).getUid();
                class _cls1 extends com.pinterest.api.remote.BoardApi.BoardFollowApiResponse
                {

                    final BoardGridCell._cls2 this$1;
                    final EventType val$ev;
                    final boolean val$isCurrentlyFollowing;

                    public void onFailure(Throwable throwable, ApiResponse apiresponse)
                    {
                        super.onFailure(throwable, apiresponse);
                        if (BoardGridCell.access$100(this$0) != null)
                        {
                            throwable = BoardGridCell.access$100(this$0);
                            boolean flag3;
                            if (!isCurrentlyFollowing)
                            {
                                flag3 = true;
                            } else
                            {
                                flag3 = false;
                            }
                            throwable.setFollowing(Boolean.valueOf(flag3));
                            ModelHelper.setBoard(BoardGridCell.access$100(this$0));
                            updateFollowButton();
                            if (BoardGridCell.access$200(this$0) != null)
                            {
                                BoardGridCell.access$200(this$0).onBoardChanged(BoardGridCell.access$100(this$0));
                            }
                        }
                    }

                    public void onSuccess(ApiResponse apiresponse)
                    {
                        super.onSuccess(apiresponse);
                        Pinalytics.a(ev, BoardGridCell.access$100(this$0).getUid());
                    }

            _cls1(boolean flag)
            {
                this$1 = BoardGridCell._cls2.this;
                ev = eventtype;
                isCurrentlyFollowing = flag;
                super(final_board);
            }
                }

                if (flag2)
                {
                    flag = false;
                }
                BoardGridCell.access$102(boardgridcell, ModelHelper.followBoard(s, flag, new _cls1(flag2), null));
            }
            updateFollowButton();
            if (BoardGridCell.access$200(BoardGridCell.this) != null)
            {
                BoardGridCell.access$200(BoardGridCell.this).onBoardChanged(BoardGridCell.access$100(BoardGridCell.this));
                return;
            }
        }
    }

    _cls1()
    {
        this$0 = BoardGridCell.this;
        super();
    }
}
