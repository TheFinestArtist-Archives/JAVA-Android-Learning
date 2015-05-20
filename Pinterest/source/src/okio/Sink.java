// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.Closeable;

// Referenced classes of package okio:
//            Timeout, Buffer

public interface Sink
    extends Closeable
{

    public abstract Timeout a();

    public abstract void a(Buffer buffer, long l);

    public abstract void b();

    public abstract void close();
}
