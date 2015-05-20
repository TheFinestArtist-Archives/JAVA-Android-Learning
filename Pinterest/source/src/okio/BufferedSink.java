// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.OutputStream;

// Referenced classes of package okio:
//            Sink, Source, ByteString, Buffer

public interface BufferedSink
    extends Sink
{

    public abstract long a(Source source);

    public abstract BufferedSink b(String s1);

    public abstract BufferedSink b(ByteString bytestring);

    public abstract BufferedSink b(byte abyte0[]);

    public abstract BufferedSink c(byte abyte0[], int i, int j);

    public abstract Buffer d();

    public abstract BufferedSink d(int i);

    public abstract OutputStream e();

    public abstract BufferedSink e(int i);

    public abstract BufferedSink r();

    public abstract BufferedSink s();
}
