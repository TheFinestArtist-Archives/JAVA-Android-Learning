// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Spdy3, Header, ErrorCode, 
//            Settings

final class b
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

    (BufferedSink bufferedsink, boolean flag)
    {
        a = bufferedsink;
        d = flag;
        bufferedsink = new Deflater();
        bufferedsink.setDictionary(Spdy3.a);
        c = Okio.a(new DeflaterSink(b, bufferedsink));
    }
}
