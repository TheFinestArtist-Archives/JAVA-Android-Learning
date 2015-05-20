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
    public static final getFieldName ADS_INSERTION_ID;
    public static final getFieldName PIN_ID;
    public static final getFieldName REQUEST_ID;
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
            return REQUEST_ID;

        case 2: // '\002'
            return PIN_ID;

        case 3: // '\003'
            return ADS_INSERTION_ID;
        }
    }

    public static ADS_INSERTION_ID findByThriftIdOrThrow(int i)
    {
        ADS_INSERTION_ID ads_insertion_id = findByThriftId(i);
        if (ads_insertion_id == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return ads_insertion_id;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/InsertionData$_Fields, s);
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
        REQUEST_ID = new <init>("REQUEST_ID", 0, (short)1, "requestId");
        PIN_ID = new <init>("PIN_ID", 1, (short)2, "pinId");
        ADS_INSERTION_ID = new <init>("ADS_INSERTION_ID", 2, (short)3, "adsInsertionId");
        $VALUES = (new .VALUES[] {
            REQUEST_ID, PIN_ID, ADS_INSERTION_ID
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/InsertionData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
