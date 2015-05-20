// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class DropBoxApi extends DefaultApi10a
{

    public DropBoxApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.dropbox.com/1/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return (new StringBuilder("https://www.dropbox.com/1/oauth/authorize?oauth_token=")).append(token.getToken()).toString();
    }

    public String getRequestTokenEndpoint()
    {
        return "https://api.dropbox.com/1/oauth/request_token";
    }
}
