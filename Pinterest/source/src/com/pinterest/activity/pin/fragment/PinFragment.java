// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.pinterest.activity.DialogHelper;
import com.pinterest.activity.map.GoogleServiceDialog;
import com.pinterest.activity.pin.view.PinCloseupAccessoryActionBar;
import com.pinterest.activity.pin.view.PinCloseupView;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.adapter.PinGridAdapter;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.remote.FeedApiResponseHandler;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.base.GooglePlayServices;
import com.pinterest.base.StopWatch;
import com.pinterest.experiment.Experiments;
import com.pinterest.fragment.PinGridFragment;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.data.DiskWatcher;
import com.pinterest.kit.utils.DrawableUtils;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;
import com.pinterest.ui.actionbar.ActionBar;
import com.pinterest.ui.grid.PinterestGridView;
import com.pinterest.ui.text.BevelTitleDivider;

public class PinFragment extends PinGridFragment
{

    private static final int GLOBAL_PADDING = (int)Resources.dimension(0x7f0a00a2);
    private final int RELATED_PIN_DELAY_MS = (int)(Math.random() * 300D) + 1000;
    private boolean _didHideHeader;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private PinCloseupAccessoryActionBar _floatingSubActionBar;
    private Handler _handler;
    private boolean _pendingHandler;
    protected Pin _pin;
    private PinCloseupView _pinVw;
    private BevelTitleDivider _relatedTitle;
    FrameLayout _rootVw;
    private DiskWatcher _screenShotDetector;
    private android.view.ViewTreeObserver.OnPreDrawListener onPreDrawListener;

    public PinFragment()
    {
        onPreDrawListener = new _cls4();
        _eventsSubscriber = new _cls5();
        _layoutId = 0x7f03009c;
        _handler = new Handler();
        _reshowActionBar = false;
        ((PinGridAdapter)_adapter).setIsRelatedContent(true);
        _screenShotDetector = new _cls1(DiskWatcher.findScreenShotPath(), 256);
    }

    private void onLoginClicked()
    {
        Pinalytics.a(ElementType.LOGIN_BUTTON, ComponentType.NAVIGATION);
        DialogHelper.goLogin();
    }

    private void scrollToHideHeader()
    {
        while (_didHideHeader || _gridVw == null || !_gridVw.canScroll() || _actionBarWrapper == null) 
        {
            return;
        }
        _gridVw.scrollTo(0, Constants.ACTIONBAR_HEIGHT);
        _actionBarWrapper.setTranslationY(Math.max(-Constants.ACTIONBAR_HEIGHT, -_gridVw.getScrolledY()));
        _didHideHeader = true;
    }

