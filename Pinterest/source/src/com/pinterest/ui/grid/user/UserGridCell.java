// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.user;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.api.model.User;
import com.pinterest.base.Constants;
import com.pinterest.ui.ViewHelper;

// Referenced classes of package com.pinterest.ui.grid.user:
//            UserGridCellTitleView, UserGridCellImageView

public class UserGridCell extends LinearLayout
{

    UserGridCellImageView _cover;
    TextView _followTv;
    UserGridCellTitleView _title;
    private User _user;
    private android.view.View.OnClickListener onFollowClicked;

    public UserGridCell(Context context)
    {
        this(context, null);
    }

    public UserGridCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        onFollowClicked = new _cls1();
        init();
    }

    public static UserGridCell get(View view, ViewGroup viewgroup)
    {
        if (view == null || !(view instanceof UserGridCell))
        {
            return new UserGridCell(ViewHelper.getContext(view, viewgroup));
        } else
        {
            return (UserGridCell)view;
        }
    }

    public User getUser()
    {
        return _user;
    }

    protected void init()
    {
        inflate(getContext(), 0x7f0300f6, this);
        ButterKnife.a(this);
    }

    public void setUser(User user, boolean flag)
    {
        for (_user = user; _user == null || flag;)
        {
            return;
        }

        _followTv.setOnClickListener(onFollowClicked);
        updateFollowButton();
        _title.setUser(user);
        _cover.setUser(user, flag);
    }

    public void updateFollowButton()
    {
        ViewHelper.updateFollow(_followTv, Constants.isTrue(Boolean.valueOf(_user.getFollowing())));
    }



/*
    static User access$002(UserGridCell usergridcell, User user)
    {
        usergridcell._user = user;
        return user;
    }

*/

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final UserGridCell this$0;

        public void onClick(View view)
        {
            if (_user == null)
            {
                return;
            }
            Pinalytics.a(ElementType.USER_FOLLOW, ComponentType.USER_FEED, _user.getUid());
            boolean flag = Constants.isTrue(Boolean.valueOf(_user.getFollowing()));
            view = UserGridCell.this;
            String s = _user.getUid();
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view._user = ModelHelper.followUser(s, flag, null, null);
            updateFollowButton();
        }

        _cls1()
        {
            this$0 = UserGridCell.this;
            super();
        }
    }

}
