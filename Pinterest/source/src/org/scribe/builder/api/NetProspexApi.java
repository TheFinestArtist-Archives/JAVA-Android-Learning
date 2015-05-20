// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class NetProspexApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_URL = "https://api.netprospex.com/1.0/oauth/access-token";
    private static final String AUTHORIZE_URL = "https://api.netprospex.com/1.0/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "https://api.netprospex.com/1.0/oauth/request-token";

    public NetProspexApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.netprospex.com/1.0/oauth/access-token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.netprospex.com/1.0/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.netprospex.com/1.0/oauth/request-token";
    }
}
