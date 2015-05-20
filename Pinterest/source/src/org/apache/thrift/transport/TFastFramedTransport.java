// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


// Referenced classes of package org.apache.thrift.transport:
//            TTransport, AutoExpandingBufferWriteTransport, AutoExpandingBufferReadTransport, TFramedTransport, 
//            TTransportException, AutoExpandingBuffer

public class TFastFramedTransport extends TTransport
{

    public static final int DEFAULT_BUF_CAPACITY = 1024;
    public static final int DEFAULT_MAX_LENGTH = 0xfa0000;
    private final byte i32buf[];
    private final int maxLength;
    private final AutoExpandingBufferReadTransport readBuffer;
    private final TTransport underlying;
    private final AutoExpandingBufferWriteTransport writeBuffer;

    public TFastFramedTransport(TTransport ttransport)
    {
        this(ttransport, 1024, 0xfa0000);
    }

    public TFastFramedTransport(TTransport ttransport, int i)
    {
        this(ttransport, i, 0xfa0000);
    }

    public TFastFramedTransport(TTransport ttransport, int i, int j)
    {
        i32buf = new byte[4];
        underlying = ttransport;
        maxLength = j;
        writeBuffer = new AutoExpandingBufferWriteTransport(i, 1.5D);
        readBuffer = new AutoExpandingBufferReadTransport(i, 1.5D);
    }

    private void readFrame()
    {
        underlying.readAll(i32buf, 0, 4);
        int i = TFramedTransport.decodeFrameSize(i32buf);
        if (i < 0)
        {
            throw new TTransportException((new StringBuilder("Read a negative frame size (")).append(i).append(")!").toString());
        }
        if (i > maxLength)
        {
            throw new TTransportException((new StringBuilder("Frame size (")).append(i).append(") larger than max length (").append(maxLength).append(")!").toString());
        } else
        {
            readBuffer.fill(underlying, i);
            return;
        }
    }

    public void close()
    {
        underlying.close();
    }

    public void consumeBuffer(int i)
    {
        readBuffer.consumeBuffer(i);
    }

    public void flush()
    {
        int i = writeBuffer.getPos();
        TFramedTransport.encodeFrameSize(i, i32buf);
        underlying.write(i32buf, 0, 4);
        underlying.write(writeBuffer.getBuf().array(), 0, i);
        writeBuffer.reset();
        underlying.flush();
    }

    public byte[] getBuffer()
    {
        return readBuffer.getBuffer();
    }

    public int getBufferPosition()
    {
        return readBuffer.getBufferPosition();
    }

    public int getBytesRemainingInBuffer()
    {
        return readBuffer.getBytesRemainingInBuffer();
    }

    public boolean isOpen()
    {
        return underlying.isOpen();
    }

    public void open()
    {
        underlying.open();
    }

    public int read(byte abyte0[], int i, int j)
    {
        int k = readBuffer.read(abyte0, i, j);
        if (k > 0)
        {
            return k;
        } else
        {
            readFrame();
            return readBuffer.read(abyte0, i, j);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        writeBuffer.write(abyte0, i, j);
    }
}
