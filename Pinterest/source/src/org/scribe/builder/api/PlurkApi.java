// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class PlurkApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_URL = "http://www.plurk.com/OAuth/access_token";
    private static final String AUTHORIZATION_URL = "http://www.plurk.com/OAuth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://www.plurk.com/OAuth/request_token";

    public PlurkApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://www.plurk.com/OAuth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://www.plurk.com/OAuth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://www.plurk.com/OAuth/request_token";
    }
}
