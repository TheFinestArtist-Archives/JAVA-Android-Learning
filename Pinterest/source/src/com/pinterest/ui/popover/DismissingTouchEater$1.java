// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.ui.popover;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.pinterest.ui.popover:
//            DismissingTouchEater

class this._cls0
    implements android.view.ouchEater._cls1
{

    final DismissingTouchEater this$0;

    public void onClick(View view)
    {
        ((Activity)view.getContext()).onBackPressed();
    }

    ()
    {
        this$0 = DismissingTouchEater.this;
        super();
    }
}
