// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class ConstantContactApi extends DefaultApi10a
{

    private static final String AUTHORIZE_URL = "https://oauth.constantcontact.com/ws/oauth/confirm_access?oauth_token=%s";

    public ConstantContactApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://oauth.constantcontact.com/ws/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://oauth.constantcontact.com/ws/oauth/confirm_access?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://oauth.constantcontact.com/ws/oauth/request_token";
    }
}
