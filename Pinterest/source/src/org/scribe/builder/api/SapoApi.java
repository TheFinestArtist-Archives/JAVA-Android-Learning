// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class SapoApi extends DefaultApi10a
{

    private static final String ACCESS_URL = "https://id.sapo.pt/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://id.sapo.pt/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_URL = "https://id.sapo.pt/oauth/request_token";

    public SapoApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://id.sapo.pt/oauth/access_token";
    }

    public Verb getAccessTokenVerb()
    {
        return Verb.GET;
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://id.sapo.pt/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://id.sapo.pt/oauth/request_token";
    }

    public Verb getRequestTokenVerb()
    {
        return Verb.GET;
    }
}
