// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.activity.user.adapter.MyUserBoardGridAdapter;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.model.Feed;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Colors;
import com.pinterest.ui.grid.AdapterFooterView;
import com.pinterest.ui.grid.PinterestGridView;

// Referenced classes of package com.pinterest.activity.user:
//            UserBoardsFragment

class retries extends com.pinterest.api.remote.Response
{

    private int retries;
    final UserBoardsFragment this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        if (retries < 3)
        {
            retries = retries + 1;
            MyUserApi.a(UserBoardsFragment.access$100(UserBoardsFragment.this), UserBoardsFragment.access$1300(UserBoardsFragment.this));
        }
        UserBoardsFragment.access$1500(UserBoardsFragment.this, UserBoardsFragment.access$1400(UserBoardsFragment.this));
    }

    public void onSuccess(Feed feed)
    {
        super.onSuccess(feed);
        if (UserBoardsFragment.access$600(UserBoardsFragment.this) instanceof MyUserBoardGridAdapter)
        {
            ((MyUserBoardGridAdapter)UserBoardsFragment.access$700(UserBoardsFragment.this)).setSecretDatasource(feed);
            if (UserBoardsFragment.access$800(UserBoardsFragment.this) != null)
            {
                UserBoardsFragment.access$900(UserBoardsFragment.this).getFooterView().setBackgroundColor(Colors.BG_GRID_DARK);
                UserBoardsFragment.access$1000(UserBoardsFragment.this).setState(com.pinterest.ui.grid.te.LOADED);
            }
        }
        UserBoardsFragment.access$1200(UserBoardsFragment.this, UserBoardsFragment.access$1100(UserBoardsFragment.this));
    }

    idAdapter()
    {
        this$0 = UserBoardsFragment.this;
        super();
        retries = 0;
    }
}
