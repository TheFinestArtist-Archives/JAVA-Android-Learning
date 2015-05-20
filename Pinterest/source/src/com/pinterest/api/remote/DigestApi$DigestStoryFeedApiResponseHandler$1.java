// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api.remote;

import com.pinterest.api.PinterestJsonObject;
import com.pinterest.api.model.DigestFeed;
import com.pinterest.api.model.Feed;
import com.pinterest.base.Events;
import com.pinterest.kit.data.DiskCache;
import com.pinterest.kit.tasks.BackgroundTask;

class a extends BackgroundTask
{

    final PinterestJsonObject a;
    final a b;
    private Feed c;

    public void onFinish()
    {
        super.onFinish();
        b.Success(c);
        Events.post(new c());
    }

    public void run()
    {
        c = new DigestFeed(a, cess._mth000(b));
        DiskCache.setJsonObject("MY_DIGEST_FEED", a);
    }

    ( , PinterestJsonObject pinterestjsonobject)
    {
        b = ;
        a = pinterestjsonobject;
        super();
    }
}
