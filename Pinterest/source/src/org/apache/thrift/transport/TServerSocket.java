// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TServerTransport, TTransportException, TSocket, TTransport

public class TServerSocket extends TServerTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TServerSocket.getName());
    private int clientTimeout_;
    private ServerSocket serverSocket_;

    public TServerSocket(int i)
    {
        this(i, 0);
    }

    public TServerSocket(int i, int j)
    {
        this(new InetSocketAddress(i), j);
    }

    public TServerSocket(InetSocketAddress inetsocketaddress)
    {
        this(inetsocketaddress, 0);
    }

    public TServerSocket(InetSocketAddress inetsocketaddress, int i)
    {
        serverSocket_ = null;
        clientTimeout_ = 0;
        clientTimeout_ = i;
        try
        {
            serverSocket_ = new ServerSocket();
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

    public TServerSocket(ServerSocket serversocket)
    {
        this(serversocket, 0);
    }

    public TServerSocket(ServerSocket serversocket, int i)
    {
        serverSocket_ = null;
        clientTimeout_ = 0;
        serverSocket_ = serversocket;
        clientTimeout_ = i;
    }

    protected TSocket acceptImpl()
    {
        if (serverSocket_ == null)
        {
            throw new TTransportException(1, "No underlying server socket.");
        }
        TSocket tsocket;
        try
        {
            tsocket = new TSocket(serverSocket_.accept());
            tsocket.setTimeout(clientTimeout_);
        }
        catch (IOException ioexception)
        {
            throw new TTransportException(ioexception);
        }
        return tsocket;
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
                LOGGER.warn("Could not close server socket.", ioexception);
            }
            serverSocket_ = null;
        }
    }

    public ServerSocket getServerSocket()
    {
        return serverSocket_;
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
        LOGGER.error("Could not set socket timeout.", socketexception);
        return;
    }

}
