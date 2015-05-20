// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi20

public class FacebookApi extends DefaultApi20
{

    private static final String AUTHORIZE_URL = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s";
    private static final String SCOPED_AUTHORIZE_URL = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s&scope=%s";

    public FacebookApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://graph.facebook.com/oauth/access_token";
    }

    public String getAuthorizationUrl(OAuthConfig oauthconfig)
    {
        Preconditions.checkValidUrl(oauthconfig.getCallback(), "Must provide a valid url as callback. Facebook does not support OOB");
        if (oauthconfig.hasScope())
        {
            return String.format("https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s&scope=%s", new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback()), OAuthEncoder.encode(oauthconfig.getScope())
            });
        } else
        {
            return String.format("https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s", new Object[] {
                oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback())
            });
        }
    }
}
