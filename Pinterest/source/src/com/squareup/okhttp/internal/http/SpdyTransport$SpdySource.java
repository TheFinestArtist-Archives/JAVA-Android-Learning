// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

class c
    implements Source
{

    private final SpdyStream a;
    private final Source b;
    private final CacheRequest c;
    private final OutputStream d;
    private boolean e;
    private boolean f;

    private boolean b()
    {
        Exception exception;
        long l = a.d().f();
        a.d().a(100L, TimeUnit.MILLISECONDS);
        try
        {
            Util.a(this);
        }
        catch (IOException ioexception)
        {
            a.d().a(l, TimeUnit.NANOSECONDS);
            return false;
        }
        finally
        {
            a.d().a(l, TimeUnit.NANOSECONDS);
        }
        a.d().a(l, TimeUnit.NANOSECONDS);
        return true;
        throw exception;
    }

    public final Timeout a()
    {
        return b.a();
    }

    public final long b(Buffer buffer, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (f)
        {
            throw new IllegalStateException("closed");
        }
        if (e)
        {
            l = -1L;
        } else
        {
            long l1 = b.b(buffer, l);
            if (l1 == -1L)
            {
                e = true;
                if (c != null)
                {
                    d.close();
                }
                return -1L;
            }
            l = l1;
            if (d != null)
            {
                buffer.a(d, buffer.c() - l1, l1);
                return l1;
            }
        }
        return l;
    }

    public void close()
    {
        if (!f)
        {
            if (!e && d != null)
            {
                b();
            }
            f = true;
            if (!e)
            {
                a.b(ErrorCode.l);
                if (c != null)
                {
                    c.abort();
                    return;
                }
            }
        }
    }

    (SpdyStream spdystream, CacheRequest cacherequest)
    {
        a = spdystream;
        b = spdystream.e();
        if (cacherequest != null)
        {
            spdystream = cacherequest.getBody();
        } else
        {
            spdystream = null;
        }
        if (spdystream == null)
        {
            cacherequest = null;
        }
        d = spdystream;
        c = cacherequest;
    }
}
