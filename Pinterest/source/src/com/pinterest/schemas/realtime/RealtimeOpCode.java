// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.realtime;

import org.apache.thrift.TEnum;

public final class RealtimeOpCode extends Enum
    implements TEnum
{

    private static final RealtimeOpCode $VALUES[];
    public static final RealtimeOpCode MESSAGES_MESSAGE_ADDED;
    private final int value;

    private RealtimeOpCode(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static RealtimeOpCode findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return MESSAGES_MESSAGE_ADDED;
        }
    }

    public static RealtimeOpCode valueOf(String s)
    {
        return (RealtimeOpCode)Enum.valueOf(com/pinterest/schemas/realtime/RealtimeOpCode, s);
    }

    public static RealtimeOpCode[] values()
    {
        return (RealtimeOpCode[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        MESSAGES_MESSAGE_ADDED = new RealtimeOpCode("MESSAGES_MESSAGE_ADDED", 0, 1);
        $VALUES = (new RealtimeOpCode[] {
            MESSAGES_MESSAGE_ADDED
        });
    }
}
