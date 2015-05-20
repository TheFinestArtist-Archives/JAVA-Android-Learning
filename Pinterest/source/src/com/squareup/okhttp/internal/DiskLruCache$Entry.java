// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache

final class <init>
{

    final DiskLruCache a;
    private final String b;
    private final long c[];
    private boolean d;
    private  e;
    private long f;

    static long a(<init> <init>1, long l)
    {
        <init>1.f = l;
        return l;
    }

    static  a( ,  1)
    {
        .e = 1;
        return 1;
    }

    private static IOException a(String as[])
    {
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
    }

    static void a(e e1, String as[])
    {
        if (as.length != DiskLruCache.f(e1.a))
        {
            throw a(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                e1.c[i] = Long.parseLong(as[i]);
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                throw a(as);
            }
            i++;
        } while (true);
    }

    static boolean a(a a1)
    {
        a1.d = true;
        return true;
    }

    static  b(d d1)
    {
        return d1.e;
    }

    static long[] c(e e1)
    {
        return e1.c;
    }

    static String d(c c1)
    {
        return c1.b;
    }

    static boolean e(b b1)
    {
        return b1.d;
    }

    static long f(d d1)
    {
        return d1.f;
    }

    public final File a(int i)
    {
        return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i).toString());
    }

    public final String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = c;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }

    public final File b(int i)
    {
        return new File(DiskLruCache.g(a), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }

    private (DiskLruCache disklrucache, String s)
    {
        a = disklrucache;
        super();
        b = s;
        c = new long[DiskLruCache.f(disklrucache)];
    }

    c(DiskLruCache disklrucache, String s, byte byte0)
    {
        this(disklrucache, s);
    }
}
