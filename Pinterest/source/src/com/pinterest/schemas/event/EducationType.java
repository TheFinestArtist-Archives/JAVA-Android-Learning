// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class EducationType extends Enum
    implements TEnum
{

    private static final EducationType $VALUES[];
    public static final EducationType EDIT_BOARD_MAP;
    public static final EducationType PLACE_BOARD_ADD_PIN;
    private final int value;

    private EducationType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return PLACE_BOARD_ADD_PIN;

        case 1: // '\001'
            return EDIT_BOARD_MAP;
        }
    }

    public static EducationType valueOf(String s)
    {
        return (EducationType)Enum.valueOf(com/pinterest/schemas/event/EducationType, s);
    }

    public static EducationType[] values()
    {
        return (EducationType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        PLACE_BOARD_ADD_PIN = new EducationType("PLACE_BOARD_ADD_PIN", 0, 0);
        EDIT_BOARD_MAP = new EducationType("EDIT_BOARD_MAP", 1, 1);
        $VALUES = (new EducationType[] {
            PLACE_BOARD_ADD_PIN, EDIT_BOARD_MAP
        });
    }
}
