// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.invitefriend.events.InviteCreateEvent;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Events;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

public class NewFindFriendsInviteAllHeaderView extends FrameLayout
{

    TextView _friendsCount;

    public NewFindFriendsInviteAllHeaderView(Context context)
    {
        this(context, null);
    }

    public NewFindFriendsInviteAllHeaderView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NewFindFriendsInviteAllHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030101, this, true);
        ButterKnife.a(this, this);
    }

    public void onSendBtnClick()
    {
        Pinalytics.a(ElementType.SEND_INVITE_BUTTON, ComponentType.BULK_INVITE);
        Events.post(new InviteCreateEvent(true));
    }

    public void updateFriendsCount(int i)
    {
        _friendsCount.setText(Resources.stringPlural(0x7f0d000b, Integer.valueOf(i)));
    }
}
