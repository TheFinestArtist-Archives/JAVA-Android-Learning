// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.util.HashMap;

public final class ce extends Enum
{

    public static final ce A;
    public static final ce B;
    private static HashMap C;
    private static final ce F[];
    public static final ce a;
    public static final ce b;
    public static final ce c;
    public static final ce d;
    public static final ce e;
    public static final ce f;
    public static final ce g;
    public static final ce h;
    public static final ce i;
    public static final ce j;
    public static final ce k;
    public static final ce l;
    public static final ce m;
    public static final ce n;
    public static final ce o;
    public static final ce p;
    public static final ce q;
    public static final ce r;
    public static final ce s;
    public static final ce t;
    public static final ce u;
    public static final ce v;
    public static final ce w;
    public static final ce x;
    public static final ce y;
    public static final ce z;
    private int D;
    private String E;

    private ce(String s1, int i1, int j1, String s2)
    {
        super(s1, i1);
        D = j1;
        E = s2;
    }

    public static ce a(Throwable throwable)
    {
        if (C == null)
        {
            b();
        }
        Object obj = null;
        if (throwable != null)
        {
            obj = throwable.getClass().getName();
        }
        obj = (ce)C.get(obj);
        throwable = ((Throwable) (obj));
        if (obj == null)
        {
            throwable = B;
        }
        return throwable;
    }

    private static void b()
    {
        crittercism/android/ce;
        JVM INSTR monitorenter ;
        HashMap hashmap = C;
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        crittercism/android/ce;
        JVM INSTR monitorexit ;
        return;
_L2:
        ce ace[];
        int j1;
        hashmap = new HashMap();
        ace = values();
        j1 = ace.length;
        int i1 = 0;
_L4:
        ce ce1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ce1 = ace[i1];
        hashmap.put(ce1.E, ce1);
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        C = hashmap;
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public static ce valueOf(String s1)
    {
        return (ce)Enum.valueOf(crittercism/android/ce, s1);
    }

    public static ce[] values()
    {
        return (ce[])F.clone();
    }

    public final int a()
    {
        return D;
    }

    static 
    {
        a = new ce("OK", 0, 0, null);
        b = new ce("ASSERTION_ERROR", 1, 1, "java.lang.AssertionError");
        c = new ce("BIND_EXCEPTION", 2, 2, "java.net.BindException");
        d = new ce("CLASS_NOT_FOUND_EXCEPTION", 3, 3, "java.lang.ClassNotFoundException");
        e = new ce("ERROR", 4, 4, "java.lang.Error");
        f = new ce("IO_EXCEPTION", 5, 5, "java.io.IOException");
        g = new ce("ILLEGAL_ARGUMENT_EXCEPTION", 6, 6, "java.lang.IllegalArgumentException");
        h = new ce("ILLEGAL_STATE_EXCEPTION", 7, 7, "java.lang.IllegalStateException");
        i = new ce("INDEX_OUT_OF_BOUNDS_EXCEPTION", 8, 8, "java.lang.IndexOutOfBoundsException");
        j = new ce("MALFORMED_URL_EXCEPTION", 9, 9, "java.net.MalformedURLException");
        k = new ce("NO_SUCH_PROVIDER_EXCEPTION", 10, 10, "java.security.NoSuchProviderException");
        l = new ce("NULL_POINTER_EXCEPTION", 11, 11, "java.lang.NullPointerException");
        m = new ce("PROTOCOL_EXCEPTION", 12, 12, "java.net.ProtocolException");
        n = new ce("SECURITY_EXCEPTION", 13, 13, "java.lang.SecurityException");
        o = new ce("SOCKET_EXCEPTION", 14, 14, "java.net.SocketException");
        p = new ce("SOCKET_TIMEOUT_EXCEPTION", 15, 15, "java.net.SocketTimeoutException");
        q = new ce("SSL_PEER_UNVERIFIED_EXCEPTION", 16, 16, "javax.net.ssl.SSLPeerUnverifiedException");
        r = new ce("STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION", 17, 17, "java.lang.StringIndexOutOfBoundsException");
        s = new ce("UNKNOWN_HOST_EXCEPTION", 18, 18, "java.net.UnknownHostException");
        t = new ce("UNKNOWN_SERVICE_EXCEPTION", 19, 19, "java.net.UnknownServiceException");
        u = new ce("UNSUPPORTED_OPERATION_EXCEPTION", 20, 20, "java.lang.UnsupportedOperationException");
        v = new ce("URI_SYNTAX_EXCEPTION", 21, 21, "java.net.URISyntaxException");
        w = new ce("CONNECT_EXCEPTION", 22, 22, "java.net.ConnectException");
        x = new ce("SSL_EXCEPTION", 23, 23, "javax.net.ssl.SSLException");
        y = new ce("SSL_HANDSHAKE_EXCEPTION", 24, 24, "javax.net.ssl.SSLHandshakeException");
        z = new ce("SSL_KEY_EXCEPTION", 25, 25, "javax.net.ssl.SSLKeyException");
        A = new ce("SSL_PROTOCOL_EXCEPTION", 26, 26, "javax.net.ssl.SSLProtocolException");
        B = new ce("UNDEFINED_EXCEPTION", 27, -1, "__UNKNOWN__");
        F = (new ce[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B
        });
    }
}
