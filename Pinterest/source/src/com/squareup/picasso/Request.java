// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.net.Uri;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.picasso:
//            Transformation

public final class Request
{

    private static final long r;
    int a;
    long b;
    boolean c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final float l;
    public final float m;
    public final float n;
    public final boolean o;
    public final android.graphics.Bitmap.Config p;
    public final Picasso.Priority q;

    private Request(Uri uri, int i1, String s, List list, int j1, int k1, boolean flag, 
            boolean flag1, float f1, float f2, float f3, boolean flag2, android.graphics.Bitmap.Config config, Picasso.Priority priority)
    {
        d = uri;
        e = i1;
        f = s;
        if (list == null)
        {
            g = null;
        } else
        {
            g = Collections.unmodifiableList(list);
        }
        h = j1;
        i = k1;
        j = flag;
        k = flag1;
        l = f1;
        m = f2;
        n = f3;
        o = flag2;
        p = config;
        q = priority;
    }

    Request(Uri uri, int i1, String s, List list, int j1, int k1, boolean flag, 
            boolean flag1, float f1, float f2, float f3, boolean flag2, android.graphics.Bitmap.Config config, Picasso.Priority priority, 
            byte byte0)
    {
        this(uri, i1, s, list, j1, k1, flag, flag1, f1, f2, f3, flag2, config, priority);
    }

    final String a()
    {
        long l1 = System.nanoTime() - b;
        if (l1 > r)
        {
            return (new StringBuilder()).append(b()).append('+').append(TimeUnit.NANOSECONDS.toSeconds(l1)).append('s').toString();
        } else
        {
            return (new StringBuilder()).append(b()).append('+').append(TimeUnit.NANOSECONDS.toMillis(l1)).append("ms").toString();
        }
    }

    final String b()
    {
        return (new StringBuilder("[R")).append(a).append(']').toString();
    }

    public final boolean c()
    {
        return h != 0 || i != 0;
    }

    final boolean d()
    {
        return c() || l != 0.0F;
    }

    final boolean e()
    {
        return g != null;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Request{");
        if (e > 0)
        {
            stringbuilder.append(e);
        } else
        {
            stringbuilder.append(d);
        }
        if (g != null && !g.isEmpty())
        {
            Transformation transformation;
            for (Iterator iterator = g.iterator(); iterator.hasNext(); stringbuilder.append(' ').append(transformation.key()))
            {
                transformation = (Transformation)iterator.next();
            }

        }
        if (f != null)
        {
            stringbuilder.append(" stableKey(").append(f).append(')');
        }
        if (h > 0)
        {
            stringbuilder.append(" resize(").append(h).append(',').append(i).append(')');
        }
        if (j)
        {
            stringbuilder.append(" centerCrop");
        }
        if (k)
        {
            stringbuilder.append(" centerInside");
        }
        if (l != 0.0F)
        {
            stringbuilder.append(" rotation(").append(l);
            if (o)
            {
                stringbuilder.append(" @ ").append(m).append(',').append(n);
            }
            stringbuilder.append(')');
        }
        if (p != null)
        {
            stringbuilder.append(' ').append(p);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    static 
    {
        r = TimeUnit.SECONDS.toNanos(5L);
    }
}
