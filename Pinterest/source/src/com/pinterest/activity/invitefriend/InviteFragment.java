// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ModifiedViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pinterest.activity.home.events.HomeControlEvent;
import com.pinterest.activity.task.fragment.ViewPagerFragment;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Application;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.tab.TabBar;
import com.pinterest.ui.text.PButton;
import com.pinterest.ui.text.SearchEditText;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            InviteViewAdapter

public class InviteFragment extends ViewPagerFragment
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private ActionBar _inviteActionBar;
    private PButton _inviteBtn;
    private TextView _inviteTv;
    private SearchEditText _searchEt;
    private TabBar _tabBar;
    private android.view.View.OnClickListener onBulkInviteClickListener;
    private android.support.v4.view.ModifiedViewPager.OnPageChangeListener onPageChanged;
    private com.pinterest.ui.tab.TabBar.Listener onTabChanged;
    private TextWatcher searchTextWatcher;

    public InviteFragment()
    {
        onBulkInviteClickListener = new _cls2();
        onPageChanged = new _cls3();
        onTabChanged = new _cls4();
        searchTextWatcher = new _cls5();
        _eventsSubscriber = new _cls6();
    }

    private void initializePinvitational()
    {
        ViewHelper.setVisibility(_inviteTv, false);
        MyUserApi.a(new _cls7(), getApiTag());
    }

    private void tryRedirectTab()
    {
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("com.pinterest.EXTRA_HOME_CONTROL"))
        {
            Events.postSticky(new HomeControlEvent(intent.getIntExtra("com.pinterest.EXTRA_HOME_CONTROL", 1)));
        }
    }

    public boolean onBackPressed()
    {
        if (_viewPager.getCurrentItem() != 0)
        {
            _viewPager.setCurrentItem(0, true);
            _tabBar.setCurrentIndex(0);
            return true;
        } else
        {
            return false;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03008d;
        _menuId = 0;
        _offScreenLimit = 2;
        setHasOptionsMenu(Device.hasHardwareMenuKey(Application.context()));
        _viewAdapter = new InviteViewAdapter(getChildFragmentManager());
        Experiments.a("android_new_find_friends");
    }

    protected void onDeactivate()
    {
        Device.hideSoftKeyboard(_searchEt);
        super.onDeactivate();
    }

    public void onPause()
    {
        Events.unregister(_eventsSubscriber);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Events.registerSticky(_eventsSubscriber, com/pinterest/activity/home/events/HomeControlEvent, new Class[] {
            com/pinterest/activity/invitefriend/PinvitationalConfirmFragment$InviteConfirmEvent
        });
        if (Experiments.g())
        {
            initializePinvitational();
        }
        tryRedirectTab();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _viewPager.setCurrentItem(0);
        _viewPager.setOnPageChangeListener(onPageChanged);
        _tabBar = (TabBar)view.findViewById(0x7f0b0062);
        _tabBar.setCurrentIndex(0);
        _tabBar.setListener(onTabChanged);
        _actionBar.setTitle(0x7f0e029e);
        _inviteBtn = (PButton)LayoutInflater.from(view.getContext()).inflate(0x7f03011c, _actionBar, false);
        _inviteBtn.setText(0x7f0e029b);
        _inviteBtn.setStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
        _inviteBtn.setOnClickListener(onBulkInviteClickListener);
        _actionBar.addView(_inviteBtn);
        bundle = (android.support.v7.widget.Toolbar.LayoutParams)_inviteBtn.getLayoutParams();
        bundle.gravity = 5;
        bundle.setMargins(Constants.MARGIN, 0, Constants.MARGIN, 0);
        _inviteActionBar = (ActionBar)view.findViewById(0x7f0b0061);
        _inviteActionBar.getActionBar().setTitle(0x7f0e029e);
        view = (ViewGroup)view.findViewById(0x7f0b0250);
        _inviteTv = (TextView)view.findViewById(0x7f0b0251);
        _searchEt = (SearchEditText)view.findViewById(0x7f0b014d);
        _searchEt.addTextChangedListener(searchTextWatcher);
        _searchEt.setOnEditorActionListener(new _cls1());
    }










    private class _cls2
        implements android.view.View.OnClickListener
    {

        final InviteFragment this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.SEND_INVITE_BUTTON, ComponentType.BULK_INVITE);
            Events.post(new InviteCreateEvent(true));
        }

        _cls2()
        {
            this$0 = InviteFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.support.v4.view.ModifiedViewPager.OnPageChangeListener
    {

        final InviteFragment this$0;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            _tabBar.setPagerScroll(i, f);
        }

        public void onPageSelected(int i)
        {
            Events.post(new TabChangedEvent(_searchEt.getText()));
            _tabBar.setCurrentIndex(i);
            if (i == 1)
            {
                _inviteBtn.setVisibility(8);
            } else
            {
                _inviteBtn.setVisibility(0);
            }
            Pinalytics.a(InviteFragment.this);
        }

        _cls3()
        {
            this$0 = InviteFragment.this;
            super();
        }
    }





    private class _cls7 extends ApiResponseHandler
    {

        final InviteFragment this$0;

        public void onSuccess(ApiResponse apiresponse)
        {
            onSuccess(apiresponse);
            apiresponse = ((ApiResponse) (apiresponse.getData()));
            if (apiresponse instanceof PinterestJsonObject)
            {
                int i = ((PinterestJsonObject)apiresponse).a("remaining_quota", 0);
                PinvitationalData.setQuota(i);
                apiresponse = getResources().getQuantityString(0x7f0d0000, i);
                _inviteTv.setText(Html.fromHtml(String.format(apiresponse, new Object[] {
                    Integer.valueOf(i)
                })));
                ViewHelper.setVisibility(_inviteTv, true);
            }
        }

        _cls7()
        {
            this$0 = InviteFragment.this;
            super();
        }
    }


    private class _cls1
        implements android.widget.TextView.OnEditorActionListener
    {

        final InviteFragment this$0;

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
            this$0 = InviteFragment.this;
            super();
        }
    }

}
