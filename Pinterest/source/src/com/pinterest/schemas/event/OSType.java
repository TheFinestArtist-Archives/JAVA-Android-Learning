// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class OSType extends Enum
    implements TEnum
{

    private static final OSType $VALUES[];
    public static final OSType ANDROID;
    public static final OSType BLACKBERRY;
    public static final OSType IOS;
    public static final OSType LINUX;
    public static final OSType MAC;
    public static final OSType OTHER;
    public static final OSType UBUNTU;
    public static final OSType WINDOWS_7;
    public static final OSType WINDOWS_8;
    public static final OSType WINDOWS_OTHER;
    public static final OSType WINDOWS_PHONE;
    public static final OSType WINDOWS_VISTA;
    public static final OSType WINDOWS_XP;
    private final int value;

    private OSType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static OSType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return OTHER;

        case 1: // '\001'
            return WINDOWS_XP;

        case 2: // '\002'
            return WINDOWS_VISTA;

        case 3: // '\003'
            return WINDOWS_7;

        case 4: // '\004'
            return WINDOWS_8;

        case 5: // '\005'
            return MAC;

        case 6: // '\006'
            return IOS;

        case 7: // '\007'
            return ANDROID;

        case 8: // '\b'
            return UBUNTU;

        case 9: // '\t'
            return LINUX;

        case 10: // '\n'
            return WINDOWS_PHONE;

        case 11: // '\013'
            return BLACKBERRY;

        case 12: // '\f'
            return WINDOWS_OTHER;
        }
    }

    public static OSType valueOf(String s)
    {
        return (OSType)Enum.valueOf(com/pinterest/schemas/event/OSType, s);
    }

    public static OSType[] values()
    {
        return (OSType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        OTHER = new OSType("OTHER", 0, 0);
        WINDOWS_XP = new OSType("WINDOWS_XP", 1, 1);
        WINDOWS_VISTA = new OSType("WINDOWS_VISTA", 2, 2);
        WINDOWS_7 = new OSType("WINDOWS_7", 3, 3);
        WINDOWS_8 = new OSType("WINDOWS_8", 4, 4);
        MAC = new OSType("MAC", 5, 5);
        IOS = new OSType("IOS", 6, 6);
        ANDROID = new OSType("ANDROID", 7, 7);
        UBUNTU = new OSType("UBUNTU", 8, 8);
        LINUX = new OSType("LINUX", 9, 9);
        WINDOWS_PHONE = new OSType("WINDOWS_PHONE", 10, 10);
        BLACKBERRY = new OSType("BLACKBERRY", 11, 11);
        WINDOWS_OTHER = new OSType("WINDOWS_OTHER", 12, 12);
        $VALUES = (new OSType[] {
            OTHER, WINDOWS_XP, WINDOWS_VISTA, WINDOWS_7, WINDOWS_8, MAC, IOS, ANDROID, UBUNTU, LINUX, 
            WINDOWS_PHONE, BLACKBERRY, WINDOWS_OTHER
        });
    }
}
