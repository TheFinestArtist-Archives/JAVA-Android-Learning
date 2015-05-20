// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import java.security.PrivateKey;
import java.security.Signature;
import org.scribe.exceptions.OAuthSignatureException;

// Referenced classes of package org.scribe.services:
//            SignatureService, Base64Encoder

public class RSASha1SignatureService
    implements SignatureService
{

    private static final String METHOD = "RSA-SHA1";
    private static final String RSA_SHA1 = "SHA1withRSA";
    private static final String UTF8 = "UTF-8";
    private PrivateKey privateKey;

    public RSASha1SignatureService(PrivateKey privatekey)
    {
        privateKey = privatekey;
    }

    private String bytesToBase64String(Signature signature)
    {
        return Base64Encoder.getInstance().encode(signature.sign());
    }

    public String getSignature(String s, String s1, String s2)
    {
        try
        {
            s1 = Signature.getInstance("SHA1withRSA");
            s1.initSign(privateKey);
            s1.update(s.getBytes("UTF-8"));
            s1 = bytesToBase64String(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new OAuthSignatureException(s, s1);
        }
        return s1;
    }

    public String getSignatureMethod()
    {
        return "RSA-SHA1";
    }
}
