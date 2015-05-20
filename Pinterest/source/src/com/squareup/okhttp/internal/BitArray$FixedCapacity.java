// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;


// Referenced classes of package com.squareup.okhttp.internal:
//            BitArray

public final class a
    implements BitArray
{

    long a;

    private static int a(int i)
    {
        if (i < 0 || i > 63)
        {
            throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return i;
        }
    }

    public final BitArray a()
    {
        return new ty(this, (byte)0);
    }

    public final void clear()
    {
        a = 0L;
    }

    public final boolean get(int i)
    {
        return (a >> a(i) & 1L) == 1L;
    }

    public final void set(int i)
    {
        a = a | 1L << a(i);
    }

    public final void shiftLeft(int i)
    {
        a = a << a(i);
    }

    public final String toString()
    {
        return Long.toBinaryString(a);
    }

    public final void toggle(int i)
    {
        a = a ^ 1L << a(i);
    }

    public ty()
    {
        a = 0L;
    }
}
