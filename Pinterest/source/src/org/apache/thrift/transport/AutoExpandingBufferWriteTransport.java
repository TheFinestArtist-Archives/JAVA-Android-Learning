// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransport, AutoExpandingBuffer

public final class AutoExpandingBufferWriteTransport extends TTransport
{

    private final AutoExpandingBuffer buf;
    private int pos;

    public AutoExpandingBufferWriteTransport(int i, double d)
    {
        buf = new AutoExpandingBuffer(i, d);
        pos = 0;
    }

    public final void close()
    {
    }

    public final AutoExpandingBuffer getBuf()
    {
        return buf;
    }

    public final int getPos()
    {
        return pos;
    }

    public final boolean isOpen()
    {
        return true;
    }

    public final void open()
    {
    }

    public final int read(byte abyte0[], int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    public final void reset()
    {
        pos = 0;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        buf.resizeIfNecessary(pos + j);
        System.arraycopy(abyte0, i, buf.array(), pos, j);
        pos = pos + j;
    }
}
