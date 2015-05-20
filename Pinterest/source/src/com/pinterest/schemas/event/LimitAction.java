// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class LimitAction extends Enum
    implements TEnum
{

    private static final LimitAction $VALUES[];
    public static final LimitAction ALLOW;
    public static final LimitAction ALLOW_SILENT;
    public static final LimitAction BLOCK;
    public static final LimitAction CAPTCHA;
    public static final LimitAction REVIEW;
    public static final LimitAction SILENCE;
    public static final LimitAction WARN;
    private final int value;

    private LimitAction(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static LimitAction findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return ALLOW;

        case 1: // '\001'
            return ALLOW_SILENT;

        case 2: // '\002'
            return BLOCK;

        case 3: // '\003'
            return WARN;

        case 4: // '\004'
            return CAPTCHA;

        case 5: // '\005'
            return SILENCE;

        case 6: // '\006'
            return REVIEW;
        }
    }

    public static LimitAction valueOf(String s)
    {
        return (LimitAction)Enum.valueOf(com/pinterest/schemas/event/LimitAction, s);
    }

    public static LimitAction[] values()
    {
        return (LimitAction[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        ALLOW = new LimitAction("ALLOW", 0, 0);
        ALLOW_SILENT = new LimitAction("ALLOW_SILENT", 1, 1);
        BLOCK = new LimitAction("BLOCK", 2, 2);
        WARN = new LimitAction("WARN", 3, 3);
        CAPTCHA = new LimitAction("CAPTCHA", 4, 4);
        SILENCE = new LimitAction("SILENCE", 5, 5);
        REVIEW = new LimitAction("REVIEW", 6, 6);
        $VALUES = (new LimitAction[] {
            ALLOW, ALLOW_SILENT, BLOCK, WARN, CAPTCHA, SILENCE, REVIEW
        });
    }
}
