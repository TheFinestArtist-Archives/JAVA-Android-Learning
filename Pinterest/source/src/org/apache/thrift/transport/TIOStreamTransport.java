// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport, TTransportException

public class TIOStreamTransport extends TTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TIOStreamTransport.getName());
    protected InputStream inputStream_;
    protected OutputStream outputStream_;

    protected TIOStreamTransport()
    {
        inputStream_ = null;
        outputStream_ = null;
    }

    public TIOStreamTransport(InputStream inputstream)
    {
        inputStream_ = null;
        outputStream_ = null;
        inputStream_ = inputstream;
    }

    public TIOStreamTransport(InputStream inputstream, OutputStream outputstream)
    {
        inputStream_ = null;
        outputStream_ = null;
        inputStream_ = inputstream;
        outputStream_ = outputstream;
    }

    public TIOStreamTransport(OutputStream outputstream)
    {
        inputStream_ = null;
        outputStream_ = null;
        outputStream_ = outputstream;
    }

    public void close()
    {
        if (inputStream_ != null)
        {
            try
            {
                inputStream_.close();
            }
            catch (IOException ioexception)
            {
                LOGGER.warn("Error closing input stream.", ioexception);
            }
            inputStream_ = null;
        }
        if (outputStream_ != null)
        {
            try
            {
                outputStream_.close();
            }
            catch (IOException ioexception1)
            {
                LOGGER.warn("Error closing output stream.", ioexception1);
            }
            outputStream_ = null;
        }
    }

    public void flush()
    {
        if (outputStream_ == null)
        {
            throw new TTransportException(1, "Cannot flush null outputStream");
        }
        try
        {
            outputStream_.flush();
            return;
        }
        catch (IOException ioexception)
        {
            throw new TTransportException(0, ioexception);
        }
    }

    public boolean isOpen()
    {
        return true;
    }

    public void open()
    {
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (inputStream_ == null)
        {
            throw new TTransportException(1, "Cannot read from null inputStream");
        }
        try
        {
            i = inputStream_.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
        if (i < 0)
        {
            throw new TTransportException(4);
        } else
        {
            return i;
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        if (outputStream_ == null)
        {
            throw new TTransportException(1, "Cannot write to null outputStream");
        }
        try
        {
            outputStream_.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
    }

}
