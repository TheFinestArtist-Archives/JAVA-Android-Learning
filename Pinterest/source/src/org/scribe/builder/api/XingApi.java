// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class XingApi extends DefaultApi10a
{

    private static final String AUTHORIZE_URL = "https://api.xing.com/v1/authorize?oauth_token=%s";

    public XingApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.xing.com/v1/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.xing.com/v1/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.xing.com/v1/request_token";
    }
}
