// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package org.scribe.model:
//            Request, Verb

public class OAuthRequest extends Request
{

    private static final String OAUTH_PREFIX = "oauth_";
    private Map oauthParameters;
    private String realm;

    public OAuthRequest(Verb verb, String s)
    {
        super(verb, s);
        oauthParameters = new HashMap();
    }

    private String checkKey(String s)
    {
        if (s.startsWith("oauth_") || s.equals("scope"))
        {
            return s;
        } else
        {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[] {
                "scope", "oauth_"
            }));
        }
    }

    public void addOAuthParameter(String s, String s1)
    {
        oauthParameters.put(checkKey(s), s1);
    }

    public Map getOauthParameters()
    {
        return oauthParameters;
    }

    public String getRealm()
    {
        return realm;
    }

    public void setRealm(String s)
    {
        realm = s;
    }

    public String toString()
    {
        return String.format("@OAuthRequest(%s, %s)", new Object[] {
            getVerb(), getUrl()
        });
    }
}
