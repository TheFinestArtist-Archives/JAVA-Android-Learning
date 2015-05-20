// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.invitefriend.events.InviteSendEvent;
import com.pinterest.activity.invitefriend.events.SingleCheckEvent;
import com.pinterest.base.Events;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;

public class InviterHeaderView extends FrameLayout
{

    TextView _contactsNum;
    private com.pinterest.base.Events.EventsSubscriber _eventSubscriber;
    CheckBox _inviteAllCb;
    private android.view.View.OnClickListener _inviteAllClicked;
    View _inviteAllRl;
    TextView _inviteAllTv;
    ImageView _mailIv;

    public InviterHeaderView(Context context)
    {
        this(context, null);
    }

    public InviterHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _inviteAllClicked = new _cls1();
        _eventSubscriber = new _cls2();
        init();
    }

    private void init()
    {
        boolean flag1 = true;
        LayoutInflater.from(getContext()).inflate(0x7f03012c, this, true);
        ButterKnife.a(this, this);
        Object obj = _mailIv;
        boolean flag;
        if (!Experiments.g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ViewHelper.setVisibility(((View) (obj)), flag);
        obj = _inviteAllCb;
        if (!Experiments.g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ViewHelper.setVisibility(((View) (obj)), flag);
        obj = _inviteAllTv;
        if (!Experiments.g())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ViewHelper.setVisibility(((View) (obj)), flag);
        _inviteAllCb.setOnClickListener(_inviteAllClicked);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Events.register(_eventSubscriber, com/pinterest/activity/invitefriend/events/SingleCheckEvent, new Class[] {
            com/pinterest/activity/invitefriend/events/InviteSendEvent
        });
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        Events.unregister(_eventSubscriber);
    }

    public void showInviteAll(boolean flag)
    {
        ViewHelper.setVisibility(_inviteAllRl, flag);
    }

    public void updateContactsNum(int i)
    {
        _contactsNum.setText(Resources.stringPlural(0x7f0d0005, Integer.valueOf(i)));
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final InviterHeaderView this$0;

        public void onClick(View view)
        {
            PLog.a((new StringBuilder("_inviteAllClicked: ")).append(_inviteAllCb.isChecked()).toString(), new Object[0]);
            Pinalytics.a(ElementType.INVITE_ALL_TOGGLE, ComponentType.BULK_INVITE);
            Events.post(new SelectAllEvent(_inviteAllCb.isChecked()));
        }

        _cls1()
        {
            this$0 = InviterHeaderView.this;
            super();
        }
    }


    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final InviterHeaderView this$0;

        public void onEventMainThread(InviteSendEvent invitesendevent)
        {
            _inviteAllCb.setChecked(false);
        }

        public void onEventMainThread(SingleCheckEvent singlecheckevent)
        {
            _inviteAllCb.setChecked(singlecheckevent.isAllChecked());
        }

        _cls2()
        {
            this$0 = InviterHeaderView.this;
            super();
        }
    }

}
