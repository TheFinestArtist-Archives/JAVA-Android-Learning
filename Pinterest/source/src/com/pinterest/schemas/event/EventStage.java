// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class EventStage extends Enum
    implements TEnum
{

    private static final EventStage $VALUES[];
    public static final EventStage A;
    public static final EventStage B;
    public static final EventStage C;
    private final int value;

    private EventStage(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static EventStage findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return A;

        case 1: // '\001'
            return B;

        case 2: // '\002'
            return C;
        }
    }

    public static EventStage valueOf(String s)
    {
        return (EventStage)Enum.valueOf(com/pinterest/schemas/event/EventStage, s);
    }

    public static EventStage[] values()
    {
        return (EventStage[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        A = new EventStage("A", 0, 0);
        B = new EventStage("B", 1, 1);
        C = new EventStage("C", 2, 2);
        $VALUES = (new EventStage[] {
            A, B, C
        });
    }
}
