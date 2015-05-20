// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.exceptions;


public class OAuthException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    public OAuthException(String s)
    {
        super(s, null);
    }

    public OAuthException(String s, Exception exception)
    {
        super(s, exception);
    }
}
