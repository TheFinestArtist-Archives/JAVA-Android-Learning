// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            NameValueBlockReader

class a extends ForwardingSource
{

    final NameValueBlockReader a;

    public final long b(Buffer buffer, long l)
    {
        if (NameValueBlockReader.a(a) != 0)
        {
            if ((l = super.b(buffer, Math.min(l, NameValueBlockReader.a(a)))) != -1L)
            {
                NameValueBlockReader.a(a, l);
                return l;
            }
        }
        return -1L;
    }

    (NameValueBlockReader namevalueblockreader, Source source)
    {
        a = namevalueblockreader;
        super(source);
    }
}
