// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package com.squareup.okhttp:
//            Address

public final class Route
{

    final Address a;
    final Proxy b;
    final InetSocketAddress c;
    final String d;

    public Route(Address address, Proxy proxy, InetSocketAddress inetsocketaddress, String s)
    {
        if (address == null)
        {
            throw new NullPointerException("address == null");
        }
        if (proxy == null)
        {
            throw new NullPointerException("proxy == null");
        }
        if (inetsocketaddress == null)
        {
            throw new NullPointerException("inetSocketAddress == null");
        }
        if (s == null)
        {
            throw new NullPointerException("tlsVersion == null");
        } else
        {
            a = address;
            b = proxy;
            c = inetsocketaddress;
            d = s;
            return;
        }
    }

    public final Proxy a()
    {
        return b;
    }

    public final boolean b()
    {
        return a.e != null && b.type() == java.net.Proxy.Type.HTTP;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Route)
        {
            obj = (Route)obj;
            flag = flag1;
            if (a.equals(((Route) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((Route) (obj)).b))
                {
                    flag = flag1;
                    if (c.equals(((Route) (obj)).c))
                    {
                        flag = flag1;
                        if (d.equals(((Route) (obj)).d))
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (((a.hashCode() + 527) * 31 + b.hashCode()) * 31 + c.hashCode()) * 31 + d.hashCode();
    }
}
