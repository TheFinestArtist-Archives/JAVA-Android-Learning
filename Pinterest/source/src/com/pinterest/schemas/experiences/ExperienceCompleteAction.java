// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class ExperienceCompleteAction extends Enum
    implements TEnum
{

    private static final ExperienceCompleteAction $VALUES[];
    public static final ExperienceCompleteAction COMPLETE;
    public static final ExperienceCompleteAction COMPLETE_AND_SHOW;
    public static final ExperienceCompleteAction DONT_COMPLETE_AND_HIDE;
    public static final ExperienceCompleteAction DONT_COMPLETE_AND_SHOW;
    private final int value;

    private ExperienceCompleteAction(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ExperienceCompleteAction findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return COMPLETE;

        case 2: // '\002'
            return COMPLETE_AND_SHOW;

        case 3: // '\003'
            return DONT_COMPLETE_AND_HIDE;

        case 4: // '\004'
            return DONT_COMPLETE_AND_SHOW;
        }
    }

    public static ExperienceCompleteAction valueOf(String s)
    {
        return (ExperienceCompleteAction)Enum.valueOf(com/pinterest/schemas/experiences/ExperienceCompleteAction, s);
    }

    public static ExperienceCompleteAction[] values()
    {
        return (ExperienceCompleteAction[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        COMPLETE = new ExperienceCompleteAction("COMPLETE", 0, 1);
        COMPLETE_AND_SHOW = new ExperienceCompleteAction("COMPLETE_AND_SHOW", 1, 2);
        DONT_COMPLETE_AND_HIDE = new ExperienceCompleteAction("DONT_COMPLETE_AND_HIDE", 2, 3);
        DONT_COMPLETE_AND_SHOW = new ExperienceCompleteAction("DONT_COMPLETE_AND_SHOW", 3, 4);
        $VALUES = (new ExperienceCompleteAction[] {
            COMPLETE, COMPLETE_AND_SHOW, DONT_COMPLETE_AND_HIDE, DONT_COMPLETE_AND_SHOW
        });
    }
}
