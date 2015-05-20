// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class SiteType extends Enum
    implements TEnum
{

    private static final SiteType $VALUES[];
    public static final SiteType ANALYTICS;
    public static final SiteType DESKTOP;
    public static final SiteType DEVELOPERS;
    public static final SiteType MOBILE;
    public static final SiteType STERLING;
    private final int value;

    private SiteType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static SiteType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return DESKTOP;

        case 1: // '\001'
            return MOBILE;

        case 2: // '\002'
            return DEVELOPERS;

        case 3: // '\003'
            return STERLING;

        case 4: // '\004'
            return ANALYTICS;
        }
    }

    public static SiteType valueOf(String s)
    {
        return (SiteType)Enum.valueOf(com/pinterest/schemas/event/SiteType, s);
    }

    public static SiteType[] values()
    {
        return (SiteType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        DESKTOP = new SiteType("DESKTOP", 0, 0);
        MOBILE = new SiteType("MOBILE", 1, 1);
        DEVELOPERS = new SiteType("DEVELOPERS", 2, 2);
        STERLING = new SiteType("STERLING", 3, 3);
        ANALYTICS = new SiteType("ANALYTICS", 4, 4);
        $VALUES = (new SiteType[] {
            DESKTOP, MOBILE, DEVELOPERS, STERLING, ANALYTICS
        });
    }
}
