// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            Headers, CacheControl, Request, Protocol, 
//            Handshake, ResponseBody

public final class Response
{

    private final Request a;
    private final Protocol b;
    private final int c;
    private final String d;
    private final Handshake e;
    private final Headers f;
    private final ResponseBody g;
    private Response h;
    private Response i;
    private final Response j;
    private volatile CacheControl k;

    private Response(Builder builder)
    {
        a = Builder.a(builder);
        b = Builder.b(builder);
        c = Builder.c(builder);
        d = Builder.d(builder);
        e = Builder.e(builder);
        f = Builder.f(builder).a();
        g = Builder.g(builder);
        h = Builder.h(builder);
        i = Builder.i(builder);
        j = Builder.j(builder);
    }

    Response(Builder builder, byte byte0)
    {
        this(builder);
    }

    static Request a(Response response)
    {
        return response.a;
    }

    static Protocol b(Response response)
    {
        return response.b;
    }

    static int c(Response response)
    {
        return response.c;
    }

    static String d(Response response)
    {
        return response.d;
    }

    static Handshake e(Response response)
    {
        return response.e;
    }

    static Headers f(Response response)
    {
        return response.f;
    }

    static ResponseBody g(Response response)
    {
        return response.g;
    }

    static Response h(Response response)
    {
        return response.h;
    }

    static Response i(Response response)
    {
        return response.i;
    }

    static Response j(Response response)
    {
        return response.j;
    }

    public final Request a()
    {
        return a;
    }

    public final String a(String s)
    {
        s = f.a(s);
        if (s != null)
        {
            return s;
        } else
        {
            return null;
        }
    }

    public final Protocol b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final String d()
    {
        return d;
    }

    public final Handshake e()
    {
        return e;
    }

    public final Headers f()
    {
        return f;
    }

    public final ResponseBody g()
    {
        return g;
    }

    public final Builder h()
    {
        return new Builder(this, (byte)0);
    }

    public final boolean i()
    {
        switch (c)
        {
        case 304: 
        case 305: 
        case 306: 
        default:
            return false;

        case 300: 
        case 301: 
        case 302: 
        case 303: 
        case 307: 
            return true;
        }
    }

    public final Response j()
    {
        return h;
    }

    public final Response k()
    {
        return i;
    }

    public final List l()
    {
        String s;
        if (c == 401)
        {
            s = "WWW-Authenticate";
        } else
        if (c == 407)
        {
            s = "Proxy-Authenticate";
        } else
        {
            return Collections.emptyList();
        }
        return OkHeaders.b(f, s);
    }

    public final CacheControl m()
    {
        CacheControl cachecontrol = k;
        if (cachecontrol != null)
        {
            return cachecontrol;
        } else
        {
            CacheControl cachecontrol1 = CacheControl.a(f);
            k = cachecontrol1;
            return cachecontrol1;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Response{protocol=")).append(b).append(", code=").append(c).append(", message=").append(d).append(", url=").append(a.c()).append('}').toString();
    }

    private class Builder
    {

        private Request a;
        private Protocol b;
        private int c;
        private String d;
        private Handshake e;
        private Headers.Builder f;
        private ResponseBody g;
        private Response h;
        private Response i;
        private Response j;

        static Request a(Builder builder)
        {
            return builder.a;
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

        static Protocol b(Builder builder)
        {
            return builder.b;
        }

        static int c(Builder builder)
        {
            return builder.c;
        }

        static String d(Builder builder)
        {
            return builder.d;
        }

        static Handshake e(Builder builder)
        {
            return builder.e;
        }

        static Headers.Builder f(Builder builder)
        {
            return builder.f;
        }

        static ResponseBody g(Builder builder)
        {
            return builder.g;
        }

        static Response h(Builder builder)
        {
            return builder.h;
        }

        static Response i(Builder builder)
        {
            return builder.i;
        }

        static Response j(Builder builder)
        {
            return builder.j;
        }

        public final Builder a(int i1)
        {
            c = i1;
            return this;
        }

        public final Builder a(Handshake handshake)
        {
            e = handshake;
            return this;
        }

        public final Builder a(Headers headers)
        {
            f = headers.b();
            return this;
        }

        public final Builder a(Protocol protocol)
        {
            b = protocol;
            return this;
        }

        public final Builder a(Request request)
        {
            a = request;
            return this;
        }

        public final Builder a(Response response)
        {
            if (response != null)
            {
                a("networkResponse", response);
            }
            h = response;
            return this;
        }

        public final Builder a(ResponseBody responsebody)
        {
            g = responsebody;
            return this;
        }

        public final Builder a(String s)
        {
            d = s;
            return this;
        }

        public final Builder a(String s, String s1)
        {
            f.b(s, s1);
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

        public final Builder b(Response response)
        {
            if (response != null)
            {
                a("cacheResponse", response);
            }
            i = response;
            return this;
        }

        public final Builder b(String s)
        {
            f.b(s);
            return this;
        }

        public final Builder b(String s, String s1)
        {
            f.a(s, s1);
            return this;
        }

        public final Builder c(Response response)
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

        public Builder()
        {
            c = -1;
            f = new Headers.Builder();
        }

        private Builder(Response response)
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

        Builder(Response response, byte byte0)
        {
            this(response);
        }
    }

}
