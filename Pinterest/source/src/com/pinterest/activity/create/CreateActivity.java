// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.create.fragment.CreateBaseFragment;
import com.pinterest.activity.create.fragment.CreateFragment;
import com.pinterest.activity.create.helper.CreateImageHelper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Events;
import com.pinterest.kit.activity.BaseActivity;

public class CreateActivity extends BaseActivity
{

    protected CreateFragment _createFragment;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;

    public CreateActivity()
    {
        _eventsSubscriber = new _cls1();
    }

    public BaseFragment getActiveFragment()
    {
        return _createFragment;
    }

    protected void handleActivityResult(CreateBaseFragment createbasefragment, int i, int j, Intent intent)
    {
        if (j == 0)
        {
            CreateImageHelper.handleCancel(i);
            createbasefragment.getActivity().finish();
            return;
        }
        intent = CreateImageHelper.handleResult(createbasefragment.getActivity(), i, j, intent);
        if (intent != null)
        {
            createbasefragment.setImageUri(intent);
        }
        createbasefragment.updateFromIntent();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        handleActivityResult(_createFragment, i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        _createFragment = new CreateFragment();
        FragmentHelper.replaceFragment(this, _createFragment, false, com.pinterest.activity.FragmentHelper.Animation.NONE);
        FragmentHelper.updateFragmentWidth(this);
        Events.register(_eventsSubscriber, com/pinterest/base/Device$MetricsUpdateEvent, new Class[0]);
    }

    protected void onDestroy()
    {
        Events.unregister(_eventsSubscriber);
        super.onDestroy();
    }

    private class _cls1 extends com.pinterest.base.Events.EventsSubscriber
    {

        final CreateActivity this$0;

        public void onEventMainThread(com.pinterest.base.Device.MetricsUpdateEvent metricsupdateevent)
        {
            FragmentHelper.updateFragmentWidth(CreateActivity.this);
        }

        _cls1()
        {
            this$0 = CreateActivity.this;
            super();
        }
    }

}
