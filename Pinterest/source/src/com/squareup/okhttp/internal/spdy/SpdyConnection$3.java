// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, Ping

class c extends NamedRunnable
{

    final boolean a = true;
    final int b;
    final int c;
    final Ping d = null;
    final SpdyConnection e;

    public final void a()
    {
        try
        {
            SpdyConnection.a(e, a, b, c, d);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (SpdyConnection spdyconnection, String s, Object aobj[], int i, int j)
    {
        e = spdyconnection;
        b = i;
        c = j;
        super(s, aobj);
    }
}
