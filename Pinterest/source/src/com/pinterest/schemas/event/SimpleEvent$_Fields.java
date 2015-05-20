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
    public static final getFieldName AUX_DATA;
    public static final getFieldName EVENT_TYPE;
    public static final getFieldName OBJECT_ID;
    public static final getFieldName OBJECT_ID_STR;
    public static final getFieldName TIME;
    public static final getFieldName USER_ID;
    public static final getFieldName USER_ID_STR;
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
            return USER_ID_STR;

        case 7: // '\007'
            return OBJECT_ID_STR;
        }
    }

    public static OBJECT_ID_STR findByThriftIdOrThrow(int i)
    {
        OBJECT_ID_STR object_id_str = findByThriftId(i);
        if (object_id_str == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return object_id_str;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/SimpleEvent$_Fields, s);
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
        USER_ID_STR = new <init>("USER_ID_STR", 5, (short)6, "userIdStr");
        OBJECT_ID_STR = new <init>("OBJECT_ID_STR", 6, (short)7, "objectIdStr");
        $VALUES = (new .VALUES[] {
            TIME, EVENT_TYPE, USER_ID, OBJECT_ID, AUX_DATA, USER_ID_STR, OBJECT_ID_STR
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/SimpleEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
