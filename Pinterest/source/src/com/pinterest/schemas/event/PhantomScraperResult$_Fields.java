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
    public static final getFieldName AMZ_URL;
    public static final getFieldName BASE_URL;
    public static final getFieldName RAW_RESULT;
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
            return BASE_URL;

        case 2: // '\002'
            return AMZ_URL;

        case 3: // '\003'
            return RAW_RESULT;
        }
    }

    public static RAW_RESULT findByThriftIdOrThrow(int i)
    {
        RAW_RESULT raw_result = findByThriftId(i);
        if (raw_result == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return raw_result;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PhantomScraperResult$_Fields, s);
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
        BASE_URL = new <init>("BASE_URL", 0, (short)1, "baseUrl");
        AMZ_URL = new <init>("AMZ_URL", 1, (short)2, "amzUrl");
        RAW_RESULT = new <init>("RAW_RESULT", 2, (short)3, "rawResult");
        $VALUES = (new .VALUES[] {
            BASE_URL, AMZ_URL, RAW_RESULT
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomScraperResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
