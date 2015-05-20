// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class ClientDestination extends Enum
    implements TEnum
{

    private static final ClientDestination $VALUES[];
    public static final ClientDestination HOME_FEED;
    private final int value;

    private ClientDestination(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ClientDestination findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return HOME_FEED;
        }
    }

    public static ClientDestination valueOf(String s)
    {
        return (ClientDestination)Enum.valueOf(com/pinterest/schemas/experiences/ClientDestination, s);
    }

    public static ClientDestination[] values()
    {
        return (ClientDestination[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        HOME_FEED = new ClientDestination("HOME_FEED", 0, 1);
        $VALUES = (new ClientDestination[] {
            HOME_FEED
        });
    }
}
