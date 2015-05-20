// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationTouchTarget extends Enum
    implements TEnum
{

    private static final EducationTouchTarget $VALUES[];
    public static final EducationTouchTarget PULSE;
    public static final EducationTouchTarget TARGET_VIEW;
    private final int value;

    private EducationTouchTarget(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationTouchTarget findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return TARGET_VIEW;

        case 2: // '\002'
            return PULSE;
        }
    }

    public static EducationTouchTarget valueOf(String s)
    {
        return (EducationTouchTarget)Enum.valueOf(com/pinterest/schemas/experiences/EducationTouchTarget, s);
    }

    public static EducationTouchTarget[] values()
    {
        return (EducationTouchTarget[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        TARGET_VIEW = new EducationTouchTarget("TARGET_VIEW", 0, 1);
        PULSE = new EducationTouchTarget("PULSE", 1, 2);
        $VALUES = (new EducationTouchTarget[] {
            TARGET_VIEW, PULSE
        });
    }
}
