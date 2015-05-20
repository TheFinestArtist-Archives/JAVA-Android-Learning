// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpDate;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;

public class HttpURLConnectionImpl extends HttpURLConnection
{

    final OkHttpClient a;
    protected IOException b;
    protected HttpEngine c;
    Handshake d;
    private com.squareup.okhttp.Headers.Builder e;
    private long f;
    private int g;
    private Headers h;
    private Route i;

    public HttpURLConnectionImpl(URL url, OkHttpClient okhttpclient)
    {
        super(url);
        e = new com.squareup.okhttp.Headers.Builder();
        f = -1L;
        a = okhttpclient;
    }

    private Headers a()
    {
        if (h == null)
        {
            Object obj = c().h();
            com.squareup.okhttp.Headers.Builder builder = ((Response) (obj)).f().b();
            Object obj1 = new StringBuilder();
            Platform.a();
            obj1 = ((StringBuilder) (obj1)).append(Platform.b()).append("-Response-Source").toString();
            if (((Response) (obj)).j() == null)
            {
                if (((Response) (obj)).k() == null)
                {
                    obj = "NONE";
                } else
                {
                    obj = (new StringBuilder("CACHE ")).append(((Response) (obj)).c()).toString();
                }
            } else
            if (((Response) (obj)).k() == null)
            {
                obj = (new StringBuilder("NETWORK ")).append(((Response) (obj)).c()).toString();
            } else
            {
                obj = (new StringBuilder("CONDITIONAL_CACHE ")).append(((Response) (obj)).j().c()).toString();
            }
            h = builder.a(((String) (obj1)), ((String) (obj))).a();
        }
        return h;
    }

