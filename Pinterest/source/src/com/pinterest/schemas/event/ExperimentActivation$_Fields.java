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
    public static final getFieldName APP_TYPE;
    public static final getFieldName CONTEXT_INFO;
    public static final getFieldName COUNTRY;
    public static final getFieldName EXPERIMENT_GROUP;
    public static final getFieldName EXPERIMENT_HASH;
    public static final getFieldName EXPERIMENT_INFO;
    public static final getFieldName EXPERIMENT_NAME;
    public static final getFieldName EXPERIMENT_VERSION;
    public static final getFieldName IP_ADDRESS;
    public static final getFieldName REQUEST_ID;
    public static final getFieldName SESSION_ID;
    public static final getFieldName TIME;
    public static final getFieldName UNIQUE_ID;
    public static final getFieldName USER_ID;
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
            return EXPERIMENT_HASH;

        case 3: // '\003'
            return EXPERIMENT_NAME;

        case 4: // '\004'
            return EXPERIMENT_VERSION;

        case 5: // '\005'
            return EXPERIMENT_GROUP;

        case 6: // '\006'
            return APP_TYPE;

        case 7: // '\007'
            return REQUEST_ID;

        case 8: // '\b'
            return USER_ID;

        case 9: // '\t'
            return SESSION_ID;

        case 10: // '\n'
            return COUNTRY;

        case 11: // '\013'
            return IP_ADDRESS;

        case 12: // '\f'
            return UNIQUE_ID;

        case 13: // '\r'
            return EXPERIMENT_INFO;

        case 14: // '\016'
            return CONTEXT_INFO;
        }
    }

    public static CONTEXT_INFO findByThriftIdOrThrow(int i)
    {
        CONTEXT_INFO context_info = findByThriftId(i);
        if (context_info == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return context_info;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/ExperimentActivation$_Fields, s);
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
        EXPERIMENT_HASH = new <init>("EXPERIMENT_HASH", 1, (short)2, "experimentHash");
        EXPERIMENT_NAME = new <init>("EXPERIMENT_NAME", 2, (short)3, "experimentName");
        EXPERIMENT_VERSION = new <init>("EXPERIMENT_VERSION", 3, (short)4, "experimentVersion");
        EXPERIMENT_GROUP = new <init>("EXPERIMENT_GROUP", 4, (short)5, "experimentGroup");
        APP_TYPE = new <init>("APP_TYPE", 5, (short)6, "appType");
        REQUEST_ID = new <init>("REQUEST_ID", 6, (short)7, "requestId");
        USER_ID = new <init>("USER_ID", 7, (short)8, "userId");
        SESSION_ID = new <init>("SESSION_ID", 8, (short)9, "sessionId");
        COUNTRY = new <init>("COUNTRY", 9, (short)10, "country");
        IP_ADDRESS = new <init>("IP_ADDRESS", 10, (short)11, "ipAddress");
        UNIQUE_ID = new <init>("UNIQUE_ID", 11, (short)12, "uniqueId");
        EXPERIMENT_INFO = new <init>("EXPERIMENT_INFO", 12, (short)13, "experimentInfo");
        CONTEXT_INFO = new <init>("CONTEXT_INFO", 13, (short)14, "contextInfo");
        $VALUES = (new .VALUES[] {
            TIME, EXPERIMENT_HASH, EXPERIMENT_NAME, EXPERIMENT_VERSION, EXPERIMENT_GROUP, APP_TYPE, REQUEST_ID, USER_ID, SESSION_ID, COUNTRY, 
            IP_ADDRESS, UNIQUE_ID, EXPERIMENT_INFO, CONTEXT_INFO
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ExperimentActivation$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
