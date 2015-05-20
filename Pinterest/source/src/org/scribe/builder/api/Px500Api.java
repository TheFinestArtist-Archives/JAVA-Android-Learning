// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class Px500Api extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "https://api.500px.com/v1/oauth/authorize?oauth_token=%s";

    public Px500Api()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.500px.com/v1/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.500px.com/v1/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.500px.com/v1/oauth/request_token";
    }
}
