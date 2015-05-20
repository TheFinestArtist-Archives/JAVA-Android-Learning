// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class ToastType extends Enum
    implements TEnum
{

    private static final ToastType $VALUES[];
    public static final ToastType BOARD_FOLLOW;
    public static final ToastType BOARD_FOLLOW_SUGGESTED;
    public static final ToastType INVITE_FRIENDS;
    public static final ToastType LIKE;
    public static final ToastType LIKE_SUGGESTED;
    public static final ToastType LOOKBOOK_RECOMMENDATION;
    public static final ToastType NOTIFICATION;
    public static final ToastType REPIN;
    public static final ToastType REPIN_SUGGESTED;
    public static final ToastType SEND;
    public static final ToastType SEND_PIN_SUGGESTION;
    public static final ToastType SHARE_EXTENSION_EDUCATION;
    private final int value;

    private ToastType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static ToastType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return REPIN;

        case 1: // '\001'
            return LIKE;

        case 2: // '\002'
            return SEND;

        case 3: // '\003'
            return BOARD_FOLLOW;

        case 4: // '\004'
            return NOTIFICATION;

        case 5: // '\005'
            return REPIN_SUGGESTED;

        case 6: // '\006'
            return LIKE_SUGGESTED;

        case 7: // '\007'
            return BOARD_FOLLOW_SUGGESTED;

        case 8: // '\b'
            return SEND_PIN_SUGGESTION;

        case 9: // '\t'
            return INVITE_FRIENDS;

        case 10: // '\n'
            return LOOKBOOK_RECOMMENDATION;

        case 11: // '\013'
            return SHARE_EXTENSION_EDUCATION;
        }
    }

    public static ToastType valueOf(String s)
    {
        return (ToastType)Enum.valueOf(com/pinterest/schemas/event/ToastType, s);
    }

    public static ToastType[] values()
    {
        return (ToastType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        REPIN = new ToastType("REPIN", 0, 0);
        LIKE = new ToastType("LIKE", 1, 1);
        SEND = new ToastType("SEND", 2, 2);
        BOARD_FOLLOW = new ToastType("BOARD_FOLLOW", 3, 3);
        NOTIFICATION = new ToastType("NOTIFICATION", 4, 4);
        REPIN_SUGGESTED = new ToastType("REPIN_SUGGESTED", 5, 5);
        LIKE_SUGGESTED = new ToastType("LIKE_SUGGESTED", 6, 6);
        BOARD_FOLLOW_SUGGESTED = new ToastType("BOARD_FOLLOW_SUGGESTED", 7, 7);
        SEND_PIN_SUGGESTION = new ToastType("SEND_PIN_SUGGESTION", 8, 8);
        INVITE_FRIENDS = new ToastType("INVITE_FRIENDS", 9, 9);
        LOOKBOOK_RECOMMENDATION = new ToastType("LOOKBOOK_RECOMMENDATION", 10, 10);
        SHARE_EXTENSION_EDUCATION = new ToastType("SHARE_EXTENSION_EDUCATION", 11, 11);
        $VALUES = (new ToastType[] {
            REPIN, LIKE, SEND, BOARD_FOLLOW, NOTIFICATION, REPIN_SUGGESTED, LIKE_SUGGESTED, BOARD_FOLLOW_SUGGESTED, SEND_PIN_SUGGESTION, INVITE_FRIENDS, 
            LOOKBOOK_RECOMMENDATION, SHARE_EXTENSION_EDUCATION
        });
    }
}
