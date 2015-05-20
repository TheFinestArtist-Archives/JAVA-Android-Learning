// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.menu;

import android.widget.TextView;
import com.pinterest.experiment.LongPressEducation;
import com.pinterest.ui.text.PButton;

// Referenced classes of package com.pinterest.ui.menu:
//            ContextMenuEducationFragment, ContextMenuEduCompletedEvent

class this._cls0 extends com.pinterest.base.._cls2
{

    final ContextMenuEducationFragment this$0;

    public void onEventMainThread(ContextMenuEduCompletedEvent contextmenueducompletedevent)
    {
        ContextMenuEducationFragment.access$000(ContextMenuEducationFragment.this).setVisibility(8);
        ContextMenuEducationFragment.access$100(ContextMenuEducationFragment.this).setVisibility(0);
        LongPressEducation.b();
    }

    ()
    {
        this$0 = ContextMenuEducationFragment.this;
        super();
    }
}
