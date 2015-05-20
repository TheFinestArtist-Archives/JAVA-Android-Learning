// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Settings, Http20Draft12, Variant, Spdy3, 
//            SpdyStream, Ping, FrameWriter, ErrorCode, 
//            IncomingStreamHandler, PushObserver

public final class SpdyConnection
    implements Closeable
{

    static final boolean l;
    private static final ExecutorService m;
    final Protocol a;
    final boolean b;
    long c;
    long d;
    final Settings e;
    final Settings f;
    final Variant g;
    final Socket h;
    final FrameWriter i;
    final long j;
    final Reader k;
    private final IncomingStreamHandler n;
    private final Map o;
    private final String p;
    private int q;
    private int r;
    private boolean s;
    private long t;
    private final ExecutorService u;
    private Map v;
    private final PushObserver w;
    private int x;
    private boolean y;
    private final Set z;

    private SpdyConnection(Builder builder)
    {
        byte byte0 = 2;
        super();
        o = new HashMap();
        t = System.nanoTime();
        c = 0L;
        e = new Settings();
        f = new Settings();
        y = false;
        z = new LinkedHashSet();
        a = Builder.a(builder);
        w = Builder.b(builder);
        b = Builder.c(builder);
        n = Builder.d(builder);
        int i1;
        if (Builder.c(builder))
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        r = i1;
        if (Builder.c(builder) && a == Protocol.d)
        {
            r = r + 2;
        }
        i1 = byte0;
        if (Builder.c(builder))
        {
            i1 = 1;
        }
        x = i1;
        if (Builder.c(builder))
        {
            e.a(7, 0, 0x1000000);
        }
        p = Builder.e(builder);
        if (a == Protocol.d)
        {
            g = new Http20Draft12();
            u = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Util.c(String.format("OkHttp %s Push Observer", new Object[] {
                p
            })));
        } else
        if (a == Protocol.c)
        {
            g = new Spdy3();
            u = null;
        } else
        {
            throw new AssertionError(a);
        }
        d = f.d();
        h = Builder.f(builder);
        i = g.newWriter(Okio.a(Okio.a(Builder.f(builder))), b);
        j = g.maxFrameSize();
        k = new Reader((byte)0);
        (new Thread(k)).start();
    }

    SpdyConnection(Builder builder, byte byte0)
    {
        this(builder);
    }

    static String a(SpdyConnection spdyconnection)
    {
        return spdyconnection.p;
    }

    private void a(ErrorCode errorcode, ErrorCode errorcode1)
    {
        if (!l && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!s) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        errorcode = null;
_L9:
        this;
        JVM INSTR monitorenter ;
        SpdyStream aspdystream[];
        if (o.isEmpty())
        {
            break MISSING_BLOCK_LABEL_345;
        }
        aspdystream = (SpdyStream[])o.values().toArray(new SpdyStream[o.size()]);
        o.clear();
        a(false);
_L13:
        if (v == null) goto _L4; else goto _L3
_L3:
        Ping aping[];
        aping = (Ping[])v.values().toArray(new Ping[v.size()]);
        v = null;
_L12:
        this;
        JVM INSTR monitorexit ;
        obj = errorcode;
        if (aspdystream == null) goto _L6; else goto _L5
_L5:
        int i1;
        int k1;
        k1 = aspdystream.length;
        i1 = 0;
_L8:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aspdystream[i1];
        ((SpdyStream) (obj)).a(errorcode1);
        obj = errorcode;
_L10:
        i1++;
        errorcode = ((ErrorCode) (obj));
        if (true) goto _L8; else goto _L7
_L2:
        s = true;
        i1 = q;
        this;
        JVM INSTR monitorexit ;
        i.goAway(i1, errorcode, Util.a);
        obj;
        JVM INSTR monitorexit ;
        errorcode = null;
          goto _L9
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        errorcode;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw errorcode;
        }
        // Misplaced declaration of an exception variable
        catch (ErrorCode errorcode) { }
          goto _L9
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        IOException ioexception;
        ioexception;
        obj = errorcode;
        if (errorcode != null)
        {
            obj = ioexception;
        }
          goto _L10
