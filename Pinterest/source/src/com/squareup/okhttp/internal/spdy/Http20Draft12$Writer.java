// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Http20Draft12, ErrorCode, Settings

final class c
    implements FrameWriter
{

    private final BufferedSink a;
    private final boolean b;
    private final Buffer c = new Buffer();
    private final a d;
    private boolean e;

    private void a(int i, int j, byte byte0, byte byte1)
    {
        if (Http20Draft12.b().isLoggable(Level.FINE))
        {
            Http20Draft12.b().fine(gger.a(false, i, j, byte0, byte1));
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
        d.(list);
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
        d.(list);
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

    gger(BufferedSink bufferedsink, boolean flag)
    {
        a = bufferedsink;
        b = flag;
        d = new init>(c);
    }
}
