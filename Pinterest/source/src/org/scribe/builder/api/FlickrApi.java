// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class FlickrApi extends DefaultApi10a
{

    public FlickrApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://www.flickr.com/services/oauth/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return (new StringBuilder("http://www.flickr.com/services/oauth/authorize?oauth_token=")).append(token.getToken()).toString();
    }

    public String getRequestTokenEndpoint()
    {
        return "http://www.flickr.com/services/oauth/request_token";
    }
}
