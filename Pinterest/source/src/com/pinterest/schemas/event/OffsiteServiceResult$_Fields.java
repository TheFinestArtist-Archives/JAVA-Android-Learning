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
    public static final getFieldName CHECK_LEVEL;
    public static final getFieldName HOST;
    public static final getFieldName RESULTS;
    public static final getFieldName TIME;
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
            return RESULTS;

        case 2: // '\002'
            return HOST;

        case 3: // '\003'
            return TIME;

        case 4: // '\004'
            return CHECK_LEVEL;
        }
    }

    public static CHECK_LEVEL findByThriftIdOrThrow(int i)
    {
        CHECK_LEVEL check_level = findByThriftId(i);
        if (check_level == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return check_level;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/OffsiteServiceResult$_Fields, s);
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
        RESULTS = new <init>("RESULTS", 0, (short)1, "results");
        HOST = new <init>("HOST", 1, (short)2, "host");
        TIME = new <init>("TIME", 2, (short)3, "time");
        CHECK_LEVEL = new <init>("CHECK_LEVEL", 3, (short)4, "checkLevel");
        $VALUES = (new .VALUES[] {
            RESULTS, HOST, TIME, CHECK_LEVEL
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/OffsiteServiceResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
