// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            EvernoteApi

public class  extends EvernoteApi
{

    private static final String SANDBOX_URL = "https://sandbox.evernote.com";

    public String getAccessTokenEndpoint()
    {
        return "https://sandbox.evernote.com/oauth";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://sandbox.evernote.com/OAuth.action?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://sandbox.evernote.com/oauth";
    }

    public ()
    {
    }
}
