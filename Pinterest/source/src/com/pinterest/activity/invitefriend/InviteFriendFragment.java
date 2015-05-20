// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.pinterest.activity.invitefriend.events.InviteCreateEvent;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.invitefriend.events.SelectAllEvent;
import com.pinterest.activity.invitefriend.events.TabChangedEvent;
import com.pinterest.activity.sendapin.ui.ProgressSpinnerListCell;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Events;
import com.pinterest.kit.log.PLog;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteFriendAdapter, InviterHeaderView

public class InviteFriendFragment extends BaseFragment
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private InviterHeaderView _header;
    private boolean _inviteAll;
    ListView _listView;
    private InviteFriendAdapter _listViewAdapter;
    private boolean _refreshOnResume;
    private int _tabPosition;
    private android.widget.AdapterView.OnItemClickListener onListCellClickListener;
    private android.widget.AbsListView.OnScrollListener onListViewScrollListener;

    public InviteFriendFragment()
    {
        _tabPosition = 0;
        _eventsSubscriber = new _cls1();
        onListViewScrollListener = new _cls2();
        onListCellClickListener = new _cls3();
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/activity/invitefriend/events/SelectAllEvent, new Class[] {
            com/pinterest/activity/invitefriend/events/TabChangedEvent, com/pinterest/activity/invitefriend/events/InviteCreateEvent, com/pinterest/activity/invitefriend/events/InviteSendEvent, com/pinterest/activity/invitefriend/FriendSearchAdapter$ContactsChangeEvent
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03008f;
    }

    protected void onDeactivate()
    {
        Events.unregister(_eventsSubscriber);
        super.onDeactivate();
    }

    public void onResume()
    {
        super.onResume();
        if (_refreshOnResume)
        {
            _listViewAdapter.refresh();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        PLog.a("INVITE", new Object[] {
            _listView.toString()
        });
        _listViewAdapter = new InviteFriendAdapter(getActivity());
        _listViewAdapter.setApiTag(getApiTag());
        view = new ProgressSpinnerListCell(getActivity());
        _header = new InviterHeaderView(getActivity());
        bundle = _header;
        boolean flag;
        if (_tabPosition == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.showInviteAll(flag);
        _listView.addHeaderView(_header);
        _listView.addFooterView(view, null, true);
        _listViewAdapter.setFooterView(view);
        _listViewAdapter.setSpinnerState(true);
        _listViewAdapter.setContactType(_tabPosition);
        _listView.setAdapter(_listViewAdapter);
        _listView.setOnItemClickListener(onListCellClickListener);
        _listView.setOnScrollListener(onListViewScrollListener);
        _listView.setSelection(0);
        _listViewAdapter.refresh();
        _inviteAll = false;
    }

    public void searchQueryUpdated(CharSequence charsequence)
    {
        _listViewAdapter.onSearchQueryChanged(charsequence.toString());
    }

    public void selectAll(boolean flag)
    {
        if (flag)
        {
            _listViewAdapter.addAllToInviteList();
        } else
        {
            _listViewAdapter.clearInviteList();
        }
        PLog.a((new StringBuilder("INVITER selectAll clicked. InviteList size")).append(_listViewAdapter.getInviteListSize()).toString(), new Object[0]);
    }

    public void setTabPosition(int i)
    {
        _tabPosition = i;
        if (_header != null)
        {
            InviterHeaderView inviterheaderview = _header;
            boolean flag;
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            inviterheaderview.showInviteAll(flag);
        }
    }




/*
    static boolean access$102(InviteFriendFragment invitefriendfragment, boolean flag)
    {
        invitefriendfragment._inviteAll = flag;
        return flag;
    }

*/


    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final InviteFriendFragment this$0;

        public void onEventMainThread(FriendSearchAdapter.ContactsChangeEvent contactschangeevent)
        {
            if (_header != null)
            {
                _header.updateContactsNum(contactschangeevent.size);
            }
        }

        public void onEventMainThread(InviteCreateEvent invitecreateevent)
        {
            PLog.a((new StringBuilder("INVITER Invite send btn clicked ")).append(invitecreateevent.isSendBtnClicked).toString(), new Object[0]);
            if (invitecreateevent.isSendBtnClicked)
            {
                _listViewAdapter.bulkInvite(_inviteAll);
            }
            _listViewAdapter.refresh();
        }

        public void onEventMainThread(InviteSendEvent invitesendevent)
        {
            _listViewAdapter.updateInviteList(invitesendevent);
        }

        public void onEventMainThread(SelectAllEvent selectallevent)
        {
            selectAll(selectallevent.isSelectAll);
            _listViewAdapter.refresh();
            _inviteAll = selectallevent.isSelectAll;
        }

        public void onEventMainThread(TabChangedEvent tabchangedevent)
        {
            _listViewAdapter.onSearchQueryChanged(tabchangedevent.getSearchQuery());
        }

        _cls1()
        {
            this$0 = InviteFriendFragment.this;
            super();
        }
    }


    private class _cls2
        implements android.widget.AbsListView.OnScrollListener
    {

        final InviteFriendFragment this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (i == 1)
            {
                Device.hideSoftKeyboard(abslistview);
            }
        }

        _cls2()
        {
            this$0 = InviteFriendFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final InviteFriendFragment this$0;

        private Intent getContactViewIntent(String s)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.withAppendedPath(android.provider.ContactsContract.Contacts.CONTENT_URI, s));
            return intent;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = ((AdapterView) (_listView.getItemAtPosition(i)));
            if (!(adapterview instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
            adapterview = (TypeAheadItem)adapterview;
            _cls4..SwitchMap.com.pinterest.activity.search.model.TypeAheadItem.ItemType[adapterview.getItemType().ordinal()];
            JVM INSTR tableswitch 1 4: default 64
        //                       1 65
        //                       2 65
        //                       3 65
        //                       4 96;
               goto _L2 _L3 _L3 _L3 _L4
_L2:
            return;
_L3:
            Pinalytics.a(ElementType.USER_LIST_CONTACT, ComponentType.USER_FEED);
            adapterview = getContactViewIntent(adapterview.getUid());
            Device.hideSoftKeyboard(view);
            startActivity(adapterview);
            return;
_L4:
            Pinalytics.a(ElementType.EMAIL_BUTTON, ComponentType.USER_FEED);
            return;
        }

        _cls3()
        {
            this$0 = InviteFriendFragment.this;
            super();
        }

        private class _cls4
        {

            static final int $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[];

            static 
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType = new int[com.pinterest.activity.search.model.TypeAheadItem.ItemType.values().length];
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.PINNER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_PLACEHOLDER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

    }

}
