// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.ui.ViewHelper;
import java.util.List;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModalStep, PinvitationalPinSummaryFragment, PinvitationalConfettiView, PinvitationalHomeFeedModal

public class PinvitationalHomeFeedModalFragment extends BaseFragment
{

    private static final int SHOW_ANIMATION_DURATION = 500;
    private static final int STEP_TO_COMPLETE_EXP = 0;
    private static Handler sHandler;
    protected PinvitationalConfettiView _bgContainer;
    protected Button _completeBtn;
    protected TextView _descTv;
    protected TextView _dismissTv;
    protected LinearLayout _fgContainer;
    private PinvitationalHomeFeedModal _modal;
    protected ViewGroup _pinSummaryContainer;
    private PinvitationalPinSummaryFragment _pinSummaryFragment;
    private PinvitationalHomeFeedModalStep _step;
    private int _stepIndex;
    private List _steps;
    protected TextView _titleTv;

    public PinvitationalHomeFeedModalFragment()
    {
    }

    public static Handler getHandler()
    {
        if (sHandler == null)
        {
            sHandler = new Handler(Looper.getMainLooper());
        }
        return sHandler;
    }

    private void goToNextStep()
    {
        _stepIndex = _stepIndex + 1;
        if (_stepIndex < _steps.size())
        {
            _step = (PinvitationalHomeFeedModalStep)_steps.get(_stepIndex);
            refreshStep();
            return;
        } else
        {
            FragmentHelper.removeFragment(getFragmentManager(), this);
            return;
        }
    }

    private void loadPinSummary()
    {
        _pinSummaryFragment = new PinvitationalPinSummaryFragment();
        _pinSummaryFragment.loadData();
        FragmentHelper.replaceFragment(getFragmentManager(), 0x7f0b018e, _pinSummaryFragment, false, com.pinterest.activity.FragmentHelper.Animation.FADE);
    }

    private void makeAllViews()
    {
        if (!TextUtils.isEmpty(_step.getTitleText()))
        {
            _titleTv.setText(_step.getTitleText());
            ViewHelper.setVisibility(_titleTv, true);
        } else
        {
            ViewHelper.setVisibility(_titleTv, false);
        }
        if (!TextUtils.isEmpty(_step.getDescriptionText()))
        {
            _descTv.setText(_step.getDescriptionText());
            ViewHelper.setVisibility(_descTv, true);
        } else
        {
            ViewHelper.setVisibility(_descTv, false);
        }
        if (_step.getPinSummaryCount() > 0)
        {
            loadPinSummary();
            ViewHelper.setVisibility(_pinSummaryContainer, true);
        } else
        {
            ViewHelper.setVisibility(_pinSummaryContainer, false);
        }
        if (!TextUtils.isEmpty(_step.getCompleteButtonText()))
        {
            _completeBtn.setText(_step.getCompleteButtonText());
            _completeBtn.setOnClickListener(new _cls2());
            ViewHelper.setVisibility(_completeBtn, true);
        } else
        {
            ViewHelper.setVisibility(_completeBtn, false);
        }
        if (!TextUtils.isEmpty(_step.getCompleteButtonText()))
        {
            _dismissTv.setText(_step.getDismissButtonText());
            _dismissTv.setOnClickListener(new _cls3());
            ViewHelper.setVisibility(_dismissTv, true);
            return;
        } else
        {
            ViewHelper.setVisibility(_dismissTv, false);
            return;
        }
    }

