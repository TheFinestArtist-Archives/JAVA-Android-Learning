// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.toast.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.pinterest.activity.task.model.Navigation;
import com.pinterest.activity.task.toast.BaseToast;
import com.pinterest.base.Constants;
import com.pinterest.base.Events;
import com.pinterest.kit.utils.AnimationUtils;

public class ToastContainer extends FrameLayout
{

    private static int MIN_FLING_VELOCITY;
    private static int MIN_TOUCH_SLOP;
    private Navigation _currentNavigation;
    private com.pinterest.base.Events.EventsSubscriber _eventsSubscriber;
    private SparseArray _runnables;

    public ToastContainer(Context context)
    {
        this(context, null);
    }

    public ToastContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        _runnables = new SparseArray();
        _eventsSubscriber = new _cls2();
        init(context);
    }

    private void addDismissRunnable(View view)
    {
        if (view.getTag() instanceof BaseToast)
        {
            DismissToastRunnable dismisstoastrunnable = new DismissToastRunnable(view);
            postDelayed(dismisstoastrunnable, ((BaseToast)view.getTag()).getDuration());
            _runnables.put(view.getId(), dismisstoastrunnable);
        }
    }

    private static void completeToast(View view)
    {
        Object obj = view.getTag();
        if (obj instanceof BaseToast)
        {
            ((BaseToast)obj).onToastCompleted(view.getContext());
        }
    }

    private static boolean dismissToast(View view)
    {
        if (view.getTag() instanceof BaseToast)
        {
            view = (BaseToast)view.getTag();
            if (!view.isDismissed())
            {
                view.setDismissed(true);
                return true;
            }
        }
        return false;
    }

    private boolean hide(final View v)
    {
        while (v == null || v.getParent() == null || !dismissToast(v)) 
        {
            return false;
        }
        ObjectAnimator objectanimator = AnimationUtils.springAnimate(v, "translationY", 0, 300, 0.75F, 0.25F);
        objectanimator.setStartDelay(160L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(v, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator1.setDuration(400L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator1, objectanimator
        });
        animatorset.addListener(new _cls1());
        animatorset.start();
        return true;
    }

    private void init(Context context)
    {
        context = ViewConfiguration.get(context);
        MIN_FLING_VELOCITY = context.getScaledMinimumFlingVelocity();
        MIN_TOUCH_SLOP = context.getScaledTouchSlop();
        setPadding(Constants.MARGIN, Constants.MARGIN, Constants.MARGIN, Constants.MARGIN);
        setClipChildren(false);
        setClipToPadding(false);
    }

    private void removeRunnable(View view)
    {
        Runnable runnable = (Runnable)_runnables.get(view.getId());
        if (runnable != null)
        {
            removeCallbacks(runnable);
            _runnables.remove(view.getId());
        }
    }

    private void removeToastView(View view)
    {
        if (view != null)
        {
            removeView(view);
        }
    }

    public void addToast(BaseToast basetoast)
    {
        if (basetoast == null)
        {
            return;
        } else
        {
            View view = basetoast.getView(this);
            view.setTag(basetoast);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            layoutparams.gravity = basetoast.getGravity();
            view.setLayoutParams(layoutparams);
            view.setOnTouchListener(new ToastTouchListener());
            AnimationUtils.springAnimate(view, "translationY", 300, 0, 0.75F, 0.25F).start();
            addView(view);
            addDismissRunnable(view);
            return;
        }
    }

    public void dismiss(View view)
    {
        hide(view);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        Events.register(_eventsSubscriber, com/pinterest/activity/task/view/MainViewPager$PageChangedEvent, new Class[0]);
    }

    protected void onDetachedFromWindow()
    {
        Events.unregister(_eventsSubscriber);
        super.onDetachedFromWindow();
    }






/*
    static Navigation access$402(ToastContainer toastcontainer, Navigation navigation)
    {
        toastcontainer._currentNavigation = navigation;
        return navigation;
    }

*/






    private class _cls2 extends com.pinterest.base.Events.EventsSubscriber
    {

        final ToastContainer this$0;

        public void onEventMainThread(com.pinterest.activity.task.view.MainViewPager.PageChangedEvent pagechangedevent)
        {
            _currentNavigation = pagechangedevent.getNavigation();
            for (int i = 0; i < getChildCount(); i++)
            {
                pagechangedevent = getChildAt(i);
                if (hide(pagechangedevent))
                {
                    ToastContainer.completeToast(pagechangedevent);
                }
            }

        }

        _cls2()
        {
            this$0 = ToastContainer.this;
            super();
        }
    }


    private class DismissToastRunnable
        implements Runnable
    {

        final ToastContainer this$0;
        private View v;

        public void run()
        {
            if (hide(v))
            {
                ToastContainer.completeToast(v);
            }
            _runnables.delete(v.getId());
        }

        public DismissToastRunnable(View view)
        {
            this$0 = ToastContainer.this;
            super();
            v = view;
        }
    }


    private class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
    {

        final ToastContainer this$0;
        final View val$v;

        public void onAnimationCancel(Animator animator)
        {
            removeToastView(v);
        }

        public void onAnimationEnd(Animator animator)
        {
            removeToastView(v);
        }

        _cls1()
        {
            this$0 = ToastContainer.this;
            v = view;
            super();
        }
    }


    private class ToastTouchListener
        implements android.view.View.OnTouchListener
    {

        private VelocityTracker _velocityTracker;
        private float deltaX;
        private float downX;
        final ToastContainer this$0;

        public boolean onTouch(final View v, MotionEvent motionevent)
        {
            MotionEventCompat.getActionMasked(motionevent);
            JVM INSTR tableswitch 0 2: default 32
        //                       0 34
        //                       1 67
        //                       2 247;
               goto _L1 _L2 _L3 _L4
_L1:
            return false;
_L2:
            _velocityTracker = VelocityTracker.obtain();
            _velocityTracker.addMovement(motionevent);
            downX = motionevent.getRawX();
            removeRunnable(v);
            return false;
_L3:
            if (_velocityTracker != null)
            {
                _velocityTracker.addMovement(motionevent);
                _velocityTracker.computeCurrentVelocity(1000);
                float f = Math.abs(_velocityTracker.getXVelocity());
                deltaX = motionevent.getRawX() - downX;
                if (f >= (float)ToastContainer.MIN_FLING_VELOCITY)
                {
                    motionevent = ObjectAnimator.ofFloat(v, "translationX", new float[] {
                        v.getTranslationX(), Math.copySign(Device.getScreenWidth(), deltaX)
                    });
                    motionevent.setInterpolator(new AccelerateDecelerateInterpolator());
                    class _cls1 extends com.pinterest.kit.utils.AnimationUtils.AnimationListener
                    {

                        final ToastTouchListener this$1;
                        final View val$v;

                        public void onAnimationEnd(Animator animator)
                        {
                            ToastContainer.completeToast(v);
                            removeToastView(v);
                        }

                _cls1()
                {
                    this$1 = ToastTouchListener.this;
                    v = view;
                    super();
                }
                    }

                    motionevent.addListener(new _cls1());
                    motionevent.start();
                    ToastContainer.dismissToast(v);
                    return true;
                }
                if (Math.abs(deltaX) >= (float)ToastContainer.MIN_TOUCH_SLOP)
                {
                    AnimationUtils.springAnimate(v, "translationX", deltaX, 0.0F, 0.75F, 0.25F).start();
                    addDismissRunnable(v);
                    return true;
                } else
                {
                    _velocityTracker.recycle();
                    _velocityTracker = null;
                    return false;
                }
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (_velocityTracker != null)
            {
                _velocityTracker.addMovement(motionevent);
                deltaX = motionevent.getRawX() - downX;
                v.setTranslationX(deltaX);
                return true;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        ToastTouchListener()
        {
            this$0 = ToastContainer.this;
            super();
        }
    }

}
