// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.unauth.fragment;

import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import butterknife.ButterKnife;
import com.pinterest.activity.DialogHelper;
import com.pinterest.activity.FragmentHelper;
import com.pinterest.activity.task.fragment.BaseFragment;
import com.pinterest.activity.unauth.UnauthHelper;
import com.pinterest.api.remote.AnalyticsApi;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Device;
import com.pinterest.base.GooglePlayServices;
import com.pinterest.kit.application.Resources;
import com.pinterest.kit.utils.ImageUtils;
import com.pinterest.kit.utils.LocaleUtils;
import com.pinterest.ui.ViewHelper;
import com.pinterest.ui.text.PTextView;

// Referenced classes of package com.pinterest.activity.unauth.fragment:
//            NewLoginFragment

public class InspiredWallFragment extends BaseFragment
{

    private static final int AXIS_X = 0;
    private static final int AXIS_Y = 1;
    private static final int BACKGROUND_FADE_DURATION = 1000;
    private static final int BUTTONS_FADEIN_DELAY = 1000;
    private static final int PINS_OFFSET = (int)Resources.dimension(0x7f0a00eb);
    private static final int STORY_OFFSET = (int)Resources.dimension(0x7f0a00ec);
    private static final int TITLE_FADE_DURATION = 800;
    View _continueBt;
    private int _currentStepIndex;
    View _emailBt;
    private ImageView _foregroundImageView;
    View _gplusBt;
    private Handler _handler;
    private ViewGroup _layout;
    View _normalSignupWrapper;
    private ObjectAnimator _shiftAnimator;
    View _signupWrapper;
    PTextView _titleTv;
    private final android.view.View.OnLongClickListener onLongClick = new _cls4();

    public InspiredWallFragment()
    {
        _currentStepIndex = 0;
    }

    private void animateStep(int i, final String previousIv, int j, int k, int l)
    {
        if (getActivity() != null && getView() != null) goto _L2; else goto _L1
_L1:
        _shiftAnimator.cancel();
_L5:
        return;
_L2:
        ImageView imageview;
        Object obj;
        imageview = new ImageView(getView().getContext());
        imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        imageview.setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
        obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
        if (l != 0) goto _L4; else goto _L3
_L3:
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(0, 0, -k, 0);
_L6:
        _layout.addView(imageview, 0, ((android.view.ViewGroup.LayoutParams) (obj)));
        setTitle(previousIv);
        if (_foregroundImageView != null)
        {
            previousIv = _foregroundImageView;
            obj = ObjectAnimator.ofFloat(previousIv, "alpha", new float[] {
                1.0F, 0.0F
            });
            ((ObjectAnimator) (obj)).setDuration(1000L);
            ((ObjectAnimator) (obj)).addListener(new _cls1());
            ((ObjectAnimator) (obj)).start();
        }
        _foregroundImageView = imageview;
        if (l == 0)
        {
            previousIv = "x";
        } else
        {
            previousIv = "y";
        }
        try
        {
            _shiftAnimator = ObjectAnimator.ofFloat(_foregroundImageView, previousIv, new float[] {
                0.0F, (float)(-k)
            });
            _shiftAnimator.setInterpolator(new LinearInterpolator());
            _shiftAnimator.setDuration(j);
            _shiftAnimator.start();
            previousIv = new _cls2();
            _handler.postDelayed(previousIv, j - 1000);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String previousIv)
        {
            CrashReporting.logHandledException(previousIv);
        }
        if (_foregroundImageView == null)
        {
            setTitle(getString(0x7f0e01a1));
            return;
        }
          goto _L5
_L4:
        i = -k;
        ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(0, 0, 0, i);
          goto _L6
    }

    private void init(View view)
    {
        _layout = (ViewGroup)view;
        _handler = new Handler();
        if (Device.getUserProfile(getActivity()))
        {
            showContinueButton();
        }
        _titleTv.setOnLongClickListener(onLongClick);
        if (LocaleUtils.isLanguageEn())
        {
            _titleTv.setTypefaceId(com.pinterest.kit.utils.FontUtils.TypefaceId.REGULAR);
        }
        ViewHelper.setVisibility(_gplusBt, GooglePlayServices.isAvailable());
        startAnimating();
    }

