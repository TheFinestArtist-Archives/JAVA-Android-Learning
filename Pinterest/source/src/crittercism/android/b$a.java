// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class l extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k m[];
    private String l;

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(crittercism/android/b$a, s);
    }

    public static l[] values()
    {
        return (l[])m.clone();
    }

    public final String toString()
    {
        return l;
    }

    static 
    {
        a = new <init>("NOT_LOGGED_YET", 0, "Not logged");
        b = new <init>("INPUT_STREAM_READ", 1, "InputStream.read()");
        c = new <init>("INPUT_STREAM_CLOSE", 2, "InputStream.close()");
        d = new <init>("SOCKET_CLOSE", 3, "Socket.close()");
        e = new <init>("LEGACY_JAVANET", 4, "Legacy java.net");
        f = new <init>("HTTP_CONTENT_LENGTH_PARSER", 5, "parse()");
        g = new <init>("INPUT_STREAM_FINISHED", 6, "finishedMessage()");
        h = new <init>("PARSING_INPUT_STREAM_LOG_ERROR", 7, "logError()");
        i = new <init>("SOCKET_IMPL_CONNECT", 8, "MonitoredSocketImpl.connect()");
        j = new <init>("SSL_SOCKET_START_HANDSHAKE", 9, "MonitoredSSLSocket.startHandshake");
        k = new <init>("UNIT_TEST", 10, "Unit test");
        m = (new m[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1, String s1)
    {
        super(s, i1);
        l = s1;
    }
}
