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
    public static final getFieldName BCC;
    public static final getFieldName CATEGORIES;
    public static final getFieldName CONTEXT_JSON;
    public static final getFieldName EXPERIMENTS;
    public static final getFieldName FROM_USER_ID;
    public static final getFieldName MAIN_CATEGORY;
    public static final getFieldName RECOMMENDATIONS;
    public static final getFieldName RECOMMENDATION_EVENT;
    public static final getFieldName SUBJECT;
    public static final getFieldName TEMPLATE;
    public static final getFieldName TIME;
    public static final getFieldName TO_ADDRESS;
    public static final getFieldName TRACKING_ID;
    public static final getFieldName USER_ID;
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
            return TIME;

        case 2: // '\002'
            return TO_ADDRESS;

        case 3: // '\003'
            return SUBJECT;

        case 4: // '\004'
            return TEMPLATE;

        case 5: // '\005'
            return USER_ID;

        case 6: // '\006'
            return TRACKING_ID;

        case 7: // '\007'
            return MAIN_CATEGORY;

        case 8: // '\b'
            return CATEGORIES;

        case 9: // '\t'
            return BCC;

        case 10: // '\n'
            return EXPERIMENTS;

        case 11: // '\013'
            return CONTEXT_JSON;

        case 12: // '\f'
            return FROM_USER_ID;

        case 13: // '\r'
            return RECOMMENDATIONS;

        case 14: // '\016'
            return RECOMMENDATION_EVENT;
        }
    }

    public static RECOMMENDATION_EVENT findByThriftIdOrThrow(int i)
    {
        RECOMMENDATION_EVENT recommendation_event = findByThriftId(i);
        if (recommendation_event == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return recommendation_event;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/email_queued/QueuedEmailEvent$_Fields, s);
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
        TIME = new <init>("TIME", 0, (short)1, "time");
        TO_ADDRESS = new <init>("TO_ADDRESS", 1, (short)2, "toAddress");
        SUBJECT = new <init>("SUBJECT", 2, (short)3, "subject");
        TEMPLATE = new <init>("TEMPLATE", 3, (short)4, "template");
        USER_ID = new <init>("USER_ID", 4, (short)5, "userId");
        TRACKING_ID = new <init>("TRACKING_ID", 5, (short)6, "trackingId");
        MAIN_CATEGORY = new <init>("MAIN_CATEGORY", 6, (short)7, "mainCategory");
        CATEGORIES = new <init>("CATEGORIES", 7, (short)8, "categories");
        BCC = new <init>("BCC", 8, (short)9, "bcc");
        EXPERIMENTS = new <init>("EXPERIMENTS", 9, (short)10, "experiments");
        CONTEXT_JSON = new <init>("CONTEXT_JSON", 10, (short)11, "contextJson");
        FROM_USER_ID = new <init>("FROM_USER_ID", 11, (short)12, "fromUserId");
        RECOMMENDATIONS = new <init>("RECOMMENDATIONS", 12, (short)13, "recommendations");
        RECOMMENDATION_EVENT = new <init>("RECOMMENDATION_EVENT", 13, (short)14, "recommendationEvent");
        $VALUES = (new .VALUES[] {
            TIME, TO_ADDRESS, SUBJECT, TEMPLATE, USER_ID, TRACKING_ID, MAIN_CATEGORY, CATEGORIES, BCC, EXPERIMENTS, 
            CONTEXT_JSON, FROM_USER_ID, RECOMMENDATIONS, RECOMMENDATION_EVENT
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/QueuedEmailEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
        {
            _lthriftid = (getFieldName)iterator.next();
        }

    }

    private A(String s, int i, short word0, String s1)
    {
        super(s, i);
        _thriftId = word0;
        _fieldName = s1;
    }
}
