// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.services;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;
import org.scribe.exceptions.OAuthSignatureException;

// Referenced classes of package org.scribe.services:
//            Base64Encoder

public class CommonsEncoder extends Base64Encoder
{

    public CommonsEncoder()
    {
    }

    public static boolean isPresent()
    {
        try
        {
            Class.forName("org.apache.commons.codec.binary.Base64");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public String encode(byte abyte0[])
    {
        try
        {
            abyte0 = new String(Base64.encodeBase64(abyte0), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new OAuthSignatureException("Can't perform base64 encoding", abyte0);
        }
        return abyte0;
    }

    public String getType()
    {
        return "CommonsCodec";
    }
}
