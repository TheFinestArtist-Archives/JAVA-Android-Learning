// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.util.zip.Deflater;

// Referenced classes of package okio:
//            Sink, Okio, BufferedSink, Buffer, 
//            Segment, Util, SegmentPool, Timeout

public final class DeflaterSink
    implements Sink
{

    private final BufferedSink a;
    private final Deflater b;
    private boolean c;

    private DeflaterSink(BufferedSink bufferedsink, Deflater deflater)
    {
        if (bufferedsink == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = bufferedsink;
            b = deflater;
            return;
        }
    }

    public DeflaterSink(Sink sink, Deflater deflater)
    {
        this(Okio.a(sink), deflater);
    }

    private void a(boolean flag)
    {
        Buffer buffer = a.d();
label0:
        do
        {
            do
            {
                Segment segment = buffer.c(1);
                int i;
                if (flag)
                {
                    i = b.deflate(segment.a, segment.c, 2048 - segment.c, 2);
                } else
                {
                    i = b.deflate(segment.a, segment.c, 2048 - segment.c);
                }
                if (i <= 0)
                {
                    continue label0;
                }
                segment.c = segment.c + i;
                buffer.b = buffer.b + (long)i;
                a.r();
            } while (true);
        } while (!b.needsInput());
    }

    public final Timeout a()
    {
        return a.a();
    }

    public final void a(Buffer buffer, long l)
    {
        Util.a(buffer.b, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            Segment segment = buffer.a;
            i = (int)Math.min(l, segment.c - segment.b);
            b.setInput(segment.a, segment.b, i);
            a(false);
            buffer.b = buffer.b - (long)i;
            segment.b = segment.b + i;
            if (segment.b == segment.c)
            {
                buffer.a = segment.a();
                SegmentPool.a.a(segment);
            }
        }

    }

    public final void b()
    {
        a(true);
        a.b();
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
        try
        {
            b.finish();
            a(false);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        b.end();
        throwable = throwable1;
_L3:
        a.close();
        throwable1 = throwable;
_L4:
        c = true;
        if (throwable1 != null)
        {
            Util.a(throwable1);
            return;
        }
          goto _L1
        throwable;
        if (throwable1 != null)
        {
            throwable = throwable1;
        }
          goto _L3
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public final String toString()
    {
        return (new StringBuilder("DeflaterSink(")).append(a).append(")").toString();
    }
}
