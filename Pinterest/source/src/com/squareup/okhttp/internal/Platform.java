// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.List;
import javax.net.ssl.SSLSocket;

public class Platform
{

    private static final Platform a = c();

    public Platform()
    {
    }

    public static Platform a()
    {
        return a;
    }

    public static URI a(URL url)
    {
        return url.toURI();
    }

    public static void a(String s)
    {
        System.out.println(s);
    }

    public static String b()
    {
        return "OkHttp";
    }

    private static Platform c()
    {
        Class class2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
_L2:
        Method method2;
        Method method3;
        method2 = class2.getMethod("setUseSessionTickets", new Class[] {
            Boolean.TYPE
        });
        method3 = class2.getMethod("setHostname", new Class[] {
            java/lang/String
        });
        Object obj;
        Object obj2;
        obj2 = Class.forName("android.net.TrafficStats");
        obj = ((Class) (obj2)).getMethod("tagSocket", new Class[] {
            java/net/Socket
        });
        obj2 = ((Class) (obj2)).getMethod("untagSocket", new Class[] {
            java/net/Socket
        });
_L3:
        Method method = class2.getMethod("setNpnProtocols", new Class[] {
            [B
        });
        Method method1 = class2.getMethod("getNpnSelectedProtocol", new Class[0]);
_L4:
        Object obj1;
        NoSuchMethodException nosuchmethodexception;
        try
        {
            return new Android(class2, method2, method3, ((Method) (obj)), ((Method) (obj2)), method, method1, (byte)0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L1
        obj1;
        class2 = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
          goto _L2
        obj1;
        obj1 = null;
_L10:
        obj2 = null;
          goto _L3
        obj1;
        obj1 = null;
_L9:
        obj2 = null;
          goto _L3
        nosuchmethodexception;
        nosuchmethodexception = null;
_L8:
        method1 = null;
          goto _L4
_L1:
        obj2 = "org.eclipse.jetty.alpn.ALPN";
        obj1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
_L5:
        Class class1 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$Provider").toString());
        Class class3 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$ClientProvider").toString());
        obj2 = Class.forName((new StringBuilder()).append(((String) (obj2))).append("$ServerProvider").toString());
        obj1 = new JdkWithJettyBootPlatform(((Class) (obj1)).getMethod("put", new Class[] {
            javax/net/ssl/SSLSocket, class1
        }), ((Class) (obj1)).getMethod("get", new Class[] {
            javax/net/ssl/SSLSocket
        }), class3, ((Class) (obj2)));
        return ((Platform) (obj1));
        obj1;
_L6:
        return new Platform();
        obj1;
        obj2 = "org.eclipse.jetty.npn.NextProtoNego";
        obj1 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
          goto _L5
        obj1;
          goto _L6
        obj1;
        if (true) goto _L1; else goto _L7
_L7:
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
          goto _L8
        Object obj3;
        obj3;
          goto _L9
        obj3;
          goto _L10
    }

    public String a(SSLSocket sslsocket)
    {
        return null;
    }

    public void a(Socket socket)
    {
    }

    public void a(Socket socket, InetSocketAddress inetsocketaddress, int i)
    {
        socket.connect(inetsocketaddress, i);
    }

    public void a(SSLSocket sslsocket, String s, String s1)
    {
        if (s1.equals("SSLv3"))
        {
            sslsocket.setEnabledProtocols(new String[] {
                "SSLv3"
            });
        }
    }

    public void a(SSLSocket sslsocket, List list)
    {
    }

    public void b(Socket socket)
    {
    }


    private class Android extends Platform
    {

        protected final Class a;
        private final Method b;
        private final Method c;
        private final Method d;
        private final Method e;
        private final Method f;
        private final Method g;

        public final String a(SSLSocket sslsocket)
        {
            if (g == null)
            {
                return null;
            }
            if (!a.isInstance(sslsocket))
            {
                return null;
            }
            try
            {
                sslsocket = (byte[])g.invoke(sslsocket, new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new RuntimeException(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            if (sslsocket == null)
            {
                return null;
            }
            sslsocket = new String(sslsocket, Util.d);
            return sslsocket;
        }

        public final void a(Socket socket)
        {
            if (d == null)
            {
                return;
            }
            try
            {
                d.invoke(null, new Object[] {
                    socket
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket);
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket);
            }
        }

        public final void a(Socket socket, InetSocketAddress inetsocketaddress, int i)
        {
            try
            {
                socket.connect(inetsocketaddress, i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                inetsocketaddress = new IOException("Exception in connect");
            }
            inetsocketaddress.initCause(socket);
            throw inetsocketaddress;
        }

        public final void a(SSLSocket sslsocket, String s, String s1)
        {
            a(sslsocket, s, s1);
            if (!s1.equals("TLSv1") || !a.isInstance(sslsocket))
            {
                break MISSING_BLOCK_LABEL_64;
            }
            b.invoke(sslsocket, new Object[] {
                Boolean.valueOf(true)
            });
            c.invoke(sslsocket, new Object[] {
                s
            });
            return;
            sslsocket;
            throw new RuntimeException(sslsocket);
            sslsocket;
            throw new AssertionError(sslsocket);
        }

        public final void a(SSLSocket sslsocket, List list)
        {
            int i;
            while (f == null || !a.isInstance(sslsocket)) 
            {
                return;
            }
            Buffer buffer;
            Protocol protocol;
            int j;
            try
            {
                buffer = new Buffer();
                j = list.size();
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new RuntimeException(sslsocket);
            }
            i = 0;
_L2:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            protocol = (Protocol)list.get(i);
            if (protocol != Protocol.a)
            {
                buffer.a(protocol.toString().length());
                buffer.a(protocol.toString());
            }
            break MISSING_BLOCK_LABEL_135;
            list = buffer.n();
            f.invoke(sslsocket, new Object[] {
                list
            });
            return;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void b(Socket socket)
        {
            if (e == null)
            {
                return;
            }
            try
            {
                e.invoke(null, new Object[] {
                    socket
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket);
            }
            // Misplaced declaration of an exception variable
            catch (Socket socket)
            {
                throw new RuntimeException(socket);
            }
        }

        private Android(Class class1, Method method, Method method1, Method method2, Method method3, Method method4, Method method5)
        {
            a = class1;
            b = method;
            c = method1;
            d = method2;
            e = method3;
            f = method4;
            g = method5;
        }

        Android(Class class1, Method method, Method method1, Method method2, Method method3, Method method4, Method method5, 
                byte byte0)
        {
            this(class1, method, method1, method2, method3, method4, method5);
        }
    }


    private class JdkWithJettyBootPlatform extends Platform
    {

        private final Method a;
        private final Method b;
        private final Class c;
        private final Class d;

        public final String a(SSLSocket sslsocket)
        {
            sslsocket = (JettyNegoProvider)Proxy.getInvocationHandler(a.invoke(null, new Object[] {
                sslsocket
            }));
            if (JettyNegoProvider.a(sslsocket) || JettyNegoProvider.b(sslsocket) != null)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
            return null;
            if (JettyNegoProvider.a(sslsocket))
            {
                return null;
            }
            try
            {
                sslsocket = JettyNegoProvider.b(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError();
            }
            return sslsocket;
        }

        public final void a(SSLSocket sslsocket, List list)
        {
            int i;
            Object obj;
            Object obj1;
            Class class1;
            int j;
            try
            {
                obj = new ArrayList(list.size());
                j = list.size();
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            i = 0;
_L2:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            obj1 = (Protocol)list.get(i);
            if (obj1 != Protocol.a)
            {
                ((List) (obj)).add(((Protocol) (obj1)).toString());
            }
            break MISSING_BLOCK_LABEL_157;
            list = com/squareup/okhttp/internal/Platform.getClassLoader();
            obj1 = c;
            class1 = d;
            obj = new JettyNegoProvider(((List) (obj)));
            list = ((List) (Proxy.newProxyInstance(list, new Class[] {
                obj1, class1
            }, ((InvocationHandler) (obj)))));
            b.invoke(null, new Object[] {
                sslsocket, list
            });
            return;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public JdkWithJettyBootPlatform(Method method, Method method1, Class class1, Class class2)
        {
            b = method;
            a = method1;
            c = class1;
            d = class2;
        }

        private class JettyNegoProvider
            implements InvocationHandler
        {

            private final List a;
            private boolean b;
            private String c;

            static boolean a(JettyNegoProvider jettynegoprovider)
            {
                return jettynegoprovider.b;
            }

            static String b(JettyNegoProvider jettynegoprovider)
            {
                return jettynegoprovider.c;
            }

            public Object invoke(Object obj, Method method, Object aobj[])
            {
                String s = method.getName();
                Class class1 = method.getReturnType();
                obj = ((Object) (aobj));
                if (aobj == null)
                {
                    obj = Util.b;
                }
                if (s.equals("supports") && Boolean.TYPE == class1)
                {
                    return Boolean.valueOf(true);
                }
                if (s.equals("unsupported") && Void.TYPE == class1)
                {
                    b = true;
                    return null;
                }
                if (s.equals("protocols") && obj.length == 0)
                {
                    return a;
                }
                if ((s.equals("selectProtocol") || s.equals("select")) && java/lang/String == class1 && obj.length == 1 && (obj[0] instanceof List))
                {
                    obj = (List)obj[0];
                    int j = ((List) (obj)).size();
                    for (int i = 0; i < j; i++)
                    {
                        if (a.contains(((List) (obj)).get(i)))
                        {
                            obj = (String)((List) (obj)).get(i);
                            c = ((String) (obj));
                            return obj;
                        }
                    }

                    obj = (String)a.get(0);
                    c = ((String) (obj));
                    return obj;
                }
                if ((s.equals("protocolSelected") || s.equals("selected")) && obj.length == 1)
                {
                    c = (String)obj[0];
                    return null;
                } else
                {
                    return method.invoke(this, ((Object []) (obj)));
                }
            }

            public JettyNegoProvider(List list)
            {
                a = list;
            }
        }

    }

}
