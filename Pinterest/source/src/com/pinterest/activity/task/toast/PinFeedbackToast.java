// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast;

import android.view.View;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.api.model.Pin;

// Referenced classes of package com.pinterest.activity.task.toast:
//            BaseToast

public class PinFeedbackToast extends BaseToast
{

    private Pin _pin;
    private boolean _upVote;

    public PinFeedbackToast(Pin pin, boolean flag)
    {
        _pin = pin;
        _upVote = flag;
    }

    public View getView(ToastContainer toastcontainer)
    {
        setImageUrl(_pin.getImageSquareUrl());
        int i;
        if (_upVote)
        {
            i = 0x7f0e025c;
        } else
        {
            i = 0x7f0e04aa;
        }
        setMessage(i);
        if (_upVote)
        {
            i = 0x7f0e03d4;
        } else
        {
            i = 0x7f0e03d5;
        }
        setSecondaryMessage(i);
        setLayoutGravity(81);
        return super.getView(toastcontainer);
    }
}
