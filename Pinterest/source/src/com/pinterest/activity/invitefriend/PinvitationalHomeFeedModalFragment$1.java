// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.invitefriend;

import android.animation.Animator;

// Referenced classes of package com.pinterest.activity.invitefriend:
//            PinvitationalHomeFeedModalFragment

class val.fgShowAnimator extends com.pinterest.kit.utils.lFragment._cls1
{

    final PinvitationalHomeFeedModalFragment this$0;
    final Animator val$fgShowAnimator;

    public void onAnimationEnd(Animator animator)
    {
        super.imationEnd(animator);
        PinvitationalHomeFeedModalFragment.access$000(PinvitationalHomeFeedModalFragment.this);
        val$fgShowAnimator.start();
        PinvitationalHomeFeedModalFragment.access$100(PinvitationalHomeFeedModalFragment.this);
    }

    ()
    {
        this$0 = final_pinvitationalhomefeedmodalfragment;
        val$fgShowAnimator = Animator.this;
        super();
    }
}
