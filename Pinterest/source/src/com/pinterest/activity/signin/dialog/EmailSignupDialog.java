// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.remote.AnalyticsApi;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            EmailSignupDialogView

public class EmailSignupDialog extends BaseDialog
{

    public static final String KEY = "email";
    private String _email;
    private String _inviteCode;

    public EmailSignupDialog()
    {
        this(null, null);
    }

    public EmailSignupDialog(String s, String s1)
    {
        _key = "email";
        _email = s;
        _inviteCode = s1;
    }

    public void make(LayoutInflater layoutinflater)
    {
        EmailSignupDialogView emailsignupdialogview = new EmailSignupDialogView(getContext());
        emailsignupdialogview.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
        setContent(emailsignupdialogview, 0);
        super.make(layoutinflater);
        emailsignupdialogview.setEmailAddress(_email);
        emailsignupdialogview.setInviteCode(_inviteCode);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        AnalyticsApi.a("email_signup_dialog");
    }

    public void onPause()
    {
        Pinalytics.c();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Pinalytics.a(this);
    }
}
