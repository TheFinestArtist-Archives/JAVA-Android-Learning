// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import android.view.View;
import android.widget.EditText;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.base.Application;
import com.pinterest.kit.utils.SignupFormUtils;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            SignupConfirmDialog

class val.emailEt
    implements android.view.g.SignupConfirmDialog._cls2
{

    final SignupConfirmDialog this$0;
    final EditText val$emailEt;

    public void onClick(View view)
    {
        Pinalytics.a(ElementType.DONE_BUTTON);
        view = val$emailEt.getText().toString();
        if (SignupFormUtils.isEmailValid(view))
        {
            SignupConfirmDialog.access$000(SignupConfirmDialog.this).q = view;
            doEmailSignup();
            return;
        } else
        {
            Application.showToast(0x7f0e0465);
            return;
        }
    }

    ()
    {
        this$0 = final_signupconfirmdialog;
        val$emailEt = EditText.this;
        super();
    }
}
