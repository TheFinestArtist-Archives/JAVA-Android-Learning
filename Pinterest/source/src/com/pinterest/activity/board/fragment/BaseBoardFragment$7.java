// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.board.fragment;

import android.app.Activity;
import com.pinterest.activity.board.view.BoardHeaderView;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Board;
import com.pinterest.base.Events;
import com.pinterest.ui.actionbar.MetadataBar;

// Referenced classes of package com.pinterest.activity.board.fragment:
//            BaseBoardFragment

class this._cls0 extends com.pinterest.api.remote.ponse
{

    final BaseBoardFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        if (apiresponse.getCode() == 40)
        {
            Events.post(new com.pinterest.api.model.istEvent(apiresponse));
        }
        if (_board == null)
        {
            throwable = getActivity();
            if (throwable != null)
            {
                throwable.onBackPressed();
            }
        }
    }

    public void onSuccess(Board board)
    {
        super.onSuccess(board);
        _board = board;
        _user = _board.getUser();
        if (_header != null)
        {
            _header.setUser(_user);
            _header.setBoard(_board);
        }
        if (_metadataBar != null)
        {
            _metadataBar.setModel(_board);
        }
        if (_floatingMetadataBar != null)
        {
            _floatingMetadataBar.setModel(_board);
        }
        BaseBoardFragment.access$400(BaseBoardFragment.this);
        BaseBoardFragment.access$300(BaseBoardFragment.this);
    }

    ()
    {
        this$0 = BaseBoardFragment.this;
        super();
    }
}
