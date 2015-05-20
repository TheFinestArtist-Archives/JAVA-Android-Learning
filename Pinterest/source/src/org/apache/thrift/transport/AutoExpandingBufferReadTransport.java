// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransport, AutoExpandingBuffer

public class AutoExpandingBufferReadTransport extends TTransport
{

    private final AutoExpandingBuffer buf;
    private int limit;
    private int pos;

    public AutoExpandingBufferReadTransport(int i, double d)
    {
        pos = 0;
        limit = 0;
        buf = new AutoExpandingBuffer(i, d);
    }

    public void close()
    {
    }

    public final void consumeBuffer(int i)
    {
        pos = pos + i;
    }

    public void fill(TTransport ttransport, int i)
    {
        buf.resizeIfNecessary(i);
        ttransport.readAll(buf.array(), 0, i);
        pos = 0;
        limit = i;
    }

    public final byte[] getBuffer()
    {
        return buf.array();
    }

    public final int getBufferPosition()
    {
        return pos;
    }

    public final int getBytesRemainingInBuffer()
    {
        return limit - pos;
    }

    public boolean isOpen()
    {
        return true;
    }

    public void open()
    {
    }

    public final int read(byte abyte0[], int i, int j)
    {
        j = Math.min(j, getBytesRemainingInBuffer());
        System.arraycopy(buf.array(), pos, abyte0, i, j);
        consumeBuffer(j);
        return j;
    }

    public void write(byte abyte0[], int i, int j)
    {
        throw new UnsupportedOperationException();
    }
}
