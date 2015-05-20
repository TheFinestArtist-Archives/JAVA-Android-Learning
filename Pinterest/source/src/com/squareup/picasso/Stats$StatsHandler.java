// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.squareup.picasso:
//            Picasso, Stats

class a extends Handler
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
                final Stats.StatsHandler b;

                public void run()
                {
                    throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
                }

            _cls1(Message message)
            {
                b = Stats.StatsHandler.this;
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
            long l = message.arg1;
            stats.m = stats.m + 1;
            stats.g = l + stats.g;
            int i = stats.m;
            stats.j = stats.g / (long)i;
            return;

        case 3: // '\003'
            Stats stats1 = a;
            long l1 = message.arg1;
            stats1.n = stats1.n + 1;
            stats1.h = l1 + stats1.h;
            int j = stats1.m;
            stats1.k = stats1.h / (long)j;
            return;

        case 4: // '\004'
            stats2 = a;
            break;
        }
        message = (Long)message.obj;
        stats2.l = stats2.l + 1;
        stats2.f = stats2.f + message.longValue();
        int k = stats2.l;
        stats2.i = stats2.f / (long)k;
    }

    public _cls1(Looper looper, Stats stats)
    {
        super(looper);
        a = stats;
    }
}
