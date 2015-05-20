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
    public static final getFieldName AUX_DATA;
    public static final getFieldName DATA;
    public static final getFieldName MESSAGE;
    public static final getFieldName RESPONSE_CODE;
    public static final getFieldName RESPONSE_CONTEXT;
    public static final getFieldName RULE_RESULTS;
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
            return ACTION;

        case 2: // '\002'
            return MESSAGE;

        case 3: // '\003'
            return RULE_RESULTS;

        case 4: // '\004'
            return DATA;

        case 5: // '\005'
            return RESPONSE_CODE;

        case 6: // '\006'
            return RESPONSE_CONTEXT;

        case 7: // '\007'
            return AUX_DATA;
        }
    }

    public static AUX_DATA findByThriftIdOrThrow(int i)
    {
        AUX_DATA aux_data = findByThriftId(i);
        if (aux_data == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return aux_data;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/LimitResult$_Fields, s);
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
        ACTION = new <init>("ACTION", 0, (short)1, "action");
        MESSAGE = new <init>("MESSAGE", 1, (short)2, "message");
        RULE_RESULTS = new <init>("RULE_RESULTS", 2, (short)3, "ruleResults");
        DATA = new <init>("DATA", 3, (short)4, "data");
        RESPONSE_CODE = new <init>("RESPONSE_CODE", 4, (short)5, "response_code");
        RESPONSE_CONTEXT = new <init>("RESPONSE_CONTEXT", 5, (short)6, "response_context");
        AUX_DATA = new <init>("AUX_DATA", 6, (short)7, "aux_data");
        $VALUES = (new .VALUES[] {
            ACTION, MESSAGE, RULE_RESULTS, DATA, RESPONSE_CODE, RESPONSE_CONTEXT, AUX_DATA
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/LimitResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
