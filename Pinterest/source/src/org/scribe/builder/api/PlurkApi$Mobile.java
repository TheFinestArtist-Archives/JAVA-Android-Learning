// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            PlurkApi

public class  extends PlurkApi
{

    private static final String AUTHORIZATION_URL = "http://www.plurk.com/m/authorize?oauth_token=%s";

    public String getAuthorizationUrl(Token token)
    {
        return String.format("http://www.plurk.com/m/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public ()
    {
    }
}
