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
    public static final getFieldName BLEND_TYPE;
    public static final getFieldName INTEREST_IMPRESSIONS;
    public static final getFieldName ORDER_TYPE;
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
            return INTEREST_IMPRESSIONS;

        case 2: // '\002'
            return ORDER_TYPE;

        case 3: // '\003'
            return BLEND_TYPE;
        }
    }

    public static BLEND_TYPE findByThriftIdOrThrow(int i)
    {
        BLEND_TYPE blend_type = findByThriftId(i);
        if (blend_type == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return blend_type;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/InterestImpressionData$_Fields, s);
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
        INTEREST_IMPRESSIONS = new <init>("INTEREST_IMPRESSIONS", 0, (short)1, "interestImpressions");
        ORDER_TYPE = new <init>("ORDER_TYPE", 1, (short)2, "orderType");
        BLEND_TYPE = new <init>("BLEND_TYPE", 2, (short)3, "blendType");
        $VALUES = (new .VALUES[] {
            INTEREST_IMPRESSIONS, ORDER_TYPE, BLEND_TYPE
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/InterestImpressionData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
