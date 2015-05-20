// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.signin.dialog;

import com.facebook.model.GraphUser;
import com.pinterest.ui.text.PEditText;

// Referenced classes of package com.pinterest.activity.signin.dialog:
//            SignupDialogView

class this._cls0 extends com.pinterest.base.iber
{

    final SignupDialogView this$0;

    public void onEventMainThread(com.pinterest.base.ignupDialogView._cls1 _pcls1)
    {
        if (_pcls1.isConnected())
        {
            switch (.SwitchMap.com.pinterest.base.Social.Network[_pcls1.getNetwork().nal()])
            {
            default:
                return;

            case 1: // '\001'
                _pcls1 = _pcls1.getGraphUser();
                break;
            }
            if (_pcls1 != null)
            {
                _firstnameEt.setText(_pcls1.getFirstName());
                if (_lastnameEt != null)
                {
                    _lastnameEt.setText(_pcls1.getLastName());
                }
                _emailEt.setText((String)_pcls1.getProperty("email"));
                return;
            }
        }
    }

    ()
    {
        this$0 = SignupDialogView.this;
        super();
    }
}
