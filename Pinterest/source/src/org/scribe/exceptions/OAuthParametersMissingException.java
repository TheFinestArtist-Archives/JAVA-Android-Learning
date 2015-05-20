// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.exceptions;

import org.scribe.model.OAuthRequest;

// Referenced classes of package org.scribe.exceptions:
//            OAuthException

public class OAuthParametersMissingException extends OAuthException
{

    private static final String MSG = "Could not find oauth parameters in request: %s. OAuth parameters must be specified with the addOAuthParameter() method";
    private static final long serialVersionUID = 0x18389511fdda10dfL;

    public OAuthParametersMissingException(OAuthRequest oauthrequest)
    {
        super(String.format("Could not find oauth parameters in request: %s. OAuth parameters must be specified with the addOAuthParameter() method", new Object[] {
            oauthrequest
        }));
    }
}
