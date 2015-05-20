// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class AndroidEducationAnchor extends Enum
    implements TEnum
{

    private static final AndroidEducationAnchor $VALUES[];
    public static final AndroidEducationAnchor BOARD_FOLLOW_BUTTON;
    public static final AndroidEducationAnchor CREATE_BOARD_CELL;
    public static final AndroidEducationAnchor EXPLORE_TAB;
    public static final AndroidEducationAnchor NEWS_BUTTON;
    public static final AndroidEducationAnchor PIN_IMAGE_VIEW;
    public static final AndroidEducationAnchor PIN_IT_BUTTON;
    public static final AndroidEducationAnchor SCREEN_TOP_THIRD;
    private final int value;

    private AndroidEducationAnchor(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static AndroidEducationAnchor findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return EXPLORE_TAB;

        case 2: // '\002'
            return CREATE_BOARD_CELL;

        case 3: // '\003'
            return SCREEN_TOP_THIRD;

        case 4: // '\004'
            return PIN_IMAGE_VIEW;

        case 5: // '\005'
            return NEWS_BUTTON;

        case 6: // '\006'
            return PIN_IT_BUTTON;

        case 7: // '\007'
            return BOARD_FOLLOW_BUTTON;
        }
    }

    public static AndroidEducationAnchor valueOf(String s)
    {
        return (AndroidEducationAnchor)Enum.valueOf(com/pinterest/schemas/experiences/AndroidEducationAnchor, s);
    }

    public static AndroidEducationAnchor[] values()
    {
        return (AndroidEducationAnchor[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        EXPLORE_TAB = new AndroidEducationAnchor("EXPLORE_TAB", 0, 1);
        CREATE_BOARD_CELL = new AndroidEducationAnchor("CREATE_BOARD_CELL", 1, 2);
        SCREEN_TOP_THIRD = new AndroidEducationAnchor("SCREEN_TOP_THIRD", 2, 3);
        PIN_IMAGE_VIEW = new AndroidEducationAnchor("PIN_IMAGE_VIEW", 3, 4);
        NEWS_BUTTON = new AndroidEducationAnchor("NEWS_BUTTON", 4, 5);
        PIN_IT_BUTTON = new AndroidEducationAnchor("PIN_IT_BUTTON", 5, 6);
        BOARD_FOLLOW_BUTTON = new AndroidEducationAnchor("BOARD_FOLLOW_BUTTON", 6, 7);
        $VALUES = (new AndroidEducationAnchor[] {
            EXPLORE_TAB, CREATE_BOARD_CELL, SCREEN_TOP_THIRD, PIN_IMAGE_VIEW, NEWS_BUTTON, PIN_IT_BUTTON, BOARD_FOLLOW_BUTTON
        });
    }
}
