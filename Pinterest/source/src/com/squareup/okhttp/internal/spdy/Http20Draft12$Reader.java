// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSource;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, Http20Draft12, HeadersMode, ErrorCode, 
//            Settings

final class c
    implements FrameReader
{

    final b a;
    private final BufferedSource b;
    private final ationSource c;
    private final boolean d;

    private List a(short word0, short word1, byte byte0, int i)
    {
        ationSource ationsource = c;
        c.d = word0;
        ationsource.a = word0;
        c.e = word1;
        c.b = byte0;
        c.c = i;
        a.();
        a.();
        return a.();
    }

    private void a( , int i)
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
        .riority(i, j & 0x7fffffff, (b.h() & 0xff) + 1, flag);
    }

    public final void close()
    {
        b.close();
    }

    public final boolean nextFrame(b b1)
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
            Http20Draft12.b().fine(gger.a(true, i1, word2, byte0, byte1));
        }
        byte0;
        JVM INSTR tableswitch 0 11: default 156
    //                   0 180
    //                   1 276
    //                   2 375
    //                   3 423
    //                   4 515
    //                   5 784
    //                   6 845
    //                   7 934
    //                   8 1071
    //                   9 156
    //                   10 1148
    //                   11 1286;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L1 _L11 _L12
_L1:
        throw Http20Draft12.a("PROTOCOL_ERROR: unknown frame type %s", new Object[] {
            Byte.valueOf(byte0)
        });
        b1;
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
            b1.ata(flag2, i1, b, flag);
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
            a(b1, i1);
            word0 = (short)(word2 - 5);
        }
        b1.eaders(false, flag3, i1, -1, a(Http20Draft12.a(word0, byte1, word3), word3, byte1, i1), HeadersMode.d);
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
            a(b1, i1);
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
            b1.stStream(i1, errorcode);
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
                b1.ckSettings();
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
    //                   1 714
    //                   2 682
    //                   3 711
    //                   4 734
    //                   5 714;
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
        b1.ettings(false, settings);
        if (settings.c() >= 0)
        {
            a.(settings.c());
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
            b1.ushPromise(i1, b.j() & 0x7fffffff, a((short)(word2 - 4), word1, byte1, i1));
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
        b1.ing(flag4, k, i1);
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
        b1.oAway(l, errorcode1, bytestring);
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
            b1.indowUpdate(i1, l2);
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
        b1.lternateService(i1, b.d(word2 - 9 - k1 - i2), bytestring1, s, word4 & 0xffff, l3 & 0xffffffffL);
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

    ationSource(BufferedSource bufferedsource, boolean flag)
    {
        b = bufferedsource;
        d = flag;
        c = new ationSource(b);
        a = new init>(c);
    }
}
