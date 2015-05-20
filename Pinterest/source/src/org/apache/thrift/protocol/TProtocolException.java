// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;

public class TProtocolException extends TException
{

    public static final int BAD_VERSION = 4;
    public static final int INVALID_DATA = 1;
    public static final int NEGATIVE_SIZE = 2;
    public static final int NOT_IMPLEMENTED = 5;
    public static final int SIZE_LIMIT = 3;
    public static final int UNKNOWN = 0;
    private static final long serialVersionUID = 1L;
    protected int type_;

    public TProtocolException()
    {
        type_ = 0;
    }

    public TProtocolException(int i)
    {
        type_ = 0;
        type_ = i;
    }

    public TProtocolException(int i, String s)
    {
        super(s);
        type_ = 0;
        type_ = i;
    }

    public TProtocolException(int i, String s, Throwable throwable)
    {
        super(s, throwable);
        type_ = 0;
        type_ = i;
    }

    public TProtocolException(int i, Throwable throwable)
    {
        super(throwable);
        type_ = 0;
        type_ = i;
    }

    public TProtocolException(String s)
    {
        super(s);
        type_ = 0;
    }

    public TProtocolException(String s, Throwable throwable)
    {
        super(s, throwable);
        type_ = 0;
    }

    public TProtocolException(Throwable throwable)
    {
        super(throwable);
        type_ = 0;
    }

    public int getType()
    {
        return type_;
    }
}
