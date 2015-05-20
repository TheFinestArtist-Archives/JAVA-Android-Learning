// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

// Referenced classes of package com.squareup.okhttp.internal.tls:
//            DistinguishedNameParser

public final class OkHostnameVerifier
    implements HostnameVerifier
{

    public static final OkHostnameVerifier a = new OkHostnameVerifier();
    private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private OkHostnameVerifier()
    {
    }

    private static List a(X509Certificate x509certificate, int i)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        Object obj;
        Integer integer;
        try
        {
            x509certificate = x509certificate.getSubjectAlternativeNames();
        }
        // Misplaced declaration of an exception variable
        catch (X509Certificate x509certificate)
        {
            return Collections.emptyList();
        }
        if (x509certificate != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        return Collections.emptyList();
        x509certificate = x509certificate.iterator();
_L2:
        do
        {
            if (!x509certificate.hasNext())
            {
                break MISSING_BLOCK_LABEL_118;
            }
            obj = (List)x509certificate.next();
        } while (obj == null);
        if (((List) (obj)).size() < 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        integer = (Integer)((List) (obj)).get(0);
        if (integer == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (integer.intValue() != i)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (String)((List) (obj)).get(1);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist.add(obj);
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private static boolean a(String s, String s1)
    {
        boolean flag1 = true;
        if (s != null && s.length() != 0 && s1 != null && s1.length() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        s1 = s1.toLowerCase(Locale.US);
        if (!s1.contains("*"))
        {
            return s.equals(s1);
        }
        if (!s1.startsWith("*."))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (s.regionMatches(0, s1, 2, s1.length() - 2)) goto _L4; else goto _L3
_L3:
        int i = s1.indexOf('*');
        if (i > s1.indexOf('.'))
        {
            return false;
        }
        if (!s.regionMatches(0, s1, 0, i))
        {
            return false;
        }
        int j = s1.length() - (i + 1);
        int k = s.length() - j;
        if (s.indexOf('.', i) < k)
        {
            return false;
        }
        flag = flag1;
        if (!s.regionMatches(k, s1, i + 1, j))
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final boolean verify(String s, SSLSession sslsession)
    {
        sslsession = (X509Certificate)sslsession.getPeerCertificates()[0];
        if (!b.matcher(s).matches()) goto _L2; else goto _L1
_L1:
        sslsession = a(sslsession, 7).iterator();
_L6:
        if (!sslsession.hasNext()) goto _L4; else goto _L3
_L3:
        if (!s.equalsIgnoreCase((String)sslsession.next())) goto _L6; else goto _L5
_L5:
        return true;
_L2:
        boolean flag;
        Iterator iterator;
        boolean flag1;
        try
        {
            s = s.toLowerCase(Locale.US);
            iterator = a(sslsession, 2).iterator();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        flag = false;
_L8:
        if (iterator.hasNext())
        {
            if (a(s, (String)iterator.next()))
            {
                return true;
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        sslsession = (new DistinguishedNameParser(sslsession.getSubjectX500Principal())).a("cn");
        if (sslsession == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        flag1 = a(s, sslsession);
        return flag1;
        return false;
_L4:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
