// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.services.PlaintextSignatureService;
import org.scribe.services.SignatureService;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class UbuntuOneApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "https://one.ubuntu.com/oauth/authorize/?oauth_token=%s";

    public UbuntuOneApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://one.ubuntu.com/oauth/access/";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://one.ubuntu.com/oauth/authorize/?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://one.ubuntu.com/oauth/request/";
    }

    public SignatureService getSignatureService()
    {
        return new PlaintextSignatureService();
    }
}
