// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;

public final class _fieldName extends Enum
    implements TFieldIdEnum
{

    private static final getFieldName $VALUES[];
    public static final getFieldName APP;
    public static final getFieldName APP_STATE;
    public static final getFieldName APP_VERSION;
    public static final getFieldName AUX_DATA;
    public static final getFieldName BROWSER;
    public static final getFieldName CONTEXT;
    public static final getFieldName DEVICE;
    public static final getFieldName DEVICE_NAME;
    public static final getFieldName DIAGNOSTICS;
    public static final getFieldName EVENT_DATA;
    public static final getFieldName EVENT_TYPE;
    public static final getFieldName INSERTION_ID;
    public static final getFieldName OBJECT_ID;
    public static final getFieldName OBJECT_ID_STR;
    public static final getFieldName OS;
    public static final getFieldName PREVIOUS_CONTEXT;
    public static final getFieldName P_DATA;
    public static final getFieldName REQUEST;
    public static final getFieldName SITE;
    public static final getFieldName TIME;
    public static final getFieldName UNAUTH_ID;
    public static final getFieldName USER_ID;
    public static final getFieldName USER_ID_STR;
    public static final getFieldName UUID;
    private static final Map byName;
    private final String _fieldName;
    private final short _thriftId;

    public static _fieldName findByName(String s)
    {
        return (_fieldName)byName.get(s);
    }

    public static byName findByThriftId(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return TIME;

        case 2: // '\002'
            return EVENT_TYPE;

        case 3: // '\003'
            return USER_ID;

        case 4: // '\004'
            return OBJECT_ID;

        case 5: // '\005'
            return AUX_DATA;

        case 6: // '\006'
            return EVENT_DATA;

        case 7: // '\007'
            return PREVIOUS_CONTEXT;

        case 8: // '\b'
            return CONTEXT;

        case 9: // '\t'
            return APP;

        case 10: // '\n'
            return REQUEST;

        case 11: // '\013'
            return APP_VERSION;

        case 12: // '\f'
            return DEVICE;

        case 13: // '\r'
            return BROWSER;

        case 14: // '\016'
            return OS;

        case 15: // '\017'
            return DEVICE_NAME;

        case 16: // '\020'
            return UNAUTH_ID;

        case 17: // '\021'
            return USER_ID_STR;

        case 18: // '\022'
            return OBJECT_ID_STR;

        case 19: // '\023'
            return INSERTION_ID;

        case 20: // '\024'
            return APP_STATE;

        case 21: // '\025'
            return SITE;

        case 22: // '\026'
            return DIAGNOSTICS;

        case 23: // '\027'
            return UUID;

        case 24: // '\030'
            return P_DATA;
        }
    }

    public static P_DATA findByThriftIdOrThrow(int i)
    {
        P_DATA p_data = findByThriftId(i);
        if (p_data == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return p_data;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/Event$_Fields, s);
    }

    public static findByThriftId[] values()
    {
        return (findByThriftId[])$VALUES.clone();
    }

    public final String getFieldName()
    {
        return _fieldName;
    }

    public final short getThriftFieldId()
    {
        return _thriftId;
    }

    static 
    {
        TIME = new <init>("TIME", 0, (short)1, "time");
        EVENT_TYPE = new <init>("EVENT_TYPE", 1, (short)2, "eventType");
        USER_ID = new <init>("USER_ID", 2, (short)3, "userId");
        OBJECT_ID = new <init>("OBJECT_ID", 3, (short)4, "objectId");
        AUX_DATA = new <init>("AUX_DATA", 4, (short)5, "auxData");
        EVENT_DATA = new <init>("EVENT_DATA", 5, (short)6, "eventData");
        PREVIOUS_CONTEXT = new <init>("PREVIOUS_CONTEXT", 6, (short)7, "previousContext");
        CONTEXT = new <init>("CONTEXT", 7, (short)8, "context");
        APP = new <init>("APP", 8, (short)9, "app");
        REQUEST = new <init>("REQUEST", 9, (short)10, "request");
        APP_VERSION = new <init>("APP_VERSION", 10, (short)11, "appVersion");
        DEVICE = new <init>("DEVICE", 11, (short)12, "device");
        BROWSER = new <init>("BROWSER", 12, (short)13, "browser");
        OS = new <init>("OS", 13, (short)14, "os");
        DEVICE_NAME = new <init>("DEVICE_NAME", 14, (short)15, "deviceName");
        UNAUTH_ID = new <init>("UNAUTH_ID", 15, (short)16, "unauthId");
        USER_ID_STR = new <init>("USER_ID_STR", 16, (short)17, "userIdStr");
        OBJECT_ID_STR = new <init>("OBJECT_ID_STR", 17, (short)18, "objectIdStr");
        INSERTION_ID = new <init>("INSERTION_ID", 18, (short)19, "insertionId");
        APP_STATE = new <init>("APP_STATE", 19, (short)20, "appState");
        SITE = new <init>("SITE", 20, (short)21, "site");
        DIAGNOSTICS = new <init>("DIAGNOSTICS", 21, (short)22, "diagnostics");
        UUID = new <init>("UUID", 22, (short)23, "uuid");
        P_DATA = new <init>("P_DATA", 23, (short)24, "pData");
        $VALUES = (new .VALUES[] {
            TIME, EVENT_TYPE, USER_ID, OBJECT_ID, AUX_DATA, EVENT_DATA, PREVIOUS_CONTEXT, CONTEXT, APP, REQUEST, 
            APP_VERSION, DEVICE, BROWSER, OS, DEVICE_NAME, UNAUTH_ID, USER_ID_STR, OBJECT_ID_STR, INSERTION_ID, APP_STATE, 
            SITE, DIAGNOSTICS, UUID, P_DATA
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/Event$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
        {
            _lthriftid = (getFieldName)iterator.next();
        }

    }

    private (String s, int i, short word0, String s1)
    {
        super(s, i);
        _thriftId = word0;
        _fieldName = s1;
    }
}
