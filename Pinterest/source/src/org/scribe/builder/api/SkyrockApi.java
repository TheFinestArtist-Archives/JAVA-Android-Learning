// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class SkyrockApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_RESOURCE = "/oauth/token";
    private static final String API_ENDPOINT = "https://api.skyrock.com/v2";
    private static final String AUTHORIZE_URL = "/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "/oauth/initiate";

    public SkyrockApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.skyrock.com/v2/oauth/token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.skyrock.com/v2/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.skyrock.com/v2/oauth/initiate";
    }
}
