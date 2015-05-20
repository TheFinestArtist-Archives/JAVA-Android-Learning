// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.ApiResponse;
import com.pinterest.api.PinterestJsonObject;
import com.pinterest.experience.Experiences;
import com.pinterest.kit.tasks.BackgroundTask;

class a extends BackgroundTask
{

    final ApiResponse a;
    final a b;

    public void onFinish()
    {
        b.Success();
    }

    public void run()
    {
        PinterestJsonObject pinterestjsonobject = (PinterestJsonObject)a.getData();
        if (pinterestjsonobject != null)
        {
            Experiences.c().a(pinterestjsonobject.a());
        }
    }

    I(I i, ApiResponse apiresponse)
    {
        b = i;
        a = apiresponse;
        super();
    }
}
