// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class EventAppState extends Enum
    implements TEnum
{

    private static final EventAppState $VALUES[];
    public static final EventAppState ACTIVE;
    public static final EventAppState BACKGROUND;
    public static final EventAppState INACTIVE;
    public static final EventAppState OTHER;
    private final int value;

    private EventAppState(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EventAppState findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return ACTIVE;

        case 1: // '\001'
            return BACKGROUND;

        case 2: // '\002'
            return INACTIVE;

        case 100: // 'd'
            return OTHER;
        }
    }

    public static EventAppState valueOf(String s)
    {
        return (EventAppState)Enum.valueOf(com/pinterest/schemas/event/EventAppState, s);
    }

    public static EventAppState[] values()
    {
        return (EventAppState[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        ACTIVE = new EventAppState("ACTIVE", 0, 0);
        BACKGROUND = new EventAppState("BACKGROUND", 1, 1);
        INACTIVE = new EventAppState("INACTIVE", 2, 2);
        OTHER = new EventAppState("OTHER", 3, 100);
        $VALUES = (new EventAppState[] {
            ACTIVE, BACKGROUND, INACTIVE, OTHER
        });
    }
}
