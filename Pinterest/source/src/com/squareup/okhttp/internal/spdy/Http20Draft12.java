// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.util.logging.Logger;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter

public final class Http20Draft12
    implements Variant
{

    private static final Logger a = Logger.getLogger(com/squareup/okhttp/internal/spdy/Http20Draft12.getName());
    private static final ByteString b = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public Http20Draft12()
    {
    }

    static IOException a(String s, Object aobj[])
    {
        return c(s, aobj);
    }

    static ByteString a()
    {
        return b;
    }

    static short a(BufferedSource bufferedsource, byte byte0)
    {
        if ((byte0 & 0x10) != 0 && (byte0 & 8) == 0)
        {
            throw c("PROTOCOL_ERROR FLAG_PAD_HIGH set without FLAG_PAD_LOW", new Object[0]);
        }
        if ((byte0 & 0x10) != 0)
        {
            byte0 = bufferedsource.i() & 0xffff;
        } else
        if ((byte0 & 8) != 0)
        {
            byte0 = bufferedsource.h() & 0xff;
        } else
        {
            byte0 = 0;
        }
        if (byte0 > 16383)
        {
            throw c("PROTOCOL_ERROR padding > %d: %d", new Object[] {
                Integer.valueOf(16383), Integer.valueOf(byte0)
            });
        } else
        {
            return (short)byte0;
        }
    }

    static short a(short word0, byte byte0, short word1)
    {
        short word2;
        if ((byte0 & 0x10) != 0)
        {
            word2 = (short)(word0 - 2);
        } else
        {
            word2 = word0;
            if ((byte0 & 8) != 0)
            {
                word2 = (short)(word0 - 1);
            }
        }
        if (word1 > word2)
        {
            throw c("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] {
                Short.valueOf(word1), Short.valueOf(word2)
            });
        } else
        {
            return (short)(word2 - word1);
        }
    }

    static IllegalArgumentException b(String s, Object aobj[])
    {
        throw new IllegalArgumentException(String.format(s, aobj));
    }

    static Logger b()
    {
        return a;
    }

    private static transient IOException c(String s, Object aobj[])
    {
        throw new IOException(String.format(s, aobj));
    }

    public final Protocol getProtocol()
    {
        return Protocol.d;
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


    private class Reader
        implements FrameReader
    {
        private class ContinuationSource
            implements Source
        {

            short a;
            byte b;
            int c;
            short d;
            short e;
            private final BufferedSource f;

            public final Timeout a()
            {
                return f.a();
            }

            public final long b(Buffer buffer, long l)
            {
_L7:
                if (d != 0) goto _L2; else goto _L1
_L1:
                f.g(e);
                e = 0;
                if ((b & 4) == 0) goto _L4; else goto _L3
_L3:
                return -1L;
_L4:
                int i = c;
                int j = f.j();
                int k = f.j();
                a = (short)((0x3fff0000 & j) >> 16);
                byte byte0 = (byte)((0xff00 & j) >> 8);
                b = (byte)(j & 0xff);
                if (Http20Draft12.b().isLoggable(Level.FINE))
                {
                    Http20Draft12.b().fine(FrameLogger.a(true, c, a, byte0, b));
                }
                e = Http20Draft12.a(f, b);
                short word0 = Http20Draft12.a(a, b, e);
                d = word0;
                a = word0;
                c = 0x7fffffff & k;
                if (byte0 != 9)
                {
                    throw Http20Draft12.a("%s != TYPE_CONTINUATION", new Object[] {
                        Byte.valueOf(byte0)
                    });
                }
                if (c != i)
                {
                    throw Http20Draft12.a("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                l = f.b(buffer, Math.min(l, d));
                if (l == -1L) goto _L3; else goto _L5
_L5:
                d = (short)(int)((long)d - l);
                return l;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public final void close()
            {
            }

            public ContinuationSource(BufferedSource bufferedsource)
            {
                f = bufferedsource;
            }

            private class FrameLogger
            {

                private static final String a[] = {
                    "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION", 
                    "ALTSVC", "BLOCKED"
                };
                private static final String b[];
                private static final String c[];

                static String a(boolean flag, int i, int j, byte byte0, byte byte1)
                {
                    String s;
                    String s2;
                    if (byte0 < a.length)
                    {
                        s2 = a[byte0];
                    } else
                    {
                        s2 = String.format("0x%02x", new Object[] {
                            Byte.valueOf(byte0)
                        });
                    }
                    if (byte1 != 0) goto _L2; else goto _L1
_L1:
                    s = "";
_L4:
                    String s1;
                    if (flag)
                    {
                        s1 = "<<";
                    } else
                    {
                        s1 = ">>";
                    }
                    return String.format("%s 0x%08x %5d %-13s %s", new Object[] {
                        s1, Integer.valueOf(i), Integer.valueOf(j), s2, s
                    });
_L2:
                    switch (byte0)
                    {
                    case 5: // '\005'
                    case 9: // '\t'
                    default:
                        if (byte1 < b.length)
                        {
                            s1 = b[byte1];
                        } else
                        {
                            s1 = c[byte1];
                        }
                        if (byte0 == 5 && (byte1 & 4) != 0)
                        {
                            s = s1.replace("HEADERS", "PUSH_PROMISE");
                        } else
                        {
                            s = s1;
                            if (byte0 == 0)
                            {
                                s = s1;
                                if ((byte1 & 0x20) != 0)
                                {
                                    s = s1.replace("PRIORITY", "COMPRESSED");
                                }
                            }
                        }
                        break;

                    case 4: // '\004'
                    case 6: // '\006'
                        if (byte1 == 1)
                        {
                            s = "ACK";
                        } else
                        {
                            s = c[byte1];
                        }
                        break;

                    case 2: // '\002'
                    case 3: // '\003'
                    case 7: // '\007'
                    case 8: // '\b'
                    case 10: // '\n'
                    case 11: // '\013'
                        s = c[byte1];
                        break;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                static 
                {
                    b = new String[64];
                    c = new String[256];
                    for (int i = 0; i < c.length; i++)
                    {
                        c[i] = String.format("%8s", new Object[] {
                            Integer.toBinaryString(i)
                        }).replace(' ', '0');
                    }

                    b[0] = "";
                    b[1] = "END_STREAM";
                    b[2] = "END_SEGMENT";
                    b[3] = "END_STREAM|END_SEGMENT";
                    int ai[] = new int[3];
                    int[] _tmp = ai;
                    ai[0] = 1;
                    ai[1] = 2;
                    ai[2] = 3;
                    b[8] = "PAD_LOW";
                    b[24] = "PAD_LOW|PAD_HIGH";
                    int ai1[] = new int[2];
                    int[] _tmp1 = ai1;
                    ai1[0] = 8;
                    ai1[1] = 24;
                    for (int j = 0; j < 3; j++)
                    {
                        int k1 = ai[j];
                        for (int i1 = 0; i1 < 2; i1++)
                        {
                            int i2 = ai1[i1];
                            b[k1 | i2] = (new StringBuilder()).append(b[k1]).append('|').append(b[i2]).toString();
                        }

                    }

                    b[4] = "END_HEADERS";
                    b[32] = "PRIORITY";
                    b[36] = "END_HEADERS|PRIORITY";
                    for (int k = 0; k < 3; k++)
                    {
                        int j2 = (new int[] {
                            4, 32, 36
                        })[k];
                        for (int j1 = 0; j1 < 3; j1++)
                        {
                            int k2 = ai[j1];
                            b[k2 | j2] = (new StringBuilder()).append(b[k2]).append('|').append(b[j2]).toString();
                            for (int l1 = 0; l1 < 2; l1++)
                            {
                                int l2 = ai1[l1];
                                b[k2 | j2 | l2] = (new StringBuilder()).append(b[k2]).append('|').append(b[j2]).append('|').append(b[l2]).toString();
                            }

                        }

                    }

                    for (int l = 0; l < b.length; l++)
                    {
                        if (b[l] == null)
                        {
                            b[l] = c[l];
                        }
                    }

                }
            }

        }


        final HpackDraft07.Reader a;
        private final BufferedSource b;
        private final ContinuationSource c;
        private final boolean d;

        private List a(short word0, short word1, byte byte0, int i)
        {
            ContinuationSource continuationsource = c;
            c.d = word0;
            continuationsource.a = word0;
            c.e = word1;
            c.b = byte0;
            c.c = i;
            a.a();
            a.b();
            return a.c();
        }

        private void a(FrameReader.Handler handler, int i)
        {
            int j = b.j();
            boolean flag;
            if ((0x80000000 & j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.priority(i, j & 0x7fffffff, (b.h() & 0xff) + 1, flag);
        }

        public final void close()
        {
            b.close();
        }

        public final boolean nextFrame(FrameReader.Handler handler)
        {
            boolean flag1;
            boolean flag5;
            flag1 = true;
            flag5 = false;
            int j;
            int i1;
            j = b.j();
            i1 = b.j();
            byte byte0;
            byte byte1;
            short word2;
            word2 = (short)((0x3fff0000 & j) >> 16);
            byte0 = (byte)((0xff00 & j) >> 8);
            byte1 = (byte)(j & 0xff);
            i1 &= 0x7fffffff;
            if (Http20Draft12.b().isLoggable(Level.FINE))
            {
                Http20Draft12.b().fine(FrameLogger.a(true, i1, word2, byte0, byte1));
            }
            byte0;
            JVM INSTR tableswitch 0 11: default 156
        //                       0 180
        //                       1 276
        //                       2 375
        //                       3 423
        //                       4 515
        //                       5 784
        //                       6 845
        //                       7 934
        //                       8 1071
        //                       9 156
        //                       10 1148
        //                       11 1286;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11 _L12
_L1:
            throw Http20Draft12.a("PROTOCOL_ERROR: unknown frame type %s", new Object[] {
                Byte.valueOf(byte0)
            });
            handler;
            flag1 = false;
_L24:
            return flag1;
_L2:
            boolean flag;
            boolean flag2;
            if ((byte1 & 1) != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if ((byte1 & 0x20) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                throw Http20Draft12.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            } else
            {
                int i = Http20Draft12.a(b, byte1);
                flag = Http20Draft12.a(word2, byte1, i);
                handler.data(flag2, i1, b, flag);
                b.g(i);
                return true;
            }
_L3:
            if (i1 == 0)
            {
                throw Http20Draft12.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            short word0;
            short word3;
            boolean flag3;
            if ((byte1 & 1) != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            word3 = Http20Draft12.a(b, byte1);
            word0 = word2;
            if ((byte1 & 0x20) != 0)
            {
                a(handler, i1);
                word0 = (short)(word2 - 5);
            }
            handler.headers(false, flag3, i1, -1, a(Http20Draft12.a(word0, byte1, word3), word3, byte1, i1), HeadersMode.d);
            return true;
_L4:
            if (word2 != 5)
            {
                throw Http20Draft12.a("TYPE_PRIORITY length: %d != 5", new Object[] {
                    Short.valueOf(word2)
                });
            }
            if (i1 == 0)
            {
                throw Http20Draft12.a("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else
            {
                a(handler, i1);
                return true;
            }
_L5:
            if (word2 != 4)
            {
                throw Http20Draft12.a("TYPE_RST_STREAM length: %d != 4", new Object[] {
                    Short.valueOf(word2)
                });
            }
            if (i1 == 0)
            {
                throw Http20Draft12.a("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            flag = b.j();
            ErrorCode errorcode = ErrorCode.b(flag);
            if (errorcode == null)
            {
                throw Http20Draft12.a("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(flag)
                });
            } else
            {
                handler.rstStream(i1, errorcode);
                return true;
            }
_L6:
            Settings settings;
            if (i1 != 0)
            {
                throw Http20Draft12.a("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((byte1 & 1) != 0)
            {
                if (word2 != 0)
                {
                    throw Http20Draft12.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                } else
                {
                    handler.ackSettings();
                    return true;
                }
            }
            if (word2 % 5 != 0)
            {
                throw Http20Draft12.a("TYPE_SETTINGS length %% 5 != 0: %s", new Object[] {
                    Short.valueOf(word2)
                });
            }
            settings = new Settings();
            i1 = 0;
_L20:
            if (i1 >= word2) goto _L14; else goto _L13
_L13:
            byte byte2;
            int l1;
            byte2 = b.h();
            l1 = b.j();
            flag = byte2;
            byte2;
            JVM INSTR tableswitch 1 5: default 664
        //                       1 714
        //                       2 682
        //                       3 711
        //                       4 734
        //                       5 714;
               goto _L15 _L16 _L17 _L18 _L19 _L16
_L16:
            break; /* Loop/switch isn't completed */
_L15:
            throw Http20Draft12.a("PROTOCOL_ERROR invalid settings id: %s", new Object[] {
                Integer.valueOf(byte2)
            });
_L17:
            flag = byte2;
            if (l1 != 0)
            {
                flag = byte2;
                if (l1 != 1)
                {
                    throw Http20Draft12.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            }
            break; /* Loop/switch isn't completed */
_L18:
            flag = 4;
_L22:
            settings.a(flag, 0, l1);
            i1 += 5;
              goto _L20
_L19:
            flag = 7;
            if (l1 >= 0) goto _L22; else goto _L21
_L21:
            throw Http20Draft12.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
_L14:
            handler.settings(false, settings);
            if (settings.c() >= 0)
            {
                a.a(settings.c());
                return true;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (i1 == 0)
            {
                throw Http20Draft12.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            } else
            {
                short word1 = Http20Draft12.a(b, byte1);
                handler.pushPromise(i1, b.j() & 0x7fffffff, a((short)(word2 - 4), word1, byte1, i1));
                return true;
            }
_L8:
            if (word2 != 8)
            {
                throw Http20Draft12.a("TYPE_PING length != 8: %s", new Object[] {
                    Short.valueOf(word2)
                });
            }
            if (i1 != 0)
            {
                throw Http20Draft12.a("TYPE_PING streamId != 0", new Object[0]);
            }
            int k = b.j();
            i1 = b.j();
            boolean flag4 = flag5;
            if ((byte1 & 1) != 0)
            {
                flag4 = true;
            }
            handler.ping(flag4, k, i1);
            return true;
_L9:
            if (word2 < 8)
            {
                throw Http20Draft12.a("TYPE_GOAWAY length < 8: %s", new Object[] {
                    Short.valueOf(word2)
                });
            }
            if (i1 != 0)
            {
                throw Http20Draft12.a("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int l = b.j();
            i1 = b.j();
            int j1 = word2 - 8;
            ErrorCode errorcode1 = ErrorCode.b(i1);
            if (errorcode1 == null)
            {
                throw Http20Draft12.a("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(i1)
                });
            }
            ByteString bytestring = ByteString.a;
            if (j1 > 0)
            {
                bytestring = b.c(j1);
            }
            handler.goAway(l, errorcode1, bytestring);
            return true;
_L10:
            if (word2 != 4)
            {
                throw Http20Draft12.a("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] {
                    Short.valueOf(word2)
                });
            }
            long l2 = (long)b.j() & 0x7fffffffL;
            if (l2 == 0L)
            {
                throw Http20Draft12.a("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l2)
                });
            } else
            {
                handler.windowUpdate(i1, l2);
                return true;
            }
_L11:
            long l3 = b.j();
            short word4 = b.i();
            b.h();
            int k1 = b.h() & 0xff;
            ByteString bytestring1 = b.c(k1);
            int i2 = b.h() & 0xff;
            String s = b.d(i2);
            handler.alternateService(i1, b.d(word2 - 9 - k1 - i2), bytestring1, s, word4 & 0xffff, l3 & 0xffffffffL);
            return true;
_L12:
            if (word2 != 0)
            {
                throw Http20Draft12.a("TYPE_BLOCKED length != 0: %s", new Object[] {
                    Short.valueOf(word2)
                });
            }
            if (true) goto _L24; else goto _L23
_L23:
        }

        public final void readConnectionPreface()
        {
            if (!d)
            {
                ByteString bytestring = b.c(Http20Draft12.a().e());
                if (Http20Draft12.b().isLoggable(Level.FINE))
                {
                    Http20Draft12.b().fine(String.format("<< CONNECTION %s", new Object[] {
                        bytestring.c()
                    }));
                }
                if (!Http20Draft12.a().equals(bytestring))
                {
                    throw Http20Draft12.a("Expected a connection header but was %s", new Object[] {
                        bytestring.a()
                    });
                }
            }
        }

        Reader(BufferedSource bufferedsource, boolean flag)
        {
            b = bufferedsource;
            d = flag;
            c = new ContinuationSource(b);
            a = new HpackDraft07.Reader(c);
        }
    }


    private class Writer
        implements FrameWriter
    {

        private final BufferedSink a;
        private final boolean b;
        private final Buffer c = new Buffer();
        private final HpackDraft07.Writer d;
        private boolean e;

        private void a(int i, int j, byte byte0, byte byte1)
        {
            if (Http20Draft12.b().isLoggable(Level.FINE))
            {
                Http20Draft12.b().fine(FrameLogger.a(false, i, j, byte0, byte1));
            }
            if (j > 16383)
            {
                throw Http20Draft12.b("FRAME_SIZE_ERROR length > %d: %d", new Object[] {
                    Integer.valueOf(16383), Integer.valueOf(j)
                });
            }
            if ((0x80000000 & i) != 0)
            {
                throw Http20Draft12.b("reserved bit set: %s", new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                a.d((j & 0x3fff) << 16 | (byte0 & 0xff) << 8 | byte1 & 0xff);
                a.d(0x7fffffff & i);
                return;
            }
        }

        private void a(int i, long l)
        {
            while (l > 0L) 
            {
                int j = (int)Math.min(16383L, l);
                l -= j;
                byte byte0;
                if (l == 0L)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                a(i, j, (byte)9, byte0);
                a.a(c, j);
            }
        }

        private void a(boolean flag, int i, List list)
        {
            if (e)
            {
                throw new IOException("closed");
            }
            if (c.c() != 0L)
            {
                throw new IllegalStateException();
            }
            d.a(list);
            long l = c.c();
            int j = (int)Math.min(16383L, l);
            byte byte0;
            byte byte1;
            if (l == (long)j)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            byte1 = byte0;
            if (flag)
            {
                byte1 = (byte)(byte0 | 1);
            }
            a(i, j, (byte)1, byte1);
            a.a(c, j);
            if (l > (long)j)
            {
                a(i, l - (long)j);
            }
        }

        public final void ackSettings()
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
            a(0, 0, (byte)4, (byte)1);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void close()
        {
            this;
            JVM INSTR monitorenter ;
            e = true;
            a.close();
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
            boolean flag = b;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_36;
            }
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
            if (Http20Draft12.b().isLoggable(Level.FINE))
            {
                Http20Draft12.b().fine(String.format(">> CONNECTION %s", new Object[] {
                    Http20Draft12.a().c()
                }));
            }
            a.b(Http20Draft12.a().f());
            a.b();
              goto _L1
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
            byte byte0 = 0;
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_27;
            buffer;
            this;
            JVM INSTR monitorexit ;
            throw buffer;
            if (flag)
            {
                byte0 = 1;
            }
            a(i, j, (byte)0, byte0);
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_62;
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
            if (errorcode.r == -1)
            {
                throw Http20Draft12.b("errorCode.httpCode == -1", new Object[0]);
            }
            a(0, abyte0.length + 8, (byte)7, (byte)0);
            a.d(i);
            a.d(errorcode.r);
            if (abyte0.length > 0)
            {
                a.b(abyte0);
            }
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
            a(false, i, list);
            this;
            JVM INSTR monitorexit ;
        }

        public final void ping(boolean flag, int i, int j)
        {
            byte byte0 = 0;
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
            if (flag)
            {
                byte0 = 1;
            }
            a(0, 8, (byte)6, byte0);
            a.d(i);
            a.d(j);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void pushPromise(int i, int j, List list)
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
            int k;
            long l;
            if (c.c() != 0L)
            {
                throw new IllegalStateException();
            }
            d.a(list);
            l = c.c();
            k = (int)Math.min(16379L, l);
            byte byte0;
            if (l == (long)k)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            a(i, k + 4, (byte)5, byte0);
            a.d(0x7fffffff & j);
            a.a(c, k);
            if (l <= (long)k)
            {
                break MISSING_BLOCK_LABEL_146;
            }
            a(i, l - (long)k);
            this;
            JVM INSTR monitorexit ;
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
            a(i, 4, (byte)3, (byte)0);
            a.d(errorcode.r);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        public final void settings(Settings settings1)
        {
            int i = 0;
            this;
            JVM INSTR monitorenter ;
            if (e)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            settings1;
            this;
            JVM INSTR monitorexit ;
            throw settings1;
            a(0, settings1.b() * 5, (byte)4, (byte)0);
_L8:
            if (i >= 10) goto _L2; else goto _L1
_L1:
            if (!settings1.a(i)) goto _L4; else goto _L3
_L3:
            if (i != 4) goto _L6; else goto _L5
_L5:
            int j = 3;
_L7:
            a.e(j);
            a.d(settings1.b(i));
              goto _L4
_L2:
            a.b();
            this;
            JVM INSTR monitorexit ;
            return;
_L10:
            j = i;
              goto _L7
_L4:
            i++;
              goto _L8
_L6:
            if (i != 7) goto _L10; else goto _L9
_L9:
            j = 4;
              goto _L7
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
            a(flag, i, list);
            this;
            JVM INSTR monitorexit ;
        }

        public final void synStream(boolean flag, boolean flag1, int i, int j, List list)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            throw new UnsupportedOperationException();
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            if (e)
            {
                throw new IOException("closed");
            }
            a(flag, i, list);
            this;
            JVM INSTR monitorexit ;
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
                break MISSING_BLOCK_LABEL_57;
            }
            throw Http20Draft12.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
                Long.valueOf(l)
            });
            a(i, 4, (byte)8, (byte)0);
            a.d((int)l);
            a.b();
            this;
            JVM INSTR monitorexit ;
        }

        Writer(BufferedSink bufferedsink, boolean flag)
        {
            a = bufferedsink;
            b = flag;
            d = new HpackDraft07.Writer(c);
        }
    }

}
