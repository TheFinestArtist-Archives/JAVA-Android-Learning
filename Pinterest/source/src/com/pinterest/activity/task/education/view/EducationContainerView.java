// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.education.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.pinterest.activity.home.events.PageChangedEvent;
import com.pinterest.activity.task.activity.MainActivity;
import com.pinterest.activity.task.education.event.EducationEvent;
import com.pinterest.activity.task.education.model.Education;
import com.pinterest.activity.task.education.model.EducationBackground;
import com.pinterest.activity.task.education.model.EducationButton;
import com.pinterest.activity.task.education.model.EducationForeground;
import com.pinterest.activity.task.education.model.EducationPulse;
import com.pinterest.activity.task.education.model.EducationStep;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.api.remote.ExperiencesApi;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.education.EducationHelper;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.kit.log.PLog;
import com.pinterest.schemas.experiences.ClientDestination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.pinterest.activity.task.education.view:
//            EducationTriggerView, EducationFlyoutView, EducationBackgroundView, EducationCardView, 
//            EducationPulseView

public class EducationContainerView extends RelativeLayout
{

    private EducationBackgroundView _background;
    private EducationCardView _currentCard;
    private Education _currentEducation;
    private int _currentStep;
    private List _currentSteps;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private EducationFlyoutView _flyout;
    private FrameLayout _foreground;
    private BaseFragment _initFragment;
    private boolean _isActive;
    private boolean _isExpectingPageChange;
    private EducationPulseView _pulse;
    private EducationTriggerView _trigger;

    public EducationContainerView(Context context)
    {
        this(context, null);
    }

