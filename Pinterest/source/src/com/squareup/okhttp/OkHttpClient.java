// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            Dispatcher, Cache, Protocol, ConnectionPool, 
//            Authenticator

public final class OkHttpClient
    implements Cloneable
{

    private static SSLSocketFactory a;
    private final RouteDatabase b = new RouteDatabase();
    private Dispatcher c;
    private Proxy d;
    private List e;
    private ProxySelector f;
    private CookieHandler g;
    private InternalCache h;
    private Cache i;
    private SocketFactory j;
    private SSLSocketFactory k;
    private HostnameVerifier l;
    private Authenticator m;
    private ConnectionPool n;
    private boolean o;
    private int p;
    private int q;
    private int r;

    public OkHttpClient()
    {
        o = true;
        c = new Dispatcher();
    }

    static RouteDatabase a(OkHttpClient okhttpclient)
    {
        return okhttpclient.b;
    }

    private SSLSocketFactory r()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = a;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj = SSLContext.getInstance("TLS");
        ((SSLContext) (obj)).init(null, null, null);
        a = ((SSLContext) (obj)).getSocketFactory();
        obj = a;
        this;
        JVM INSTR monitorexit ;
        return ((SSLSocketFactory) (obj));
        Object obj1;
        obj1;
        throw new AssertionError();
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final int a()
    {
        return p;
    }

    public final OkHttpClient a(Cache cache)
    {
        i = cache;
        if (cache != null)
        {
            cache = cache.a;
        } else
        {
            cache = null;
        }
        h = cache;
        return this;
    }

    public final OkHttpClient a(Proxy proxy)
    {
        d = proxy;
        return this;
    }

    public final OkHttpClient a(List list)
    {
        list = Util.a(list);
        if (!list.contains(Protocol.b))
        {
            throw new IllegalArgumentException((new StringBuilder("protocols doesn't contain http/1.1: ")).append(list).toString());
        }
        if (list.contains(null))
        {
            throw new IllegalArgumentException("protocols must not contain null");
        } else
        {
            e = Util.a(list);
            return this;
        }
    }

    public final OkHttpClient a(HostnameVerifier hostnameverifier)
    {
        l = hostnameverifier;
        return this;
    }

    public final OkHttpClient a(SSLSocketFactory sslsocketfactory)
    {
        k = sslsocketfactory;
        return this;
    }

    public final void a(long l1, TimeUnit timeunit)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        l1 = timeunit.toMillis(l1);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        } else
        {
            p = (int)l1;
            return;
        }
    }

    public final int b()
    {
        return q;
    }

    public final void b(long l1, TimeUnit timeunit)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        l1 = timeunit.toMillis(l1);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        } else
        {
            q = (int)l1;
            return;
        }
    }

    public final int c()
    {
        return r;
    }

    public final Object clone()
    {
        return q();
    }

    public final Proxy d()
    {
        return d;
    }

    public final ProxySelector e()
    {
        return f;
    }

    public final CookieHandler f()
    {
        return g;
    }

    final InternalCache g()
    {
        return h;
    }

    public final Cache h()
    {
        return i;
    }

    public final SocketFactory i()
    {
        return j;
    }

    public final SSLSocketFactory j()
    {
        return k;
    }

    public final HostnameVerifier k()
    {
        return l;
    }

    public final Authenticator l()
    {
        return m;
    }

    public final ConnectionPool m()
    {
        return n;
    }

    public final boolean n()
    {
        return o;
    }

    public final List o()
    {
        return e;
    }

    final OkHttpClient p()
    {
        OkHttpClient okhttpclient = q();
        if (okhttpclient.f == null)
        {
            okhttpclient.f = ProxySelector.getDefault();
        }
        if (okhttpclient.g == null)
        {
            okhttpclient.g = CookieHandler.getDefault();
        }
        if (okhttpclient.j == null)
        {
            okhttpclient.j = SocketFactory.getDefault();
        }
        if (okhttpclient.k == null)
        {
            okhttpclient.k = r();
        }
        if (okhttpclient.l == null)
        {
            okhttpclient.l = OkHostnameVerifier.a;
        }
        if (okhttpclient.m == null)
        {
            okhttpclient.m = AuthenticatorAdapter.a;
        }
        if (okhttpclient.n == null)
        {
            okhttpclient.n = ConnectionPool.a();
        }
        if (okhttpclient.e == null)
        {
            okhttpclient.e = Util.a(new Protocol[] {
                Protocol.d, Protocol.c, Protocol.b
            });
        }
        return okhttpclient;
    }

    public final OkHttpClient q()
    {
        OkHttpClient okhttpclient;
        try
        {
            okhttpclient = (OkHttpClient)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return okhttpclient;
    }

    static 
    {
        Internal.a = new _cls1();
    }

    private class _cls1 extends Internal
    {

        public final InternalCache a(OkHttpClient okhttpclient)
        {
            return okhttpclient.g();
        }

        public final Transport a(Connection connection, HttpEngine httpengine)
        {
            return connection.a(httpengine);
        }

        public final void a(Connection connection, int i1, int j1)
        {
            connection.a(i1, j1);
        }

        public final void a(Connection connection, int i1, int j1, int k1, Request request)
        {
            connection.a(i1, j1, k1, request);
        }

        public final void a(Connection connection, Protocol protocol)
        {
            connection.a(protocol);
        }

        public final void a(Connection connection, Object obj)
        {
            connection.b(obj);
        }

        public final void a(ConnectionPool connectionpool, Connection connection)
        {
            connectionpool.a(connection);
        }

        public final void a(Headers.Builder builder, String s)
        {
            builder.a(s);
        }

        public final boolean a(Connection connection)
        {
            return connection.b();
        }

        public final int b(Connection connection)
        {
            return connection.o();
        }

        public final RouteDatabase b(OkHttpClient okhttpclient)
        {
            return OkHttpClient.a(okhttpclient);
        }

        public final void b(Connection connection, HttpEngine httpengine)
        {
            connection.a(httpengine);
        }

        public final void b(ConnectionPool connectionpool, Connection connection)
        {
            connectionpool.b(connection);
        }

        public final Object c(Connection connection)
        {
            return connection.a();
        }

        public final boolean d(Connection connection)
        {
            return connection.c();
        }

        public final boolean e(Connection connection)
        {
            return connection.l();
        }

        public final boolean f(Connection connection)
        {
            return connection.g();
        }

        _cls1()
        {
        }
    }

}
