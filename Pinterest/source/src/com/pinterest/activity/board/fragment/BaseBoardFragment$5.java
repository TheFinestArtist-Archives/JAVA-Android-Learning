// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.support.v4.app.FragmentActivity;
import com.pinterest.activity.board.view.BoardHeaderView;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.BoardApi;
import com.pinterest.ui.actionbar.MetadataBar;

// Referenced classes of package com.pinterest.activity.board.fragment:
//            BaseBoardFragment

class this._cls0 extends com.pinterest.base.ber
{

    final BaseBoardFragment this$0;

    public void onEventMainThread(com.pinterest.api.model.vent vent)
    {
        BoardApi.a(String.valueOf(_board.getUid()), BaseBoardFragment.access$500(BaseBoardFragment.this), BaseBoardFragment.access$600(BaseBoardFragment.this));
    }

    public void onEventMainThread(com.pinterest.api.model.ardFragment._cls5 _pcls5)
    {
        if (_board != null && _pcls5.tBoard().getUid().equals(_board.getUid()))
        {
            _board = _pcls5.tBoard();
            if (_pcls5.sDeleted())
            {
                getActivity().onBackPressed();
            } else
            {
                BaseBoardFragment.access$300(BaseBoardFragment.this);
                BaseBoardFragment.access$400(BaseBoardFragment.this);
                if (_header != null)
                {
                    _header.setBoard(_board);
                }
                if (_metadataBar != null)
                {
                    _metadataBar.setModel(_board, com.pinterest.ui.actionbar.S);
                }
                if (_floatingMetadataBar != null)
                {
                    _floatingMetadataBar.setModel(_board, com.pinterest.ui.actionbar.S);
                }
                if (_pcls5.freshFeed())
                {
                    refresh();
                    return;
                }
            }
        }
    }

    public void onEventMainThread(com.pinterest.api.model.ardFragment._cls5 _pcls5)
    {
        if (_user != null && _pcls5.User().getUid().equals(_user.getUid()))
        {
            _user = _pcls5.User();
            updateEmptyContent();
        }
    }

    ()
    {
        this$0 = BaseBoardFragment.this;
        super();
    }
}
