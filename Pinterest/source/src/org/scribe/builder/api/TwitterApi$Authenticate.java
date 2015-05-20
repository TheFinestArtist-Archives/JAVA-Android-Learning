// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

public class  extends 
{

    private static final String AUTHENTICATE_URL = "https://api.twitter.com/oauth/authenticate?oauth_token=%s";

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.twitter.com/oauth/authenticate?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public ()
    {
    }
}
