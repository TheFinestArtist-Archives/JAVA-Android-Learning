// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.unauth.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import butterknife.ButterKnife;
import com.pinterest.activity.ActivityHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.base.Events;
import com.pinterest.kit.activity.DialogHostActivity;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.pinterest.activity.unauth.fragment:
//            PinvitationalInviteRequestFragment, PinvitationalSignupFragment, InspiredWallFragment

public class UnauthLoadingFragment extends BaseFragment
{

    private static final int API_TIMEOUT = 5000;
    private static final String INVITE_CODE_PARAM_KEY = "invite_code";
    Runnable _apiTimeout;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private volatile boolean _expCheckCompleted;
    private Handler _handler;
    private volatile boolean _hasInvalidInviteCode;
    private String _inviteCode;
    private volatile boolean _inviteCodeCheckCompleted;
    private String _inviteUrl;
    private volatile boolean _isPinvitational;
    private AtomicBoolean _nextStepCompleted;

    public UnauthLoadingFragment()
    {
        _isPinvitational = false;
        _hasInvalidInviteCode = false;
        _nextStepCompleted = new AtomicBoolean(false);
        _expCheckCompleted = false;
        _inviteCodeCheckCompleted = true;
        _apiTimeout = new _cls1();
        _eventsSubscriber = new _cls2();
    }

    private void goToNextStep()
    {
        if (getActivity() == null || !((DialogHostActivity)getActivity()).isVisible() || !_expCheckCompleted || !_inviteCodeCheckCompleted || !_nextStepCompleted.compareAndSet(false, true))
        {
            return;
        }
        _handler.removeCallbacks(_apiTimeout);
        Object obj;
        if (_isPinvitational)
        {
            if (_inviteCode == null || _hasInvalidInviteCode)
            {
                obj = new PinvitationalInviteRequestFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("com.pinterest.EXTRA_SIGNUP_HAS_INVALID_INVITE_CODE", _hasInvalidInviteCode);
                ((BaseFragment) (obj)).setArguments(bundle);
            } else
            {
                obj = new PinvitationalSignupFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("com.pinterest.EXTRA_SIGNUP_INVITE_CODE", _inviteCode);
                ((BaseFragment) (obj)).setArguments(bundle1);
            }
        } else
        if (_inviteCode == null)
        {
            obj = new InspiredWallFragment();
        } else
        {
            ActivityHelper.gotoBrowser(getActivity(), _inviteUrl);
            return;
        }
        FragmentHelper.replaceFragment(getActivity(), ((android.support.v4.app.Fragment) (obj)), false, com.pinterest.activity.FragmentHelper.Animation.FADE);
    }

    private void init()
    {
        _handler = new Handler();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300af;
    }

    public void onDestroyView()
    {
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/experiment/Experiments$ExperimentsLoaded, com/pinterest/api/remote/AccountApi$InviteCodeValidationResult
        });
        super.onDestroyView();
    }

    public void onStart()
    {
        super.onStart();
        setActive(true);
        _handler.postDelayed(_apiTimeout, 5000L);
    }

    public void onStop()
    {
        super.onStop();
        _handler.removeCallbacks(_apiTimeout);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        init();
        Events.register(_eventsSubscriber, com/pinterest/experiment/Experiments$ExperimentsLoaded, new Class[] {
            com/pinterest/api/remote/AccountApi$InviteCodeValidationResult
        });
    }

    public void setInviteUrl(String s)
    {
        _inviteUrl = s;
        _inviteCodeCheckCompleted = false;
        try
        {
            _inviteCode = Uri.parse(_inviteUrl).getQueryParameter("invite_code");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }



/*
    static boolean access$002(UnauthLoadingFragment unauthloadingfragment, boolean flag)
    {
        unauthloadingfragment._expCheckCompleted = flag;
        return flag;
    }

*/



/*
    static boolean access$102(UnauthLoadingFragment unauthloadingfragment, boolean flag)
    {
        unauthloadingfragment._inviteCodeCheckCompleted = flag;
        return flag;
    }

*/




/*
    static boolean access$402(UnauthLoadingFragment unauthloadingfragment, boolean flag)
    {
        unauthloadingfragment._isPinvitational = flag;
        return flag;
    }

*/


/*
    static boolean access$502(UnauthLoadingFragment unauthloadingfragment, boolean flag)
    {
        unauthloadingfragment._hasInvalidInviteCode = flag;
        return flag;
    }

*/

    private class _cls1
        implements Runnable
    {

        final UnauthLoadingFragment this$0;

        public void run()
        {
            _expCheckCompleted = _inviteCodeCheckCompleted = true;
            goToNextStep();
        }

        _cls1()
        {
            this$0 = UnauthLoadingFragment.this;
            super();
        }
    }


    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final UnauthLoadingFragment this$0;

        public void onEventMainThread(com.pinterest.api.remote.AccountApi.InviteCodeValidationResult invitecodevalidationresult)
        {
            boolean flag = true;
            if (_nextStepCompleted.get() || _inviteCodeCheckCompleted)
            {
                return;
            }
            _inviteCodeCheckCompleted = true;
            UnauthLoadingFragment unauthloadingfragment = UnauthLoadingFragment.this;
            if (invitecodevalidationresult.a())
            {
                flag = false;
            }
            unauthloadingfragment._hasInvalidInviteCode = flag;
            goToNextStep();
        }

        public void onEventMainThread(com.pinterest.experiment.Experiments.ExperimentsLoaded experimentsloaded)
        {
            if (_nextStepCompleted.get() || _expCheckCompleted)
            {
                return;
            }
            _expCheckCompleted = true;
            if (experimentsloaded.a)
            {
                Experiments.a("pinvitational_philippines");
                _isPinvitational = Experiments.g();
            }
            goToNextStep();
        }

        _cls2()
        {
            this$0 = UnauthLoadingFragment.this;
            super();
        }
    }

}
