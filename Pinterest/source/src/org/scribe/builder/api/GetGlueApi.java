// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class GetGlueApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_RESOURCE = "https://api.getglue.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "http://getglue.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "https://api.getglue.com/oauth/request_token";

    public GetGlueApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.getglue.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://getglue.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.getglue.com/oauth/request_token";
    }
}
