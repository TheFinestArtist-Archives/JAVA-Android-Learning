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

public class VkontakteApi extends DefaultApi20
{

    private static final String AUTHORIZE_URL = "https://oauth.vk.com/authorize?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = String.format("%s&scope=%%s", new Object[] {
        "https://oauth.vk.com/authorize?client_id=%s&redirect_uri=%s&response_type=code"
    });

    public VkontakteApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.vkontakte.ru/oauth/access_token";
    }

    public AccessTokenExtractor getAccessTokenExtractor()
    {
        return new JsonTokenExtractor();
    }

    public String getAuthorizationUrl(OAuthConfig oauthconfig)
    {
        Preconditions.checkValidUrl(oauthconfig.getCallback(), "Valid url is required for a callback. Vkontakte does not support OOB");
        if (oauthconfig.hasScope())
        {
            return String.format(SCOPED_AUTHORIZE_URL, new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback()), OAuthEncoder.encode(oauthconfig.getScope())
            });
        } else
        {
            return String.format("https://oauth.vk.com/authorize?client_id=%s&redirect_uri=%s&response_type=code", new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback())
            });
        }
    }

}
