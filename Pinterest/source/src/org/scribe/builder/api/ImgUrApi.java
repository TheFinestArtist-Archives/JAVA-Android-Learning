// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class ImgUrApi extends DefaultApi10a
{

    public ImgUrApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.imgur.com/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.imgur.com/oauth/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.imgur.com/oauth/request_token";
    }
}
