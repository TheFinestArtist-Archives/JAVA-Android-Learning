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
    public static final getFieldName OFFSITE_SCORE;
    public static final getFieldName SANITIZED_URL;
    public static final getFieldName SIGNUP_SCORE_V1;
    public static final getFieldName SIGNUP_SCORE_V2;
    public static final getFieldName SIGNUP_SCORE_V3;
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
            return SIGNUP_SCORE_V2;

        case 2: // '\002'
            return SIGNUP_SCORE_V1;

        case 3: // '\003'
            return OFFSITE_SCORE;

        case 4: // '\004'
            return SANITIZED_URL;

        case 5: // '\005'
            return SIGNUP_SCORE_V3;
        }
    }

    public static SIGNUP_SCORE_V3 findByThriftIdOrThrow(int i)
    {
        SIGNUP_SCORE_V3 signup_score_v3 = findByThriftId(i);
        if (signup_score_v3 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return signup_score_v3;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/LimitData$_Fields, s);
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
        SIGNUP_SCORE_V2 = new <init>("SIGNUP_SCORE_V2", 0, (short)1, "signup_score_v2");
        SIGNUP_SCORE_V1 = new <init>("SIGNUP_SCORE_V1", 1, (short)2, "signup_score_v1");
        OFFSITE_SCORE = new <init>("OFFSITE_SCORE", 2, (short)3, "offsite_score");
        SANITIZED_URL = new <init>("SANITIZED_URL", 3, (short)4, "sanitized_url");
        SIGNUP_SCORE_V3 = new <init>("SIGNUP_SCORE_V3", 4, (short)5, "signup_score_v3");
        $VALUES = (new .VALUES[] {
            SIGNUP_SCORE_V2, SIGNUP_SCORE_V1, OFFSITE_SCORE, SANITIZED_URL, SIGNUP_SCORE_V3
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/LimitData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
