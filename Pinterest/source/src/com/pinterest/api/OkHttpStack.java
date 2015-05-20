// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.android.volley.toolbox.HurlStack;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.net.HttpURLConnection;
import java.net.URL;

public class OkHttpStack extends HurlStack
{

    private final OkUrlFactory a;

    public OkHttpStack()
    {
        this(new OkHttpClient());
    }

    private OkHttpStack(OkHttpClient okhttpclient)
    {
        a = new OkUrlFactory(okhttpclient);
    }

    protected HttpURLConnection createConnection(URL url)
    {
        return a.a(url);
    }
}
