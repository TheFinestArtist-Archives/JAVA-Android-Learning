// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, OkHeaders, StatusLine, HttpEngine, 
//            RequestLine, RetryableSink

public final class SpdyTransport
    implements Transport
{

    private static final List a = Util.a(new ByteString[] {
        ByteString.a("connection"), ByteString.a("host"), ByteString.a("keep-alive"), ByteString.a("proxy-connection"), ByteString.a("transfer-encoding")
    });
    private static final List b = Util.a(new ByteString[] {
        ByteString.a("connection"), ByteString.a("host"), ByteString.a("keep-alive"), ByteString.a("proxy-connection"), ByteString.a("te"), ByteString.a("transfer-encoding"), ByteString.a("encoding"), ByteString.a("upgrade")
    });
    private final HttpEngine c;
    private final SpdyConnection d;
    private SpdyStream e;

    public SpdyTransport(HttpEngine httpengine, SpdyConnection spdyconnection)
    {
        c = httpengine;
        d = spdyconnection;
    }

    private static boolean a(Protocol protocol, ByteString bytestring)
    {
        if (protocol == Protocol.c)
        {
            return a.contains(bytestring);
        }
        if (protocol == Protocol.d)
        {
            return b.contains(bytestring);
        } else
        {
            throw new AssertionError(protocol);
        }
    }

    public final boolean canReuseConnection()
    {
        return true;
    }

    public final Sink createRequestBody(Request request)
    {
        writeRequestHeaders(request);
        return e.f();
    }

    public final void disconnect(HttpEngine httpengine)
    {
        e.a(ErrorCode.l);
    }

    public final void emptyTransferStream()
    {
    }

    public final void flushRequest()
    {
        e.f().close();
    }

    public final Source getTransferStream(CacheRequest cacherequest)
    {
        return new SpdySource(e, cacherequest);
    }

    public final com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        List list = e.c();
        Protocol protocol = d.a();
        Object obj = null;
        String s = "HTTP/1.1";
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        builder.b(OkHeaders.d, protocol.toString());
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                break;
            }
            ByteString bytestring = ((Header)list.get(i)).h;
            String s2 = ((Header)list.get(i)).i.a();
            int j = 0;
            while (j < s2.length()) 
            {
                int l = s2.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s2.length();
                }
                String s1 = s2.substring(j, k);
                if (bytestring.equals(Header.a))
                {
                    obj = s1;
                } else
                if (bytestring.equals(Header.g))
                {
                    s = s1;
                } else
                if (!a(protocol, bytestring))
                {
                    builder.a(bytestring.a(), s1);
                }
                j = k + 1;
            }
            i++;
        } while (true);
        if (obj == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (s == null)
        {
            throw new ProtocolException("Expected ':version' header not present");
        } else
        {
            obj = StatusLine.a((new StringBuilder()).append(s).append(" ").append(((String) (obj))).toString());
            return (new com.squareup.okhttp.Response.Builder()).a(((StatusLine) (obj)).a).a(((StatusLine) (obj)).b).a(((StatusLine) (obj)).c).a(builder.a());
        }
    }

    public final void releaseConnectionOnIdle()
    {
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        throw new UnsupportedOperationException();
    }

    public final void writeRequestHeaders(Request request)
    {
        SpdyConnection spdyconnection;
        ArrayList arraylist;
        Object obj;
        String s;
        boolean flag;
        if (e != null)
        {
            return;
        }
        c.b();
        flag = c.c();
        obj = RequestLine.a(c.j().m());
        spdyconnection = d;
        Protocol protocol = d.a();
        Headers headers = request.e();
        arraylist = new ArrayList(headers.a() + 10);
        arraylist.add(new Header(Header.b, request.d()));
        arraylist.add(new Header(Header.c, RequestLine.a(request.a())));
        s = HttpEngine.a(request.a());
        int i;
        if (Protocol.c == protocol)
        {
            arraylist.add(new Header(Header.g, ((String) (obj))));
            arraylist.add(new Header(Header.f, s));
        } else
        if (Protocol.d == protocol)
        {
            arraylist.add(new Header(Header.e, s));
        } else
        {
            throw new AssertionError();
        }
        arraylist.add(new Header(Header.d, request.a().getProtocol()));
        request = new LinkedHashSet();
        i = 0;
        if (i >= headers.a())
        {
            break MISSING_BLOCK_LABEL_509;
        }
        obj = ByteString.a(headers.a(i).toLowerCase(Locale.US));
        s = headers.b(i);
        if (!a(protocol, ((ByteString) (obj))) && !((ByteString) (obj)).equals(Header.b) && !((ByteString) (obj)).equals(Header.c) && !((ByteString) (obj)).equals(Header.d) && !((ByteString) (obj)).equals(Header.e) && !((ByteString) (obj)).equals(Header.f) && !((ByteString) (obj)).equals(Header.g))
        {
            if (!request.add(obj))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(new Header(((ByteString) (obj)), s));
        }
_L6:
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_214;
_L1:
        int j = 0;
_L4:
        if (j < arraylist.size())
        {
label0:
            {
                if (!((Header)arraylist.get(j)).h.equals(obj))
                {
                    break label0;
                }
                arraylist.set(j, new Header(((ByteString) (obj)), (new StringBuilder(((Header)arraylist.get(j)).i.a())).append('\0').append(s).toString()));
            }
        }
        continue; /* Loop/switch isn't completed */
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        e = spdyconnection.a(arraylist, flag);
        e.d().a(c.a.b(), TimeUnit.MILLISECONDS);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }


    private class SpdySource
        implements Source
    {

        private final SpdyStream a;
        private final Source b;
        private final CacheRequest c;
        private final OutputStream d;
        private boolean e;
        private boolean f;

        private boolean b()
        {
            Exception exception;
            long l = a.d().f();
            a.d().a(100L, TimeUnit.MILLISECONDS);
            try
            {
                Util.a(this);
            }
            catch (IOException ioexception)
            {
                a.d().a(l, TimeUnit.NANOSECONDS);
                return false;
            }
            finally
            {
                a.d().a(l, TimeUnit.NANOSECONDS);
            }
            a.d().a(l, TimeUnit.NANOSECONDS);
            return true;
            throw exception;
        }

        public final Timeout a()
        {
            return b.a();
        }

        public final long b(Buffer buffer, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (f)
            {
                throw new IllegalStateException("closed");
            }
            if (e)
            {
                l = -1L;
            } else
            {
                long l1 = b.b(buffer, l);
                if (l1 == -1L)
                {
                    e = true;
                    if (c != null)
                    {
                        d.close();
                    }
                    return -1L;
                }
                l = l1;
                if (d != null)
                {
                    buffer.a(d, buffer.c() - l1, l1);
                    return l1;
                }
            }
            return l;
        }

        public void close()
        {
            if (!f)
            {
                if (!e && d != null)
                {
                    b();
                }
                f = true;
                if (!e)
                {
                    a.b(ErrorCode.l);
                    if (c != null)
                    {
                        c.abort();
                        return;
                    }
                }
            }
        }

        SpdySource(SpdyStream spdystream, CacheRequest cacherequest)
        {
            a = spdystream;
            b = spdystream.e();
            if (cacherequest != null)
            {
                spdystream = cacherequest.getBody();
            } else
            {
                spdystream = null;
            }
            if (spdystream == null)
            {
                cacherequest = null;
            }
            d = spdystream;
            c = cacherequest;
        }
    }

}
