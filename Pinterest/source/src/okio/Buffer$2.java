// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.InputStream;

// Referenced classes of package okio:
//            Buffer

class tream extends InputStream
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

    public int read(byte abyte0[], int i, int j)
    {
        return a.a(abyte0, i, j);
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(".inputStream()").toString();
    }

    ng(Buffer buffer)
    {
        a = buffer;
        super();
    }
}
