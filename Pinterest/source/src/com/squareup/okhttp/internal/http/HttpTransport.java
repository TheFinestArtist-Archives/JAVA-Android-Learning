// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import java.net.CacheRequest;
import java.net.Proxy;
import okio.Sink;
import okio.Source;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, HttpEngine, HttpConnection, OkHeaders, 
//            RetryableSink, RequestLine

public final class HttpTransport
    implements Transport
{

    private final HttpEngine a;
    private final HttpConnection b;

    public HttpTransport(HttpEngine httpengine, HttpConnection httpconnection)
    {
        a = httpengine;
        b = httpconnection;
    }

    public final boolean canReuseConnection()
    {
        while ("close".equalsIgnoreCase(a.g().a("Connection")) || "close".equalsIgnoreCase(a.h().a("Connection")) || b.c()) 
        {
            return false;
        }
        return true;
    }

    public final Sink createRequestBody(Request request)
    {
        long l = OkHeaders.a(request);
        if (a.c)
        {
            if (l > 0x7fffffffL)
            {
                throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
            }
            if (l != -1L)
            {
                writeRequestHeaders(request);
                return new RetryableSink((int)l);
            } else
            {
                return new RetryableSink();
            }
        }
        if ("chunked".equalsIgnoreCase(request.a("Transfer-Encoding")))
        {
            writeRequestHeaders(request);
            return b.h();
        }
        if (l != -1L)
        {
            writeRequestHeaders(request);
            return b.a(l);
        } else
        {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final void disconnect(HttpEngine httpengine)
    {
        b.a(httpengine);
    }

    public final void emptyTransferStream()
    {
        b.i();
    }

    public final void flushRequest()
    {
        b.d();
    }

    public final Source getTransferStream(CacheRequest cacherequest)
    {
        if (!a.o())
        {
            return b.a(cacherequest, 0L);
        }
        if ("chunked".equalsIgnoreCase(a.h().a("Transfer-Encoding")))
        {
            return b.a(cacherequest, a);
        }
        long l = OkHeaders.a(a.h());
        if (l != -1L)
        {
            return b.a(cacherequest, l);
        } else
        {
            return b.a(cacherequest);
        }
    }

    public final com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        return b.g();
    }

    public final void releaseConnectionOnIdle()
    {
        if (canReuseConnection())
        {
            b.a();
            return;
        } else
        {
            b.b();
            return;
        }
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        b.a(retryablesink);
    }

    public final void writeRequestHeaders(Request request)
    {
        a.b();
        String s = RequestLine.a(request, a.j().d().a().type(), a.j().m());
        b.a(request.e(), s);
    }
}
