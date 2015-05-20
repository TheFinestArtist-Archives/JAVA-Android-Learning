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
    public static final getFieldName ACTION;
    public static final getFieldName RULE_NAME;
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
            return RULE_NAME;

        case 2: // '\002'
            return ACTION;

        case 3: // '\003'
            return USER_ID;
        }
    }

    public static USER_ID findByThriftIdOrThrow(int i)
    {
        USER_ID user_id = findByThriftId(i);
        if (user_id == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return user_id;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/TripwireData$_Fields, s);
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
        RULE_NAME = new <init>("RULE_NAME", 0, (short)1, "ruleName");
        ACTION = new <init>("ACTION", 1, (short)2, "action");
        USER_ID = new <init>("USER_ID", 2, (short)3, "userId");
        $VALUES = (new .VALUES[] {
            RULE_NAME, ACTION, USER_ID
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/TripwireData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
