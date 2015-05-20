// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal:
//            BitArray

public final class <init>
    implements BitArray
{

    long a[];
    private int b;

    private int a(int i)
    {
        i = (b + i) / 64;
        if (i > a.length - 1)
        {
            long al[] = new long[i + 1];
            if (a != null)
            {
                System.arraycopy(a, 0, al, 0, a.length);
            }
            a = al;
        }
        return i;
    }

    private List a()
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j = a.length;
        for (int k = b; i < j * 64 - k; i++)
        {
            if (get(i))
            {
                arraylist.add(Integer.valueOf(i));
            }
        }

        return arraylist;
    }

    private int b(int i)
    {
        return (b + i) % 64;
    }

    private static int c(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException(String.format("input must be a positive number: %s", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return i;
        }
    }

    public final void clear()
    {
        Arrays.fill(a, 0L);
    }

    public final boolean get(int i)
    {
        c(i);
        int j = a(i);
        return (a[j] & 1L << b(i)) != 0L;
    }

    public final void set(int i)
    {
        c(i);
        int j = a(i);
        long al[] = a;
        al[j] = al[j] | 1L << b(i);
    }

    public final void shiftLeft(int i)
    {
        b = b - c(i);
        if (b < 0)
        {
            i = b / -64 + 1;
            long al[] = new long[a.length + i];
            System.arraycopy(a, 0, al, i, a.length);
            a = al;
            b = b % 64 + 64;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("{");
        List list = a();
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(',');
            }
            stringbuilder.append(list.get(i));
        }

        return stringbuilder.append('}').toString();
    }

    public final void toggle(int i)
    {
        c(i);
        int j = a(i);
        long al[] = a;
        al[j] = al[j] ^ 1L << b(i);
    }

    public ()
    {
        a = new long[1];
    }

    private a(a a1)
    {
        a = (new long[] {
            a1.a, 0L
        });
    }

    a(a a1, byte byte0)
    {
        this(a1);
    }
}
