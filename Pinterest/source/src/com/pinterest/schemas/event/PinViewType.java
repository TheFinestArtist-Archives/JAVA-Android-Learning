// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class PinViewType extends Enum
    implements TEnum
{

    private static final PinViewType $VALUES[];
    public static final PinViewType AGGREGATED_INTEREST_FEED;
    public static final PinViewType BOARD;
    public static final PinViewType CLOSEUP;
    public static final PinViewType DOMAIN;
    public static final PinViewType FEED;
    public static final PinViewType FOLLOWING_FEED;
    public static final PinViewType FRIEND_FEED;
    public static final PinViewType HOME_FEED;
    public static final PinViewType INTERESTS_FEED;
    public static final PinViewType RECOMMENDATION_FEED;
    public static final PinViewType RELATED_PINS;
    public static final PinViewType SEARCH;
    private final int value;

    private PinViewType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static PinViewType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return HOME_FEED;

        case 2: // '\002'
            return FEED;

        case 3: // '\003'
            return CLOSEUP;

        case 4: // '\004'
            return DOMAIN;

        case 5: // '\005'
            return SEARCH;

        case 6: // '\006'
            return BOARD;

        case 7: // '\007'
            return FRIEND_FEED;

        case 8: // '\b'
            return RELATED_PINS;

        case 9: // '\t'
            return RECOMMENDATION_FEED;

        case 10: // '\n'
            return FOLLOWING_FEED;

        case 11: // '\013'
            return INTERESTS_FEED;

        case 12: // '\f'
            return AGGREGATED_INTEREST_FEED;
        }
    }

    public static PinViewType valueOf(String s)
    {
        return (PinViewType)Enum.valueOf(com/pinterest/schemas/event/PinViewType, s);
    }

    public static PinViewType[] values()
    {
        return (PinViewType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        HOME_FEED = new PinViewType("HOME_FEED", 0, 1);
        FEED = new PinViewType("FEED", 1, 2);
        CLOSEUP = new PinViewType("CLOSEUP", 2, 3);
        DOMAIN = new PinViewType("DOMAIN", 3, 4);
        SEARCH = new PinViewType("SEARCH", 4, 5);
        BOARD = new PinViewType("BOARD", 5, 6);
        FRIEND_FEED = new PinViewType("FRIEND_FEED", 6, 7);
        RELATED_PINS = new PinViewType("RELATED_PINS", 7, 8);
        RECOMMENDATION_FEED = new PinViewType("RECOMMENDATION_FEED", 8, 9);
        FOLLOWING_FEED = new PinViewType("FOLLOWING_FEED", 9, 10);
        INTERESTS_FEED = new PinViewType("INTERESTS_FEED", 10, 11);
        AGGREGATED_INTEREST_FEED = new PinViewType("AGGREGATED_INTEREST_FEED", 11, 12);
        $VALUES = (new PinViewType[] {
            HOME_FEED, FEED, CLOSEUP, DOMAIN, SEARCH, BOARD, FRIEND_FEED, RELATED_PINS, RECOMMENDATION_FEED, FOLLOWING_FEED, 
            INTERESTS_FEED, AGGREGATED_INTEREST_FEED
        });
    }
}
