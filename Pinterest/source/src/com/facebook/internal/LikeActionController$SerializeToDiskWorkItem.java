// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;


// Referenced classes of package com.facebook.internal:
//            LikeActionController

class controllerJson
    implements Runnable
{

    private String cacheKey;
    private String controllerJson;

    public void run()
    {
        LikeActionController.access$2900(cacheKey, controllerJson);
    }

    (String s, String s1)
    {
        cacheKey = s;
        controllerJson = s1;
    }
}
