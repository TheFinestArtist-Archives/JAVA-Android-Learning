// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

// Referenced classes of package okio:
//            RealBufferedSink, RealBufferedSource, Timeout, Sink, 
//            BufferedSink, Source, BufferedSource, AsyncTimeout

public final class Okio
{

    private static final Logger a = Logger.getLogger(okio/Okio.getName());

    private Okio()
    {
    }

    static Logger a()
    {
        return a;
    }

    public static BufferedSink a(Sink sink)
    {
        if (sink == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new RealBufferedSink(sink);
        }
    }

    public static BufferedSource a(Source source)
    {
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new RealBufferedSource(source);
        }
    }

    public static Sink a(OutputStream outputstream)
    {
        return a(outputstream, new Timeout());
    }

    private static Sink a(OutputStream outputstream, Timeout timeout)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new _cls1(timeout, outputstream);
        }
    }

    public static Sink a(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            AsyncTimeout asynctimeout = c(socket);
            return new AsyncTimeout._cls1(asynctimeout, a(socket.getOutputStream(), ((Timeout) (asynctimeout))));
        }
    }

    public static Source a(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return a(((InputStream) (new FileInputStream(file))));
        }
    }

    public static Source a(InputStream inputstream)
    {
        return a(inputstream, new Timeout());
    }

    private static Source a(InputStream inputstream, Timeout timeout)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new _cls2(timeout, inputstream);
        }
    }

    public static Source b(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            AsyncTimeout asynctimeout = c(socket);
            return new AsyncTimeout._cls2(asynctimeout, a(socket.getInputStream(), asynctimeout));
        }
    }

    private static AsyncTimeout c(Socket socket)
    {
        return new _cls3(socket);
    }


    private class _cls1
        implements Sink
    {

        final Timeout a;
        final OutputStream b;

        public final Timeout a()
        {
            return a;
        }

        public final void a(Buffer buffer, long l)
        {
            Util.a(buffer.b, 0L, l);
            do
            {
                if (l <= 0L)
                {
                    break;
                }
                a.i();
                Segment segment = buffer.a;
                int i = (int)Math.min(l, segment.c - segment.b);
                b.write(segment.a, segment.b, i);
                segment.b = segment.b + i;
                long l1 = l - (long)i;
                buffer.b = buffer.b - (long)i;
                l = l1;
                if (segment.b == segment.c)
                {
                    buffer.a = segment.a();
                    SegmentPool.a.a(segment);
                    l = l1;
                }
            } while (true);
        }

        public final void b()
        {
            b.flush();
        }

        public final void close()
        {
            b.close();
        }

        public final String toString()
        {
            return (new StringBuilder("sink(")).append(b).append(")").toString();
        }

        _cls1(Timeout timeout, OutputStream outputstream)
        {
            a = timeout;
            b = outputstream;
            super();
        }
    }


    private class _cls2
        implements Source
    {

        final Timeout a;
        final InputStream b;

        public final Timeout a()
        {
            return a;
        }

        public final long b(Buffer buffer, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            a.i();
            Segment segment = buffer.c(1);
            int i = (int)Math.min(l, 2048 - segment.c);
            i = b.read(segment.a, segment.c, i);
            if (i == -1)
            {
                return -1L;
            } else
            {
                segment.c = segment.c + i;
                buffer.b = buffer.b + (long)i;
                return (long)i;
            }
        }

        public final void close()
        {
            b.close();
        }

        public final String toString()
        {
            return (new StringBuilder("source(")).append(b).append(")").toString();
        }

        _cls2(Timeout timeout, InputStream inputstream)
        {
            a = timeout;
            b = inputstream;
            super();
        }
    }


    private class _cls3 extends AsyncTimeout
    {

        final Socket a;

        protected final void a()
        {
            try
            {
                a.close();
                return;
            }
            catch (Exception exception)
            {
                Okio.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(a).toString(), exception);
            }
        }

        _cls3(Socket socket)
        {
            a = socket;
            super();
        }
    }

}
