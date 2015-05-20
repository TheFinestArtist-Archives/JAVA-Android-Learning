// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.DialogHelper;
import com.pinterest.activity.pin.adapter.IconTextListAdapter;
import com.pinterest.activity.pin.gridcells.PinCloseupSubView;
import com.pinterest.activity.report.ReportPinDialog;
import com.pinterest.activity.sendapin.SendPinActivity;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.model.Location;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.remote.PinApi;
import com.pinterest.base.Colors;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.SocialUtils;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import java.util.ArrayList;
import java.util.List;

public class PinCloseupAccessoryActionBar extends PinCloseupSubView
    implements android.support.v7.widget.Toolbar.OnMenuItemClickListener, android.view.View.OnClickListener
{

    private Toolbar _actionBar;
    private View _divider;
    private MenuItem _editMenuItem;
    private MenuItem _likeMenuItem;
    private ListPopupWindow _overflowPoup;
    private Pin _pin;
    private View _pinItButton;
    private MenuItem _sendMenuItem;
    private MenuItem _shareMenuItem;
    private ListPopupWindow _sharePopup;

    public PinCloseupAccessoryActionBar(Context context)
    {
        this(context, null);
    }

    public PinCloseupAccessoryActionBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PinCloseupAccessoryActionBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void ensureOverflowPopup()
    {
        if (_overflowPoup != null)
        {
            return;
        }
        MenuBuilder menubuilder = new MenuBuilder(getContext());
        (new MenuInflater(getContext())).inflate(0x7f100008, menubuilder);
        final IconTextListAdapter adapter = new IconTextListAdapter();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        int i = 0;
        for (int j = menubuilder.size(); i < j; i++)
        {
            MenuItem menuitem = menubuilder.getItem(i);
            arraylist.add(new com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText(null, String.valueOf(menuitem.getTitle()), null));
            arraylist1.add(Integer.valueOf(menuitem.getItemId()));
        }

        adapter.setDataSource(arraylist);
        adapter.setIds(arraylist1);
        _overflowPoup = new ListPopupWindow(getContext());
        _overflowPoup.setAdapter(adapter);
        _overflowPoup.setAnchorView(_actionBar.findViewById(0x7f0b0318));
        _overflowPoup.setModal(true);
        _overflowPoup.setContentWidth((int)Resources.dimension(0x7f0a009e));
        _overflowPoup.setOnItemClickListener(new _cls3());
    }

    private void ensureSharePopup()
    {
        if (_sharePopup != null)
        {
            return;
        } else
        {
            View view = _actionBar.findViewById(0x7f0b0317);
            _sharePopup = new ListPopupWindow(getContext());
            final IconTextListAdapter adapter = new IconTextListAdapter();
            List list = SocialUtils.getAppListForShare();
            list.add(new com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText(null, Resources.string(0x7f0e0436), null));
            adapter.setDataSource(list);
            _sharePopup.setAdapter(adapter);
            _sharePopup.setAnchorView(view);
            _sharePopup.setModal(true);
            _sharePopup.setContentWidth((int)Resources.dimension(0x7f0a009e));
            _sharePopup.setOnItemClickListener(new _cls2());
            return;
        }
    }

    private void onEditClicked()
    {
        Intent intent = ActivityHelper.getPinEditIntent(getContext());
        intent.putExtra("com.pinterest.EXTRA_PIN_ID", _pin.getUid());
        ((Activity)getContext()).startActivityForResult(intent, 10300);
    }

    private void onLikeClicked()
    {
        int i = 1;
        Pin pin = _pin;
        int j;
        boolean flag;
        if (_pin.getLiked() != Boolean.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        pin.setLiked(Boolean.valueOf(flag));
        pin = _pin;
        j = _pin.getLikeCountDisplay();
        if (!_pin.getLiked().booleanValue())
        {
            i = -1;
        }
        pin.setLikeCount(Integer.valueOf(i + j));
        Events.post(new com.pinterest.api.model.Pin.UpdateEvent(_pin));
        updateView();
        Pinalytics.a(ElementType.PIN_LIKE_BUTTON, ComponentType.MODAL_PIN, _pin.getUid());
        PinApi.a(_pin.getUid(), _pin.getLiked().booleanValue(), new _cls1(_pin));
    }

    private void onOverflowClicked()
    {
        Pinalytics.a(ElementType.MENU_BUTTON, ComponentType.NAVIGATION);
        ensureOverflowPopup();
        _overflowPoup.show();
    }

    private void onPinItClicked()
    {
        Pinalytics.a(ElementType.PIN_REPIN_BUTTON, ComponentType.MODAL_PIN, _pin.getUid());
        StopWatch.get().start("repin_dialog");
        Events.post(new Navigation(Location.REPIN, _pin));
    }

    private void onReportClicked()
    {
        Events.post(new DialogEvent(new ReportPinDialog(_pin.getUid())));
    }

    private void onSaveClicked()
    {
        Pinalytics.a(ElementType.PIN_SAVE_BUTTON, ComponentType.MODAL_PIN, _pin.getUid());
        (new _cls4()).execute();
    }

    private void onSendClicked()
    {
        Pinalytics.a(ElementType.PIN_SEND_BUTTON, ComponentType.NAVIGATION);
        SendPinActivity.startSendPin(getContext(), _pin.getUid());
    }

    private void onShareClicked()
    {
        Pinalytics.a(ElementType.PIN_SHARE, ComponentType.NAVIGATION);
        ensureSharePopup();
        _sharePopup.show();
    }

    private void onShareMoreClicked()
    {
        Pinalytics.a(ElementType.SHARE_SOCIAL_BUTTON, ComponentType.NAVIGATION, "more");
        SocialUtils.startShare(getContext(), _pin);
    }

    private void onSignupClicked()
    {
        Pinalytics.a(ElementType.SIGNUP_BUTTON, ComponentType.NAVIGATION);
        DialogHelper.goSignup();
    }

    public View getPinItButton()
    {
        return _pinItButton;
    }

    protected void init()
    {
        setOrientation(1);
        _divider = new View(getContext());
        _divider.setBackgroundColor(Resources.color(0x7f090047));
        addView(_divider, -1, Constants.HAIRLINE);
        _actionBar = new Toolbar(getContext(), null, 0x7f0f0006);
        _actionBar.setBackgroundColor(Resources.color(0x7f09000a));
        _actionBar.setMinimumHeight(Constants.ACTIONBAR_HEIGHT);
        addView(_actionBar, -1, Constants.ACTIONBAR_HEIGHT);
        if (MyUser.hasAccessToken())
        {
            _actionBar.inflateMenu(0x7f100009);
            _pinItButton = _actionBar.findViewById(0x7f0b01c8);
            _pinItButton.setOnClickListener(this);
        } else
        {
            _actionBar.setTitle(0x7f0e02bf);
            _actionBar.setSubtitle(0x7f0e02a9);
            _actionBar.inflateMenu(0x7f10000a);
            _actionBar.findViewById(0x7f0b00af).setOnClickListener(this);
        }
        _actionBar.setOnMenuItemClickListener(this);
        DrawableUtils.tintToolbarIcons(_actionBar, 0x7f090043, false);
        updateView();
    }

    public void onClick(View view)
    {
        if (_pin == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131427503: 
            onSignupClicked();
            return;

        case 2131427784: 
            onPinItClicked();
            break;
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (_overflowPoup != null)
        {
            _overflowPoup.dismiss();
        }
        if (_sharePopup != null)
        {
            _sharePopup.dismiss();
        }
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        if (_pin == null)
        {
            return false;
        }
        menuitem.getItemId();
        JVM INSTR tableswitch 2131428116 2131428121: default 52
    //                   2131428116 54
    //                   2131428117 61
    //                   2131428118 68
    //                   2131428119 75
    //                   2131428120 82
    //                   2131428121 89;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return true;
_L2:
        onEditClicked();
        continue; /* Loop/switch isn't completed */
_L3:
        onLikeClicked();
        continue; /* Loop/switch isn't completed */
_L4:
        onSendClicked();
        continue; /* Loop/switch isn't completed */
_L5:
        onShareClicked();
        continue; /* Loop/switch isn't completed */
_L6:
        onOverflowClicked();
        continue; /* Loop/switch isn't completed */
_L7:
        onPinItClicked();
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void setPin(Pin pin)
    {
        _pin = pin;
        updateView();
    }

    protected boolean shouldUpdateView()
    {
        return true;
    }

    protected void updateView()
    {
        boolean flag1 = true;
        if (_pin != null && _actionBar != null)
        {
            if (_shareMenuItem == null)
            {
                _shareMenuItem = _actionBar.getMenu().findItem(0x7f0b0317);
            }
            boolean flag;
            if (_shareMenuItem != null)
            {
                MenuItem menuitem = _shareMenuItem;
                if (!_pin.isSecret())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                menuitem.setVisible(flag);
            }
            if (_sendMenuItem == null)
            {
                _sendMenuItem = _actionBar.getMenu().findItem(0x7f0b0316);
            }
            if (_sendMenuItem != null)
            {
                menuitem = _sendMenuItem;
                if (!_pin.isSecret())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                menuitem.setVisible(flag);
            }
            if (_editMenuItem == null)
            {
                _editMenuItem = _actionBar.getMenu().findItem(0x7f0b0314);
            }
            if (_editMenuItem != null)
            {
                _editMenuItem.setVisible(MyUser.isUserMe(_pin.getUser()));
            }
            if (_likeMenuItem == null)
            {
                _likeMenuItem = _actionBar.getMenu().findItem(0x7f0b0315);
            }
            if (_likeMenuItem != null)
            {
                menuitem = _likeMenuItem;
                if (!MyUser.isUserMe(_pin.getUser()))
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                menuitem.setVisible(flag);
            }
            if (_likeMenuItem != null)
            {
                menuitem = _likeMenuItem;
                int i;
                if (_pin.getLiked() == Boolean.TRUE)
                {
                    i = Colors.RED;
                } else
                {
                    i = Colors.GRAY_SOLID;
                }
                DrawableUtils.tintIcon(menuitem, i);
                return;
            }
        }
    }







    private class _cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PinCloseupAccessoryActionBar this$0;
        final IconTextListAdapter val$adapter;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (i < 0 || i >= adapter.getCount()) goto _L2; else goto _L1
_L1:
            (int)l;
            JVM INSTR tableswitch 2131428114 2131428115: default 40
        //                       2131428114 71
        //                       2131428115 61;
               goto _L2 _L3 _L4
_L2:
            if (_overflowPoup != null)
            {
                _overflowPoup.dismiss();
            }
            return;
_L4:
            onReportClicked();
            continue; /* Loop/switch isn't completed */
_L3:
            onSaveClicked();
            if (true) goto _L2; else goto _L5
_L5:
        }

        _cls3()
        {
            this$0 = PinCloseupAccessoryActionBar.this;
            adapter = icontextlistadapter;
            super();
        }
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PinCloseupAccessoryActionBar this$0;
        final IconTextListAdapter val$adapter;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (i >= 0 && i < adapter.getCount())
            {
                if (i != adapter.getCount() - 1)
                {
                    adapterview = (com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText)adapter.getItem(i);
                    Pinalytics.a(ElementType.SHARE_SOCIAL_BUTTON, ComponentType.NAVIGATION, ((com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText) (adapterview)).meta);
                    SocialUtils.startShare(getContext(), _pin, ((com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText) (adapterview)).text, ((com.pinterest.activity.pin.adapter.IconTextListAdapter.IconText) (adapterview)).meta);
                } else
                {
                    onShareMoreClicked();
                }
            }
            if (_sharePopup != null)
            {
                _sharePopup.dismiss();
            }
        }

        _cls2()
        {
            this$0 = PinCloseupAccessoryActionBar.this;
            adapter = icontextlistadapter;
            super();
        }
    }


    private class _cls1 extends com.pinterest.api.remote.PinApi.PinLikeApiResponse
    {

        final PinCloseupAccessoryActionBar this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            if (_pin != null)
            {
                throwable = _pin;
                int i;
                boolean flag;
                if (!_pin.getLiked().booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                throwable.setLiked(Boolean.valueOf(flag));
                throwable = _pin;
                if (_pin.getLiked().booleanValue())
                {
                    i = _pin.getLikeCountDisplay() + 1;
                } else
                {
                    i = _pin.getLikeCountDisplay() - 1;
                }
                throwable.setLikeCount(Integer.valueOf(i));
                ModelHelper.setPin(_pin);
                updateView();
            }
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            if (_pin != null)
            {
                if (_pin.getLiked().booleanValue())
                {
                    apiresponse = EventType.PIN_LIKE;
                } else
                {
                    apiresponse = EventType.PIN_UNLIKE;
                }
                Pinalytics.a(apiresponse, _pin.getUid(), _pin.getLoggingAuxData());
                ModelHelper.setPin(_pin);
            }
        }

        _cls1(Pin pin)
        {
            this$0 = PinCloseupAccessoryActionBar.this;
            super(pin);
        }
    }


    private class _cls4 extends BackgroundTask
    {

        private boolean saved;
        final PinCloseupAccessoryActionBar this$0;

        public void onFinish()
        {
            super.onFinish();
            Pinalytics.a(EventType.PIN_SAVE_TO_DEVICE, _pin.getUid());
            int i;
            int j;
            if (saved)
            {
                i = 0x7f0e0369;
            } else
            {
                i = 0x7f0e0368;
            }
            if (saved)
            {
                j = 0;
            } else
            {
                j = 0x7f0200fa;
            }
            Application.showToast(i, j);
        }

        public void run()
        {
            saved = ImageCache.saveImageToGallery(_pin.getImageLargeUrl());
        }

        _cls4()
        {
            this$0 = PinCloseupAccessoryActionBar.this;
            super();
            saved = false;
        }
    }

}
