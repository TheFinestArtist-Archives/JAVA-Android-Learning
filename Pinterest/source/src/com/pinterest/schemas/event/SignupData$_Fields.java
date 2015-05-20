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
    public static final getFieldName MEDIUM;
    public static final getFieldName REFERRER_TYPE;
    public static final getFieldName SOCIAL_ID;
    public static final getFieldName USER_AGENT;
    public static final getFieldName VIA;
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
            return VIA;

        case 2: // '\002'
            return MEDIUM;

        case 3: // '\003'
            return SOCIAL_ID;

        case 4: // '\004'
            return USER_AGENT;

        case 5: // '\005'
            return REFERRER_TYPE;
        }
    }

    public static REFERRER_TYPE findByThriftIdOrThrow(int i)
    {
        REFERRER_TYPE referrer_type = findByThriftId(i);
        if (referrer_type == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return referrer_type;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/SignupData$_Fields, s);
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
        VIA = new <init>("VIA", 0, (short)1, "via");
        MEDIUM = new <init>("MEDIUM", 1, (short)2, "medium");
        SOCIAL_ID = new <init>("SOCIAL_ID", 2, (short)3, "socialId");
        USER_AGENT = new <init>("USER_AGENT", 3, (short)4, "userAgent");
        REFERRER_TYPE = new <init>("REFERRER_TYPE", 4, (short)5, "referrerType");
        $VALUES = (new .VALUES[] {
            VIA, MEDIUM, SOCIAL_ID, USER_AGENT, REFERRER_TYPE
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/SignupData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
