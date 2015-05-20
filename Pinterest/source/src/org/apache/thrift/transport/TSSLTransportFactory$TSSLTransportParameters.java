// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class clientAuth
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

    public ()
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

    public isTrustStoreSet(String s, String as[])
    {
        this(s, as, false);
    }

    public <init>(String s, String as[], boolean flag)
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
