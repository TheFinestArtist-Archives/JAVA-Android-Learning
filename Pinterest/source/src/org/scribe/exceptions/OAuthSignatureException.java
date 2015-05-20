// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.exceptions;


// Referenced classes of package org.scribe.exceptions:
//            OAuthException

public class OAuthSignatureException extends OAuthException
{

    private static final String MSG = "Error while signing string: %s";
    private static final long serialVersionUID = 1L;

    public OAuthSignatureException(String s, Exception exception)
    {
        super(String.format("Error while signing string: %s", new Object[] {
            s
        }), exception);
    }
}
