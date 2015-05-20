// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class BrowserIdState extends Enum
    implements TEnum
{

    private static final BrowserIdState $VALUES[];
    public static final BrowserIdState FROM_BROWSER_ID_INVALID;
    public static final BrowserIdState FROM_INSTALL_ID;
    public static final BrowserIdState FROM_WEB_BROWSER_ID;
    public static final BrowserIdState INVALID;
    public static final BrowserIdState NEW;
    public static final BrowserIdState VALID;
    private final int value;

    private BrowserIdState(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static BrowserIdState findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return NEW;

        case 1: // '\001'
            return VALID;

        case 2: // '\002'
            return INVALID;

        case 3: // '\003'
            return FROM_INSTALL_ID;

        case 4: // '\004'
            return FROM_WEB_BROWSER_ID;

        case 5: // '\005'
            return FROM_BROWSER_ID_INVALID;
        }
    }

    public static BrowserIdState valueOf(String s)
    {
        return (BrowserIdState)Enum.valueOf(com/pinterest/schemas/event/BrowserIdState, s);
    }

    public static BrowserIdState[] values()
    {
        return (BrowserIdState[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        NEW = new BrowserIdState("NEW", 0, 0);
        VALID = new BrowserIdState("VALID", 1, 1);
        INVALID = new BrowserIdState("INVALID", 2, 2);
        FROM_INSTALL_ID = new BrowserIdState("FROM_INSTALL_ID", 3, 3);
        FROM_WEB_BROWSER_ID = new BrowserIdState("FROM_WEB_BROWSER_ID", 4, 4);
        FROM_BROWSER_ID_INVALID = new BrowserIdState("FROM_BROWSER_ID_INVALID", 5, 5);
        $VALUES = (new BrowserIdState[] {
            NEW, VALID, INVALID, FROM_INSTALL_ID, FROM_WEB_BROWSER_ID, FROM_BROWSER_ID_INVALID
        });
    }
}
