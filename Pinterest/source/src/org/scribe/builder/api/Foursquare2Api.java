// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi20

public class Foursquare2Api extends DefaultApi20
{

    private static final String AUTHORIZATION_URL = "https://foursquare.com/oauth2/authenticate?client_id=%s&response_type=code&redirect_uri=%s";

    public Foursquare2Api()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://foursquare.com/oauth2/access_token?grant_type=authorization_code";
    }

    public AccessTokenExtractor getAccessTokenExtractor()
    {
        return new JsonTokenExtractor();
    }

    public String getAuthorizationUrl(OAuthConfig oauthconfig)
    {
        Preconditions.checkValidUrl(oauthconfig.getCallback(), "Must provide a valid url as callback. Foursquare2 does not support OOB");
        return String.format("https://foursquare.com/oauth2/authenticate?client_id=%s&response_type=code&redirect_uri=%s", new Object[] {
            oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback())
        });
    }
}
