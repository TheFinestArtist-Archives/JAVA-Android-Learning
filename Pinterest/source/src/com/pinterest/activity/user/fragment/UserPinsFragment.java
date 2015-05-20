// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.user.UserBaseFragment;
import com.pinterest.activity.user.view.UserMetadataView;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Constants;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.actions.SynchronizedPagerChild;
import com.pinterest.ui.grid.PinterestGridView;

public class UserPinsFragment extends PinGridFragment
    implements UserBaseFragment, SynchronizedPagerChild
{

    private View _searchBar;
    protected User _user;
    private UserMetadataView _userMetadataView;

    public UserPinsFragment()
    {
        _swipeOffsetEnd = (int)Resources.dimension(0x7f0a0107) + Constants.MARGIN;
        _swipeOffsetStart = _swipeOffsetEnd - Constants.SWIPE_OFFSET_LENGTH;
        ((PinGridAdapter)_adapter).setRenderUser(false);
    }

    public void adjustScroll(int i)
    {
        scrollTo(0, i, true);
    }

    public User getUser()
    {
        return _user;
    }

    protected void initHeader()
    {
        _userMetadataView = new UserMetadataView(getView().getContext());
        _userMetadataView.setUser(_user);
        _userMetadataView.setMetadataBarMode(com.pinterest.ui.actionbar.MetadataBar.Mode.PINS);
        _gridVw.addHeaderView(_userMetadataView, -1, -2);
        if (MyUser.isUserMe(_navigation.getId()))
        {
            _searchBar = _gridVw.addHeaderView(0x7f03012a);
            ((TextView)_searchBar.findViewById(0x7f0b02a0)).setText(Resources.string(0x7f0e042c));
            _searchBar.setOnClickListener(new _cls1());
        }
    }

    protected void loadData()
    {
        String s = getNavigation().getId();
        if (ModelHelper.isValid(s))
        {
            UserApi.a(s, new com.pinterest.api.remote.PinApi.PinFeedApiResponse(gridResponseHandler), getApiTag());
        }
        super.loadData();
    }

    public void onDestroyView()
    {
        if (_searchBar != null)
        {
            _searchBar.setOnClickListener(null);
            _searchBar = null;
        }
        _userMetadataView = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        initHeader();
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        if (navigation == null)
        {
            return;
        } else
        {
            _user = navigation.getModelAsUser();
            return;
        }
    }

    protected void updateEmptyContent()
    {
        _emptyLeftImage = 0x7f020163;
        _emptyCenterImage = 0x7f02016b;
        _emptyRightImage = 0x7f020166;
        String s;
        if (_navigation == null)
        {
            s = "";
        } else
        {
            s = _navigation.getId();
        }
        if (MyUser.isUserMe(s))
        {
            _emptyMessage = Resources.string(0x7f0e01fc);
            return;
        }
        if (_user != null && !TextUtils.isEmpty(_user.getFirstName()))
        {
            _emptyMessage = Resources.string(0x7f0e01ff, new Object[] {
                _user.getFirstName()
            });
            return;
        } else
        {
            _emptyMessage = Resources.string(0x7f0e0200);
            return;
        }
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UserPinsFragment this$0;

        public void onClick(View view)
        {
            view = new Navigation(Location.SEARCH, "");
            view.putExtra("com.pinterest.EXTRA_SEARCH_MODE", "VALUE_SEARCH_LOCAL");
            Events.post(view);
        }

        _cls1()
        {
            this$0 = UserPinsFragment.this;
            super();
        }
    }

}
