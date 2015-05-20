// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;

// Referenced classes of package okio:
//            Source, AsyncTimeout, Timeout, Buffer

class it>
    implements Source
{

    final Source a;
    final AsyncTimeout b;

    public final Timeout a()
    {
        return b;
    }

    public final long b(Buffer buffer, long l)
    {
        b.c();
        l = a.b(buffer, l);
        b.a(true);
        return l;
        buffer;
        throw b.a(buffer);
        buffer;
        b.a(false);
        throw buffer;
    }

    public void close()
    {
        a.close();
        b.a(true);
        return;
        Object obj;
        obj;
        throw b.a(((IOException) (obj)));
        obj;
        b.a(false);
        throw obj;
    }

    public String toString()
    {
        return (new StringBuilder("AsyncTimeout.source(")).append(a).append(")").toString();
    }

    der(AsyncTimeout asynctimeout, Source source)
    {
        b = asynctimeout;
        a = source;
        super();
    }
}
