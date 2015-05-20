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
import com.pinterest.kit.application.Resources;

public class NewFindFriendsHeaderView extends FrameLayout
{

    TextView _friendsCount;
    private android.view.View.OnClickListener _inviteAllClicked;
    TextView _inviteAllTv;

    public NewFindFriendsHeaderView(Context context)
    {
        this(context, null);
    }

    public NewFindFriendsHeaderView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NewFindFriendsHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _inviteAllClicked = new _cls1();
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030102, this, true);
        ButterKnife.a(this, this);
        _inviteAllTv.setOnClickListener(_inviteAllClicked);
    }

    public void updateFriendsCount(int i)
    {
        _friendsCount.setText(Resources.stringPlural(0x7f0d0009, Integer.valueOf(i)));
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final NewFindFriendsHeaderView this$0;

        public void onClick(View view)
        {
            Events.post(new Navigation(Location.INVITE_ALL_FRIENDS));
        }

        _cls1()
        {
            this$0 = NewFindFriendsHeaderView.this;
            super();
        }
    }

}
