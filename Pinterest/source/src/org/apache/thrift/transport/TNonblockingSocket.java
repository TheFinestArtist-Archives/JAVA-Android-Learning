// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TNonblockingTransport, TTransportException

public class TNonblockingSocket extends TNonblockingTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TNonblockingSocket.getName());
    private final SocketAddress socketAddress_;
    private final SocketChannel socketChannel_;

    public TNonblockingSocket(String s, int i)
    {
        this(s, i, 0);
    }

    public TNonblockingSocket(String s, int i, int j)
    {
        this(SocketChannel.open(), j, ((SocketAddress) (new InetSocketAddress(s, i))));
    }

    public TNonblockingSocket(SocketChannel socketchannel)
    {
        this(socketchannel, 0, ((SocketAddress) (null)));
        if (!socketchannel.isConnected())
        {
            throw new IOException("Socket must already be connected");
        } else
        {
            return;
        }
    }

    private TNonblockingSocket(SocketChannel socketchannel, int i, SocketAddress socketaddress)
    {
        socketChannel_ = socketchannel;
        socketAddress_ = socketaddress;
        socketchannel.configureBlocking(false);
        socketchannel = socketchannel.socket();
        socketchannel.setSoLinger(false, 0);
        socketchannel.setTcpNoDelay(true);
        setTimeout(i);
    }

    public void close()
    {
        try
        {
            socketChannel_.close();
            return;
        }
        catch (IOException ioexception)
        {
            LOGGER.warn("Could not close socket.", ioexception);
        }
    }

    public boolean finishConnect()
    {
        return socketChannel_.finishConnect();
    }

    public void flush()
    {
    }

    public SocketChannel getSocketChannel()
    {
        return socketChannel_;
    }

    public boolean isOpen()
    {
        return socketChannel_.isOpen() && socketChannel_.isConnected();
    }

    public void open()
    {
        throw new RuntimeException("open() is not implemented for TNonblockingSocket");
    }

    public int read(ByteBuffer bytebuffer)
    {
        return socketChannel_.read(bytebuffer);
    }

    public int read(byte abyte0[], int i, int j)
    {
        if ((socketChannel_.validOps() & 1) != 1)
        {
            throw new TTransportException(1, "Cannot read from write-only socket channel");
        }
        try
        {
            i = socketChannel_.read(ByteBuffer.wrap(abyte0, i, j));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
        return i;
    }

    public SelectionKey registerSelector(Selector selector, int i)
    {
        return socketChannel_.register(selector, i);
    }

    public void setTimeout(int i)
    {
        try
        {
            socketChannel_.socket().setSoTimeout(i);
            return;
        }
        catch (SocketException socketexception)
        {
            LOGGER.warn("Could not set socket timeout.", socketexception);
        }
    }

    public boolean startConnect()
    {
        return socketChannel_.connect(socketAddress_);
    }

    public int write(ByteBuffer bytebuffer)
    {
        return socketChannel_.write(bytebuffer);
    }

    public void write(byte abyte0[], int i, int j)
    {
        if ((socketChannel_.validOps() & 4) != 4)
        {
            throw new TTransportException(1, "Cannot write to write-only socket channel");
        }
        try
        {
            socketChannel_.write(ByteBuffer.wrap(abyte0, i, j));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(0, abyte0);
        }
    }

}
