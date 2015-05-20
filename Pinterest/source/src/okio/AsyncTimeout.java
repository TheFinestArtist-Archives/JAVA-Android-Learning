// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package okio:
//            Timeout

public class AsyncTimeout extends Timeout
{

    private static AsyncTimeout a;
    private boolean c;
    private AsyncTimeout d;
    private long e;

    public AsyncTimeout()
    {
    }

    private static void a(AsyncTimeout asynctimeout, long l, boolean flag)
    {
        okio/AsyncTimeout;
        JVM INSTR monitorenter ;
        long l1;
        if (a == null)
        {
            a = new AsyncTimeout();
            (new Watchdog()).start();
        }
        l1 = System.nanoTime();
        if (l == 0L || !flag) goto _L2; else goto _L1
_L1:
        asynctimeout.e = Math.min(l, asynctimeout.h() - l1) + l1;
_L3:
        l = asynctimeout.e;
        for (AsyncTimeout asynctimeout1 = a; asynctimeout1.d != null && l - l1 >= asynctimeout1.d.e - l1; asynctimeout1 = asynctimeout1.d)
        {
            break MISSING_BLOCK_LABEL_177;
        }

        asynctimeout.d = asynctimeout1.d;
        asynctimeout1.d = asynctimeout;
        if (asynctimeout1 == a)
        {
            okio/AsyncTimeout.notify();
        }
        okio/AsyncTimeout;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        asynctimeout.e = l1 + l;
          goto _L3
        asynctimeout;
        throw asynctimeout;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        asynctimeout.e = asynctimeout.h();
          goto _L3
        throw new AssertionError();
    }

    private static boolean a(AsyncTimeout asynctimeout)
    {
        okio/AsyncTimeout;
        JVM INSTR monitorenter ;
        AsyncTimeout asynctimeout1 = a;
_L8:
        if (asynctimeout1 == null) goto _L2; else goto _L1
_L1:
        if (asynctimeout1.d != asynctimeout) goto _L4; else goto _L3
_L3:
        asynctimeout1.d = asynctimeout.d;
        asynctimeout.d = null;
        boolean flag = false;
_L6:
        okio/AsyncTimeout;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        asynctimeout1 = asynctimeout1.d;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        asynctimeout;
        throw asynctimeout;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static AsyncTimeout b()
    {
        Object obj = null;
        okio/AsyncTimeout;
        JVM INSTR monitorenter ;
        AsyncTimeout asynctimeout = a.d;
        if (asynctimeout != null) goto _L2; else goto _L1
_L1:
        okio/AsyncTimeout.wait();
_L4:
        okio/AsyncTimeout;
        JVM INSTR monitorexit ;
        return ((AsyncTimeout) (obj));
_L2:
        long l;
        l = System.nanoTime();
        l = asynctimeout.e - l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        long l1 = l / 0xf4240L;
        okio/AsyncTimeout.wait(l1, (int)(l - 0xf4240L * l1));
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        a.d = asynctimeout.d;
        asynctimeout.d = null;
        obj = asynctimeout;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static AsyncTimeout e()
    {
        return b();
    }

    final IOException a(IOException ioexception)
    {
        if (!d())
        {
            return ioexception;
        } else
        {
            InterruptedIOException interruptedioexception = new InterruptedIOException("timeout");
            interruptedioexception.initCause(ioexception);
            return interruptedioexception;
        }
    }

    protected void a()
    {
    }

    final void a(boolean flag)
    {
        if (d() && flag)
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    public final void c()
    {
        if (c)
        {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l = f();
        boolean flag = g();
        if (l == 0L && !flag)
        {
            return;
        } else
        {
            c = true;
            a(this, l, flag);
            return;
        }
    }

    public final boolean d()
    {
        if (!c)
        {
            return false;
        } else
        {
            c = false;
            return a(this);
        }
    }

    private class Watchdog extends Thread
    {

        public final void run()
        {
            do
            {
                AsyncTimeout asynctimeout;
                do
                {
                    asynctimeout = AsyncTimeout.e();
                } while (asynctimeout == null);
                try
                {
                    asynctimeout.a();
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

        public Watchdog()
        {
            super("Okio Watchdog");
            setDaemon(true);
        }
    }

}
