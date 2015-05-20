// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout
{

    public static final Timeout b = new _cls1();
    private boolean a;
    private long c;
    private long d;

    public Timeout()
    {
    }

    public Timeout a(long l, TimeUnit timeunit)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("timeout < 0: ")).append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            d = timeunit.toNanos(l);
            return this;
        }
    }

    public final long f()
    {
        return d;
    }

    public final boolean g()
    {
        return a;
    }

    public final long h()
    {
        if (!a)
        {
            throw new IllegalStateException("No deadline");
        } else
        {
            return c;
        }
    }

    public void i()
    {
        if (Thread.interrupted())
        {
            throw new InterruptedIOException();
        }
        if (a && System.nanoTime() > c)
        {
            throw new IOException("deadline reached");
        } else
        {
            return;
        }
    }


    private class _cls1 extends Timeout
    {

        public final Timeout a(long l, TimeUnit timeunit)
        {
            return this;
        }

        public final void i()
        {
        }

        _cls1()
        {
        }
    }

}
