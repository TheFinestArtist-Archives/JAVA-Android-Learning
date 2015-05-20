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
    public static final getFieldName ANALYTICS_SELECTED_APPLICATION;
    public static final getFieldName INTEREST_NAME;
    public static final getFieldName OBJECT_DATA;
    public static final getFieldName SEARCH_QUERY;
    public static final getFieldName STUB;
    public static final getFieldName VIEW_OBJECT_ID;
    public static final getFieldName VIEW_OBJECT_ID_STR;
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
            return STUB;

        case 2: // '\002'
            return INTEREST_NAME;

        case 3: // '\003'
            return VIEW_OBJECT_ID;

        case 4: // '\004'
            return OBJECT_DATA;

        case 5: // '\005'
            return SEARCH_QUERY;

        case 6: // '\006'
            return ANALYTICS_SELECTED_APPLICATION;

        case 7: // '\007'
            return VIEW_OBJECT_ID_STR;
        }
    }

    public static VIEW_OBJECT_ID_STR findByThriftIdOrThrow(int i)
    {
        VIEW_OBJECT_ID_STR view_object_id_str = findByThriftId(i);
        if (view_object_id_str == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return view_object_id_str;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/ViewData$_Fields, s);
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
        STUB = new <init>("STUB", 0, (short)1, "stub");
        INTEREST_NAME = new <init>("INTEREST_NAME", 1, (short)2, "interestName");
        VIEW_OBJECT_ID = new <init>("VIEW_OBJECT_ID", 2, (short)3, "viewObjectId");
        OBJECT_DATA = new <init>("OBJECT_DATA", 3, (short)4, "objectData");
        SEARCH_QUERY = new <init>("SEARCH_QUERY", 4, (short)5, "searchQuery");
        ANALYTICS_SELECTED_APPLICATION = new <init>("ANALYTICS_SELECTED_APPLICATION", 5, (short)6, "analyticsSelectedApplication");
        VIEW_OBJECT_ID_STR = new <init>("VIEW_OBJECT_ID_STR", 6, (short)7, "viewObjectIdStr");
        $VALUES = (new .VALUES[] {
            STUB, INTEREST_NAME, VIEW_OBJECT_ID, OBJECT_DATA, SEARCH_QUERY, ANALYTICS_SELECTED_APPLICATION, VIEW_OBJECT_ID_STR
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ViewData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
