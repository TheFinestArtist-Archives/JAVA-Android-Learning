// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.OutputStream;

// Referenced classes of package okio:
//            BufferedSink, Buffer, Source, Sink, 
//            Util, Segment, Timeout, ByteString

final class RealBufferedSink
    implements BufferedSink
{

    public final Buffer a;
    public final Sink b;
    private boolean c;

    public RealBufferedSink(Sink sink)
    {
        this(sink, new Buffer());
    }

    private RealBufferedSink(Sink sink, Buffer buffer)
    {
        if (sink == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            a = buffer;
            b = sink;
            return;
        }
    }

    static boolean a(RealBufferedSink realbufferedsink)
    {
        return realbufferedsink.c;
    }

    public final long a(Source source)
    {
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = source.b(a, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                r();
            } else
            {
                return l;
            }
        } while (true);
    }

    public final Timeout a()
    {
        return b.a();
    }

    public final void a(Buffer buffer, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(buffer, l);
            r();
            return;
        }
    }

    public final BufferedSink b(String s1)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(s1);
            return r();
        }
    }

    public final BufferedSink b(ByteString bytestring)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(bytestring);
            return r();
        }
    }

    public final BufferedSink b(byte abyte0[])
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(abyte0);
            return r();
        }
    }

    public final void b()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b > 0L)
        {
            b.a(a, a.b);
        }
        b.b();
    }

    public final BufferedSink c(byte abyte0[], int i, int j)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(abyte0, i, j);
            return r();
        }
    }

    public final void close()
    {
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        throwable = throwable1;
        if (a.b <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        b.a(a, a.b);
        throwable = throwable1;
_L4:
        b.close();
        throwable1 = throwable;
_L3:
        c = true;
        if (throwable1 != null)
        {
            Util.a(throwable1);
            return;
        }
          goto _L1
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L3
        throwable;
          goto _L4
    }

    public final Buffer d()
    {
        return a;
    }

    public final BufferedSink d(int i)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(i);
            return r();
        }
    }

    public final OutputStream e()
    {
        return new _cls1();
    }

    public final BufferedSink e(int i)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(i);
            return r();
        }
    }

    public final BufferedSink r()
    {
        Object obj;
        long l1;
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        obj = a;
        l1 = ((Buffer) (obj)).b;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L4:
        if (l > 0L)
        {
            b.a(a, l);
        }
        return this;
_L2:
        obj = ((Buffer) (obj)).a.e;
        l = l1;
        if (((Segment) (obj)).c < 2048)
        {
            l = l1 - (long)(((Segment) (obj)).c - ((Segment) (obj)).b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final BufferedSink s()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.p();
            return r();
        }
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }

    private class _cls1 extends OutputStream
    {

        final RealBufferedSink a;

        public void close()
        {
            a.close();
        }

        public void flush()
        {
            if (!RealBufferedSink.a(a))
            {
                a.b();
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append(a).append(".outputStream()").toString();
        }

        public void write(int i)
        {
            if (RealBufferedSink.a(a))
            {
                throw new IOException("closed");
            } else
            {
                a.a.a((byte)i);
                a.r();
                return;
            }
        }

        public void write(byte abyte0[], int i, int j)
        {
            if (RealBufferedSink.a(a))
            {
                throw new IOException("closed");
            } else
            {
                a.a.b(abyte0, i, j);
                a.r();
                return;
            }
        }

        _cls1()
        {
            a = RealBufferedSink.this;
            super();
        }
    }

}
