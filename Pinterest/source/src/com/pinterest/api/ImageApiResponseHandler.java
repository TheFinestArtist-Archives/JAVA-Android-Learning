// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import android.graphics.Bitmap;
import com.android.volley.VolleyError;

public class ImageApiResponseHandler
    implements com.android.volley.Response.ErrorListener, com.android.volley.Response.Listener
{

    protected String _baseUrl;
    protected String _method;

    public ImageApiResponseHandler()
    {
        _method = "GET";
    }

    public String getBaseUrl()
    {
        return _baseUrl;
    }

    public String getMethod()
    {
        return _method;
    }

    public void onErrorResponse(VolleyError volleyerror)
    {
    }

    public void onResponse(Bitmap bitmap)
    {
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((Bitmap)obj);
    }

    public void setBaseUrl(String s)
    {
        _baseUrl = s;
    }

    public void setMethod(String s)
    {
        _method = s;
    }
}
