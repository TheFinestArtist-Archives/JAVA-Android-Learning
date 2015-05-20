// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.util.SparseArray;

public final class g extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    private static SparseArray d;
    private static final g f[];
    private int e;

    private g(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static g a(int i)
    {
        g g2 = (g)d.get(i);
        g g1 = g2;
        if (g2 == null)
        {
            g1 = a;
        }
        return g1;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(crittercism/android/g, s);
    }

    public static g[] values()
    {
        return (g[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    static 
    {
        a = new g("NOT_ON_WIFI", 0, 0);
        b = new g("ON_WIFI", 1, 1);
        c = new g("UNKNOWN", 2, 2);
        f = (new g[] {
            a, b, c
        });
        SparseArray sparsearray = new SparseArray();
        d = sparsearray;
        sparsearray.put(0, a);
        d.put(1, b);
    }
}
