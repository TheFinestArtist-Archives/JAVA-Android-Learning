// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.api.model.Pin;
import com.pinterest.api.model.User;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.grid.PinGridCell;
import com.pinterest.ui.text.PButton;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuView, ContextMenuEduCompletedEvent

public class ContextMenuEducationFragment extends BaseFragment
{

    private static final int PIN_CELL_BOTTOM_MARGIN = (int)Resources.dimension(0x7f0a0056);
    private static final int PIN_CELL_TOP_MARGIN = (int)Resources.dimension(0x7f0a0057);
    private static final int PIN_IMAGE_HEIGHT = (int)Resources.dimension(0x7f0a0055);
    private static final int PIN_IMAGE_WIDTH = (int)Resources.dimension(0x7f0a0058);
    private Context _context;
    private ContextMenuView _contextMenu;
    private PButton _doneBtn;
    private float _eduTouchCenterX;
    private float _eduTouchCenterY;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private PinGridCell _pinGridCell;
    private TextView _skipTipView;

    public ContextMenuEducationFragment()
    {
        _eventsSubscriber = new _cls2();
        _layoutId = 0x7f030074;
    }

    private void startEducation()
    {
        if (_contextMenu != null)
        {
            _contextMenu.startEducation(_eduTouchCenterX, _eduTouchCenterY, PIN_IMAGE_HEIGHT / 2);
        }
    }

    private void updatePinGridCell()
    {
        Pin pin = new Pin();
        pin.setUid("0");
        pin.setImageMediumUrl("2130837689");
        pin.setImageMediumWidth(Integer.valueOf(PIN_IMAGE_WIDTH));
        pin.setImageMediumHeight(Integer.valueOf(PIN_IMAGE_HEIGHT));
        User user = new User();
        user.setImageMediumUrl("2130837690");
        user.setFullName(Resources.string(0x7f0e011f));
        pin.cacheUser(user);
        _pinGridCell.setPin(pin, false);
        _pinGridCell.setRenderDescription(false);
        _pinGridCell.setRenderDomain(false);
        _pinGridCell.setRenderOnto(false);
        _pinGridCell.setOverrideClicks(true);
        _pinGridCell.setEnabled(false);
    }

    protected void onActivate()
    {
        super.onActivate();
        Events.register(_eventsSubscriber, com/pinterest/ui/menu/ContextMenuEduCompletedEvent, new Class[0]);
        Events.post(new com.pinterest.activity.task.view.MainViewPager.ControlEvent(0));
        if (!Device.isTablet() && getActivity() != null)
        {
            getActivity().setRequestedOrientation(1);
        }
    }

    protected void onDeactivate()
    {
        super.onDeactivate();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/ui/menu/ContextMenuEduCompletedEvent
        });
        getActivity().setRequestedOrientation(-1);
        Events.post(new com.pinterest.activity.task.view.MainViewPager.ControlEvent(1));
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _context = view.getContext();
        _pinGridCell = (PinGridCell)view.findViewById(0x7f0b0141);
        bundle = new android.widget.RelativeLayout.LayoutParams(PIN_IMAGE_WIDTH, -2);
        bundle.setMargins(0, PIN_CELL_TOP_MARGIN, 0, PIN_CELL_BOTTOM_MARGIN);
        bundle.addRule(14);
        _pinGridCell.setLayoutParams(bundle);
        updatePinGridCell();
        _skipTipView = (TextView)view.findViewById(0x7f0b0142);
        _skipTipView.setClickable(true);
        _skipTipView.setOnClickListener(new SkipDoneClickListener(true));
        _doneBtn = (PButton)view.findViewById(0x7f0b0143);
        _doneBtn.setStyle(com.pinterest.ui.text.PButton.ButtonStyle.RED);
        _doneBtn.setOnClickListener(new SkipDoneClickListener(false));
        _doneBtn.setVisibility(8);
        _contextMenu = (ContextMenuView)view.findViewById(0x7f0b006c);
        _eduTouchCenterX = Device.getScreenWidth() / 2.0F;
        _eduTouchCenterY = PIN_CELL_TOP_MARGIN + PIN_IMAGE_HEIGHT / 2;
        startEducation();
        view.postDelayed(new _cls1(), 300L);
    }




    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final ContextMenuEducationFragment this$0;

        public void onEventMainThread(ContextMenuEduCompletedEvent contextmenueducompletedevent)
        {
            _skipTipView.setVisibility(8);
            _doneBtn.setVisibility(0);
            LongPressEducation.b();
        }

        _cls2()
        {
            this$0 = ContextMenuEducationFragment.this;
            super();
        }
    }


    private class SkipDoneClickListener
        implements android.view.View.OnClickListener
    {

        private boolean _isSkipped;
        final ContextMenuEducationFragment this$0;

        public void onClick(View view)
        {
            FragmentActivity fragmentactivity = getActivity();
            if (fragmentactivity != null)
            {
                if (_isSkipped)
                {
                    view = ElementType.CANCEL_BUTTON;
                } else
                {
                    view = ElementType.DONE_BUTTON;
                }
                Pinalytics.a(view, ComponentType.EDUCATION);
                LongPressEducation.b();
                fragmentactivity.onBackPressed();
            }
        }

        public SkipDoneClickListener(boolean flag)
        {
            this$0 = ContextMenuEducationFragment.this;
            super();
            _isSkipped = flag;
        }
    }


    private class _cls1
        implements Runnable
    {

        final ContextMenuEducationFragment this$0;

        public void run()
        {
            Events.post(new com.pinterest.activity.task.view.MainViewPager.ControlEvent(0));
        }

        _cls1()
        {
            this$0 = ContextMenuEducationFragment.this;
            super();
        }
    }

}
