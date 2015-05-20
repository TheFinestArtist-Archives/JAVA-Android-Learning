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
//            AccessTokenExtractor

public class TokenExtractor20Impl
    implements AccessTokenExtractor
{

    private static final String EMPTY_SECRET = "";
    private static final String TOKEN_REGEX = "access_token=([^&]+)";

    public TokenExtractor20Impl()
    {
    }

    public Token extract(String s)
    {
        Preconditions.checkEmptyString(s, "Response body is incorrect. Can't extract a token from an empty string");
        Matcher matcher = Pattern.compile("access_token=([^&]+)").matcher(s);
        if (matcher.find())
        {
            return new Token(OAuthEncoder.decode(matcher.group(1)), "", s);
        } else
        {
            throw new OAuthException((new StringBuilder("Response body is incorrect. Can't extract a token from this: '")).append(s).append("'").toString(), null);
        }
    }
}
