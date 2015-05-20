// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package okio:
//            BufferedSink, BufferedSource, Segment, SegmentPool, 
//            Source, Util, ByteString, Timeout

public final class Buffer
    implements Cloneable, BufferedSink, BufferedSource
{

    Segment a;
    long b;

    public Buffer()
    {
    }

    final int a(byte abyte0[], int i1, int j1)
    {
        Segment segment = a;
        if (segment == null)
        {
            i1 = -1;
        } else
        {
            j1 = Math.min(j1, segment.c - segment.b);
            System.arraycopy(segment.a, segment.b, abyte0, i1, j1);
            segment.b = segment.b + j1;
            b = b - (long)j1;
            i1 = j1;
            if (segment.b == segment.c)
            {
                a = segment.a();
                SegmentPool.a.a(segment);
                return j1;
            }
        }
        return i1;
    }

    public final long a(byte byte0)
    {
        return a(byte0, 0L);
    }

    public final long a(byte byte0, long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = a;
        if (segment == null)
        {
            return -1L;
        }
        long l2 = 0L;
        do
        {
            int i1 = segment.c - segment.b;
            Segment segment1;
            if (l1 >= (long)i1)
            {
                l1 -= i1;
            } else
            {
                byte abyte0[] = segment.a;
                l1 = (long)segment.b + l1;
                for (long l3 = segment.c; l1 < l3; l1++)
                {
                    if (abyte0[(int)l1] == byte0)
                    {
                        return (l2 + l1) - (long)segment.b;
                    }
                }

                l1 = 0L;
            }
            l2 += i1;
            segment1 = segment.d;
            segment = segment1;
        } while (segment1 != a);
        return -1L;
    }

    public final long a(Source source)
    {
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l1 = 0L;
        do
        {
            long l2 = source.b(this, 2048L);
            if (l2 != -1L)
            {
                l1 += l2;
            } else
            {
                return l1;
            }
        } while (true);
    }

    public final Buffer a(int i1)
    {
        Segment segment = c(1);
        byte abyte0[] = segment.a;
        int j1 = segment.c;
        segment.c = j1 + 1;
        abyte0[j1] = (byte)i1;
        b = b + 1L;
        return this;
    }

    public final Buffer a(OutputStream outputstream, long l1, long l2)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        Util.a(b, l1, l2);
        if (l2 != 0L)
        {
            Segment segment = a;
            Segment segment1;
            long l3;
            long l4;
            do
            {
                segment1 = segment;
                l3 = l1;
                l4 = l2;
                if (l1 < (long)(segment.c - segment.b))
                {
                    break;
                }
                l1 -= segment.c - segment.b;
                segment = segment.d;
            } while (true);
            while (l4 > 0L) 
            {
                int i1 = (int)((long)segment1.b + l3);
                int j1 = (int)Math.min(segment1.c - i1, l4);
                outputstream.write(segment1.a, i1, j1);
                l4 -= j1;
                segment1 = segment1.d;
                l3 = 0L;
            }
        }
        return this;
    }

    public final Buffer a(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        java.nio.charset.Charset charset = Util.a;
        if (s1 == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        } else
        {
            s1 = s1.getBytes(charset);
            return b(s1, 0, s1.length);
        }
    }

    public final Buffer a(ByteString bytestring)
    {
        if (bytestring == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            return b(bytestring.b, 0, bytestring.b.length);
        }
    }

    public final Buffer a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return b(abyte0, 0, abyte0.length);
        }
    }

    public final Timeout a()
    {
        return Timeout.b;
    }

    public final void a(long l1)
    {
        if (b < l1)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final void a(Buffer buffer, long l1)
    {
        if (buffer == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        Util.a(buffer.b, 0L, l1);
_L5:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        if (l1 >= (long)(buffer.a.c - buffer.a.b)) goto _L2; else goto _L1
_L1:
        Segment segment;
        if (a != null)
        {
            segment = a.e;
        } else
        {
            segment = null;
        }
        if (segment != null && (long)(segment.c - segment.b) + l1 <= 2048L) goto _L4; else goto _L3
_L3:
        segment = buffer.a;
        int i1 = (int)l1;
        int j1 = segment.c - segment.b - i1;
        if (i1 <= 0 || j1 <= 0)
        {
            throw new IllegalArgumentException();
        }
        Segment segment2;
        Segment segment4;
        long l2;
        if (i1 < j1)
        {
            Segment segment1 = SegmentPool.a.a();
            System.arraycopy(segment.a, segment.b, segment1.a, segment1.b, i1);
            segment.b = segment.b + i1;
            segment1.c = i1 + segment1.c;
            segment.e.a(segment1);
            segment = segment1;
        } else
        {
            Segment segment3 = SegmentPool.a.a();
            System.arraycopy(segment.a, i1 + segment.b, segment3.a, segment3.b, j1);
            segment.c = segment.c - j1;
            segment3.c = j1 + segment3.c;
            segment.a(segment3);
        }
        buffer.a = segment;
_L2:
        segment = buffer.a;
        l2 = segment.c - segment.b;
        buffer.a = segment.a();
        if (a == null)
        {
            a = segment;
            segment = a;
            segment2 = a;
            segment4 = a;
            segment2.e = segment4;
            segment.d = segment4;
        } else
        {
            segment = a.e.a(segment);
            if (segment.e == segment)
            {
                throw new IllegalStateException();
            }
            if ((segment.e.c - segment.e.b) + (segment.c - segment.b) <= 2048)
            {
                segment.a(segment.e, segment.c - segment.b);
                segment.a();
                SegmentPool.a.a(segment);
            }
        }
        buffer.b = buffer.b - l2;
        b = b + l2;
        l1 -= l2;
        if (true) goto _L5; else goto _L4
_L4:
        buffer.a.a(segment, (int)l1);
        buffer.b = buffer.b - l1;
        b = b + l1;
    }

    public final byte b(long l1)
    {
        Util.a(b, l1, 1L);
        Segment segment = a;
        do
        {
            int i1 = segment.c - segment.b;
            if (l1 < (long)i1)
            {
                return segment.a[segment.b + (int)l1];
            }
            l1 -= i1;
            segment = segment.d;
        } while (true);
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
        if (b == 0L)
        {
            return -1L;
        }
        long l2 = l1;
        if (l1 > b)
        {
            l2 = b;
        }
        buffer.a(this, l2);
        return l2;
    }

    public final Buffer b(int i1)
    {
        Segment segment = c(4);
        byte abyte0[] = segment.a;
        int k1 = segment.c;
        int j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 24 & 0xff);
        k1 = j1 + 1;
        abyte0[j1] = (byte)(i1 >>> 16 & 0xff);
        j1 = k1 + 1;
        abyte0[k1] = (byte)(i1 >>> 8 & 0xff);
        abyte0[j1] = (byte)(i1 & 0xff);
        segment.c = j1 + 1;
        b = b + 4L;
        return this;
    }

    public final Buffer b(byte abyte0[], int i1, int j1)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        Util.a(abyte0.length, i1, j1);
        for (int k1 = i1 + j1; i1 < k1;)
        {
            Segment segment = c(1);
            int l1 = Math.min(k1 - i1, 2048 - segment.c);
            System.arraycopy(abyte0, i1, segment.a, segment.c, l1);
            i1 += l1;
            segment.c = l1 + segment.c;
        }

        b = b + (long)j1;
        return this;
    }

    public final BufferedSink b(String s1)
    {
        return a(s1);
    }

    public final BufferedSink b(ByteString bytestring)
    {
        return a(bytestring);
    }

    public final BufferedSink b(byte abyte0[])
    {
        return a(abyte0);
    }

    public final void b()
    {
    }

    public final long c()
    {
        return b;
    }

    public final BufferedSink c(byte abyte0[], int i1, int j1)
    {
        return b(abyte0, i1, j1);
    }

    public final ByteString c(long l1)
    {
        return new ByteString(f(l1));
    }

    final Segment c(int i1)
    {
        if (i1 <= 0 || i1 > 2048)
        {
            throw new IllegalArgumentException();
        }
        Segment segment;
        if (a == null)
        {
            a = SegmentPool.a.a();
            Segment segment1 = a;
            Segment segment3 = a;
            segment = a;
            segment3.e = segment;
            segment1.d = segment;
        } else
        {
            Segment segment2 = a.e;
            segment = segment2;
            if (segment2.c + i1 > 2048)
            {
                return segment2.a(SegmentPool.a.a());
            }
        }
        return segment;
    }

    public final Object clone()
    {
        return q();
    }

    public final void close()
    {
    }

    public final String d(long l1)
    {
        Object obj = Util.a;
        Util.a(b, 0L, l1);
        if (obj == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l1).toString());
        }
        if (l1 == 0L)
        {
            obj = "";
        } else
        {
            Segment segment = a;
            if ((long)segment.b + l1 > (long)segment.c)
            {
                return new String(f(l1), ((java.nio.charset.Charset) (obj)));
            }
            String s1 = new String(segment.a, segment.b, (int)l1, ((java.nio.charset.Charset) (obj)));
            segment.b = (int)((long)segment.b + l1);
            b = b - l1;
            obj = s1;
            if (segment.b == segment.c)
            {
                a = segment.a();
                SegmentPool.a.a(segment);
                return s1;
            }
        }
        return ((String) (obj));
    }

    public final Buffer d()
    {
        return this;
    }

    public final BufferedSink d(int i1)
    {
        return b(i1);
    }

    public final OutputStream e()
    {
        return new _cls1();
    }

    final String e(long l1)
    {
        if (l1 > 0L && b(l1 - 1L) == 13)
        {
            String s1 = d(l1 - 1L);
            g(2L);
            return s1;
        } else
        {
            String s2 = d(l1);
            g(1L);
            return s2;
        }
    }

    public final BufferedSink e(int i1)
    {
        return a(i1);
    }

    public final boolean equals(Object obj)
    {
        long l2 = 0L;
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Buffer))
        {
            return false;
        }
        obj = (Buffer)obj;
        if (b != ((Buffer) (obj)).b)
        {
            return false;
        }
        if (b == 0L)
        {
            return true;
        }
        Segment segment1 = a;
        obj = ((Buffer) (obj)).a;
        int j1 = segment1.b;
        int i1 = ((Segment) (obj)).b;
        while (l2 < b) 
        {
            long l3 = Math.min(segment1.c - j1, ((Segment) (obj)).c - i1);
            for (int k1 = 0; (long)k1 < l3;)
            {
                if (segment1.a[j1] != ((Segment) (obj)).a[i1])
                {
                    return false;
                }
                k1++;
                i1++;
                j1++;
            }

            int l1 = j1;
            Segment segment = segment1;
            if (j1 == segment1.c)
            {
                segment = segment1.d;
                l1 = segment.b;
            }
            j1 = i1;
            Object obj1 = obj;
            if (i1 == ((Segment) (obj)).c)
            {
                obj1 = ((Segment) (obj)).d;
                j1 = ((Segment) (obj1)).b;
            }
            l2 += l3;
            i1 = j1;
            j1 = l1;
            segment1 = segment;
            obj = obj1;
        }
        return true;
    }

    public final boolean f()
    {
        return b == 0L;
    }

    public final byte[] f(long l1)
    {
        Util.a(b, 0L, l1);
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount > Integer.MAX_VALUE: ")).append(l1).toString());
        }
        int i1 = 0;
        byte abyte0[] = new byte[(int)l1];
        do
        {
            if ((long)i1 >= l1)
            {
                break;
            }
            int k1 = (int)Math.min(l1 - (long)i1, a.c - a.b);
            System.arraycopy(a.a, a.b, abyte0, i1, k1);
            int j1 = i1 + k1;
            Segment segment = a;
            segment.b = k1 + segment.b;
            i1 = j1;
            if (a.b == a.c)
            {
                Segment segment1 = a;
                a = segment1.a();
                SegmentPool.a.a(segment1);
                i1 = j1;
            }
        } while (true);
        b = b - l1;
        return abyte0;
    }

    public final InputStream g()
    {
        return new _cls2();
    }

    public final void g(long l1)
    {
        Util.a(b, 0L, l1);
        b = b - l1;
        do
        {
            if (l1 <= 0L)
            {
                break;
            }
            int i1 = (int)Math.min(l1, a.c - a.b);
            long l2 = l1 - (long)i1;
            Segment segment = a;
            segment.b = i1 + segment.b;
            l1 = l2;
            if (a.b == a.c)
            {
                Segment segment1 = a;
                a = segment1.a();
                SegmentPool.a.a(segment1);
                l1 = l2;
            }
        } while (true);
    }

    public final byte h()
    {
        if (b == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = a;
        int i1 = segment.b;
        int j1 = segment.c;
        byte abyte0[] = segment.a;
        int k1 = i1 + 1;
        byte byte0 = abyte0[i1];
        b = b - 1L;
        if (k1 == j1)
        {
            a = segment.a();
            SegmentPool.a.a(segment);
            return byte0;
        } else
        {
            segment.b = k1;
            return byte0;
        }
    }

    public final int hashCode()
    {
        Segment segment = a;
        if (segment == null)
        {
            return 0;
        }
        int j1 = 1;
        Segment segment1;
        int i1;
        do
        {
            int k1 = segment.b;
            int l1 = segment.c;
            for (i1 = j1; k1 < l1; i1 = j1 + i1 * 31)
            {
                j1 = segment.a[k1];
                k1++;
            }

            segment1 = segment.d;
            j1 = i1;
            segment = segment1;
        } while (segment1 != a);
        return i1;
    }

    public final short i()
    {
        if (b < 2L)
        {
            throw new IllegalStateException((new StringBuilder("size < 2: ")).append(b).toString());
        }
        Segment segment = a;
        int k1 = segment.b;
        int i1 = segment.c;
        if (i1 - k1 < 2)
        {
            return (short)((h() & 0xff) << 8 | h() & 0xff);
        }
        byte abyte0[] = segment.a;
        int j1 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = j1 + 1;
        j1 = abyte0[j1];
        b = b - 2L;
        if (l1 == i1)
        {
            a = segment.a();
            SegmentPool.a.a(segment);
        } else
        {
            segment.b = l1;
        }
        return (short)((k1 & 0xff) << 8 | j1 & 0xff);
    }

    public final int j()
    {
        if (b < 4L)
        {
            throw new IllegalStateException((new StringBuilder("size < 4: ")).append(b).toString());
        }
        Segment segment = a;
        int j1 = segment.b;
        int i1 = segment.c;
        if (i1 - j1 < 4)
        {
            return (h() & 0xff) << 24 | (h() & 0xff) << 16 | (h() & 0xff) << 8 | h() & 0xff;
        }
        byte abyte0[] = segment.a;
        int k1 = j1 + 1;
        j1 = abyte0[j1];
        int i2 = k1 + 1;
        k1 = abyte0[k1];
        int l1 = i2 + 1;
        byte byte0 = abyte0[i2];
        i2 = l1 + 1;
        j1 = (j1 & 0xff) << 24 | (k1 & 0xff) << 16 | (byte0 & 0xff) << 8 | abyte0[l1] & 0xff;
        b = b - 4L;
        if (i2 == i1)
        {
            a = segment.a();
            SegmentPool.a.a(segment);
            return j1;
        } else
        {
            segment.b = i2;
            return j1;
        }
    }

    public final short k()
    {
        return Util.a(i());
    }

    public final int l()
    {
        return Util.a(j());
    }

    public final String m()
    {
        long l1 = a((byte)10, 0L);
        if (l1 == -1L)
        {
            throw new EOFException();
        } else
        {
            return e(l1);
        }
    }

    public final byte[] n()
    {
        return f(b);
    }

    public final void o()
    {
        g(b);
    }

    public final Buffer p()
    {
        Segment segment = c(2);
        byte abyte0[] = segment.a;
        int i1 = segment.c;
        int j1 = i1 + 1;
        abyte0[i1] = 0;
        abyte0[j1] = 0;
        segment.c = j1 + 1;
        b = b + 2L;
        return this;
    }

    public final Buffer q()
    {
        Buffer buffer = new Buffer();
        if (b == 0L)
        {
            return buffer;
        }
        buffer.b(a.a, a.b, a.c - a.b);
        for (Segment segment = a.d; segment != a; segment = segment.d)
        {
            buffer.b(segment.a, segment.b, segment.c - segment.b);
        }

        return buffer;
    }

    public final volatile BufferedSink r()
    {
        return this;
    }

    public final BufferedSink s()
    {
        return p();
    }

    public final String toString()
    {
        if (b == 0L)
        {
            return "Buffer[size=0]";
        }
        if (b <= 16L)
        {
            ByteString bytestring = q().c(b);
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(b), bytestring.c()
            });
        }
        String s1;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(a.a, a.b, a.c - a.b);
            for (Segment segment = a.d; segment != a; segment = segment.d)
            {
                messagedigest.update(segment.a, segment.b, segment.c - segment.b);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s1 = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(b), ByteString.a(messagedigest.digest()).c()
        });
        return s1;
    }

    private class _cls1 extends OutputStream
    {

        final Buffer a;

        public void close()
        {
        }

        public void flush()
        {
        }

        public String toString()
        {
            return (new StringBuilder()).append(this).append(".outputStream()").toString();
        }

        public void write(int i1)
        {
            a.a((byte)i1);
        }

        public void write(byte abyte0[], int i1, int j1)
        {
            a.b(abyte0, i1, j1);
        }

        _cls1()
        {
            a = Buffer.this;
            super();
        }
    }


    private class _cls2 extends InputStream
    {

        final Buffer a;

        public int available()
        {
            return (int)Math.min(a.b, 0x7fffffffL);
        }

        public void close()
        {
        }

        public int read()
        {
            if (a.b > 0L)
            {
                return a.h() & 0xff;
            } else
            {
                return -1;
            }
        }

        public int read(byte abyte0[], int i1, int j1)
        {
            return a.a(abyte0, i1, j1);
        }

        public String toString()
        {
            return (new StringBuilder()).append(a).append(".inputStream()").toString();
        }

        _cls2()
        {
            a = Buffer.this;
            super();
        }
    }

}
