// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class BrowserType extends Enum
    implements TEnum
{

    private static final BrowserType $VALUES[];
    public static final BrowserType CHROME;
    public static final BrowserType FIREFOX;
    public static final BrowserType IE;
    public static final BrowserType OPERA;
    public static final BrowserType OPERA_BLINK;
    public static final BrowserType OTHER;
    public static final BrowserType SAFARI;
    private final int value;

    private BrowserType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static BrowserType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return OTHER;

        case 1: // '\001'
            return CHROME;

        case 2: // '\002'
            return SAFARI;

        case 3: // '\003'
            return IE;

        case 4: // '\004'
            return FIREFOX;

        case 5: // '\005'
            return OPERA;

        case 6: // '\006'
            return OPERA_BLINK;
        }
    }

    public static BrowserType valueOf(String s)
    {
        return (BrowserType)Enum.valueOf(com/pinterest/schemas/event/BrowserType, s);
    }

    public static BrowserType[] values()
    {
        return (BrowserType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        OTHER = new BrowserType("OTHER", 0, 0);
        CHROME = new BrowserType("CHROME", 1, 1);
        SAFARI = new BrowserType("SAFARI", 2, 2);
        IE = new BrowserType("IE", 3, 3);
        FIREFOX = new BrowserType("FIREFOX", 4, 4);
        OPERA = new BrowserType("OPERA", 5, 5);
        OPERA_BLINK = new BrowserType("OPERA_BLINK", 6, 6);
        $VALUES = (new BrowserType[] {
            OTHER, CHROME, SAFARI, IE, FIREFOX, OPERA, OPERA_BLINK
        });
    }
}
