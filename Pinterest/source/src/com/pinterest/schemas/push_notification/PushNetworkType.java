// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.push_notification;

import org.apache.thrift.TEnum;

public final class PushNetworkType extends Enum
    implements TEnum
{

    private static final PushNetworkType $VALUES[];
    public static final PushNetworkType APNS;
    public static final PushNetworkType GCM;
    private final int value;

    private PushNetworkType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static PushNetworkType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return APNS;

        case 2: // '\002'
            return GCM;
        }
    }

    public static PushNetworkType valueOf(String s)
    {
        return (PushNetworkType)Enum.valueOf(com/pinterest/schemas/push_notification/PushNetworkType, s);
    }

    public static PushNetworkType[] values()
    {
        return (PushNetworkType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        APNS = new PushNetworkType("APNS", 0, 1);
        GCM = new PushNetworkType("GCM", 1, 2);
        $VALUES = (new PushNetworkType[] {
            APNS, GCM
        });
    }
}
