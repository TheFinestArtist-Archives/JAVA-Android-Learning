// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package okio:
//            RealBufferedSource, Buffer, Source, Util

class  extends InputStream
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

    public int read(byte abyte0[], int i, int j)
    {
        if (RealBufferedSource.a(a))
        {
            throw new IOException("closed");
        }
        Util.a(abyte0.length, i, j);
        if (a.a.b == 0L && a.b.b(a.a, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return a.a.a(abyte0, i, j);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(".inputStream()").toString();
    }

    (RealBufferedSource realbufferedsource)
    {
        a = realbufferedsource;
        super();
    }
}