    public EducationContainerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public EducationContainerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        _eventsSubscriber = new _cls5();
        init();
    }

    private void dismiss()
    {
        dismissUi();
        _currentEducation.getExperienceValue().c();
        Experiences.c(_currentEducation.getPid());
    }

    private void dismissUi()
    {
        hideContent();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/task/model/Navigation, com/pinterest/activity/home/events/PageChangedEvent, com/pinterest/activity/task/view/MainViewPager$PageChangedEvent
        });
        _trigger.hide(null);
        _flyout.hide(null);
    }

    private void handleNext()
    {
        _isExpectingPageChange = true;
        final EducationStep step = (EducationStep)_currentSteps.get(_currentStep);
        Object obj;
        int i;
        if (step != null)
        {
            obj = step.getForeground();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((EducationForeground) (obj)).getForward();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            i = ((EducationButton) (obj)).getDestination();
        } else
        {
            i = 0;
        }
        if (step != null)
        {
            obj = step.getBackground();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((EducationBackground) (obj)).getPulse();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            obj = ((EducationPulse) (obj)).getAnchor();
        } else
        {
            obj = null;
        }
        if (i != 0 && obj != null)
        {
            _background.setDefault(new _cls1());
            _currentCard.showSuccess(null);
            return;
        }
        if (i != 0)
        {
            _background.setDefault(new _cls2());
            return;
        }
        if (obj != null)
        {
            _currentCard.showSuccess(new _cls3());
            return;
        } else
        {
            showNextStep();
            return;
        }
    }

    private void handleStart(Education education, EducationEvent educationevent)
    {
        if (!education.isEmpty() && !_isActive)
        {
            if (education.isFlyout() && !education.isTriggered())
            {
                _trigger.hide(null);
                _flyout.setEvent(educationevent);
                _flyout.show();
                EducationHelper.a();
                Events.register(_eventsSubscriber, com/pinterest/activity/task/model/Navigation, new Class[] {
                    com/pinterest/activity/home/events/PageChangedEvent, com/pinterest/activity/task/view/MainViewPager$PageChangedEvent
                });
                return;
            }
            if (education.isAutomatic() || education.isTriggered())
            {
                _isActive = true;
                setEducation(education, educationevent);
                Events.register(_eventsSubscriber, com/pinterest/activity/task/model/Navigation, new Class[] {
                    com/pinterest/activity/home/events/PageChangedEvent, com/pinterest/activity/task/view/MainViewPager$PageChangedEvent
                });
                return;
            }
            if (education.getSteps().size() > 0)
            {
                _trigger.setEvent(educationevent);
                _trigger.show(null);
                Events.register(_eventsSubscriber, com/pinterest/activity/task/model/Navigation, new Class[] {
                    com/pinterest/activity/home/events/PageChangedEvent, com/pinterest/activity/task/view/MainViewPager$PageChangedEvent
                });
                return;
            }
        }
    }

    private void hideContent()
    {
        Device.resetToDefaultOrientation((Activity)getContext());
        _isActive = false;
        removeCardViews();
        removeBackgroundViews();
        _pulse.setPulse(null);
        _initFragment = null;
    }

    private void init()
    {
        _isActive = false;
        _isExpectingPageChange = false;
        Events.register(_eventsSubscriber, com/pinterest/activity/task/education/event/EducationEvent, new Class[0]);
        _background = new EducationBackgroundView(getContext());
        _background.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(_background);
        _foreground = new FrameLayout(getContext());
        _foreground.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(_foreground);
        _pulse = new EducationPulseView(getContext());
        addView(_pulse, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        _trigger = new EducationTriggerView(getContext());
        addView(_trigger, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        _flyout = new EducationFlyoutView(getContext());
        addView(_flyout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    private boolean isScrollingToTarget(EducationStep educationstep)
    {
        if (_currentStep != 0)
        {
            return false;
        }
        if (educationstep.getBackground() != null)
        {
            educationstep = educationstep.getBackground().getAnchor();
        } else
        {
            educationstep = null;
        }
        if (educationstep == null)
        {
            return false;
        }
        BaseFragment basefragment = ((MainActivity)getContext()).getActiveFragment();
        educationstep = EducationPulseView.getTargetView((MainActivity)getContext(), educationstep);
        if (basefragment == null || educationstep == null)
        {
            return false;
        }
        if (basefragment.getScrollPosition().equals(new Pair(Integer.valueOf((int)educationstep.getX()), Integer.valueOf((int)educationstep.getY()))))
        {
            return false;
        } else
        {
            PLog.a("Scroll to the anchor target %d, %d ", new Object[] {
                Float.valueOf(educationstep.getX()), Float.valueOf(educationstep.getY())
            });
            basefragment.scrollTo((int)educationstep.getX(), (int)educationstep.getY());
            _currentStep = _currentStep - 1;
            postDelayed(new _cls4(), 300L);
            return true;
        }
    }

    private void performAction(EducationStep educationstep)
    {
        if (educationstep.getForeground().getForward().getDestination() != ClientDestination.HOME_FEED.getValue())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        educationstep = (Activity)getContext();
        if (educationstep != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((educationstep = educationstep.findViewById(0x7f0b006b)) == null) goto _L1; else goto _L3
_L3:
        setClickable(true);
        educationstep.onKeyLongPress(4, new KeyEvent(0, 4));
        Events.register(_eventsSubscriber, com/pinterest/activity/task/view/MainViewPager$PageStateEvent, new Class[0]);
        return;
        showNextStep();
        return;
    }

    private void removeBackgroundViews()
    {
        _background.setSteps(new ArrayList());
    }

    private void removeCardViews()
    {
        _foreground.removeAllViews();
    }

    private void safeCompleteExperience(Education education)
    {
        if (education != null && education.getExperienceValue() != null)
        {
            education.getExperienceValue().b();
        }
    }

    private void show(EducationStep educationstep)
    {
        _background.showNextStep(_currentStep);
        _pulse.setPulse(educationstep.getBackground().getPulse());
        removeCardViews();
        if (educationstep != null)
        {
            _currentCard = new EducationCardView(getContext());
            _currentCard.setStep(educationstep);
            educationstep = _currentCard;
            boolean flag;
            if (_currentStep == _currentSteps.size() - 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            educationstep.setIsLastStep(flag);
            _foreground.addView(_currentCard);
        }
    }

    private void showNextStep()
    {
        _isExpectingPageChange = false;
        _currentStep = _currentStep + 1;
        if (_currentStep < _currentSteps.size())
        {
            EducationStep educationstep = (EducationStep)_currentSteps.get(_currentStep);
            if (isScrollingToTarget(educationstep))
            {
                return;
            }
            if (educationstep.shouldComplete())
            {
                safeCompleteExperience(_currentEducation);
            }
            show(educationstep);
            return;
        }
        if (_currentStep == _currentSteps.size() && !((EducationStep)_currentSteps.get(_currentStep - 1)).shouldComplete())
        {
            safeCompleteExperience(_currentEducation);
        }
        dismissUi();
    }

    public boolean isActive()
    {
        return _isActive;
    }

    protected void onDetachedFromWindow()
    {
        Events.unregister(_eventsSubscriber);
        super.onDetachedFromWindow();
    }

    public void setEducation(Education education, EducationEvent educationevent)
    {
        Device.lockToCurrentOrientation((Activity)getContext());
        BaseFragment basefragment;
        if (getContext() != null)
        {
            basefragment = ((MainActivity)getContext()).getActiveFragment();
        } else
        {
            basefragment = null;
        }
        _initFragment = basefragment;
        _currentStep = -1;
        _currentEducation = education;
        if (_currentEducation != null)
        {
            _currentSteps = _currentEducation.getSteps();
        } else
        {
            _currentSteps = Collections.emptyList();
        }
        _trigger.setEvent(educationevent);
        _trigger.hide(null);
        _background.setSteps(_currentSteps);
        if (_currentEducation == null)
        {
            return;
        } else
        {
            ExperiencesApi.b(_currentEducation.getExperienceValue().d);
            showNextStep();
            return;
        }
    }

    public void setFragmentManager(FragmentManager fragmentmanager)
    {
        _background.setFragmentManager(fragmentmanager);
    }

    public void suspend()
    {
        hideContent();
        _trigger.show(null);
    }










    private class _cls5 extends com.pinterest.base.Events.EventsSubscriber
    {

        final EducationContainerView this$0;

        public void onEventMainThread(PageChangedEvent pagechangedevent)
        {
            if (!_isExpectingPageChange)
            {
                _flyout.updateLocationState();
                dismissUi();
            }
        }

        public void onEventMainThread(EducationEvent educationevent)
        {
            switch (_cls6..SwitchMap.com.pinterest.activity.task.education.event.EducationEvent.Type[educationevent.getType().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                EducationHelper.a(educationevent.getEducation().getEid());
                handleStart(educationevent.getEducation(), educationevent);
                return;

            case 2: // '\002'
                handleNext();
                return;

            case 3: // '\003'
                dismiss();
                EducationHelper.a(null);
                return;

            case 4: // '\004'
                dismissUi();
                EducationHelper.a(null);
                return;

            case 5: // '\005'
                suspend();
                break;
            }
            EducationHelper.a(null);
        }

        public void onEventMainThread(Navigation navigation)
        {
            if (!_isExpectingPageChange)
            {
                _flyout.updateLocationState();
                dismissUi();
            }
        }

        public void onEventMainThread(com.pinterest.activity.task.view.MainViewPager.PageChangedEvent pagechangedevent)
        {
            if (!_isExpectingPageChange)
            {
                _flyout.updateLocationState();
                dismissUi();
            }
        }

        public void onEventMainThread(com.pinterest.activity.task.view.MainViewPager.PageStateEvent pagestateevent)
        {
            switch (pagestateevent.getState())
            {
            default:
                return;

            case 0: // '\0'
                setClickable(false);
                break;
            }
            Events.unregister(_eventsSubscriber, new Class[] {
                com/pinterest/activity/task/view/MainViewPager$PageStateEvent
            });
            showNextStep();
        }

        _cls5()
        {
            this$0 = EducationContainerView.this;
            super();
        }

        private class _cls6
        {

            static final int $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[];

            static 
            {
                $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type = new int[com.pinterest.activity.task.education.event.EducationEvent.Type.values().length];
                try
                {
                    $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[com.pinterest.activity.task.education.event.EducationEvent.Type.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[com.pinterest.activity.task.education.event.EducationEvent.Type.NEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[com.pinterest.activity.task.education.event.EducationEvent.Type.DISMISS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[com.pinterest.activity.task.education.event.EducationEvent.Type.DISMISS_UI.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$pinterest$activity$task$education$event$EducationEvent$Type[com.pinterest.activity.task.education.event.EducationEvent.Type.SUSPEND.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

    }


    private class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final EducationContainerView this$0;
        final EducationStep val$step;

        public void onAnimationEnd(Animator animator)
        {
            super.onAnimationEnd(animator);
            performAction(step);
        }

        _cls1()
        {
            this$0 = EducationContainerView.this;
            step = educationstep;
            super();
        }
    }


    private class _cls2 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final EducationContainerView this$0;
        final EducationStep val$step;

        public void onAnimationEnd(Animator animator)
        {
            super.onAnimationEnd(animator);
            performAction(step);
        }

        _cls2()
        {
            this$0 = EducationContainerView.this;
            step = educationstep;
            super();
        }
    }


    private class _cls3 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final EducationContainerView this$0;

        public void onAnimationEnd(Animator animator)
        {
            super.onAnimationEnd(animator);
            showNextStep();
        }

        _cls3()
        {
            this$0 = EducationContainerView.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final EducationContainerView this$0;

        public void run()
        {
            showNextStep();
        }

        _cls4()
        {
            this$0 = EducationContainerView.this;
            super();
        }
    }

}
