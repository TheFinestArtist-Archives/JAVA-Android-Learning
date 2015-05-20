// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;


final class c
{

    private final c a[];
    private final int b;
    private final int c;

    static c[] a(c c1)
    {
        return c1.a;
    }

    static int b(a a1)
    {
        return a1.b;
    }

    static int c(b b1)
    {
        return b1.c;
    }

    ()
    {
        a = new a[256];
        b = 0;
        c = 0;
    }

    c(int i, int j)
    {
        a = null;
        b = i;
        j &= 7;
        i = j;
        if (j == 0)
        {
            i = 8;
        }
        c = i;
    }
}
