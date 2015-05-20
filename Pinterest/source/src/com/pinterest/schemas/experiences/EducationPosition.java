// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationPosition extends Enum
    implements TEnum
{

    private static final EducationPosition $VALUES[];
    public static final EducationPosition BOTTOM;
    public static final EducationPosition BOTTOM_ABOVE_NAVIGATION;
    public static final EducationPosition TOP;
    private final int value;

    private EducationPosition(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationPosition findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return BOTTOM;

        case 2: // '\002'
            return BOTTOM_ABOVE_NAVIGATION;

        case 3: // '\003'
            return TOP;
        }
    }

    public static EducationPosition valueOf(String s)
    {
        return (EducationPosition)Enum.valueOf(com/pinterest/schemas/experiences/EducationPosition, s);
    }

    public static EducationPosition[] values()
    {
        return (EducationPosition[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        BOTTOM = new EducationPosition("BOTTOM", 0, 1);
        BOTTOM_ABOVE_NAVIGATION = new EducationPosition("BOTTOM_ABOVE_NAVIGATION", 1, 2);
        TOP = new EducationPosition("TOP", 2, 3);
        $VALUES = (new EducationPosition[] {
            BOTTOM, BOTTOM_ABOVE_NAVIGATION, TOP
        });
    }
}
