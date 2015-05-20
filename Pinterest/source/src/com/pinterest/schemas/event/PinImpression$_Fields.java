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
    public static final getFieldName CACHED;
    public static final getFieldName COLUMN_INDEX;
    public static final getFieldName END_TIME;
    public static final getFieldName IMAGE_SIGNATURE;
    public static final getFieldName IMAGE_URL;
    public static final getFieldName INSERTION_ID;
    public static final getFieldName LOOPS;
    public static final getFieldName PIN_ID;
    public static final getFieldName PIN_ID_STR;
    public static final getFieldName RENDER_DURATION;
    public static final getFieldName REQUEST_ID;
    public static final getFieldName SLOT_INDEX;
    public static final getFieldName TIME;
    public static final getFieldName TYPE;
    public static final getFieldName Y_POSITION;
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
            return PIN_ID;

        case 2: // '\002'
            return TIME;

        case 3: // '\003'
            return PIN_ID_STR;

        case 4: // '\004'
            return INSERTION_ID;

        case 5: // '\005'
            return END_TIME;

        case 6: // '\006'
            return Y_POSITION;

        case 7: // '\007'
            return COLUMN_INDEX;

        case 8: // '\b'
            return SLOT_INDEX;

        case 9: // '\t'
            return REQUEST_ID;

        case 10: // '\n'
            return TYPE;

        case 11: // '\013'
            return RENDER_DURATION;

        case 12: // '\f'
            return IMAGE_URL;

        case 13: // '\r'
            return IMAGE_SIGNATURE;

        case 14: // '\016'
            return CACHED;

        case 15: // '\017'
            return LOOPS;
        }
    }

    public static LOOPS findByThriftIdOrThrow(int i)
    {
        LOOPS loops = findByThriftId(i);
        if (loops == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return loops;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PinImpression$_Fields, s);
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
        PIN_ID = new <init>("PIN_ID", 0, (short)1, "pinId");
        TIME = new <init>("TIME", 1, (short)2, "time");
        PIN_ID_STR = new <init>("PIN_ID_STR", 2, (short)3, "pinIdStr");
        INSERTION_ID = new <init>("INSERTION_ID", 3, (short)4, "insertionId");
        END_TIME = new <init>("END_TIME", 4, (short)5, "endTime");
        Y_POSITION = new <init>("Y_POSITION", 5, (short)6, "yPosition");
        COLUMN_INDEX = new <init>("COLUMN_INDEX", 6, (short)7, "columnIndex");
        SLOT_INDEX = new <init>("SLOT_INDEX", 7, (short)8, "slotIndex");
        REQUEST_ID = new <init>("REQUEST_ID", 8, (short)9, "requestId");
        TYPE = new <init>("TYPE", 9, (short)10, "type");
        RENDER_DURATION = new <init>("RENDER_DURATION", 10, (short)11, "renderDuration");
        IMAGE_URL = new <init>("IMAGE_URL", 11, (short)12, "imageURL");
        IMAGE_SIGNATURE = new <init>("IMAGE_SIGNATURE", 12, (short)13, "imageSignature");
        CACHED = new <init>("CACHED", 13, (short)14, "cached");
        LOOPS = new <init>("LOOPS", 14, (short)15, "loops");
        $VALUES = (new .VALUES[] {
            PIN_ID, TIME, PIN_ID_STR, INSERTION_ID, END_TIME, Y_POSITION, COLUMN_INDEX, SLOT_INDEX, REQUEST_ID, TYPE, 
            RENDER_DURATION, IMAGE_URL, IMAGE_SIGNATURE, CACHED, LOOPS
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinImpression$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
