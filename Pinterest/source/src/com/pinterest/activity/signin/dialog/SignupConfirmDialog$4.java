// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.app.Activity;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.task.event.DialogEvent;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.User;
import com.pinterest.appwidget.PWidgetHelper;
import com.pinterest.base.Application;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.kit.application.Resources;
import java.io.IOException;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            SignupDialog, SignupConfirmDialog, SignupDialogView, BusinessSignupDialogView

class  extends com.pinterest.api.remote.ponse
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
        SignupConfirmDialog.access$202(SignupConfirmDialog.this, null);
    }

    public void onFinish()
    {
    }

    public void onSuccess(User user)
    {
        super.onSuccess(user);
        PWidgetHelper.notifyWidgetStateChange(Application.context());
        if (SignupConfirmDialog.access$200(SignupConfirmDialog.this) != null)
        {
            user = (Activity)SignupConfirmDialog.access$200(SignupConfirmDialog.this).get();
        } else
        {
            user = null;
        }
        if (user != null)
        {
            ActivityHelper.goPostSignup(user);
            user.finish();
            SignupConfirmDialog.access$202(SignupConfirmDialog.this, null);
        }
        Events.post(new DialogEvent(null));
        SignupDialogView.onSignupSuccess();
        BusinessSignupDialogView.onSignupSuccess();
    }

    ew(int i)
    {
        this$0 = SignupConfirmDialog.this;
        super(i);
    }
}
