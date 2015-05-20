// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            FreelancerApi

public class  extends FreelancerApi
{

    private static final String SANDBOX_AUTHORIZATION_URL = "http://www.sandbox.freelancer.com/users/api-token/auth.php";

    public String getAccessTokenEndpoint()
    {
        return "http://api.sandbox.freelancer.com/RequestAccessToken/requestAccessToken.xml?";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://www.sandbox.freelancer.com/users/api-token/auth.php?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.sandbox.freelancer.com/RequestRequestToken/requestRequestToken.xml";
    }

    public ()
    {
    }
}
