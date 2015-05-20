// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.squareup.okhttp:
//            Cache

final class ditor extends CacheRequest
{

    final Cache a;
    private final com.squareup.okhttp.internal._cls1 b;
    private OutputStream c;
    private boolean d;
    private OutputStream e;

    static boolean a(ditor ditor)
    {
        return ditor.d;
    }

    static boolean b(d d1)
    {
        d1.d = true;
        return true;
    }

    public final void abort()
    {
label0:
        {
            synchronized (a)
            {
                if (!d)
                {
                    break label0;
                }
            }
            return;
        }
        d = true;
        Cache.c(a);
        obj;
        JVM INSTR monitorexit ;
        Util.a(c);
        try
        {
            b._mth1();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final OutputStream getBody()
    {
        return e;
    }

    public ditor(Cache cache, com.squareup.okhttp.internal._cls1 _pcls1)
    {
        a = cache;
        super();
        b = _pcls1;
        c = _pcls1._mth1(1);
        class _cls1 extends FilterOutputStream
        {

            final Cache a;
            final com.squareup.okhttp.internal.DiskLruCache.Editor b;
            final Cache.CacheRequestImpl c;

            public void close()
            {
label0:
                {
                    synchronized (c.a)
                    {
                        if (!Cache.CacheRequestImpl.a(c))
                        {
                            break label0;
                        }
                    }
                    return;
                }
                Cache.CacheRequestImpl.b(c);
                Cache.b(c.a);
                cache1;
                JVM INSTR monitorexit ;
                super.close();
                b.a();
                return;
                exception;
                cache1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void write(byte abyte0[], int i, int j)
            {
                out.write(abyte0, i, j);
            }

            _cls1(OutputStream outputstream, Cache cache, com.squareup.okhttp.internal.DiskLruCache.Editor editor)
            {
                c = Cache.CacheRequestImpl.this;
                a = cache;
                b = editor;
                super(outputstream);
            }
        }

        e = new _cls1(c, cache, _pcls1);
    }
}
