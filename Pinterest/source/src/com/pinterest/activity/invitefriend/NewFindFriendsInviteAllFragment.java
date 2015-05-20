// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.pinterest.activity.invitefriend.events.InviteCountChangeEvent;
import com.pinterest.activity.invitefriend.events.InviteCreateEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Events;
import com.pinterest.ui.actionbar.ActionBar;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendAdapter, NewFindFriendsInviteAllHeaderView

public class NewFindFriendsInviteAllFragment extends BaseFragment
{

    ActionBar _actionBar;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private NewFindFriendsInviteAllHeaderView _header;
    ListView _listView;
    private InviteFriendAdapter _listViewAdapter;

    public NewFindFriendsInviteAllFragment()
    {
        _eventsSubscriber = new _cls1();
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/activity/invitefriend/events/InviteCreateEvent, new Class[] {
            com/pinterest/activity/invitefriend/events/InviteCountChangeEvent
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030093;
        _menuId = 0x7f100005;
    }

    protected void onDeactivate()
    {
        Events.unregister(_eventsSubscriber);
        super.onDeactivate();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _listViewAdapter = new InviteFriendAdapter(getActivity());
        _listViewAdapter.setApiTag(getApiTag());
        _listViewAdapter.setContactType(0);
        _listViewAdapter.addAllToInviteList();
        _header = new NewFindFriendsInviteAllHeaderView(getActivity());
        _listView.addHeaderView(_header);
        _listView.setAdapter(_listViewAdapter);
        _listView.setSelection(0);
        _listViewAdapter.refresh();
        _actionBar.getActionBar().setTitle(0x7f0e029e);
    }



    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final NewFindFriendsInviteAllFragment this$0;

        public void onEventMainThread(InviteCountChangeEvent invitecountchangeevent)
        {
            if (_header != null)
            {
                _header.updateFriendsCount(invitecountchangeevent.count);
            }
        }

        public void onEventMainThread(InviteCreateEvent invitecreateevent)
        {
            _listViewAdapter.bulkInvite();
        }

        _cls1()
        {
            this$0 = NewFindFriendsInviteAllFragment.this;
            super();
        }
    }

}
