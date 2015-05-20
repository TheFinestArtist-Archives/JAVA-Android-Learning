// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user;

import android.os.Bundle;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.view.ModifiedViewPager;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.fragment.ViewPagerFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.user.adapter.UserViewAdapter;
import com.pinterest.activity.user.view.UserHeaderView;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.actions.SynchronizedPagerChild;
import com.pinterest.ui.tab.Tab;
import com.pinterest.ui.tab.TabBar;
import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.user:
//            UserImageDialog

public class UserFragment extends ViewPagerFragment
{

    private static final int HEADER_HEIGHT;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    TabBar _tabBar;
    private User _user;
    LinearLayout _userHeader;
    UserHeaderView _userHeaderView;
    private android.support.v4.view.ModifiedViewPager.OnPageChangeListener onPageChanged;
    private com.pinterest.ui.tab.TabBar.Listener onTabChanged;
    private com.pinterest.api.remote.UserApi.UserApiResponse onUserLoad;

    public UserFragment()
    {
        onPageChanged = new _cls2();
        onUserLoad = new _cls3();
        onTabChanged = new _cls4();
        _eventsSubscriber = new _cls5();
    }

    private void adjustChildTop(int i)
    {
        ArrayList arraylist = _viewAdapter.getFragments();
        if (arraylist == null || i >= arraylist.size())
        {
            return;
        } else
        {
            ((SynchronizedPagerChild)arraylist.get(i)).adjustScroll((int)(-_userHeader.getTranslationY()));
            return;
        }
    }

    private void adjustHeaderTop(int i)
    {
        i = Math.min(i, HEADER_HEIGHT);
        _userHeader.setTranslationY(-i);
    }

    private void updateUser()
    {
        if (_user != null)
        {
            if (_viewAdapter != null)
            {
                ((UserViewAdapter)_viewAdapter).setUser(_user);
            }
            if (_userHeaderView != null)
            {
                _userHeaderView.setUser(_user);
                return;
            }
        }
    }

    public void loadData()
    {
        UserApi.a(getNavigation().getId(), onUserLoad, getApiTag());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300b0;
        _offScreenLimit = 2;
        _viewAdapter = new UserViewAdapter(getChildFragmentManager());
        ((UserViewAdapter)_viewAdapter).setUser(_user);
        ((UserViewAdapter)_viewAdapter).setChildListener(new _cls1());
    }

    public void onDestroy()
    {
        if (_viewAdapter != null)
        {
            ((UserViewAdapter)_viewAdapter).setChildListener(null);
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/User$UpdateEvent
        });
        ButterKnife.a(this);
        super.onDestroyView();
    }

    void onUserImageClicked()
    {
        if (_user == null || getView() == null)
        {
            return;
        } else
        {
            Pinalytics.a(ElementType.PROFILE_IMAGE, ComponentType.NAVIGATION, _user.getUid());
            Events.post(new DialogEvent(new UserImageDialog(_user)));
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _actionBarWrapper.setShadowVisibility(8);
        _viewPager.setCurrentItem(0);
        _viewPager.setOnPageChangeListener(onPageChanged);
        if (!MyUser.isUserMe(_user))
        {
            ((Tab)_tabBar.getChildAt(0)).setText(Resources.string(0x7f0e0089));
            ((Tab)_tabBar.getChildAt(1)).setText(Resources.string(0x7f0e037f));
        }
        _tabBar.setCurrentIndex(0);
        _tabBar.setListener(onTabChanged);
        loadData();
        updateUser();
        Events.register(_eventsSubscriber, com/pinterest/api/model/User$UpdateEvent, new Class[0]);
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        if (navigation == null)
        {
            return;
        }
        _user = _navigation.getModelAsUser();
        if (MyUser.isUserMe(_user))
        {
            if (Experiments.o())
            {
                _menuId = 0x7f100006;
            } else
            {
                _menuId = 0x7f100004;
            }
            Experiments.a("android_new_find_friends");
        }
        updateUser();
    }

    static 
    {
        HEADER_HEIGHT = Constants.ITEM_HEIGHT;
    }






/*
    static User access$402(UserFragment userfragment, User user)
    {
        userfragment._user = user;
        return user;
    }

*/




    private class _cls2
        implements android.support.v4.view.ModifiedViewPager.OnPageChangeListener
    {

        final UserFragment this$0;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            if (j > 0)
            {
                UserFragment userfragment = UserFragment.this;
                if (i < setCurrentIndex.getCurrentItem())
                {
                    j = i;
                } else
                {
                    j = i + 1;
                }
                userfragment.adjustChildTop(j);
            }
            _tabBar.setPagerScroll(i, f);
            if (_userHeader.getTranslationY() < (float)(-Constants.ITEM_HEIGHT))
            {
                _userHeader.setTranslationY(-Constants.ITEM_HEIGHT);
            }
        }

        public void onPageSelected(int i)
        {
            _tabBar.setCurrentIndex(i);
            Pinalytics.a(UserFragment.this);
            adjustChildTop(i);
            Pair pair = ((Scrollable)access$300.getFragments().get(i)).getScrollPosition();
            if ((float)((Integer)pair.second).intValue() < -_userHeader.getTranslationY())
            {
                _userHeader.setTranslationY(-((Integer)pair.second).intValue());
            }
        }

        _cls2()
        {
            this$0 = UserFragment.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.api.remote.UserApi.UserApiResponse
    {

        final UserFragment this$0;

        public void onSuccess(User user)
        {
            _user = user;
            updateUser();
        }

        _cls3()
        {
            this$0 = UserFragment.this;
            super();
        }
    }




    private class _cls1 extends com.pinterest.activity.user.adapter.UserViewAdapter.ChildListener
    {

        final UserFragment this$0;

        public void onChildScrolled(int i)
        {
            adjustHeaderTop(i);
        }

        _cls1()
        {
            this$0 = UserFragment.this;
            super();
        }
    }

}