    private void refreshStep()
    {
        Object obj = ObjectAnimator.ofFloat(_fgContainer, "alpha", new float[] {
            0.0F
        });
        ((Animator) (obj)).setDuration(500L);
        ((Animator) (obj)).setInterpolator(new DecelerateInterpolator());
        final ObjectAnimator fgShowAnimator = ObjectAnimator.ofFloat(_fgContainer, "alpha", new float[] {
            1.0F
        });
        fgShowAnimator.setDuration(500L);
        fgShowAnimator.setInterpolator(new DecelerateInterpolator());
        fgShowAnimator = new _cls1();
        ((Animator) (obj)).addListener(fgShowAnimator);
        if (_stepIndex == 0)
        {
            _fgContainer.setAlpha(0.0F);
            fgShowAnimator.onAnimationEnd(((Animator) (obj)));
        } else
        {
            ((Animator) (obj)).start();
        }
        if (_step.hasBackgroundImage()) goto _L2; else goto _L1
_L1:
        _bgContainer.setAlpha(0.0F);
_L4:
        obj = _modal.getExperienceValue();
        AnalyticsApi.b(String.format("%s_%s_%d_step%d", new Object[] {
            "MODAL", ((ExperienceValue) (obj)).e, Integer.valueOf(((ExperienceValue) (obj)).b), Integer.valueOf(_stepIndex)
        }));
        return;
_L2:
        if (_stepIndex == 0 || !((PinvitationalHomeFeedModalStep)_steps.get(_stepIndex - 1)).hasBackgroundImage())
        {
            _bgContainer.playAnimation(getActivity().getWindow().getDecorView().getHeight());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setupAutoDismiss()
    {
        int i = _step.getDismissAfterSeconds() * 1000;
        if (i > 0)
        {
            _cls4 _lcls4 = new _cls4();
            getHandler().postDelayed(_lcls4, i);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f0300a4;
        _modal = (PinvitationalHomeFeedModal)_navigation.getExtra("modal");
        _stepIndex = 0;
        _steps = _modal.getSteps();
        if (_steps != null)
        {
            _step = (PinvitationalHomeFeedModalStep)_steps.get(_stepIndex);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        ButterKnife.a(this, view);
        if (_step != null)
        {
            refreshStep();
            _modal.viewed();
        }
    }








    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PinvitationalHomeFeedModalFragment this$0;

        public void onClick(View view)
        {
            if (!TextUtils.isEmpty(_step.getCompleteButtonUrl()))
            {
                getActivity().getSupportFragmentManager().popBackStack();
                Location.navigateUri(getActivity(), _step.getCompleteButtonUrl());
                view = _modal.getExperienceValue();
                AnalyticsApi.b(String.format("%s_%s_%d_step%d_complete_btn", new Object[] {
                    "MODAL", ((ExperienceValue) (view)).e, Integer.valueOf(((ExperienceValue) (view)).b), Integer.valueOf(_stepIndex)
                }));
                return;
            }
            if (_stepIndex == 0)
            {
                _modal.complete();
            }
            goToNextStep();
        }

        _cls2()
        {
            this$0 = PinvitationalHomeFeedModalFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final PinvitationalHomeFeedModalFragment this$0;

        public void onClick(View view)
        {
            _modal.dismiss();
            pressBackButton();
            view = _modal.getExperienceValue();
            AnalyticsApi.b(String.format("%s_%s_%d_step%d_dismiss_btn", new Object[] {
                "MODAL", ((ExperienceValue) (view)).e, Integer.valueOf(((ExperienceValue) (view)).b), Integer.valueOf(_stepIndex)
            }));
        }

        _cls3()
        {
            this$0 = PinvitationalHomeFeedModalFragment.this;
            super();
        }
    }


    private class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final PinvitationalHomeFeedModalFragment this$0;
        final Animator val$fgShowAnimator;

        public void onAnimationEnd(Animator animator)
        {
            super.onAnimationEnd(animator);
            makeAllViews();
            fgShowAnimator.start();
            setupAutoDismiss();
        }

        _cls1()
        {
            this$0 = PinvitationalHomeFeedModalFragment.this;
            fgShowAnimator = animator;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final PinvitationalHomeFeedModalFragment this$0;

        public void run()
        {
            goToNextStep();
        }

        _cls4()
        {
            this$0 = PinvitationalHomeFeedModalFragment.this;
            super();
        }
    }

}
