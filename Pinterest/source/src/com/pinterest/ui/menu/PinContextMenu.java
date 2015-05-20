// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.view.LayoutInflater;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.Pin;
import com.pinterest.base.Constants;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenu, ContextMenuItemView, ContextMenuView

public class PinContextMenu
    implements ContextMenu
{

    private Pin _pin;

    public PinContextMenu()
    {
    }

    private ContextMenuItemView getEditView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f0200fc);
        layoutinflater.setToolTip(0x7f0e011d);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls4());
        return layoutinflater;
    }

    private ContextMenuItemView getLikeView(LayoutInflater layoutinflater, boolean flag)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        if (!flag)
        {
            layoutinflater.setImage(0x7f0200fe);
            layoutinflater.setToolTip(0x7f0e0126);
        } else
        {
            layoutinflater.setImage(0x7f020103);
            layoutinflater.setToolTip(0x7f0e012a);
        }
        layoutinflater.setOnClickListener(new _cls3());
        layoutinflater.setVisibility(4);
        return layoutinflater;
    }

    private ContextMenuItemView getRepinView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f020100);
        layoutinflater.setToolTip(0x7f0e0127);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls1());
        return layoutinflater;
    }

    private ContextMenuItemView getSendView(LayoutInflater layoutinflater)
    {
        layoutinflater = (ContextMenuItemView)layoutinflater.inflate(0x7f03003a, null);
        layoutinflater.setImage(0x7f020101);
        layoutinflater.setToolTip(0x7f0e0129);
        layoutinflater.setVisibility(4);
        layoutinflater.setOnClickListener(new _cls2());
        return layoutinflater;
    }

    public void show(ContextMenuView contextmenuview, Pin pin)
    {
        boolean flag = false;
        _pin = pin;
        ArrayList arraylist = new ArrayList(3);
        LayoutInflater layoutinflater = LayoutInflater.from(contextmenuview.getContext());
        boolean flag1;
        boolean flag2;
        if (pin != null)
        {
            flag2 = MyUser.isUserMe(pin.getUserUid());
            flag1 = pin.isSecret();
            flag = Constants.isTrue(pin.getLiked());
        } else
        {
            flag1 = false;
            flag2 = false;
        }
        if (flag2)
        {
            pin = getEditView(layoutinflater);
        } else
        {
            pin = getLikeView(layoutinflater, flag);
        }
        arraylist.add(pin);
        if (!flag1)
        {
            arraylist.add(getSendView(layoutinflater));
        }
        arraylist.add(getRepinView(layoutinflater));
        contextmenuview.addMenuOptions(arraylist);
        contextmenuview.show();
    }

    public volatile void show(ContextMenuView contextmenuview, Object obj)
    {
        show(contextmenuview, (Pin)obj);
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final PinContextMenu this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PIN_EDIT_BUTTON, ComponentType.CONTEXTUAL_MENU, _pin.getUid());
            view = view.getContext();
            if (view != null)
            {
                Intent intent = ActivityHelper.getPinEditIntent(view);
                intent.putExtra("com.pinterest.EXTRA_PIN_ID", _pin.getUid());
                view.startActivity(intent);
            }
        }

        _cls4()
        {
            this$0 = PinContextMenu.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final PinContextMenu this$0;

        public void onClick(View view)
        {
            int i = 1;
            view = ModelHelper.getPin(_pin.getUid());
            boolean flag;
            if (!Constants.isTrue(view.getLiked()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (view != null)
            {
                Pinalytics.a(ElementType.PIN_LIKE_BUTTON, ComponentType.CONTEXTUAL_MENU, _pin.getUid());
                view.setLiked(Boolean.valueOf(flag));
                int j = view.getLikeCountDisplay();
                if (!flag)
                {
                    i = -1;
                }
                view.setLikeCount(Integer.valueOf(i + j));
                Events.post(new com.pinterest.api.model.Pin.UpdateEvent(view));
                PinApi.a(view.getUid(), flag, new com.pinterest.api.remote.PinApi.PinLikeApiResponse(view));
            }
        }

        _cls3()
        {
            this$0 = PinContextMenu.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PinContextMenu this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.PIN_REPIN_BUTTON, ComponentType.CONTEXTUAL_MENU, _pin.getUid());
            StopWatch.get().start("repin_dialog");
            Events.post(new Navigation(Location.REPIN, _pin));
        }

        _cls1()
        {
            this$0 = PinContextMenu.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinContextMenu this$0;

        public void onClick(View view)
        {
            if (StringUtils.isNotEmpty(_pin.getUid()))
            {
                Pinalytics.a(ElementType.SEND_BUTTON, ComponentType.CONTEXTUAL_MENU);
                SendPinActivity.startSendPin(view.getContext(), _pin.getUid());
            }
        }

        _cls2()
        {
            this$0 = PinContextMenu.this;
            super();
        }
    }

}
