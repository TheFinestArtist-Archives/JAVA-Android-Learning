// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.io.FilterOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp:
//            Cache

class b extends FilterOutputStream
{

    final Cache a;
    final com.squareup.okhttp.internal. b;
    final tor c;

    public void close()
    {
label0:
        {
            synchronized (c.c)
            {
                if (!c(c))
                {
                    break label0;
                }
            }
            return;
        }
        c(c);
        Cache.b(c.c);
        cache;
        JVM INSTR monitorexit ;
        super.close();
        b.();
        return;
        exception;
        cache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void write(byte abyte0[], int i, int j)
    {
        out.write(abyte0, i, j);
    }

    tor(tor tor, OutputStream outputstream, Cache cache, com.squareup.okhttp.internal. )
    {
        c = tor;
        a = cache;
        b = ;
        super(outputstream);
    }
}
