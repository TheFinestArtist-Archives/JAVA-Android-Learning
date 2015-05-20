// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.api;

import com.android.volley.VolleyError;

public class ByteApiResponseHandler
    implements com.android.volley.Response.ErrorListener, com.android.volley.Response.Listener
{

    protected String a;
    protected String b;

    public ByteApiResponseHandler()
    {
        b = "GET";
    }

    public void a()
    {
    }

    public final void a(String s)
    {
        a = s;
    }

    public void a(byte abyte0[])
    {
    }

    public final void b(String s)
    {
        b = s;
    }

    public void onErrorResponse(VolleyError volleyerror)
    {
    }

    public void onResponse(Object obj)
    {
        a((byte[])obj);
    }
}
