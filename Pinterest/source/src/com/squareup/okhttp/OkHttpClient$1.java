// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient, Connection, ConnectionPool, Request, 
//            Protocol

final class ttpEngine extends Internal
{

    public final InternalCache a(OkHttpClient okhttpclient)
    {
        return okhttpclient.g();
    }

    public final Transport a(Connection connection, HttpEngine httpengine)
    {
        return connection.a(httpengine);
    }

    public final void a(Connection connection, int i, int j)
    {
        connection.a(i, j);
    }

    public final void a(Connection connection, int i, int j, int k, Request request)
    {
        connection.a(i, j, k, request);
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

    public final void a( , String s)
    {
        .a(s);
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

    ttpEngine()
    {
    }
}