    private HttpEngine a(String s, Connection connection, RetryableSink retryablesink, Response response)
    {
        boolean flag1 = false;
        boolean flag = false;
        Object obj = (new com.squareup.okhttp.Request.Builder()).a(getURL()).c(s);
        Object obj1 = e.a();
        for (int j = 0; j < ((Headers) (obj1)).a(); j++)
        {
            ((com.squareup.okhttp.Request.Builder) (obj)).b(((Headers) (obj1)).a(j), ((Headers) (obj1)).b(j));
        }

        if (HttpMethod.b(s))
        {
            if (f != -1L)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).a("Content-Length", Long.toString(f));
            } else
            if (chunkLength > 0)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).a("Transfer-Encoding", "chunked");
            } else
            {
                flag = true;
            }
            flag1 = flag;
            if (((Headers) (obj1)).a("Content-Type") == null)
            {
                ((com.squareup.okhttp.Request.Builder) (obj)).a("Content-Type", "application/x-www-form-urlencoded");
                flag1 = flag;
            }
        }
        if (((Headers) (obj1)).a("User-Agent") == null)
        {
            s = System.getProperty("http.agent");
            if (s == null)
            {
                s = (new StringBuilder("Java")).append(System.getProperty("java.version")).toString();
            }
            ((com.squareup.okhttp.Request.Builder) (obj)).a("User-Agent", s);
        }
        obj1 = ((com.squareup.okhttp.Request.Builder) (obj)).a();
        obj = a;
        s = ((String) (obj));
        if (Internal.a.a(((OkHttpClient) (obj))) != null)
        {
            s = ((String) (obj));
            if (!getUseCaches())
            {
                s = a.q().a(null);
            }
        }
        return new HttpEngine(s, ((Request) (obj1)), flag1, connection, null, retryablesink, response);
    }

    private void a(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.addAll(a.o());
        }
        s = s.split(",", -1);
        int k = s.length;
        int j = 0;
        while (j < k) 
        {
            String s1 = s[j];
            try
            {
                arraylist.add(Protocol.a(s1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
            j++;
        }
        a.a(arraylist);
    }

    private boolean a(boolean flag)
    {
        Handshake handshake;
        c.a();
        i = c.k();
        if (c.j() == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        handshake = c.j().k();
_L1:
        d = handshake;
        if (flag)
        {
            try
            {
                c.p();
            }
            catch (IOException ioexception)
            {
                HttpEngine httpengine = c.a(ioexception);
                if (httpengine != null)
                {
                    c = httpengine;
                    return false;
                } else
                {
                    b = ioexception;
                    throw ioexception;
                }
            }
        }
        return true;
        handshake = null;
          goto _L1
    }

    private void b()
    {
        Object obj;
        obj = null;
        if (b != null)
        {
            throw b;
        }
        if (c != null)
        {
            return;
        }
        connected = true;
        if (!doOutput) goto _L2; else goto _L1
_L1:
        if (!method.equals("GET")) goto _L4; else goto _L3
_L3:
        method = "POST";
_L2:
        RetryableSink retryablesink = obj;
        try
        {
            if (!doOutput)
            {
                break MISSING_BLOCK_LABEL_78;
            }
        }
        catch (IOException ioexception)
        {
            b = ioexception;
            throw ioexception;
        }
        retryablesink = obj;
        if (f == 0L)
        {
            retryablesink = Util.a();
        }
        c = a(method, null, retryablesink, null);
        return;
_L4:
        if (HttpMethod.b(method)) goto _L2; else goto _L5
_L5:
        throw new ProtocolException((new StringBuilder()).append(method).append(" does not support writing").toString());
    }

    private HttpEngine c()
    {
        b();
        if (c.f())
        {
            return c;
        }
        do
        {
            while (!a(true)) ;
            response = c.h();
            request = c.q();
            if (request == null)
            {
                c.l();
                return c;
            }
            if (response.i())
            {
                int j = g + 1;
                g = j;
                if (j > 20)
                {
                    throw new ProtocolException((new StringBuilder("Too many redirects: ")).append(g).toString());
                }
            }
            url = request.a();
            e = request.e().b();
            sink = c.d();
            if (!request.d().equals(method))
            {
                sink = null;
            }
            if (sink == null || (sink instanceof RetryableSink))
            {
                if (!c.b(request.a()))
                {
                    c.l();
                }
                Connection connection = c.n();
                c = a(request.d(), connection, (RetryableSink)sink, response);
            } else
            {
                throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
            }
        } while (true);
    }

    public final void addRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.a();
            Platform.a((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            a(s1, true);
            return;
        } else
        {
            e.a(s, s1);
            return;
        }
    }

    public final void connect()
    {
        b();
        while (!a(false)) ;
    }

    public final void disconnect()
    {
        if (c == null)
        {
            return;
        } else
        {
            c.m();
            return;
        }
    }

    public int getConnectTimeout()
    {
        return a.a();
    }

    public final InputStream getErrorStream()
    {
        Object obj = null;
        InputStream inputstream;
        HttpEngine httpengine;
        try
        {
            httpengine = c();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        inputstream = obj;
        if (!httpengine.o())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        inputstream = obj;
        if (httpengine.h().c() >= 400)
        {
            inputstream = httpengine.i();
        }
        return inputstream;
    }

    public final String getHeaderField(int j)
    {
        String s;
        try
        {
            s = a().b(j);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final String getHeaderField(String s)
    {
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        return StatusLine.a(c().h()).toString();
        s = a().a(s);
        return s;
        s;
        return null;
    }

    public final String getHeaderFieldKey(int j)
    {
        String s;
        try
        {
            s = a().a(j);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final Map getHeaderFields()
    {
        Map map;
        try
        {
            map = OkHeaders.a(a(), StatusLine.a(c().h()).toString());
        }
        catch (IOException ioexception)
        {
            return Collections.emptyMap();
        }
        return map;
    }

    public final InputStream getInputStream()
    {
        if (!doInput)
        {
            throw new ProtocolException("This protocol does not support input");
        }
        Object obj = c();
        if (getResponseCode() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        }
        obj = ((HttpEngine) (obj)).i();
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder("No response body exists; responseCode=")).append(getResponseCode()).toString());
        } else
        {
            return ((InputStream) (obj));
        }
    }

    public final OutputStream getOutputStream()
    {
        connect();
        BufferedSink bufferedsink = c.e();
        if (bufferedsink == null)
        {
            throw new ProtocolException((new StringBuilder("method does not support a request body: ")).append(method).toString());
        }
        if (c.f())
        {
            throw new ProtocolException("cannot write request body after response has been read");
        } else
        {
            return bufferedsink.e();
        }
    }

    public final Permission getPermission()
    {
        String s = getURL().getHost();
        int j = Util.a(getURL());
        if (usingProxy())
        {
            InetSocketAddress inetsocketaddress = (InetSocketAddress)a.d().address();
            s = inetsocketaddress.getHostName();
            j = inetsocketaddress.getPort();
        }
        return new SocketPermission((new StringBuilder()).append(s).append(":").append(j).toString(), "connect, resolve");
    }

    public int getReadTimeout()
    {
        return a.b();
    }

    public final Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        } else
        {
            return OkHeaders.a(e.a(), null);
        }
    }

    public final String getRequestProperty(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return e.c(s);
        }
    }

    public final int getResponseCode()
    {
        return c().h().c();
    }

    public String getResponseMessage()
    {
        return c().h().d();
    }

    public void setConnectTimeout(int j)
    {
        a.a(j, TimeUnit.MILLISECONDS);
    }

    public void setFixedLengthStreamingMode(int j)
    {
        setFixedLengthStreamingMode(j);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        if (super.connected)
        {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0)
        {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("contentLength < 0");
        } else
        {
            f = l;
            super.fixedContentLength = (int)Math.min(l, 0x7fffffffL);
            return;
        }
    }

    public void setIfModifiedSince(long l)
    {
        super.setIfModifiedSince(l);
        if (ifModifiedSince != 0L)
        {
            e.b("If-Modified-Since", HttpDate.a(new Date(ifModifiedSince)));
            return;
        } else
        {
            e.b("If-Modified-Since");
            return;
        }
    }

    public void setReadTimeout(int j)
    {
        a.b(j, TimeUnit.MILLISECONDS);
    }

    public void setRequestMethod(String s)
    {
        if (!HttpMethod.a.contains(s))
        {
            throw new ProtocolException((new StringBuilder("Expected one of ")).append(HttpMethod.a).append(" but was ").append(s).toString());
        } else
        {
            method = s;
            return;
        }
    }

    public final void setRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.a();
            Platform.a((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            a(s1, false);
            return;
        } else
        {
            e.b(s, s1);
            return;
        }
    }

    public final boolean usingProxy()
    {
        Proxy proxy;
        if (i != null)
        {
            proxy = i.a();
        } else
        {
            proxy = a.d();
        }
        return proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT;
    }
}
