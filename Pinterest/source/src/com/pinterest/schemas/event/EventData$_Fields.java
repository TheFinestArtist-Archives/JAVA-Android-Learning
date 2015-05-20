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
    public static final getFieldName ADMIN_OVERRIDE;
    public static final getFieldName BROWSER_ID_DATA;
    public static final getFieldName COMPLETED_CAPTCHA;
    public static final getFieldName EMAIL;
    public static final getFieldName ENFORCE_SPAM_RULES;
    public static final getFieldName INSERTION;
    public static final getFieldName INTEREST_IMPRESSION_DATA;
    public static final getFieldName JSON;
    public static final getFieldName OFFSITE_RESULT;
    public static final getFieldName PHANTOM_RESULT;
    public static final getFieldName PIN_IMPRESSIONS;
    public static final getFieldName PUSH;
    public static final getFieldName SIGNUP;
    public static final getFieldName SPAM_REQUEST;
    public static final getFieldName TEST_DATA;
    public static final getFieldName TRIPWIRE_DATA;
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
            return TEST_DATA;

        case 2: // '\002'
            return EMAIL;

        case 3: // '\003'
            return JSON;

        case 4: // '\004'
            return SPAM_REQUEST;

        case 5: // '\005'
            return PUSH;

        case 6: // '\006'
            return SIGNUP;

        case 7: // '\007'
            return OFFSITE_RESULT;

        case 8: // '\b'
            return PHANTOM_RESULT;

        case 9: // '\t'
            return COMPLETED_CAPTCHA;

        case 10: // '\n'
            return TRIPWIRE_DATA;

        case 11: // '\013'
            return PIN_IMPRESSIONS;

        case 12: // '\f'
            return ENFORCE_SPAM_RULES;

        case 13: // '\r'
            return ADMIN_OVERRIDE;

        case 14: // '\016'
            return INTEREST_IMPRESSION_DATA;

        case 15: // '\017'
            return BROWSER_ID_DATA;

        case 16: // '\020'
            return INSERTION;
        }
    }

    public static INSERTION findByThriftIdOrThrow(int i)
    {
        INSERTION insertion = findByThriftId(i);
        if (insertion == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return insertion;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/EventData$_Fields, s);
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
        TEST_DATA = new <init>("TEST_DATA", 0, (short)1, "testData");
        EMAIL = new <init>("EMAIL", 1, (short)2, "email");
        JSON = new <init>("JSON", 2, (short)3, "json");
        SPAM_REQUEST = new <init>("SPAM_REQUEST", 3, (short)4, "spamRequest");
        PUSH = new <init>("PUSH", 4, (short)5, "push");
        SIGNUP = new <init>("SIGNUP", 5, (short)6, "signup");
        OFFSITE_RESULT = new <init>("OFFSITE_RESULT", 6, (short)7, "offsiteResult");
        PHANTOM_RESULT = new <init>("PHANTOM_RESULT", 7, (short)8, "phantomResult");
        COMPLETED_CAPTCHA = new <init>("COMPLETED_CAPTCHA", 8, (short)9, "completedCaptcha");
        TRIPWIRE_DATA = new <init>("TRIPWIRE_DATA", 9, (short)10, "tripwireData");
        PIN_IMPRESSIONS = new <init>("PIN_IMPRESSIONS", 10, (short)11, "pinImpressions");
        ENFORCE_SPAM_RULES = new <init>("ENFORCE_SPAM_RULES", 11, (short)12, "enforceSpamRules");
        ADMIN_OVERRIDE = new <init>("ADMIN_OVERRIDE", 12, (short)13, "adminOverride");
        INTEREST_IMPRESSION_DATA = new <init>("INTEREST_IMPRESSION_DATA", 13, (short)14, "interestImpressionData");
        BROWSER_ID_DATA = new <init>("BROWSER_ID_DATA", 14, (short)15, "browserIdData");
        INSERTION = new <init>("INSERTION", 15, (short)16, "insertion");
        $VALUES = (new .VALUES[] {
            TEST_DATA, EMAIL, JSON, SPAM_REQUEST, PUSH, SIGNUP, OFFSITE_RESULT, PHANTOM_RESULT, COMPLETED_CAPTCHA, TRIPWIRE_DATA, 
            PIN_IMPRESSIONS, ENFORCE_SPAM_RULES, ADMIN_OVERRIDE, INTEREST_IMPRESSION_DATA, BROWSER_ID_DATA, INSERTION
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/EventData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
