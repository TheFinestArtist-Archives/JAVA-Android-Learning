// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;


public final class retries_ extends Enum
{

    private static final WAIT_FOREVER $VALUES[];
    public static final WAIT_FOREVER NOWAIT;
    public static final WAIT_FOREVER WAIT_FOREVER;
    public final int retries_;
    public final int timeout_;

    public static retries_ valueOf(String s)
    {
        return (retries_)Enum.valueOf(org/apache/thrift/transport/TFileTransport$tailPolicy, s);
    }

    public static retries_[] values()
    {
        return (retries_[])$VALUES.clone();
    }

    static 
    {
        NOWAIT = new <init>("NOWAIT", 0, 0, 0);
        WAIT_FOREVER = new <init>("WAIT_FOREVER", 1, 500, -1);
        $VALUES = (new .VALUES[] {
            NOWAIT, WAIT_FOREVER
        });
    }

    private (String s, int i, int j, int k)
    {
        super(s, i);
        timeout_ = j;
        retries_ = k;
    }
}
