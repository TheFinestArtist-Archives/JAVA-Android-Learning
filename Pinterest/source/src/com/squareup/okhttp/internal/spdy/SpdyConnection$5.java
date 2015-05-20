// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, PushObserver, ErrorCode, FrameWriter

class c extends NamedRunnable
{

    final int a;
    final List b;
    final boolean c;
    final SpdyConnection d;

    public final void a()
    {
        boolean flag;
        flag = SpdyConnection.j(d).onHeaders(a, b, c);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        d.i.rstStream(a, ErrorCode.l);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!c)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        synchronized (d)
        {
            SpdyConnection.k(d).remove(Integer.valueOf(a));
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

    transient (SpdyConnection spdyconnection, String s, Object aobj[], int i, List list, boolean flag)
    {
        d = spdyconnection;
        a = i;
        b = list;
        c = flag;
        super(s, aobj);
    }
}
