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

public final class RetryableSink
    implements Sink
{

    private boolean a;
    private final int b;
    private final Buffer c;

    public RetryableSink()
    {
        this(-1);
    }

    public RetryableSink(int i)
    {
        c = new Buffer();
        b = i;
    }

    public final Timeout a()
    {
        return Timeout.b;
    }

    public final void a(Buffer buffer, long l)
    {
        if (a)
        {
            throw new IllegalStateException("closed");
        }
        Util.a(buffer.c(), l);
        if (b != -1 && c.c() > (long)b - l)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(b).append(" bytes").toString());
        } else
        {
            c.a(buffer, l);
            return;
        }
    }

    public final void a(BufferedSink bufferedsink)
    {
        bufferedsink.a(c.q());
    }

    public final void b()
    {
    }

    public final long c()
    {
        return c.c();
    }

    public final void close()
    {
        if (!a)
        {
            a = true;
            if (c.c() < (long)b)
            {
                throw new ProtocolException((new StringBuilder("content-length promised ")).append(b).append(" bytes, but received ").append(c.c()).toString());
            }
        }
    }
}
