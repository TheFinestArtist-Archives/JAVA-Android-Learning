// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake
{

    private final String a;
    private final List b;
    private final List c;

    private Handshake(String s, List list, List list1)
    {
        a = s;
        b = list;
        c = list1;
    }

    public static Handshake a(String s, List list, List list1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cipherSuite == null");
        } else
        {
            return new Handshake(s, Util.a(list), Util.a(list1));
        }
    }

    public static Handshake a(SSLSession sslsession)
    {
        String s = sslsession.getCipherSuite();
        if (s == null)
        {
            throw new IllegalStateException("cipherSuite == null");
        }
        List list;
        try
        {
            list = sslsession.getPeerCertificates();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list = null;
        }
        if (list != null)
        {
            list = Util.a(list);
        } else
        {
            list = Collections.emptyList();
        }
        sslsession = sslsession.getLocalCertificates();
        if (sslsession != null)
        {
            sslsession = Util.a(sslsession);
        } else
        {
            sslsession = Collections.emptyList();
        }
        return new Handshake(s, list, sslsession);
    }

    public final String a()
    {
        return a;
    }

    public final List b()
    {
        return b;
    }

    public final Principal c()
    {
        if (!b.isEmpty())
        {
            return ((X509Certificate)b.get(0)).getSubjectX500Principal();
        } else
        {
            return null;
        }
    }

    public final List d()
    {
        return c;
    }

    public final Principal e()
    {
        if (!c.isEmpty())
        {
            return ((X509Certificate)c.get(0)).getSubjectX500Principal();
        } else
        {
            return null;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Handshake)
        {
            if (a.equals(((Handshake) (obj = (Handshake)obj)).a) && b.equals(((Handshake) (obj)).b) && c.equals(((Handshake) (obj)).c))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return ((a.hashCode() + 527) * 31 + b.hashCode()) * 31 + c.hashCode();
    }
}
