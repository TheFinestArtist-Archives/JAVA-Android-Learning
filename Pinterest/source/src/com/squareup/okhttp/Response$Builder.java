// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;


// Referenced classes of package com.squareup.okhttp:
//            Response, Headers, Request, Protocol, 
//            Handshake, ResponseBody

public class <init>
{

    private Request a;
    private Protocol b;
    private int c;
    private String d;
    private Handshake e;
    private j f;
    private ResponseBody g;
    private Response h;
    private Response i;
    private Response j;

    static Request a(<init> <init>1)
    {
        return <init>1.a;
    }

    private static void a(String s, Response response)
    {
        if (Response.g(response) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".body != null").toString());
        }
        if (Response.h(response) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".networkResponse != null").toString());
        }
        if (Response.i(response) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".cacheResponse != null").toString());
        }
        if (Response.j(response) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".priorResponse != null").toString());
        } else
        {
            return;
        }
    }

    static Protocol b(nit> nit>)
    {
        return nit>.b;
    }

    static int c(b b1)
    {
        return b1.c;
    }

    static String d(c c1)
    {
        return c1.d;
    }

    static Handshake e(d d1)
    {
        return d1.e;
    }

    static e f(e e1)
    {
        return e1.f;
    }

    static ResponseBody g(f f1)
    {
        return f1.g;
    }

    static Response h(g g1)
    {
        return g1.h;
    }

    static Response i(h h1)
    {
        return h1.i;
    }

    static Response j(i k)
    {
        return k.j;
    }

    public final j a(int k)
    {
        c = k;
        return this;
    }

    public final c a(Handshake handshake)
    {
        e = handshake;
        return this;
    }

    public final e a(Headers headers)
    {
        f = headers.b();
        return this;
    }

    public final f a(Protocol protocol)
    {
        b = protocol;
        return this;
    }

    public final b a(Request request)
    {
        a = request;
        return this;
    }

    public final a a(Response response)
    {
        if (response != null)
        {
            a("networkResponse", response);
        }
        h = response;
        return this;
    }

    public final h a(ResponseBody responsebody)
    {
        g = responsebody;
        return this;
    }

    public final g a(String s)
    {
        d = s;
        return this;
    }

    public final d a(String s, String s1)
    {
        f.(s, s1);
        return this;
    }

    public final Response a()
    {
        if (a == null)
        {
            throw new IllegalStateException("request == null");
        }
        if (b == null)
        {
            throw new IllegalStateException("protocol == null");
        }
        if (c < 0)
        {
            throw new IllegalStateException((new StringBuilder("code < 0: ")).append(c).toString());
        } else
        {
            return new Response(this, (byte)0);
        }
    }

    public final c b(Response response)
    {
        if (response != null)
        {
            a("cacheResponse", response);
        }
        i = response;
        return this;
    }

    public final i b(String s)
    {
        f.(s);
        return this;
    }

    public final  b(String s, String s1)
    {
        f.(s, s1);
        return this;
    }

    public final  c(Response response)
    {
        if (response != null && Response.g(response) != null)
        {
            throw new IllegalArgumentException("priorResponse.body != null");
        } else
        {
            j = response;
            return this;
        }
    }

    public ()
    {
        c = -1;
        f = new init>();
    }

    private init>(Response response)
    {
        c = -1;
        a = Response.a(response);
        b = Response.b(response);
        c = Response.c(response);
        d = Response.d(response);
        e = Response.e(response);
        f = Response.f(response).b();
        g = Response.g(response);
        h = Response.h(response);
        i = Response.i(response);
        j = Response.j(response);
    }

    j(Response response, byte byte0)
    {
        this(response);
    }
}
