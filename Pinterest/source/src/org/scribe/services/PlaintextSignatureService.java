// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import org.scribe.exceptions.OAuthSignatureException;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.services:
//            SignatureService

public class PlaintextSignatureService
    implements SignatureService
{

    private static final String METHOD = "PLAINTEXT";

    public PlaintextSignatureService()
    {
    }

    public String getSignature(String s, String s1, String s2)
    {
        try
        {
            Preconditions.checkEmptyString(s1, "Api secret cant be null or empty string");
            s1 = (new StringBuilder()).append(OAuthEncoder.encode(s1)).append('&').append(OAuthEncoder.encode(s2)).toString();
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
        return "PLAINTEXT";
    }
}
