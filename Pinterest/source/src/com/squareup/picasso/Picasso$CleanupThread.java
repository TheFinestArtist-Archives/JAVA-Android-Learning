// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

class setName extends Thread
{

    private final ReferenceQueue a;
    private final Handler b;

    public void run()
    {
        Process.setThreadPriority(10);
        class _cls1
            implements Runnable
        {

            final Exception a;
            final Picasso.CleanupThread b;

            public void run()
            {
                throw new RuntimeException(a);
            }

            _cls1(Exception exception)
            {
                b = Picasso.CleanupThread.this;
                a = exception;
                super();
            }
        }

        try
        {
            do
            {
                rence rence = (rence)a.remove();
                b.sendMessage(b.obtainMessage(3, rence.a));
            } while (true);
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        catch (Exception exception)
        {
            b.post(new _cls1(exception));
        }
    }

    _cls1(ReferenceQueue referencequeue, Handler handler)
    {
        a = referencequeue;
        b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }
}
