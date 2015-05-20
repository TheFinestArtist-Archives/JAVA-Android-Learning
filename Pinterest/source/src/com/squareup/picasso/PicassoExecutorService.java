// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter

class PicassoExecutorService extends ThreadPoolExecutor
{

    PicassoExecutorService()
    {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new Utils.PicassoThreadFactory());
    }

    private void a(int i)
    {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    final void a(NetworkInfo networkinfo)
    {
        if (networkinfo == null || !networkinfo.isConnectedOrConnecting())
        {
            a(3);
            return;
        }
        switch (networkinfo.getType())
        {
        default:
            a(3);
            return;

        case 1: // '\001'
        case 6: // '\006'
        case 9: // '\t'
            a(4);
            return;

        case 0: // '\0'
            switch (networkinfo.getSubtype())
            {
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            default:
                a(3);
                return;

            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
                a(3);
                return;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 12: // '\f'
                a(2);
                return;

            case 1: // '\001'
            case 2: // '\002'
                a(1);
                return;
            }
        }
    }

    public Future submit(Runnable runnable)
    {
        runnable = new PicassoFutureTask((BitmapHunter)runnable);
        execute(runnable);
        return runnable;
    }

    private class PicassoFutureTask extends FutureTask
        implements Comparable
    {

        private final BitmapHunter a;

        public final int compareTo(Object obj)
        {
            obj = (PicassoFutureTask)obj;
            Picasso.Priority priority = a.r;
            Picasso.Priority priority1 = ((PicassoFutureTask) (obj)).a.r;
            if (priority == priority1)
            {
                return a.a - ((PicassoFutureTask) (obj)).a.a;
            } else
            {
                return priority1.ordinal() - priority.ordinal();
            }
        }

        public PicassoFutureTask(BitmapHunter bitmaphunter)
        {
            super(bitmaphunter, null);
            a = bitmaphunter;
        }
    }

}
