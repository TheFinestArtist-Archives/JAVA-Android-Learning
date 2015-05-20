// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class DiggApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "http://digg.com/oauth/authorize?oauth_token=%s";
    private static final String BASE_URL = "http://services.digg.com/oauth/";

    public DiggApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://services.digg.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://digg.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://services.digg.com/oauth/request_token";
    }
}
