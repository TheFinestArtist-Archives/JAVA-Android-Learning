// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            FragmentTransitionCompat21, BackStackRecord, Fragment

class val.outFragment
    implements android.view.nPreDrawListener
{

    final BackStackRecord this$0;
    final Fragment val$inFragment;
    final boolean val$isBack;
    final Fragment val$outFragment;
    final View val$sceneRoot;
    final ArrayList val$sharedElementTargets;
    final Object val$sharedElementTransition;
    final ansitionState val$state;

    public boolean onPreDraw()
    {
        val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
        if (val$sharedElementTransition != null)
        {
            FragmentTransitionCompat21.removeTargets(val$sharedElementTransition, val$sharedElementTargets);
            val$sharedElementTargets.clear();
            ArrayMap arraymap = BackStackRecord.access$000(BackStackRecord.this, val$state, val$isBack, val$inFragment);
            if (arraymap.isEmpty())
            {
                val$sharedElementTargets.add(val$state.nonExistentView);
            } else
            {
                val$sharedElementTargets.addAll(arraymap.values());
            }
            FragmentTransitionCompat21.addTargets(val$sharedElementTransition, val$sharedElementTargets);
            BackStackRecord.access$100(BackStackRecord.this, arraymap, val$state);
            BackStackRecord.access$200(BackStackRecord.this, val$state, val$inFragment, val$outFragment, val$isBack, arraymap);
        }
        return true;
    }

    ansitionState()
    {
        this$0 = final_backstackrecord;
        val$sceneRoot = view;
        val$sharedElementTransition = obj;
        val$sharedElementTargets = arraylist;
        val$state = ansitionstate;
        val$isBack = flag;
        val$inFragment = fragment;
        val$outFragment = Fragment.this;
        super();
    }
}
