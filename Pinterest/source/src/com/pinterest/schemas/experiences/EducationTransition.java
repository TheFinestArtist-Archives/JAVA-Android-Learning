// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationTransition extends Enum
    implements TEnum
{

    private static final EducationTransition $VALUES[];
    public static final EducationTransition CAROUSEL;
    public static final EducationTransition CAROUSEL_SCALE_FORWARD;
    public static final EducationTransition NONE;
    public static final EducationTransition SCALE_BACK;
    public static final EducationTransition SCALE_FORWARD;
    private final int value;

    private EducationTransition(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationTransition findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return CAROUSEL_SCALE_FORWARD;

        case 2: // '\002'
            return CAROUSEL;

        case 3: // '\003'
            return SCALE_FORWARD;

        case 4: // '\004'
            return SCALE_BACK;

        case 5: // '\005'
            return NONE;
        }
    }

    public static EducationTransition valueOf(String s)
    {
        return (EducationTransition)Enum.valueOf(com/pinterest/schemas/experiences/EducationTransition, s);
    }

    public static EducationTransition[] values()
    {
        return (EducationTransition[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        CAROUSEL_SCALE_FORWARD = new EducationTransition("CAROUSEL_SCALE_FORWARD", 0, 1);
        CAROUSEL = new EducationTransition("CAROUSEL", 1, 2);
        SCALE_FORWARD = new EducationTransition("SCALE_FORWARD", 2, 3);
        SCALE_BACK = new EducationTransition("SCALE_BACK", 3, 4);
        NONE = new EducationTransition("NONE", 4, 5);
        $VALUES = (new EducationTransition[] {
            CAROUSEL_SCALE_FORWARD, CAROUSEL, SCALE_FORWARD, SCALE_BACK, NONE
        });
    }
}
