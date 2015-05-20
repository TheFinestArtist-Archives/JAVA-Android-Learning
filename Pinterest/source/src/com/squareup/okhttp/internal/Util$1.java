// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.util.concurrent.ThreadFactory;

final class a
    implements ThreadFactory
{

    final String a;
    final boolean b = true;

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, a);
        runnable.setDaemon(b);
        return runnable;
    }

    (String s)
    {
        a = s;
        super();
    }
}
