// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.api.BaseApiResponseHandler;
import com.pinterest.api.remote.AccountApi;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.api.remote.BusinessApi;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            BusinessSignupDialog, SignupDialog

public class SignupConfirmDialog extends BaseDialog
{

    public static final String KEY = "signup_confirm";
    private WeakReference _activity;
    private boolean _partnerSignup;
    private com.pinterest.api.remote.AccountApi.SignupParams _signupParams;
    private BaseApiResponseHandler onEmailSignup;
    private com.pinterest.api.remote.MyUserApi.MyUserApiResponse onLoadMe;

    public SignupConfirmDialog()
    {
        _partnerSignup = false;
        onEmailSignup = new _cls3(0x7f0e02c4);
        onLoadMe = new _cls4(0x7f0e02c4);
        _key = "signup_confirm";
    }

    public void doEmailSignup()
    {
        StopWatch.get().start("signup_email");
        if (getPartnerSignup())
        {
            try
            {
                BusinessApi.a((com.pinterest.api.remote.BusinessApi.PartnerParams)_signupParams, onEmailSignup);
                return;
            }
            catch (Exception exception)
            {
                StopWatch.get().invalidate("signup_email");
                Events.post(new DialogEvent(new BusinessSignupDialog()));
                CrashReporting.logHandledException(exception);
                return;
            }
        }
        try
        {
            AccountApi.a(_signupParams, onEmailSignup);
            return;
        }
        catch (Exception exception1)
        {
            StopWatch.get().invalidate("signup_email");
            Events.post(new DialogEvent(new SignupDialog()));
            CrashReporting.logHandledException(exception1);
            return;
        }
    }

    public boolean getPartnerSignup()
    {
        return _partnerSignup;
    }

    public com.pinterest.api.remote.AccountApi.SignupParams getSignupParams()
    {
        return _signupParams;
    }

    public void make(LayoutInflater layoutinflater)
    {
        setTitle(0x7f0e00bc);
        setSubTitle(0x7f0e01d3);
        super.make(layoutinflater);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        AnalyticsApi.a("signup_email_confirm");
        View view = LayoutInflater.from(activity).inflate(0x7f030050, null);
        if (view == null)
        {
            return;
        } else
        {
            final EditText emailEt = (EditText)view.findViewById(0x7f0b00c2);
            emailEt.setText(_signupParams.q);
            emailEt.setSelected(false);
            setContent(view);
            setNegativeButton(0x7f0e008f, new _cls1());
            setPositiveButton(0x7f0e04ab, new _cls2());
            _activity = new WeakReference(activity);
            return;
        }
    }

    public void setActivity(Activity activity)
    {
        _activity = new WeakReference(activity);
    }

    public void setPartnerSignup(boolean flag)
    {
        _partnerSignup = flag;
    }

    public void setSignupParams(com.pinterest.api.remote.AccountApi.SignupParams signupparams)
    {
        _signupParams = signupparams;
    }





/*
    static WeakReference access$202(SignupConfirmDialog signupconfirmdialog, WeakReference weakreference)
    {
        signupconfirmdialog._activity = weakreference;
        return weakreference;
    }

*/

    private class _cls3 extends ApiResponseHandler
    {

        final SignupConfirmDialog this$0;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            StopWatch.get().invalidate("signup_email");
            int i;
            if (getPartnerSignup())
            {
                i = 6;
            } else
            {
                i = _signupParams.a();
            }
            Events.post(new DialogEvent(new SignupFailureDialog(throwable, apiresponse, i, _signupParams.s)));
        }

        public void onFinish()
        {
            ActivityHelper.setPostSignup(true);
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            MyUser.setAccessToken((String)apiresponse.getData());
            if (getPartnerSignup())
            {
                apiresponse = "register_partner";
            } else
            {
                apiresponse = "register_email";
            }
            AnalyticsApi.a(apiresponse);
            MyUserApi.a(onLoadMe, null);
        }

        _cls3(int i)
        {
            this$0 = SignupConfirmDialog.this;
            super(i);
        }
    }


    private class _cls4 extends com.pinterest.api.remote.MyUserApi.MyUserApiResponse
    {

        final SignupConfirmDialog this$0;

        public void onFailure(Throwable throwable, PinterestJsonObject pinterestjsonobject)
        {
            StopWatch.get().invalidate("signup_email");
            Events.post(new DialogEvent(new SignupDialog()));
            if (throwable instanceof IOException)
            {
                Application.showNoInternetToast();
            } else
            if (pinterestjsonobject != null)
            {
                Application.showToast(pinterestjsonobject.a("error", Resources.string(0x7f0e02cb)), 0x7f0200fa);
            } else
            {
                Application.showToast(0x7f0e02cb, 0x7f0200fa);
            }
            _activity = null;
        }

        public void onFinish()
        {
        }

        public void onSuccess(User user)
        {
            super.onSuccess(user);
            PWidgetHelper.notifyWidgetStateChange(Application.context());
            if (_activity != null)
            {
                user = (Activity)_activity.get();
            } else
            {
                user = null;
            }
            if (user != null)
            {
                ActivityHelper.goPostSignup(user);
                user.finish();
                _activity = null;
            }
            Events.post(new DialogEvent(null));
            SignupDialogView.onSignupSuccess();
            BusinessSignupDialogView.onSignupSuccess();
        }

        _cls4(int i)
        {
            this$0 = SignupConfirmDialog.this;
            super(i);
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final SignupConfirmDialog this$0;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.CANCEL_BUTTON);
            if (getPartnerSignup())
            {
                view = new BusinessSignupDialog();
            } else
            {
                view = new SignupDialog();
            }
            Events.post(new DialogEvent(view));
        }

        _cls1()
        {
            this$0 = SignupConfirmDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final SignupConfirmDialog this$0;
        final EditText val$emailEt;

        public void onClick(View view)
        {
            Pinalytics.a(ElementType.DONE_BUTTON);
            view = emailEt.getText().toString();
            if (SignupFormUtils.isEmailValid(view))
            {
                _signupParams.q = view;
                doEmailSignup();
                return;
            } else
            {
                Application.showToast(0x7f0e0465);
                return;
            }
        }

        _cls2()
        {
            this$0 = SignupConfirmDialog.this;
            emailEt = edittext;
            super();
        }
    }

}
