// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings.dialog;

import android.view.View;
import android.widget.RadioGroup;

// Referenced classes of package com.pinterest.activity.settings.dialog:
//            GenderSettingDialog

class _firstClick
    implements android.view.log.GenderSettingDialog._cls3
{

    private boolean _firstClick;
    private int _lastGenderBt;
    final GenderSettingDialog this$0;

    public void onClick(View view)
    {
        if (_firstClick)
        {
            _lastGenderBt = GenderSettingDialog.access$100(GenderSettingDialog.this);
            _firstClick = false;
        }
        if (_lastGenderBt == view.getId() && view.getId() == _genderGroup.getCheckedRadioButtonId())
        {
            _genderGroup.clearCheck();
            _lastGenderBt = -1;
            return;
        } else
        {
            _lastGenderBt = _genderGroup.getCheckedRadioButtonId();
            return;
        }
    }

    ()
    {
        this$0 = GenderSettingDialog.this;
        super();
        _lastGenderBt = -1;
        _firstClick = true;
    }
}
