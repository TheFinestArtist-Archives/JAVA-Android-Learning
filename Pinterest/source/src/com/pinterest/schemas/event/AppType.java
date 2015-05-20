// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class AppType extends Enum
    implements TEnum
{

    private static final AppType $VALUES[];
    public static final AppType ANDROID_MOBILE;
    public static final AppType ANDROID_TABLET;
    public static final AppType IPAD;
    public static final AppType IPHONE;
    public static final AppType WEB;
    public static final AppType WEB_DENZEL;
    public static final AppType WEB_MOBILE;
    private final int value;

    private AppType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static AppType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return WEB;

        case 1: // '\001'
            return IPHONE;

        case 2: // '\002'
            return IPAD;

        case 3: // '\003'
            return ANDROID_MOBILE;

        case 4: // '\004'
            return ANDROID_TABLET;

        case 5: // '\005'
            return WEB_DENZEL;

        case 6: // '\006'
            return WEB_MOBILE;
        }
    }

    public static AppType valueOf(String s)
    {
        return (AppType)Enum.valueOf(com/pinterest/schemas/event/AppType, s);
    }

    public static AppType[] values()
    {
        return (AppType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        WEB = new AppType("WEB", 0, 0);
        IPHONE = new AppType("IPHONE", 1, 1);
        IPAD = new AppType("IPAD", 2, 2);
        ANDROID_MOBILE = new AppType("ANDROID_MOBILE", 3, 3);
        ANDROID_TABLET = new AppType("ANDROID_TABLET", 4, 4);
        WEB_DENZEL = new AppType("WEB_DENZEL", 5, 5);
        WEB_MOBILE = new AppType("WEB_MOBILE", 6, 6);
        $VALUES = (new AppType[] {
            WEB, IPHONE, IPAD, ANDROID_MOBILE, ANDROID_TABLET, WEB_DENZEL, WEB_MOBILE
        });
    }
}
