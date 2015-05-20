// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class YahooApi extends DefaultApi10a
{

    private static final String AUTHORIZE_URL = "https://api.login.yahoo.com/oauth/v2/request_auth?oauth_token=%s";

    public YahooApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.login.yahoo.com/oauth/v2/get_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.login.yahoo.com/oauth/v2/request_auth?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.login.yahoo.com/oauth/v2/get_request_token";
    }
}
