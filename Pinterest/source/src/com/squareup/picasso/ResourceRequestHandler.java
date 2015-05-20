// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Request, Utils

class ResourceRequestHandler extends RequestHandler
{

    private final Context a;

    ResourceRequestHandler(Context context)
    {
        a = context;
    }

    public final boolean a(Request request)
    {
        if (request.e != 0)
        {
            return true;
        } else
        {
            return "android.resource".equals(request.d.getScheme());
        }
    }

    public final RequestHandler.Result b(Request request)
    {
        android.content.res.Resources resources = Utils.a(a, request);
        int i = Utils.a(resources, request);
        android.graphics.BitmapFactory.Options options = d(request);
        if (a(options))
        {
            BitmapFactory.decodeResource(resources, i, options);
            a(request.h, request.i, options, request);
        }
        return new RequestHandler.Result(BitmapFactory.decodeResource(resources, i, options), Picasso.LoadedFrom.b);
    }
}
