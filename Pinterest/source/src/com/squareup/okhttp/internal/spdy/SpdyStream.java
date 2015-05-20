// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, Settings, ErrorCode, HeadersMode

public final class SpdyStream
{

    static final boolean d;
    long a;
    long b;
    final SpdyDataSink c;
    private final int e;
    private final SpdyConnection f;
    private long g;
    private final List h;
    private List i;
    private final SpdyDataSource j;
    private final SpdyTimeout k = new SpdyTimeout();
    private final SpdyTimeout l = new SpdyTimeout();
    private ErrorCode m;

    SpdyStream(int i1, SpdyConnection spdyconnection, boolean flag, boolean flag1, List list)
    {
        a = 0L;
        g = 0L;
        m = null;
        if (spdyconnection == null)
        {
            throw new NullPointerException("connection == null");
        }
        if (list == null)
        {
            throw new NullPointerException("requestHeaders == null");
        } else
        {
            e = i1;
            f = spdyconnection;
            b = spdyconnection.f.d();
            j = new SpdyDataSource(spdyconnection.e.d(), (byte)0);
            c = new SpdyDataSink();
            SpdyDataSource.a(j, flag1);
            SpdyDataSink.a(c, flag);
            h = list;
            return;
        }
    }

    static SpdyConnection a(SpdyStream spdystream)
    {
        return spdystream.f;
    }

    static int b(SpdyStream spdystream)
    {
        return spdystream.e;
    }

    static SpdyTimeout c(SpdyStream spdystream)
    {
        return spdystream.k;
    }

    static ErrorCode d(SpdyStream spdystream)
    {
        return spdystream.m;
    }

