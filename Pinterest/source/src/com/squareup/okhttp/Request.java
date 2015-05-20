// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            Headers, CacheControl, RequestBody

public final class Request
{

    private final String a;
    private final String b;
    private final Headers c;
    private final RequestBody d;
    private final Object e;
    private volatile URL f;
    private volatile URI g;
    private volatile CacheControl h;

    private Request(Builder builder)
    {
        a = Builder.a(builder);
        b = Builder.b(builder);
        c = Builder.c(builder).a();
        d = Builder.d(builder);
        Object obj;
        if (Builder.e(builder) != null)
        {
            obj = Builder.e(builder);
        } else
        {
            obj = this;
        }
        e = obj;
        f = Builder.f(builder);
    }

    Request(Builder builder, byte byte0)
    {
        this(builder);
    }

    static String a(Request request)
    {
        return request.a;
    }

    static URL b(Request request)
    {
        return request.f;
    }

    static String c(Request request)
    {
        return request.b;
    }

    static RequestBody d(Request request)
    {
        return request.d;
    }

    static Object e(Request request)
    {
        return request.e;
    }

    static Headers f(Request request)
    {
        return request.c;
    }

    public final String a(String s)
    {
        return c.a(s);
    }

    public final URL a()
    {
        URL url;
        try
        {
            url = f;
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException((new StringBuilder("Malformed URL: ")).append(a).toString(), malformedurlexception);
        }
        if (url != null)
        {
            return url;
        }
        url = new URL(a);
        f = url;
        return url;
    }

    public final URI b()
    {
        URI uri;
        try
        {
            uri = g;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IOException(urisyntaxexception.getMessage());
        }
        if (uri != null)
        {
            return uri;
        }
        Platform.a();
        uri = Platform.a(f);
        g = uri;
        return uri;
    }

    public final List b(String s)
    {
        return c.c(s);
    }

    public final String c()
    {
        return a;
    }

    public final String d()
    {
        return b;
    }

    public final Headers e()
    {
        return c;
    }

    public final Builder f()
    {
        return new Builder(this, (byte)0);
    }

    public final CacheControl g()
    {
        CacheControl cachecontrol = h;
        if (cachecontrol != null)
        {
            return cachecontrol;
        } else
        {
            CacheControl cachecontrol1 = CacheControl.a(c);
            h = cachecontrol1;
            return cachecontrol1;
        }
    }

    public final boolean h()
    {
        return a().getProtocol().equals("https");
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Request{method=")).append(b).append(", url=").append(f).append(", tag=");
        Object obj;
        if (e != this)
        {
            obj = e;
        } else
        {
            obj = null;
        }
        return stringbuilder.append(obj).append('}').toString();
    }

    private class Builder
    {

        private String a;
        private URL b;
        private String c;
        private Headers.Builder d;
        private RequestBody e;
        private Object f;

        static String a(Builder builder)
        {
            return builder.a;
        }

        static String b(Builder builder)
        {
            return builder.c;
        }

        static Headers.Builder c(Builder builder)
        {
            return builder.d;
        }

        static RequestBody d(Builder builder)
        {
            return builder.e;
        }

        static Object e(Builder builder)
        {
            return builder.f;
        }

        static URL f(Builder builder)
        {
            return builder.b;
        }

        public final Builder a(Headers headers)
        {
            d = headers.b();
            return this;
        }

        public final Builder a(String s)
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

        public final Builder a(String s, String s1)
        {
            d.b(s, s1);
            return this;
        }

        public final Builder a(URL url)
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

        public final Builder b(String s)
        {
            d.b(s);
            return this;
        }

        public final Builder b(String s, String s1)
        {
            d.a(s, s1);
            return this;
        }

        public final Builder c(String s)
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

        public Builder()
        {
            c = "GET";
            d = new Headers.Builder();
        }

        private Builder(Request request)
        {
            a = Request.a(request);
            b = Request.b(request);
            c = Request.c(request);
            e = Request.d(request);
            f = Request.e(request);
            d = Request.f(request).b();
        }

        Builder(Request request, byte byte0)
        {
            this(request);
        }
    }

}
