// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;


public class IllegalMixedTypeException extends RuntimeException
{

    public IllegalMixedTypeException()
    {
    }

    public IllegalMixedTypeException(String s)
    {
        super(s);
    }

    public IllegalMixedTypeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public IllegalMixedTypeException(Throwable throwable)
    {
        super(throwable);
    }
}
