// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements Sink
{

    final HttpConnection a;
    private boolean b;
    private long c;

    public final Timeout a()
    {
        return HttpConnection.a(a).a();
    }

    public final void a(Buffer buffer, long l)
    {
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        Util.a(buffer.c(), l);
        if (l > c)
        {
            throw new ProtocolException((new StringBuilder("expected ")).append(c).append(" bytes but received ").append(l).toString());
        } else
        {
            HttpConnection.a(a).a(buffer, l);
            c = c - l;
            return;
        }
    }

    public final void b()
    {
        if (b)
        {
            return;
        } else
        {
            HttpConnection.a(a).b();
            return;
        }
    }

    public final void close()
    {
        if (b)
        {
            return;
        }
        b = true;
        if (c > 0L)
        {
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            HttpConnection.a(a, 3);
            return;
        }
    }

    private (HttpConnection httpconnection, long l)
    {
        a = httpconnection;
        super();
        c = l;
    }

    c(HttpConnection httpconnection, long l, byte byte0)
    {
        this(httpconnection, l);
    }
}
