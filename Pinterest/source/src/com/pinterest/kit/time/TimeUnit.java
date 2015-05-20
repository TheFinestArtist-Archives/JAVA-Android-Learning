// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.time;


public final class TimeUnit extends Enum
{

    public static final TimeUnit a;
    public static final TimeUnit b;
    public static final TimeUnit c;
    public static final TimeUnit d;
    public static final TimeUnit e;
    public static final TimeUnit f;
    public static final TimeUnit g;
    private static final TimeUnit i[];
    private int h;

    private TimeUnit(String s, int j, int k)
    {
        super(s, j);
        h = k;
    }

    public static TimeUnit valueOf(String s)
    {
        return (TimeUnit)Enum.valueOf(com/pinterest/kit/time/TimeUnit, s);
    }

    public static TimeUnit[] values()
    {
        return (TimeUnit[])i.clone();
    }

    public final int a()
    {
        return h;
    }

    static 
    {
        a = new TimeUnit("SECONDS", 0, 1);
        b = new TimeUnit("MINUTES", 1, a.h * 60);
        c = new TimeUnit("HOURS", 2, b.h * 60);
        d = new TimeUnit("DAYS", 3, c.h * 24);
        e = new TimeUnit("WEEKS", 4, d.h * 7);
        f = new TimeUnit("MONTHS", 5, d.h * 30);
        g = new TimeUnit("YEARS", 6, d.h * 365);
        i = (new TimeUnit[] {
            a, b, c, d, e, f, g
        });
    }
}
