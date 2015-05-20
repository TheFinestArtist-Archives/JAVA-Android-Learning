// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.MyUser;
import com.pinterest.base.CrashReporting;
import com.pinterest.base.Events;
import com.pinterest.kit.tasks.BackgroundTask;

class a extends BackgroundTask
{

    final PinterestJsonObject a;
    final a b;

    public void onFinish()
    {
        super.onFinish();
        CrashReporting.updateUsername();
        com.pinterest.api.model.User user = MyUser.get();
        b.Success(user);
        Events.post(new com.pinterest.api.model.nSuccess(user));
        Events.post(new com.pinterest.api.model.nSuccess(user));
    }

    public void run()
    {
        MyUser.updateMe(a);
    }

    ( , PinterestJsonObject pinterestjsonobject)
    {
        b = ;
        a = pinterestjsonobject;
        super();
    }
}
