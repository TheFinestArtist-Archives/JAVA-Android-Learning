// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache

class a
    implements Runnable
{

    final DiskLruCache a;

    public void run()
    {
label0:
        {
            synchronized (a)
            {
                if (DiskLruCache.a(a) != null)
                {
                    break label0;
                }
            }
            return;
        }
        DiskLruCache.b(a);
        if (DiskLruCache.c(a))
        {
            DiskLruCache.d(a);
            DiskLruCache.e(a);
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
    }

    (DiskLruCache disklrucache)
    {
        a = disklrucache;
        super();
    }
}
