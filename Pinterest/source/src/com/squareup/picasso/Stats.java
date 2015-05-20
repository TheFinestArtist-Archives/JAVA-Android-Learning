// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

// Referenced classes of package com.squareup.picasso:
//            Utils, Cache

class Stats
{

    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final Cache b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    Stats(Cache cache)
    {
        b = cache;
        a.start();
        c = new StatsHandler(a.getLooper(), this);
    }

    private void a(Bitmap bitmap, int i1)
    {
        int j1 = Utils.a(bitmap);
        c.sendMessage(c.obtainMessage(i1, j1, 0));
    }

    final void a()
    {
        c.sendEmptyMessage(0);
    }

    final void a(Bitmap bitmap)
    {
        a(bitmap, 2);
    }

    final void b(Bitmap bitmap)
    {
        a(bitmap, 3);
    }

    private class StatsHandler extends Handler
    {

        private final Stats a;

        public void handleMessage(Message message)
        {
            Stats stats2;
            switch (message.what)
            {
            default:
                class _cls1
                    implements Runnable
                {

                    final Message a;
                    final StatsHandler b;

                    public void run()
                    {
                        throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
                    }

                _cls1(Message message)
                {
                    b = StatsHandler.this;
                    a = message;
                    super();
                }
                }

                Picasso.a.post(new _cls1(message));
                return;

            case 0: // '\0'
                message = a;
                message.d = ((Stats) (message)).d + 1L;
                return;

            case 1: // '\001'
                message = a;
                message.e = ((Stats) (message)).e + 1L;
                return;

            case 2: // '\002'
                Stats stats = a;
                long l1 = message.arg1;
                stats.m = stats.m + 1;
                stats.g = l1 + stats.g;
                int i1 = stats.m;
                stats.j = stats.g / (long)i1;
                return;

            case 3: // '\003'
                Stats stats1 = a;
                long l2 = message.arg1;
                stats1.n = stats1.n + 1;
                stats1.h = l2 + stats1.h;
                int j1 = stats1.m;
                stats1.k = stats1.h / (long)j1;
                return;

            case 4: // '\004'
                stats2 = a;
                break;
            }
            message = (Long)message.obj;
            stats2.l = stats2.l + 1;
            stats2.f = stats2.f + message.longValue();
            int k1 = stats2.l;
            stats2.i = stats2.f / (long)k1;
        }

        public StatsHandler(Looper looper, Stats stats)
        {
            super(looper);
            a = stats;
        }
    }

}
