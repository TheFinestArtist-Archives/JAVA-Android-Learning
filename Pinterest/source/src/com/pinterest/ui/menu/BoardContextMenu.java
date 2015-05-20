// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.view.LayoutInflater;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Constants;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenu, ContextMenuItemView, ContextMenuView

public class BoardContextMenu
    implements ContextMenu
{

    private Board _board;

    public BoardContextMenu()
    {
    }

    private ContextMenuItemView getEditView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f0200fc);
        layoutinflater.setToolTip(0x7f0e011d);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls2());
        return layoutinflater;
    }

    private ContextMenuItemView getFollowView(LayoutInflater layoutinflater)
    {
        final boolean isFollowing = _board.getFollowing().booleanValue();
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f0200fd);
        int i;
        if (isFollowing)
        {
            i = 0x7f0e04c8;
        } else
        {
            i = 0x7f0e022e;
        }
        layoutinflater.setToolTip(i);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls3());
        return layoutinflater;
    }

    private ContextMenuItemView getRelatedView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f0200ff);
        layoutinflater.setToolTip(0x7f0e0128);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls4());
        return layoutinflater;
    }

    private ContextMenuItemView getSendView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f020101);
        layoutinflater.setToolTip(0x7f0e0129);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls1());
        return layoutinflater;
    }

    public void show(ContextMenuView contextmenuview, Board board)
    {
        if (board == null)
        {
            return;
        }
        _board = board;
        board = new ArrayList(3);
        LayoutInflater layoutinflater = LayoutInflater.from(contextmenuview.getContext());
        board.add(getRelatedView(layoutinflater));
        board.add(getSendView(layoutinflater));
        if (MyUser.isUserMe(_board.getUserUid()) || Constants.isTrue(_board.getCollaborator()))
        {
            board.add(getEditView(layoutinflater));
        } else
        {
            board.add(getFollowView(layoutinflater));
        }
        contextmenuview.addMenuOptions(board);
        contextmenuview.show();
    }

    public volatile void show(ContextMenuView contextmenuview, Object obj)
    {
        show(contextmenuview, (Board)obj);
    }



/*
    static Board access$002(BoardContextMenu boardcontextmenu, Board board)
    {
        boardcontextmenu._board = board;
        return board;
    }

*/

    private class _cls2
        implements android.view.View.OnClickListener
    {

        final BoardContextMenu this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_EDIT_BUTTON, ComponentType.CONTEXTUAL_MENU, _board.getUid());
            Events.post(new Navigation(Location.BOARD_EDIT, _board));
        }

        _cls2()
        {
            this$0 = BoardContextMenu.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final BoardContextMenu this$0;
        final boolean val$isFollowing;

        public void onClick(View view)
        {
            boolean flag1 = true;
            Pinalytics.a(ElementType.PIN_BOARD_FOLLOW, ComponentType.NAVIGATION, _board.getUid());
            view = String.valueOf(_board.getUid());
            class _cls1 extends com.pinterest.api.remote.BoardApi.BoardFollowApiResponse
            {

                final _cls3 this$1;

                public void onFailure(Board board)
                {
                    _board = board;
                }

                public void onSuccess(Board board)
                {
                    _board = board;
                    if (isFollowing)
                    {
                        board = EventType.BOARD_UNFOLLOW;
                    } else
                    {
                        board = EventType.BOARD_FOLLOW;
                    }
                    Pinalytics.a(board, _board.getUid());
                }

                _cls1(Board board)
                {
                    this$1 = _cls3.this;
                    super(board);
                }
            }

            boolean flag;
            if (!isFollowing)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            BoardApi.a(view, flag, new _cls1(_board), null);
            view = _board;
            if (!isFollowing)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.setFollowing(Boolean.valueOf(flag));
        }

        _cls3()
        {
            this$0 = BoardContextMenu.this;
            isFollowing = flag;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final BoardContextMenu this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.BOARD_RELATED_BOARD, ComponentType.CONTEXTUAL_MENU, _board.getUid());
            Events.post(new Navigation(Location.RELATED_BOARDS, _board.getUid()));
        }

        _cls4()
        {
            this$0 = BoardContextMenu.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BoardContextMenu this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.SEND_BUTTON, ComponentType.CONTEXTUAL_MENU, _board.getUid());
            view = view.getContext();
            Intent intent = new Intent(view, com/pinterest/activity/sendapin/SendPinActivity);
            intent.putExtra("boardId", _board.getUid());
            view.startActivity(intent);
        }

        _cls1()
        {
            this$0 = BoardContextMenu.this;
            super();
        }
    }

}
