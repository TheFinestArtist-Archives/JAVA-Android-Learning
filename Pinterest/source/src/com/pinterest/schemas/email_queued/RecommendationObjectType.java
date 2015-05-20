// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import org.apache.thrift.TEnum;

public final class RecommendationObjectType extends Enum
    implements TEnum
{

    private static final RecommendationObjectType $VALUES[];
    public static final RecommendationObjectType BOARD;
    public static final RecommendationObjectType PIN;
    public static final RecommendationObjectType USER;
    private final int value;

    private RecommendationObjectType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static RecommendationObjectType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return BOARD;

        case 1: // '\001'
            return PIN;

        case 2: // '\002'
            return USER;
        }
    }

    public static RecommendationObjectType valueOf(String s)
    {
        return (RecommendationObjectType)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationObjectType, s);
    }

    public static RecommendationObjectType[] values()
    {
        return (RecommendationObjectType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        BOARD = new RecommendationObjectType("BOARD", 0, 0);
        PIN = new RecommendationObjectType("PIN", 1, 1);
        USER = new RecommendationObjectType("USER", 2, 2);
        $VALUES = (new RecommendationObjectType[] {
            BOARD, PIN, USER
        });
    }
}
