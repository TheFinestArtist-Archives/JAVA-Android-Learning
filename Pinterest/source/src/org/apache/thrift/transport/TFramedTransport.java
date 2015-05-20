// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import org.apache.thrift.TByteArrayOutputStream;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport, TMemoryInputTransport, TTransportException

public class TFramedTransport extends TTransport
{

    protected static final int DEFAULT_MAX_LENGTH = 0xfa0000;
    private final byte i32buf[];
    private int maxLength_;
    private TMemoryInputTransport readBuffer_;
    private TTransport transport_;
    private final TByteArrayOutputStream writeBuffer_;

    public TFramedTransport(TTransport ttransport)
    {
        transport_ = null;
        writeBuffer_ = new TByteArrayOutputStream(1024);
        readBuffer_ = new TMemoryInputTransport(new byte[0]);
        i32buf = new byte[4];
        transport_ = ttransport;
        maxLength_ = 0xfa0000;
    }

    public TFramedTransport(TTransport ttransport, int i)
    {
        transport_ = null;
        writeBuffer_ = new TByteArrayOutputStream(1024);
        readBuffer_ = new TMemoryInputTransport(new byte[0]);
        i32buf = new byte[4];
        transport_ = ttransport;
        maxLength_ = i;
    }

    public static final int decodeFrameSize(byte abyte0[])
    {
        return (abyte0[0] & 0xff) << 24 | (abyte0[1] & 0xff) << 16 | (abyte0[2] & 0xff) << 8 | abyte0[3] & 0xff;
    }

    public static final void encodeFrameSize(int i, byte abyte0[])
    {
        abyte0[0] = (byte)(i >> 24 & 0xff);
        abyte0[1] = (byte)(i >> 16 & 0xff);
        abyte0[2] = (byte)(i >> 8 & 0xff);
        abyte0[3] = (byte)(i & 0xff);
    }

    private void readFrame()
    {
        transport_.readAll(i32buf, 0, 4);
        int i = decodeFrameSize(i32buf);
        if (i < 0)
        {
            throw new TTransportException((new StringBuilder("Read a negative frame size (")).append(i).append(")!").toString());
        }
        if (i > maxLength_)
        {
            throw new TTransportException((new StringBuilder("Frame size (")).append(i).append(") larger than max length (").append(maxLength_).append(")!").toString());
        } else
        {
            byte abyte0[] = new byte[i];
            transport_.readAll(abyte0, 0, i);
            readBuffer_.reset(abyte0);
            return;
        }
    }

    public void close()
    {
        transport_.close();
    }

    public void consumeBuffer(int i)
    {
        readBuffer_.consumeBuffer(i);
    }

    public void flush()
    {
        byte abyte0[] = writeBuffer_.get();
        int i = writeBuffer_.len();
        writeBuffer_.reset();
        encodeFrameSize(i, i32buf);
        transport_.write(i32buf, 0, 4);
        transport_.write(abyte0, 0, i);
        transport_.flush();
    }

    public byte[] getBuffer()
    {
        return readBuffer_.getBuffer();
    }

    public int getBufferPosition()
    {
        return readBuffer_.getBufferPosition();
    }

    public int getBytesRemainingInBuffer()
    {
        return readBuffer_.getBytesRemainingInBuffer();
    }

    public boolean isOpen()
    {
        return transport_.isOpen();
    }

    public void open()
    {
        transport_.open();
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (readBuffer_ != null)
        {
            int k = readBuffer_.read(abyte0, i, j);
            if (k > 0)
            {
                return k;
            }
        }
        readFrame();
        return readBuffer_.read(abyte0, i, j);
    }

    public void write(byte abyte0[], int i, int j)
    {
        writeBuffer_.write(abyte0, i, j);
    }
}
