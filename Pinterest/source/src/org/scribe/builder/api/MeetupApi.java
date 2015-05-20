// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class MeetupApi extends DefaultApi10a
{

    private static final String AUTHORIZE_URL = "http://www.meetup.com/authenticate?oauth_token=%s";

    public MeetupApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "http://api.meetup.com/oauth/access/";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://www.meetup.com/authenticate?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "http://api.meetup.com/oauth/request/";
    }
}
