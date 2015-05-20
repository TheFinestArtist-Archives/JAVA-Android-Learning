// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.seismic;


class 
{

    private final d a = new init>();
    private init> b;
    private init> c;
    private int d;
    private int e;

    final void a()
    {
        while (b != null) 
        {
              = b;
            b = .b;
            a.();
        }
        c = null;
        d = 0;
        e = 0;
    }

    final void a(long l, boolean flag)
    {
        while (d >= 4 && b != null && l - 0x1dcd6500L - b.b > 0L) 
        {
            e e1 = b;
            if (e1.b)
            {
                e = e - 1;
            }
            d = d - 1;
            b = e1.b;
            if (b == null)
            {
                c = null;
            }
            a.(e1);
        }
        e e2 = a.();
        e2. = l;
        e2. = flag;
        e2. = null;
        if (c != null)
        {
            c.c = e2;
        }
        c = e2;
        if (b == null)
        {
            b = e2;
        }
        d = d + 1;
        if (flag)
        {
            e = e + 1;
        }
    }

    final boolean b()
    {
        return c != null && b != null && c.c - b.b >= 0xee6b280L && e >= (d >> 1) + (d >> 2);
    }

    ()
    {
    }
}
