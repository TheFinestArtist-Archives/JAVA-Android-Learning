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
    public static final getFieldName RECOMMENDATIONS;
    public static final getFieldName RECOMMENDATION_EVENT_ID;
    public static final getFieldName TRIGGER_EVENT;
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
            return RECOMMENDATION_EVENT_ID;

        case 2: // '\002'
            return TRIGGER_EVENT;

        case 3: // '\003'
            return RECOMMENDATIONS;
        }
    }

    public static RECOMMENDATIONS findByThriftIdOrThrow(int i)
    {
        RECOMMENDATIONS recommendations = findByThriftId(i);
        if (recommendations == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return recommendations;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationEvent$_Fields, s);
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
        RECOMMENDATION_EVENT_ID = new <init>("RECOMMENDATION_EVENT_ID", 0, (short)1, "recommendationEventId");
        TRIGGER_EVENT = new <init>("TRIGGER_EVENT", 1, (short)2, "triggerEvent");
        RECOMMENDATIONS = new <init>("RECOMMENDATIONS", 2, (short)3, "recommendations");
        $VALUES = (new .VALUES[] {
            RECOMMENDATION_EVENT_ID, TRIGGER_EVENT, RECOMMENDATIONS
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
