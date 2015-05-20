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
import com.pinterest.schemas.event.ComponentType;

public class AdditionalPinFeedbackDialog extends BaseDialog
{

    private static final int NOT_INTERESTED = 1;
    private static final int OFFENSIVE = 2;
    private static final int OTHER_REASON = 0;
    private static final int SEEN_IT_BEFORE = 3;
    private ComponentType COMPONENT_TYPE;
    private Pin _pin;
    ApiResponseHandler onFeedback;

    public AdditionalPinFeedbackDialog()
    {
        onFeedback = new ApiResponseHandler();
    }

    public AdditionalPinFeedbackDialog(Pin pin)
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
        activity = new AdditionalPinFeedbackView(activity);
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



/*
    static ComponentType access$002(AdditionalPinFeedbackDialog additionalpinfeedbackdialog, ComponentType componenttype)
    {
        additionalpinfeedbackdialog.COMPONENT_TYPE = componenttype;
        return componenttype;
    }

*/

    private class AdditionalPinFeedbackView extends LinearLayout
        implements android.view.View.OnClickListener
    {

        private Pin _pin;
        final AdditionalPinFeedbackDialog this$0;

        private void init()
        {
            setOrientation(1);
            inflate(getContext(), 0x7f03003c, this);
            findViewById(0x7f0b0098).setOnClickListener(this);
            findViewById(0x7f0b0097).setOnClickListener(this);
            findViewById(0x7f0b0099).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            int i = 0;
            view.getId();
            JVM INSTR tableswitch 2131427479 2131427481: default 32
        //                       2131427479 127
        //                       2131427480 145
        //                       2131427481 163;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L4:
            break MISSING_BLOCK_LABEL_163;
_L5:
            if (_pin != null && _pin.getRecommendationReason() != null)
            {
                PinApi.a(_pin.getUid(), _pin.getFeedbackType().intValue(), _pin.getRecommendationBoardUid(), Pin.getRecommendationUid(_pin.getRecommendationReason()), i, onFeedback);
            } else
            {
                PinApi.a(_pin.getUid(), _pin.getFeedbackType().intValue(), i, onFeedback);
            }
            _pin.setHiddenState(Integer.valueOf(2));
            Events.postSticky(new com.pinterest.api.model.Pin.EditEvent(_pin));
            dismiss();
            return;
_L2:
            i = 1;
            Pinalytics.a(ElementType.PIN_FEEDBACK_REASON_BUTTON_NOT_INTERESTED, COMPONENT_TYPE);
              goto _L5
_L3:
            Pinalytics.a(ElementType.PIN_FEEDBACK_REASON_BUTTON_OFFENSIVE, COMPONENT_TYPE);
            i = 2;
              goto _L5
            i = 3;
            Pinalytics.a(ElementType.PIN_FEEDBACK_REASON_BUTTON_SEEN_BEFORE, COMPONENT_TYPE);
              goto _L5
        }

        public void setPin(Pin pin)
        {
            _pin = pin;
            if (_pin.getPromoterUid() != null)
            {
                COMPONENT_TYPE = ComponentType.PIN_FEEDBACK_DIALOG_PROMOTED_REASON;
                return;
            } else
            {
                COMPONENT_TYPE = ComponentType.PIN_FEEDBACK_DIALOG_PFY_REASON;
                return;
            }
        }

        public AdditionalPinFeedbackView(Context context)
        {
            this(context, null);
        }

        public AdditionalPinFeedbackView(Context context, AttributeSet attributeset)
        {
            this$0 = AdditionalPinFeedbackDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
