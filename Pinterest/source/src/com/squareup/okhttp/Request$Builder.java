// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.net.URL;

// Referenced classes of package com.squareup.okhttp:
//            Request, Headers, RequestBody

public class <init>
{

    private String a;
    private URL b;
    private String c;
    private e d;
    private RequestBody e;
    private Object f;

    static String a(<init> <init>1)
    {
        return <init>1.a;
    }

    static String b(a a1)
    {
        return a1.c;
    }

    static c c(c c1)
    {
        return c1.d;
    }

    static RequestBody d(d d1)
    {
        return d1.e;
    }

    static Object e(e e1)
    {
        return e1.f;
    }

    static URL f(f f1)
    {
        return f1.b;
    }

    public final b a(Headers headers)
    {
        d = headers.b();
        return this;
    }

    public final d a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("url == null");
        } else
        {
            a = s;
            return this;
        }
    }

    public final a a(String s, String s1)
    {
        d.b(s, s1);
        return this;
    }

    public final b a(URL url)
    {
        if (url == null)
        {
            throw new IllegalArgumentException("url == null");
        } else
        {
            b = url;
            a = url.toString();
            return this;
        }
    }

    public final Request a()
    {
        if (a == null)
        {
            throw new IllegalStateException("url == null");
        } else
        {
            return new Request(this, (byte)0);
        }
    }

    public final t> b(String s)
    {
        d.b(s);
        return this;
    }

    public final b b(String s, String s1)
    {
        d.a(s, s1);
        return this;
    }

    public final a c(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        } else
        {
            c = s;
            e = null;
            return this;
        }
    }

    public ()
    {
        c = "GET";
        d = new <init>();
    }

    private <init>(Request request)
    {
        a = Request.a(request);
        b = Request.b(request);
        c = Request.c(request);
        e = Request.d(request);
        f = Request.e(request);
        d = Request.f(request).b();
    }

    d(Request request, byte byte0)
    {
        this(request);
    }
}
