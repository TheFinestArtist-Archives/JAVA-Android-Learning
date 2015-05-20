// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Utils, Request

class AssetRequestHandler extends RequestHandler
{

    private static final int a = 22;
    private final AssetManager b;

    public AssetRequestHandler(Context context)
    {
        b = context.getAssets();
    }

    private Bitmap a(Request request, String s)
    {
        java.io.InputStream inputstream;
        android.graphics.BitmapFactory.Options options;
        inputstream = null;
        options = d(request);
        if (!a(options))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        java.io.InputStream inputstream1 = b.open(s);
        inputstream = inputstream1;
        BitmapFactory.decodeStream(inputstream1, null, options);
        Utils.a(inputstream1);
        a(request.h, request.i, options, request);
        request = b.open(s);
        s = BitmapFactory.decodeStream(request, null, options);
        Utils.a(request);
        return s;
        request;
        Utils.a(inputstream);
        throw request;
        s;
        Utils.a(request);
        throw s;
    }

    public final boolean a(Request request)
    {
        boolean flag1 = false;
        request = request.d;
        boolean flag = flag1;
        if ("file".equals(request.getScheme()))
        {
            flag = flag1;
            if (!request.getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(request.getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final RequestHandler.Result b(Request request)
    {
        return new RequestHandler.Result(a(request, request.d.toString().substring(a)), Picasso.LoadedFrom.b);
    }

}
