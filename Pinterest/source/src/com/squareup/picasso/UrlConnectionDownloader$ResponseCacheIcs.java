// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.http.HttpResponseCache;
import java.io.IOException;

// Referenced classes of package com.squareup.picasso:
//            Utils

class 
{

    static Object a(Context context)
    {
        java.io.File file = Utils.b(context);
        HttpResponseCache httpresponsecache = HttpResponseCache.getInstalled();
        context = httpresponsecache;
        if (httpresponsecache == null)
        {
            context = HttpResponseCache.install(file, Utils.a(file));
        }
        return context;
    }

    static void a(Object obj)
    {
        try
        {
            ((HttpResponseCache)obj).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }
}
