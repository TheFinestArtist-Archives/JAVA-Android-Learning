// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.api.remote.UserApi;
import com.pinterest.base.Events;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.schemas.experiences.Experience;
import com.pinterest.ui.megaphone.NagHideAndUpdateEvent;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalData, InviteUtil, PinvitationalConfettiView

public class PinvitationalConfirmFragment extends BaseFragment
{

    private static final int TIMEOUT = 3000;
    private static Handler sHandler;
    protected PinvitationalConfettiView _bgContainer;
    protected ViewGroup _fgContainer;
    protected ViewGroup _inviteeContainer;
    ArrayList _invitees;
    protected TextView _titleTv;

    public PinvitationalConfirmFragment()
    {
    }

    private TextView buildInviteeTextView(String s)
    {
        TextView textview = new TextView(getActivity());
        textview.setTextAppearance(getActivity(), 0x7f0f01a7);
        textview.setTextSize(0, getResources().getDimension(0x7f0a00fd));
        textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
        textview.setGravity(1);
        textview.setTypeface(null, 1);
        textview.setSingleLine(true);
        textview.setText(s);
        return textview;
    }

    private static Handler getHandler()
    {
        if (sHandler == null)
        {
            sHandler = new Handler(Looper.getMainLooper());
        }
        return sHandler;
    }

    public boolean onBackPressed()
    {
        Events.post(new InviteConfirmEvent());
        return super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03008e;
    }

    public void onResume()
    {
        boolean flag = true;
        super.onResume();
        Experiences.c();
        Object obj = Experiences.a(Experiences.a);
        if (((ExperienceValue) (obj)).b == Experience.ANDROID_NAG_PINVITATIONAL.getValue())
        {
            if (PinvitationalData.getQuota() - Math.max(_invitees.size(), 1) <= 0)
            {
                flag = false;
            }
            Events.post(new NagHideAndUpdateEvent(flag));
            ((ExperienceValue) (obj)).d();
        }
        obj = new _cls3();
        getHandler().postDelayed(((Runnable) (obj)), 3000L);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        ButterKnife.a(this, view);
        _invitees = _navigation.getStringArrayListParcelable("invitees");
        _fgContainer.setOnClickListener(new _cls1());
        for (view = _invitees.iterator(); view.hasNext(); _inviteeContainer.addView(buildInviteeTextView(bundle)))
        {
            bundle = (String)view.next();
        }

        if (_invitees.size() > 0)
        {
            UserApi.a(InviteUtil.joinEmails(_invitees), false, InviteUtil.getInviteSource(), new _cls2(), getApiTag());
            _titleTv.setTextAppearance(getActivity(), 0x7f0f01a7);
            _titleTv.setTextSize(0, getResources().getDimension(0x7f0a00f4));
        } else
        {
            _titleTv.setTextAppearance(getActivity(), 0x7f0f01ae);
            _titleTv.setTextSize(0, getResources().getDimension(0x7f0a00fd));
            _titleTv.setText(0x7f0e0385);
        }
        _bgContainer.playAnimation(getActivity().getWindow().getDecorView().getHeight());
        AnalyticsApi.b("PINVITATIONAL_INVITE_CONFIRM");
    }

    private class InviteConfirmEvent
    {

        final PinvitationalConfirmFragment this$0;

        public InviteConfirmEvent()
        {
            this$0 = PinvitationalConfirmFragment.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final PinvitationalConfirmFragment this$0;

        public void run()
        {
            if (isActive())
            {
                Events.post(new Navigation(Location.HOME, MyUser.getUid()));
            }
        }

        _cls3()
        {
            this$0 = PinvitationalConfirmFragment.this;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PinvitationalConfirmFragment this$0;

        public void onClick(View view)
        {
            Events.post(new Navigation(Location.HOME, MyUser.getUid()));
        }

        _cls1()
        {
            this$0 = PinvitationalConfirmFragment.this;
            super();
        }
    }


    private class _cls2 extends BaseApiResponseHandler
    {

        final PinvitationalConfirmFragment this$0;

        public void onSuccess(String s)
        {
            super.onSuccess(s);
            Events.post(new InviteSendEvent(true, new HashSet(_invitees)));
        }

        _cls2()
        {
            this$0 = PinvitationalConfirmFragment.this;
            super();
        }
    }

}
