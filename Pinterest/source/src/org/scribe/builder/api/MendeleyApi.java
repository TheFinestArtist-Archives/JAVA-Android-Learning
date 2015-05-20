// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class MendeleyApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "http://api.mendeley.com/oauth/authorize?oauth_token=%s";

    public MendeleyApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://api.mendeley.com/oauth/access_token/";
    }

    public Verb getAccessTokenVerb()
    {
        return Verb.GET;
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://api.mendeley.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.mendeley.com/oauth/request_token/";
    }

    public Verb getRequestTokenVerb()
    {
        return Verb.GET;
    }
}
