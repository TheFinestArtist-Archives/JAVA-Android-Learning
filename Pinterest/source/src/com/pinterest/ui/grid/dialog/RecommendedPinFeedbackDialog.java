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

public class RecommendedPinFeedbackDialog extends BaseDialog
{

    public static final String REPIN_BOARD = "REPIN_BOARD";
    private Pin _pin;
    ApiResponseHandler onFeedback;

    public RecommendedPinFeedbackDialog()
    {
        onFeedback = new ApiResponseHandler();
    }

    public RecommendedPinFeedbackDialog(Pin pin)
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

        private TextView _message;
        private String _messageText;
        private Pin _pin;
        private TextView _title;
        final RecommendedPinFeedbackDialog this$0;

        private void init()
        {
            setOrientation(1);
            inflate(getContext(), 0x7f030057, this);
            _message = (TextView)findViewById(0x7f0b0096);
            if (StringUtils.isNotBlank(_messageText))
            {
                _message.setText(Html.fromHtml(_messageText));
            }
            findViewById(0x7f0b00e9).setOnClickListener(this);
            findViewById(0x7f0b00e8).setOnClickListener(this);
        }

        public void onClick(View view)
        {
            view.getId();
            JVM INSTR tableswitch 2131427560 2131427561: default 28
        //                       2131427560 119
        //                       2131427561 85;
               goto _L1 _L2 _L3
_L1:
            Events.postSticky(new com.pinterest.api.model.Pin.EditEvent(_pin));
            PinApi.a(_pin.getUid(), _pin.getFeedbackType().intValue(), _pin.getRecommendationBoardUid(), onFeedback, null);
            dismiss();
            return;
_L3:
            _pin.setHiddenState(Integer.valueOf(1));
            _pin.setFeedbackType(Integer.valueOf(2));
            Pinalytics.a(ElementType.PIN_FEEDBACK_DIALOG_BUTTON_PFY_STOP_RECS_FROM_THROUGH_BOARD, ComponentType.PIN_FEEDBACK_DIALOG_PFY);
            continue; /* Loop/switch isn't completed */
_L2:
            _pin.setHiddenState(Integer.valueOf(1));
            _pin.setFeedbackType(Integer.valueOf(1));
            Pinalytics.a(ElementType.PIN_FEEDBACK_DIALOG_BUTTON_HIDE_PIN_PFY, ComponentType.PIN_FEEDBACK_DIALOG_PFY);
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void setPin(Pin pin)
        {
            _pin = pin;
            if (_pin != null)
            {
                pin = _pin.getRecommendationReason();
                String s = _pin.getRecommendationMessage();
                Board board = _pin.getRecommendationBoard();
                if ("REPIN_BOARD".equalsIgnoreCase(pin) && board != null && StringUtils.isNotBlank(board.getName()))
                {
                    _messageText = Resources.string(0x7f0e04ad, new Object[] {
                        board.getName()
                    });
                } else
                if (pin != null && s != null)
                {
                    _messageText = Resources.string(0x7f0e001a);
                } else
                {
                    _messageText = "";
                }
            } else
            {
                _messageText = "";
            }
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

        public RecommendedPinView(Context context)
        {
            this(context, null);
        }

        public RecommendedPinView(Context context, AttributeSet attributeset)
        {
            this$0 = RecommendedPinFeedbackDialog.this;
            super(context, attributeset);
            init();
        }
    }

}
