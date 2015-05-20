// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.builder.api:
//            ConstantContactApi2

class this._cls0
    implements AccessTokenExtractor
{

    final ConstantContactApi2 this$0;

    public Token extract(String s)
    {
        Preconditions.checkEmptyString(s, "Response body is incorrect. Can't extract a token from an empty string");
        Matcher matcher = Pattern.compile("\"access_token\"\\s*:\\s*\"([^&\"]+)\"").matcher(s);
        if (matcher.find())
        {
            return new Token(OAuthEncoder.decode(matcher.group(1)), "", s);
        } else
        {
            throw new OAuthException((new StringBuilder("Response body is incorrect. Can't extract a token from this: '")).append(s).append("'").toString(), null);
        }
    }

    ()
    {
        this$0 = ConstantContactApi2.this;
        super();
    }
}
