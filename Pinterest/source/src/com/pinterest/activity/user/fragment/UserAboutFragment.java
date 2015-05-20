// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.user.UserBaseFragment;
import com.pinterest.activity.user.view.UserAboutBioView;
import com.pinterest.activity.user.view.UserAboutFlagView;
import com.pinterest.activity.user.view.UserAboutSetPictureView;
import com.pinterest.activity.user.view.UserAboutSitesView;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.actions.Scrollable;
import com.pinterest.ui.actions.SynchronizedPagerChild;
import com.pinterest.ui.scrollview.ObservableScrollView;

public class UserAboutFragment extends BaseFragment
    implements UserBaseFragment, Scrollable, SynchronizedPagerChild
{

    UserAboutBioView _aboutBio;
    ViewGroup _bioSitesWrapper;
    ObservableScrollView _contentVw;
    UserAboutFlagView _flagView;
    UserAboutSetPictureView _setPictureVw;
    UserAboutSitesView _sitesVw;
    private User _user;
    public com.pinterest.api.remote.MyUserApi.SettingsApiResponse onUserAboutUpdate;

    public UserAboutFragment()
    {
        onUserAboutUpdate = new _cls1(true);
    }

    private void updateDividers(User user)
    {
        View view = getView();
        if (view == null || user == null)
        {
            return;
        }
        if (!ModelHelper.isValid(user.getFacebookUrl()) && !ModelHelper.isValid(user.getTwitterUrl()))
        {
            view.findViewById(0x7f0b019e).setVisibility(8);
            return;
        } else
        {
            view.findViewById(0x7f0b019e).setVisibility(0);
            return;
        }
    }

    public void adjustScroll(int i)
    {
        scrollTo(0, i);
    }

    public User getUser()
    {
        return _user;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300b1;
    }

    public void onDestroyView()
    {
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        ButterKnife.a(this, view);
        if (_scrollListener != null)
        {
            _contentVw.addListener(_scrollListener);
        }
        _aboutBio.setApiTag(getApiTag());
        _aboutBio.setAboutUpdateListener(onUserAboutUpdate);
        _sitesVw.setAboutUpdateListener(onUserAboutUpdate);
        updateView();
    }

    public void scrollTo(int i, int j)
    {
        if (_contentVw != null)
        {
            _contentVw.scrollTo(i, j);
        }
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

    public void updateView()
    {
        while (getActivity() == null || _user == null) 
        {
            return;
        }
        updateDividers(_user);
        _setPictureVw.updateView(_user);
        _aboutBio.updateBio(_user);
        _sitesVw.updateSites(_user);
        _flagView.updateUi(_user);
        ViewGroup viewgroup = _bioSitesWrapper;
        boolean flag;
        if (!_aboutBio.isEmpty() || !_sitesVw.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ViewHelper.setVisibility(viewgroup, flag);
    }


/*
    static User access$002(UserAboutFragment useraboutfragment, User user)
    {
        useraboutfragment._user = user;
        return user;
    }

*/

    private class _cls1 extends com.pinterest.api.remote.MyUserApi.SettingsApiResponse
    {

        final UserAboutFragment this$0;

        public void onFailure(Throwable throwable, PinterestJsonObject pinterestjsonobject)
        {
            super.onFailure(throwable, pinterestjsonobject);
            updateView();
        }

        public void onSuccess(User user)
        {
            Pinalytics.a(EventType.USER_EDIT, null);
            if (getActivity() == null)
            {
                return;
            } else
            {
                _user = user;
                updateView();
                Application.showToastShort(0x7f0e0292);
                return;
            }
        }

        _cls1(boolean flag)
        {
            this$0 = UserAboutFragment.this;
            super(flag);
        }
    }

}
