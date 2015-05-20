// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.pinterest.activity.report.ReportHelper;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.base.Constants;
import com.pinterest.kit.application.Resources;
import com.pinterest.ui.text.FollowButton;

public class FollowUserButton extends FollowButton
{

    private boolean _pendingApiResponse;
    private User _user;

    public FollowUserButton(Context context)
    {
        super(context);
    }

    public FollowUserButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FollowUserButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected boolean isFollowing()
    {
        return _user != null && Constants.isTrue(_user.getExplicitFollowing());
    }

    public void onClick(View view)
    {
        boolean flag = true;
        if (_user == null || _pendingApiResponse)
        {
            return;
        }
        if (Constants.isTrue(_user.getBlocked()))
        {
            ReportHelper.showBlockDialog((Activity)getContext(), _user);
            return;
        }
        _pendingApiResponse = true;
        view = _user;
        if (Constants.isTrue(_user.getExplicitFollowing()))
        {
            flag = false;
        }
        view.setFollowing(flag);
        updateDisplay();
        ModelHelper.followUser(_user.getUid(), _user.getFollowing(), new _cls1(), null);
    }

    public void setUser(User user)
    {
        _user = user;
        updateDisplay();
    }

    protected void updateDisplay()
    {
        if (_user == null)
        {
            return;
        }
        if (Constants.isTrue(_user.getBlocked()))
        {
            setText(Resources.string(0x7f0e04bd));
            setStyle(com.pinterest.ui.text.PButton.ButtonStyle.PLAIN);
            return;
        } else
        {
            super.updateDisplay();
            return;
        }
    }



/*
    static boolean access$102(FollowUserButton followuserbutton, boolean flag)
    {
        followuserbutton._pendingApiResponse = flag;
        return flag;
    }

*/

    private class _cls1 extends ApiResponseHandler
    {

        final FollowUserButton this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            throwable = _user;
            boolean flag;
            if (!_user.getFollowing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            throwable.setFollowing(flag);
        }

        public void onFinish()
        {
            super.onFinish();
            setLoading(false);
            _pendingApiResponse = false;
        }

        public void onStart()
        {
            super.onStart();
            setLoading(true);
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            if (_user.getFollowing())
            {
                apiresponse = EventType.USER_FOLLOW;
            } else
            {
                apiresponse = EventType.USER_UNFOLLOW;
            }
            Pinalytics.a(apiresponse, _user.getUid());
            ModelHelper.updateUser(_user);
            Events.post(new com.pinterest.api.model.User.UserFollowEvent(_user));
        }

        _cls1()
        {
            this$0 = FollowUserButton.this;
            super();
        }
    }

}
