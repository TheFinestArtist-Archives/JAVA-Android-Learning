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
    public static final getFieldName IMAGE;
    public static final getFieldName IMAGE_SETTINGS;
    public static final getFieldName MAX_TIME_OUT;
    public static final getFieldName RAW_RESULT;
    public static final getFieldName REDIRECT_BODY;
    public static final getFieldName REDIRECT_HEADERS;
    public static final getFieldName REDIRECT_URL;
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
            return IMAGE;

        case 2: // '\002'
            return IMAGE_SETTINGS;

        case 3: // '\003'
            return REDIRECT_URL;

        case 4: // '\004'
            return REDIRECT_HEADERS;

        case 5: // '\005'
            return REDIRECT_BODY;

        case 6: // '\006'
            return MAX_TIME_OUT;

        case 7: // '\007'
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
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PhantomServiceSettings$_Fields, s);
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
        IMAGE = new <init>("IMAGE", 0, (short)1, "image");
        IMAGE_SETTINGS = new <init>("IMAGE_SETTINGS", 1, (short)2, "imageSettings");
        REDIRECT_URL = new <init>("REDIRECT_URL", 2, (short)3, "redirectUrl");
        REDIRECT_HEADERS = new <init>("REDIRECT_HEADERS", 3, (short)4, "redirectHeaders");
        REDIRECT_BODY = new <init>("REDIRECT_BODY", 4, (short)5, "redirectBody");
        MAX_TIME_OUT = new <init>("MAX_TIME_OUT", 5, (short)6, "maxTimeOut");
        RAW_RESULT = new <init>("RAW_RESULT", 6, (short)7, "rawResult");
        $VALUES = (new .VALUES[] {
            IMAGE, IMAGE_SETTINGS, REDIRECT_URL, REDIRECT_HEADERS, REDIRECT_BODY, MAX_TIME_OUT, RAW_RESULT
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomServiceSettings$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
