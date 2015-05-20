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
    public static final getFieldName DIGEST_STORY_TYPE;
    public static final getFieldName EDUCATION_TYPE;
    public static final getFieldName NAG_TYPE;
    public static final getFieldName STUB;
    public static final getFieldName TOAST_TYPE;
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
            return STUB;

        case 2: // '\002'
            return TOAST_TYPE;

        case 3: // '\003'
            return NAG_TYPE;

        case 4: // '\004'
            return EDUCATION_TYPE;

        case 5: // '\005'
            return DIGEST_STORY_TYPE;
        }
    }

    public static DIGEST_STORY_TYPE findByThriftIdOrThrow(int i)
    {
        DIGEST_STORY_TYPE digest_story_type = findByThriftId(i);
        if (digest_story_type == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return digest_story_type;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/ComponentData$_Fields, s);
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
        STUB = new <init>("STUB", 0, (short)1, "stub");
        TOAST_TYPE = new <init>("TOAST_TYPE", 1, (short)2, "toastType");
        NAG_TYPE = new <init>("NAG_TYPE", 2, (short)3, "nagType");
        EDUCATION_TYPE = new <init>("EDUCATION_TYPE", 3, (short)4, "educationType");
        DIGEST_STORY_TYPE = new <init>("DIGEST_STORY_TYPE", 4, (short)5, "digestStoryType");
        $VALUES = (new .VALUES[] {
            STUB, TOAST_TYPE, NAG_TYPE, EDUCATION_TYPE, DIGEST_STORY_TYPE
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ComponentData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
