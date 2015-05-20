// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.net.CacheRequest;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

class > extends >
    implements Source
{

    final HttpConnection d;
    private boolean e;

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
        if (e)
        {
            return -1L;
        }
        l = HttpConnection.g(d).b(buffer, l);
        if (l == -1L)
        {
            e = true;
            a(false);
            return -1L;
        } else
        {
            a(buffer, l);
            return l;
        }
    }

    public void close()
    {
        if (b)
        {
            return;
        }
        if (!e)
        {
            a_();
        }
        b = true;
    }

    (HttpConnection httpconnection, CacheRequest cacherequest)
    {
        d = httpconnection;
        super(httpconnection, cacherequest);
    }
}
