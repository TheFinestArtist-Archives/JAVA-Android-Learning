// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TNonblockingServerTransport, TTransportException, TNonblockingSocket, TTransport

public class TNonblockingServerSocket extends TNonblockingServerTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TNonblockingServerTransport.getName());
    private int clientTimeout_;
    private ServerSocketChannel serverSocketChannel;
    private ServerSocket serverSocket_;

    public TNonblockingServerSocket(int i)
    {
        this(i, 0);
    }

    public TNonblockingServerSocket(int i, int j)
    {
        this(new InetSocketAddress(i), j);
    }

    public TNonblockingServerSocket(InetSocketAddress inetsocketaddress)
    {
        this(inetsocketaddress, 0);
    }

    public TNonblockingServerSocket(InetSocketAddress inetsocketaddress, int i)
    {
        serverSocketChannel = null;
        serverSocket_ = null;
        clientTimeout_ = 0;
        clientTimeout_ = i;
        try
        {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocket_ = serverSocketChannel.socket();
            serverSocket_.setReuseAddress(true);
            serverSocket_.bind(inetsocketaddress);
            return;
        }
        catch (IOException ioexception)
        {
            serverSocket_ = null;
        }
        throw new TTransportException((new StringBuilder("Could not create ServerSocket on address ")).append(inetsocketaddress.toString()).append(".").toString());
    }

    protected TNonblockingSocket acceptImpl()
    {
        if (serverSocket_ == null)
        {
            throw new TTransportException(1, "No underlying server socket.");
        }
        Object obj;
        try
        {
            obj = serverSocketChannel.accept();
        }
        catch (IOException ioexception)
        {
            throw new TTransportException(ioexception);
        }
        if (obj == null)
        {
            return null;
        }
        obj = new TNonblockingSocket(((java.nio.channels.SocketChannel) (obj)));
        ((TNonblockingSocket) (obj)).setTimeout(clientTimeout_);
        return ((TNonblockingSocket) (obj));
    }

    protected volatile TTransport acceptImpl()
    {
        return acceptImpl();
    }

    public void close()
    {
        if (serverSocket_ != null)
        {
            try
            {
                serverSocket_.close();
            }
            catch (IOException ioexception)
            {
                LOGGER.warn((new StringBuilder("WARNING: Could not close server socket: ")).append(ioexception.getMessage()).toString());
            }
            serverSocket_ = null;
        }
    }

    public void interrupt()
    {
        close();
    }

    public void listen()
    {
        if (serverSocket_ == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        serverSocket_.setSoTimeout(0);
        return;
        SocketException socketexception;
        socketexception;
        socketexception.printStackTrace();
        return;
    }

    public void registerSelector(Selector selector)
    {
        try
        {
            serverSocketChannel.register(selector, 16);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Selector selector)
        {
            return;
        }
    }

}
