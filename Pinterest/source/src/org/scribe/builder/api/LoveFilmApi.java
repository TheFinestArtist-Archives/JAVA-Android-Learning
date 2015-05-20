// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class LoveFilmApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_URL = "http://openapi.lovefilm.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://www.lovefilm.com/activate?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://openapi.lovefilm.com/oauth/request_token";

    public LoveFilmApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://openapi.lovefilm.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://www.lovefilm.com/activate?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://openapi.lovefilm.com/oauth/request_token";
    }
}
