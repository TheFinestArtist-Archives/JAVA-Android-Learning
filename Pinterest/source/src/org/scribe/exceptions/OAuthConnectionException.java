// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.exceptions;


// Referenced classes of package org.scribe.exceptions:
//            OAuthException

public class OAuthConnectionException extends OAuthException
{

    private static final String MSG = "There was a problem while creating a connection to the remote service.";

    public OAuthConnectionException(Exception exception)
    {
        super("There was a problem while creating a connection to the remote service.", exception);
    }
}