    private void requestNextStep()
    {
        if (getActivity() == null)
        {
            return;
        }
        _currentStepIndex;
        JVM INSTR tableswitch 0 3: default 44
    //                   0 55
    //                   1 78
    //                   2 102
    //                   3 126;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        _currentStepIndex = _currentStepIndex + 1;
        return;
_L2:
        animateStep(0x7f020171, getString(0x7f0e0293), 5000, STORY_OFFSET, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        animateStep(0x7f020170, getString(0x7f0e0294), 5000, STORY_OFFSET, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        animateStep(0x7f02016f, getString(0x7f0e0295), 5000, STORY_OFFSET, 0);
        continue; /* Loop/switch isn't completed */
_L5:
        animateStep(0x7f020173, getString(0x7f0e01a1), 20000, PINS_OFFSET, 1);
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void setTitle(final String text)
    {
        if (_titleTv.getText().length() > 0)
        {
            final ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(_titleTv, "alpha", new float[] {
                0.0F, 1.0F
            });
            fadeInAnimator.setDuration(800L);
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(_titleTv, "alpha", new float[] {
                1.0F, 0.0F
            });
            objectanimator.setDuration(800L);
            objectanimator.addListener(new _cls3());
            objectanimator.start();
            return;
        } else
        {
            _titleTv.setText(text);
            return;
        }
    }

    private void showContinueButton()
    {
        ViewHelper.setVisibility(_normalSignupWrapper, false);
        ViewHelper.setVisibility(_continueBt, true);
    }

    private void startAnimating()
    {
        _signupWrapper.setAlpha(0.0F);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(_signupWrapper, "alpha", new float[] {
            0.0F, 1.0F
        });
        objectanimator.setStartDelay(1000L);
        objectanimator.setDuration(600L);
        objectanimator.start();
        requestNextStep();
    }

    protected void onActivate()
    {
        super.onActivate();
        if (!Device.isTablet() && getActivity() != null)
        {
            getActivity().setRequestedOrientation(1);
        }
    }

    void onButtonClick(View view)
    {
        if (_emailBt == view)
        {
            DialogHelper.goEmailSignup();
            return;
        }
        if (_continueBt == view)
        {
            NewLoginFragment newloginfragment = new NewLoginFragment();
            FragmentHelper.replaceFragment(getActivity(), newloginfragment, true);
        }
        UnauthHelper.onClick(view, getActivity());
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2 && !Device.isTablet())
        {
            ViewHelper.setVisibility(_titleTv, false);
            return;
        } else
        {
            ViewHelper.setVisibility(_titleTv, true);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        _layoutId = 0x7f03008a;
    }

    protected void onDeactivate()
    {
        super.onDeactivate();
        if (!Device.isTablet() && getActivity() != null)
        {
            getActivity().setRequestedOrientation(-1);
        }
    }

    public void onDetach()
    {
        if (_shiftAnimator != null)
        {
            _shiftAnimator.cancel();
        }
        ImageUtils.recycleBitmap(_foregroundImageView);
        super.onDetach();
    }

    public void onStart()
    {
        super.onStart();
        AnalyticsApi.a("unauth_home");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ButterKnife.a(this, view);
        init(view);
    }




    private class _cls4
        implements android.view.View.OnLongClickListener
    {

        final InspiredWallFragment this$0;

        public boolean onLongClick(View view)
        {
            DeveloperHelper.a(getActivity());
            return true;
        }

        _cls4()
        {
            this$0 = InspiredWallFragment.this;
            super();
        }
    }


    private class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final InspiredWallFragment this$0;
        final ImageView val$previousIv;

        public void onAnimationEnd(Animator animator)
        {
            _layout.removeView(previousIv);
            ImageUtils.recycleBitmap(previousIv);
        }

        _cls1()
        {
            this$0 = InspiredWallFragment.this;
            previousIv = imageview;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final InspiredWallFragment this$0;

        public void run()
        {
            requestNextStep();
        }

        _cls2()
        {
            this$0 = InspiredWallFragment.this;
            super();
        }
    }


    private class _cls3 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final InspiredWallFragment this$0;
        final ObjectAnimator val$fadeInAnimator;
        final String val$text;

        public void onAnimationEnd(Animator animator)
        {
            _titleTv.setText(text);
            fadeInAnimator.start();
        }

        _cls3()
        {
            this$0 = InspiredWallFragment.this;
            text = s;
            fadeInAnimator = objectanimator;
            super();
        }
    }

}
