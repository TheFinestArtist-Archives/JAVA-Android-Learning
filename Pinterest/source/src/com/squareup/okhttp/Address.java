// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp:
//            Authenticator

public final class Address
{

    final Proxy a;
    final String b;
    final int c;
    final SocketFactory d;
    final SSLSocketFactory e;
    final HostnameVerifier f;
    final Authenticator g;
    final List h;

    public Address(String s, int i, SocketFactory socketfactory, SSLSocketFactory sslsocketfactory, HostnameVerifier hostnameverifier, Authenticator authenticator, Proxy proxy, 
            List list)
    {
        if (s == null)
        {
            throw new NullPointerException("uriHost == null");
        }
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder("uriPort <= 0: ")).append(i).toString());
        }
        if (authenticator == null)
        {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null)
        {
            throw new IllegalArgumentException("protocols == null");
        } else
        {
            a = proxy;
            b = s;
            c = i;
            d = socketfactory;
            e = sslsocketfactory;
            f = hostnameverifier;
            g = authenticator;
            h = Util.a(list);
            return;
        }
    }

    public final SSLSocketFactory a()
    {
        return e;
    }

    public final Proxy b()
    {
        return a;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Address)
        {
            obj = (Address)obj;
            flag = flag1;
            if (Util.a(a, ((Address) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((Address) (obj)).b))
                {
                    flag = flag1;
                    if (c == ((Address) (obj)).c)
                    {
                        flag = flag1;
                        if (Util.a(e, ((Address) (obj)).e))
                        {
                            flag = flag1;
                            if (Util.a(f, ((Address) (obj)).f))
                            {
                                flag = flag1;
                                if (Util.a(g, ((Address) (obj)).g))
                                {
                                    flag = flag1;
                                    if (Util.a(h, ((Address) (obj)).h))
                                    {
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int k = 0;
        int l = b.hashCode();
        int i1 = c;
        int i;
        int j;
        int j1;
        if (e != null)
        {
            i = e.hashCode();
        } else
        {
            i = 0;
        }
        if (f != null)
        {
            j = f.hashCode();
        } else
        {
            j = 0;
        }
        j1 = g.hashCode();
        if (a != null)
        {
            k = a.hashCode();
        }
        return (((j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + j1) * 31 + k) * 31 + h.hashCode();
    }
}