    private void updateFloatingBarState()
    {
        int i = 0x7f0b01c8;
        int j = 0;
        PinCloseupAccessoryActionBar pincloseupaccessoryactionbar;
        if (getView() != null && _floatingSubActionBar != null && _pinVw != null)
        {
            if ((pincloseupaccessoryactionbar = _pinVw.getAccessoryActionBar()) != null)
            {
                int ai[] = new int[2];
                pincloseupaccessoryactionbar.getLocationOnScreen(ai);
                int ai1[] = new int[2];
                _floatingSubActionBar.getLocationOnScreen(ai1);
                byte byte0;
                if (ai[1] < ai1[1])
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                    i = 0;
                    j = 0x7f0b01c8;
                }
                _floatingSubActionBar.setVisibility(byte0);
                if (_floatingSubActionBar.getPinItButton() != null)
                {
                    _floatingSubActionBar.getPinItButton().setId(j);
                }
                if (_pinVw.getAccessoryActionBar().getPinItButton() != null)
                {
                    _pinVw.getAccessoryActionBar().getPinItButton().setId(i);
                    return;
                }
            }
        }
    }

    private void updateView()
    {
        if (_pin != null)
        {
            if (_pinVw != null)
            {
                _pinVw.setPin(_pin);
            }
            if (_floatingSubActionBar != null)
            {
                _floatingSubActionBar.setPin(_pin);
                return;
            }
        }
    }

    protected void loadData()
    {
        if (!MyUser.hasAccessToken() || !_active || _pendingHandler || _adapter == null || ((PinGridAdapter)_adapter).getCount() != 0 || ((PinGridAdapter)_adapter).isLoading())
        {
            return;
        } else
        {
            _pendingHandler = true;
            _handler.postDelayed(new _cls6(), RELATED_PIN_DELAY_MS);
            return;
        }
    }

    protected void onActivate()
    {
        super.onActivate();
        if (_screenShotDetector != null)
        {
            _screenShotDetector.start();
        }
        if (_pinVw != null)
        {
            _pinVw.onActivate();
        }
        Events.register(_eventsSubscriber, com/pinterest/api/model/Pin$UpdateEvent, new Class[0]);
        loadData();
    }

    protected void onDeactivate()
    {
        if (_screenShotDetector != null)
        {
            _screenShotDetector.stop();
        }
        StopWatch.get().invalidate("pin_closeup").invalidate("clickthrough_verify");
        if (_pinVw != null)
        {
            _pinVw.onDeactivate();
        }
        _handler.removeCallbacksAndMessages(null);
        _pendingHandler = false;
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/api/model/Pin$UpdateEvent
        });
        super.onDeactivate();
    }

    public void onDestroy()
    {
        onPreDrawListener = null;
        if (_screenShotDetector != null)
        {
            _screenShotDetector.stop();
            _screenShotDetector = null;
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (_gridVw != null)
        {
            _gridVw.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        }
        Events.unregister(_eventsSubscriber);
        _pinVw = null;
        _handler.removeCallbacksAndMessages(null);
        ButterKnife.a(this);
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        _pinVw = new PinCloseupView(view.getContext());
        _pinVw.setApiTag(getApiTag());
        _pinVw.setFragmentManager(getChildFragmentManager());
        _gridVw.addHeaderView(_pinVw, -1, -2, 0, Constants.MARGIN);
        _relatedTitle = new BevelTitleDivider(view.getContext());
        _relatedTitle.setText(0x7f0e03db);
        _gridVw.addHeaderView(_relatedTitle);
        _relatedTitle.setVisibility(8);
        view.postDelayed(new _cls2(), 500L);
        updateView();
        if (_pin != null && _pin.getHasPlace() == Boolean.TRUE && !GooglePlayServices.isAvailable())
        {
            GoogleServiceDialog.show();
        }
        _gridVw.addListener(new _cls3());
        if (!Experiments.j())
        {
            _gridVw.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
        }
        DrawableUtils.tintToolbarIcons(_actionBar, 0x7f090043);
    }

    public void setNavigation(Navigation navigation)
    {
        super.setNavigation(navigation);
        _pin = navigation.getModelAsPin();
    }








/*
    static boolean access$1302(PinFragment pinfragment, boolean flag)
    {
        pinfragment._pendingHandler = flag;
        return flag;
    }

*/



/*
    static PinCloseupAccessoryActionBar access$202(PinFragment pinfragment, PinCloseupAccessoryActionBar pincloseupaccessoryactionbar)
    {
        pinfragment._floatingSubActionBar = pincloseupaccessoryactionbar;
        return pincloseupaccessoryactionbar;
    }

*/









    private class _cls5 extends com.pinterest.base.Events.EventsSubscriber
    {

        final PinFragment this$0;

        public void onEventMainThread(com.pinterest.api.model.Pin.UpdateEvent updateevent)
        {
            updateevent = updateevent.getPin();
            if (updateevent.equals(_pin))
            {
                updateFloatingBarState();
                if (_floatingSubActionBar != null)
                {
                    _floatingSubActionBar.setPin(updateevent);
                    return;
                }
            }
        }

        _cls5()
        {
            this$0 = PinFragment.this;
            super();
        }
    }




    private class _cls2
        implements Runnable
    {

        final PinFragment this$0;

        public void run()
        {
            Object obj = getView();
            if (obj == null)
            {
                return;
            } else
            {
                _floatingSubActionBar = new PinCloseupAccessoryActionBar(((View) (obj)).getContext());
                obj = new LayoutParams(-1, Constants.ACTIONBAR_HEIGHT);
                obj.gravity = 80;
                _floatingSubActionBar.setPin(_pin);
                _floatingSubActionBar.setVisibility(4);
                _floatingSubActionBar.setTranslationY(Constants.ACTIONBAR_HEIGHT);
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(_floatingSubActionBar, "translationY", new float[] {
                    0.0F
                });
                objectanimator.setInterpolator(new DecelerateInterpolator());
                objectanimator.setDuration(200L);
                objectanimator.start();
                _rootVw.addView(_floatingSubActionBar, ((android.view.ViewGroup.LayoutParams) (obj)));
                class _cls1
                    implements Runnable
                {

                    final _cls2 this$1;

                    public void run()
                    {
                        updateFloatingBarState();
                    }

                _cls1()
                {
                    this$1 = _cls2.this;
                    Object();
                }
                }

                _floatingSubActionBar.post(new _cls1());
                return;
            }
        }

        _cls2()
        {
            this$0 = PinFragment.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.ui.scrollview.ObservableScrollView.ScrollViewListener
    {

        final PinFragment this$0;

        public void onScroll(View view, int i, int j, int k, int l)
        {
            updateFloatingBarState();
        }

        _cls3()
        {
            this$0 = PinFragment.this;
            super();
        }
    }

}
