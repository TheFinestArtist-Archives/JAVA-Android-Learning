// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;

// Referenced classes of package crittercism.android:
//            at, df, bb, bt

public final class bq
{

    private static at a = null;
    private static Context b = null;
    private static df c = null;
    private static bb d = null;
    private static bt e = null;

    static at a()
    {
        return a;
    }

    public static void a(Context context)
    {
        b = context;
    }

    public static void a(at at)
    {
        a = at;
    }

    public static void a(bb bb)
    {
        d = bb;
    }

    public static void a(bt bt)
    {
        e = bt;
    }

    public static void a(df df)
    {
        c = df;
    }

    static Context b()
    {
        return b;
    }

    static bb c()
    {
        return d;
    }

    static df d()
    {
        return c;
    }

    static bt e()
    {
        return e;
    }

}
