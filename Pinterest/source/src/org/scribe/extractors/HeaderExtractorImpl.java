// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.extractors;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.scribe.exceptions.OAuthParametersMissingException;
import org.scribe.model.OAuthRequest;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.extractors:
//            HeaderExtractor

public class HeaderExtractorImpl
    implements HeaderExtractor
{

    public static final int ESTIMATED_PARAM_LENGTH = 20;
    private static final String PARAM_SEPARATOR = ", ";
    private static final String PREAMBLE = "OAuth ";

    public HeaderExtractorImpl()
    {
    }

    private void checkPreconditions(OAuthRequest oauthrequest)
    {
        Preconditions.checkNotNull(oauthrequest, "Cannot extract a header from a null object");
        if (oauthrequest.getOauthParameters() == null || oauthrequest.getOauthParameters().size() <= 0)
        {
            throw new OAuthParametersMissingException(oauthrequest);
        } else
        {
            return;
        }
    }

    public String extract(OAuthRequest oauthrequest)
    {
        checkPreconditions(oauthrequest);
        Object obj = oauthrequest.getOauthParameters();
        StringBuilder stringbuilder = new StringBuilder(((Map) (obj)).size() * 20);
        stringbuilder.append("OAuth ");
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append(String.format("%s=\"%s\"", new Object[] {
    entry.getKey(), OAuthEncoder.encode((String)entry.getValue())
})))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            if (stringbuilder.length() > 6)
            {
                stringbuilder.append(", ");
            }
        }

        if (oauthrequest.getRealm() != null && !oauthrequest.getRealm().isEmpty())
        {
            stringbuilder.append(", ");
            stringbuilder.append(String.format("%s=\"%s\"", new Object[] {
                "realm", oauthrequest.getRealm()
            }));
        }
        return stringbuilder.toString();
    }
}
