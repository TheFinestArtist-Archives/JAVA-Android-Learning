// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class FoursquareApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "http://foursquare.com/oauth/authorize?oauth_token=%s";

    public FoursquareApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://foursquare.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://foursquare.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://foursquare.com/oauth/request_token";
    }
}
