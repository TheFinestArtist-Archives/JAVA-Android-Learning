// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;


public final class cc extends Enum
{

    public static final cc A;
    public static final cc B;
    public static final cc C;
    public static final cc D;
    public static final cc E;
    public static final cc F;
    public static final cc G;
    public static final cc H;
    public static final cc I;
    public static final cc J;
    public static final cc K;
    public static final cc L;
    public static final cc M;
    public static final cc N;
    public static final cc O;
    public static final cc P;
    public static final cc Q;
    public static final cc R;
    public static final cc S;
    public static final cc T;
    public static final cc U;
    public static final cc V;
    public static final cc W;
    public static final cc X;
    public static final cc Y;
    public static final cc Z;
    public static final cc a;
    public static final cc aa;
    public static final cc ab;
    public static final cc ac;
    private static final cc af[];
    public static final cc b;
    public static final cc c;
    public static final cc d;
    public static final cc e;
    public static final cc f;
    public static final cc g;
    public static final cc h;
    public static final cc i;
    public static final cc j;
    public static final cc k;
    public static final cc l;
    public static final cc m;
    public static final cc n;
    public static final cc o;
    public static final cc p;
    public static final cc q;
    public static final cc r;
    public static final cc s;
    public static final cc t;
    public static final cc u;
    public static final cc v;
    public static final cc w;
    public static final cc x;
    public static final cc y;
    public static final cc z;
    private int ad;
    private int ae;

    private cc(String s1, int i1, int j1)
    {
        super(s1, i1);
        ae = 0;
        ad = j1;
    }

    public static cc valueOf(String s1)
    {
        return (cc)Enum.valueOf(crittercism/android/cc, s1);
    }

    public static cc[] values()
    {
        return (cc[])af.clone();
    }

    public final void a(int i1)
    {
        ae = i1;
    }

    public final String toString()
    {
        String s2 = (new StringBuilder("error(")).append(ad).toString();
        String s1 = s2;
        if (ae == 0)
        {
            s1 = (new StringBuilder()).append(s2).append(", ").append(ae).toString();
        }
        return (new StringBuilder()).append(s1).append(")").toString();
    }

