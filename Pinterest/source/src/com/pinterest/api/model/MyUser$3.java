// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.model;

import com.pinterest.kit.tasks.BackgroundResult;
import com.pinterest.kit.tasks.BackgroundTask;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pinterest.api.model:
//            MyUser

final class _interests extends BackgroundTask
{

    List _interests;
    final BackgroundResult val$handler;

    public final void onFinish()
    {
        val$handler.onFinish(_interests);
    }

    public final void run()
    {
        _interests = MyUser.getLastUsedInterestsBlocking();
    }

    dResult()
    {
        val$handler = backgroundresult;
        super();
        _interests = new ArrayList();
    }
}
