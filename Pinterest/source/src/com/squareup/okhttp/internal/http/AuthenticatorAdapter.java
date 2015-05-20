// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

public final class AuthenticatorAdapter
    implements Authenticator
{

    public static final Authenticator a = new AuthenticatorAdapter();

    public AuthenticatorAdapter()
    {
    }

    private static InetAddress a(Proxy proxy, URL url)
    {
        if (proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT)
        {
            return ((InetSocketAddress)proxy.address()).getAddress();
        } else
        {
            return InetAddress.getByName(url.getHost());
        }
    }

    public final Request authenticate(Proxy proxy, Response response)
    {
        List list = response.l();
        response = response.a();
        URL url = response.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (Challenge)list.get(i);
            if (!"Basic".equalsIgnoreCase(((Challenge) (obj)).a()))
            {
                continue;
            }
            obj = java.net.Authenticator.requestPasswordAuthentication(url.getHost(), a(proxy, url), url.getPort(), url.getProtocol(), ((Challenge) (obj)).b(), ((Challenge) (obj)).a(), url, java.net.Authenticator.RequestorType.SERVER);
            if (obj != null)
            {
                proxy = Credentials.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return response.f().a("Authorization", proxy).a();
            }
        }

        return null;
    }

    public final Request authenticateProxy(Proxy proxy, Response response)
    {
        List list = response.l();
        response = response.a();
        URL url = response.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (Challenge)list.get(i);
            if (!"Basic".equalsIgnoreCase(((Challenge) (obj)).a()))
            {
                continue;
            }
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
            obj = java.net.Authenticator.requestPasswordAuthentication(inetsocketaddress.getHostName(), a(proxy, url), inetsocketaddress.getPort(), url.getProtocol(), ((Challenge) (obj)).b(), ((Challenge) (obj)).a(), url, java.net.Authenticator.RequestorType.PROXY);
            if (obj != null)
            {
                proxy = Credentials.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return response.f().a("Proxy-Authorization", proxy).a();
            }
        }

        return null;
    }

}
