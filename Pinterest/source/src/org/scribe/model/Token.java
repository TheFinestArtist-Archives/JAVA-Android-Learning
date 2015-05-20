// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.model;

import java.io.Serializable;
import org.scribe.utils.Preconditions;

public class Token
    implements Serializable
{

    private static final long serialVersionUID = 0x9ec317fdcf6730bL;
    private final String rawResponse;
    private final String secret;
    private final String token;

    public Token(String s, String s1)
    {
        this(s, s1, null);
    }

    public Token(String s, String s1, String s2)
    {
        Preconditions.checkNotNull(s, "Token can't be null");
        Preconditions.checkNotNull(s1, "Secret can't be null");
        token = s;
        secret = s1;
        rawResponse = s2;
    }

    public static Token empty()
    {
        return new Token("", "");
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Token)obj;
            if (!token.equals(((Token) (obj)).token) || !secret.equals(((Token) (obj)).secret))
            {
                return false;
            }
        }
        return true;
    }

    public String getRawResponse()
    {
        if (rawResponse == null)
        {
            throw new IllegalStateException("This token object was not constructed by scribe and does not have a rawResponse");
        } else
        {
            return rawResponse;
        }
    }

    public String getSecret()
    {
        return secret;
    }

    public String getToken()
    {
        return token;
    }

    public int hashCode()
    {
        return token.hashCode() * 31 + secret.hashCode();
    }

    public boolean isEmpty()
    {
        return "".equals(token) && "".equals(secret);
    }

    public String toString()
    {
        return String.format("Token[%s , %s]", new Object[] {
            token, secret
        });
    }
}
