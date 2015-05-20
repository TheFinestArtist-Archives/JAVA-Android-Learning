// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.BufferedSource;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter

public final class Spdy3
    implements Variant
{

    static final byte a[];

    public Spdy3()
    {
    }

    public final Protocol getProtocol()
    {
        return Protocol.c;
    }

    public final int maxFrameSize()
    {
        return 16383;
    }

    public final FrameReader newReader(BufferedSource bufferedsource, boolean flag)
    {
        return new Reader(bufferedsource, flag);
    }

    public final FrameWriter newWriter(BufferedSink bufferedsink, boolean flag)
    {
        return new Writer(bufferedsink, flag);
    }

    static 
    {
        try
        {
            a = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.d.name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError();
        }
    }

    private class Reader
        implements FrameReader
    {

        private final BufferedSource a;
        private final boolean b;
        private final NameValueBlockReader c;

        private static transient IOException a(String s, Object aobj[])
        {
            throw new IOException(String.format(s, aobj));
        }

        private void a(FrameReader.Handler handler, int i, int j)
        {
            boolean flag = true;
            int k = a.j();
            if (j != k * 8 + 4)
            {
                throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(k)
                });
            }
            Settings settings = new Settings();
            for (j = 0; j < k; j++)
            {
                int l = a.j();
                settings.a(l & 0xffffff, (0xff000000 & l) >>> 24, a.j());
            }

            if ((i & 1) == 0)
            {
                flag = false;
            }
            handler.settings(flag, settings);
        }

        public final void close()
        {
            c.a();
        }

        public final boolean nextFrame(FrameReader.Handler handler)
        {
            boolean flag = false;
            boolean flag1 = false;
            int i;
            int j;
            int k;
            int l;
            try
            {
                k = a.j();
                l = a.j();
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            if ((0x80000000 & k) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            j = (0xff000000 & l) >>> 24;
            l = 0xffffff & l;
            if (i != 0)
            {
                i = (0x7fff0000 & k) >>> 16;
                if (i != 3)
                {
                    throw new ProtocolException((new StringBuilder("version != 3: ")).append(i).toString());
                }
                switch (k & 0xffff)
                {
                case 5: // '\005'
                default:
                    a.g(l);
                    return true;

                case 1: // '\001'
                    i = a.j();
                    k = a.j();
                    a.i();
                    List list = c.a(l - 10);
                    if ((j & 1) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if ((j & 2) != 0)
                    {
                        flag1 = true;
                    }
                    handler.headers(flag1, flag, i & 0x7fffffff, k & 0x7fffffff, list, HeadersMode.a);
                    return true;

                case 2: // '\002'
                    i = a.j();
                    List list1 = c.a(l - 4);
                    if ((j & 1) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    handler.headers(false, flag, i & 0x7fffffff, -1, list1, HeadersMode.b);
                    return true;

                case 3: // '\003'
                    if (l != 8)
                    {
                        throw a("TYPE_RST_STREAM length: %d != 8", new Object[] {
                            Integer.valueOf(l)
                        });
                    }
                    i = a.j();
                    j = a.j();
                    ErrorCode errorcode = ErrorCode.a(j);
                    if (errorcode == null)
                    {
                        throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                            Integer.valueOf(j)
                        });
                    } else
                    {
                        handler.rstStream(i & 0x7fffffff, errorcode);
                        return true;
                    }

                case 4: // '\004'
                    a(handler, j, l);
                    return true;

                case 6: // '\006'
                    if (l != 4)
                    {
                        throw a("TYPE_PING length: %d != 4", new Object[] {
                            Integer.valueOf(l)
                        });
                    }
                    i = a.j();
                    boolean flag2 = b;
                    if ((i & 1) == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag2 == flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    handler.ping(flag, i, 0);
                    return true;

                case 7: // '\007'
                    if (l != 8)
                    {
                        throw a("TYPE_GOAWAY length: %d != 8", new Object[] {
                            Integer.valueOf(l)
                        });
                    }
                    i = a.j();
                    j = a.j();
                    ErrorCode errorcode1 = ErrorCode.c(j);
                    if (errorcode1 == null)
                    {
                        throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                            Integer.valueOf(j)
                        });
                    } else
                    {
                        handler.goAway(i & 0x7fffffff, errorcode1, ByteString.a);
                        return true;
                    }

                case 8: // '\b'
                    handler.headers(false, false, a.j() & 0x7fffffff, -1, c.a(l - 4), HeadersMode.c);
                    return true;

                case 9: // '\t'
                    break;
                }
                if (l != 8)
                {
                    throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                        Integer.valueOf(l)
                    });
                }
                i = a.j();
                long l1 = a.j() & 0x7fffffff;
                if (l1 == 0L)
                {
                    throw a("windowSizeIncrement was 0", new Object[] {
                        Long.valueOf(l1)
                    });
                } else
                {
                    handler.windowUpdate(i & 0x7fffffff, l1);
                    return true;
                }
            }
            if ((j & 1) != 0)
            {
                flag = true;
            }
            handler.data(flag, k & 0x7fffffff, a, l);
            return true;
        }

        public final void readConnectionPreface()
        {
        }

        Reader(BufferedSource bufferedsource, boolean flag)
        {
            a = bufferedsource;
            c = new NameValueBlockReader(a);
            b = flag;
        }
    }


    private class Writer
        implements FrameWriter
    {

        private final BufferedSink a;
        private final Buffer b = new Buffer();
        private final BufferedSink c;
        private final boolean d;
        private boolean e;

        private void a(List list)
        {
            if (b.c() != 0L)
            {
                throw new IllegalStateException();
            }
            c.d(list.size());
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ByteString bytestring = ((Header)list.get(i)).h;
                c.d(bytestring.e());
                c.b(bytestring);
                bytestring = ((Header)list.get(i)).i;
                c.d(bytestring.e());
                c.b(bytestring);
            }

            c.b();
        }

        public final void ackSettings()
        {
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            e = true;
            Util.a(a, c);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void connectionPreface()
        {
            this;
            JVM INSTR monitorenter ;
        }

        public final void data(boolean flag, int i, Buffer buffer)
        {
            this;
            JVM INSTR monitorenter ;
            data(flag, i, buffer, (int)buffer.c());
            this;
            JVM INSTR monitorexit ;
            return;
            buffer;
            throw buffer;
        }

        public final void data(boolean flag, int i, Buffer buffer, int j)
        {
            this;
            JVM INSTR monitorenter ;
            int k;
            if (flag)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_37;
            buffer;
            this;
            JVM INSTR monitorexit ;
            throw buffer;
            if ((long)j <= 0xffffffL)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            throw new IllegalArgumentException((new StringBuilder("FRAME_TOO_LARGE max size is 16Mib: ")).append(j).toString());
            a.d(0x7fffffff & i);
            a.d((k & 0xff) << 24 | 0xffffff & j);
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            a.a(buffer, j);
            this;
            JVM INSTR monitorexit ;
        }

        public final void flush()
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void goAway(int i, ErrorCode errorcode, byte abyte0[])
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.t == -1)
            {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            a.d(0x80030007);
            a.d(8);
            a.d(i);
            a.d(errorcode.t);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void headers(int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            a(list);
            int j = (int)(b.c() + 4L);
            a.d(0x80030008);
            a.d(j & 0xffffff | 0);
            a.d(0x7fffffff & i);
            a.a(b);
            this;
            JVM INSTR monitorexit ;
        }

        public final void ping(boolean flag, int i, int j)
        {
            boolean flag2 = true;
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_29;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            boolean flag3 = d;
            boolean flag1;
            if ((i & 1) == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag3 != flag1)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
              goto _L1
_L3:
            if (flag == flag1)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            throw new IllegalArgumentException("payload != reply");
            a.d(0x80030006);
            a.d(4);
            a.d(i);
            a.b();
            this;
            JVM INSTR monitorexit ;
            return;
_L1:
            if (true) goto _L3; else goto _L2
_L2:
        }

        public final void pushPromise(int i, int j, List list)
        {
        }

        public final void rstStream(int i, ErrorCode errorcode)
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.s == -1)
            {
                throw new IllegalArgumentException();
            }
            a.d(0x80030003);
            a.d(8);
            a.d(0x7fffffff & i);
            a.d(errorcode.s);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void settings(Settings settings1)
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            settings1;
            this;
            JVM INSTR monitorexit ;
            throw settings1;
            int i = settings1.b();
            a.d(0x80030004);
            a.d(i * 8 + 4 & 0xffffff | 0);
            a.d(i);
            int j = 0;
