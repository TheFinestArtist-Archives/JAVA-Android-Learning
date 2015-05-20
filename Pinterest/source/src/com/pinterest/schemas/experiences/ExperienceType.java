// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class ExperienceType extends Enum
    implements TEnum
{

    private static final ExperienceType $VALUES[];
    public static final ExperienceType DEFAULT;
    public static final ExperienceType EMAIL;
    public static final ExperienceType GUIDE;
    public static final ExperienceType NAG;
    public static final ExperienceType NETWORK_STORY;
    public static final ExperienceType NOOP;
    public static final ExperienceType NUX;
    public static final ExperienceType PUSH;
    public static final ExperienceType SURVEY;
    public static final ExperienceType TOOLTIP;
    private final int value;

    private ExperienceType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ExperienceType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return NOOP;

        case 1: // '\001'
            return DEFAULT;

        case 2: // '\002'
            return NAG;

        case 3: // '\003'
            return GUIDE;

        case 4: // '\004'
            return EMAIL;

        case 5: // '\005'
            return SURVEY;

        case 6: // '\006'
            return PUSH;

        case 7: // '\007'
            return NETWORK_STORY;

        case 8: // '\b'
            return TOOLTIP;

        case 9: // '\t'
            return NUX;
        }
    }

    public static ExperienceType valueOf(String s)
    {
        return (ExperienceType)Enum.valueOf(com/pinterest/schemas/experiences/ExperienceType, s);
    }

    public static ExperienceType[] values()
    {
        return (ExperienceType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NOOP = new ExperienceType("NOOP", 0, 0);
        DEFAULT = new ExperienceType("DEFAULT", 1, 1);
        NAG = new ExperienceType("NAG", 2, 2);
        GUIDE = new ExperienceType("GUIDE", 3, 3);
        EMAIL = new ExperienceType("EMAIL", 4, 4);
        SURVEY = new ExperienceType("SURVEY", 5, 5);
        PUSH = new ExperienceType("PUSH", 6, 6);
        NETWORK_STORY = new ExperienceType("NETWORK_STORY", 7, 7);
        TOOLTIP = new ExperienceType("TOOLTIP", 8, 8);
        NUX = new ExperienceType("NUX", 9, 9);
        $VALUES = (new ExperienceType[] {
            NOOP, DEFAULT, NAG, GUIDE, EMAIL, SURVEY, PUSH, NETWORK_STORY, TOOLTIP, NUX
        });
    }
}
