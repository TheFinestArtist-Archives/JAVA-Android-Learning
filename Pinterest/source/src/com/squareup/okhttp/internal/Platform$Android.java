// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

// Referenced classes of package com.squareup.okhttp.internal:
//            Platform, Util

class <init> extends Platform
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
        super.a(sslsocket, s, s1);
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

    private (Class class1, Method method, Method method1, Method method2, Method method3, Method method4, Method method5)
    {
        a = class1;
        b = method;
        c = method1;
        d = method2;
        e = method3;
        f = method4;
        g = method5;
    }

    g(Class class1, Method method, Method method1, Method method2, Method method3, Method method4, Method method5, 
            byte byte0)
    {
        this(class1, method, method1, method2, method3, method4, method5);
    }
}
