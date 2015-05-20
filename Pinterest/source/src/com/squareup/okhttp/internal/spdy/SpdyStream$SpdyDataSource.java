// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream, ErrorCode, SpdyConnection, Settings

final class <init>
    implements Source
{

    static final boolean a;
    final SpdyStream b;
    private final Buffer c;
    private final Buffer d;
    private final long e;
    private boolean f;
    private boolean g;

    static boolean a(<init> <init>1)
    {
        return <init>1.g;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.g = flag;
        return flag;
    }

    private void b()
    {
        SpdyStream.c(b).b();
        for (; d.c() == 0L && !g && !f && SpdyStream.d(b) == null; SpdyStream.e(b)) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        SpdyStream.c(b).b();
        throw exception;
        SpdyStream.c(b).b();
        return;
    }

    static boolean b(b b1)
    {
        return b1.f;
    }

    public final Timeout a()
    {
        return SpdyStream.c(b);
    }

    final void a(BufferedSource bufferedsource, long l)
    {
        long l1;
        l1 = l;
        if (!a)
        {
            l1 = l;
            if (Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
        }
          goto _L1
_L3:
        l1 -= l;
        SpdyStream spdystream = b;
        spdystream;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (d.c() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d.a(c);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        b.notifyAll();
        spdystream;
        JVM INSTR monitorexit ;
_L1:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        spdystream = b;
        spdystream;
        JVM INSTR monitorenter ;
        flag1 = g;
        if (d.c() + l1 > e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spdystream;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        bufferedsource.g(l1);
        b.b(ErrorCode.h);
        return;
        bufferedsource;
        spdystream;
        JVM INSTR monitorexit ;
        throw bufferedsource;
        if (flag1)
        {
            bufferedsource.g(l1);
            return;
        }
        l = bufferedsource.b(c, l1);
        if (l != -1L) goto _L3; else goto _L2
_L2:
        throw new EOFException();
        bufferedsource;
        spdystream;
        JVM INSTR monitorexit ;
        throw bufferedsource;
    }

    public final long b(Buffer buffer, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        SpdyStream spdystream = b;
        spdystream;
        JVM INSTR monitorenter ;
        b();
        if (f)
        {
            throw new IOException("stream closed");
        }
        break MISSING_BLOCK_LABEL_66;
        buffer;
        spdystream;
        JVM INSTR monitorexit ;
        throw buffer;
        if (SpdyStream.d(b) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(SpdyStream.d(b)).toString());
        }
        if (d.c() != 0L)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        spdystream;
        JVM INSTR monitorexit ;
        return -1L;
        l = d.b(buffer, Math.min(l, d.c()));
        buffer = b;
        buffer.a = ((SpdyStream) (buffer)).a + l;
        if (b.a >= (long)(SpdyStream.a(b).e.d() / 2))
        {
            SpdyStream.a(b).a(SpdyStream.b(b), b.a);
            b.a = 0L;
        }
        spdystream;
        JVM INSTR monitorexit ;
        synchronized (SpdyStream.a(b))
        {
            SpdyConnection spdyconnection = SpdyStream.a(b);
            spdyconnection.c = spdyconnection.c + l;
            if (SpdyStream.a(b).c >= (long)(SpdyStream.a(b).e.d() / 2))
            {
                SpdyStream.a(b).a(0, SpdyStream.a(b).c);
                SpdyStream.a(b).c = 0L;
            }
        }
        return l;
        exception;
        buffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void close()
    {
        synchronized (b)
        {
            f = true;
            d.o();
            b.notifyAll();
        }
        SpdyStream.f(b);
        return;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    private A(SpdyStream spdystream, long l)
    {
        b = spdystream;
        super();
        c = new Buffer();
        d = new Buffer();
        e = l;
    }

    e(SpdyStream spdystream, long l, byte byte0)
    {
        this(spdystream, l);
    }
}
