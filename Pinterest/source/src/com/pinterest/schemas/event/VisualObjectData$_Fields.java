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
    public static final getFieldName OBJECTS;
    public static final getFieldName SELECTED_OBJECT_INDEX;
    public static final getFieldName SIMLIST_VERSION;
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
            return OBJECTS;

        case 2: // '\002'
            return SIMLIST_VERSION;

        case 3: // '\003'
            return SELECTED_OBJECT_INDEX;
        }
    }

    public static SELECTED_OBJECT_INDEX findByThriftIdOrThrow(int i)
    {
        SELECTED_OBJECT_INDEX selected_object_index = findByThriftId(i);
        if (selected_object_index == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return selected_object_index;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/VisualObjectData$_Fields, s);
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
        OBJECTS = new <init>("OBJECTS", 0, (short)1, "objects");
        SIMLIST_VERSION = new <init>("SIMLIST_VERSION", 1, (short)2, "simlistVersion");
        SELECTED_OBJECT_INDEX = new <init>("SELECTED_OBJECT_INDEX", 2, (short)3, "selectedObjectIndex");
        $VALUES = (new .VALUES[] {
            OBJECTS, SIMLIST_VERSION, SELECTED_OBJECT_INDEX
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/VisualObjectData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
