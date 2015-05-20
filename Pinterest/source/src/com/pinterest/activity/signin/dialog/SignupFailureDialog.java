// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.kit.application.Resources;
import org.apache.commons.lang3.StringUtils;

public class SignupFailureDialog extends BaseDialog
{

    public SignupFailureDialog()
    {
    }

    public SignupFailureDialog(Throwable throwable, ApiResponse apiresponse, final int type, final String inviteCode)
    {
        final boolean goRequestInvite;
        goRequestInvite = false;
        throwable = apiresponse.getMessageDisplay();
        apiresponse.getCode();
        JVM INSTR lookupswitch 6: default 76
    //                   1: 172
    //                   90: 164
    //                   91: 146
    //                   92: 155
    //                   802: 270
    //                   804: 270;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_270;
_L7:
        if (StringUtils.isEmpty(throwable))
        {
            throwable = Resources.string(0x7f0e02cb);
        }
        int i;
        if (goRequestInvite)
        {
            i = 0x7f0e0340;
        } else
        {
            i = 0x7f0e0034;
        }
        setTitle(i);
        setMessage(throwable);
        if (goRequestInvite)
        {
            i = 0x7f0e038c;
        } else
        {
            i = 0x7f0e04b7;
        }
        setPositiveButton(i, new _cls1());
        setNegativeButton(0x7f0e008f, null);
        return;
_L4:
        throwable = Resources.string(0x7f0e0466);
          goto _L7
_L5:
        throwable = Resources.string(0x7f0e0480);
          goto _L7
_L3:
        throwable = apiresponse.getMessageDetail();
          goto _L7
_L2:
        if (!(apiresponse.getData() instanceof PinterestJsonObject))
        {
            break MISSING_BLOCK_LABEL_270;
        }
        apiresponse = (PinterestJsonObject)apiresponse.getData();
        try
        {
            apiresponse = apiresponse.a("param_name", "");
        }
        // Misplaced declaration of an exception variable
        catch (ApiResponse apiresponse)
        {
            apiresponse.printStackTrace();
            apiresponse = null;
        }
        if (!StringUtils.isNotEmpty(apiresponse))
        {
            break MISSING_BLOCK_LABEL_270;
        }
        if (apiresponse.equals("email"))
        {
            throwable = Resources.string(0x7f0e0465);
        } else
        if (apiresponse.equals("username"))
        {
            throwable = Resources.string(0x7f0e047e);
        } else
        {
            if (!apiresponse.equals("password"))
            {
                break MISSING_BLOCK_LABEL_270;
            }
            throwable = Resources.string(0x7f0e0474);
        }
          goto _L7
        goRequestInvite = true;
          goto _L7
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final SignupFailureDialog this$0;
        final BaseDialog val$dialog;
        final boolean val$goRequestInvite;
        final String val$inviteCode;
        final int val$type;

        public void onClick(View view)
        {
            if (goRequestInvite)
            {
                dialog.dismiss();
                FragmentHelper.replaceFragment(getActivity(), new PinvitationalInviteRequestFragment(), false, com.pinterest.activity.FragmentHelper.Animation.SLIDE);
                return;
            }
            if (type == 1)
            {
                Events.post(new DialogEvent(new EmailSignupDialog(null, inviteCode)));
                return;
            }
            if (type == 6)
            {
                Events.post(new DialogEvent(new BusinessSignupDialog(null, inviteCode)));
                return;
            } else
            {
                Events.post(new DialogEvent(new SignupDialog()));
                return;
            }
        }

        _cls1()
        {
            this$0 = SignupFailureDialog.this;
            goRequestInvite = flag;
            dialog = basedialog;
            type = i;
            inviteCode = s;
            super();
        }
    }

}
