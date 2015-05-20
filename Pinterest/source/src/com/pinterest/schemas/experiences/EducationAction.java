// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class EducationAction extends Enum
    implements TEnum
{

    private static final EducationAction $VALUES[];
    public static final EducationAction SWIPE_DOWN;
    public static final EducationAction SWIPE_LEFT;
    public static final EducationAction SWIPE_RIGHT;
    public static final EducationAction SWIPE_UP;
    public static final EducationAction TAP;
    private final int value;

    private EducationAction(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EducationAction findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return TAP;

        case 2: // '\002'
            return SWIPE_UP;

        case 3: // '\003'
            return SWIPE_DOWN;

        case 4: // '\004'
            return SWIPE_LEFT;

        case 5: // '\005'
            return SWIPE_RIGHT;
        }
    }

    public static EducationAction valueOf(String s)
    {
        return (EducationAction)Enum.valueOf(com/pinterest/schemas/experiences/EducationAction, s);
    }

    public static EducationAction[] values()
    {
        return (EducationAction[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        TAP = new EducationAction("TAP", 0, 1);
        SWIPE_UP = new EducationAction("SWIPE_UP", 1, 2);
        SWIPE_DOWN = new EducationAction("SWIPE_DOWN", 2, 3);
        SWIPE_LEFT = new EducationAction("SWIPE_LEFT", 3, 4);
        SWIPE_RIGHT = new EducationAction("SWIPE_RIGHT", 4, 5);
        $VALUES = (new EducationAction[] {
            TAP, SWIPE_UP, SWIPE_DOWN, SWIPE_LEFT, SWIPE_RIGHT
        });
    }
}
