// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public final class CacheStrategy
{

    public final Request a;
    public final Response b;

    private CacheStrategy(Request request, Response response)
    {
        a = request;
        b = response;
    }

    CacheStrategy(Request request, Response response, byte byte0)
    {
        this(request, response);
    }

    public static boolean a(Response response, Request request)
    {
        int i = response.c();
        if (i == 200 || i == 203 || i == 300 || i == 301 || i == 410)
        {
            response = response.m();
            if ((request.a("Authorization") == null || response.e() || response.f() || response.d() != -1) && !response.b())
            {
                return true;
            }
        }
        return false;
    }
}
