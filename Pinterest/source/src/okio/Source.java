// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.Closeable;

// Referenced classes of package okio:
//            Timeout, Buffer

public interface Source
    extends Closeable
{

    public abstract Timeout a();

    public abstract long b(Buffer buffer, long l);

    public abstract void close();
}
