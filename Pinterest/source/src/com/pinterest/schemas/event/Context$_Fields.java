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
    public static final getFieldName COMPONENT;
    public static final getFieldName COMPONENT_DATA;
    public static final getFieldName ELEMENT;
    public static final getFieldName ELEMENT_DATA;
    public static final getFieldName VIEW_DATA;
    public static final getFieldName VIEW_PARAMETER;
    public static final getFieldName VIEW_TYPE;
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
            return VIEW_TYPE;

        case 2: // '\002'
            return VIEW_PARAMETER;

        case 3: // '\003'
            return VIEW_DATA;

        case 4: // '\004'
            return COMPONENT;

        case 5: // '\005'
            return COMPONENT_DATA;

        case 6: // '\006'
            return ELEMENT;

        case 7: // '\007'
            return ELEMENT_DATA;
        }
    }

    public static ELEMENT_DATA findByThriftIdOrThrow(int i)
    {
        ELEMENT_DATA element_data = findByThriftId(i);
        if (element_data == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return element_data;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/Context$_Fields, s);
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
        VIEW_TYPE = new <init>("VIEW_TYPE", 0, (short)1, "viewType");
        VIEW_PARAMETER = new <init>("VIEW_PARAMETER", 1, (short)2, "viewParameter");
        VIEW_DATA = new <init>("VIEW_DATA", 2, (short)3, "viewData");
        COMPONENT = new <init>("COMPONENT", 3, (short)4, "component");
        COMPONENT_DATA = new <init>("COMPONENT_DATA", 4, (short)5, "componentData");
        ELEMENT = new <init>("ELEMENT", 5, (short)6, "element");
        ELEMENT_DATA = new <init>("ELEMENT_DATA", 6, (short)7, "elementData");
        $VALUES = (new .VALUES[] {
            VIEW_TYPE, VIEW_PARAMETER, VIEW_DATA, COMPONENT, COMPONENT_DATA, ELEMENT, ELEMENT_DATA
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/Context$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
