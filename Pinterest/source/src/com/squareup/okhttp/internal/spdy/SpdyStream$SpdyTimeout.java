// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.InterruptedIOException;
import okio.AsyncTimeout;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            ErrorCode, SpdyStream

class a extends AsyncTimeout
{

    final SpdyStream a;

    protected final void a()
    {
        a.b(ErrorCode.l);
    }

    public final void b()
    {
        if (d())
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    (SpdyStream spdystream)
    {
        a = spdystream;
        super();
    }
}
