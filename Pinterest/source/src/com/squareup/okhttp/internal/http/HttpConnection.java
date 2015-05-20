// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            RetryableSink, StatusLine, OkHeaders, HttpEngine

public final class HttpConnection
{

    private static final byte h[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    private static final byte i[] = {
        48, 13, 10, 13, 10
    };
    private final ConnectionPool a;
    private final Connection b;
    private final Socket c;
    private final BufferedSource d;
    private final BufferedSink e;
    private int f;
    private int g;

    public HttpConnection(ConnectionPool connectionpool, Connection connection, Socket socket)
    {
        f = 0;
        g = 0;
        a = connectionpool;
        b = connection;
        c = socket;
        d = Okio.a(Okio.b(socket));
        e = Okio.a(Okio.a(socket));
    }

    static int a(HttpConnection httpconnection, int l)
    {
        httpconnection.f = l;
        return l;
    }

    static BufferedSink a(HttpConnection httpconnection)
    {
        return httpconnection.e;
    }

    static int b(HttpConnection httpconnection)
    {
        return httpconnection.f;
    }

    static int c(HttpConnection httpconnection)
    {
        return httpconnection.g;
    }

    static int d(HttpConnection httpconnection)
    {
        httpconnection.g = 0;
        return 0;
    }

    static ConnectionPool e(HttpConnection httpconnection)
    {
        return httpconnection.a;
    }

    static Connection f(HttpConnection httpconnection)
    {
        return httpconnection.b;
    }

    static BufferedSource g(HttpConnection httpconnection)
    {
        return httpconnection.d;
    }

    static byte[] j()
    {
        return i;
    }

    static byte[] k()
    {
        return h;
    }

    public final Sink a(long l)
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 2;
            return new FixedLengthSink(l, (byte)0);
        }
    }

    public final Source a(CacheRequest cacherequest)
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new UnknownLengthSource(cacherequest);
        }
    }

    public final Source a(CacheRequest cacherequest, long l)
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new FixedLengthSource(cacherequest, l);
        }
    }

    public final Source a(CacheRequest cacherequest, HttpEngine httpengine)
    {
        if (f != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 5;
            return new ChunkedSource(cacherequest, httpengine);
        }
    }

    public final void a()
    {
        g = 1;
        if (f == 0)
        {
            g = 0;
            Internal.a.a(a, b);
        }
    }

    public final void a(int l, int i1)
    {
        if (l != 0)
        {
            d.a().a(l, TimeUnit.MILLISECONDS);
        }
        if (i1 != 0)
        {
            e.a().a(i1, TimeUnit.MILLISECONDS);
        }
    }

    public final void a(com.squareup.okhttp.Headers.Builder builder)
    {
        do
        {
            String s = d.m();
            if (s.length() != 0)
            {
                Internal.a.a(builder, s);
            } else
            {
                return;
            }
        } while (true);
    }

    public final void a(Headers headers, String s)
    {
        if (f != 0)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        }
        e.b(s).b("\r\n");
        for (int l = 0; l < headers.a(); l++)
        {
            e.b(headers.a(l)).b(": ").b(headers.b(l)).b("\r\n");
        }

        e.b("\r\n");
        f = 1;
    }

    public final void a(RetryableSink retryablesink)
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 3;
            retryablesink.a(e);
            return;
        }
    }

    public final void a(Object obj)
    {
        Internal.a.a(b, obj);
    }

    public final boolean a(Source source)
    {
        int l;
        boolean flag;
        try
        {
            l = c.getSoTimeout();
            c.setSoTimeout(100);
        }
        // Misplaced declaration of an exception variable
        catch (Source source)
        {
            return false;
        }
        flag = Util.a(source);
        c.setSoTimeout(l);
        return flag;
        source;
        c.setSoTimeout(l);
        throw source;
    }

    public final void b()
    {
        g = 2;
        if (f == 0)
        {
            f = 6;
            b.e().close();
        }
    }

    public final boolean c()
    {
        return f == 6;
    }

    public final void d()
    {
        e.b();
    }

    public final long e()
    {
        return d.d().c();
    }

    public final boolean f()
    {
        Exception exception;
        int l;
        boolean flag;
        try
        {
            l = c.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        c.setSoTimeout(1);
        flag = d.f();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        c.setSoTimeout(l);
        return false;
        c.setSoTimeout(l);
        return true;
        exception;
        c.setSoTimeout(l);
        throw exception;
    }

    public final com.squareup.okhttp.Response.Builder g()
    {
        if (f != 1 && f != 3)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        }
        StatusLine statusline;
        com.squareup.okhttp.Response.Builder builder;
        do
        {
            statusline = StatusLine.a(d.m());
            builder = (new com.squareup.okhttp.Response.Builder()).a(statusline.a).a(statusline.b).a(statusline.c);
            com.squareup.okhttp.Headers.Builder builder1 = new com.squareup.okhttp.Headers.Builder();
            a(builder1);
            builder1.a(OkHeaders.d, statusline.a.toString());
            builder.a(builder1.a());
        } while (statusline.b == 100);
        f = 4;
        return builder;
    }

    public final Sink h()
    {
        if (f != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(f).toString());
        } else
        {
            f = 2;
            return new ChunkedSink((byte)0);
        }
    }

    public final void i()
    {
        a(((CacheRequest) (null)), 0L);
    }


    private class FixedLengthSink
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

        private FixedLengthSink(long l)
        {
            a = HttpConnection.this;
            super();
            c = l;
        }

        FixedLengthSink(long l, byte byte0)
        {
            this(l);
        }
    }


    private class UnknownLengthSource extends AbstractSource
        implements Source
    {
        private class AbstractSource
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

            AbstractSource(CacheRequest cacherequest)
            {
                c = HttpConnection.this;
                super();
                if (cacherequest != null)
                {
                    httpconnection = cacherequest.getBody();
                } else
                {
                    httpconnection = null;
                }
                if (HttpConnection.this == null)
                {
                    cacherequest = null;
                }
                a = HttpConnection.this;
                d = cacherequest;
            }
        }


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

        UnknownLengthSource(CacheRequest cacherequest)
        {
            d = HttpConnection.this;
            super(cacherequest);
        }
    }


    private class FixedLengthSource extends AbstractSource
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

        public FixedLengthSource(CacheRequest cacherequest, long l)
        {
            d = HttpConnection.this;
            super(cacherequest);
            e = l;
            if (e == 0L)
            {
                a(true);
            }
        }
    }


    private class ChunkedSource extends AbstractSource
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
            int i1 = s.indexOf(";");
            Object obj = s;
            if (i1 != -1)
            {
                obj = s.substring(0, i1);
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
                obj = new com.squareup.okhttp.Headers.Builder();
                d.a(((com.squareup.okhttp.Headers.Builder) (obj)));
                g.a(((com.squareup.okhttp.Headers.Builder) (obj)).a());
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

        ChunkedSource(CacheRequest cacherequest, HttpEngine httpengine)
        {
            d = HttpConnection.this;
            super(cacherequest);
            e = -1;
            f = true;
            g = httpengine;
        }
    }


    private class ChunkedSink
        implements Sink
    {

        final HttpConnection a;
        private final byte b[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 13, 10
        };
        private boolean c;

        private void a(long l)
        {
            int i1 = 16;
            int j1;
            long l1;
            do
            {
                byte abyte0[] = b;
                j1 = i1 - 1;
                abyte0[j1] = HttpConnection.k()[(int)(15L & l)];
                l1 = l >>> 4;
                i1 = j1;
                l = l1;
            } while (l1 != 0L);
            HttpConnection.a(a).c(b, j1, b.length - j1);
        }

        public final Timeout a()
        {
            return HttpConnection.a(a).a();
        }

        public final void a(Buffer buffer, long l)
        {
            if (c)
            {
                throw new IllegalStateException("closed");
            }
            if (l == 0L)
            {
                return;
            } else
            {
                a(l);
                HttpConnection.a(a).a(buffer, l);
                HttpConnection.a(a).b("\r\n");
                return;
            }
        }

        public final void b()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = c;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            HttpConnection.a(a).b();
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = c;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            c = true;
            HttpConnection.a(a).b(HttpConnection.j());
            HttpConnection.a(a, 3);
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private ChunkedSink()
        {
            a = HttpConnection.this;
            super();
        }

        ChunkedSink(byte byte0)
        {
            this();
        }
    }

}
