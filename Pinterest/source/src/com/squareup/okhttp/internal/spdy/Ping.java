// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.concurrent.CountDownLatch;

public final class Ping
{

    private final CountDownLatch a = new CountDownLatch(1);
    private long b;
    private long c;

    Ping()
    {
        b = -1L;
        c = -1L;
    }

    final void a()
    {
        if (b != -1L)
        {
            throw new IllegalStateException();
        } else
        {
            b = System.nanoTime();
            return;
        }
    }

    final void b()
    {
        if (c != -1L || b == -1L)
        {
            throw new IllegalStateException();
        } else
        {
            c = System.nanoTime();
            a.countDown();
            return;
        }
    }

    final void c()
    {
        if (c != -1L || b == -1L)
        {
            throw new IllegalStateException();
        } else
        {
            c = b - 1L;
            a.countDown();
            return;
        }
    }
}
