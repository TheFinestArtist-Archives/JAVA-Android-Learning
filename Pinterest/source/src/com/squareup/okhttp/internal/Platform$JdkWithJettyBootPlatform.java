// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp.internal:
//            Platform

class d extends Platform
{

    private final Method a;
    private final Method b;
    private final Class c;
    private final Class d;

    public final String a(SSLSocket sslsocket)
    {
        sslsocket = (d)Proxy.getInvocationHandler(a.invoke(null, new Object[] {
            sslsocket
        }));
        if (a(sslsocket) || a(sslsocket) != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
        return null;
        if (a(sslsocket))
        {
            return null;
        }
        try
        {
            sslsocket = a(sslsocket);
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
        obj = new d(((List) (obj)));
        list = ((List) (Proxy.newProxyInstance(list, new Class[] {
            obj1, class1
        }, ((java.lang.reflect.InvocationHandler) (obj)))));
        b.invoke(null, new Object[] {
            sslsocket, list
        });
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public (Method method, Method method1, Class class1, Class class2)
    {
        b = method;
        a = method1;
        c = class1;
        d = class2;
    }
}
