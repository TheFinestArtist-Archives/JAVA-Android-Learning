// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.nux;

import com.pinterest.activity.nux.view.NUXProgressIndicatorView;

// Referenced classes of package com.pinterest.activity.nux:
//            NUXActivity

class r extends com.pinterest.base.ubscriber
{

    final NUXActivity this$0;

    public void onEventMainThread(XProgressChangeEvent xprogresschangeevent)
    {
        _progressBar.updateProgress(xprogresschangeevent);
    }

    XProgressChangeEvent()
    {
        this$0 = NUXActivity.this;
        super();
    }
}
