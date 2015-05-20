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
    public static final getFieldName H;
    public static final getFieldName OBJECT_INDEX;
    public static final getFieldName OBJECT_TYPE;
    public static final getFieldName W;
    public static final getFieldName X;
    public static final getFieldName Y;
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
            return OBJECT_TYPE;

        case 2: // '\002'
            return OBJECT_INDEX;

        case 3: // '\003'
            return X;

        case 4: // '\004'
            return Y;

        case 5: // '\005'
            return W;

        case 6: // '\006'
            return H;
        }
    }

    public static H findByThriftIdOrThrow(int i)
    {
        H h = findByThriftId(i);
        if (h == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return h;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/VisualObject$_Fields, s);
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
        OBJECT_TYPE = new <init>("OBJECT_TYPE", 0, (short)1, "objectType");
        OBJECT_INDEX = new <init>("OBJECT_INDEX", 1, (short)2, "objectIndex");
        X = new <init>("X", 2, (short)3, "x");
        Y = new <init>("Y", 3, (short)4, "y");
        W = new <init>("W", 4, (short)5, "w");
        H = new <init>("H", 5, (short)6, "h");
        $VALUES = (new .VALUES[] {
            OBJECT_TYPE, OBJECT_INDEX, X, Y, W, H
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/VisualObject$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
