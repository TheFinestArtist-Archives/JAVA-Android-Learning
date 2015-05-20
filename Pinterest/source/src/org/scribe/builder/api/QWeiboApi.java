// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class QWeiboApi extends DefaultApi10a
{

    private static final String ACCESS_TOKEN_URL = "https://open.t.qq.com/cgi-bin/access_token";
    private static final String AUTHORIZE_URL = "https://open.t.qq.com/cgi-bin/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "https://open.t.qq.com/cgi-bin/request_token";

    public QWeiboApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://open.t.qq.com/cgi-bin/access_token";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://open.t.qq.com/cgi-bin/authorize?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        return "https://open.t.qq.com/cgi-bin/request_token";
    }
}
