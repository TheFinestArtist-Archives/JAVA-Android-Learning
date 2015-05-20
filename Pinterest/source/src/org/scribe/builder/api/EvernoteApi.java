// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class EvernoteApi extends DefaultApi10a
{

    private static final String AUTHORIZATION_URL = "https://www.evernote.com/OAuth.action?oauth_token=%s";

    public EvernoteApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://www.evernote.com/oauth";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://www.evernote.com/OAuth.action?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://www.evernote.com/oauth";
    }
}
