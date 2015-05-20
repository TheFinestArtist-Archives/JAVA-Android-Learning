// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.squareup.picasso:
//            RequestCreator

final class b
    implements Runnable
{

    final AtomicInteger a;
    final CountDownLatch b;

    public final void run()
    {
        a.set(RequestCreator.e());
        b.countDown();
    }

    ger(AtomicInteger atomicinteger, CountDownLatch countdownlatch)
    {
        a = atomicinteger;
        b = countdownlatch;
        super();
    }
}
