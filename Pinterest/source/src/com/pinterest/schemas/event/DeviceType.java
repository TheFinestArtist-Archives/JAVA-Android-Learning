// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import org.apache.thrift.TEnum;

public final class DeviceType extends Enum
    implements TEnum
{

    private static final DeviceType $VALUES[];
    public static final DeviceType ALCATEL;
    public static final DeviceType BLACKBERRY;
    public static final DeviceType DROID;
    public static final DeviceType GALAXY_TAB_DEPRECATED;
    public static final DeviceType HTC;
    public static final DeviceType HUAWEI;
    public static final DeviceType IPAD;
    public static final DeviceType IPHONE;
    public static final DeviceType IPOD;
    public static final DeviceType KINDLE;
    public static final DeviceType KYOCERA;
    public static final DeviceType LENOVO;
    public static final DeviceType LGE;
    public static final DeviceType NEXUS;
    public static final DeviceType NOOK;
    public static final DeviceType OTHER;
    public static final DeviceType SAMSUNG;
    public static final DeviceType SONY;
    public static final DeviceType WINDOWS_PHONE;
    public static final DeviceType ZTE;
    private final int value;

    private DeviceType(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }

    public static DeviceType findByValue(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return OTHER;

        case 1: // '\001'
            return IPHONE;

        case 2: // '\002'
            return IPAD;

        case 3: // '\003'
            return IPOD;

        case 4: // '\004'
            return KINDLE;

        case 5: // '\005'
            return DROID;

        case 6: // '\006'
            return NEXUS;

        case 7: // '\007'
            return NOOK;

        case 8: // '\b'
            return SAMSUNG;

        case 9: // '\t'
            return HTC;

        case 10: // '\n'
            return GALAXY_TAB_DEPRECATED;

        case 11: // '\013'
            return BLACKBERRY;

        case 12: // '\f'
            return WINDOWS_PHONE;

        case 13: // '\r'
            return LGE;

        case 14: // '\016'
            return SONY;

        case 15: // '\017'
            return ZTE;

        case 16: // '\020'
            return HUAWEI;

        case 17: // '\021'
            return ALCATEL;

        case 18: // '\022'
            return LENOVO;

        case 19: // '\023'
            return KYOCERA;
        }
    }

    public static DeviceType valueOf(String s)
    {
        return (DeviceType)Enum.valueOf(com/pinterest/schemas/event/DeviceType, s);
    }

    public static DeviceType[] values()
    {
        return (DeviceType[])$VALUES.clone();
    }

    public final int getValue()
    {
        return value;
    }

    static 
    {
        OTHER = new DeviceType("OTHER", 0, 0);
        IPHONE = new DeviceType("IPHONE", 1, 1);
        IPAD = new DeviceType("IPAD", 2, 2);
        IPOD = new DeviceType("IPOD", 3, 3);
        KINDLE = new DeviceType("KINDLE", 4, 4);
        DROID = new DeviceType("DROID", 5, 5);
        NEXUS = new DeviceType("NEXUS", 6, 6);
        NOOK = new DeviceType("NOOK", 7, 7);
        SAMSUNG = new DeviceType("SAMSUNG", 8, 8);
        HTC = new DeviceType("HTC", 9, 9);
        GALAXY_TAB_DEPRECATED = new DeviceType("GALAXY_TAB_DEPRECATED", 10, 10);
        BLACKBERRY = new DeviceType("BLACKBERRY", 11, 11);
        WINDOWS_PHONE = new DeviceType("WINDOWS_PHONE", 12, 12);
        LGE = new DeviceType("LGE", 13, 13);
        SONY = new DeviceType("SONY", 14, 14);
        ZTE = new DeviceType("ZTE", 15, 15);
        HUAWEI = new DeviceType("HUAWEI", 16, 16);
        ALCATEL = new DeviceType("ALCATEL", 17, 17);
        LENOVO = new DeviceType("LENOVO", 18, 18);
        KYOCERA = new DeviceType("KYOCERA", 19, 19);
        $VALUES = (new DeviceType[] {
            OTHER, IPHONE, IPAD, IPOD, KINDLE, DROID, NEXUS, NOOK, SAMSUNG, HTC, 
            GALAXY_TAB_DEPRECATED, BLACKBERRY, WINDOWS_PHONE, LGE, SONY, ZTE, HUAWEI, ALCATEL, LENOVO, KYOCERA
        });
    }
}
