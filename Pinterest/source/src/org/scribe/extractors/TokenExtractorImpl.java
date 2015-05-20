// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.extractors:
//            AccessTokenExtractor, RequestTokenExtractor

public class TokenExtractorImpl
    implements AccessTokenExtractor, RequestTokenExtractor
{

    private static final Pattern SECRET_REGEX = Pattern.compile("oauth_token_secret=([^&]*)");
    private static final Pattern TOKEN_REGEX = Pattern.compile("oauth_token=([^&]+)");

    public TokenExtractorImpl()
    {
    }

    private String extract(String s, Pattern pattern)
    {
        pattern = pattern.matcher(s);
        if (pattern.find() && pattern.groupCount() > 0)
        {
            return OAuthEncoder.decode(pattern.group(1));
        } else
        {
            throw new OAuthException((new StringBuilder("Response body is incorrect. Can't extract token and secret from this: '")).append(s).append("'").toString(), null);
        }
    }

    public Token extract(String s)
    {
        Preconditions.checkEmptyString(s, "Response body is incorrect. Can't extract a token from an empty string");
        return new Token(extract(s, TOKEN_REGEX), extract(s, SECRET_REGEX), s);
    }

}
