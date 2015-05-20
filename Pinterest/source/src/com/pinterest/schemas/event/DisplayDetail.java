// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class DisplayDetail extends Enum
    implements TEnum
{

    private static final DisplayDetail $VALUES[];
    public static final DisplayDetail FULL_SCREEN;
    public static final DisplayDetail GRID_TILE;
    public static final DisplayDetail NOT_SHOWN;
    public static final DisplayDetail THUMBNAIL;
    private final int value;

    private DisplayDetail(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static DisplayDetail findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return NOT_SHOWN;

        case 1: // '\001'
            return FULL_SCREEN;

        case 2: // '\002'
            return GRID_TILE;

        case 3: // '\003'
            return THUMBNAIL;
        }
    }

    public static DisplayDetail valueOf(String s)
    {
        return (DisplayDetail)Enum.valueOf(com/pinterest/schemas/event/DisplayDetail, s);
    }

    public static DisplayDetail[] values()
    {
        return (DisplayDetail[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NOT_SHOWN = new DisplayDetail("NOT_SHOWN", 0, 0);
        FULL_SCREEN = new DisplayDetail("FULL_SCREEN", 1, 1);
        GRID_TILE = new DisplayDetail("GRID_TILE", 2, 2);
        THUMBNAIL = new DisplayDetail("THUMBNAIL", 3, 3);
        $VALUES = (new DisplayDetail[] {
            NOT_SHOWN, FULL_SCREEN, GRID_TILE, THUMBNAIL
        });
    }
}
