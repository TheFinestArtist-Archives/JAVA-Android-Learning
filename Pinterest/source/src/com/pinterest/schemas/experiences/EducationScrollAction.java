// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationScrollAction extends Enum
    implements TEnum
{

    private static final EducationScrollAction $VALUES[];
    public static final EducationScrollAction DISABLE_SCROLL;
    public static final EducationScrollAction SUSPEND_EDUCATION;
    private final int value;

    private EducationScrollAction(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationScrollAction findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return DISABLE_SCROLL;

        case 2: // '\002'
            return SUSPEND_EDUCATION;
        }
    }

    public static EducationScrollAction valueOf(String s)
    {
        return (EducationScrollAction)Enum.valueOf(com/pinterest/schemas/experiences/EducationScrollAction, s);
    }

    public static EducationScrollAction[] values()
    {
        return (EducationScrollAction[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        DISABLE_SCROLL = new EducationScrollAction("DISABLE_SCROLL", 0, 1);
        SUSPEND_EDUCATION = new EducationScrollAction("SUSPEND_EDUCATION", 1, 2);
        $VALUES = (new EducationScrollAction[] {
            DISABLE_SCROLL, SUSPEND_EDUCATION
        });
    }
}
