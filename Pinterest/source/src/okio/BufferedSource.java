// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.InputStream;

// Referenced classes of package okio:
//            Source, ByteString, Buffer

public interface BufferedSource
    extends Source
{

    public abstract long a(byte byte0);

    public abstract void a(long l1);

    public abstract ByteString c(long l1);

    public abstract String d(long l1);

    public abstract Buffer d();

    public abstract boolean f();

    public abstract byte[] f(long l1);

    public abstract InputStream g();

    public abstract void g(long l1);

    public abstract byte h();

    public abstract short i();

    public abstract int j();

    public abstract short k();

    public abstract int l();

    public abstract String m();
}
