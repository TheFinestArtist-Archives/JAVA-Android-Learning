// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import org.apache.thrift.TEnum;

public final class RecommendationTriggerType extends Enum
    implements TEnum
{

    private static final RecommendationTriggerType $VALUES[];
    public static final RecommendationTriggerType BOARD_CREATE;
    public static final RecommendationTriggerType BOARD_FOLLOW;
    public static final RecommendationTriggerType DORMANT_BOARD;
    public static final RecommendationTriggerType FIRST_BOARD_CREATE;
    public static final RecommendationTriggerType FIRST_BOARD_FOLLOW;
    public static final RecommendationTriggerType PIN_ON_ANOTHER_BOARD;
    public static final RecommendationTriggerType RECOMMENDATIONS_DIGEST;
    private final int value;

    private RecommendationTriggerType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static RecommendationTriggerType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return RECOMMENDATIONS_DIGEST;

        case 10: // '\n'
            return BOARD_CREATE;

        case 11: // '\013'
            return BOARD_FOLLOW;

        case 12: // '\f'
            return FIRST_BOARD_CREATE;

        case 13: // '\r'
            return FIRST_BOARD_FOLLOW;

        case 14: // '\016'
            return DORMANT_BOARD;

        case 20: // '\024'
            return PIN_ON_ANOTHER_BOARD;
        }
    }

    public static RecommendationTriggerType valueOf(String s)
    {
        return (RecommendationTriggerType)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationTriggerType, s);
    }

    public static RecommendationTriggerType[] values()
    {
        return (RecommendationTriggerType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        RECOMMENDATIONS_DIGEST = new RecommendationTriggerType("RECOMMENDATIONS_DIGEST", 0, 1);
        BOARD_CREATE = new RecommendationTriggerType("BOARD_CREATE", 1, 10);
        BOARD_FOLLOW = new RecommendationTriggerType("BOARD_FOLLOW", 2, 11);
        FIRST_BOARD_CREATE = new RecommendationTriggerType("FIRST_BOARD_CREATE", 3, 12);
        FIRST_BOARD_FOLLOW = new RecommendationTriggerType("FIRST_BOARD_FOLLOW", 4, 13);
        DORMANT_BOARD = new RecommendationTriggerType("DORMANT_BOARD", 5, 14);
        PIN_ON_ANOTHER_BOARD = new RecommendationTriggerType("PIN_ON_ANOTHER_BOARD", 6, 20);
        $VALUES = (new RecommendationTriggerType[] {
            RECOMMENDATIONS_DIGEST, BOARD_CREATE, BOARD_FOLLOW, FIRST_BOARD_CREATE, FIRST_BOARD_FOLLOW, DORMANT_BOARD, PIN_ON_ANOTHER_BOARD
        });
    }
}
