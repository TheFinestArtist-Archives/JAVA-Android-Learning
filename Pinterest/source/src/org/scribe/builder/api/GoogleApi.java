// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class GoogleApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=%s";

    public GoogleApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://www.google.com/accounts/OAuthGetAccessToken";
    }

    public Verb getAccessTokenVerb()
    {
        return Verb.GET;
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://www.google.com/accounts/OAuthGetRequestToken";
    }

    public Verb getRequestTokenVerb()
    {
        return Verb.GET;
    }
}
