// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;


public class TException extends Exception
{

    private static final long serialVersionUID = 1L;

    public TException()
    {
    }

    public TException(String s)
    {
        super(s);
    }

    public TException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public TException(Throwable throwable)
    {
        super(throwable);
    }
}
