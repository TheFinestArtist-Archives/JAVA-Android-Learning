// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.oauth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

// Referenced classes of package org.scribe.oauth:
//            OAuthService

public class OAuth20ServiceImpl
    implements OAuthService
{

    private static final String VERSION = "2.0";
    private final DefaultApi20 api;
    private final OAuthConfig config;

    public OAuth20ServiceImpl(DefaultApi20 defaultapi20, OAuthConfig oauthconfig)
    {
        api = defaultapi20;
        config = oauthconfig;
    }

    public Token getAccessToken(Token token, Verifier verifier)
    {
        token = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
        token.addQuerystringParameter("client_id", config.getApiKey());
        token.addQuerystringParameter("client_secret", config.getApiSecret());
        token.addQuerystringParameter("code", verifier.getValue());
        token.addQuerystringParameter("redirect_uri", config.getCallback());
        if (config.hasScope())
        {
            token.addQuerystringParameter("scope", config.getScope());
        }
        token = token.send();
        return api.getAccessTokenExtractor().extract(token.getBody());
    }

    public String getAuthorizationUrl(Token token)
    {
        return api.getAuthorizationUrl(config);
    }

    public Token getRequestToken()
    {
        throw new UnsupportedOperationException("Unsupported operation, please use 'getAuthorizationUrl' and redirect your users there");
    }

    public String getVersion()
    {
        return "2.0";
    }

    public void signRequest(Token token, OAuthRequest oauthrequest)
    {
        oauthrequest.addQuerystringParameter("access_token", token.getToken());
    }
}
