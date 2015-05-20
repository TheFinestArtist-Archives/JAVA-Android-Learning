// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransport

public final class TMemoryInputTransport extends TTransport
{

    private byte buf_[];
    private int endPos_;
    private int pos_;

    public TMemoryInputTransport()
    {
    }

    public TMemoryInputTransport(byte abyte0[])
    {
        reset(abyte0);
    }

    public TMemoryInputTransport(byte abyte0[], int i, int j)
    {
        reset(abyte0, i, j);
    }

    public final void clear()
    {
        buf_ = null;
    }

    public final void close()
    {
    }

    public final void consumeBuffer(int i)
    {
        pos_ = pos_ + i;
    }

    public final byte[] getBuffer()
    {
        return buf_;
    }

    public final int getBufferPosition()
    {
        return pos_;
    }

    public final int getBytesRemainingInBuffer()
    {
        return endPos_ - pos_;
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
        int l = getBytesRemainingInBuffer();
        int k = j;
        if (j > l)
        {
            k = l;
        }
        if (k > 0)
        {
            System.arraycopy(buf_, pos_, abyte0, i, k);
            consumeBuffer(k);
        }
        return k;
    }

    public final void reset(byte abyte0[])
    {
        reset(abyte0, 0, abyte0.length);
    }

    public final void reset(byte abyte0[], int i, int j)
    {
        buf_ = abyte0;
        pos_ = i;
        endPos_ = i + j;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        throw new UnsupportedOperationException("No writing allowed!");
    }
}
