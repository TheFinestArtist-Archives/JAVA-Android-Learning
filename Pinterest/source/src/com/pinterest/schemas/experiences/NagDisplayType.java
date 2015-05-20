// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class NagDisplayType extends Enum
    implements TEnum
{

    private static final NagDisplayType $VALUES[];
    public static final NagDisplayType BANNER;
    public static final NagDisplayType STANDARD;
    private final int value;

    private NagDisplayType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static NagDisplayType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return STANDARD;

        case 2: // '\002'
            return BANNER;
        }
    }

    public static NagDisplayType valueOf(String s)
    {
        return (NagDisplayType)Enum.valueOf(com/pinterest/schemas/experiences/NagDisplayType, s);
    }

    public static NagDisplayType[] values()
    {
        return (NagDisplayType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        STANDARD = new NagDisplayType("STANDARD", 0, 1);
        BANNER = new NagDisplayType("BANNER", 1, 2);
        $VALUES = (new NagDisplayType[] {
            STANDARD, BANNER
        });
    }
}
