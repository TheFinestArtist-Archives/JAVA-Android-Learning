// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.unauth;

import android.content.Intent;
import android.os.Bundle;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.unauth.fragment.UnauthLoadingFragment;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.activity.BaseActivity;

public class UnauthWallActivity extends BaseActivity
{

    private BaseFragment _fragment;

    public UnauthWallActivity()
    {
    }

    public BaseFragment getActiveFragment()
    {
        return _fragment;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!Device.isTablet())
        {
            setRequestedOrientation(1);
        } else
        {
            setRequestedOrientation(4);
        }
        setContentView(0x7f030027);
        bundle = new UnauthLoadingFragment();
        if (getIntent() != null)
        {
            String s = getIntent().getStringExtra("com.pinterest.EXTRA_SIGNUP_INVITE_URL");
            if (s != null)
            {
                bundle.setInviteUrl(s);
            }
        }
        _fragment = bundle;
        FragmentHelper.replaceFragment(this, _fragment, false, com.pinterest.activity.FragmentHelper.Animation.NONE);
        StopWatch.get().invalidate("ttrfp");
    }

    protected void onResume()
    {
        boolean flag;
        if (getIntent().hasExtra("com.pinterest.EXTRA_USER_NAME") && getIntent().hasExtra("com.pinterest.EXTRA_PASSWORD"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || !MyUser.hasAccessTokenAndUser()) goto _L2; else goto _L1
_L1:
        ActivityHelper.goRoot(this);
        finish();
        super.onResume();
_L4:
        return;
_L2:
        super.onResume();
        if (!getIntent().hasExtra("com.pinterest.EXTRA_PENDING_DIALOG")) goto _L4; else goto _L3
_L3:
        Object obj = getIntent().getSerializableExtra("com.pinterest.EXTRA_PENDING_DIALOG");
        obj = ((Class)obj).newInstance();
        if (!(obj instanceof BaseDialog))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = (BaseDialog)obj;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        ((BaseDialog) (obj)).setBundle(getIntent().getExtras());
        Events.post(new DialogEvent(((BaseDialog) (obj))));
_L6:
        getIntent().removeExtra("com.pinterest.EXTRA_PENDING_DIALOG");
        return;
        Object obj1;
        obj1;
        ((InstantiationException) (obj1)).printStackTrace();
        continue; /* Loop/switch isn't completed */
        obj1;
        ((IllegalAccessException) (obj1)).printStackTrace();
        if (true) goto _L6; else goto _L5
_L5:
    }
}
