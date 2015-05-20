// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.InputStream;

// Referenced classes of package okio:
//            BufferedSource, Buffer, Source, Timeout, 
//            ByteString

final class RealBufferedSource
    implements BufferedSource
{

    public final Buffer a;
    public final Source b;
    private boolean c;

    public RealBufferedSource(Source source)
    {
        this(source, new Buffer());
    }

    private RealBufferedSource(Source source, Buffer buffer)
    {
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            a = buffer;
            b = source;
            return;
        }
    }

    static boolean a(RealBufferedSource realbufferedsource)
    {
        return realbufferedsource.c;
    }

    public final long a(byte byte0)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        long l1 = 0L;
        do
        {
            long l2 = a.a(byte0, l1);
            l1 = l2;
            if (l2 != -1L)
            {
                break;
            }
            l1 = a.b;
            if (b.b(a, 2048L) != -1L)
            {
                continue;
            }
            l1 = -1L;
            break;
        } while (true);
        return l1;
    }

    public final Timeout a()
    {
        return b.a();
    }

    public final void a(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        while (a.b < l1) 
        {
            if (b.b(a, 2048L) == -1L)
            {
                throw new EOFException();
            }
        }
    }

    public final long b(Buffer buffer, long l1)
    {
        if (buffer == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b == 0L && b.b(a, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l1 = Math.min(l1, a.b);
            return a.b(buffer, l1);
        }
    }

    public final ByteString c(long l1)
    {
        a(l1);
        return a.c(l1);
    }

    public final void close()
    {
        if (c)
        {
            return;
        } else
        {
            c = true;
            b.close();
            a.o();
            return;
        }
    }

    public final String d(long l1)
    {
        a(l1);
        return a.d(l1);
    }

    public final Buffer d()
    {
        return a;
    }

    public final boolean f()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        return a.f() && b.b(a, 2048L) == -1L;
    }

    public final byte[] f(long l1)
    {
        a(l1);
        return a.f(l1);
    }

    public final InputStream g()
    {
        return new _cls1();
    }

    public final void g(long l1)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
_L3:
        if (l1 > 0L)
        {
            if (a.b == 0L && b.b(a, 2048L) == -1L)
            {
                throw new EOFException();
            }
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        long l2 = Math.min(l1, a.b);
        a.g(l2);
        l1 -= l2;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public final byte h()
    {
        a(1L);
        return a.h();
    }

    public final short i()
    {
        a(2L);
        return a.i();
    }

    public final int j()
    {
        a(4L);
        return a.j();
    }

    public final short k()
    {
        a(2L);
        return a.k();
    }

    public final int l()
    {
        a(4L);
        return a.l();
    }

    public final String m()
    {
        long l1 = a((byte)10);
        if (l1 == -1L)
        {
            throw new EOFException();
        } else
        {
            return a.e(l1);
        }
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }

    private class _cls1 extends InputStream
    {

        final RealBufferedSource a;

        public int available()
        {
            if (RealBufferedSource.a(a))
            {
                throw new IOException("closed");
            } else
            {
                return (int)Math.min(a.a.b, 0x7fffffffL);
            }
        }

        public void close()
        {
            a.close();
        }

        public int read()
        {
            if (RealBufferedSource.a(a))
            {
                throw new IOException("closed");
            }
            if (a.a.b == 0L && a.b.b(a.a, 2048L) == -1L)
            {
                return -1;
            } else
            {
                return a.a.h() & 0xff;
            }
        }

        public int read(byte abyte0[], int i1, int j1)
        {
            if (RealBufferedSource.a(a))
            {
                throw new IOException("closed");
            }
            Util.a(abyte0.length, i1, j1);
            if (a.a.b == 0L && a.b.b(a.a, 2048L) == -1L)
            {
                return -1;
            } else
            {
                return a.a.a(abyte0, i1, j1);
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append(a).append(".inputStream()").toString();
        }

        _cls1()
        {
            a = RealBufferedSource.this;
            super();
        }
    }

}
