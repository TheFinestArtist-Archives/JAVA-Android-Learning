// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class FreelancerApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "http://www.freelancer.com/users/api-token/auth.php?oauth_token=%s";

    public FreelancerApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://api.freelancer.com/RequestAccessToken/requestAccessToken.xml?";
    }

    public Verb getAccessTokenVerb()
    {
        return Verb.GET;
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://www.freelancer.com/users/api-token/auth.php?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.freelancer.com/RequestRequestToken/requestRequestToken.xml";
    }

    public Verb getRequestTokenVerb()
    {
        return Verb.GET;
    }
}