_L7:
        obj = errorcode;
_L6:
        if (aping != null)
        {
            int l1 = aping.length;
            for (int j1 = 0; j1 < l1; j1++)
            {
                aping[j1].c();
            }

        }
        i.close();
        errorcode = ((ErrorCode) (obj));
_L11:
        try
        {
            h.close();
        }
        // Misplaced declaration of an exception variable
        catch (ErrorCode errorcode) { }
        if (errorcode != null)
        {
            throw errorcode;
        } else
        {
            return;
        }
        errorcode;
        if (obj != null)
        {
            errorcode = ((ErrorCode) (obj));
        }
          goto _L11
_L4:
        aping = null;
          goto _L12
        aspdystream = null;
          goto _L13
    }

    static void a(SpdyConnection spdyconnection, int i1, int j1)
    {
        m.submit(spdyconnection. new _cls3("OkHttp %s ping %08x%08x", new Object[] {
            spdyconnection.p, Integer.valueOf(i1), Integer.valueOf(j1)
        }, i1, j1));
    }

    static void a(SpdyConnection spdyconnection, int i1, ErrorCode errorcode)
    {
        spdyconnection.u.submit(spdyconnection. new _cls7("OkHttp %s Push Reset[%s]", new Object[] {
            spdyconnection.p, Integer.valueOf(i1)
        }, i1, errorcode));
    }

    static void a(SpdyConnection spdyconnection, int i1, List list)
    {
        spdyconnection;
        JVM INSTR monitorenter ;
        if (!spdyconnection.z.contains(Integer.valueOf(i1)))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        spdyconnection.a(i1, ErrorCode.b);
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        spdyconnection.z.add(Integer.valueOf(i1));
        spdyconnection;
        JVM INSTR monitorexit ;
        spdyconnection.u.submit(spdyconnection. new _cls4("OkHttp %s Push Request[%s]", new Object[] {
            spdyconnection.p, Integer.valueOf(i1)
        }, i1, list));
        return;
        list;
        spdyconnection;
        JVM INSTR monitorexit ;
        throw list;
    }

    static void a(SpdyConnection spdyconnection, int i1, List list, boolean flag)
    {
        spdyconnection.u.submit(spdyconnection. new _cls5("OkHttp %s Push Headers[%s]", new Object[] {
            spdyconnection.p, Integer.valueOf(i1)
        }, i1, list, flag));
    }

    static void a(SpdyConnection spdyconnection, int i1, BufferedSource bufferedsource, int j1, boolean flag)
    {
        Buffer buffer = new Buffer();
        bufferedsource.a(j1);
        bufferedsource.b(buffer, j1);
        if (buffer.c() != (long)j1)
        {
            throw new IOException((new StringBuilder()).append(buffer.c()).append(" != ").append(j1).toString());
        } else
        {
            spdyconnection.u.submit(spdyconnection. new _cls6("OkHttp %s Push Data[%s]", new Object[] {
                spdyconnection.p, Integer.valueOf(i1)
            }, i1, buffer, j1, flag));
            return;
        }
    }

    static void a(SpdyConnection spdyconnection, ErrorCode errorcode, ErrorCode errorcode1)
    {
        spdyconnection.a(errorcode, errorcode1);
    }

    static void a(SpdyConnection spdyconnection, boolean flag, int i1, int j1, Ping ping)
    {
        FrameWriter framewriter = spdyconnection.i;
        framewriter;
        JVM INSTR monitorenter ;
        if (ping == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ping.a();
        spdyconnection.i.ping(flag, i1, j1);
        framewriter;
        JVM INSTR monitorexit ;
        return;
        spdyconnection;
        framewriter;
        JVM INSTR monitorexit ;
        throw spdyconnection;
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        long l1 = System.nanoTime();
_L1:
        t = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        l1 = 0x7fffffffffffffffL;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(SpdyConnection spdyconnection, int i1)
    {
        return spdyconnection.a == Protocol.d && i1 != 0 && (i1 & 1) == 0;
    }

    static int b(SpdyConnection spdyconnection, int i1)
    {
        spdyconnection.q = i1;
        return i1;
    }

    private SpdyStream b(List list, boolean flag)
    {
        boolean flag1;
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        FrameWriter framewriter = i;
        framewriter;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (s)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_47;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        list;
        framewriter;
        JVM INSTR monitorexit ;
        throw list;
        SpdyStream spdystream;
        int i1;
        i1 = r;
        r = r + 2;
        spdystream = new SpdyStream(i1, this, flag1, false, list);
        if (spdystream.a())
        {
            o.put(Integer.valueOf(i1), spdystream);
            a(false);
        }
        this;
        JVM INSTR monitorexit ;
        i.synStream(flag1, false, i1, 0, list);
        framewriter;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            i.flush();
        }
        return spdystream;
    }

    static boolean b(SpdyConnection spdyconnection)
    {
        return spdyconnection.s;
    }

    static int c(SpdyConnection spdyconnection)
    {
        return spdyconnection.q;
    }

    private Ping c(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (v == null) goto _L2; else goto _L1
_L1:
        Ping ping = (Ping)v.remove(Integer.valueOf(i1));
_L4:
        this;
        JVM INSTR monitorexit ;
        return ping;
_L2:
        ping = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static Ping c(SpdyConnection spdyconnection, int i1)
    {
        return spdyconnection.c(i1);
    }

    static int d(SpdyConnection spdyconnection)
    {
        return spdyconnection.r;
    }

    static Map e(SpdyConnection spdyconnection)
    {
        return spdyconnection.o;
    }

    static IncomingStreamHandler f(SpdyConnection spdyconnection)
    {
        return spdyconnection.n;
    }

    static ExecutorService f()
    {
        return m;
    }

    static boolean g(SpdyConnection spdyconnection)
    {
        return spdyconnection.y;
    }

    static boolean h(SpdyConnection spdyconnection)
    {
        spdyconnection.y = true;
        return true;
    }

    static boolean i(SpdyConnection spdyconnection)
    {
        spdyconnection.s = true;
        return true;
    }

    static PushObserver j(SpdyConnection spdyconnection)
    {
        return spdyconnection.w;
    }

    static Set k(SpdyConnection spdyconnection)
    {
        return spdyconnection.z;
    }

    public final Protocol a()
    {
        return a;
    }

    final SpdyStream a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)o.get(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    public final SpdyStream a(List list, boolean flag)
    {
        return b(list, flag);
    }

    final void a(int i1, long l1)
    {
        m.submit(new _cls2("OkHttp Window Update %s stream %d", new Object[] {
            p, Integer.valueOf(i1)
        }, i1, l1));
    }

    final void a(int i1, ErrorCode errorcode)
    {
        m.submit(new _cls1("OkHttp %s stream %d", new Object[] {
            p, Integer.valueOf(i1)
        }, i1, errorcode));
    }

    public final void a(int i1, boolean flag, Buffer buffer, long l1)
    {
        long l2 = l1;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        i.data(flag, i1, buffer, 0);
_L4:
        return;
_L5:
        int j1;
        j1 = (int)Math.min(Math.min(l2, d), j);
        d = d - (long)j1;
        this;
        JVM INSTR monitorexit ;
        l2 -= j1;
        FrameWriter framewriter = i;
        boolean flag1;
        if (flag && l2 == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        framewriter.data(flag1, i1, buffer, j1);
_L2:
        if (l2 <= 0L) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
        while (d <= 0L) 
        {
            wait();
        }
          goto _L5
        buffer;
        throw new InterruptedIOException();
        buffer;
        this;
        JVM INSTR monitorexit ;
        throw buffer;
    }

    final SpdyStream b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        SpdyStream spdystream = (SpdyStream)o.remove(Integer.valueOf(i1));
        if (spdystream == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (o.isEmpty())
        {
            a(true);
        }
        this;
        JVM INSTR monitorexit ;
        return spdystream;
        Exception exception;
        exception;
        throw exception;
    }

    final void b(int i1, ErrorCode errorcode)
    {
        i.rstStream(i1, errorcode);
    }

    public final boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = t;
        boolean flag;
        if (l1 != 0x7fffffffffffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final long c()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = t;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void close()
    {
        a(ErrorCode.a, ErrorCode.l);
    }

    public final void d()
    {
        i.flush();
    }

    public final void e()
    {
        i.connectionPreface();
        i.settings(e);
        int i1 = e.d();
        if (i1 != 0x10000)
        {
            i.windowUpdate(0, i1 - 0x10000);
        }
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyConnection.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = flag;
        m = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.c("OkHttp SpdyConnection"));
    }

    private class Builder
    {

        private String a;
        private Socket b;
        private IncomingStreamHandler c;
        private Protocol d;
        private PushObserver e;
        private boolean f;

        static Protocol a(Builder builder)
        {
            return builder.d;
        }

        static PushObserver b(Builder builder)
        {
            return builder.e;
        }

        static boolean c(Builder builder)
        {
            return builder.f;
        }

        static IncomingStreamHandler d(Builder builder)
        {
            return builder.c;
        }

        static String e(Builder builder)
        {
            return builder.a;
        }

        static Socket f(Builder builder)
        {
            return builder.b;
        }

        public final Builder a(Protocol protocol)
        {
            d = protocol;
            return this;
        }

        public final SpdyConnection a()
        {
            return new SpdyConnection(this, (byte)0);
        }

        public Builder(String s1, Socket socket)
        {
            c = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            d = Protocol.c;
            e = PushObserver.CANCEL;
            a = s1;
            f = true;
            b = socket;
        }
    }


    private class Reader extends NamedRunnable
        implements FrameReader.Handler
    {

        FrameReader a;
        final SpdyConnection b;

        protected final void a()
        {
            Object obj;
            ErrorCode errorcode;
            Object obj2;
            ErrorCode errorcode1;
            obj2 = ErrorCode.g;
            errorcode1 = ErrorCode.g;
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            a = b.g.newReader(Okio.a(Okio.b(b.h)), b.b);
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            if (b.b)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            a.readConnectionPreface();
_L2:
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            if (a.nextFrame(this)) goto _L2; else goto _L1
_L1:
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            obj2 = ErrorCode.a;
            errorcode = ((ErrorCode) (obj2));
            obj = obj2;
            ErrorCode errorcode2 = ErrorCode.l;
            IOException ioexception;
            Object obj1;
            try
            {
                SpdyConnection.a(b, ((ErrorCode) (obj2)), errorcode2);
            }
            catch (IOException ioexception1) { }
            Util.a(a);
            return;
            obj;
            obj = errorcode;
            obj2 = ErrorCode.b;
            obj = ErrorCode.b;
            try
            {
                SpdyConnection.a(b, ((ErrorCode) (obj2)), ((ErrorCode) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
            Util.a(a);
            return;
            obj1;
            obj2 = obj;
            obj = obj1;
_L4:
            try
            {
                SpdyConnection.a(b, ((ErrorCode) (obj2)), errorcode1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            Util.a(a);
            throw obj;
            obj;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void ackSettings()
        {
        }

        public void alternateService(int i1, String s1, ByteString bytestring, String s2, int j1, long l1)
        {
        }

        public void data(boolean flag, int i1, BufferedSource bufferedsource, int j1)
        {
            if (SpdyConnection.a(b, i1))
            {
                SpdyConnection.a(b, i1, bufferedsource, j1, flag);
            } else
            {
                SpdyStream spdystream = b.a(i1);
                if (spdystream == null)
                {
                    b.a(i1, ErrorCode.c);
                    bufferedsource.g(j1);
                    return;
                }
                spdystream.a(bufferedsource, j1);
                if (flag)
                {
                    spdystream.g();
                    return;
                }
            }
        }

        public void goAway(int i1, ErrorCode errorcode, ByteString bytestring)
        {
            bytestring.e();
            errorcode = b;
            errorcode;
            JVM INSTR monitorenter ;
            SpdyConnection.i(b);
            bytestring = SpdyConnection.e(b).entrySet().iterator();
            do
            {
                if (!bytestring.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)bytestring.next();
                if (((Integer)entry.getKey()).intValue() > i1 && ((SpdyStream)entry.getValue()).b())
                {
                    ((SpdyStream)entry.getValue()).c(ErrorCode.k);
                    bytestring.remove();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_121;
            bytestring;
            errorcode;
            JVM INSTR monitorexit ;
            throw bytestring;
            errorcode;
            JVM INSTR monitorexit ;
        }

        public void headers(boolean flag, boolean flag1, int i1, int j1, List list, HeadersMode headersmode)
        {
            boolean flag2;
            j1 = 1;
            flag2 = false;
            if (!SpdyConnection.a(b, i1)) goto _L2; else goto _L1
_L1:
            SpdyConnection.a(b, i1, list, flag1);
_L4:
            return;
_L2:
            synchronized (b)
            {
                if (!SpdyConnection.b(b))
                {
                    break MISSING_BLOCK_LABEL_60;
                }
            }
            return;
            list;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw list;
            SpdyStream spdystream = b.a(i1);
            if (spdystream != null)
            {
                break MISSING_BLOCK_LABEL_244;
            }
            if (headersmode == HeadersMode.b)
            {
                break MISSING_BLOCK_LABEL_303;
            }
            j1 = ((flag2) ? 1 : 0);
            if (headersmode == HeadersMode.c)
            {
                break MISSING_BLOCK_LABEL_303;
            }
            class _cls1 extends NamedRunnable
            {

                final SpdyStream a;
                final Reader b;

                public final void a()
                {
                    try
                    {
                        SpdyConnection.f(b.b).receive(a);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        throw new RuntimeException(ioexception);
                    }
                }

                transient _cls1(String s1, Object aobj[], SpdyStream spdystream)
                {
                    b = Reader.this;
                    a = spdystream;
                    super(s1, aobj);
                }
            }

            for (; j1 == 0; j1 = 1)
            {
                break MISSING_BLOCK_LABEL_118;
            }

            b.a(i1, ErrorCode.c);
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            if (i1 > SpdyConnection.c(b))
            {
                break MISSING_BLOCK_LABEL_133;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            if (i1 % 2 != SpdyConnection.d(b) % 2)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            list = new SpdyStream(i1, b, flag, flag1, list);
            SpdyConnection.b(b, i1);
            SpdyConnection.e(b).put(Integer.valueOf(i1), list);
            SpdyConnection.f().submit(new _cls1("OkHttp %s stream %d", new Object[] {
                SpdyConnection.a(b), Integer.valueOf(i1)
            }, list));
            spdyconnection;
            JVM INSTR monitorexit ;
            return;
            spdyconnection;
            JVM INSTR monitorexit ;
            if (headersmode != HeadersMode.a)
            {
                j1 = 0;
            }
            if (j1 != 0)
            {
                spdystream.b(ErrorCode.b);
                b.b(i1);
                return;
            }
            spdystream.a(list, headersmode);
            if (flag1)
            {
                spdystream.g();
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void ping(boolean flag, int i1, int j1)
        {
            if (flag)
            {
                Ping ping1 = SpdyConnection.c(b, i1);
                if (ping1 != null)
                {
                    ping1.b();
                }
                return;
            } else
            {
                SpdyConnection.a(b, i1, j1);
                return;
            }
        }

        public void priority(int i1, int j1, int k1, boolean flag)
        {
        }

        public void pushPromise(int i1, int j1, List list)
        {
            SpdyConnection.a(b, j1, list);
        }

        public void rstStream(int i1, ErrorCode errorcode)
        {
            if (SpdyConnection.a(b, i1))
            {
                SpdyConnection.a(b, i1, errorcode);
            } else
            {
                SpdyStream spdystream = b.b(i1);
                if (spdystream != null)
                {
                    spdystream.c(errorcode);
                    return;
                }
            }
        }

        public void settings(boolean flag, Settings settings1)
        {
            obj = null;
            SpdyConnection spdyconnection = b;
            spdyconnection;
            JVM INSTR monitorenter ;
            int i1 = b.f.d();
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            b.f.a();
            int j1;
            b.f.a(settings1);
            class _cls2 extends NamedRunnable
            {

                final Reader a;

                public final void a()
                {
                    try
                    {
                        a.b.i.ackSettings();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

                transient _cls2(String s1, Object aobj[])
                {
                    a = Reader.this;
                    super(s1, aobj);
                }
            }

            if (b.a == Protocol.d)
            {
                SpdyConnection.f().submit(new _cls2("OkHttp %s ACK Settings", new Object[] {
                    SpdyConnection.a(b)
                }));
            }
            j1 = b.f.d();
            if (j1 == -1 || j1 == i1) goto _L2; else goto _L1
_L1:
            long l2 = j1 - i1;
            if (SpdyConnection.g(b))
            {
                break MISSING_BLOCK_LABEL_173;
            }
            settings1 = b;
            settings1.d = ((SpdyConnection) (settings1)).d + l2;
            if (l2 <= 0L)
            {
                break MISSING_BLOCK_LABEL_165;
            }
            settings1.notifyAll();
            SpdyConnection.h(b);
            long l1;
            settings1 = ((Settings) (obj));
            l1 = l2;
            if (SpdyConnection.e(b).isEmpty())
            {
                break MISSING_BLOCK_LABEL_234;
            }
            settings1 = (SpdyStream[])SpdyConnection.e(b).values().toArray(new SpdyStream[SpdyConnection.e(b).size()]);
            l1 = l2;
_L4:
            spdyconnection;
            JVM INSTR monitorexit ;
            if (settings1 != null && l1 != 0L)
            {
                for (obj = SpdyConnection.e(b).values().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    synchronized ((SpdyStream)((Iterator) (obj)).next())
                    {
                        settings1.a(l1);
                    }
                }

            }
            break MISSING_BLOCK_LABEL_309;
            obj;
            settings1;
            JVM INSTR monitorexit ;
            throw obj;
            settings1;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw settings1;
            return;
_L2:
            l1 = 0L;
            settings1 = ((Settings) (obj));
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void windowUpdate(int i1, long l1)
        {
            if (i1 == 0)
            {
                synchronized (b)
                {
                    SpdyConnection spdyconnection1 = b;
                    spdyconnection1.d = spdyconnection1.d + l1;
                    b.notifyAll();
                }
                return;
            }
            break MISSING_BLOCK_LABEL_50;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw exception;
            SpdyStream spdystream;
            spdystream = b.a(i1);
            if (spdystream == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            spdystream;
            JVM INSTR monitorenter ;
            spdystream.a(l1);
            spdystream;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            spdystream;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        private Reader()
        {
            b = SpdyConnection.this;
            super("OkHttp %s", new Object[] {
                SpdyConnection.a(SpdyConnection.this)
            });
        }

        Reader(byte byte0)
        {
            this();
        }
    }


    private class _cls3 extends NamedRunnable
    {

        final boolean a = true;
        final int b;
        final int c;
        final Ping d = null;
        final SpdyConnection e;

        public final void a()
        {
            try
            {
                SpdyConnection.a(e, a, b, c, d);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls3(String s1, Object aobj[], int i1, int j1)
        {
            e = SpdyConnection.this;
            b = i1;
            c = j1;
            super(s1, aobj);
        }
    }


    private class _cls7 extends NamedRunnable
    {

        final int a;
        final ErrorCode b;
        final SpdyConnection c;

        public final void a()
        {
            SpdyConnection.j(c).onReset(a, b);
            synchronized (c)
            {
                SpdyConnection.k(c).remove(Integer.valueOf(a));
            }
            return;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            throw exception;
        }

        transient _cls7(String s1, Object aobj[], int i1, ErrorCode errorcode)
        {
            c = SpdyConnection.this;
            a = i1;
            b = errorcode;
            super(s1, aobj);
        }
    }


    private class _cls4 extends NamedRunnable
    {

        final int a;
        final List b;
        final SpdyConnection c;

        public final void a()
        {
            if (!SpdyConnection.j(c).onRequest(a, b))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            c.i.rstStream(a, ErrorCode.l);
            synchronized (c)
            {
                SpdyConnection.k(c).remove(Integer.valueOf(a));
            }
            return;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (IOException ioexception) { }
        }

        transient _cls4(String s1, Object aobj[], int i1, List list)
        {
            c = SpdyConnection.this;
            a = i1;
            b = list;
            super(s1, aobj);
        }
    }


    private class _cls5 extends NamedRunnable
    {

        final int a;
        final List b;
        final boolean c;
        final SpdyConnection d;

        public final void a()
        {
            boolean flag;
            flag = SpdyConnection.j(d).onHeaders(a, b, c);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_48;
            }
            d.i.rstStream(a, ErrorCode.l);
            if (flag)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            if (!c)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            synchronized (d)
            {
                SpdyConnection.k(d).remove(Integer.valueOf(a));
            }
            return;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (IOException ioexception) { }
        }

        transient _cls5(String s1, Object aobj[], int i1, List list, boolean flag)
        {
            d = SpdyConnection.this;
            a = i1;
            b = list;
            c = flag;
            super(s1, aobj);
        }
    }


    private class _cls6 extends NamedRunnable
    {

        final int a;
        final Buffer b;
        final int c;
        final boolean d;
        final SpdyConnection e;

        public final void a()
        {
            boolean flag = SpdyConnection.j(e).onData(a, b, c, d);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_52;
            }
            e.i.rstStream(a, ErrorCode.l);
            if (flag)
            {
                break MISSING_BLOCK_LABEL_63;
            }
            if (!d)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            synchronized (e)
            {
                SpdyConnection.k(e).remove(Integer.valueOf(a));
            }
            return;
            exception;
            spdyconnection;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            catch (IOException ioexception) { }
        }

        transient _cls6(String s1, Object aobj[], int i1, Buffer buffer, int j1, boolean flag)
        {
            e = SpdyConnection.this;
            a = i1;
            b = buffer;
            c = j1;
            d = flag;
            super(s1, aobj);
        }
    }


    private class _cls2 extends NamedRunnable
    {

        final int a;
        final long b;
        final SpdyConnection c;

        public final void a()
        {
            try
            {
                c.i.windowUpdate(a, b);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls2(String s1, Object aobj[], int i1, long l1)
        {
            c = SpdyConnection.this;
            a = i1;
            b = l1;
            super(s1, aobj);
        }
    }


    private class _cls1 extends NamedRunnable
    {

        final int a;
        final ErrorCode b;
        final SpdyConnection c;

        public final void a()
        {
            try
            {
                c.b(a, b);
                return;
            }
            catch (IOException ioexception)
            {
                return;
            }
        }

        transient _cls1(String s1, Object aobj[], int i1, ErrorCode errorcode)
        {
            c = SpdyConnection.this;
            a = i1;
            b = errorcode;
            super(s1, aobj);
        }
    }

}
