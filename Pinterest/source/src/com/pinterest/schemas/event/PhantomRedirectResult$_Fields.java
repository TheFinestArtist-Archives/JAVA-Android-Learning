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
    public static final getFieldName BODY;
    public static final getFieldName HEADERS;
    public static final getFieldName REQUEST_TIME;
    public static final getFieldName RESPONSE_TIME;
    public static final getFieldName STATUS;
    public static final getFieldName STATUS_TEXT;
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
            return URL;

        case 2: // '\002'
            return HEADERS;

        case 3: // '\003'
            return BODY;

        case 4: // '\004'
            return REQUEST_TIME;

        case 5: // '\005'
            return RESPONSE_TIME;

        case 6: // '\006'
            return STATUS;

        case 7: // '\007'
            return STATUS_TEXT;
        }
    }

    public static STATUS_TEXT findByThriftIdOrThrow(int i)
    {
        STATUS_TEXT status_text = findByThriftId(i);
        if (status_text == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return status_text;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PhantomRedirectResult$_Fields, s);
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
        URL = new <init>("URL", 0, (short)1, "url");
        HEADERS = new <init>("HEADERS", 1, (short)2, "headers");
        BODY = new <init>("BODY", 2, (short)3, "body");
        REQUEST_TIME = new <init>("REQUEST_TIME", 3, (short)4, "requestTime");
        RESPONSE_TIME = new <init>("RESPONSE_TIME", 4, (short)5, "responseTime");
        STATUS = new <init>("STATUS", 5, (short)6, "status");
        STATUS_TEXT = new <init>("STATUS_TEXT", 6, (short)7, "statusText");
        $VALUES = (new .VALUES[] {
            URL, HEADERS, BODY, REQUEST_TIME, RESPONSE_TIME, STATUS, STATUS_TEXT
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomRedirectResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
