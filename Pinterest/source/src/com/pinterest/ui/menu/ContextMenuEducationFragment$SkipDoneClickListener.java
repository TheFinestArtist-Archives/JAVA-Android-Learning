// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.app.Activity;
import android.view.View;
import com.pinterest.analytics.Pinalytics;
import com.pinterest.experiment.LongPressEducation;
import com.pinterest.schemas.event.ComponentType;
import com.pinterest.schemas.event.ElementType;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuEducationFragment

class _isSkipped
    implements android.view.Listener
{

    private boolean _isSkipped;
    final ContextMenuEducationFragment this$0;

    public void onClick(View view)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            if (_isSkipped)
            {
                view = ElementType.CANCEL_BUTTON;
            } else
            {
                view = ElementType.DONE_BUTTON;
            }
            Pinalytics.a(view, ComponentType.EDUCATION);
            LongPressEducation.b();
            fragmentactivity.onBackPressed();
        }
    }

    public (boolean flag)
    {
        this$0 = ContextMenuEducationFragment.this;
        super();
        _isSkipped = flag;
    }
}
