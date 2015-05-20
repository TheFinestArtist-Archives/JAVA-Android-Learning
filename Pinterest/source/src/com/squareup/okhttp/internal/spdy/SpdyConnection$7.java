// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.util.Set;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, PushObserver, ErrorCode

class b extends NamedRunnable
{

    final int a;
    final ErrorCode b;
    final SpdyConnection c;

    public final void a()
    {
        SpdyConnection.j(c).onReset(a, b);
        synchronized (c)
        {
            SpdyConnection.k(c).remove(Integer.valueOf(a));
        }
        return;
        exception;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw exception;
    }

    transient (SpdyConnection spdyconnection, String s, Object aobj[], int i, ErrorCode errorcode)
    {
        c = spdyconnection;
        a = i;
        b = errorcode;
        super(s, aobj);
    }
}
