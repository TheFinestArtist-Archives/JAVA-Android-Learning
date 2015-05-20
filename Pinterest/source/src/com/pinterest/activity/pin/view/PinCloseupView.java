// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.pin.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.pin.gridcells.PinCloseupBasicInfoView;
import com.pinterest.activity.pin.gridcells.PinCloseupClickThroughView;
import com.pinterest.activity.pin.gridcells.PinCloseupDetailedDataView;
import com.pinterest.activity.pin.gridcells.PinCloseupImageView;
import com.pinterest.activity.pin.gridcells.PinCloseupPlaceView;
import com.pinterest.activity.pin.gridcells.PinCloseupStatsView;
import com.pinterest.activity.pin.gridcells.PinCloseupSubView;
import com.pinterest.activity.pin.gridcells.PinCloseupTitleView;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.api.remote.PinApi;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.pinterest.activity.pin.view:
//            PinCloseupAccessoryActionBar

public class PinCloseupView extends LinearLayout
{

    private PinCloseupAccessoryActionBar _accessoryBar;
    private boolean _active;
    private String _apiTag;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private boolean _firstLoad;
    private FragmentManager _fragmentManager;
    private Pin _pin;
    private String _pinUid;
    private ArrayList _subViews;
    private com.pinterest.api.remote.PinApi.PinApiResponse onPinLoaded;

    public PinCloseupView(Context context)
    {
        this(context, null);
    }

    public PinCloseupView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        onPinLoaded = new _cls1();
        _eventsSubscriber = new _cls2();
        init();
    }

    private void init()
    {
        initiView();
        _firstLoad = true;
    }

    private void initiView()
    {
        updatePadding();
        setOrientation(1);
        _subViews = new ArrayList();
        _subViews.add(new PinCloseupTitleView(getContext()));
        _subViews.add(new PinCloseupImageView(getContext()));
        _subViews.add(new PinCloseupDetailedDataView(getContext()));
        _subViews.add(new PinCloseupClickThroughView(getContext()));
        _subViews.add(new PinCloseupPlaceView(getContext()));
        _subViews.add(new PinCloseupBasicInfoView(getContext()));
        _subViews.add(new PinCloseupStatsView(getContext()));
        _accessoryBar = new PinCloseupAccessoryActionBar(getContext());
        _subViews.add(_accessoryBar);
        PinCloseupSubView pincloseupsubview;
        for (Iterator iterator = _subViews.iterator(); iterator.hasNext(); addView(pincloseupsubview, -1, -2))
        {
            pincloseupsubview = (PinCloseupSubView)iterator.next();
            pincloseupsubview.setApiTag(_apiTag);
        }

    }

    private void loadData()
    {
        if (!_firstLoad || !ModelHelper.isValid(_pinUid))
        {
            return;
        } else
        {
            PinApi.a(_pinUid, MyUser.hasAccessToken(), onPinLoaded, _apiTag);
            _firstLoad = false;
            return;
        }
    }

    private void updatePadding()
    {
        int i = (int)((Device.getScreenWidth() - (float)FragmentHelper.getCloseupWidth(this)) / 2.0F);
        setPadding(i, 0, i, 0);
    }

    private void updateView()
    {
        for (Iterator iterator = _subViews.iterator(); iterator.hasNext(); ((PinCloseupSubView)iterator.next()).setPin(_pin)) { }
    }

    public PinCloseupAccessoryActionBar getAccessoryActionBar()
    {
        return _accessoryBar;
    }

    public FragmentManager getFragmentManager()
    {
        return _fragmentManager;
    }

    public void onActivate()
    {
        _active = true;
        updateView();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        loadData();
        Events.register(_eventsSubscriber, com/pinterest/api/model/Pin$UpdateEvent, new Class[] {
            com/pinterest/api/model/Comment$CreateEvent, com/pinterest/api/model/Comment$UpdateEvent
        });
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updatePadding();
    }

    public void onDeactivate()
    {
        _active = false;
    }

    protected void onDetachedFromWindow()
    {
        Events.unregister(_eventsSubscriber);
        _fragmentManager = null;
        removeAllViews();
        super.onDetachedFromWindow();
    }

    public void setApiTag(String s)
    {
        _apiTag = s;
    }

    public void setFragmentManager(FragmentManager fragmentmanager)
    {
        _fragmentManager = fragmentmanager;
    }

    public void setPin(Pin pin)
    {
        if (pin == null)
        {
            return;
        } else
        {
            _pin = pin;
            _pinUid = _pin.getUid();
            loadData();
            updateView();
            return;
        }
    }





    private class _cls1 extends com.pinterest.api.remote.PinApi.PinApiResponse
    {

        final PinCloseupView this$0;

        public void onSuccess(Pin pin)
        {
            setPin(pin);
            HashMap hashmap = new HashMap();
            hashmap.put("pin_id", pin.getUid());
            class _cls1 extends com.pinterest.api.remote.ExperiencesApi.ExperienceResponseHandler
            {

                final _cls1 this$1;

                public void onSuccess()
                {
                    PinSwipeFragment.setEduRunnable(EducationHelper.a(Placement.ANDROID_PIN_CLOSEUP_TAKEOVER));
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            ExperiencesApi.a(String.valueOf(Placement.ANDROID_PIN_CLOSEUP_TAKEOVER.getValue()), hashmap, new _cls1(), _apiTag);
        }

        _cls1()
        {
            this$0 = PinCloseupView.this;
            super();
        }
    }


    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final PinCloseupView this$0;

        public void onEventMainThread(com.pinterest.api.model.Comment.CreateEvent createevent)
        {
            if (!createevent.getComment().getPinUid().equals(_pinUid))
            {
                return;
            } else
            {
                _pin.setCommentCount(Integer.valueOf(_pin.getCommentCount().intValue() + 1));
                updateView();
                return;
            }
        }

        public void onEventMainThread(com.pinterest.api.model.Comment.UpdateEvent updateevent)
        {
            if (!updateevent.getComment().getPinUid().equals(_pinUid) || !updateevent.wasDeleted())
            {
                return;
            } else
            {
                _pin.setCommentCount(Integer.valueOf(_pin.getCommentCount().intValue() - 1));
                updateView();
                return;
            }
        }

        public void onEventMainThread(com.pinterest.api.model.Pin.UpdateEvent updateevent)
        {
            if (!updateevent.getPin().getUid().equals(_pinUid))
            {
                return;
            } else
            {
                setPin(updateevent.getPin());
                return;
            }
        }

        _cls2()
        {
            this$0 = PinCloseupView.this;
            super();
        }
    }

}
