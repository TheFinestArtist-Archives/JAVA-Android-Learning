// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.pinterest.activity.pin.adapter.SimpleTextListAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import java.util.ArrayList;

public class UserAboutFlagView extends RelativeLayout
{

    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private android.view.View.OnClickListener _onClick;
    private Button _reportBt;
    private User _user;

    public UserAboutFlagView(Context context)
    {
        this(context, null);
    }

    public UserAboutFlagView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _onClick = new _cls1();
        _eventsSubscriber = new _cls3();
        init();
    }

    public UserAboutFlagView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _onClick = new _cls1();
        _eventsSubscriber = new _cls3();
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f030145, this);
        _reportBt = (Button)findViewById(0x7f0b02db);
        _reportBt.setOnClickListener(_onClick);
    }

    private void showReportBlockDialog()
    {
        if (_user == null)
        {
            return;
        }
        final Context context = getContext();
        final BaseDialog dialog = new ArrayList();
        Object obj;
        SimpleTextListAdapter simpletextlistadapter;
        int i;
        if (_user.getFullName() == null)
        {
            obj = "";
        } else
        {
            obj = _user.getFullName();
        }
        dialog.add(String.format(context.getString(0x7f0e03ff), new Object[] {
            obj
        }));
        if (_user.getBlocked() == Boolean.TRUE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = 0x7f0e04bf;
        } else
        {
            i = 0x7f0e005d;
        }
        dialog.add(Resources.string(i, new Object[] {
            obj
        }));
        obj = (String[])dialog.toArray(new String[dialog.size()]);
        dialog = new BaseDialog();
        simpletextlistadapter = new SimpleTextListAdapter(false);
        simpletextlistadapter.setDataSource(((Object []) (obj)));
        dialog.setListViewOptions(simpletextlistadapter, new _cls2());
        Events.post(new DialogEvent(dialog));
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Events.register(_eventsSubscriber, com/pinterest/api/model/User$UpdateEvent, new Class[0]);
    }

    protected void onDetachedFromWindow()
    {
        Events.unregister(_eventsSubscriber);
        super.onDetachedFromWindow();
    }

    public void updateUi(User user)
    {
        _user = user;
        if (_user != null)
        {
            if (MyUser.isUserMe(user))
            {
                _reportBt.setVisibility(8);
                return;
            }
            if (user.getFirstName() != null)
            {
                user = String.format(getContext().getString(0x7f0e03f4), new Object[] {
                    _user.getFirstName()
                });
                _reportBt.setText(user);
                _reportBt.setVisibility(0);
                return;
            }
        }
    }




/*
    static User access$102(UserAboutFlagView useraboutflagview, User user)
    {
        useraboutflagview._user = user;
        return user;
    }

*/

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UserAboutFlagView this$0;

        public void onClick(View view)
        {
            showReportBlockDialog();
        }

        _cls1()
        {
            this$0 = UserAboutFlagView.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.base.Events.EventsSubscriber
    {

        final UserAboutFlagView this$0;

        public void onEventMainThread(com.pinterest.api.model.User.UpdateEvent updateevent)
        {
            if (updateevent.getUser().equals(_user))
            {
                _user = updateevent.getUser();
                updateUi(_user);
            }
        }

        _cls3()
        {
            this$0 = UserAboutFlagView.this;
            super();
        }
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final UserAboutFlagView this$0;
        final Context val$context;
        final BaseDialog val$dialog;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            i;
            JVM INSTR tableswitch 0 1: default 24
        //                       0 32
        //                       1 59;
               goto _L1 _L2 _L3
_L1:
            dialog.dismiss();
            return;
_L2:
            Events.post(new DialogEvent(new ReportUserDialog(_user)));
            continue; /* Loop/switch isn't completed */
_L3:
            ReportHelper.showBlockDialog((Activity)context, _user);
            if (true) goto _L1; else goto _L4
_L4:
        }

        _cls2()
        {
            this$0 = UserAboutFlagView.this;
            context = context1;
            dialog = basedialog;
            super();
        }
    }

}
