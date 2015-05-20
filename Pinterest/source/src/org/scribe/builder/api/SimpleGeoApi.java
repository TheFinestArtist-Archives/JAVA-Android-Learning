// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import org.scribe.model.Token;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi10a

public class SimpleGeoApi extends DefaultApi10a
{

    private static final String ENDPOINT = "these are not used since SimpleGeo uses 2 legged OAuth";

    public SimpleGeoApi()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "these are not used since SimpleGeo uses 2 legged OAuth";
    }

    public String getAuthorizationUrl(Token token)
    {
        return "these are not used since SimpleGeo uses 2 legged OAuth";
    }

    public String getRequestTokenEndpoint()
    {
        return "these are not used since SimpleGeo uses 2 legged OAuth";
    }
}
