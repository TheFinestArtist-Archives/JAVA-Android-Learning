// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class NeteaseWeibooApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_URL = "http://api.t.163.com/oauth/access_token";
    private static final String AUTHENTICATE_URL = "http://api.t.163.com/oauth/authenticate?oauth_token=%s";
    private static final String AUTHORIZE_URL = "http://api.t.163.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://api.t.163.com/oauth/request_token";

    public NeteaseWeibooApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://api.t.163.com/oauth/access_token";
    }

    public String getAuthenticateUrl(Token token)
    {
        return String.format("http://api.t.163.com/oauth/authenticate?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://api.t.163.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.t.163.com/oauth/request_token";
    }
}
