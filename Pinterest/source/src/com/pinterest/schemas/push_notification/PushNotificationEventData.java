// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.push_notification;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package com.pinterest.schemas.push_notification:
//            PushNetworkType

public class PushNotificationEventData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ACTION_TYPE_FIELD_DESC = new TField("actionType", (byte)8, (short)8);
    private static final TField ACTOR_ID_FIELD_DESC = new TField("actorId", (byte)10, (short)5);
    private static final TField BODY_FIELD_DESC = new TField("body", (byte)11, (short)3);
    private static final TField DEVICE_ID_FIELD_DESC = new TField("deviceId", (byte)11, (short)6);
    private static final TField LINK_FIELD_DESC = new TField("link", (byte)11, (short)4);
    private static final TField PUSH_ID_FIELD_DESC = new TField("pushId", (byte)11, (short)2);
    private static final TField PUSH_NETWORK_TYPE_FIELD_DESC = new TField("pushNetworkType", (byte)8, (short)1);
    private static final TField PUSH_TOKEN_FIELD_DESC = new TField("pushToken", (byte)11, (short)7);
    private static final TStruct STRUCT_DESC = new TStruct("PushNotificationEventData");
    private static final int __ACTIONTYPE_ISSET_ID = 1;
    private static final int __ACTORID_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public int actionType;
    public long actorId;
    public String body;
    public String deviceId;
    public String link;
    public String pushId;
    public PushNetworkType pushNetworkType;
    public String pushToken;

    public PushNotificationEventData()
    {
        __isset_bitfield = 0;
    }

    public PushNotificationEventData(PushNetworkType pushnetworktype, String s, String s1, String s2)
    {
        this();
        pushNetworkType = pushnetworktype;
        pushId = s;
        body = s1;
        link = s2;
    }

    public PushNotificationEventData(PushNotificationEventData pushnotificationeventdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = pushnotificationeventdata.__isset_bitfield;
        if (pushnotificationeventdata.isSetPushNetworkType())
        {
            pushNetworkType = pushnotificationeventdata.pushNetworkType;
        }
        if (pushnotificationeventdata.isSetPushId())
        {
            pushId = pushnotificationeventdata.pushId;
        }
        if (pushnotificationeventdata.isSetBody())
        {
            body = pushnotificationeventdata.body;
        }
        if (pushnotificationeventdata.isSetLink())
        {
            link = pushnotificationeventdata.link;
        }
        actorId = pushnotificationeventdata.actorId;
        if (pushnotificationeventdata.isSetDeviceId())
        {
            deviceId = pushnotificationeventdata.deviceId;
        }
        if (pushnotificationeventdata.isSetPushToken())
        {
            pushToken = pushnotificationeventdata.pushToken;
        }
        actionType = pushnotificationeventdata.actionType;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
            __isset_bitfield = 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectinputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new IOException(objectinputstream.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        try
        {
            write(new TCompactProtocol(new TIOStreamTransport(objectoutputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            throw new IOException(objectoutputstream.getMessage());
        }
    }

    public void clear()
    {
        pushNetworkType = null;
        pushId = null;
        body = null;
        link = null;
        setActorIdIsSet(false);
        actorId = 0L;
        deviceId = null;
        pushToken = null;
        setActionTypeIsSet(false);
        actionType = 0;
    }

    public int compareTo(PushNotificationEventData pushnotificationeventdata)
    {
        if (getClass().equals(pushnotificationeventdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(pushnotificationeventdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetPushNetworkType()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetPushNetworkType()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetPushNetworkType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pushNetworkType, pushnotificationeventdata.pushNetworkType);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetPushId()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetPushId()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetPushId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pushId, pushnotificationeventdata.pushId);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetBody()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetBody()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetBody())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(body, pushnotificationeventdata.body);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetLink()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetLink()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetLink())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(link, pushnotificationeventdata.link);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetActorId()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetActorId()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetActorId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(actorId, pushnotificationeventdata.actorId);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetDeviceId()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetDeviceId()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetDeviceId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(deviceId, pushnotificationeventdata.deviceId);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetPushToken()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetPushToken()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetPushToken())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pushToken, pushnotificationeventdata.pushToken);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetActionType()).compareTo(Boolean.valueOf(pushnotificationeventdata.isSetActionType()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetActionType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(actionType, pushnotificationeventdata.actionType);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PushNotificationEventData)obj);
    }

    public PushNotificationEventData deepCopy()
    {
        return new PushNotificationEventData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PushNotificationEventData pushnotificationeventdata)
    {
        if (pushnotificationeventdata != null)
        {
            boolean flag = isSetPushNetworkType();
            boolean flag8 = pushnotificationeventdata.isSetPushNetworkType();
            if (!flag && !flag8 || flag && flag8 && pushNetworkType.equals(pushnotificationeventdata.pushNetworkType))
            {
                boolean flag1 = isSetPushId();
                boolean flag9 = pushnotificationeventdata.isSetPushId();
                if (!flag1 && !flag9 || flag1 && flag9 && pushId.equals(pushnotificationeventdata.pushId))
                {
                    boolean flag2 = isSetBody();
                    boolean flag10 = pushnotificationeventdata.isSetBody();
                    if (!flag2 && !flag10 || flag2 && flag10 && body.equals(pushnotificationeventdata.body))
                    {
                        boolean flag3 = isSetLink();
                        boolean flag11 = pushnotificationeventdata.isSetLink();
                        if (!flag3 && !flag11 || flag3 && flag11 && link.equals(pushnotificationeventdata.link))
                        {
                            boolean flag4 = isSetActorId();
                            boolean flag12 = pushnotificationeventdata.isSetActorId();
                            if (!flag4 && !flag12 || flag4 && flag12 && actorId == pushnotificationeventdata.actorId)
                            {
                                boolean flag5 = isSetDeviceId();
                                boolean flag13 = pushnotificationeventdata.isSetDeviceId();
                                if (!flag5 && !flag13 || flag5 && flag13 && deviceId.equals(pushnotificationeventdata.deviceId))
                                {
                                    boolean flag6 = isSetPushToken();
                                    boolean flag14 = pushnotificationeventdata.isSetPushToken();
                                    if (!flag6 && !flag14 || flag6 && flag14 && pushToken.equals(pushnotificationeventdata.pushToken))
                                    {
                                        boolean flag7 = isSetActionType();
                                        boolean flag15 = pushnotificationeventdata.isSetActionType();
                                        if (!flag7 && !flag15 || flag7 && flag15 && actionType == pushnotificationeventdata.actionType)
                                        {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PushNotificationEventData)) 
        {
            return false;
        }
        return equals((PushNotificationEventData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public int getActionType()
    {
        return actionType;
    }

    public long getActorId()
    {
        return actorId;
    }

    public String getBody()
    {
        return body;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.push_notification.PushNotificationEventData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getPushNetworkType();

        case 2: // '\002'
            return getPushId();

        case 3: // '\003'
            return getBody();

        case 4: // '\004'
            return getLink();

        case 5: // '\005'
            return Long.valueOf(getActorId());

        case 6: // '\006'
            return getDeviceId();

        case 7: // '\007'
            return getPushToken();

        case 8: // '\b'
            return Integer.valueOf(getActionType());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getLink()
    {
        return link;
    }

    public String getPushId()
    {
        return pushId;
    }

    public PushNetworkType getPushNetworkType()
    {
        return pushNetworkType;
    }

    public String getPushToken()
    {
        return pushToken;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetPushNetworkType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(pushNetworkType.getValue()));
        }
        flag = isSetPushId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(pushId);
        }
        flag = isSetBody();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(body);
        }
        flag = isSetLink();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(link);
        }
        flag = isSetActorId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Long.valueOf(actorId));
        }
        flag = isSetDeviceId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(deviceId);
        }
        flag = isSetPushToken();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(pushToken);
        }
        flag = isSetActionType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(actionType));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.push_notification.PushNotificationEventData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetPushNetworkType();

        case 2: // '\002'
            return isSetPushId();

        case 3: // '\003'
            return isSetBody();

        case 4: // '\004'
            return isSetLink();

        case 5: // '\005'
            return isSetActorId();

        case 6: // '\006'
            return isSetDeviceId();

        case 7: // '\007'
            return isSetPushToken();

        case 8: // '\b'
            return isSetActionType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetActionType()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetActorId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetBody()
    {
        return body != null;
    }

    public boolean isSetDeviceId()
    {
        return deviceId != null;
    }

    public boolean isSetLink()
    {
        return link != null;
    }

    public boolean isSetPushId()
    {
        return pushId != null;
    }

    public boolean isSetPushNetworkType()
    {
        return pushNetworkType != null;
    }

    public boolean isSetPushToken()
    {
        return pushToken != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PushNotificationEventData setActionType(int i)
    {
        actionType = i;
        setActionTypeIsSet(true);
        return this;
    }

    public void setActionTypeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public PushNotificationEventData setActorId(long l)
    {
        actorId = l;
        setActorIdIsSet(true);
        return this;
    }

    public void setActorIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PushNotificationEventData setBody(String s)
    {
        body = s;
        return this;
    }

    public void setBodyIsSet(boolean flag)
    {
        if (!flag)
        {
            body = null;
        }
    }

    public PushNotificationEventData setDeviceId(String s)
    {
        deviceId = s;
        return this;
    }

    public void setDeviceIdIsSet(boolean flag)
    {
        if (!flag)
        {
            deviceId = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.push_notification.PushNotificationEventData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetPushNetworkType();
                return;
            } else
            {
                setPushNetworkType((PushNetworkType)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetPushId();
                return;
            } else
            {
                setPushId((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetBody();
                return;
            } else
            {
                setBody((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetLink();
                return;
            } else
            {
                setLink((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetActorId();
                return;
            } else
            {
                setActorId(((Long)obj).longValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetDeviceId();
                return;
            } else
            {
                setDeviceId((String)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetPushToken();
                return;
            } else
            {
                setPushToken((String)obj);
                return;
            }

        case 8: // '\b'
            break;
        }
        if (obj == null)
        {
            unsetActionType();
            return;
        } else
        {
            setActionType(((Integer)obj).intValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PushNotificationEventData setLink(String s)
    {
        link = s;
        return this;
    }

    public void setLinkIsSet(boolean flag)
    {
        if (!flag)
        {
            link = null;
        }
    }

    public PushNotificationEventData setPushId(String s)
    {
        pushId = s;
        return this;
    }

    public void setPushIdIsSet(boolean flag)
    {
        if (!flag)
        {
            pushId = null;
        }
    }

    public PushNotificationEventData setPushNetworkType(PushNetworkType pushnetworktype)
    {
        pushNetworkType = pushnetworktype;
        return this;
    }

    public void setPushNetworkTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            pushNetworkType = null;
        }
    }

    public PushNotificationEventData setPushToken(String s)
    {
        pushToken = s;
        return this;
    }

    public void setPushTokenIsSet(boolean flag)
    {
        if (!flag)
        {
            pushToken = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PushNotificationEventData(");
        stringbuilder.append("pushNetworkType:");
        if (pushNetworkType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(pushNetworkType);
        }
        stringbuilder.append(", ");
        stringbuilder.append("pushId:");
        if (pushId == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(pushId);
        }
        stringbuilder.append(", ");
        stringbuilder.append("body:");
        if (body == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(body);
        }
        stringbuilder.append(", ");
        stringbuilder.append("link:");
        if (link == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(link);
        }
        if (isSetActorId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("actorId:");
            stringbuilder.append(actorId);
        }
        if (isSetDeviceId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("deviceId:");
            if (deviceId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(deviceId);
            }
        }
        if (isSetPushToken())
        {
            stringbuilder.append(", ");
            stringbuilder.append("pushToken:");
            if (pushToken == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(pushToken);
            }
        }
        if (isSetActionType())
        {
            stringbuilder.append(", ");
            stringbuilder.append("actionType:");
            stringbuilder.append(actionType);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetActionType()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetActorId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetBody()
    {
        body = null;
    }

    public void unsetDeviceId()
    {
        deviceId = null;
    }

    public void unsetLink()
    {
        link = null;
    }

    public void unsetPushId()
    {
        pushId = null;
    }

    public void unsetPushNetworkType()
    {
        pushNetworkType = null;
    }

    public void unsetPushToken()
    {
        pushToken = null;
    }

    public void validate()
    {
    }

    public void write(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().write(tprotocol, this);
    }

    static 
    {
        Object obj = new HashMap();
        schemes = ((Map) (obj));
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PushNotificationEventDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PushNotificationEventDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.ACTOR_ID, _Fields.DEVICE_ID, _Fields.PUSH_TOKEN, _Fields.ACTION_TYPE
        });
        obj = new EnumMap(com/pinterest/schemas/push_notification/PushNotificationEventData$_Fields);
        ((Map) (obj)).put(_Fields.PUSH_NETWORK_TYPE, new FieldMetaData("pushNetworkType", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/push_notification/PushNetworkType)));
        ((Map) (obj)).put(_Fields.PUSH_ID, new FieldMetaData("pushId", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.BODY, new FieldMetaData("body", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.LINK, new FieldMetaData("link", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ACTOR_ID, new FieldMetaData("actorId", (byte)2, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.DEVICE_ID, new FieldMetaData("deviceId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.PUSH_TOKEN, new FieldMetaData("pushToken", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ACTION_TYPE, new FieldMetaData("actionType", (byte)2, new FieldValueMetaData((byte)8)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/push_notification/PushNotificationEventData, metaDataMap);
    }










    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ACTION_TYPE;
        public static final _Fields ACTOR_ID;
        public static final _Fields BODY;
        public static final _Fields DEVICE_ID;
        public static final _Fields LINK;
        public static final _Fields PUSH_ID;
        public static final _Fields PUSH_NETWORK_TYPE;
        public static final _Fields PUSH_TOKEN;
        private static final Map byName;
        private final String _fieldName;
        private final short _thriftId;

        public static _Fields findByName(String s)
        {
            return (_Fields)byName.get(s);
        }

        public static _Fields findByThriftId(int i)
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

        public static _Fields findByThriftIdOrThrow(int i)
        {
            _Fields _lfields = findByThriftId(i);
            if (_lfields == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
            } else
            {
                return _lfields;
            }
        }

        public static _Fields valueOf(String s)
        {
            return (_Fields)Enum.valueOf(com/pinterest/schemas/push_notification/PushNotificationEventData$_Fields, s);
        }

        public static _Fields[] values()
        {
            return (_Fields[])$VALUES.clone();
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
            PUSH_NETWORK_TYPE = new _Fields("PUSH_NETWORK_TYPE", 0, (short)1, "pushNetworkType");
            PUSH_ID = new _Fields("PUSH_ID", 1, (short)2, "pushId");
            BODY = new _Fields("BODY", 2, (short)3, "body");
            LINK = new _Fields("LINK", 3, (short)4, "link");
            ACTOR_ID = new _Fields("ACTOR_ID", 4, (short)5, "actorId");
            DEVICE_ID = new _Fields("DEVICE_ID", 5, (short)6, "deviceId");
            PUSH_TOKEN = new _Fields("PUSH_TOKEN", 6, (short)7, "pushToken");
            ACTION_TYPE = new _Fields("ACTION_TYPE", 7, (short)8, "actionType");
            $VALUES = (new _Fields[] {
                PUSH_NETWORK_TYPE, PUSH_ID, BODY, LINK, ACTOR_ID, DEVICE_ID, PUSH_TOKEN, ACTION_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/push_notification/PushNotificationEventData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
            {
                _lfields = (_Fields)iterator.next();
            }

        }

        private _Fields(String s, int i, short word0, String s1)
        {
            super(s, i);
            _thriftId = word0;
            _fieldName = s1;
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.PUSH_NETWORK_TYPE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.PUSH_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.BODY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.LINK.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.ACTOR_ID.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.DEVICE_ID.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.PUSH_TOKEN.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$push_notification$PushNotificationEventData$_Fields[_Fields.ACTION_TYPE.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PushNotificationEventDataStandardSchemeFactory
        implements SchemeFactory
    {

        public PushNotificationEventDataStandardScheme getScheme()
        {
            return new PushNotificationEventDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PushNotificationEventDataStandardSchemeFactory()
        {
        }

        PushNotificationEventDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PushNotificationEventDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
            {
                tprotocol.readStructBegin();
_L11:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_374;
                }
                tfield.id;
                JVM INSTR tableswitch 1 8: default 68
            //                           1 83
            //                           2 122
            //                           3 158
            //                           4 194
            //                           5 230
            //                           6 266
            //                           7 302
            //                           8 338;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L9:
                break MISSING_BLOCK_LABEL_338;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L12:
                tprotocol.readFieldEnd();
                if (true) goto _L11; else goto _L10
_L10:
                if (tfield.type == 8)
                {
                    pushnotificationeventdata.pushNetworkType = PushNetworkType.findByValue(tprotocol.readI32());
                    pushnotificationeventdata.setPushNetworkTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L3:
                if (tfield.type == 11)
                {
                    pushnotificationeventdata.pushId = tprotocol.readString();
                    pushnotificationeventdata.setPushIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L4:
                if (tfield.type == 11)
                {
                    pushnotificationeventdata.body = tprotocol.readString();
                    pushnotificationeventdata.setBodyIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L5:
                if (tfield.type == 11)
                {
                    pushnotificationeventdata.link = tprotocol.readString();
                    pushnotificationeventdata.setLinkIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L6:
                if (tfield.type == 10)
                {
                    pushnotificationeventdata.actorId = tprotocol.readI64();
                    pushnotificationeventdata.setActorIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L7:
                if (tfield.type == 11)
                {
                    pushnotificationeventdata.deviceId = tprotocol.readString();
                    pushnotificationeventdata.setDeviceIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
_L8:
                if (tfield.type == 11)
                {
                    pushnotificationeventdata.pushToken = tprotocol.readString();
                    pushnotificationeventdata.setPushTokenIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
                if (tfield.type == 8)
                {
                    pushnotificationeventdata.actionType = tprotocol.readI32();
                    pushnotificationeventdata.setActionTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L12
                tprotocol.readStructEnd();
                pushnotificationeventdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PushNotificationEventData)tbase);
            }

            public void write(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
            {
                pushnotificationeventdata.validate();
                tprotocol.writeStructBegin(PushNotificationEventData.STRUCT_DESC);
                if (pushnotificationeventdata.pushNetworkType != null)
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.PUSH_NETWORK_TYPE_FIELD_DESC);
                    tprotocol.writeI32(pushnotificationeventdata.pushNetworkType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.pushId != null)
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.PUSH_ID_FIELD_DESC);
                    tprotocol.writeString(pushnotificationeventdata.pushId);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.body != null)
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.BODY_FIELD_DESC);
                    tprotocol.writeString(pushnotificationeventdata.body);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.link != null)
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.LINK_FIELD_DESC);
                    tprotocol.writeString(pushnotificationeventdata.link);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.isSetActorId())
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.ACTOR_ID_FIELD_DESC);
                    tprotocol.writeI64(pushnotificationeventdata.actorId);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.deviceId != null && pushnotificationeventdata.isSetDeviceId())
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.DEVICE_ID_FIELD_DESC);
                    tprotocol.writeString(pushnotificationeventdata.deviceId);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.pushToken != null && pushnotificationeventdata.isSetPushToken())
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.PUSH_TOKEN_FIELD_DESC);
                    tprotocol.writeString(pushnotificationeventdata.pushToken);
                    tprotocol.writeFieldEnd();
                }
                if (pushnotificationeventdata.isSetActionType())
                {
                    tprotocol.writeFieldBegin(PushNotificationEventData.ACTION_TYPE_FIELD_DESC);
                    tprotocol.writeI32(pushnotificationeventdata.actionType);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PushNotificationEventData)tbase);
            }

            private PushNotificationEventDataStandardScheme()
            {
            }

            PushNotificationEventDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PushNotificationEventDataTupleSchemeFactory
        implements SchemeFactory
    {

        public PushNotificationEventDataTupleScheme getScheme()
        {
            return new PushNotificationEventDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PushNotificationEventDataTupleSchemeFactory()
        {
        }

        PushNotificationEventDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PushNotificationEventDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(8);
                if (bitset.get(0))
                {
                    pushnotificationeventdata.pushNetworkType = PushNetworkType.findByValue(tprotocol.readI32());
                    pushnotificationeventdata.setPushNetworkTypeIsSet(true);
                }
                if (bitset.get(1))
                {
                    pushnotificationeventdata.pushId = tprotocol.readString();
                    pushnotificationeventdata.setPushIdIsSet(true);
                }
                if (bitset.get(2))
                {
                    pushnotificationeventdata.body = tprotocol.readString();
                    pushnotificationeventdata.setBodyIsSet(true);
                }
                if (bitset.get(3))
                {
                    pushnotificationeventdata.link = tprotocol.readString();
                    pushnotificationeventdata.setLinkIsSet(true);
                }
                if (bitset.get(4))
                {
                    pushnotificationeventdata.actorId = tprotocol.readI64();
                    pushnotificationeventdata.setActorIdIsSet(true);
                }
                if (bitset.get(5))
                {
                    pushnotificationeventdata.deviceId = tprotocol.readString();
                    pushnotificationeventdata.setDeviceIdIsSet(true);
                }
                if (bitset.get(6))
                {
                    pushnotificationeventdata.pushToken = tprotocol.readString();
                    pushnotificationeventdata.setPushTokenIsSet(true);
                }
                if (bitset.get(7))
                {
                    pushnotificationeventdata.actionType = tprotocol.readI32();
                    pushnotificationeventdata.setActionTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PushNotificationEventData)tbase);
            }

            public void write(TProtocol tprotocol, PushNotificationEventData pushnotificationeventdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (pushnotificationeventdata.isSetPushNetworkType())
                {
                    bitset.set(0);
                }
                if (pushnotificationeventdata.isSetPushId())
                {
                    bitset.set(1);
                }
                if (pushnotificationeventdata.isSetBody())
                {
                    bitset.set(2);
                }
                if (pushnotificationeventdata.isSetLink())
                {
                    bitset.set(3);
                }
                if (pushnotificationeventdata.isSetActorId())
                {
                    bitset.set(4);
                }
                if (pushnotificationeventdata.isSetDeviceId())
                {
                    bitset.set(5);
                }
                if (pushnotificationeventdata.isSetPushToken())
                {
                    bitset.set(6);
                }
                if (pushnotificationeventdata.isSetActionType())
                {
                    bitset.set(7);
                }
                tprotocol.writeBitSet(bitset, 8);
                if (pushnotificationeventdata.isSetPushNetworkType())
                {
                    tprotocol.writeI32(pushnotificationeventdata.pushNetworkType.getValue());
                }
                if (pushnotificationeventdata.isSetPushId())
                {
                    tprotocol.writeString(pushnotificationeventdata.pushId);
                }
                if (pushnotificationeventdata.isSetBody())
                {
                    tprotocol.writeString(pushnotificationeventdata.body);
                }
                if (pushnotificationeventdata.isSetLink())
                {
                    tprotocol.writeString(pushnotificationeventdata.link);
                }
                if (pushnotificationeventdata.isSetActorId())
                {
                    tprotocol.writeI64(pushnotificationeventdata.actorId);
                }
                if (pushnotificationeventdata.isSetDeviceId())
                {
                    tprotocol.writeString(pushnotificationeventdata.deviceId);
                }
                if (pushnotificationeventdata.isSetPushToken())
                {
                    tprotocol.writeString(pushnotificationeventdata.pushToken);
                }
                if (pushnotificationeventdata.isSetActionType())
                {
                    tprotocol.writeI32(pushnotificationeventdata.actionType);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PushNotificationEventData)tbase);
            }

            private PushNotificationEventDataTupleScheme()
            {
            }

            PushNotificationEventDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
