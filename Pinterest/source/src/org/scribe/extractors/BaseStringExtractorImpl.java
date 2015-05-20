// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.extractors;

import java.util.Map;
import org.scribe.exceptions.OAuthParametersMissingException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.ParameterList;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.extractors:
//            BaseStringExtractor

public class BaseStringExtractorImpl
    implements BaseStringExtractor
{

    private static final String AMPERSAND_SEPARATED_STRING = "%s&%s&%s";

    public BaseStringExtractorImpl()
    {
    }

    private void checkPreconditions(OAuthRequest oauthrequest)
    {
        Preconditions.checkNotNull(oauthrequest, "Cannot extract base string from null object");
        if (oauthrequest.getOauthParameters() == null || oauthrequest.getOauthParameters().size() <= 0)
        {
            throw new OAuthParametersMissingException(oauthrequest);
        } else
        {
            return;
        }
    }

    private String getSortedAndEncodedParams(OAuthRequest oauthrequest)
    {
        ParameterList parameterlist = new ParameterList();
        parameterlist.addAll(oauthrequest.getQueryStringParams());
        parameterlist.addAll(oauthrequest.getBodyParams());
        parameterlist.addAll(new ParameterList(oauthrequest.getOauthParameters()));
        return parameterlist.sort().asOauthBaseString();
    }

    public String extract(OAuthRequest oauthrequest)
    {
        checkPreconditions(oauthrequest);
        return String.format("%s&%s&%s", new Object[] {
            OAuthEncoder.encode(oauthrequest.getVerb().name()), OAuthEncoder.encode(oauthrequest.getSanitizedUrl()), getSortedAndEncodedParams(oauthrequest)
        });
    }
}
