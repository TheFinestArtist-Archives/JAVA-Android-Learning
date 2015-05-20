// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.task.education.view;

import android.animation.Animator;
import com.pinterest.activity.task.education.model.EducationStep;

// Referenced classes of package com.pinterest.activity.task.education.view:
//            EducationContainerView

class val.step extends com.pinterest.kit.utils.istener
{

    final EducationContainerView this$0;
    final EducationStep val$step;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        EducationContainerView.access$000(EducationContainerView.this, val$step);
    }

    I()
    {
        this$0 = final_educationcontainerview;
        val$step = EducationStep.this;
        super();
    }
}
