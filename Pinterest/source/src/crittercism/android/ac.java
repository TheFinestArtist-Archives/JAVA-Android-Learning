// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package crittercism.android:
//            ae, cc, j, b, 
//            c, ba, ca, cd, 
//            d, x, ce, w

public final class ac extends SocketImpl
    implements ae
{

    private static Field a;
    private static Field b;
    private static Field c;
    private static Field d;
    private static Method e[];
    private static boolean f;
    private static cc g;
    private final Queue h = new LinkedList();
    private d i;
    private c j;
    private SocketImpl k;
    private w l;
    private x m;

    public ac(d d1, c c1, SocketImpl socketimpl)
    {
        if (d1 == null)
        {
            throw new NullPointerException("dispatch was null");
        }
        if (socketimpl == null)
        {
            throw new NullPointerException("delegate was null");
        } else
        {
            i = d1;
            j = c1;
            k = socketimpl;
            f();
            return;
        }
    }

    private b a(boolean flag)
    {
        b b1 = new b();
        InetAddress inetaddress = getInetAddress();
        if (inetaddress != null)
        {
            b1.a(inetaddress);
        }
        int i1 = getPort();
        if (i1 > 0)
        {
            b1.a(i1);
        }
        if (flag)
        {
            b1.a(k.a.a);
        }
        if (j != null)
        {
            b1.j = j.a();
        }
        if (ba.b())
        {
            b1.a(ba.a());
        }
        return b1;
    }

    private transient Object a(int i1, Object aobj[])
    {
        try
        {
            a.set(k, address);
            b.set(k, fd);
            c.setInt(k, localport);
            d.setInt(k, port);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.L);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(cc.M);
        }
        aobj = ((Object []) (e[i1].invoke(k, aobj)));
        f();
        return ((Object) (aobj));
        aobj;
        throw new ca(cc.E);
        aobj;
        f();
        throw aobj;
        aobj;
        throw new ca(cc.F);
        aobj;
        aobj = ((InvocationTargetException) (aobj)).getCause();
        if (aobj != null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        throw new ca(cc.G);
        if (aobj instanceof Exception)
        {
            throw (Exception)aobj;
        }
        if (aobj instanceof Error)
        {
            throw (Error)aobj;
        } else
        {
            throw new ca(cc.H);
        }
        aobj;
        throw new ca(cc.K);
        aobj;
        throw new ca(cc.T);
    }

    private transient Object b(int i1, Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(i1, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new ca(new cd(cc.I, (new StringBuilder("Unexpected exception: ")).append(((Object) (aobj)).getClass().getName()).toString()));
        }
        return ((Object) (aobj));
    }

    private transient Object c(int i1, Object aobj[])
    {
        try
        {
            aobj = ((Object []) (a(i1, aobj)));
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
            throw new ca(new cd(cc.I, (new StringBuilder("Unexpected exception: ")).append(((Object) (aobj)).getClass().getName()).toString()));
        }
        return ((Object) (aobj));
    }

    public static boolean c()
    {
        return f;
    }

    public static cc d()
    {
        return g;
    }

    public static void e()
    {
        if (!f)
        {
            throw new ca(g);
        }
        Object obj = new _cls1();
        obj = new ac(new d(new _cls2()), null, ((SocketImpl) (obj)));
        Object obj1 = new Object();
        try
        {
            ((ac) (obj)).setOption(0, obj1);
            ((ac) (obj)).getOption(0);
            ((ac) (obj)).sendUrgentData(0);
            ((ac) (obj)).listen(0);
            ((ac) (obj)).getOutputStream();
            ((ac) (obj)).getInputStream();
            ((ac) (obj)).create(false);
            ((ac) (obj)).connect(((SocketAddress) (null)), 0);
            ((ac) (obj)).connect(((InetAddress) (null)), 0);
            ((ac) (obj)).connect(((String) (null)), 0);
            ((ac) (obj)).close();
            ((ac) (obj)).bind(null, 0);
            ((ac) (obj)).available();
            ((ac) (obj)).accept(((SocketImpl) (obj)));
            ((ac) (obj)).getFileDescriptor();
            ((ac) (obj)).getInetAddress();
            ((ac) (obj)).getLocalPort();
            ((ac) (obj)).getPort();
            ((ac) (obj)).setPerformancePreferences(0, 0, 0);
            ((ac) (obj)).shutdownInput();
            ((ac) (obj)).shutdownOutput();
            ((ac) (obj)).supportsUrgentData();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        catch (ca ca1)
        {
            throw ca1;
        }
        catch (Throwable throwable)
        {
            throw new ca(cc.U);
        }
    }

    private void f()
    {
        try
        {
            address = (InetAddress)a.get(k);
            fd = (FileDescriptor)b.get(k);
            localport = c.getInt(k);
            port = d.getInt(k);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ca(cc.N);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new ca(cc.O);
        }
    }

    public final b a()
    {
        return a(true);
    }

    public final void a(b b1)
    {
        synchronized (h)
        {
            h.add(b1);
        }
    }

    public final void accept(SocketImpl socketimpl)
    {
        c(0, new Object[] {
            socketimpl
        });
    }

    public final int available()
    {
        Integer integer = (Integer)c(1, new Object[0]);
        if (integer == null)
        {
            throw new ca(cc.J);
        } else
        {
            return integer.intValue();
        }
    }

    public final b b()
    {
        b b1;
        synchronized (h)
        {
            b1 = (b)h.poll();
        }
        return b1;
    }

    public final void bind(InetAddress inetaddress, int i1)
    {
        c(2, new Object[] {
            inetaddress, Integer.valueOf(i1)
        });
    }

    public final void close()
    {
        c(3, new Object[0]);
        try
        {
            if (m != null)
            {
                m.d();
            }
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public final void connect(String s, int i1)
    {
        try
        {
            c(6, new Object[] {
                s, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (s != null)
            {
                try
                {
                    b b1 = a(false);
                    b1.e();
                    b1.a(s);
                    b1.a(i1);
                    b1.g = ce.a(ioexception);
                    i.a(b1, b.a.i);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw s;
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
            }
        }
        throw ioexception;
    }

    public final void connect(InetAddress inetaddress, int i1)
    {
        try
        {
            c(4, new Object[] {
                inetaddress, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (inetaddress != null)
            {
                try
                {
                    b b1 = a(false);
                    b1.e();
                    b1.a(inetaddress);
                    b1.a(i1);
                    b1.g = ce.a(ioexception);
                    i.a(b1, b.a.i);
                }
                // Misplaced declaration of an exception variable
                catch (InetAddress inetaddress)
                {
                    throw inetaddress;
                }
                // Misplaced declaration of an exception variable
                catch (InetAddress inetaddress) { }
            }
        }
        throw ioexception;
    }

    public final void connect(SocketAddress socketaddress, int i1)
    {
        try
        {
            c(5, new Object[] {
                socketaddress, Integer.valueOf(i1)
            });
            return;
        }
        catch (IOException ioexception)
        {
            if (socketaddress != null)
            {
                try
                {
                    if (socketaddress instanceof InetSocketAddress)
                    {
                        b b1 = a(false);
                        socketaddress = (InetSocketAddress)socketaddress;
                        b1.e();
                        b1.a(socketaddress.getAddress());
                        b1.a(socketaddress.getPort());
                        b1.g = ce.a(ioexception);
                        i.a(b1, b.a.i);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (SocketAddress socketaddress)
                {
                    throw socketaddress;
                }
                // Misplaced declaration of an exception variable
                catch (SocketAddress socketaddress) { }
            }
        }
        throw ioexception;
    }

    public final void create(boolean flag)
    {
        c(7, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public final FileDescriptor getFileDescriptor()
    {
        return (FileDescriptor)b(8, new Object[0]);
    }

    public final InetAddress getInetAddress()
    {
        return (InetAddress)b(9, new Object[0]);
    }

    public final InputStream getInputStream()
    {
        Object obj;
        obj = (InputStream)c(10, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        x x1;
        if (m != null && m.a(((InputStream) (obj))))
        {
            return m;
        }
        m = new x(this, ((InputStream) (obj)), i);
        x1 = m;
        return x1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        return ((InputStream) (obj));
    }

    public final int getLocalPort()
    {
        return ((Integer)b(11, new Object[0])).intValue();
    }

    public final Object getOption(int i1)
    {
        return k.getOption(i1);
    }

    public final OutputStream getOutputStream()
    {
        Object obj;
        obj = (OutputStream)c(12, new Object[0]);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        w w1;
        if (l != null && l.a(((OutputStream) (obj))))
        {
            return l;
        }
        l = new w(this, ((OutputStream) (obj)));
        w1 = l;
        return w1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        return ((OutputStream) (obj));
    }

    public final int getPort()
    {
        return ((Integer)b(13, new Object[0])).intValue();
    }

    public final void listen(int i1)
    {
        c(14, new Object[] {
            Integer.valueOf(i1)
        });
    }

    public final void sendUrgentData(int i1)
    {
        c(15, new Object[] {
            Integer.valueOf(i1)
        });
    }

    public final void setOption(int i1, Object obj)
    {
        k.setOption(i1, obj);
    }

    public final void setPerformancePreferences(int i1, int j1, int k1)
    {
        b(16, new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1)
        });
    }

    public final void shutdownInput()
    {
        c(17, new Object[0]);
    }

    public final void shutdownOutput()
    {
        c(18, new Object[0]);
    }

    public final boolean supportsUrgentData()
    {
        return ((Boolean)b(19, new Object[0])).booleanValue();
    }

    public final String toString()
    {
        return k.toString();
    }

    static 
    {
        int i1;
        i1 = 0;
        e = new Method[20];
        f = false;
        g = cc.a;
        Field field;
        Field field1;
        Field field2;
        Field field3;
        a = java/net/SocketImpl.getDeclaredField("address");
        b = java/net/SocketImpl.getDeclaredField("fd");
        c = java/net/SocketImpl.getDeclaredField("localport");
        d = java/net/SocketImpl.getDeclaredField("port");
        field = a;
        field1 = b;
        field2 = c;
        field3 = d;
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        field.setAccessible(true);
        crittercism.android.j.a(new AccessibleObject[] {
            field1, field2, field3
        });
        e[0] = java/net/SocketImpl.getDeclaredMethod("accept", new Class[] {
            java/net/SocketImpl
        });
        e[1] = java/net/SocketImpl.getDeclaredMethod("available", new Class[0]);
        e[2] = java/net/SocketImpl.getDeclaredMethod("bind", new Class[] {
            java/net/InetAddress, Integer.TYPE
        });
        e[3] = java/net/SocketImpl.getDeclaredMethod("close", new Class[0]);
        e[4] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/net/InetAddress, Integer.TYPE
        });
        e[5] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/net/SocketAddress, Integer.TYPE
        });
        e[6] = java/net/SocketImpl.getDeclaredMethod("connect", new Class[] {
            java/lang/String, Integer.TYPE
        });
        e[7] = java/net/SocketImpl.getDeclaredMethod("create", new Class[] {
            Boolean.TYPE
        });
        e[8] = java/net/SocketImpl.getDeclaredMethod("getFileDescriptor", new Class[0]);
        e[9] = java/net/SocketImpl.getDeclaredMethod("getInetAddress", new Class[0]);
        e[10] = java/net/SocketImpl.getDeclaredMethod("getInputStream", new Class[0]);
        e[11] = java/net/SocketImpl.getDeclaredMethod("getLocalPort", new Class[0]);
        e[12] = java/net/SocketImpl.getDeclaredMethod("getOutputStream", new Class[0]);
        e[13] = java/net/SocketImpl.getDeclaredMethod("getPort", new Class[0]);
        e[14] = java/net/SocketImpl.getDeclaredMethod("listen", new Class[] {
            Integer.TYPE
        });
        e[15] = java/net/SocketImpl.getDeclaredMethod("sendUrgentData", new Class[] {
            Integer.TYPE
        });
        e[16] = java/net/SocketImpl.getDeclaredMethod("setPerformancePreferences", new Class[] {
            Integer.TYPE, Integer.TYPE, Integer.TYPE
        });
        e[17] = java/net/SocketImpl.getDeclaredMethod("shutdownInput", new Class[0]);
        e[18] = java/net/SocketImpl.getDeclaredMethod("shutdownOutput", new Class[0]);
        e[19] = java/net/SocketImpl.getDeclaredMethod("supportsUrgentData", new Class[0]);
        crittercism.android.j.a(e);
        f = true;
        return;
        Object obj;
        obj;
        f = false;
        g = cc.P;
        return;
        obj;
        f = false;
        g = cc.Q;
_L3:
        if (i1 >= 20)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        if (e[i1] != null) goto _L2; else goto _L1
_L1:
        g.a(i1);
        return;
_L2:
        i1++;
          goto _L3
        obj;
        f = false;
        g = cc.R;
        if (a == null)
        {
            g.a(1);
            return;
        }
        if (b == null)
        {
            g.a(2);
            return;
        }
        if (c == null)
        {
            g.a(3);
            return;
        }
        if (d == null)
        {
            g.a(4);
            return;
        } else
        {
            g.a(9999);
            return;
        }
        obj;
        f = false;
        g = cc.S;
        return;
        i1 = 20;
          goto _L1
    }

    private class _cls1 extends SocketImpl
    {

        protected final void accept(SocketImpl socketimpl)
        {
        }

        protected final int available()
        {
            return 0;
        }

        protected final void bind(InetAddress inetaddress, int i1)
        {
        }

        protected final void close()
        {
        }

        protected final void connect(String s, int i1)
        {
        }

        protected final void connect(InetAddress inetaddress, int i1)
        {
        }

        protected final void connect(SocketAddress socketaddress, int i1)
        {
        }

        protected final void create(boolean flag)
        {
        }

        protected final FileDescriptor getFileDescriptor()
        {
            return null;
        }

        protected final InetAddress getInetAddress()
        {
            return null;
        }

        protected final InputStream getInputStream()
        {
            return null;
        }

        protected final int getLocalPort()
        {
            return 0;
        }

        public final Object getOption(int i1)
        {
            return null;
        }

        protected final OutputStream getOutputStream()
        {
            return null;
        }

        protected final int getPort()
        {
            return 0;
        }

        protected final void listen(int i1)
        {
        }

        protected final void sendUrgentData(int i1)
        {
        }

        public final void setOption(int i1, Object obj)
        {
        }

        protected final void setPerformancePreferences(int i1, int j1, int k1)
        {
        }

        protected final void shutdownInput()
        {
        }

        protected final void shutdownOutput()
        {
        }

        protected final boolean supportsUrgentData()
        {
            return false;
        }

        public final String toString()
        {
            return null;
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements Executor
    {

        public final void execute(Runnable runnable)
        {
        }

        _cls2()
        {
        }
    }

}
