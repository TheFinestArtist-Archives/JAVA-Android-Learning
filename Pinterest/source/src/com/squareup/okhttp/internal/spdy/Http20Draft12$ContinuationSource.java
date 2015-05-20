// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http20Draft12

final class f
    implements Source
{

    short a;
    byte b;
    int c;
    short d;
    short e;
    private final BufferedSource f;

    public final Timeout a()
    {
        return f.a();
    }

    public final long b(Buffer buffer, long l)
    {
_L7:
        if (d != 0) goto _L2; else goto _L1
_L1:
        f.g(e);
        e = 0;
        if ((b & 4) == 0) goto _L4; else goto _L3
_L3:
        return -1L;
_L4:
        int i = c;
        int j = f.j();
        int k = f.j();
        a = (short)((0x3fff0000 & j) >> 16);
        byte byte0 = (byte)((0xff00 & j) >> 8);
        b = (byte)(j & 0xff);
        if (Http20Draft12.b().isLoggable(Level.FINE))
        {
            Http20Draft12.b().fine(b(true, c, a, byte0, b));
        }
        e = Http20Draft12.a(f, b);
        short word0 = Http20Draft12.a(a, b, e);
        d = word0;
        a = word0;
        c = 0x7fffffff & k;
        if (byte0 != 9)
        {
            throw Http20Draft12.a("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (c != i)
        {
            throw Http20Draft12.a("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        l = f.b(buffer, Math.min(l, d));
        if (l == -1L) goto _L3; else goto _L5
_L5:
        d = (short)(int)((long)d - l);
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void close()
    {
    }

    public (BufferedSource bufferedsource)
    {
        f = bufferedsource;
    }
}
