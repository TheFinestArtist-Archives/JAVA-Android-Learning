// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package crittercism.android:
//            cb, cd, cc, dl, 
//            j, v, ab, ad, 
//            ca, ac, y, d, 
//            c

public final class i
{

    public static final a a;
    public static final v.a b;
    private ad c;
    private ab d;
    private ab e;
    private v f;
    private d g;
    private c h;
    private a i;
    private v.a j;

    public i(d d1, c c1)
    {
        i = a;
        j = b;
        g = d1;
        h = c1;
    }

    private static void a(cb cb1)
    {
        cb1.a().a.a(3);
    }

    private static void a(cb cb1, int k)
    {
        cb1 = cb1.a().a;
        cb1.a(k);
        a(((cc) (cb1)));
    }

    private static void a(cc cc1)
    {
        dl.a(new cd(cc1, "Unable to install OPTIMZ for http connections"));
    }

    private static boolean a(SocketImplFactory socketimplfactory)
    {
        Field field;
        try
        {
            field = crittercism.android.j.a(java/net/Socket, java/net/SocketImplFactory);
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a(((cb) (socketimplfactory)), 1);
            return false;
        }
        try
        {
            field.setAccessible(true);
            field.set(null, socketimplfactory);
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a(cc.s);
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a(cc.t);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (SocketImplFactory socketimplfactory)
        {
            a(cc.u);
            return false;
        }
        return true;
    }

    private static void b(cc cc1)
    {
        dl.a(new cd(cc1, "Unable to install OPTIMZ for SSL HttpClient connections"));
    }

    private boolean b()
    {
        boolean flag;
        try
        {
            f = new v(j, g, h);
            flag = f.b();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            classnotfoundexception.printStackTrace();
            return false;
        }
        return flag;
    }

    private boolean c()
    {
        Object obj;
        try
        {
            obj = SSLSocketFactory.getSocketFactory();
            obj = (javax.net.ssl.SSLSocketFactory)crittercism.android.j.a(org/apache/http/conn/ssl/SSLSocketFactory, javax/net/ssl/SSLSocketFactory).get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            b(cc.w);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            b(cc.x);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            b(cc.y);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a(((cb) (obj)));
            return false;
        }
        if (obj == null)
        {
            b(cc.B);
            return false;
        }
        if (obj instanceof ab)
        {
            return false;
        }
        obj = new ab(((javax.net.ssl.SSLSocketFactory) (obj)), g, h);
        try
        {
            SSLSocketFactory sslsocketfactory = SSLSocketFactory.getSocketFactory();
            crittercism.android.j.a(org/apache/http/conn/ssl/SSLSocketFactory, javax/net/ssl/SSLSocketFactory).set(sslsocketfactory, obj);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            b(cc.z);
            return false;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            b(cc.A);
            return false;
        }
        catch (cb cb1)
        {
            a(cb1);
            return false;
        }
        e = ((ab) (obj));
        return true;
    }

    private boolean d()
    {
        Object obj;
        SocketImplFactory socketimplfactory;
        obj = null;
        try
        {
            socketimplfactory = (SocketImplFactory)crittercism.android.j.a(crittercism.android.j.a(java/net/Socket, java/net/SocketImplFactory), null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a(((cb) (obj)), 1);
            return false;
        }
        if (socketimplfactory != null) goto _L2; else goto _L1
_L1:
        obj = (SocketImpl)crittercism.android.j.a(crittercism.android.j.a(java/net/Socket, java/net/SocketImpl), new Socket());
        if (obj == null)
        {
            try
            {
                throw new cb(cc.m);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a(((cb) (obj)), 2);
            }
            return false;
        }
        obj = obj.getClass();
_L6:
        if (socketimplfactory == null) goto _L4; else goto _L3
_L3:
        try
        {
            obj = new ad(socketimplfactory, g, h);
            a(((SocketImplFactory) (obj)));
        }
        catch (cb cb1)
        {
            a(cb1, 0);
            return false;
        }
        catch (IOException ioexception)
        {
            a(cc.v);
            return false;
        }
        c = ((ad) (obj));
        return true;
_L2:
        if (socketimplfactory instanceof ad)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        obj = new ad(((Class) (obj)), g, h);
        Socket.setSocketImplFactory(((SocketImplFactory) (obj)));
        break MISSING_BLOCK_LABEL_104;
        a(cc.o);
        return false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean a()
    {
        if (!ac.c())
        {
            dl.a(new cd(ac.d(), "Unable to install OPTMZ"));
            return false;
        }
        boolean flag;
        boolean flag1;
        boolean flag2;
        try
        {
            ac.e();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            dl.a(((ca) (obj)).a());
            return false;
        }
        flag1 = d();
        flag2 = c();
        flag = y.a(g, h) | (flag1 | false | flag2);
        if (i == a.a)
        {
            Object obj = HttpsURLConnection.getDefaultSSLSocketFactory();
            if (obj instanceof ab)
            {
                d = (ab)obj;
            } else
            {
                d = new ab(((javax.net.ssl.SSLSocketFactory) (obj)), g, h);
                HttpsURLConnection.setDefaultSSLSocketFactory(d);
            }
            return flag | true;
        } else
        {
            return b() | flag;
        }
    }

    static 
    {
        a = a.b;
        b = v.a.b;
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(crittercism/android/i$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("SOCKET_MONITOR", 0);
            b = new a("STREAM_MONITOR", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int k)
        {
            super(s, k);
        }
    }

}
