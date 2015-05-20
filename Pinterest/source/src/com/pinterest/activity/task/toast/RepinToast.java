// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast;

import android.view.View;
import com.pinterest.activity.task.toast.view.ToastContainer;
import com.pinterest.api.model.Board;
import com.pinterest.api.model.Pin;
import com.pinterest.kit.application.Resources;

// Referenced classes of package com.pinterest.activity.task.toast:
//            BaseToast

public class RepinToast extends BaseToast
{

    private Pin _pin;
    private final android.view.View.OnClickListener onToastClickListener = new _cls1();

    public RepinToast(Pin pin)
    {
        _pin = pin;
        setToastOnClickListener(onToastClickListener);
    }

    public View getView(ToastContainer toastcontainer)
    {
        if (_pin.getBoard() != null)
        {
            setImageUrl(_pin.getBoard().getImageCoverThumbnail());
            setImageOval(false);
        }
        setMessage(0x7f0e0376);
        setSecondaryMessage(String.format(Resources.string(0x7f0e04b0), new Object[] {
            _pin.getBoard().getName()
        }));
        setLayoutGravity(81);
        return super.getView(toastcontainer);
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final RepinToast this$0;

        public void onClick(View view)
        {
            Events.post(new Navigation(Location.BOARD, _pin.getBoard()));
        }

        _cls1()
        {
            this$0 = RepinToast.this;
            super();
        }
    }

}
