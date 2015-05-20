// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.nux.fragment.NUXInterestsPickerFragment;
import com.pinterest.activity.nux.fragment.NUXSocialPickerFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenFragment;
import com.pinterest.activity.nux.fragment.NUXStartScreenPinvitationalFragment;
import com.pinterest.activity.nux.view.NUXProgressIndicatorView;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.remote.ExperiencesApi;
import com.pinterest.api.remote.InterestsApi;
import com.pinterest.api.remote.MyUserApi;
import com.pinterest.base.Device;
import com.pinterest.base.Events;
import com.pinterest.base.StopWatch;
import com.pinterest.experience.ExperienceValue;
import com.pinterest.experience.Experiences;
import com.pinterest.experience.NuxDisplayData;
import com.pinterest.experience.NuxStep;
import com.pinterest.experiment.Experiments;
import com.pinterest.kit.activity.BaseActivity;
import com.pinterest.kit.utils.AnimationUtils;
import java.util.ArrayList;

public class NUXActivity extends BaseActivity
{

    private ArrayList _checkedInterest;
    private ArrayList _defaultBitmapList;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    NUXProgressIndicatorView _progressBar;
    FrameLayout _wrapper;

    public NUXActivity()
    {
        _eventsSubscriber = new _cls2();
    }

    public ArrayList getCheckedInterests()
    {
        return _checkedInterest;
    }

    public ArrayList getDefaultUserImages()
    {
        return _defaultBitmapList;
    }

    public NUXProgressIndicatorView getProgressBar()
    {
        return _progressBar;
    }

    public void onBackPressed()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(0x10000000);
        startActivity(intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030023);
        ButterKnife.a(this);
        Object obj = Experiences.a(Experiences.b);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        bundle = (NuxDisplayData)((ExperienceValue) (obj)).f;
        if (((NuxDisplayData) (bundle)).a == null || ((NuxDisplayData) (bundle)).a.isEmpty())
        {
            bundle = null;
        } else
        {
label0:
            {
                bundle = (NuxStep)((NuxDisplayData) (bundle)).a.get(0);
                if (bundle == null)
                {
                    break label0;
                }
                if (bundle.a())
                {
                    if (Experiments.g())
                    {
                        bundle = new NUXStartScreenPinvitationalFragment();
                    } else
                    {
                        bundle = new NUXStartScreenFragment();
                    }
                } else
                if (bundle.c())
                {
                    bundle = new NUXInterestsPickerFragment();
                } else
                {
                    if (!bundle.b())
                    {
                        break label0;
                    }
                    bundle = new NUXSocialPickerFragment();
                }
            }
        }
_L1:
        ExperiencesApi.b(((ExperienceValue) (obj)).d);
_L2:
        obj = bundle;
        if (bundle == null)
        {
            obj = new NUXStartScreenFragment();
        }
        _checkedInterest = new ArrayList();
        FragmentHelper.replaceFragment(this, ((android.support.v4.app.Fragment) (obj)), false, com.pinterest.activity.FragmentHelper.Animation.NONE);
        if (!Device.isTablet())
        {
            setRequestedOrientation(1);
        }
        _defaultBitmapList = new ArrayList(9);
        _defaultBitmapList.add(getResources().getDrawable(0x7f02019b));
        _defaultBitmapList.add(getResources().getDrawable(0x7f02019c));
        _defaultBitmapList.add(getResources().getDrawable(0x7f02019d));
        _defaultBitmapList.add(getResources().getDrawable(0x7f02019e));
        _defaultBitmapList.add(getResources().getDrawable(0x7f02019f));
        _defaultBitmapList.add(getResources().getDrawable(0x7f0201a0));
        _defaultBitmapList.add(getResources().getDrawable(0x7f0201a1));
        _defaultBitmapList.add(getResources().getDrawable(0x7f0201a2));
        _defaultBitmapList.add(getResources().getDrawable(0x7f0201a3));
        StopWatch.get().complete("login_email").complete("signup_email");
        return;
        bundle = null;
          goto _L1
        bundle = null;
          goto _L2
    }

    protected void onDestroy()
    {
        ButterKnife.a(this);
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        Events.unregister(_eventsSubscriber, new Class[] {
            com/pinterest/activity/nux/NUXActivity$NUXProgressChangeEvent
        });
    }

    protected void onResume()
    {
        super.onResume();
        Events.register(_eventsSubscriber, com/pinterest/activity/nux/NUXActivity$NUXProgressChangeEvent, new Class[0]);
    }

    public void setCheckedInterests(ArrayList arraylist)
    {
        _checkedInterest = arraylist;
    }

    public void setProgressVisibility(int i)
    {
        if (i == 0 && _progressBar.getVisibility() != 0)
        {
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                AnimationUtils.springAnimate(_progressBar, "translationY", com.pinterest.kit.application.Resources.dimension(0x7f0a00ab), 0.0F, 1.0F, 0.75F), AnimationUtils.springAnimate(_progressBar, "alpha", 0.5F, 1.0F, 1.0F, 0.75F)
            });
            _progressBar.setVisibility(0);
            animatorset.addListener(new _cls1());
            animatorset.start();
        } else
        if (i == 4 && _progressBar.getVisibility() != 4)
        {
            _wrapper.setPadding(0, 0, 0, 0);
            _progressBar.setVisibility(4);
            return;
        }
    }

    public void submitFollowUsers(boolean flag, ArrayList arraylist, com.pinterest.base.Social.Network network)
    {
        if (flag)
        {
            MyUserApi.a(network, new ApiResponseHandler(), getApiTag());
        } else
        if (arraylist != null && arraylist.size() > 0)
        {
            MyUserApi.a(arraylist, new ApiResponseHandler(), getApiTag());
            return;
        }
    }

    public void submitInterests(ArrayList arraylist)
    {
        if (arraylist != null && !arraylist.isEmpty())
        {
            InterestsApi.a(arraylist, new ApiResponseHandler(), getApiTag());
        }
    }

    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final NUXActivity this$0;

        public void onEventMainThread(NUXProgressChangeEvent nuxprogresschangeevent)
        {
            _progressBar.updateProgress(nuxprogresschangeevent);
        }

        _cls2()
        {
            this$0 = NUXActivity.this;
            super();
        }
    }


    private class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final NUXActivity this$0;

        public void onAnimationEnd(Animator animator)
        {
            _wrapper.setPadding(0, 0, 0, (int)com.pinterest.kit.application.Resources.dimension(0x7f0a00ab));
            super.onAnimationEnd(animator);
        }

        _cls1()
        {
            this$0 = NUXActivity.this;
            super();
        }
    }

}
