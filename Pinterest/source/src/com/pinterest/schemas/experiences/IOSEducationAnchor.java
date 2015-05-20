// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class IOSEducationAnchor extends Enum
    implements TEnum
{

    private static final IOSEducationAnchor $VALUES[];
    public static final IOSEducationAnchor BOARD_FOLLOW_BUTTON;
    public static final IOSEducationAnchor CREATE_BOARD_CELL;
    public static final IOSEducationAnchor MESSAGE_ADD_BUTTON;
    public static final IOSEducationAnchor NOTIFICATIONS_MESSAGES_TAB;
    public static final IOSEducationAnchor PIN_IMAGE_VIEW;
    public static final IOSEducationAnchor PIN_IT_BUTTON;
    public static final IOSEducationAnchor SEARCH_BAR;
    public static final IOSEducationAnchor SEARCH_TAB;
    public static final IOSEducationAnchor SEND_PIN_BUTTON;
    private final int value;

    private IOSEducationAnchor(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static IOSEducationAnchor findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return SEARCH_TAB;

        case 2: // '\002'
            return CREATE_BOARD_CELL;

        case 3: // '\003'
            return NOTIFICATIONS_MESSAGES_TAB;

        case 4: // '\004'
            return MESSAGE_ADD_BUTTON;

        case 5: // '\005'
            return PIN_IT_BUTTON;

        case 6: // '\006'
            return BOARD_FOLLOW_BUTTON;

        case 7: // '\007'
            return PIN_IMAGE_VIEW;

        case 8: // '\b'
            return SEARCH_BAR;

        case 9: // '\t'
            return SEND_PIN_BUTTON;
        }
    }

    public static IOSEducationAnchor valueOf(String s)
    {
        return (IOSEducationAnchor)Enum.valueOf(com/pinterest/schemas/experiences/IOSEducationAnchor, s);
    }

    public static IOSEducationAnchor[] values()
    {
        return (IOSEducationAnchor[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        SEARCH_TAB = new IOSEducationAnchor("SEARCH_TAB", 0, 1);
        CREATE_BOARD_CELL = new IOSEducationAnchor("CREATE_BOARD_CELL", 1, 2);
        NOTIFICATIONS_MESSAGES_TAB = new IOSEducationAnchor("NOTIFICATIONS_MESSAGES_TAB", 2, 3);
        MESSAGE_ADD_BUTTON = new IOSEducationAnchor("MESSAGE_ADD_BUTTON", 3, 4);
        PIN_IT_BUTTON = new IOSEducationAnchor("PIN_IT_BUTTON", 4, 5);
        BOARD_FOLLOW_BUTTON = new IOSEducationAnchor("BOARD_FOLLOW_BUTTON", 5, 6);
        PIN_IMAGE_VIEW = new IOSEducationAnchor("PIN_IMAGE_VIEW", 6, 7);
        SEARCH_BAR = new IOSEducationAnchor("SEARCH_BAR", 7, 8);
        SEND_PIN_BUTTON = new IOSEducationAnchor("SEND_PIN_BUTTON", 8, 9);
        $VALUES = (new IOSEducationAnchor[] {
            SEARCH_TAB, CREATE_BOARD_CELL, NOTIFICATIONS_MESSAGES_TAB, MESSAGE_ADD_BUTTON, PIN_IT_BUTTON, BOARD_FOLLOW_BUTTON, PIN_IMAGE_VIEW, SEARCH_BAR, SEND_PIN_BUTTON
        });
    }
}
