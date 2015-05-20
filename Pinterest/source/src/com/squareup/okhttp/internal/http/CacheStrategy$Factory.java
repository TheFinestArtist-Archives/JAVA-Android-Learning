// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpDate, HeaderParser, OkHeaders, CacheStrategy

public class j
{

    final long a;
    final Request b;
    final Response c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l;

    private static boolean a(Request request)
    {
        return request.a("If-Modified-Since") != null || request.a("If-None-Match") != null;
    }

    public final CacheStrategy a()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        Object obj = new CacheStrategy(b, null, (byte)0);
_L16:
        CacheStrategy cachestrategy = ((CacheStrategy) (obj));
        if (((CacheStrategy) (obj)).a != null)
        {
            cachestrategy = ((CacheStrategy) (obj));
            if (b.g().i())
            {
                cachestrategy = new CacheStrategy(null, null, (byte)0);
            }
        }
        return cachestrategy;
_L2:
        if (!b.h() || c.e() != null) goto _L4; else goto _L3
_L3:
        obj = new CacheStrategy(b, null, (byte)0);
          goto _L5
_L4:
        if (CacheStrategy.a(c, b)) goto _L7; else goto _L6
_L6:
        obj = new CacheStrategy(b, null, (byte)0);
          goto _L5
_L7:
        obj = b.g();
        if (!((CacheControl) (obj)).a() && !a(b)) goto _L9; else goto _L8
_L8:
        obj = new CacheStrategy(b, null, (byte)0);
          goto _L5
_L9:
        long l1;
        CacheControl cachecontrol;
        long l2;
        long l4;
        long l5;
        long l6;
        if (d != null)
        {
            l1 = Math.max(0L, j - d.getTime());
        } else
        {
            l1 = 0L;
        }
        l2 = l1;
        if (l != -1)
        {
            l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(l));
        }
        l6 = l2 + (j - i) + (a - j);
        cachecontrol = c.m();
        if (cachecontrol.c() == -1) goto _L11; else goto _L10
_L10:
        l1 = TimeUnit.SECONDS.toMillis(cachecontrol.c());
_L13:
        l2 = l1;
        if (((CacheControl) (obj)).c() != -1)
        {
            l2 = Math.min(l1, TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).c()));
        }
        l1 = 0L;
        if (((CacheControl) (obj)).h() != -1)
        {
            l1 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).h());
        }
        l5 = 0L;
        cachecontrol = c.m();
        l4 = l5;
        if (!cachecontrol.f())
        {
            l4 = l5;
            if (((CacheControl) (obj)).g() != -1)
            {
                l4 = TimeUnit.SECONDS.toMillis(((CacheControl) (obj)).g());
            }
        }
        if (cachecontrol.a() || l6 + l1 >= l4 + l2)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = c.h();
        if (l1 + l6 >= l2)
        {
            ((com.squareup.okhttp.ategy.Factory.c) (obj)).c("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if (l6 > 0x5265c00L)
        {
            boolean flag;
            long l3;
            if (c.m().c() == -1 && h == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                ((com.squareup.okhttp.ategy.Factory.h) (obj)).h("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
        }
        obj = new CacheStrategy(null, ((com.squareup.okhttp.ategy) (obj)).ategy(), (byte)0);
          goto _L5
_L11:
        if (h != null)
        {
            if (d != null)
            {
                l1 = d.getTime();
            } else
            {
                l1 = j;
            }
            l3 = h.getTime() - l1;
            l1 = l3;
            if (l3 <= 0L)
            {
                l1 = 0L;
            }
        } else
        if (f != null && c.a().a().getQuery() == null)
        {
            if (d != null)
            {
                l1 = d.getTime();
            } else
            {
                l1 = i;
            }
            l1 -= f.getTime();
            if (l1 > 0L)
            {
                l1 /= 10L;
            } else
            {
                l1 = 0L;
            }
        } else
        {
            l1 = 0L;
        }
        if (true) goto _L13; else goto _L12
_L12:
        obj = b.f();
        if (f == null) goto _L15; else goto _L14
_L14:
        ((com.squareup.okhttp.ategy.Factory.f) (obj)).f("If-Modified-Since", g);
_L17:
        if (k != null)
        {
            ((com.squareup.okhttp.ategy.Factory.k) (obj)).k("If-None-Match", k);
        }
        obj = ((com.squareup.okhttp.ategy.Factory.k) (obj)).k();
        if (a(((Request) (obj))))
        {
            obj = new CacheStrategy(((Request) (obj)), c, (byte)0);
        } else
        {
            obj = new CacheStrategy(((Request) (obj)), null, (byte)0);
        }
_L5:
        if (true) goto _L16; else goto _L15
_L15:
        if (d != null)
        {
            ((com.squareup.okhttp.ategy.Factory.d) (obj)).d("If-Modified-Since", e);
        }
          goto _L17
    }

    public (long l1, Request request, Response response)
    {
        l = -1;
        a = l1;
        b = request;
        c = response;
        if (response != null)
        {
            int i1 = 0;
            while (i1 < response.f().a()) 
            {
                request = response.f().a(i1);
                String s = response.f().b(i1);
                if ("Date".equalsIgnoreCase(request))
                {
                    d = HttpDate.a(s);
                    e = s;
                } else
                if ("Expires".equalsIgnoreCase(request))
                {
                    h = HttpDate.a(s);
                } else
                if ("Last-Modified".equalsIgnoreCase(request))
                {
                    f = HttpDate.a(s);
                    g = s;
                } else
                if ("ETag".equalsIgnoreCase(request))
                {
                    k = s;
                } else
                if ("Age".equalsIgnoreCase(request))
                {
                    l = HeaderParser.a(s);
                } else
                if (OkHeaders.b.equalsIgnoreCase(request))
                {
                    i = Long.parseLong(s);
                } else
                if (OkHeaders.c.equalsIgnoreCase(request))
                {
                    j = Long.parseLong(s);
                }
                i1++;
            }
        }
    }
}
