// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.pinterest.activity.sendapin.ui.ProgressSpinnerListCell;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.ui.actionsheet.ActionSheetFragment;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            NewFindFriendsListAdapter, NewFindFriendsHeaderView

public class NewFindFriendsContactFragment extends BaseFragment
{

    private ActionSheetFragment _actionSheet;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private NewFindFriendsHeaderView _header;
    ListView _listView;
    private NewFindFriendsListAdapter _listViewAdapter;
    private android.widget.AbsListView.OnScrollListener _onListViewScrollListener;
    private boolean _refreshOnResume;
    SearchEditText _searchEt;
    private TextWatcher _searchTextWatcher;

    public NewFindFriendsContactFragment()
    {
        _refreshOnResume = false;
        _eventsSubscriber = new _cls2();
        _searchTextWatcher = new _cls3();
        _onListViewScrollListener = new _cls4();
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/activity/invitefriend/FriendSearchAdapter$ContactsChangeEvent, new Class[0]);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030092;
    }

    protected void onDeactivate()
    {
        Events.unregister(_eventsSubscriber);
        Device.hideSoftKeyboard(_searchEt);
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
        view = getActivity();
        _actionSheet = new ActionSheetFragment();
        _listViewAdapter = new NewFindFriendsListAdapter(view, _actionSheet);
        _listViewAdapter.setApiTag(getApiTag());
        bundle = new ProgressSpinnerListCell(view);
        _header = new NewFindFriendsHeaderView(view);
        _listView.addHeaderView(_header);
        _listView.addFooterView(bundle, null, false);
        _listViewAdapter.setFooterView(bundle);
        _listViewAdapter.setSpinnerState(true);
        _listView.setAdapter(_listViewAdapter);
        _listView.setOnScrollListener(_onListViewScrollListener);
        _listView.setSelection(0);
        _listViewAdapter.refresh();
        _searchEt.addTextChangedListener(_searchTextWatcher);
        _searchEt.setOnEditorActionListener(new _cls1());
    }



    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final NewFindFriendsContactFragment this$0;

        public void onEventMainThread(FriendSearchAdapter.ContactsChangeEvent contactschangeevent)
        {
            if (_header != null)
            {
                _header.updateFriendsCount(contactschangeevent.size);
            }
        }

        _cls2()
        {
            this$0 = NewFindFriendsContactFragment.this;
            super();
        }
    }


    private class _cls3
        implements TextWatcher
    {

        final NewFindFriendsContactFragment this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            _listViewAdapter.onSearchQueryChanged(charsequence.toString());
        }

        _cls3()
        {
            this$0 = NewFindFriendsContactFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.widget.AbsListView.OnScrollListener
    {

        final NewFindFriendsContactFragment this$0;

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

        _cls4()
        {
            this$0 = NewFindFriendsContactFragment.this;
            super();
        }
    }


    private class _cls1
        implements android.widget.TextView.OnEditorActionListener
    {

        final NewFindFriendsContactFragment this$0;

        public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
        {
            if (ViewHelper.isKeyboardAction(3, i, keyevent))
            {
                textview.clearFocus();
                Device.hideSoftKeyboard(textview);
                return true;
            } else
            {
                return false;
            }
        }

        _cls1()
        {
            this$0 = NewFindFriendsContactFragment.this;
            super();
        }
    }

}
