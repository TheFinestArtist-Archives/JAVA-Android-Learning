// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.text.FollowButton;

public class FollowBoardButton extends FollowButton
{

    private Board _board;
    private String _editLbl;
    private boolean _myUserIsOwner;

    public FollowBoardButton(Context context)
    {
        super(context);
        _editLbl = Resources.string(0x7f0e01a8);
    }

    public FollowBoardButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _editLbl = Resources.string(0x7f0e01a8);
    }

    public FollowBoardButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _editLbl = Resources.string(0x7f0e01a8);
    }

    private void clickEdit()
    {
        Events.post(new Navigation(Location.BOARD_EDIT, _board));
    }

    private void clickFollow()
    {
        boolean flag1 = true;
        Pinalytics.a(ElementType.PIN_BOARD_FOLLOW, ComponentType.NAVIGATION, _board.getUid());
        Object obj = String.valueOf(_board.getUid());
        boolean flag;
        if (!_board.getFollowing().booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        BoardApi.a(((String) (obj)), flag, new _cls1(_board), null);
        obj = _board;
        if (!_board.getFollowing().booleanValue())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((Board) (obj)).setFollowing(Boolean.valueOf(flag));
        updateDisplay();
    }

    public Board getBoard()
    {
        return _board;
    }

    protected boolean isFollowing()
    {
        return _board != null && Constants.isTrue(_board.getFollowing());
    }

    public void onClick(View view)
    {
        if (_board == null)
        {
            return;
        }
        if (_myUserIsOwner)
        {
            clickEdit();
            return;
        } else
        {
            clickFollow();
            return;
        }
    }

    public void setBoard(Board board)
    {
        _board = board;
        boolean flag;
        if (MyUser.isUserMe(_board.getUserUid()) || _board.getCollaborator() == Boolean.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _myUserIsOwner = flag;
        updateDisplay();
    }

    protected void updateDisplay()
    {
        if (_myUserIsOwner)
        {
            setStyle(com.pinterest.ui.text.PButton.ButtonStyle.PLAIN);
            setText(_editLbl);
            return;
        } else
        {
            super.updateDisplay();
            return;
        }
    }



/*
    static Board access$002(FollowBoardButton followboardbutton, Board board)
    {
        followboardbutton._board = board;
        return board;
    }

*/

    private class _cls1 extends com.pinterest.api.remote.BoardApi.BoardFollowApiResponse
    {

        final FollowBoardButton this$0;

        public void onFailure(Board board)
        {
            _board = board;
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
            _board = board;
            if (_board.getFollowing().booleanValue())
            {
                board = EventType.BOARD_FOLLOW;
            } else
            {
                board = EventType.BOARD_UNFOLLOW;
            }
            Pinalytics.a(board, _board.getUid());
            updateDisplay();
        }

        _cls1(Board board)
        {
            this$0 = FollowBoardButton.this;
            super(board);
        }
    }

}
