// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class PinImpressionType extends Enum
    implements TEnum
{

    private static final PinImpressionType $VALUES[];
    public static final PinImpressionType CLOSEUP;
    public static final PinImpressionType GRID_CELL;
    private final int value;

    private PinImpressionType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static PinImpressionType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return GRID_CELL;

        case 1: // '\001'
            return CLOSEUP;
        }
    }

    public static PinImpressionType valueOf(String s)
    {
        return (PinImpressionType)Enum.valueOf(com/pinterest/schemas/event/PinImpressionType, s);
    }

    public static PinImpressionType[] values()
    {
        return (PinImpressionType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        GRID_CELL = new PinImpressionType("GRID_CELL", 0, 0);
        CLOSEUP = new PinImpressionType("CLOSEUP", 1, 1);
        $VALUES = (new PinImpressionType[] {
            GRID_CELL, CLOSEUP
        });
    }
}
