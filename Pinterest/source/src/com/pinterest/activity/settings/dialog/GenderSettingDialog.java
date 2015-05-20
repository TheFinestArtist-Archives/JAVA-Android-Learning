// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.settings.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.ButterKnife;
import com.pinterest.activity.task.dialog.BaseDialog;
import com.pinterest.api.RequestParams;
import com.pinterest.api.model.MyUser;
import com.pinterest.api.model.User;
import com.pinterest.api.remote.MyUserApi;

public class GenderSettingDialog extends BaseDialog
{

    private View _container;
    RadioButton _femaleBt;
    RadioGroup _genderGroup;
    private int _initCheckId;
    RadioButton _maleBt;
    private android.view.View.OnClickListener onGenderClick;

    public GenderSettingDialog()
    {
        onGenderClick = new _cls3();
    }

    private void onSaveGenderClicked(final String oldGender)
    {
        RequestParams requestparams = new RequestParams();
        if (_genderGroup == null) goto _L2; else goto _L1
_L1:
        _genderGroup.getCheckedRadioButtonId();
        JVM INSTR tableswitch 2131427526 2131427527: default 44
    //                   2131427526 97
    //                   2131427527 103;
           goto _L3 _L4 _L5
_L3:
        final String gender = "unspecified";
_L7:
        requestparams.a("gender", gender);
        final User me = MyUser.get();
        if (me != null)
        {
            me.setGender(gender);
        }
        MyUserApi.a(requestparams, new _cls2(), null);
        _genderGroup = null;
        dismiss();
        return;
_L4:
        gender = "female";
        continue; /* Loop/switch isn't completed */
_L5:
        gender = "male";
        continue; /* Loop/switch isn't completed */
_L2:
        gender = "unspecified";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void init()
    {
        ButterKnife.a(this, _container);
    }

    public void make(LayoutInflater layoutinflater)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            _container = LayoutInflater.from(getActivity()).inflate(0x7f030047, null);
            setContent(_container, 0);
            super.make(layoutinflater);
            init();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        final String gender;
        gender = MyUser.get();
        if (gender == null)
        {
            return;
        }
        gender = gender.getGender();
        _genderGroup.clearCheck();
        if (!gender.equals("female")) goto _L2; else goto _L1
_L1:
        _femaleBt.setChecked(true);
_L4:
        _initCheckId = _genderGroup.getCheckedRadioButtonId();
        _femaleBt.setOnClickListener(onGenderClick);
        _maleBt.setOnClickListener(onGenderClick);
        setTitle(0x7f0e01bb);
        setNegativeButton(getString(0x7f0e008f), null);
        setPositiveButton(getString(0x7f0e040b), new _cls1());
        super.onActivityCreated(bundle);
        return;
_L2:
        if (gender.equals("male"))
        {
            _maleBt.setChecked(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



    private class _cls3
        implements android.view.View.OnClickListener
    {

        private boolean _firstClick;
        private int _lastGenderBt;
        final GenderSettingDialog this$0;

        public void onClick(View view)
        {
            if (_firstClick)
            {
                _lastGenderBt = _initCheckId;
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

        _cls3()
        {
            this$0 = GenderSettingDialog.this;
            super();
            _lastGenderBt = -1;
            _firstClick = true;
        }
    }


    private class _cls2 extends com.pinterest.api.remote.MyUserApi.SettingsApiResponse
    {

        final GenderSettingDialog this$0;
        final String val$gender;
        final User val$me;
        final String val$oldGender;

        public void onFailure(Throwable throwable, ApiResponse apiresponse)
        {
            super.onFailure(throwable, apiresponse);
            me.setGender(oldGender);
            Events.post(new DialogEvent(null));
        }

        public void onStart()
        {
            super.onStart();
            Events.post(new DialogEvent(new LoadingDialog()));
        }

        public void onSuccess(ApiResponse apiresponse)
        {
            super.onSuccess(apiresponse);
            apiresponse = new HashMap();
            apiresponse.put("label", gender);
            Pinalytics.a(EventType.USER_GENDER_CHANGED, null, apiresponse);
            Application.showToastShort(0x7f0e01bc);
            Events.post(new DialogEvent(null));
        }

        _cls2()
        {
            this$0 = GenderSettingDialog.this;
            gender = s;
            me = user;
            oldGender = s1;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final GenderSettingDialog this$0;
        final String val$gender;

        public void onClick(View view)
        {
            onSaveGenderClicked(gender);
        }

        _cls1()
        {
            this$0 = GenderSettingDialog.this;
            gender = s;
            super();
        }
    }

}
