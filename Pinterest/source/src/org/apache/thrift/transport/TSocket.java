// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TIOStreamTransport, TTransportException

public class TSocket extends TIOStreamTransport
{

    private static final Logger LOGGER = LoggerFactory.getLogger(org/apache/thrift/transport/TSocket.getName());
    private String host_;
    private int port_;
    private Socket socket_;
    private int timeout_;

    public TSocket(String s, int i)
    {
        this(s, i, 0);
    }

    public TSocket(String s, int i, int j)
    {
        socket_ = null;
        host_ = null;
        port_ = 0;
        timeout_ = 0;
        host_ = s;
        port_ = i;
        timeout_ = j;
        initSocket();
    }

    public TSocket(Socket socket)
    {
        socket_ = null;
        host_ = null;
        port_ = 0;
        timeout_ = 0;
        socket_ = socket;
        try
        {
            socket_.setSoLinger(false, 0);
            socket_.setTcpNoDelay(true);
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            LOGGER.warn("Could not configure socket.", socket);
        }
        if (!isOpen())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        inputStream_ = new BufferedInputStream(socket_.getInputStream(), 1024);
        outputStream_ = new BufferedOutputStream(socket_.getOutputStream(), 1024);
        return;
        socket;
        close();
        throw new TTransportException(1, socket);
    }

    private void initSocket()
    {
        socket_ = new Socket();
        try
        {
            socket_.setSoLinger(false, 0);
            socket_.setTcpNoDelay(true);
            socket_.setSoTimeout(timeout_);
            return;
        }
        catch (SocketException socketexception)
        {
            LOGGER.error("Could not configure socket.", socketexception);
        }
    }

    public void close()
    {
        super.close();
        if (socket_ != null)
        {
            try
            {
                socket_.close();
            }
            catch (IOException ioexception)
            {
                LOGGER.warn("Could not close socket.", ioexception);
            }
            socket_ = null;
        }
    }

    public Socket getSocket()
    {
        if (socket_ == null)
        {
            initSocket();
        }
        return socket_;
    }

    public boolean isOpen()
    {
        if (socket_ == null)
        {
            return false;
        } else
        {
            return socket_.isConnected();
        }
    }

    public void open()
    {
        if (isOpen())
        {
            throw new TTransportException(2, "Socket already connected.");
        }
        if (host_.length() == 0)
        {
            throw new TTransportException(1, "Cannot open null host.");
        }
        if (port_ <= 0)
        {
            throw new TTransportException(1, "Cannot open without port.");
        }
        if (socket_ == null)
        {
            initSocket();
        }
        try
        {
            socket_.connect(new InetSocketAddress(host_, port_), timeout_);
            inputStream_ = new BufferedInputStream(socket_.getInputStream(), 1024);
            outputStream_ = new BufferedOutputStream(socket_.getOutputStream(), 1024);
            return;
        }
        catch (IOException ioexception)
        {
            close();
            throw new TTransportException(1, ioexception);
        }
    }

    public void setTimeout(int i)
    {
        timeout_ = i;
        try
        {
            socket_.setSoTimeout(i);
            return;
        }
        catch (SocketException socketexception)
        {
            LOGGER.warn("Could not set socket timeout.", socketexception);
        }
    }

}
