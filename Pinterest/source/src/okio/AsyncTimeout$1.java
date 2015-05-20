// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.IOException;

// Referenced classes of package okio:
//            Sink, AsyncTimeout, Timeout, Buffer

class it>
    implements Sink
{

    final Sink a;
    final AsyncTimeout b;

    public final Timeout a()
    {
        return b;
    }

    public final void a(Buffer buffer, long l)
    {
        b.c();
        a.a(buffer, l);
        b.a(true);
        return;
        buffer;
        throw b.a(buffer);
        buffer;
        b.a(false);
        throw buffer;
    }

    public final void b()
    {
        b.c();
        a.b();
        b.a(true);
        return;
        Object obj;
        obj;
        throw b.a(((IOException) (obj)));
        obj;
        b.a(false);
        throw obj;
    }

    public void close()
    {
        b.c();
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
        return (new StringBuilder("AsyncTimeout.sink(")).append(a).append(")").toString();
    }

    der(AsyncTimeout asynctimeout, Sink sink)
    {
        b = asynctimeout;
        a = sink;
        super();
    }
}
