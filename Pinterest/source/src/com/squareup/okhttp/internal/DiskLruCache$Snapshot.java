// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache, Util

public final class <init>
    implements Closeable
{

    final DiskLruCache a;
    private final String b;
    private final long c;
    private final InputStream d[];
    private final long e[];

    public final <init> a()
    {
        return DiskLruCache.a(a, b, c);
    }

    public final InputStream a(int i)
    {
        return d[i];
    }

    public final void close()
    {
        InputStream ainputstream[] = d;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            Util.a(ainputstream[i]);
        }

    }

    private (DiskLruCache disklrucache, String s, long l, InputStream ainputstream[], long al[])
    {
        a = disklrucache;
        super();
        b = s;
        c = l;
        d = ainputstream;
        e = al;
    }

    e(DiskLruCache disklrucache, String s, long l, InputStream ainputstream[], long al[], byte byte0)
    {
        this(disklrucache, s, l, ainputstream, al);
    }
}
