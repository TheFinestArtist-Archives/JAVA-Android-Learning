// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import java.io.File;
import java.io.IOException;
import java.net.CacheRequest;
import okio.BufferedSource;

// Referenced classes of package com.squareup.okhttp:
//            Response, Request

public final class Cache
{

    final InternalCache a = new _cls1();
    private final DiskLruCache b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public Cache(File file, long l)
    {
        b = DiskLruCache.a(file, l);
    }

    static int a(BufferedSource bufferedsource)
    {
        return b(bufferedsource);
    }

    static CacheRequest a(Cache cache, Response response)
    {
        return cache.a(response);
    }

    private CacheRequest a(Response response)
    {
label0:
        {
            {
                Object obj = response.a().d();
                if (!HttpMethod.a(response.a().d()))
                {
                    break label0;
                }
                IOException ioexception;
                try
                {
                    b(response.a());
                }
                // Misplaced declaration of an exception variable
                catch (Response response)
                {
                    return null;
                }
            }
            return null;
        }
        if (!((String) (obj)).equals("GET") || OkHeaders.b(response))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj = new Entry(response);
        response = b.b(Util.b(response.a().c()));
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        ((Entry) (obj)).a(response);
        obj = new CacheRequestImpl(response);
        return ((CacheRequest) (obj));
        response;
        response = null;
_L2:
        a(((com.squareup.okhttp.internal.DiskLruCache.Editor) (response)));
        return null;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void a(Cache cache)
    {
        cache.b();
    }

    static void a(Cache cache, Request request)
    {
        cache.b(request);
    }

    static void a(Cache cache, CacheStrategy cachestrategy)
    {
        cache.a(cachestrategy);
    }

    static void a(Response response, Response response1)
    {
        Entry entry = new Entry(response1);
        response1 = CacheResponseBody.a((CacheResponseBody)response.g());
        response = null;
        try
        {
            response1 = response1.a();
        }
        // Misplaced declaration of an exception variable
        catch (Response response1)
        {
            a(((com.squareup.okhttp.internal.DiskLruCache.Editor) (response)));
            return;
        }
        if (response1 == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        response = response1;
        entry.a(response1);
        response = response1;
        response1.a();
    }

    private static void a(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
    {
        if (editor == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        editor.b();
        return;
        editor;
    }

    private void a(CacheStrategy cachestrategy)
    {
        this;
        JVM INSTR monitorenter ;
        g = g + 1;
        if (cachestrategy.a == null) goto _L2; else goto _L1
_L1:
        e = e + 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (cachestrategy.b != null)
        {
            f = f + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        cachestrategy;
        throw cachestrategy;
    }

    static int b(Cache cache)
    {
        int i = cache.c;
        cache.c = i + 1;
        return i;
    }

    private static int b(BufferedSource bufferedsource)
    {
        bufferedsource = bufferedsource.m();
        int i;
        try
        {
            i = Integer.parseInt(bufferedsource);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new IOException((new StringBuilder("Expected an integer but was \"")).append(bufferedsource).append("\"").toString());
        }
        return i;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        f = f + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(Request request)
    {
        b.c(Util.b(request.c()));
    }

    static int c(Cache cache)
    {
        int i = cache.d;
        cache.d = i + 1;
        return i;
    }

    final Response a(Request request)
    {
        Object obj = Util.b(request.c());
        Entry entry;
        try
        {
            obj = b.a(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        try
        {
            entry = new Entry(((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)).a(0));
        }
        // Misplaced declaration of an exception variable
        catch (Request request)
        {
            Util.a(((java.io.Closeable) (obj)));
            return null;
        }
        obj = entry.a(((com.squareup.okhttp.internal.DiskLruCache.Snapshot) (obj)));
        if (!entry.a(request, ((Response) (obj))))
        {
            Util.a(((Response) (obj)).g());
            return null;
        } else
        {
            return ((Response) (obj));
        }
    }

    public final void a()
    {
        b.close();
    }

    private class _cls1
        implements InternalCache
    {

        final Cache a;

        public Response get(Request request)
        {
            return a.a(request);
        }

        public CacheRequest put(Response response)
        {
            return Cache.a(a, response);
        }

        public void remove(Request request)
        {
            Cache.a(a, request);
        }

        public void trackConditionalCacheHit()
        {
            Cache.a(a);
        }

        public void trackResponse(CacheStrategy cachestrategy)
        {
            Cache.a(a, cachestrategy);
        }

        public void update(Response response, Response response1)
        {
            Cache.a(response, response1);
        }

        _cls1()
        {
            a = Cache.this;
            super();
        }
    }


    private class Entry
    {

        private final String a;
        private final Headers b;
        private final String c;
        private final Protocol d;
        private final int e;
        private final String f;
        private final Headers g;
        private final Handshake h;

        private static List a(BufferedSource bufferedsource)
        {
            int j = Cache.a(bufferedsource);
            if (j != -1) goto _L2; else goto _L1
_L1:
            Object obj = Collections.emptyList();
_L4:
            return ((List) (obj));
_L2:
            ArrayList arraylist;
            CertificateFactory certificatefactory;
            int i;
            try
            {
                certificatefactory = CertificateFactory.getInstance("X.509");
                arraylist = new ArrayList(j);
            }
            // Misplaced declaration of an exception variable
            catch (BufferedSource bufferedsource)
            {
                throw new IOException(bufferedsource.getMessage());
            }
            i = 0;
            obj = arraylist;
            if (i >= j) goto _L4; else goto _L3
_L3:
            arraylist.add(certificatefactory.generateCertificate(new ByteArrayInputStream(ByteString.b(bufferedsource.m()).f())));
            i++;
            break MISSING_BLOCK_LABEL_37;
        }

        private static void a(Writer writer, List list)
        {
            int i;
            int j;
            try
            {
                writer.write(Integer.toString(list.size()));
                writer.write(10);
                j = list.size();
            }
            // Misplaced declaration of an exception variable
            catch (Writer writer)
            {
                throw new IOException(writer.getMessage());
            }
            i = 0;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            writer.write(ByteString.a(((Certificate)list.get(i)).getEncoded()).b());
            writer.write(10);
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_28;
_L1:
        }

        private boolean a()
        {
            return a.startsWith("https://");
        }

        public final Response a(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
        {
            String s = g.a("Content-Type");
            String s1 = g.a("Content-Length");
            Request request = (new Request.Builder()).a(a).c(f).a(b).a();
            return (new Response.Builder()).a(request).a(d).a(e).a(f).a(g).a(new CacheResponseBody(snapshot, s, s1)).a(h).a();
        }

        public final void a(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
        {
            boolean flag = false;
            editor = new BufferedWriter(new OutputStreamWriter(editor.a(0), Util.d));
            editor.write(a);
            editor.write(10);
            editor.write(c);
            editor.write(10);
            editor.write(Integer.toString(b.a()));
            editor.write(10);
            for (int i = 0; i < b.a(); i++)
            {
                editor.write(b.a(i));
                editor.write(": ");
                editor.write(b.b(i));
                editor.write(10);
            }

            editor.write((new StatusLine(d, e, f)).toString());
            editor.write(10);
            editor.write(Integer.toString(g.a()));
            editor.write(10);
            for (int j = ((flag) ? 1 : 0); j < g.a(); j++)
            {
                editor.write(g.a(j));
                editor.write(": ");
                editor.write(g.b(j));
                editor.write(10);
            }

            if (a())
            {
                editor.write(10);
                editor.write(h.a());
                editor.write(10);
                a(((Writer) (editor)), h.b());
                a(((Writer) (editor)), h.d());
            }
            editor.close();
        }

        public final boolean a(Request request, Response response)
        {
            return a.equals(request.c()) && c.equals(request.d()) && OkHeaders.a(response, b, request);
        }

        public Entry(Response response)
        {
            a = response.a().c();
            b = OkHeaders.c(response);
            c = response.a().d();
            d = response.b();
            e = response.c();
            f = response.d();
            g = response.f();
            h = response.e();
        }

        public Entry(InputStream inputstream)
        {
            boolean flag;
            flag = false;
            super();
            Object obj;
            Object obj1;
            int j;
            obj = Okio.a(Okio.a(inputstream));
            a = ((BufferedSource) (obj)).m();
            c = ((BufferedSource) (obj)).m();
            obj1 = new Headers.Builder();
            j = Cache.a(((BufferedSource) (obj)));
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj1)).a(((BufferedSource) (obj)).m());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            b = ((Headers.Builder) (obj1)).a();
            obj1 = StatusLine.a(((BufferedSource) (obj)).m());
            d = ((StatusLine) (obj1)).a;
            e = ((StatusLine) (obj1)).b;
            f = ((StatusLine) (obj1)).c;
            obj1 = new Headers.Builder();
            j = Cache.a(((BufferedSource) (obj)));
            i = ((flag) ? 1 : 0);
_L4:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Headers.Builder) (obj1)).a(((BufferedSource) (obj)).m());
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            g = ((Headers.Builder) (obj1)).a();
            if (!a())
            {
                break MISSING_BLOCK_LABEL_257;
            }
            obj1 = ((BufferedSource) (obj)).m();
            if (((String) (obj1)).length() > 0)
            {
                throw new IOException((new StringBuilder("expected \"\" but was \"")).append(((String) (obj1))).append("\"").toString());
            }
            break MISSING_BLOCK_LABEL_231;
            obj;
            inputstream.close();
            throw obj;
            h = Handshake.a(((BufferedSource) (obj)).m(), a(((BufferedSource) (obj))), a(((BufferedSource) (obj))));
_L5:
            inputstream.close();
            return;
            h = null;
              goto _L5
        }
    }


    private class CacheRequestImpl extends CacheRequest
    {

        final Cache a;
        private final com.squareup.okhttp.internal.DiskLruCache.Editor b;
        private OutputStream c;
        private boolean d;
        private OutputStream e;

        static boolean a(CacheRequestImpl cacherequestimpl)
        {
            return cacherequestimpl.d;
        }

        static boolean b(CacheRequestImpl cacherequestimpl)
        {
            cacherequestimpl.d = true;
            return true;
        }

        public final void abort()
        {
label0:
            {
                synchronized (a)
                {
                    if (!d)
                    {
                        break label0;
                    }
                }
                return;
            }
            d = true;
            Cache.c(a);
            obj;
            JVM INSTR monitorexit ;
            Util.a(c);
            try
            {
                b.b();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final OutputStream getBody()
        {
            return e;
        }

        public CacheRequestImpl(com.squareup.okhttp.internal.DiskLruCache.Editor editor)
        {
            a = Cache.this;
            super();
            b = editor;
            c = editor.a(1);
            class _cls1 extends FilterOutputStream
            {

                final Cache a;
                final com.squareup.okhttp.internal.DiskLruCache.Editor b;
                final CacheRequestImpl c;

                public void close()
                {
label0:
                    {
                        synchronized (c.a)
                        {
                            if (!CacheRequestImpl.a(c))
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    CacheRequestImpl.b(c);
                    Cache.b(c.a);
                    cache1;
                    JVM INSTR monitorexit ;
                    super.close();
                    b.a();
                    return;
                    exception;
                    cache1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public void write(byte abyte0[], int i, int j)
                {
                    out.write(abyte0, i, j);
                }

                _cls1(OutputStream outputstream, Cache cache, com.squareup.okhttp.internal.DiskLruCache.Editor editor)
                {
                    c = CacheRequestImpl.this;
                    a = cache;
                    b = editor;
                    super(outputstream);
                }
            }

            e = new _cls1(c, Cache.this, editor);
        }
    }


    private class CacheResponseBody extends ResponseBody
    {

        private final com.squareup.okhttp.internal.DiskLruCache.Snapshot a;
        private final BufferedSource b;
        private final String c;
        private final String d;

        static com.squareup.okhttp.internal.DiskLruCache.Snapshot a(CacheResponseBody cacheresponsebody)
        {
            return cacheresponsebody.a;
        }

        public final BufferedSource a()
        {
            return b;
        }

        public CacheResponseBody(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot, String s, String s1)
        {
            a = snapshot;
            c = s;
            d = s1;
            class _cls1 extends ForwardingSource
            {

                final com.squareup.okhttp.internal.DiskLruCache.Snapshot a;
                final CacheResponseBody b;

                public void close()
                {
                    a.close();
                    super.close();
                }

                _cls1(Source source, com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot)
                {
                    b = CacheResponseBody.this;
                    a = snapshot;
                    super(source);
                }
            }

            b = Okio.a(new _cls1(Okio.a(snapshot.a(1)), snapshot));
        }
    }

}
