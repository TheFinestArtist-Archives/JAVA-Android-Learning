// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package okio:
//            Source, Okio, BufferedSource, Buffer, 
//            Segment, Timeout

public final class InflaterSource
    implements Source
{

    private final BufferedSource a;
    private final Inflater b;
    private int c;
    private boolean d;

    InflaterSource(BufferedSource bufferedsource, Inflater inflater)
    {
        if (bufferedsource == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = bufferedsource;
            b = inflater;
            return;
        }
    }

    public InflaterSource(Source source, Inflater inflater)
    {
        this(Okio.a(source), inflater);
    }

    private void c()
    {
        if (c == 0)
        {
            return;
        } else
        {
            int i = c - b.getRemaining();
            c = c - i;
            a.g(i);
            return;
        }
    }

    public final Timeout a()
    {
        return a.a();
    }

    public final long b(Buffer buffer, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (d)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = b();
        Segment segment;
        int i;
        try
        {
            segment = buffer.c(1);
            i = b.inflate(segment.a, segment.c, 2048 - segment.c);
        }
        // Misplaced declaration of an exception variable
        catch (Buffer buffer)
        {
            throw new IOException(buffer);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        segment.c = segment.c + i;
        buffer.b = buffer.b + (long)i;
        return (long)i;
        if (!b.finished() && !b.needsDictionary())
        {
            continue; /* Loop/switch isn't completed */
        }
        c();
        return -1L;
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b()
    {
        if (!b.needsInput())
        {
            return false;
        }
        c();
        if (b.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (a.f())
        {
            return true;
        } else
        {
            Segment segment = a.d().a;
            c = segment.c - segment.b;
            b.setInput(segment.a, segment.b, c);
            return false;
        }
    }

    public final void close()
    {
        if (d)
        {
            return;
        } else
        {
            b.end();
            d = true;
            a.close();
            return;
        }
    }
}
