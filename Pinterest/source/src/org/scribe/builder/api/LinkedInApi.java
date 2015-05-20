// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class LinkedInApi extends DefaultApi10a
{

    private static final String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authenticate?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "https://api.linkedin.com/uas/oauth/requestToken";
    private final Set scopes;

    public LinkedInApi()
    {
        scopes = Collections.emptySet();
    }

    public LinkedInApi(Set set)
    {
        scopes = Collections.unmodifiableSet(set);
    }

    private String scopesAsString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (Iterator iterator = scopes.iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder("+")).append(s).toString()))
        {
            s = (String)iterator.next();
        }

        return stringbuilder.substring(1);
    }

    public static transient LinkedInApi withScopes(String as[])
    {
        return new LinkedInApi(new HashSet(Arrays.asList(as)));
    }

    public String getAccessTokenEndpoint()
    {
        return "https://api.linkedin.com/uas/oauth/accessToken";
    }

    public String getAuthorizationUrl(Token token)
    {
        return String.format("https://api.linkedin.com/uas/oauth/authenticate?oauth_token=%s", new Object[] {
            token.getToken()
        });
    }

    public String getRequestTokenEndpoint()
    {
        if (scopes.isEmpty())
        {
            return "https://api.linkedin.com/uas/oauth/requestToken";
        } else
        {
            return (new StringBuilder("https://api.linkedin.com/uas/oauth/requestToken?scope=")).append(scopesAsString()).toString();
        }
    }
}
