// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.api.model.User;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.ViewHelper;

public class UserGridCellTitleView extends LinearLayout
{

    TextView _subtitleTv;
    TextView _titleTv;
    View _verifiedIv;

    public UserGridCellTitleView(Context context)
    {
        this(context, null);
    }

    public UserGridCellTitleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        inflate(getContext(), 0x7f0300f7, this);
        setOrientation(1);
        ButterKnife.a(this);
    }

    public void setUser(User user)
    {
        if (user == null)
        {
            return;
        } else
        {
            _titleTv.setText(user.getFullName());
            String s = Resources.stringPlural(0x7f0d0015, user.getPinCount());
            String s1 = Resources.stringPlural(0x7f0d0007, user.getFollowersCount());
            _subtitleTv.setText(String.format("%s - %s", new Object[] {
                s, s1
            }));
            ViewHelper.setVisibility(_verifiedIv, Constants.isTrue(user.getWebsiteVerified()));
            return;
        }
    }
}
