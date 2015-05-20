// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

// Referenced classes of package org.apache.thrift.transport:
//            TSocket, TTransportException, TServerSocket

public class TSSLTransportFactory
{

    public TSSLTransportFactory()
    {
    }

    private static TSocket createClient(SSLSocketFactory sslsocketfactory, String s, int i, int j)
    {
        try
        {
            sslsocketfactory = (SSLSocket)sslsocketfactory.createSocket(s, i);
            sslsocketfactory.setSoTimeout(j);
            sslsocketfactory = new TSocket(sslsocketfactory);
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocketFactory sslsocketfactory)
        {
            throw new TTransportException((new StringBuilder("Could not connect to ")).append(s).append(" on port ").append(i).toString(), sslsocketfactory);
        }
        return sslsocketfactory;
    }

    private static SSLContext createSSLContext(TSSLTransportParameters tssltransportparameters)
    {
        KeyManagerFactory keymanagerfactory = null;
        TrustManagerFactory trustmanagerfactory;
        SSLContext sslcontext;
        sslcontext = SSLContext.getInstance(tssltransportparameters.protocol);
        if (!tssltransportparameters.isTrustStoreSet)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        trustmanagerfactory = TrustManagerFactory.getInstance(tssltransportparameters.trustManagerType);
        KeyStore keystore = KeyStore.getInstance(tssltransportparameters.trustStoreType);
        keystore.load(new FileInputStream(tssltransportparameters.trustStore), tssltransportparameters.trustPass.toCharArray());
        trustmanagerfactory.init(keystore);
_L3:
        if (tssltransportparameters.isKeyStoreSet)
        {
            keymanagerfactory = KeyManagerFactory.getInstance(tssltransportparameters.keyManagerType);
            KeyStore keystore1 = KeyStore.getInstance(tssltransportparameters.keyStoreType);
            keystore1.load(new FileInputStream(tssltransportparameters.keyStore), tssltransportparameters.keyPass.toCharArray());
            keymanagerfactory.init(keystore1, tssltransportparameters.keyPass.toCharArray());
        }
        if (!tssltransportparameters.isKeyStoreSet || !tssltransportparameters.isTrustStoreSet) goto _L2; else goto _L1
_L1:
        sslcontext.init(keymanagerfactory.getKeyManagers(), trustmanagerfactory.getTrustManagers(), null);
        return sslcontext;
_L2:
        if (!tssltransportparameters.isKeyStoreSet)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        sslcontext.init(keymanagerfactory.getKeyManagers(), null, null);
        return sslcontext;
        try
        {
            sslcontext.init(null, trustmanagerfactory.getTrustManagers(), null);
        }
        // Misplaced declaration of an exception variable
        catch (TSSLTransportParameters tssltransportparameters)
        {
            throw new TTransportException("Error creating the transport", tssltransportparameters);
        }
        return sslcontext;
        trustmanagerfactory = null;
          goto _L3
    }

