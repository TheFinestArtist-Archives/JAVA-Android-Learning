// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.animation.Animator;
import android.animation.AnimatorSet;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuView

class nimationListener extends com.pinterest.kit.utils.mationListener
{

    final ContextMenuView this$0;

    public void onAnimationEnd(Animator animator)
    {
        if (ContextMenuView.access$2700(ContextMenuView.this) != null)
        {
            ContextMenuView.access$2700(ContextMenuView.this).start();
        }
    }

    nimationListener()
    {
        this$0 = ContextMenuView.this;
        super();
    }
}
