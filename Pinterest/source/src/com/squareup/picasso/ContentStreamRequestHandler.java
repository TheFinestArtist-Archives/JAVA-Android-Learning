// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Request, Utils

class ContentStreamRequestHandler extends RequestHandler
{

    final Context a;

    ContentStreamRequestHandler(Context context)
    {
        a = context;
    }

    public boolean a(Request request)
    {
        return "content".equals(request.d.getScheme());
    }

    public RequestHandler.Result b(Request request)
    {
        return new RequestHandler.Result(c(request), Picasso.LoadedFrom.b);
    }

    protected final Bitmap c(Request request)
    {
        Object obj;
        android.graphics.BitmapFactory.Options options;
        ContentResolver contentresolver;
        obj = null;
        contentresolver = a.getContentResolver();
        options = d(request);
        if (!a(options))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        java.io.InputStream inputstream = contentresolver.openInputStream(request.d);
        obj = inputstream;
        BitmapFactory.decodeStream(inputstream, null, options);
        Utils.a(inputstream);
        a(request.h, request.i, options, request);
        request = contentresolver.openInputStream(request.d);
        obj = BitmapFactory.decodeStream(request, null, options);
        Utils.a(request);
        return ((Bitmap) (obj));
        request;
        Utils.a(((java.io.InputStream) (obj)));
        throw request;
        Exception exception;
        exception;
        Utils.a(request);
        throw exception;
    }
}
