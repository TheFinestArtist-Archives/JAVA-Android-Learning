// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package okio:
//            RealBufferedSink, Buffer

class it> extends OutputStream
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

    (RealBufferedSink realbufferedsink)
    {
        a = realbufferedsink;
        super();
    }
}
