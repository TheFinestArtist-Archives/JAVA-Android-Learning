// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.io.OutputStream;

// Referenced classes of package org.scribe.model:
//            SignatureType

public class OAuthConfig
{

    private final String apiKey;
    private final String apiSecret;
    private final String callback;
    private final OutputStream debugStream;
    private final String scope;
    private final SignatureType signatureType;

    public OAuthConfig(String s, String s1)
    {
        this(s, s1, null, null, null, null);
    }

    public OAuthConfig(String s, String s1, String s2, SignatureType signaturetype, String s3, OutputStream outputstream)
    {
        apiKey = s;
        apiSecret = s1;
        callback = s2;
        signatureType = signaturetype;
        scope = s3;
        debugStream = outputstream;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public String getApiSecret()
    {
        return apiSecret;
    }

    public String getCallback()
    {
        return callback;
    }

    public String getScope()
    {
        return scope;
    }

    public SignatureType getSignatureType()
    {
        return signatureType;
    }

    public boolean hasScope()
    {
        return scope != null;
    }

    public void log(String s)
    {
        if (debugStream == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = (new StringBuilder()).append(s).append("\n").toString();
        debugStream.write(s.getBytes("UTF8"));
        return;
        s;
        throw new RuntimeException("there were problems while writting to the debug stream", s);
    }
}
