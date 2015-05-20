// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

// Referenced classes of package crittercism.android:
//            j, ca, cc, ab, 
//            d, c

public final class z extends SSLContextSpi
{

    private static Method a[];
    private static boolean b = false;
    private SSLContextSpi c;
    private d d;
    private c e;

    private z()
    {
    }

    private z(SSLContextSpi sslcontextspi, d d1, c c1)
    {
        c = sslcontextspi;
        d = d1;
        e = c1;
    }

    public static z a(SSLContextSpi sslcontextspi, d d1, c c1)
    {
        if (!b)
        {
            return null;
        } else
        {
            return new z(sslcontextspi, d1, c1);
        }
    }

    private transient Object a(int i, Object aobj[])
    {
        if (c == null)
        {
            return null;
        }
        try
        {
            aobj = ((Object []) (a[i].invoke(c, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.Z);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.Z);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            aobj = ((InvocationTargetException) (aobj)).getCause();
            if (aobj == null)
            {
                throw new ca(cc.Z);
            }
            if (aobj instanceof Exception)
            {
                throw (Exception)aobj;
            }
            if (aobj instanceof Error)
            {
                throw (Error)aobj;
            } else
            {
                throw new ca(cc.Z);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.Z);
        }
        return ((Object) (aobj));
    }

    private transient Object a(Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(6, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.aa);
        }
        return ((Object) (aobj));
    }

    public static boolean a()
    {
        return b;
    }

    private transient Object b(int i, Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(i, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.aa);
        }
        return ((Object) (aobj));
    }

    protected final SSLEngine engineCreateSSLEngine()
    {
        return (SSLEngine)b(0, new Object[0]);
    }

    protected final SSLEngine engineCreateSSLEngine(String s, int i)
    {
        return (SSLEngine)b(1, new Object[] {
            s, Integer.valueOf(i)
        });
    }

    protected final SSLSessionContext engineGetClientSessionContext()
    {
        return (SSLSessionContext)b(2, new Object[0]);
    }

    protected final SSLSessionContext engineGetServerSessionContext()
    {
        return (SSLSessionContext)b(3, new Object[0]);
    }

    protected final SSLServerSocketFactory engineGetServerSocketFactory()
    {
        return (SSLServerSocketFactory)b(4, new Object[0]);
    }

    protected final SSLSocketFactory engineGetSocketFactory()
    {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory)b(5, new Object[0]);
        Object obj = sslsocketfactory;
        if (sslsocketfactory != null)
        {
            try
            {
                obj = new ab(sslsocketfactory, d, e);
            }
            catch (ThreadDeath threaddeath)
            {
                throw threaddeath;
            }
            catch (Throwable throwable)
            {
                return sslsocketfactory;
            }
        }
        return ((SSLSocketFactory) (obj));
    }

    protected final void engineInit(KeyManager akeymanager[], TrustManager atrustmanager[], SecureRandom securerandom)
    {
        a(new Object[] {
            akeymanager, atrustmanager, securerandom
        });
    }

    public final boolean equals(Object obj)
    {
        return c.equals(obj);
    }

    public final int hashCode()
    {
        return c.hashCode();
    }

    public final String toString()
    {
        return c.toString();
    }

    static 
    {
        a = new Method[7];
        try
        {
            a[0] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineCreateSSLEngine", new Class[0]);
            a[1] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineCreateSSLEngine", new Class[] {
                java/lang/String, Integer.TYPE
            });
            a[2] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineGetClientSessionContext", new Class[0]);
            a[3] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineGetServerSessionContext", new Class[0]);
            a[4] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineGetServerSocketFactory", new Class[0]);
            a[5] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineGetSocketFactory", new Class[0]);
            a[6] = javax/net/ssl/SSLContextSpi.getDeclaredMethod("engineInit", new Class[] {
                [Ljavax/net/ssl/KeyManager;, [Ljavax/net/ssl/TrustManager;, java/security/SecureRandom
            });
            j.a(a);
            z z1 = new z(new z(), null, null);
            z1.engineCreateSSLEngine();
            z1.engineCreateSSLEngine(null, 0);
            z1.engineGetClientSessionContext();
            z1.engineGetServerSessionContext();
            z1.engineGetServerSocketFactory();
            z1.engineGetSocketFactory();
            z1.engineInit(null, null, null);
            b = true;
        }
        catch (Throwable throwable)
        {
            b = false;
        }
    }
}
