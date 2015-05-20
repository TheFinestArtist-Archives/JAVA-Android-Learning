// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.findfriend;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.pinterest.activity.sendapin.ui.EmptySearchCell;
import com.pinterest.activity.sendapin.ui.ProgressSpinnerListCell;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Device;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.findfriend:
//            FindFriendAdapter

public class FindFriendsFragment extends BaseFragment
{

    private EmptySearchCell _emptyPlaceholder;
    private ListView _listView;
    private FindFriendAdapter _listViewAdapter;
    private boolean _refreshOnResume;
    private SearchEditText _searchEt;
    private android.widget.AdapterView.OnItemClickListener onListCellClickListener;
    private android.widget.AbsListView.OnScrollListener onListViewScrollListener;
    private TextWatcher searchTextWatcher;

    public FindFriendsFragment()
    {
        searchTextWatcher = new _cls3();
        onListViewScrollListener = new _cls4();
        onListCellClickListener = new _cls5();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f030083;
        _menuId = 0x7f100005;
        Experiments.a("android_new_find_friends");
    }

    protected void onDeactivate()
    {
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
        _actionBar.setTitle(0x7f0e0222);
        _emptyPlaceholder = (EmptySearchCell)view.findViewById(0x7f0b0259);
        _emptyPlaceholder.setText(Resources.string(0x7f0e0228));
        _searchEt = (SearchEditText)((ViewGroup)view.findViewById(0x7f0b0250)).findViewById(0x7f0b014d);
        _searchEt.addTextChangedListener(searchTextWatcher);
        _searchEt.setOnEditorActionListener(new _cls1());
        _listView = (ListView)view.findViewById(0x7f0b0129);
        _listViewAdapter = new FindFriendAdapter(getActivity());
        _listViewAdapter.setApiTag(getApiTag());
        view = new ProgressSpinnerListCell(getActivity());
        _listView.addFooterView(view, null, true);
        _listViewAdapter.setFooterView(view);
        _listViewAdapter.setSpinnerState(true);
        _listView.setAdapter(_listViewAdapter);
        _listView.setOnItemClickListener(onListCellClickListener);
        _listView.setOnScrollListener(onListViewScrollListener);
        _listView.setSelection(0);
        _searchEt.postDelayed(new _cls2(), 200L);
    }





/*
    static boolean access$302(FindFriendsFragment findfriendsfragment, boolean flag)
    {
        findfriendsfragment._refreshOnResume = flag;
        return flag;
    }

*/

    private class _cls3
        implements TextWatcher
    {

        final FindFriendsFragment this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            EmptySearchCell emptysearchcell = _emptyPlaceholder;
            if (charsequence.length() <= 0)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            emptysearchcell.setVisibility(i);
            _listViewAdapter.onSearchQueryChanged(charsequence.toString());
        }

        _cls3()
        {
            this$0 = FindFriendsFragment.this;
            super();
        }
    }


    private class _cls4
        implements android.widget.AbsListView.OnScrollListener
    {

        final FindFriendsFragment this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (i == 1 && _searchEt != null)
            {
                Device.hideSoftKeyboard(_searchEt);
            }
        }

        _cls4()
        {
            this$0 = FindFriendsFragment.this;
            super();
        }
    }


    private class _cls5
        implements android.widget.AdapterView.OnItemClickListener
    {

        final FindFriendsFragment this$0;

        private Intent getContactViewIntent(String s)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.withAppendedPath(android.provider.ContactsContract.Contacts.CONTENT_URI, s));
            return intent;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = ((AdapterView) (_listViewAdapter.getItem(i)));
            if (!(adapterview instanceof TypeAheadItem)) goto _L2; else goto _L1
_L1:
            adapterview = (TypeAheadItem)adapterview;
            _cls6..SwitchMap.com.pinterest.activity.search.model.TypeAheadItem.ItemType[adapterview.getItemType().ordinal()];
            JVM INSTR tableswitch 1 6: default 72
        //                       1 73
        //                       2 73
        //                       3 100
        //                       4 100
        //                       5 137
        //                       6 189;
               goto _L2 _L3 _L3 _L4 _L4 _L5 _L6
_L2:
            return;
_L3:
            Pinalytics.a(ElementType.USER_LIST_USER, ComponentType.USER_FEED);
            Events.post(new Navigation(Location.USER, adapterview.getUid()));
            return;
_L4:
            Pinalytics.a(ElementType.USER_LIST_CONTACT, ComponentType.USER_FEED);
            adapterview = getContactViewIntent(adapterview.getUid());
            Device.hideSoftKeyboard(_searchEt);
            startActivity(adapterview);
            return;
_L5:
            Pinalytics.a(ElementType.EMAIL_BUTTON, ComponentType.USER_FEED);
            adapterview = _searchEt.getText().toString();
            if (_listViewAdapter.inviteUserEmail(adapterview, adapterview, null))
            {
                _searchEt.setText("");
                return;
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
_L6:
            Pinalytics.a(ElementType.FACEBOOK_CONNECT, ComponentType.USER_FEED);
            if (getActivity() != null)
            {
                Events.post(new com.pinterest.base.Social.RequestConnectEvent(com.pinterest.base.Social.Network.FACEBOOK));
                _refreshOnResume = true;
                return;
            }
            if (true) goto _L2; else goto _L7
_L7:
        }

        _cls5()
        {
            this$0 = FindFriendsFragment.this;
            super();
        }

        private class _cls6
        {

            static final int $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[];

            static 
            {
                $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType = new int[com.pinterest.activity.search.model.TypeAheadItem.ItemType.values().length];
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.PINNER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.MUTUAL_FOLLOW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.PHONE_CONTACT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_CONTACT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.EMAIL_PLACEHOLDER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$search$model$TypeAheadItem$ItemType[com.pinterest.activity.search.model.TypeAheadItem.ItemType.CONNECT_FB_PLACEHOLDER.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

    }


    private class _cls1
        implements android.widget.TextView.OnEditorActionListener
    {

        final FindFriendsFragment this$0;

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
            this$0 = FindFriendsFragment.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final FindFriendsFragment this$0;

        public void run()
        {
            _searchEt.requestFocusFromTouch();
            Device.showSoftKeyboard(_searchEt);
        }

        _cls2()
        {
            this$0 = FindFriendsFragment.this;
            super();
        }
    }

}
