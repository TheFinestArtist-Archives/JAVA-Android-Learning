// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class value
    implements Future
{

    private final Object value;

    public final boolean cancel(boolean flag)
    {
        return false;
    }

    public final Object get()
    {
        return value;
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return value;
    }

    public final boolean isCancelled()
    {
        return false;
    }

    public final boolean isDone()
    {
        return true;
    }

    (Object obj)
    {
        value = obj;
    }
}
