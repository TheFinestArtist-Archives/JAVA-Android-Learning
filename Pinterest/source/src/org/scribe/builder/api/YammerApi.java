// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.services.PlaintextSignatureService;
import org.scribe.services.SignatureService;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class YammerApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "https://www.yammer.com/oauth/authorize?oauth_token=%s";

    public YammerApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://www.yammer.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://www.yammer.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://www.yammer.com/oauth/request_token";
    }

    public SignatureService getSignatureService()
    {
        return new PlaintextSignatureService();
    }
}
