// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            ViewPropertyAnimatorListener

class ViewPropertyAnimatorCompatJB
{

    ViewPropertyAnimatorCompatJB()
    {
    }

    public static void setListener(final View view, final ViewPropertyAnimatorListener listener)
    {
        if (listener != null)
        {
            view.animate().setListener(new _cls1());
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }

    public static void withEndAction(View view, Runnable runnable)
    {
        view.animate().withEndAction(runnable);
    }

    public static void withLayer(View view)
    {
        view.animate().withLayer();
    }

    public static void withStartAction(View view, Runnable runnable)
    {
        view.animate().withStartAction(runnable);
    }

    private class _cls1 extends AnimatorListenerAdapter
    {

        final ViewPropertyAnimatorListener val$listener;
        final View val$view;

        public final void onAnimationCancel(Animator animator)
        {
            listener.onAnimationCancel(view);
        }

        public final void onAnimationEnd(Animator animator)
        {
            listener.onAnimationEnd(view);
        }

        public final void onAnimationStart(Animator animator)
        {
            listener.onAnimationStart(view);
        }

        _cls1()
        {
            listener = viewpropertyanimatorlistener;
            view = view1;
            super();
        }
    }

}
