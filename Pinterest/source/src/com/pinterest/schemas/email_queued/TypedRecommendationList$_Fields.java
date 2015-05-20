// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;

public final class _fieldName extends Enum
    implements TFieldIdEnum
{

    private static final getFieldName $VALUES[];
    public static final getFieldName OBJECT_TYPE;
    public static final getFieldName RECOMMENDATIONS;
    public static final getFieldName RECOMMENDATION_DETAILS;
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
            return OBJECT_TYPE;

        case 2: // '\002'
            return RECOMMENDATIONS;

        case 3: // '\003'
            return RECOMMENDATION_DETAILS;
        }
    }

    public static RECOMMENDATION_DETAILS findByThriftIdOrThrow(int i)
    {
        RECOMMENDATION_DETAILS recommendation_details = findByThriftId(i);
        if (recommendation_details == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return recommendation_details;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/email_queued/TypedRecommendationList$_Fields, s);
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
        OBJECT_TYPE = new <init>("OBJECT_TYPE", 0, (short)1, "objectType");
        RECOMMENDATIONS = new <init>("RECOMMENDATIONS", 1, (short)2, "recommendations");
        RECOMMENDATION_DETAILS = new <init>("RECOMMENDATION_DETAILS", 2, (short)3, "recommendationDetails");
        $VALUES = (new .VALUES[] {
            OBJECT_TYPE, RECOMMENDATIONS, RECOMMENDATION_DETAILS
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/TypedRecommendationList$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
