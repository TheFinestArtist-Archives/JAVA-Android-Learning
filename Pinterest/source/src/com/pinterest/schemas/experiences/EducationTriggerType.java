// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationTriggerType extends Enum
    implements TEnum
{

    private static final EducationTriggerType $VALUES[];
    public static final EducationTriggerType AUTOMATIC;
    public static final EducationTriggerType FLYOUT;
    public static final EducationTriggerType MANUAL;
    private final int value;

    private EducationTriggerType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationTriggerType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return AUTOMATIC;

        case 2: // '\002'
            return MANUAL;

        case 3: // '\003'
            return FLYOUT;
        }
    }

    public static EducationTriggerType valueOf(String s)
    {
        return (EducationTriggerType)Enum.valueOf(com/pinterest/schemas/experiences/EducationTriggerType, s);
    }

    public static EducationTriggerType[] values()
    {
        return (EducationTriggerType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        AUTOMATIC = new EducationTriggerType("AUTOMATIC", 0, 1);
        MANUAL = new EducationTriggerType("MANUAL", 1, 2);
        FLYOUT = new EducationTriggerType("FLYOUT", 2, 3);
        $VALUES = (new EducationTriggerType[] {
            AUTOMATIC, MANUAL, FLYOUT
        });
    }
}
