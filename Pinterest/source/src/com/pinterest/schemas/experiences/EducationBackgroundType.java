// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationBackgroundType extends Enum
    implements TEnum
{

    private static final EducationBackgroundType $VALUES[];
    public static final EducationBackgroundType IMAGE;
    public static final EducationBackgroundType REAL_UI;
    private final int value;

    private EducationBackgroundType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationBackgroundType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return IMAGE;

        case 2: // '\002'
            return REAL_UI;
        }
    }

    public static EducationBackgroundType valueOf(String s)
    {
        return (EducationBackgroundType)Enum.valueOf(com/pinterest/schemas/experiences/EducationBackgroundType, s);
    }

    public static EducationBackgroundType[] values()
    {
        return (EducationBackgroundType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        IMAGE = new EducationBackgroundType("IMAGE", 0, 1);
        REAL_UI = new EducationBackgroundType("REAL_UI", 1, 2);
        $VALUES = (new EducationBackgroundType[] {
            IMAGE, REAL_UI
        });
    }
}
