// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.sendapin;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.pinterest.activity.sendapin.model.SendableObject;
import com.pinterest.activity.sendapin.ui.PeoplePickerListWrapper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.base.Constants;
import com.pinterest.base.Device;

public class SendPinFragment extends BaseFragment
{

    private PeoplePickerListWrapper _listwrapper;

    public SendPinFragment()
    {
    }

    private void setObject(String s, int i)
    {
        if (_listwrapper != null && ModelHelper.isValidString(s))
        {
            _listwrapper.setObjectToSend(new SendableObject(s, i));
        }
    }

    private void updateWidth()
    {
        if (Device.isTablet() || Device.isLandscape())
        {
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)_listwrapper.getLayoutParams();
            layoutparams.width = Constants.SHEET_MAX_WIDTH;
            layoutparams.gravity = 1;
            return;
        } else
        {
            _listwrapper.getLayoutParams().width = (int)Device.getScreenWidth();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updateWidth();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300a9;
    }

    public void onPause()
    {
        super.onPause();
        _listwrapper.unregisterForSendEvents();
        Device.hideSoftKeyboard(_listwrapper);
    }

    public void onResume()
    {
        super.onResume();
        _listwrapper.registerForSendEvents();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        _listwrapper = (PeoplePickerListWrapper)view.findViewById(0x7f0b0194);
        _listwrapper.setApiTag(getApiTag());
        updateWidth();
    }

    public void setBoardId(String s)
    {
        setObject(s, 1);
    }

    public void setPinId(String s)
    {
        setObject(s, 0);
    }
}
