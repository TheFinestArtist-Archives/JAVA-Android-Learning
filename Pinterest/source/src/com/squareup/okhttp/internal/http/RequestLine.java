// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import java.net.URL;

public final class RequestLine
{

    public static String a(Protocol protocol)
    {
        if (protocol == Protocol.a)
        {
            return "HTTP/1.0";
        } else
        {
            return "HTTP/1.1";
        }
    }

    static String a(Request request, java.net.Proxy.Type type, Protocol protocol)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(request.d());
        stringbuilder.append(' ');
        boolean flag;
        if (!request.h() && type == java.net.Proxy.Type.HTTP)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            stringbuilder.append(request.a());
        } else
        {
            stringbuilder.append(a(request.a()));
        }
        stringbuilder.append(' ');
        stringbuilder.append(a(protocol));
        return stringbuilder.toString();
    }

    public static String a(URL url)
    {
        String s = url.getFile();
        if (s == null)
        {
            url = "/";
        } else
        {
            url = s;
            if (!s.startsWith("/"))
            {
                return (new StringBuilder("/")).append(s).toString();
            }
        }
        return url;
    }
}
