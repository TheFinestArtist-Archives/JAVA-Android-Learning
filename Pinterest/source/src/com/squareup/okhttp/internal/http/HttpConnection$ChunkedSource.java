// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.net.CacheRequest;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection, HttpEngine

class g extends 
    implements Source
{

    final HttpConnection d;
    private int e;
    private boolean f;
    private final HttpEngine g;

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
        if (f) goto _L2; else goto _L1
_L1:
        return -1L;
_L2:
        if (e != 0 && e != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (e != -1)
        {
            HttpConnection.g(d).m();
        }
        String s = HttpConnection.g(d).m();
        int i = s.indexOf(";");
        Object obj = s;
        if (i != -1)
        {
            obj = s.substring(0, i);
        }
        try
        {
            e = Integer.parseInt(((String) (obj)).trim(), 16);
        }
        // Misplaced declaration of an exception variable
        catch (Buffer buffer)
        {
            throw new ProtocolException((new StringBuilder("Expected a hex chunk size but was ")).append(((String) (obj))).toString());
        }
        if (e == 0)
        {
            f = false;
            obj = new com.squareup.okhttp.ChunkedSource.f();
            d.a(((com.squareup.okhttp.a) (obj)));
            g.a(((com.squareup.okhttp.ChunkedSource.g) (obj)).g());
            a(true);
        }
        if (!f) goto _L1; else goto _L3
_L3:
        l = HttpConnection.g(d).b(buffer, Math.min(l, e));
        if (l == -1L)
        {
            a_();
            throw new IOException("unexpected end of stream");
        } else
        {
            e = (int)((long)e - l);
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
        if (f && !d.a(this))
        {
            a_();
        }
        b = true;
    }

    (HttpConnection httpconnection, CacheRequest cacherequest, HttpEngine httpengine)
    {
        d = httpconnection;
        super(httpconnection, cacherequest);
        e = -1;
        f = true;
        g = httpengine;
    }
}
