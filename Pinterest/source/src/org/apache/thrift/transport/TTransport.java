// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransportException

public abstract class TTransport
{

    public TTransport()
    {
    }

    public abstract void close();

    public void consumeBuffer(int i)
    {
    }

    public void flush()
    {
    }

    public byte[] getBuffer()
    {
        return null;
    }

    public int getBufferPosition()
    {
        return 0;
    }

    public int getBytesRemainingInBuffer()
    {
        return -1;
    }

    public abstract boolean isOpen();

    public abstract void open();

    public boolean peek()
    {
        return isOpen();
    }

    public abstract int read(byte abyte0[], int i, int j);

    public int readAll(byte abyte0[], int i, int j)
    {
        int k;
        int l;
        for (k = 0; k < j; k += l)
        {
            l = read(abyte0, i + k, j - k);
            if (l <= 0)
            {
                throw new TTransportException((new StringBuilder("Cannot read. Remote side has closed. Tried to read ")).append(j).append(" bytes, but only got ").append(k).append(" bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)").toString());
            }
        }

        return k;
    }

    public void write(byte abyte0[])
    {
        write(abyte0, 0, abyte0.length);
    }

    public abstract void write(byte abyte0[], int i, int j);
}
