// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.Queue;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

// Referenced classes of package crittercism.android:
//            ae, b, c, ba, 
//            x, w, ce, d

public final class aa extends SSLSocket
    implements ae
{

    private SSLSocket a;
    private d b;
    private c c;
    private final Queue d = new LinkedList();
    private w e;
    private x f;

    public aa(SSLSocket sslsocket, d d1, c c1)
    {
        if (sslsocket == null)
        {
            throw new NullPointerException("delegate was null");
        }
        if (d1 == null)
        {
            throw new NullPointerException("dispatch was null");
        } else
        {
            a = sslsocket;
            b = d1;
            c = c1;
            return;
        }
    }

    private b a(boolean flag)
    {
        b b1 = new b();
        InetAddress inetaddress = a.getInetAddress();
        if (inetaddress != null)
        {
            b1.a(inetaddress);
        }
        if (flag)
        {
            b1.a(getPort());
        }
        b1.a(k.a.b);
        if (c != null)
        {
            b1.j = c.a();
        }
        if (ba.b())
        {
            b1.a(ba.a());
        }
        return b1;
    }

    public final b a()
    {
        return a(false);
    }

    public final void a(b b1)
    {
        if (b1 != null)
        {
            synchronized (d)
            {
                d.add(b1);
            }
        }
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakecompletedlistener)
    {
        a.addHandshakeCompletedListener(handshakecompletedlistener);
    }

    public final b b()
    {
        b b1;
        synchronized (d)
        {
            b1 = (b)d.poll();
        }
        return b1;
    }

    public final void bind(SocketAddress socketaddress)
    {
        a.bind(socketaddress);
    }

    public final void close()
    {
        a.close();
        try
        {
            if (f != null)
            {
                f.d();
            }
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    public final void connect(SocketAddress socketaddress)
    {
        a.connect(socketaddress);
    }

    public final void connect(SocketAddress socketaddress, int i)
    {
        a.connect(socketaddress, i);
    }

    public final boolean equals(Object obj)
    {
        return a.equals(obj);
    }

    public final SocketChannel getChannel()
    {
        return a.getChannel();
    }

    public final boolean getEnableSessionCreation()
    {
        return a.getEnableSessionCreation();
    }

    public final String[] getEnabledCipherSuites()
    {
        return a.getEnabledCipherSuites();
    }

    public final String[] getEnabledProtocols()
    {
        return a.getEnabledProtocols();
    }

    public final InetAddress getInetAddress()
    {
        return a.getInetAddress();
    }

    public final InputStream getInputStream()
    {
        Object obj;
        obj = a.getInputStream();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        x x1;
        if (f != null && f.a(((InputStream) (obj))))
        {
            return f;
        }
        f = new x(this, ((InputStream) (obj)), b);
        x1 = f;
        return x1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        return ((InputStream) (obj));
    }

    public final boolean getKeepAlive()
    {
        return a.getKeepAlive();
    }

    public final InetAddress getLocalAddress()
    {
        return a.getLocalAddress();
    }

    public final int getLocalPort()
    {
        return a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress()
    {
        return a.getLocalSocketAddress();
    }

    public final boolean getNeedClientAuth()
    {
        return a.getNeedClientAuth();
    }

    public final boolean getOOBInline()
    {
        return a.getOOBInline();
    }

    public final OutputStream getOutputStream()
    {
        Object obj;
        obj = a.getOutputStream();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        w w1;
        if (e != null && e.a(((OutputStream) (obj))))
        {
            return e;
        }
        e = new w(this, ((OutputStream) (obj)));
        w1 = e;
        return w1;
        obj;
        throw obj;
        Throwable throwable;
        throwable;
        return ((OutputStream) (obj));
    }

    public final int getPort()
    {
        return a.getPort();
    }

    public final int getReceiveBufferSize()
    {
        return a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress()
    {
        return a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress()
    {
        return a.getReuseAddress();
    }

    public final int getSendBufferSize()
    {
        return a.getSendBufferSize();
    }

    public final SSLSession getSession()
    {
        return a.getSession();
    }

    public final int getSoLinger()
    {
        return a.getSoLinger();
    }

    public final int getSoTimeout()
    {
        return a.getSoTimeout();
    }

    public final String[] getSupportedCipherSuites()
    {
        return a.getSupportedCipherSuites();
    }

    public final String[] getSupportedProtocols()
    {
        return a.getSupportedProtocols();
    }

    public final boolean getTcpNoDelay()
    {
        return a.getTcpNoDelay();
    }

    public final int getTrafficClass()
    {
        return a.getTrafficClass();
    }

    public final boolean getUseClientMode()
    {
        return a.getUseClientMode();
    }

    public final boolean getWantClientAuth()
    {
        return a.getWantClientAuth();
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final boolean isBound()
    {
        return a.isBound();
    }

    public final boolean isClosed()
    {
        return a.isClosed();
    }

    public final boolean isConnected()
    {
        return a.isConnected();
    }

    public final boolean isInputShutdown()
    {
        return a.isInputShutdown();
    }

    public final boolean isOutputShutdown()
    {
        return a.isOutputShutdown();
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakecompletedlistener)
    {
        a.removeHandshakeCompletedListener(handshakecompletedlistener);
    }

    public final void sendUrgentData(int i)
    {
        a.sendUrgentData(i);
    }

    public final void setEnableSessionCreation(boolean flag)
    {
        a.setEnableSessionCreation(flag);
    }

    public final void setEnabledCipherSuites(String as[])
    {
        a.setEnabledCipherSuites(as);
    }

    public final void setEnabledProtocols(String as[])
    {
        a.setEnabledProtocols(as);
    }

    public final void setKeepAlive(boolean flag)
    {
        a.setKeepAlive(flag);
    }

    public final void setNeedClientAuth(boolean flag)
    {
        a.setNeedClientAuth(flag);
    }

    public final void setOOBInline(boolean flag)
    {
        a.setOOBInline(flag);
    }

    public final void setPerformancePreferences(int i, int j, int k)
    {
        a.setPerformancePreferences(i, j, k);
    }

    public final void setReceiveBufferSize(int i)
    {
        a.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean flag)
    {
        a.setReuseAddress(flag);
    }

    public final void setSendBufferSize(int i)
    {
        a.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean flag, int i)
    {
        a.setSoLinger(flag, i);
    }

    public final void setSoTimeout(int i)
    {
        a.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean flag)
    {
        a.setTcpNoDelay(flag);
    }

    public final void setTrafficClass(int i)
    {
        a.setTrafficClass(i);
    }

    public final void setUseClientMode(boolean flag)
    {
        a.setUseClientMode(flag);
    }

    public final void setWantClientAuth(boolean flag)
    {
        a.setWantClientAuth(flag);
    }

    public final void shutdownInput()
    {
        a.shutdownInput();
    }

    public final void shutdownOutput()
    {
        a.shutdownOutput();
    }

    public final void startHandshake()
    {
        try
        {
            a.startHandshake();
            return;
        }
        catch (IOException ioexception)
        {
            try
            {
                b b1 = a(true);
                b1.e();
                b1.g = ce.a(ioexception);
                b.a(b1, b.a.j);
            }
            catch (ThreadDeath threaddeath)
            {
                throw threaddeath;
            }
            catch (Throwable throwable) { }
        }
        throw ioexception;
    }

    public final String toString()
    {
        return a.toString();
    }
}