    private boolean d(ErrorCode errorcode)
    {
        if (!d && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        if (!SpdyDataSource.a(j) || !SpdyDataSink.a(c))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        m = errorcode;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        f.b(e);
        return true;
    }

    static void e(SpdyStream spdystream)
    {
        spdystream.h();
    }

    static void f(SpdyStream spdystream)
    {
        if (!d && Thread.holdsLock(spdystream))
        {
            throw new AssertionError();
        }
        spdystream;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (SpdyDataSource.a(spdystream.j) || !SpdyDataSource.b(spdystream.j) || !SpdyDataSink.a(spdystream.c) && !SpdyDataSink.b(spdystream.c))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = spdystream.a();
        spdystream;
        JVM INSTR monitorexit ;
        Exception exception;
        if (flag)
        {
            spdystream.a(ErrorCode.l);
        } else
        if (!flag1)
        {
            spdystream.f.b(spdystream.e);
            return;
        }
        return;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static SpdyTimeout g(SpdyStream spdystream)
    {
        return spdystream.l;
    }

    private void h()
    {
        try
        {
            wait();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            throw new InterruptedIOException();
        }
    }

    static void h(SpdyStream spdystream)
    {
        if (SpdyDataSink.b(spdystream.c))
        {
            throw new IOException("stream closed");
        }
        if (SpdyDataSink.a(spdystream.c))
        {
            throw new IOException("stream finished");
        }
        if (spdystream.m != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(spdystream.m).toString());
        } else
        {
            return;
        }
    }

    final void a(long l1)
    {
        b = b + l1;
        if (l1 > 0L)
        {
            notifyAll();
        }
    }

    public final void a(ErrorCode errorcode)
    {
        if (!d(errorcode))
        {
            return;
        } else
        {
            f.b(e, errorcode);
            return;
        }
    }

    final void a(List list, HeadersMode headersmode)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag = false;
        flag2 = true;
        if (!d && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (i != null) goto _L2; else goto _L1
_L1:
        if (headersmode == HeadersMode.c)
        {
            flag = true;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        list = ErrorCode.b;
_L7:
        this;
        JVM INSTR monitorexit ;
        if (list == null) goto _L6; else goto _L5
_L5:
        b(list);
_L9:
        return;
_L4:
        i = list;
        flag2 = a();
        notifyAll();
        list = obj;
          goto _L7
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
_L2:
        flag = flag1;
        if (headersmode == HeadersMode.b)
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        list = ErrorCode.e;
          goto _L7
        headersmode = new ArrayList();
        headersmode.addAll(i);
        headersmode.addAll(list);
        i = headersmode;
        list = obj;
          goto _L7
_L6:
        if (flag2) goto _L9; else goto _L8
_L8:
        f.b(e);
        return;
          goto _L7
    }

    final void a(BufferedSource bufferedsource, int i1)
    {
        if (!d && Thread.holdsLock(this))
        {
            throw new AssertionError();
        } else
        {
            j.a(bufferedsource, i1);
            return;
        }
    }

    public final boolean a()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj = m;
        if (obj == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (!SpdyDataSource.a(j) && !SpdyDataSource.b(j) || !SpdyDataSink.a(c) && !SpdyDataSink.b(c))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = i;
        if (obj != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(ErrorCode errorcode)
    {
        if (!d(errorcode))
        {
            return;
        } else
        {
            f.a(e, errorcode);
            return;
        }
    }

    public final boolean b()
    {
        boolean flag;
        if ((e & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return f.b == flag;
    }

    public final List c()
    {
        this;
        JVM INSTR monitorenter ;
        k.c();
        while (i == null && m == null) 
        {
            h();
        }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        k.b();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        List list;
        k.b();
        if (i == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        list = i;
        this;
        JVM INSTR monitorexit ;
        return list;
        throw new IOException((new StringBuilder("stream was reset: ")).append(m).toString());
    }

    final void c(ErrorCode errorcode)
    {
        this;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            m = errorcode;
            notifyAll();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        errorcode;
        throw errorcode;
    }

    public final Timeout d()
    {
        return k;
    }

    public final Source e()
    {
        return j;
    }

    public final Sink f()
    {
        this;
        JVM INSTR monitorenter ;
        if (i == null && !b())
        {
            throw new IllegalStateException("reply before requesting the sink");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        return c;
    }

    final void g()
    {
        if (!d && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        SpdyDataSource.a(j, true);
        flag = a();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            f.b(e);
        }
        return;
        Exception exception;
        exception;
        this;
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
        d = flag;
    }

    private class SpdyTimeout extends AsyncTimeout
    {

        final SpdyStream a;

        protected final void a()
        {
            a.b(ErrorCode.l);
        }

        public final void b()
        {
            if (d())
            {
                throw new InterruptedIOException("timeout");
            } else
            {
                return;
            }
        }

        SpdyTimeout()
        {
            a = SpdyStream.this;
            super();
        }
    }


    private class SpdyDataSource
        implements Source
    {

        static final boolean a;
        final SpdyStream b;
        private final Buffer c;
        private final Buffer d;
        private final long e;
        private boolean f;
        private boolean g;

        static boolean a(SpdyDataSource spdydatasource)
        {
            return spdydatasource.g;
        }

        static boolean a(SpdyDataSource spdydatasource, boolean flag)
        {
            spdydatasource.g = flag;
            return flag;
        }

        private void b()
        {
            SpdyStream.c(b).c();
            for (; d.c() == 0L && !g && !f && SpdyStream.d(b) == null; SpdyStream.e(b)) { }
            break MISSING_BLOCK_LABEL_69;
            Exception exception;
            exception;
            SpdyStream.c(b).b();
            throw exception;
            SpdyStream.c(b).b();
            return;
        }

        static boolean b(SpdyDataSource spdydatasource)
        {
            return spdydatasource.f;
        }

        public final Timeout a()
        {
            return SpdyStream.c(b);
        }

        final void a(BufferedSource bufferedsource, long l1)
        {
            long l2;
            l2 = l1;
            if (!a)
            {
                l2 = l1;
                if (Thread.holdsLock(b))
                {
                    throw new AssertionError();
                }
            }
              goto _L1
_L3:
            l2 -= l1;
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
            if (l2 <= 0L)
            {
                break MISSING_BLOCK_LABEL_156;
            }
            spdystream = b;
            spdystream;
            JVM INSTR monitorenter ;
            flag1 = g;
            if (d.c() + l2 > e)
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
            bufferedsource.g(l2);
            b.b(ErrorCode.h);
            return;
            bufferedsource;
            spdystream;
            JVM INSTR monitorexit ;
            throw bufferedsource;
            if (flag1)
            {
                bufferedsource.g(l2);
                return;
            }
            l1 = bufferedsource.b(c, l2);
            if (l1 != -1L) goto _L3; else goto _L2
_L2:
            throw new EOFException();
            bufferedsource;
            spdystream;
            JVM INSTR monitorexit ;
            throw bufferedsource;
        }

        public final long b(Buffer buffer, long l1)
        {
            if (l1 < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
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
            l1 = d.b(buffer, Math.min(l1, d.c()));
            buffer = b;
            buffer.a = ((SpdyStream) (buffer)).a + l1;
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
                spdyconnection.c = spdyconnection.c + l1;
                if (SpdyStream.a(b).c >= (long)(SpdyStream.a(b).e.d() / 2))
                {
                    SpdyStream.a(b).a(0, SpdyStream.a(b).c);
                    SpdyStream.a(b).c = 0L;
                }
            }
            return l1;
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

        private SpdyDataSource(long l1)
        {
            b = SpdyStream.this;
            super();
            c = new Buffer();
            d = new Buffer();
            e = l1;
        }

        SpdyDataSource(long l1, byte byte0)
        {
            this(l1);
        }
    }


    private class SpdyDataSink
        implements Sink
    {

        static final boolean a;
        final SpdyStream b;
        private boolean c;
        private boolean d;

        static boolean a(SpdyDataSink spdydatasink)
        {
            return spdydatasink.d;
        }

        static boolean a(SpdyDataSink spdydatasink, boolean flag)
        {
            spdydatasink.d = flag;
            return flag;
        }

        static boolean b(SpdyDataSink spdydatasink)
        {
            return spdydatasink.c;
        }

        public final Timeout a()
        {
            return SpdyStream.g(b);
        }

        public final void a(Buffer buffer, long l1)
        {
            long l2;
            l2 = l1;
            if (!a)
            {
                l2 = l1;
                if (Thread.holdsLock(b))
                {
                    throw new AssertionError();
                }
            }
              goto _L1
_L3:
            SpdyStream.g(b).b();
            SpdyStream.h(b);
            l1 = Math.min(b.b, l2);
            SpdyStream spdystream1 = b;
            spdystream1.b = spdystream1.b - l1;
            SpdyStream spdystream;
            spdystream;
            JVM INSTR monitorexit ;
            l2 -= l1;
            SpdyStream.a(b).a(SpdyStream.b(b), false, buffer, l1);
_L1:
            if (l2 <= 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            spdystream = b;
            spdystream;
            JVM INSTR monitorenter ;
            SpdyStream.g(b).c();
            while (b.b <= 0L && !d && !c && SpdyStream.d(b) == null) 
            {
                SpdyStream.e(b);
            }
            if (true) goto _L3; else goto _L2
            buffer;
            SpdyStream.g(b).b();
            throw buffer;
            buffer;
            spdystream;
            JVM INSTR monitorexit ;
            throw buffer;
_L2:
        }

        public final void b()
        {
            if (!a && Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
            synchronized (b)
            {
                SpdyStream.h(b);
            }
            SpdyStream.a(b).d();
            return;
            exception;
            spdystream;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void close()
        {
label0:
            {
                if (!a && Thread.holdsLock(b))
                {
                    throw new AssertionError();
                }
                synchronized (b)
                {
                    if (!c)
                    {
                        break label0;
                    }
                }
                return;
            }
            spdystream;
            JVM INSTR monitorexit ;
            if (!b.c.d)
            {
                SpdyStream.a(b).a(SpdyStream.b(b), true, null, 0L);
            }
            synchronized (b)
            {
                c = true;
            }
            SpdyStream.a(b).d();
            SpdyStream.f(b);
            return;
            exception;
            spdystream;
            JVM INSTR monitorexit ;
            throw exception;
            exception1;
            spdystream;
            JVM INSTR monitorexit ;
            throw exception1;
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

        SpdyDataSink()
        {
            b = SpdyStream.this;
            super();
        }
    }

}
