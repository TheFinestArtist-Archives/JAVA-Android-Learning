// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.digest.ui;

import android.os.Bundle;
import com.pinterest.activity.digest.adapter.DigestFeedbackAdapter;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.model.DigestItem;
import com.pinterest.api.model.Pin;

public class DigestFeedbackDialog extends BaseDialog
{

    private DigestFeedbackAdapter _adapter;
    private Pin _firstIncludedPin;
    private DigestItem _item;
    private android.widget.AdapterView.OnItemClickListener onItemClickListener;

    public DigestFeedbackDialog(DigestItem digestitem)
    {
        onItemClickListener = new _cls1();
        _item = digestitem;
    }

    public void onActivityCreated(Bundle bundle)
    {
        _adapter = new DigestFeedbackAdapter(getContext());
        _adapter.setApiTag(null);
        _adapter.setDigestItem(_item);
        setListViewOptions(_adapter, onItemClickListener);
        super.onActivityCreated(bundle);
    }

    public void setFirstIncludedPin(Pin pin)
    {
        _firstIncludedPin = pin;
    }



    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final DigestFeedbackDialog this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (_adapter != null)
            {
                _adapter.unFollow(i, _firstIncludedPin);
            }
            dismiss();
        }

        _cls1()
        {
            this$0 = DigestFeedbackDialog.this;
            super();
        }
    }

}
