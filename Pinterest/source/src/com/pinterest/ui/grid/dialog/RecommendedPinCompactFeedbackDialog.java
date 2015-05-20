// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.grid.dialog;

import android.app.Activity;
import android.os.Bundle;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.Pin;

public class RecommendedPinCompactFeedbackDialog extends BaseDialog
{

    private Pin _pin;
    ApiResponseHandler onFeedback;

    public RecommendedPinCompactFeedbackDialog()
    {
        onFeedback = new ApiResponseHandler();
    }

    public RecommendedPinCompactFeedbackDialog(Pin pin)
    {
        onFeedback = new ApiResponseHandler();
        _pin = pin;
        Bundle bundle = getArguments();
        pin = bundle;
        if (bundle == null)
        {
            pin = new Bundle();
        }
        pin.putString("pinUid", _pin.getUid());
        setArguments(pin);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = new RecommendedPinView(activity);
        activity.setPin(_pin);
        setContent(activity, 0);
    }

    public void onCreate(Bundle bundle)
    {
        if (bundle != null && _pin == null)
        {
            _pin = ModelHelper.getPin(bundle.getString("pinUid"));
        }
        super.onCreate(bundle);
    }

    private class RecommendedPinView extends LinearLayout
        implements android.view.View.OnClickListener
    {

        private Pin _pin;
        final RecommendedPinCompactFeedbackDialog this$0;

        private void init()
        {
            setOrientation(1);
            inflate(getContext(), 0x7f030058, this);
            findViewById(0x7f0b00e8).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131427560 2131427560: default 24
        //                       2131427560 32;
               goto _L1 _L2
_L1:
            dismiss();
            return;
_L2:
            _pin.setHiddenState(Integer.valueOf(1));
            Events.postSticky(new com.pinterest.api.model.Pin.EditEvent(_pin));
            _pin.setFeedbackType(Integer.valueOf(1));
            Pinalytics.a(ElementType.PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY, ComponentType.PIN_FEEDBACK_DIALOG_PFY);
            PinApi.a(_pin.getUid(), _pin.getFeedbackType().intValue(), _pin.getRecommendationBoardUid(), onFeedback, null);
            if (true) goto _L1; else goto _L3
_L3:
        }

        public void setPin(Pin pin)
        {
            _pin = pin;
        }

        public RecommendedPinView(Context context)
        {
            this(context, null);
        }

        public RecommendedPinView(Context context, AttributeSet attributeset)
        {
            this$0 = RecommendedPinCompactFeedbackDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
