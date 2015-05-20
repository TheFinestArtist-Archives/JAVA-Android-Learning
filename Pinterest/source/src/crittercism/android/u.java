// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.OutputStream;

// Referenced classes of package crittercism.android:
//            b

public final class u extends OutputStream
{

    private final OutputStream a;
    private final b b;

    public u(OutputStream outputstream, b b1)
    {
        if (outputstream == null)
        {
            throw new NullPointerException("delegate was null");
        }
        if (b1 == null)
        {
            throw new NullPointerException("stats were null");
        } else
        {
            a = outputstream;
            b = b1;
            return;
        }
    }

    public final void close()
    {
        a.close();
    }

    public final void flush()
    {
        a.flush();
    }

    public final void write(int i)
    {
        try
        {
            if (b != null)
            {
                b.b();
                b.c(1L);
            }
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable) { }
        a.write(i);
    }

    public final void write(byte abyte0[])
    {
        if (b != null)
        {
            b.b();
            if (abyte0 != null)
            {
                b.c(abyte0.length);
            }
        }
        a.write(abyte0);
    }

    public final void write(byte abyte0[], int i, int j)
    {
        if (b != null)
        {
            b.b();
            if (abyte0 != null)
            {
                b.c(j);
            }
        }
        a.write(abyte0, i, j);
    }
}
