// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import javax.net.ssl.SSLHandshakeException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            OkHeaders, RouteSelector, RetryableSink, CacheStrategy, 
//            Transport, HttpMethod

public final class HttpEngine
{

    private static final ResponseBody d = new _cls1();
    final OkHttpClient a;
    long b;
    public final boolean c;
    private Connection e;
    private RouteSelector f;
    private Route g;
    private final Response h;
    private Transport i;
    private boolean j;
    private final Request k;
    private Request l;
    private Response m;
    private Response n;
    private Response o;
    private Sink p;
    private BufferedSink q;
    private Source r;
    private BufferedSource s;
    private InputStream t;
    private CacheRequest u;
    private CacheStrategy v;

    public HttpEngine(OkHttpClient okhttpclient, Request request, boolean flag, Connection connection, RouteSelector routeselector, RetryableSink retryablesink, Response response)
    {
        b = -1L;
        a = okhttpclient;
        k = request;
        c = flag;
        e = connection;
        f = routeselector;
        p = retryablesink;
        h = response;
        if (connection != null)
        {
            Internal.a.b(connection, this);
            g = connection.d();
            return;
        } else
        {
            g = null;
            return;
        }
    }

    private static Headers a(Headers headers, Headers headers1)
    {
        boolean flag = false;
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        int i1 = 0;
        int j1;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= headers.a())
            {
                break;
            }
            String s1 = headers.a(i1);
            String s2 = headers.b(i1);
            if ((!"Warning".equals(s1) || !s2.startsWith("1")) && (!OkHeaders.a(s1) || headers1.a(s1) == null))
            {
                builder.a(s1, s2);
            }
            i1++;
        } while (true);
        for (; j1 < headers1.a(); j1++)
        {
            headers = headers1.a(j1);
            if (OkHeaders.a(headers))
            {
                builder.a(headers, headers1.b(j1));
            }
        }

        return builder.a();
    }

    private static Response a(Response response)
    {
        Response response1 = response;
        if (response != null)
        {
            response1 = response;
            if (response.g() != null)
            {
                response1 = response.h().a(null).a();
            }
        }
        return response1;
    }

    public static String a(URL url)
    {
        if (Util.a(url) != Util.a(url.getProtocol()))
        {
            return (new StringBuilder()).append(url.getHost()).append(":").append(url.getPort()).toString();
        } else
        {
            return url.getHost();
        }
    }

    private void a(Source source)
    {
        r = source;
        if (j && "gzip".equalsIgnoreCase(o.a("Content-Encoding")))
        {
            o = o.h().b("Content-Encoding").b("Content-Length").a();
            s = Okio.a(new GzipSource(source));
            return;
        } else
        {
            s = Okio.a(source);
            return;
        }
    }

    public final HttpEngine a(IOException ioexception)
    {
        Sink sink;
label0:
        {
            boolean flag2 = true;
            sink = p;
            if (f != null && e != null)
            {
                f.a(e, ioexception);
            }
            boolean flag;
            if (sink == null || (sink instanceof RetryableSink))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((f != null || e != null) && (f == null || f.a()))
            {
                boolean flag1;
                boolean flag3;
                if ((ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag3 = ioexception instanceof ProtocolException;
                if (!flag1 && !flag3)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                if (flag1 && flag)
                {
                    break label0;
                }
            }
            return null;
        }
        ioexception = n();
        return new HttpEngine(a, k, c, ioexception, f, (RetryableSink)sink, h);
    }

    public final void a()
    {
        if (v == null)
        {
            if (i != null)
            {
                throw new IllegalStateException();
            }
            Object obj = k;
            Object obj2 = ((Request) (obj)).f();
            if (((Request) (obj)).a("Host") == null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj2)).a("Host", a(((Request) (obj)).a()));
            }
            if ((e == null || e.m() != Protocol.a) && ((Request) (obj)).a("Connection") == null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj2)).a("Connection", "Keep-Alive");
            }
            if (((Request) (obj)).a("Accept-Encoding") == null)
            {
                j = true;
                ((com.squareup.okhttp.Request.Builder) (obj2)).a("Accept-Encoding", "gzip");
            }
            Object obj4 = a.f();
            if (obj4 != null)
            {
                java.util.Map map = OkHeaders.a(((com.squareup.okhttp.Request.Builder) (obj2)).a().e(), null);
                OkHeaders.a(((com.squareup.okhttp.Request.Builder) (obj2)), ((CookieHandler) (obj4)).get(((Request) (obj)).b(), map));
            }
            obj4 = ((com.squareup.okhttp.Request.Builder) (obj2)).a();
            obj2 = Internal.a.a(a);
            if (obj2 != null)
            {
                obj = ((InternalCache) (obj2)).get(((Request) (obj4)));
            } else
            {
                obj = null;
            }
            v = (new CacheStrategy.Factory(System.currentTimeMillis(), ((Request) (obj4)), ((Response) (obj)))).a();
            l = v.a;
            m = v.b;
            if (obj2 != null)
            {
                ((InternalCache) (obj2)).trackResponse(v);
            }
            if (obj != null && m == null)
            {
                Util.a(((Response) (obj)).g());
            }
            if (l != null)
            {
                if (e == null)
                {
                    Request request = l;
                    if (e != null)
                    {
                        throw new IllegalStateException();
                    }
                    if (f == null)
                    {
                        Object obj5 = request.a().getHost();
                        if (obj5 == null || ((String) (obj5)).length() == 0)
                        {
                            throw new UnknownHostException(request.a().toString());
                        }
                        Object obj1;
                        Object obj3;
                        Connection connection;
                        int i1;
                        int j1;
                        int k1;
                        int l1;
                        if (request.h())
                        {
                            obj1 = a.j();
                            obj3 = a.k();
                        } else
                        {
                            obj3 = null;
                            obj1 = null;
                        }
                        f = new RouteSelector(new Address(((String) (obj5)), Util.a(request.a()), a.i(), ((javax.net.ssl.SSLSocketFactory) (obj1)), ((javax.net.ssl.HostnameVerifier) (obj3)), a.l(), a.d(), a.o()), request.b(), a.e(), a.m(), Dns.DEFAULT, Internal.a.b(a));
                    }
                    e = f.a(request.d());
                    Internal.a.b(e, this);
                    if (!Internal.a.d(e))
                    {
                        obj5 = Internal.a;
                        connection = e;
                        i1 = a.a();
                        j1 = a.b();
                        k1 = a.c();
                        if (!e.d().b())
                        {
                            obj1 = null;
                        } else
                        {
                            obj3 = request.a().getHost();
                            l1 = Util.a(request.a());
                            if (l1 == Util.a("https"))
                            {
                                obj1 = obj3;
                            } else
                            {
                                obj1 = (new StringBuilder()).append(((String) (obj3))).append(":").append(l1).toString();
                            }
                            obj1 = (new com.squareup.okhttp.Request.Builder()).a(new URL("https", ((String) (obj3)), l1, "/")).a("Host", ((String) (obj1))).a("Proxy-Connection", "Keep-Alive");
                            obj3 = request.a("User-Agent");
                            if (obj3 != null)
                            {
                                ((com.squareup.okhttp.Request.Builder) (obj1)).a("User-Agent", ((String) (obj3)));
                            }
                            obj3 = request.a("Proxy-Authorization");
                            if (obj3 != null)
                            {
                                ((com.squareup.okhttp.Request.Builder) (obj1)).a("Proxy-Authorization", ((String) (obj3)));
                            }
                            obj1 = ((com.squareup.okhttp.Request.Builder) (obj1)).a();
                        }
                        ((Internal) (obj5)).a(connection, i1, j1, k1, ((Request) (obj1)));
                        if (Internal.a.e(e))
                        {
                            Internal.a.b(a.m(), e);
                        }
                        Internal.a.b(a).b(e.d());
                    }
                    Internal.a.a(e, a.b(), a.c());
                    g = e.d();
                }
                if (Internal.a.c(e) != this && !Internal.a.e(e))
                {
                    throw new AssertionError();
                }
                i = Internal.a.a(e, this);
                if (c() && p == null)
                {
                    p = i.createRequestBody(((Request) (obj4)));
                    return;
                }
            }
            while (false) 
            {
                if (e != null)
                {
                    Internal.a.a(a.m(), e);
                    e = null;
                }
                if (m != null)
                {
                    o = m.h().a(k).c(a(h)).b(a(m)).a();
                } else
                {
                    o = (new com.squareup.okhttp.Response.Builder()).a(k).c(a(h)).a(Protocol.b).a(504).a("Unsatisfiable Request (only-if-cached)").a(d).a();
                }
                if (o.g() != null)
                {
                    a(((Source) (o.g().a())));
                    return;
                }
            }
        }
    }

    public final void a(Headers headers)
    {
        CookieHandler cookiehandler = a.f();
        if (cookiehandler != null)
        {
            cookiehandler.put(k.b(), OkHeaders.a(headers, null));
        }
    }

    public final void b()
    {
        if (b != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            b = System.currentTimeMillis();
            return;
        }
    }

    public final boolean b(URL url)
    {
        URL url1 = k.a();
        return url1.getHost().equals(url.getHost()) && Util.a(url1) == Util.a(url) && url1.getProtocol().equals(url.getProtocol());
    }

    final boolean c()
    {
        return HttpMethod.b(k.d()) && !Util.a().equals(p);
    }

    public final Sink d()
    {
        if (v == null)
        {
            throw new IllegalStateException();
        } else
        {
            return p;
        }
    }

    public final BufferedSink e()
    {
        Object obj = q;
        if (obj != null)
        {
            return ((BufferedSink) (obj));
        }
        obj = d();
        if (obj != null)
        {
            obj = Okio.a(((Sink) (obj)));
            q = ((BufferedSink) (obj));
            return ((BufferedSink) (obj));
        } else
        {
            return null;
        }
    }

    public final boolean f()
    {
        return o != null;
    }

    public final Request g()
    {
        return k;
    }

    public final Response h()
    {
        if (o == null)
        {
            throw new IllegalStateException();
        } else
        {
            return o;
        }
    }

    public final InputStream i()
    {
        InputStream inputstream = t;
        if (inputstream != null)
        {
            return inputstream;
        }
        if (o == null)
        {
            throw new IllegalStateException();
        } else
        {
            InputStream inputstream1 = Okio.a(s).g();
            t = inputstream1;
            return inputstream1;
        }
    }

    public final Connection j()
    {
        return e;
    }

    public final Route k()
    {
        return g;
    }

    public final void l()
    {
        if (i != null && e != null)
        {
            i.releaseConnectionOnIdle();
        }
        e = null;
    }

    public final void m()
    {
        if (i == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        i.disconnect(this);
        return;
        IOException ioexception;
        ioexception;
    }

    public final Connection n()
    {
        if (q == null) goto _L2; else goto _L1
_L1:
        Util.a(q);
_L4:
        if (s == null)
        {
            if (e != null)
            {
                Util.a(e.e());
            }
            e = null;
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (p != null)
        {
            Util.a(p);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Util.a(s);
        Util.a(t);
        if (i != null && e != null && !i.canReuseConnection())
        {
            Util.a(e.e());
            e = null;
            return null;
        }
        if (e != null && !Internal.a.a(e))
        {
            e = null;
        }
        Connection connection = e;
        e = null;
        return connection;
    }

    public final boolean o()
    {
        if (!k.d().equals("HEAD"))
        {
            int i1 = o.c();
            if ((i1 < 100 || i1 >= 200) && i1 != 204 && i1 != 304)
            {
                return true;
            }
            if (OkHeaders.a(n) != -1L || "chunked".equalsIgnoreCase(n.a("Transfer-Encoding")))
            {
                return true;
            }
        }
        return false;
    }

    public final void p()
    {
        if (o == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        boolean flag;
        if (l == null && m == null)
        {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (l == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (q != null && q.d().c() > 0L)
        {
            q.b();
        }
        if (b == -1L)
        {
            if (OkHeaders.a(l) == -1L && (p instanceof RetryableSink))
            {
                long l1 = ((RetryableSink)p).c();
                l = l.f().a("Content-Length", Long.toString(l1)).a();
            }
            i.writeRequestHeaders(l);
        }
        if (p != null)
        {
            if (q != null)
            {
                q.close();
            } else
            {
                p.close();
            }
            if ((p instanceof RetryableSink) && !Util.a().equals(p))
            {
                i.writeRequestBody((RetryableSink)p);
            }
        }
        i.flushRequest();
        n = i.readResponseHeaders().a(l).a(e.k()).a(OkHeaders.b, Long.toString(b)).a(OkHeaders.c, Long.toString(System.currentTimeMillis())).a();
        Internal.a.a(e, n.b());
        a(n.f());
        if (m == null)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        obj1 = m;
        obj = n;
        if (((Response) (obj)).c() != 304) goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        o = m.h().a(k).c(a(h)).a(a(m.f(), n.f())).b(a(m)).a(a(n)).a();
        i.emptyTransferStream();
        l();
        obj = Internal.a.a(a);
        ((InternalCache) (obj)).trackConditionalCacheHit();
        ((InternalCache) (obj)).update(m, a(o));
        if (m.g() != null)
        {
            a(m.g().a());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj1 = ((Response) (obj1)).f().b("Last-Modified");
        if (obj1 != null)
        {
            obj = ((Response) (obj)).f().b("Last-Modified");
            if (obj != null && ((Date) (obj)).getTime() < ((Date) (obj1)).getTime())
            {
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        Util.a(m.g());
        o = n.h().a(k).c(a(h)).b(a(m)).a(a(n)).a();
        if (!o())
        {
            r = i.getTransferStream(u);
            s = Okio.a(r);
            return;
        }
        InternalCache internalcache = Internal.a.a(a);
        if (internalcache != null)
        {
            if (!CacheStrategy.a(o, l))
            {
                if (HttpMethod.a(l.d()))
                {
                    try
                    {
                        internalcache.remove(l);
                    }
                    catch (IOException ioexception) { }
                }
            } else
            {
                u = internalcache.put(a(o));
            }
        }
        a(i.getTransferStream(u));
        return;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public final Request q()
    {
        if (o == null)
        {
            throw new IllegalStateException();
        }
        Object obj;
        if (g != null)
        {
            obj = g.a();
        } else
        {
            obj = a.d();
        }
        switch (o.c())
        {
        default:
            return null;

        case 407: 
            if (((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
            {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            // fall through

        case 401: 
            return OkHeaders.a(a.l(), o, ((Proxy) (obj)));

        case 307: 
            if (!k.d().equals("GET") && !k.d().equals("HEAD"))
            {
                return null;
            }
            // fall through

        case 300: 
        case 301: 
        case 302: 
        case 303: 
            obj = o.a("Location");
            break;
        }
        if (obj == null)
        {
            return null;
        }
        obj = new URL(k.a(), ((String) (obj)));
        if (!((URL) (obj)).getProtocol().equals("https") && !((URL) (obj)).getProtocol().equals("http"))
        {
            return null;
        }
        if (!((URL) (obj)).getProtocol().equals(k.a().getProtocol()) && !a.n())
        {
            return null;
        }
        com.squareup.okhttp.Request.Builder builder = k.f();
        if (HttpMethod.b(k.d()))
        {
            builder.c("GET");
            builder.b("Transfer-Encoding");
            builder.b("Content-Length");
            builder.b("Content-Type");
        }
        if (!b(((URL) (obj))))
        {
            builder.b("Authorization");
        }
        return builder.a(((URL) (obj))).a();
    }


    private class _cls1 extends ResponseBody
    {

        public final BufferedSource a()
        {
            return new Buffer();
        }

        _cls1()
        {
        }
    }

}
