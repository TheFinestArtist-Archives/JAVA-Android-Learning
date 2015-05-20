// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.squareup.picasso:
//            Downloader, Utils

public class UrlConnectionDownloader
    implements Downloader
{

    static volatile Object a;
    private static final Object b = new Object();
    private final Context c;

    public UrlConnectionDownloader(Context context)
    {
        c = context.getApplicationContext();
    }

    public Downloader.Response load(Uri uri, boolean flag)
    {
        Context context;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        context = c;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        synchronized (b)
        {
            if (a == null)
            {
                a = ResponseCacheIcs.a(context);
            }
        }
_L1:
        uri = (HttpURLConnection)(new URL(uri.toString())).openConnection();
        uri.setConnectTimeout(15000);
        uri.setReadTimeout(20000);
        uri.setUseCaches(true);
        if (flag)
        {
            uri.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int i = uri.getResponseCode();
        IOException ioexception;
        if (i >= 300)
        {
            uri.disconnect();
            throw new Downloader.ResponseException((new StringBuilder()).append(i).append(" ").append(uri.getResponseMessage()).toString());
        } else
        {
            long l = uri.getHeaderFieldInt("Content-Length", -1);
            flag = Utils.a(uri.getHeaderField("X-Android-Response-Source"));
            return new Downloader.Response(uri.getInputStream(), flag, l);
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
          goto _L1
    }

    public void shutdown()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && a != null)
        {
            ResponseCacheIcs.a(a);
        }
    }


    private class ResponseCacheIcs
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

}
