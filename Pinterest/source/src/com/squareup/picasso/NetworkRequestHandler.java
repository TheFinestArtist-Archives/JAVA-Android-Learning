// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Request, Downloader, Utils, 
//            Stats, MarkableInputStream

class NetworkRequestHandler extends RequestHandler
{

    private final Downloader a;
    private final Stats b;

    public NetworkRequestHandler(Downloader downloader, Stats stats)
    {
        a = downloader;
        b = stats;
    }

    final int a()
    {
        return 2;
    }

    final boolean a(NetworkInfo networkinfo)
    {
        return networkinfo == null || networkinfo.isConnected();
    }

    public final boolean a(Request request)
    {
        request = request.d.getScheme();
        return "http".equals(request) || "https".equals(request);
    }

    public final RequestHandler.Result b(Request request)
    {
        Picasso.LoadedFrom loadedfrom;
        Object obj1;
        Downloader.Response response = a.load(request.d, request.c);
        if (response == null)
        {
            return null;
        }
        if (response.c)
        {
            loadedfrom = Picasso.LoadedFrom.b;
        } else
        {
            loadedfrom = Picasso.LoadedFrom.c;
        }
        obj1 = response.b;
        if (obj1 != null)
        {
            return new RequestHandler.Result(((android.graphics.Bitmap) (obj1)), loadedfrom);
        }
        obj1 = response.a;
        if (obj1 == null)
        {
            return null;
        }
        if (response.d == 0L)
        {
            Utils.a(((java.io.InputStream) (obj1)));
            throw new IOException("Received response with 0 content-length header.");
        }
        if (loadedfrom == Picasso.LoadedFrom.c && response.d > 0L)
        {
            Stats stats = b;
            long l = response.d;
            stats.c.sendMessage(stats.c.obtainMessage(4, Long.valueOf(l)));
        }
        Object obj;
        java.io.InputStream inputstream;
        long l1;
        boolean flag;
        boolean flag1;
        inputstream = new MarkableInputStream(((java.io.InputStream) (obj1)));
        l1 = inputstream.a(0x10000);
        obj = d(request);
        flag = a(((android.graphics.BitmapFactory.Options) (obj)));
        flag1 = Utils.c(inputstream);
        inputstream.a(l1);
        if (!flag1) goto _L2; else goto _L1
_L1:
        inputstream = Utils.b(inputstream);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length, ((android.graphics.BitmapFactory.Options) (obj)));
        a(request.h, request.i, ((android.graphics.BitmapFactory.Options) (obj)), request);
        request = BitmapFactory.decodeByteArray(inputstream, 0, inputstream.length, ((android.graphics.BitmapFactory.Options) (obj)));
_L4:
        request = new RequestHandler.Result(request, loadedfrom);
        Utils.a(((java.io.InputStream) (obj1)));
        return request;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        BitmapFactory.decodeStream(inputstream, null, ((android.graphics.BitmapFactory.Options) (obj)));
        a(request.h, request.i, ((android.graphics.BitmapFactory.Options) (obj)), request);
        inputstream.a(l1);
        obj = BitmapFactory.decodeStream(inputstream, null, ((android.graphics.BitmapFactory.Options) (obj)));
        request = ((Request) (obj));
        if (obj != null) goto _L4; else goto _L3
_L3:
        throw new IOException("Failed to decode stream.");
        request;
        Utils.a(((java.io.InputStream) (obj1)));
        throw request;
    }

    final boolean b()
    {
        return true;
    }
}
