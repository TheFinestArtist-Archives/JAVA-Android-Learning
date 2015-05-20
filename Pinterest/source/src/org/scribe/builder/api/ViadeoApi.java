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

public class ViadeoApi extends DefaultApi20
{

    private static final String AUTHORIZE_URL = "https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = "https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code&scope=%s";

    public ViadeoApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://secure.viadeo.com/oauth-provider/access_token2?grant_type=authorization_code";
    }

    public AccessTokenExtractor getAccessTokenExtractor()
    {
        return new JsonTokenExtractor();
    }

    public String getAuthorizationUrl(OAuthConfig oauthconfig)
    {
        Preconditions.checkValidUrl(oauthconfig.getCallback(), "Must provide a valid url as callback. Viadeo does not support OOB");
        if (oauthconfig.hasScope())
        {
            return String.format("https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code&scope=%s", new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback()), OAuthEncoder.encode(oauthconfig.getScope())
            });
        } else
        {
            return String.format("https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code", new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback())
            });
        }
    }
}
