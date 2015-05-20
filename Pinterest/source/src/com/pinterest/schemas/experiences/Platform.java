// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.experiences;

import org.apache.thrift.TEnum;

public final class Platform extends Enum
    implements TEnum
{

    private static final Platform $VALUES[];
    public static final Platform ANALYTICS;
    public static final Platform ANDROID;
    public static final Platform BATCH;
    public static final Platform EMAIL;
    public static final Platform IOS;
    public static final Platform PUSH_NOTIFICATIONS;
    public static final Platform STERLING;
    public static final Platform WEB;
    public static final Platform WEB_MOBILE;
    private final int value;

    private Platform(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static Platform findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return WEB;

        case 2: // '\002'
            return IOS;

        case 3: // '\003'
            return ANDROID;

        case 4: // '\004'
            return WEB_MOBILE;

        case 5: // '\005'
            return ANALYTICS;

        case 6: // '\006'
            return STERLING;

        case 7: // '\007'
            return EMAIL;

        case 8: // '\b'
            return PUSH_NOTIFICATIONS;

        case 9: // '\t'
            return BATCH;
        }
    }

    public static Platform valueOf(String s)
    {
        return (Platform)Enum.valueOf(com/pinterest/schemas/experiences/Platform, s);
    }

    public static Platform[] values()
    {
        return (Platform[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        WEB = new Platform("WEB", 0, 1);
        IOS = new Platform("IOS", 1, 2);
        ANDROID = new Platform("ANDROID", 2, 3);
        WEB_MOBILE = new Platform("WEB_MOBILE", 3, 4);
        ANALYTICS = new Platform("ANALYTICS", 4, 5);
        STERLING = new Platform("STERLING", 5, 6);
        EMAIL = new Platform("EMAIL", 6, 7);
        PUSH_NOTIFICATIONS = new Platform("PUSH_NOTIFICATIONS", 7, 8);
        BATCH = new Platform("BATCH", 8, 9);
        $VALUES = (new Platform[] {
            WEB, IOS, ANDROID, WEB_MOBILE, ANALYTICS, STERLING, EMAIL, PUSH_NOTIFICATIONS, BATCH
        });
    }
}