_L2:
            if (j > 10)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            if (settings1.a(j))
            {
                int k = settings1.c(j);
                a.d((k & 0xff) << 24 | j & 0xffffff);
                a.d(settings1.b(j));
            }
            break MISSING_BLOCK_LABEL_148;
            a.b();
            this;
            JVM INSTR monitorexit ;
            return;
            j++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void synReply(boolean flag, int i, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            a(list);
            int j;
            int k;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            k = (int)(b.c() + 4L);
            a.d(0x80030002);
            a.d((j & 0xff) << 24 | k & 0xffffff);
            a.d(0x7fffffff & i);
            a.a(b);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void synStream(boolean flag, boolean flag1, int i, int j, List list)
        {
            byte byte0 = 0;
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_29;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            int k;
            a(list);
            k = (int)(10L + b.c());
            break MISSING_BLOCK_LABEL_49;
_L2:
            a.d(0x80030001);
            a.d(((byte0 | flag2) & 0xff) << 24 | k & 0xffffff);
            a.d(i & 0x7fffffff);
            a.d(j & 0x7fffffff);
            a.s();
            a.a(b);
            a.b();
            this;
            JVM INSTR monitorexit ;
            return;
            boolean flag2;
            if (flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1)
            {
                byte0 = 2;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void windowUpdate(int i, long l)
        {
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            if (l != 0L && l <= 0x7fffffffL)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            throw new IllegalArgumentException((new StringBuilder("windowSizeIncrement must be between 1 and 0x7fffffff: ")).append(l).toString());
            a.d(0x80030009);
            a.d(8);
            a.d(i);
            a.d((int)l);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        Writer(BufferedSink bufferedsink, boolean flag)
        {
            a = bufferedsink;
            d = flag;
            bufferedsink = new Deflater();
            bufferedsink.setDictionary(Spdy3.a);
            c = Okio.a(new DeflaterSink(b, bufferedsink));
        }
    }

}
