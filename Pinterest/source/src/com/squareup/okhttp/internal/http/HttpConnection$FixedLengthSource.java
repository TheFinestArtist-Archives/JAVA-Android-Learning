// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.net.CacheRequest;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

class a extends a
    implements Source
{

    final HttpConnection d;
    private long e;

    public final Timeout a()
    {
        return HttpConnection.g(d).a();
    }

    public final long b(Buffer buffer, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        if (e == 0L)
        {
            return -1L;
        }
        l = HttpConnection.g(d).b(buffer, Math.min(e, l));
        if (l == -1L)
        {
            a_();
            throw new ProtocolException("unexpected end of stream");
        }
        e = e - l;
        a(buffer, l);
        if (e == 0L)
        {
            a(true);
        }
        return l;
    }

    public void close()
    {
        if (b)
        {
            return;
        }
        if (e != 0L && !d.a(this))
        {
            a_();
        }
        b = true;
    }

    public (HttpConnection httpconnection, CacheRequest cacherequest, long l)
    {
        d = httpconnection;
        super(httpconnection, cacherequest);
        e = l;
        if (e == 0L)
        {
            a(true);
        }
    }
}