    static 
    {
        a = new cc("NO_ERROR", 0, 0);
        b = new cc("NETWORK_ERROR_NO_INTERNET", 1, 1000);
        c = new cc("NETWORK_ERROR_CONN_TIMEOUT", 2, 1001);
        d = new cc("NETWORK_ERROR_UNKNOWN_HOST", 3, 1002);
        e = new cc("NETWORK_ERROR_WTF", 4, 1003);
        f = new cc("NETWORK_ERROR_FILE_NOT_FOUND", 5, 1004);
        g = new cc("REFLECTIVE_FIELD_NOT_FOUND", 6, 5000);
        h = new cc("REFLECTIVE_FIELD_GET_NOT_STATIC", 7, 5001);
        i = new cc("REFLECTIVE_FIELD_GET_NOT_ACCESSIBLE", 8, 5002);
        j = new cc("REFLECTIVE_FIELD_GET_INCOMPATIBLE", 9, 5003);
        k = new cc("REFLECTIVE_FIELD_GET_BAD_CAST", 10, 5004);
        l = new cc("REFLECTIVE_FIELD_AMBIGUOUS", 11, 5005);
        m = new cc("SOCKET_IMPLE_WAS_NULL", 12, 5006);
        n = new cc("GIVEN_NULL_SOCKET_FACTORY", 13, 5007);
        o = new cc("GIVEN_NULL_SOCKET_IMPL_CLASS", 14, 5008);
        p = new cc("SOCKET_FACTORY_DOES_NOT_WORK", 15, 5009);
        q = new cc("SOCKET_IMPL_CLASS_NEW_INSTANCE_FAILED_ILLEGAL_ACCESS", 16, 5010);
        r = new cc("SOCKET_IMPL_CLASS_NEW_INSTANCE_FAILED", 17, 5011);
        s = new cc("COULD_NOT_REFLECTIVELY_SET_SOCKET_IMPL_FACTORY_ILLEGAL_ARG", 18, 5012);
        t = new cc("COULD_NOT_REFLECTIVELY_SET_SOCKET_IMPL_FACTORY_ILLEGAL_ACCESS", 19, 5013);
        u = new cc("COULD_NOT_REFLECTIVELY_SET_SOCKET_IMPL_FACTORY_NOT_STATIC", 20, 5014);
        v = new cc("SOCKET_IMPL_FACTORY_ALREADY_INSTALLED", 21, 5015);
        w = new cc("COULD_NOT_REFLECTIVELY_GET_SSL_DELEGATE_ILLEGAL_ARG", 22, 5016);
        x = new cc("COULD_NOT_REFLECTIVELY_GET_SSL_DELEGATE_ILLEGAL_ACCESS", 23, 5017);
        y = new cc("COULD_NOT_REFLECTIVELY_GET_SSL_DELEGATE_BAD_CAST", 24, 5018);
        z = new cc("COULD_NOT_REFLECTIVELY_SET_SSL_DELEGATE_ILLEGAL_ARG", 25, 5019);
        A = new cc("COULD_NOT_REFLECTIVELY_SET_SSL_DELEGATE_ILLEGAL_ACCESS", 26, 5020);
        B = new cc("SSL_DELEGATE_FACTORY_WAS_NULL", 27, 5021);
        C = new cc("COULD_NOT_UNINSTALL_SOCKET_IMPL_FACTORY_ILLEGAL_ARG", 28, 5022);
        D = new cc("COULD_NOT_UNINSTALL_SOCKET_IMPL_FACTORY_ILLEGAL_ACCESS", 29, 5023);
        E = new cc("SOCKET_IMPL_INVOKE_ILLEGAL_ARGS", 30, 5024);
        F = new cc("SOCKET_IMPL_INVOKE_ILLEGAL_ACCESS", 31, 5025);
        G = new cc("SOCKET_IMPL_INVOKE_BAD", 32, 5026);
        H = new cc("SOCKET_IMPL_INVOKE_UNKNOWN_THROWABLE", 33, 5027);
        I = new cc("SOCKET_IMPL_INVOKE_UNEXPECTED_EXCEPTION", 34, 5028);
        J = new cc("SOCKET_IMPL_INVOKE_EXPECTED_BOXED_RETURN", 35, 5029);
        K = new cc("SOCKET_IMPL_INVOKE_UNEXPECTED_RETURN_TYPE", 36, 5030);
        L = new cc("SOCKET_IMPL_SYNC_TO_DELEGATE_ILLEGAL_ARG", 37, 5031);
        M = new cc("SOCKET_IMPL_SYNC_TO_DELEGATE_ILLEGAL_ACCESS", 38, 5032);
        N = new cc("SOCKET_IMPL_SYNC_FROM_DELEGATE_ILLEGAL_ARG", 39, 5033);
        O = new cc("SOCKET_IMPL_SYNC_FROM_DELEGATE_ILLEGAL_ACCESS", 40, 5034);
        P = new cc("SOCKET_IMPL_REFLECTION_INIT_SECURITY_EXCEPTION", 41, 5035);
        Q = new cc("SOCKET_IMPL_REFLECTION_INIT_NO_SUCH_METHOD", 42, 5036);
        R = new cc("SOCKET_IMPL_REFLECTION_INIT_NO_SUCH_FIELD", 43, 5037);
        S = new cc("SOCKET_IMPL_STATIC_INITIALIZER_UNEXPECTED_CRASH", 44, 5038);
        T = new cc("SOCKET_IMPL_INVOKE_BUG", 45, 5039);
        U = new cc("SOCKET_IMPL_UNKNOWN_VALIDATION_ERROR", 46, 5040);
        V = new cc("REFLECTIVE_FIELD_SET_NOT_STATIC", 47, 5041);
        W = new cc("REFLECTIVE_FIELD_SET_NOT_ACCESSIBLE", 48, 5042);
        X = new cc("REFLECTIVE_FIELD_SET_INCOMPATIBLE", 49, 5043);
        Y = new cc("REFLECTIVE_FIELD_SET_BAD_CAST", 50, 5044);
        Z = new cc("SSL_CONTEXT_SPI_BAD_METHOD_CALL", 51, 5045);
        aa = new cc("SSL_CONTEXT_SPI_UNDECLARED_EXCEPTION", 52, 5046);
        ab = new cc("SSL_CONTEXT_SPI_FIELD_GET_ERROR", 53, 5047);
        ac = new cc("SSL_CONTEXT_SPI_FIELD_SET_ERROR", 54, 5048);
        af = (new cc[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P, Q, R, S, T, U, V, W, X, 
            Y, Z, aa, ab, ac
        });
    }
}
