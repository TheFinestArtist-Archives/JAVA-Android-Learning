// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.Set;
import okio.Buffer;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, PushObserver, ErrorCode, FrameWriter

class d extends NamedRunnable
{

    final int a;
    final Buffer b;
    final int c;
    final boolean d;
    final SpdyConnection e;

    public final void a()
    {
        boolean flag = SpdyConnection.j(e).onData(a, b, c, d);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        e.i.rstStream(a, ErrorCode.l);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (!d)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        synchronized (e)
        {
            SpdyConnection.k(e).remove(Integer.valueOf(a));
        }
        return;
        exception;
        spdyconnection;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IOException ioexception) { }
    }

    transient (SpdyConnection spdyconnection, String s, Object aobj[], int i, Buffer buffer, int j, boolean flag)
    {
        e = spdyconnection;
        a = i;
        b = buffer;
        c = j;
        d = flag;
        super(s, aobj);
    }
}
