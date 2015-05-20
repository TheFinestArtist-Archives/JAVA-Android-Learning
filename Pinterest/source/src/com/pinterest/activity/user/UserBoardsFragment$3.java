// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import com.pinterest.activity.notifications.NotificationCount;
import com.pinterest.activity.user.adapter.MyUserBoardGridAdapter;
import com.pinterest.adapter.BoardGridAdapter;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Feed;
import com.pinterest.api.model.User;
import com.pinterest.appwidget.PWidgetHelper;
import com.pinterest.appwidget.PWidgetProvider;
import com.pinterest.base.Events;
import com.pinterest.ui.grid.PinterestGridView;
import java.util.List;

// Referenced classes of package com.pinterest.activity.user:
//            UserBoardsFragment

class  extends com.pinterest.base.er
{

    final UserBoardsFragment this$0;

    public void onEventMainThread(com.pinterest.activity.notifications.ateEvent ateevent)
    {
        int i = NotificationCount.getTotalUnseenCount();
        if (i != PWidgetProvider.getNotifCount())
        {
            PWidgetHelper.notifyWidgetStateChange(getActivity(), i);
        }
    }

    public void onEventMainThread(com.pinterest.api.model.t._cls3 _pcls3)
    {
        Board board = _pcls3.Board();
        boolean flag1 = false;
        if (board != null)
        {
            boolean flag = flag1;
            if (UserBoardsFragment.access$1600(UserBoardsFragment.this) instanceof MyUserBoardGridAdapter)
            {
                Feed feed = ((MyUserBoardGridAdapter)UserBoardsFragment.access$1700(UserBoardsFragment.this)).getSecretDatasource();
                flag = flag1;
                if (feed != null)
                {
                    flag = flag1;
                    if (feed.getIds().contains(board.getUid()))
                    {
                        flag = flag1;
                        if (!board.getSecret().booleanValue())
                        {
                            flag = true;
                        }
                    }
                }
            }
            if ((_pcls3.Deleted() || flag) && (UserBoardsFragment.access$1800(UserBoardsFragment.this) instanceof MyUserBoardGridAdapter))
            {
                _pcls3 = (MyUserBoardGridAdapter)UserBoardsFragment.access$1900(UserBoardsFragment.this);
                if (board.getSecret() == Boolean.TRUE || flag)
                {
                    _pcls3 = _pcls3.getSecretDatasource();
                } else
                {
                    _pcls3 = _pcls3.getDataSource();
                }
                if (_pcls3 != null)
                {
                    _pcls3.removeItem(board);
                    UserBoardsFragment.access$2000(UserBoardsFragment.this).reset();
                    ((BoardGridAdapter)UserBoardsFragment.access$2100(UserBoardsFragment.this)).notifyDataSetChanged();
                }
                if (((BoardGridAdapter)UserBoardsFragment.access$2200(UserBoardsFragment.this)).getCount() == 0)
                {
                    refresh();
                    return;
                }
            }
        }
    }

    public void onEventMainThread(com.pinterest.api.model.t._cls3 _pcls3)
    {
        _pcls3 = _pcls3.ser();
        if (_pcls3 == null || !_pcls3.equals(UserBoardsFragment.access$2300(UserBoardsFragment.this)))
        {
            return;
        } else
        {
            UserBoardsFragment.access$2302(UserBoardsFragment.this, _pcls3);
            return;
        }
    }

    public void onEventMainThread(com.pinterest.api.model.t._cls3 _pcls3)
    {
        Events.removeStickyEvent(_pcls3);
        for (_pcls3 = _pcls3.getUser(); _pcls3 == null || !_pcls3.equals(UserBoardsFragment.access$2300(UserBoardsFragment.this)) || (UserBoardsFragment.access$2400(UserBoardsFragment.this) instanceof MyUserBoardGridAdapter);)
        {
            return;
        }

        ((BoardGridAdapter)UserBoardsFragment.access$2500(UserBoardsFragment.this)).overrideAllBoardsFollow(_pcls3);
    }

    public void onEventMainThread(com.pinterest.events.validated validated)
    {
        Events.removeStickyEvent(validated);
        refresh();
    }

    ed()
    {
        this$0 = UserBoardsFragment.this;
        super();
    }
}
