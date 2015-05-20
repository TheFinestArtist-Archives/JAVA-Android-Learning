// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import org.apache.thrift.TException;

public class TTransportException extends TException
{

    public static final int ALREADY_OPEN = 2;
    public static final int END_OF_FILE = 4;
    public static final int NOT_OPEN = 1;
    public static final int TIMED_OUT = 3;
    public static final int UNKNOWN = 0;
    private static final long serialVersionUID = 1L;
    protected int type_;

    public TTransportException()
    {
        type_ = 0;
    }

    public TTransportException(int i)
    {
        type_ = 0;
        type_ = i;
    }

    public TTransportException(int i, String s)
    {
        super(s);
        type_ = 0;
        type_ = i;
    }

    public TTransportException(int i, String s, Throwable throwable)
    {
        super(s, throwable);
        type_ = 0;
        type_ = i;
    }

    public TTransportException(int i, Throwable throwable)
    {
        super(throwable);
        type_ = 0;
        type_ = i;
    }

    public TTransportException(String s)
    {
        super(s);
        type_ = 0;
    }

    public TTransportException(String s, Throwable throwable)
    {
        super(s, throwable);
        type_ = 0;
    }

    public TTransportException(Throwable throwable)
    {
        super(throwable);
        type_ = 0;
    }

    public int getType()
    {
        return type_;
    }
}
