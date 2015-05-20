// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.scribe.exceptions.OAuthSignatureException;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.services:
//            SignatureService, Base64Encoder

public class HMACSha1SignatureService
    implements SignatureService
{

    private static final String CARRIAGE_RETURN = "\r\n";
    private static final String EMPTY_STRING = "";
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String METHOD = "HMAC-SHA1";
    private static final String UTF8 = "UTF-8";

    public HMACSha1SignatureService()
    {
    }

    private String bytesToBase64String(byte abyte0[])
    {
        return Base64Encoder.getInstance().encode(abyte0);
    }

    private String doSign(String s, String s1)
    {
        s1 = new SecretKeySpec(s1.getBytes("UTF-8"), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(s1);
        return bytesToBase64String(mac.doFinal(s.getBytes("UTF-8"))).replace("\r\n", "");
    }

    public String getSignature(String s, String s1, String s2)
    {
        try
        {
            Preconditions.checkEmptyString(s, "Base string cant be null or empty string");
            Preconditions.checkEmptyString(s1, "Api secret cant be null or empty string");
            s1 = doSign(s, (new StringBuilder()).append(OAuthEncoder.encode(s1)).append('&').append(OAuthEncoder.encode(s2)).toString());
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
        return "HMAC-SHA1";
    }
}