    private static TServerSocket createServer(SSLServerSocketFactory sslserversocketfactory, int i, int j, boolean flag, InetAddress inetaddress, TSSLTransportParameters tssltransportparameters)
    {
        try
        {
            sslserversocketfactory = (SSLServerSocket)sslserversocketfactory.createServerSocket(i, 100, inetaddress);
            sslserversocketfactory.setSoTimeout(j);
            sslserversocketfactory.setNeedClientAuth(flag);
        }
        // Misplaced declaration of an exception variable
        catch (SSLServerSocketFactory sslserversocketfactory)
        {
            throw new TTransportException((new StringBuilder("Could not bind to port ")).append(i).toString(), sslserversocketfactory);
        }
        if (tssltransportparameters == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (tssltransportparameters.cipherSuites != null)
        {
            sslserversocketfactory.setEnabledCipherSuites(tssltransportparameters.cipherSuites);
        }
        sslserversocketfactory = new TServerSocket(sslserversocketfactory, j);
        return sslserversocketfactory;
    }

    public static TSocket getClientSocket(String s, int i)
    {
        return getClientSocket(s, i, 0);
    }

    public static TSocket getClientSocket(String s, int i, int j)
    {
        return createClient((SSLSocketFactory)SSLSocketFactory.getDefault(), s, i, j);
    }

    public static TSocket getClientSocket(String s, int i, int j, TSSLTransportParameters tssltransportparameters)
    {
        if (tssltransportparameters == null || !tssltransportparameters.isKeyStoreSet && !tssltransportparameters.isTrustStoreSet)
        {
            throw new TTransportException("Either one of the KeyStore or TrustStore must be set for SSLTransportParameters");
        } else
        {
            return createClient(createSSLContext(tssltransportparameters).getSocketFactory(), s, i, j);
        }
    }

    public static TServerSocket getServerSocket(int i)
    {
        return getServerSocket(i, 0);
    }

    public static TServerSocket getServerSocket(int i, int j)
    {
        return getServerSocket(i, j, false, ((InetAddress) (null)));
    }

    public static TServerSocket getServerSocket(int i, int j, InetAddress inetaddress, TSSLTransportParameters tssltransportparameters)
    {
        if (tssltransportparameters == null || !tssltransportparameters.isKeyStoreSet && !tssltransportparameters.isTrustStoreSet)
        {
            throw new TTransportException("Either one of the KeyStore or TrustStore must be set for SSLTransportParameters");
        } else
        {
            return createServer(createSSLContext(tssltransportparameters).getServerSocketFactory(), i, j, tssltransportparameters.clientAuth, inetaddress, tssltransportparameters);
        }
    }

    public static TServerSocket getServerSocket(int i, int j, boolean flag, InetAddress inetaddress)
    {
        return createServer((SSLServerSocketFactory)SSLServerSocketFactory.getDefault(), i, j, flag, inetaddress, null);
    }

    private class TSSLTransportParameters
    {

        protected String cipherSuites[];
        protected boolean clientAuth;
        protected boolean isKeyStoreSet;
        protected boolean isTrustStoreSet;
        protected String keyManagerType;
        protected String keyPass;
        protected String keyStore;
        protected String keyStoreType;
        protected String protocol;
        protected String trustManagerType;
        protected String trustPass;
        protected String trustStore;
        protected String trustStoreType;

        public void requireClientAuth(boolean flag)
        {
            clientAuth = flag;
        }

        public void setKeyStore(String s, String s1)
        {
            setKeyStore(s, s1, null, null);
        }

        public void setKeyStore(String s, String s1, String s2, String s3)
        {
            keyStore = s;
            keyPass = s1;
            if (s2 != null)
            {
                keyManagerType = s2;
            }
            if (s3 != null)
            {
                keyStoreType = s3;
            }
            isKeyStoreSet = true;
        }

        public void setTrustStore(String s, String s1)
        {
            setTrustStore(s, s1, null, null);
        }

        public void setTrustStore(String s, String s1, String s2, String s3)
        {
            trustStore = s;
            trustPass = s1;
            if (s2 != null)
            {
                trustManagerType = s2;
            }
            if (s3 != null)
            {
                trustStoreType = s3;
            }
            isTrustStoreSet = true;
        }

        public TSSLTransportParameters()
        {
            protocol = "TLS";
            keyManagerType = KeyManagerFactory.getDefaultAlgorithm();
            keyStoreType = "JKS";
            trustManagerType = TrustManagerFactory.getDefaultAlgorithm();
            trustStoreType = "JKS";
            clientAuth = false;
            isKeyStoreSet = false;
            isTrustStoreSet = false;
        }

        public TSSLTransportParameters(String s, String as[])
        {
            this(s, as, false);
        }

        public TSSLTransportParameters(String s, String as[], boolean flag)
        {
            protocol = "TLS";
            keyManagerType = KeyManagerFactory.getDefaultAlgorithm();
            keyStoreType = "JKS";
            trustManagerType = TrustManagerFactory.getDefaultAlgorithm();
            trustStoreType = "JKS";
            clientAuth = false;
            isKeyStoreSet = false;
            isTrustStoreSet = false;
            if (s != null)
            {
                protocol = s;
            }
            cipherSuites = as;
            clientAuth = flag;
        }
    }

}
