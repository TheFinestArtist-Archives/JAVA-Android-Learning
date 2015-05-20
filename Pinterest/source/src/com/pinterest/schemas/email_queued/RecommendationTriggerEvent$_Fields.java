// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;

public final class _fieldName extends Enum
    implements TFieldIdEnum
{

    private static final getFieldName $VALUES[];
    public static final getFieldName TRIGGER_OBJECT_ID_STR;
    public static final getFieldName TRIGGER_OBJECT_TYPE;
    public static final getFieldName TRIGGER_TYPE;
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
            return TRIGGER_TYPE;

        case 2: // '\002'
            return TRIGGER_OBJECT_ID_STR;

        case 3: // '\003'
            return TRIGGER_OBJECT_TYPE;
        }
    }

    public static TRIGGER_OBJECT_TYPE findByThriftIdOrThrow(int i)
    {
        TRIGGER_OBJECT_TYPE trigger_object_type = findByThriftId(i);
        if (trigger_object_type == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return trigger_object_type;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationTriggerEvent$_Fields, s);
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
        TRIGGER_TYPE = new <init>("TRIGGER_TYPE", 0, (short)1, "triggerType");
        TRIGGER_OBJECT_ID_STR = new <init>("TRIGGER_OBJECT_ID_STR", 1, (short)2, "triggerObjectIdStr");
        TRIGGER_OBJECT_TYPE = new <init>("TRIGGER_OBJECT_TYPE", 2, (short)3, "triggerObjectType");
        $VALUES = (new .VALUES[] {
            TRIGGER_TYPE, TRIGGER_OBJECT_ID_STR, TRIGGER_OBJECT_TYPE
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationTriggerEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
