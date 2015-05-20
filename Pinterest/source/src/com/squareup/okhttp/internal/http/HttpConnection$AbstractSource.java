// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.Socket;
import okio.Buffer;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

class d
{

    protected final OutputStream a;
    protected boolean b;
    final HttpConnection c;
    private final CacheRequest d;

    protected final void a(Buffer buffer, long l)
    {
        if (a != null)
        {
            buffer.a(a, buffer.c() - l, l);
        }
    }

    protected final void a(boolean flag)
    {
        if (HttpConnection.b(c) != 5)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(HttpConnection.b(c)).toString());
        }
        if (d != null)
        {
            a.close();
        }
        HttpConnection.a(c, 0);
        if (flag && HttpConnection.c(c) == 1)
        {
            HttpConnection.d(c);
            Internal.a.a(HttpConnection.e(c), HttpConnection.f(c));
        } else
        if (HttpConnection.c(c) == 2)
        {
            HttpConnection.a(c, 6);
            HttpConnection.f(c).e().close();
            return;
        }
    }

    protected final void a_()
    {
        if (d != null)
        {
            d.abort();
        }
        Util.a(HttpConnection.f(c).e());
        HttpConnection.a(c, 6);
    }

    (HttpConnection httpconnection, CacheRequest cacherequest)
    {
        c = httpconnection;
        super();
        if (cacherequest != null)
        {
            httpconnection = cacherequest.getBody();
        } else
        {
            httpconnection = null;
        }
        if (httpconnection == null)
        {
            cacherequest = null;
        }
        a = httpconnection;
        d = cacherequest;
    }
}
