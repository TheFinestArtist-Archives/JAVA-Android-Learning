// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;

// Referenced classes of package com.squareup.picasso:
//            ContentStreamRequestHandler, Request

class FileRequestHandler extends ContentStreamRequestHandler
{

    FileRequestHandler(Context context)
    {
        super(context);
    }

    public final boolean a(Request request)
    {
        return "file".equals(request.d.getScheme());
    }

    public final RequestHandler.Result b(Request request)
    {
        android.graphics.Bitmap bitmap;
        Picasso.LoadedFrom loadedfrom;
        bitmap = c(request);
        loadedfrom = Picasso.LoadedFrom.b;
        (new ExifInterface(request.d.getPath())).getAttributeInt("Orientation", 1);
        JVM INSTR tableswitch 3 8: default 68
    //                   3 90
    //                   4 68
    //                   5 68
    //                   6 83
    //                   7 68
    //                   8 98;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L4
_L1:
        int i = 0;
_L6:
        return new RequestHandler.Result(bitmap, loadedfrom, i);
_L3:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 270;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
