// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.squareup.picasso:
//            Downloader, Utils

public class OkHttpDownloader
    implements Downloader
{

    private final OkUrlFactory a;

    public OkHttpDownloader(Context context)
    {
        this(Utils.b(context));
    }

    private OkHttpDownloader(OkHttpClient okhttpclient)
    {
        a = new OkUrlFactory(okhttpclient);
    }

    private OkHttpDownloader(File file)
    {
        this(file, Utils.a(file));
    }

    private OkHttpDownloader(File file, long l)
    {
        this(new OkHttpClient());
        try
        {
            a.a().a(new Cache(file, l));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
    }

    public Downloader.Response load(Uri uri, boolean flag)
    {
        HttpURLConnection httpurlconnection = a.a(new URL(uri.toString()));
        httpurlconnection.setConnectTimeout(15000);
        httpurlconnection.setReadTimeout(20000);
        httpurlconnection.setUseCaches(true);
        if (flag)
        {
            httpurlconnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int i = httpurlconnection.getResponseCode();
        if (i >= 300)
        {
            httpurlconnection.disconnect();
            throw new Downloader.ResponseException((new StringBuilder()).append(i).append(" ").append(httpurlconnection.getResponseMessage()).toString());
        }
        String s = httpurlconnection.getHeaderField("OkHttp-Response-Source");
        uri = s;
        if (s == null)
        {
            uri = httpurlconnection.getHeaderField("X-Android-Response-Source");
        }
        long l = httpurlconnection.getHeaderFieldInt("Content-Length", -1);
        flag = Utils.a(uri);
        return new Downloader.Response(httpurlconnection.getInputStream(), flag, l);
    }

    public void shutdown()
    {
        Cache cache;
        cache = a.a().h();
        if (cache == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        cache.a();
        return;
        IOException ioexception;
        ioexception;
    }
}
