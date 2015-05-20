// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.extractors:
//            AccessTokenExtractor

public class JsonTokenExtractor
    implements AccessTokenExtractor
{

    private Pattern accessTokenPattern;

    public JsonTokenExtractor()
    {
        accessTokenPattern = Pattern.compile("\"access_token\":\\s*\"(\\S*?)\"");
    }

    public Token extract(String s)
    {
        Preconditions.checkEmptyString(s, "Cannot extract a token from a null or empty String");
        Matcher matcher = accessTokenPattern.matcher(s);
        if (matcher.find())
        {
            return new Token(matcher.group(1), "", s);
        } else
        {
            throw new OAuthException((new StringBuilder("Cannot extract an acces token. Response was: ")).append(s).toString());
        }
    }
}
