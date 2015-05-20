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
    public static final getFieldName BLOCK_REASON;
    public static final getFieldName REDIRECT_TIMINGS;
    public static final getFieldName RESULT;
    public static final getFieldName SANITIZED_URL;
    public static final getFieldName STATUS_CODE;
    public static final getFieldName URL;
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
            return RESULT;

        case 2: // '\002'
            return SANITIZED_URL;

        case 3: // '\003'
            return URL;

        case 4: // '\004'
            return STATUS_CODE;

        case 5: // '\005'
            return REDIRECT_TIMINGS;

        case 6: // '\006'
            return BLOCK_REASON;
        }
    }

    public static BLOCK_REASON findByThriftIdOrThrow(int i)
    {
        BLOCK_REASON block_reason = findByThriftId(i);
        if (block_reason == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return block_reason;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/UrlCheckResult$_Fields, s);
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
        RESULT = new <init>("RESULT", 0, (short)1, "result");
        SANITIZED_URL = new <init>("SANITIZED_URL", 1, (short)2, "sanitizedUrl");
        URL = new <init>("URL", 2, (short)3, "url");
        STATUS_CODE = new <init>("STATUS_CODE", 3, (short)4, "statusCode");
        REDIRECT_TIMINGS = new <init>("REDIRECT_TIMINGS", 4, (short)5, "redirectTimings");
        BLOCK_REASON = new <init>("BLOCK_REASON", 5, (short)6, "blockReason");
        $VALUES = (new .VALUES[] {
            RESULT, SANITIZED_URL, URL, STATUS_CODE, REDIRECT_TIMINGS, BLOCK_REASON
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/UrlCheckResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
