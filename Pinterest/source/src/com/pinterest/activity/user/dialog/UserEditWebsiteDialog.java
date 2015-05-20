// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.user.dialog;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import com.pinterest.activity.task.dialog.OneFieldBaseDialog;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.kit.application.Resources;
import com.pinterest.schemas.event.ElementType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEditWebsiteDialog extends OneFieldBaseDialog
{

    private com.pinterest.api.remote.MyUserApi.SettingsApiResponse _responseHandler;
    protected User _user;
    protected String _userUid;

    public UserEditWebsiteDialog()
    {
    }

    public void addUserUidToArguments(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.pinterest.EXTRA_USER_ID", s);
        setArguments(bundle);
    }

    protected String getDialogTitle()
    {
        return Resources.string(0x7f0e0521);
    }

    protected String getHint()
    {
        return Resources.string(0x7f0e0029);
    }

    protected String getInitialValue()
    {
        return _user.getWebsite();
    }

    protected String getInvalidToast()
    {
        return Resources.string(0x7f0e0299);
    }

    protected boolean isValid(String s)
    {
        return s != null && (Patterns.WEB_URL.matcher(s).matches() || s.isEmpty());
    }

    protected void logSubmitAction()
    {
        Pinalytics.a(ElementType.USER_URL_EDIT_BUTTON);
    }

    public void onActivityCreated(Bundle bundle)
    {
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            _userUid = bundle1.getString("com.pinterest.EXTRA_USER_ID");
            _user = ModelHelper.getUser(_userUid);
        }
        super.onActivityCreated(bundle);
        _et.setInputType(16);
    }

    public void setResponseHandler(com.pinterest.api.remote.MyUserApi.SettingsApiResponse settingsapiresponse)
    {
        _responseHandler = settingsapiresponse;
    }

    protected void submit(String s, String s1)
    {
        s = new RequestParams();
        s.a("website_url", s1);
        MyUserApi.a(s, _responseHandler, null);
    }
}
