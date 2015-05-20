// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements Sink
{

    final HttpConnection a;
    private final byte b[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 13, 10
    };
    private boolean c;

    private void a(long l)
    {
        int i = 16;
        int j;
        long l1;
        do
        {
            byte abyte0[] = b;
            j = i - 1;
            abyte0[j] = HttpConnection.k()[(int)(15L & l)];
            l1 = l >>> 4;
            i = j;
            l = l1;
        } while (l1 != 0L);
        HttpConnection.a(a).c(b, j, b.length - j);
    }

    public final Timeout a()
    {
        return HttpConnection.a(a).a();
    }

    public final void a(Buffer buffer, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return;
        } else
        {
            a(l);
            HttpConnection.a(a).a(buffer, l);
            HttpConnection.a(a).b("\r\n");
            return;
        }
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        HttpConnection.a(a).b();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c = true;
        HttpConnection.a(a).b(HttpConnection.j());
        HttpConnection.a(a, 3);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private (HttpConnection httpconnection)
    {
        a = httpconnection;
        super();
    }

    a(HttpConnection httpconnection, byte byte0)
    {
        this(httpconnection);
    }
}
