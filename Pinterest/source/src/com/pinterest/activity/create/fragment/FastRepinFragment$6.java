// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create.fragment;

import com.pinterest.activity.create.adapter.BoardPickerAdapter;
import com.pinterest.api.model.BoardFeed;
import com.pinterest.api.model.MyUser;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.tasks.BackgroundTask;

// Referenced classes of package com.pinterest.activity.create.fragment:
//            FastRepinFragment, BoardPickerFragment

class this._cls0 extends BackgroundTask
{

    final FastRepinFragment this$0;

    public void onFinish()
    {
        if (_adapter == null)
        {
            return;
        } else
        {
            _adapter.setDataSource(BoardPickerFragment._boardFeed);
            _adapter.setCachedSuggestions(BoardPickerFragment._suggestedBoardFeed, _pin, true);
            _adapter.notifyDataSetChanged();
            return;
        }
    }

    public void run()
    {
        if (BoardPickerFragment._suggestedBoardFeed == null)
        {
            BoardPickerFragment._suggestedBoardFeed = new BoardFeed();
        }
        BoardFeed boardfeed = new BoardFeed(DiskCache.getJsonObject("MY_PICKER_BOARDS"), null);
        BoardPickerFragment._boardFeed = boardfeed;
        if (boardfeed.getCount() > 5)
        {
            java.util.List list = MyUser.getLastUsedBoardsBlocking();
            BoardPickerFragment._suggestedBoardFeed.setItems(list);
        }
    }

    ()
    {
        this$0 = FastRepinFragment.this;
        super();
    }
}
