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

public class PromotedPinFeedbackDialog extends BaseDialog
{

    private boolean _fromPinCloseUpView;
    private Pin _pin;
    ApiResponseHandler onFeedback;

    public PromotedPinFeedbackDialog()
    {
        _fromPinCloseUpView = false;
        onFeedback = new ApiResponseHandler();
    }

    public PromotedPinFeedbackDialog(Pin pin)
    {
        _fromPinCloseUpView = false;
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

    public PromotedPinFeedbackDialog(Pin pin, boolean flag)
    {
        this(pin);
        _fromPinCloseUpView = flag;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = new PromotedPinView(activity);
        activity.setPin(_pin);
        setContent(activity, 0);
    }

    public void onCreate(Bundle bundle)
    {
        if (bundle != null && _pin == null)
        {
            _pin = ModelHelper.getPin(bundle.getString("pinUid", null));
        }
        super.onCreate(bundle);
    }


    private class PromotedPinView extends LinearLayout
        implements android.view.View.OnClickListener
    {

        private TextView _message;
        private String _messageText;
        private Pin _pin;
        private TextView _title;
        final PromotedPinFeedbackDialog this$0;

        private void init()
        {
            setOrientation(1);
            inflate(getContext(), 0x7f030056, this);
            _message = (TextView)findViewById(0x7f0b0096);
            if (StringUtils.isNotBlank(_messageText))
            {
                _message.setText(Html.fromHtml(_messageText));
            }
            findViewById(0x7f0b00e7).setOnClickListener(this);
            findViewById(0x7f0b00e8).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131427559 2131427560: default 28
        //                       2131427559 36
        //                       2131427560 60;
               goto _L1 _L2 _L3
_L1:
            dismiss();
            return;
_L2:
            Pinalytics.a(ElementType.PIN_FEEDBACK_DIALOG_BUTTON_LEARN_MORE_PROMOTED, ComponentType.PIN_FEEDBACK_DIALOG_PROMOTED);
            ActivityHelper.goIntentView(getContext(), Resources.string(0x7f0e04e0));
            continue; /* Loop/switch isn't completed */
_L3:
            _pin.setHiddenState(Integer.valueOf(1));
            Events.postSticky(new com.pinterest.api.model.Pin.EditEvent(_pin));
            _pin.setFeedbackType(Integer.valueOf(1));
            PinApi.a(_pin.getUid(), _pin.getFeedbackType().intValue(), onFeedback);
            Pinalytics.a(ElementType.PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PROMOTED, ComponentType.PIN_FEEDBACK_DIALOG_PROMOTED);
            if (_fromPinCloseUpView)
            {
                view = getActivity();
                if (view != null)
                {
                    view.onBackPressed();
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void setPin(Pin pin)
        {
            _pin = pin;
            _pin.getBoard();
            _messageText = Resources.string(0x7f0e03bb, new Object[] {
                _pin.getPromoterUser().getFullName()
            });
            if (StringUtils.isNotBlank(_messageText))
            {
                _message.setText(Html.fromHtml(_messageText));
                return;
            } else
            {
                _message.setText("");
                return;
            }
        }

        public PromotedPinView(Context context)
        {
            this(context, null);
        }

        public PromotedPinView(Context context, AttributeSet attributeset)
        {
            this$0 = PromotedPinFeedbackDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
