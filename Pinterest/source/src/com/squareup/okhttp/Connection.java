// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            Protocol, Request, Response, Route, 
//            Address, Handshake, ConnectionPool

public final class Connection
{

    private final ConnectionPool a;
    private final Route b;
    private Socket c;
    private boolean d;
    private HttpConnection e;
    private SpdyConnection f;
    private Protocol g;
    private long h;
    private Handshake i;
    private int j;
    private Object k;

    public Connection(ConnectionPool connectionpool, Route route)
    {
        d = false;
        g = Protocol.b;
        a = connectionpool;
        b = route;
    }

    private void a(Request request, int i1, int j1)
    {
        HttpConnection httpconnection = new HttpConnection(a, this, c);
        httpconnection.a(i1, j1);
        URL url = request.a();
        String s = (new StringBuilder("CONNECT ")).append(url.getHost()).append(":").append(url.getPort()).append(" HTTP/1.1").toString();
        do
        {
            httpconnection.a(request.e(), s);
            httpconnection.d();
            request = httpconnection.g().a(request).a();
            httpconnection.i();
            Request request1;
            switch (request.c())
            {
            default:
                throw new IOException((new StringBuilder("Unexpected response code for CONNECT: ")).append(request.c()).toString());

            case 200: 
                if (httpconnection.e() > 0L)
                {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                } else
                {
                    return;
                }

            case 407: 
                request1 = OkHeaders.a(b.a.g, request, b.b);
                request = request1;
                break;
            }
        } while (request1 != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    final Transport a(HttpEngine httpengine)
    {
        if (f != null)
        {
            return new SpdyTransport(httpengine, f);
        } else
        {
            return new HttpTransport(httpengine, e);
        }
    }

    final Object a()
    {
        Object obj;
        synchronized (a)
        {
            obj = k;
        }
        return obj;
        exception;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void a(int i1, int j1)
    {
        if (!d)
        {
            throw new IllegalStateException("setTimeouts - not connected");
        }
        if (e != null)
        {
            c.setSoTimeout(i1);
            e.a(i1, j1);
        }
    }

    final void a(int i1, int j1, int k1, Request request)
    {
        if (d)
        {
            throw new IllegalStateException("already connected");
        }
        if (b.b.type() != java.net.Proxy.Type.HTTP)
        {
            c = new Socket(b.b);
        } else
        {
            c = b.a.d.createSocket();
        }
        c.setSoTimeout(j1);
        Platform.a().a(c, b.c, i1);
        if (b.a.e != null)
        {
            Object obj = Platform.a();
            if (request != null)
            {
                a(request, j1, k1);
            }
            c = b.a.e.createSocket(c, b.a.b, b.a.c, true);
            request = (SSLSocket)c;
            ((Platform) (obj)).a(request, b.a.b, b.d);
            if (!b.d.equals("SSLv3"))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                ((Platform) (obj)).a(request, b.a.h);
            }
            request.startHandshake();
            if (!b.a.f.verify(b.a.b, request.getSession()))
            {
                throw new IOException((new StringBuilder("Hostname '")).append(b.a.b).append("' was not verified").toString());
            }
            i = Handshake.a(request.getSession());
            if (i1 != 0)
            {
                obj = ((Platform) (obj)).a(request);
                if (obj != null)
                {
                    g = Protocol.a(((String) (obj)));
                }
            }
            if (g == Protocol.c || g == Protocol.d)
            {
                request.setSoTimeout(0);
                f = (new com.squareup.okhttp.internal.spdy.SpdyConnection.Builder(b.a.b, c)).a(g).a();
                f.e();
            } else
            {
                e = new HttpConnection(a, this, c);
            }
        } else
        {
            e = new HttpConnection(a, this, c);
        }
        d = true;
    }

    final void a(Protocol protocol)
    {
        if (protocol == null)
        {
            throw new IllegalArgumentException("protocol == null");
        } else
        {
            g = protocol;
            return;
        }
    }

    final void a(Object obj)
    {
        if (l())
        {
            return;
        }
        ConnectionPool connectionpool = a;
        connectionpool;
        JVM INSTR monitorenter ;
        if (k != null)
        {
            throw new IllegalStateException("Connection already has an owner!");
        }
        break MISSING_BLOCK_LABEL_38;
        obj;
        connectionpool;
        JVM INSTR monitorexit ;
        throw obj;
        k = obj;
        connectionpool;
        JVM INSTR monitorexit ;
    }

    final boolean a(long l1)
    {
        return j() < System.nanoTime() - l1;
    }

    final void b(Object obj)
    {
label0:
        {
            if (l())
            {
                throw new IllegalStateException();
            }
            synchronized (a)
            {
                if (k == obj)
                {
                    break label0;
                }
            }
            return;
        }
        k = null;
        connectionpool;
        JVM INSTR monitorexit ;
        c.close();
        return;
        obj;
        connectionpool;
        JVM INSTR monitorexit ;
        throw obj;
    }

    final boolean b()
    {
label0:
        {
            synchronized (a)
            {
                if (k != null)
                {
                    break label0;
                }
            }
            return false;
        }
        k = null;
        connectionpool;
        JVM INSTR monitorexit ;
        return true;
        exception;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final boolean c()
    {
        return d;
    }

    public final Route d()
    {
        return b;
    }

    public final Socket e()
    {
        return c;
    }

    final boolean f()
    {
        return !c.isClosed() && !c.isInputShutdown() && !c.isOutputShutdown();
    }

    final boolean g()
    {
        if (e != null)
        {
            return e.f();
        } else
        {
            return true;
        }
    }

    final void h()
    {
        if (f != null)
        {
            throw new IllegalStateException("spdyConnection != null");
        } else
        {
            h = System.nanoTime();
            return;
        }
    }

    final boolean i()
    {
        return f == null || f.b();
    }

    final long j()
    {
        if (f == null)
        {
            return h;
        } else
        {
            return f.c();
        }
    }

    public final Handshake k()
    {
        return i;
    }

    final boolean l()
    {
        return f != null;
    }

    public final Protocol m()
    {
        return g;
    }

    final void n()
    {
        j = j + 1;
    }

    final int o()
    {
        return j;
    }
}
