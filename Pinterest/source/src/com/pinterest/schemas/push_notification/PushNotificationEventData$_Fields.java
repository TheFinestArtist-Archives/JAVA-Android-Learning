// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.push_notification;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;

public final class _fieldName extends Enum
    implements TFieldIdEnum
{

    private static final getFieldName $VALUES[];
    public static final getFieldName ACTION_TYPE;
    public static final getFieldName ACTOR_ID;
    public static final getFieldName BODY;
    public static final getFieldName DEVICE_ID;
    public static final getFieldName LINK;
    public static final getFieldName PUSH_ID;
    public static final getFieldName PUSH_NETWORK_TYPE;
    public static final getFieldName PUSH_TOKEN;
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
            return PUSH_NETWORK_TYPE;

        case 2: // '\002'
            return PUSH_ID;

        case 3: // '\003'
            return BODY;

        case 4: // '\004'
            return LINK;

        case 5: // '\005'
            return ACTOR_ID;

        case 6: // '\006'
            return DEVICE_ID;

        case 7: // '\007'
            return PUSH_TOKEN;

        case 8: // '\b'
            return ACTION_TYPE;
        }
    }

    public static ACTION_TYPE findByThriftIdOrThrow(int i)
    {
        ACTION_TYPE action_type = findByThriftId(i);
        if (action_type == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return action_type;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/push_notification/PushNotificationEventData$_Fields, s);
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
        PUSH_NETWORK_TYPE = new <init>("PUSH_NETWORK_TYPE", 0, (short)1, "pushNetworkType");
        PUSH_ID = new <init>("PUSH_ID", 1, (short)2, "pushId");
        BODY = new <init>("BODY", 2, (short)3, "body");
        LINK = new <init>("LINK", 3, (short)4, "link");
        ACTOR_ID = new <init>("ACTOR_ID", 4, (short)5, "actorId");
        DEVICE_ID = new <init>("DEVICE_ID", 5, (short)6, "deviceId");
        PUSH_TOKEN = new <init>("PUSH_TOKEN", 6, (short)7, "pushToken");
        ACTION_TYPE = new <init>("ACTION_TYPE", 7, (short)8, "actionType");
        $VALUES = (new .VALUES[] {
            PUSH_NETWORK_TYPE, PUSH_ID, BODY, LINK, ACTOR_ID, DEVICE_ID, PUSH_TOKEN, ACTION_TYPE
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/push_notification/PushNotificationEventData$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
