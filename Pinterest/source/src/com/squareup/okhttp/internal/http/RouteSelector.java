// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;

public final class RouteSelector
{

    private final Address a;
    private final URI b;
    private final ProxySelector c;
    private final ConnectionPool d;
    private final Dns e;
    private final RouteDatabase f;
    private Proxy g;
    private InetSocketAddress h;
    private boolean i;
    private Proxy j;
    private Iterator k;
    private InetAddress l[];
    private int m;
    private int n;
    private String o;
    private final List p = new LinkedList();

    public RouteSelector(Address address, URI uri, ProxySelector proxyselector, ConnectionPool connectionpool, Dns dns, RouteDatabase routedatabase)
    {
        a = address;
        b = uri;
        c = proxyselector;
        d = connectionpool;
        e = dns;
        f = routedatabase;
        address = address.b();
        i = true;
        if (address != null)
        {
            j = address;
        } else
        {
            address = c.select(uri);
            if (address != null)
            {
                k = address.iterator();
                return;
            }
        }
    }

    private Proxy b()
    {
        if (j != null)
        {
            i = false;
            return j;
        }
        if (k != null)
        {
            while (k.hasNext()) 
            {
                Proxy proxy = (Proxy)k.next();
                if (proxy.type() != java.net.Proxy.Type.DIRECT)
                {
                    return proxy;
                }
            }
        }
        i = false;
        return Proxy.NO_PROXY;
    }

    private boolean c()
    {
        return l != null;
    }

    private boolean d()
    {
        return o != null;
    }

    private String e()
    {
        if (o == null)
        {
            throw new IllegalStateException("No next TLS version");
        }
        if (o.equals("TLSv1"))
        {
            o = "SSLv3";
            return "TLSv1";
        }
        if (o.equals("SSLv3"))
        {
            o = null;
            return "SSLv3";
        } else
        {
            throw new AssertionError();
        }
    }

    private boolean f()
    {
        return !p.isEmpty();
    }

    public final Connection a(String s)
    {
        do
        {
            Connection connection = d.a(a);
            if (connection != null)
            {
                if (s.equals("GET") || Internal.a.f(connection))
                {
                    return connection;
                }
                connection.e().close();
            } else
            {
                Object obj;
                if (!d())
                {
                    if (!c())
                    {
                        if (!i)
                        {
                            if (!f())
                            {
                                throw new NoSuchElementException();
                            } else
                            {
                                return new Connection(d, (Route)p.remove(0));
                            }
                        }
                        g = b();
                        obj = g;
                        l = null;
                        int i1;
                        if (((Proxy) (obj)).type() == java.net.Proxy.Type.DIRECT)
                        {
                            obj = b.getHost();
                            n = Util.a(b);
                        } else
                        {
                            obj = ((Proxy) (obj)).address();
                            if (!(obj instanceof InetSocketAddress))
                            {
                                throw new IllegalArgumentException((new StringBuilder("Proxy.address() is not an InetSocketAddress: ")).append(obj.getClass()).toString());
                            }
                            InetSocketAddress inetsocketaddress = (InetSocketAddress)obj;
                            obj = inetsocketaddress.getHostName();
                            n = inetsocketaddress.getPort();
                        }
                        l = e.getAllByName(((String) (obj)));
                        m = 0;
                    }
                    obj = l;
                    i1 = m;
                    m = i1 + 1;
                    obj = new InetSocketAddress(obj[i1], n);
                    if (m == l.length)
                    {
                        l = null;
                        m = 0;
                    }
                    h = ((InetSocketAddress) (obj));
                    if (a.a() != null)
                    {
                        obj = "TLSv1";
                    } else
                    {
                        obj = "SSLv3";
                    }
                    o = ((String) (obj));
                }
                obj = e();
                obj = new Route(a, g, h, ((String) (obj)));
                if (f.c(((Route) (obj))))
                {
                    p.add(obj);
                } else
                {
                    return new Connection(d, ((Route) (obj)));
                }
            }
        } while (true);
    }

    public final void a(Connection connection, IOException ioexception)
    {
        if (Internal.a.b(connection) <= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        connection = connection.d();
        if (connection.a().type() != java.net.Proxy.Type.DIRECT && c != null)
        {
            c.connectFailed(b, connection.a().address(), ioexception);
        }
        f.a(connection);
        if (!(ioexception instanceof SSLHandshakeException) && !(ioexception instanceof SSLProtocolException))
        {
            while (d()) 
            {
                connection = new Route(a, g, h, e());
                f.a(connection);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final boolean a()
    {
        return d() || c() || i || f();
    }
}
