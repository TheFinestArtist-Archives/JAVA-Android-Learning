// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;

// Referenced classes of package com.squareup.okhttp.internal:
//            InternalCache, RouteDatabase

public abstract class Internal
{

    public static Internal a;

    public Internal()
    {
    }

    public abstract InternalCache a(OkHttpClient okhttpclient);

    public abstract Transport a(Connection connection, HttpEngine httpengine);

    public abstract void a(Connection connection, int i, int j);

    public abstract void a(Connection connection, int i, int j, int k, Request request);

    public abstract void a(Connection connection, Protocol protocol);

    public abstract void a(Connection connection, Object obj);

    public abstract void a(ConnectionPool connectionpool, Connection connection);

    public abstract void a(com.squareup.okhttp.Headers.Builder builder, String s);

    public abstract boolean a(Connection connection);

    public abstract int b(Connection connection);

    public abstract RouteDatabase b(OkHttpClient okhttpclient);

    public abstract void b(Connection connection, HttpEngine httpengine);

    public abstract void b(ConnectionPool connectionpool, Connection connection);

    public abstract Object c(Connection connection);

    public abstract boolean d(Connection connection);

    public abstract boolean e(Connection connection);

    public abstract boolean f(Connection connection);
}
