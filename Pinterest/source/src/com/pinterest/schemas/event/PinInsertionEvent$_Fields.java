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
    public static final getFieldName INSERTIONS;
    public static final getFieldName REQUEST_ID;
    public static final getFieldName TERM;
    public static final getFieldName TIMESTAMP;
    public static final getFieldName USER_ID;
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
            return TIMESTAMP;

        case 2: // '\002'
            return REQUEST_ID;

        case 3: // '\003'
            return INSERTIONS;

        case 4: // '\004'
            return USER_ID;

        case 5: // '\005'
            return VIEW_TYPE;

        case 6: // '\006'
            return TERM;
        }
    }

    public static TERM findByThriftIdOrThrow(int i)
    {
        TERM term = findByThriftId(i);
        if (term == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return term;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PinInsertionEvent$_Fields, s);
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
        TIMESTAMP = new <init>("TIMESTAMP", 0, (short)1, "timestamp");
        REQUEST_ID = new <init>("REQUEST_ID", 1, (short)2, "requestId");
        INSERTIONS = new <init>("INSERTIONS", 2, (short)3, "insertions");
        USER_ID = new <init>("USER_ID", 3, (short)4, "userId");
        VIEW_TYPE = new <init>("VIEW_TYPE", 4, (short)5, "viewType");
        TERM = new <init>("TERM", 5, (short)6, "term");
        $VALUES = (new .VALUES[] {
            TIMESTAMP, REQUEST_ID, INSERTIONS, USER_ID, VIEW_TYPE, TERM
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinInsertionEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
