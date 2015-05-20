// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

// Referenced classes of package okio:
//            Source, Okio, InflaterSource, Buffer, 
//            Segment, BufferedSource, Timeout

public final class GzipSource
    implements Source
{

    private int a;
    private final BufferedSource b;
    private final Inflater c;
    private final InflaterSource d;
    private final CRC32 e = new CRC32();

    public GzipSource(Source source)
    {
        a = 0;
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            c = new Inflater(true);
            b = Okio.a(source);
            d = new InflaterSource(b, c);
            return;
        }
    }

    private static void a(String s, int i, int j)
    {
        if (j != i)
        {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] {
                s, Integer.valueOf(j), Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    private void a(Buffer buffer, long l, long l1)
    {
        buffer = buffer.a;
        Object obj;
        long l2;
        long l3;
        do
        {
            obj = buffer;
            l2 = l;
            l3 = l1;
            if (l < (long)(((Segment) (buffer)).c - ((Segment) (buffer)).b))
            {
                break;
            }
            l -= ((Segment) (buffer)).c - ((Segment) (buffer)).b;
            buffer = ((Segment) (buffer)).d;
        } while (true);
        while (l3 > 0L) 
        {
            int i = (int)((long)((Segment) (obj)).b + l2);
            int j = (int)Math.min(((Segment) (obj)).c - i, l3);
            e.update(((Segment) (obj)).a, i, j);
            l3 -= j;
            obj = ((Segment) (obj)).d;
            l2 = 0L;
        }
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
        if (l == 0L)
        {
            return 0L;
        }
        if (a == 0)
        {
            b.a(10L);
            byte byte0 = b.d().b(3L);
            boolean flag;
            if ((byte0 >> 1 & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a(b.d(), 0L, 10L);
            }
            a("ID1ID2", 8075, b.i());
            b.g(8L);
            if ((byte0 >> 2 & 1) == 1)
            {
                b.a(2L);
                if (flag)
                {
                    a(b.d(), 0L, 2L);
                }
                int i = b.d().k();
                b.a(i);
                if (flag)
                {
                    a(b.d(), 0L, i);
                }
                b.g(i);
            }
            if ((byte0 >> 3 & 1) == 1)
            {
                long l1 = b.a((byte)0);
                if (l1 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    a(b.d(), 0L, 1L + l1);
                }
                b.g(1L + l1);
            }
            if ((byte0 >> 4 & 1) == 1)
            {
                long l2 = b.a((byte)0);
                if (l2 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    a(b.d(), 0L, 1L + l2);
                }
                b.g(1L + l2);
            }
            if (flag)
            {
                a("FHCRC", b.k(), (short)(int)e.getValue());
                e.reset();
            }
            a = 1;
        }
        if (a == 1)
        {
            long l3 = buffer.b;
            l = d.b(buffer, l);
            if (l != -1L)
            {
                a(buffer, l3, l);
                return l;
            }
            a = 2;
        }
        if (a == 2)
        {
            a("CRC", b.l(), (int)e.getValue());
            a("ISIZE", b.l(), c.getTotalOut());
            a = 3;
            if (!b.f())
            {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public final void close()
    {
        d.close();
    }
}
