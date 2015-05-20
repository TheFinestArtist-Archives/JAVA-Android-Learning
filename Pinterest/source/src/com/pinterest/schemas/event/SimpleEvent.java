// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

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
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package com.pinterest.schemas.event:
//            EventType

public class SimpleEvent
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField AUX_DATA_FIELD_DESC = new TField("auxData", (byte)13, (short)5);
    private static final TField EVENT_TYPE_FIELD_DESC = new TField("eventType", (byte)8, (short)2);
    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", (byte)10, (short)4);
    private static final TField OBJECT_ID_STR_FIELD_DESC = new TField("objectIdStr", (byte)11, (short)7);
    private static final TStruct STRUCT_DESC = new TStruct("SimpleEvent");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)1);
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)3);
    private static final TField USER_ID_STR_FIELD_DESC = new TField("userIdStr", (byte)11, (short)6);
    private static final int __OBJECTID_ISSET_ID = 2;
    private static final int __TIME_ISSET_ID = 0;
    private static final int __USERID_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public Map auxData;
    public EventType eventType;
    public long objectId;
    public String objectIdStr;
    public long time;
    public long userId;
    public String userIdStr;

    public SimpleEvent()
    {
        __isset_bitfield = 0;
        auxData = new HashMap();
    }

    public SimpleEvent(long l, EventType eventtype, long l1, long l2, 
            Map map)
    {
        this();
        time = l;
        setTimeIsSet(true);
        eventType = eventtype;
        userId = l1;
        setUserIdIsSet(true);
        objectId = l2;
        setObjectIdIsSet(true);
        auxData = map;
    }

    public SimpleEvent(SimpleEvent simpleevent)
    {
        __isset_bitfield = 0;
        __isset_bitfield = simpleevent.__isset_bitfield;
        time = simpleevent.time;
        if (simpleevent.isSetEventType())
        {
            eventType = simpleevent.eventType;
        }
        userId = simpleevent.userId;
        objectId = simpleevent.objectId;
        if (simpleevent.isSetAuxData())
        {
            auxData = new HashMap(simpleevent.auxData);
        }
        if (simpleevent.isSetUserIdStr())
        {
            userIdStr = simpleevent.userIdStr;
        }
        if (simpleevent.isSetObjectIdStr())
        {
            objectIdStr = simpleevent.objectIdStr;
        }
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
        setTimeIsSet(false);
        time = 0L;
        eventType = null;
        setUserIdIsSet(false);
        userId = 0L;
        setObjectIdIsSet(false);
        objectId = 0L;
        auxData = new HashMap();
        userIdStr = null;
        objectIdStr = null;
    }

    public int compareTo(SimpleEvent simpleevent)
    {
        if (getClass().equals(simpleevent.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(simpleevent.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(simpleevent.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, simpleevent.time);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetEventType()).compareTo(Boolean.valueOf(simpleevent.isSetEventType()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetEventType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(eventType, simpleevent.eventType);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(simpleevent.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, simpleevent.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetObjectId()).compareTo(Boolean.valueOf(simpleevent.isSetObjectId()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetObjectId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectId, simpleevent.objectId);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetAuxData()).compareTo(Boolean.valueOf(simpleevent.isSetAuxData()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetAuxData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(auxData, simpleevent.auxData);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetUserIdStr()).compareTo(Boolean.valueOf(simpleevent.isSetUserIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetUserIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userIdStr, simpleevent.userIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetObjectIdStr()).compareTo(Boolean.valueOf(simpleevent.isSetObjectIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetObjectIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectIdStr, simpleevent.objectIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SimpleEvent)obj);
    }

    public SimpleEvent deepCopy()
    {
        return new SimpleEvent(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(SimpleEvent simpleevent)
    {
        if (simpleevent != null && time == simpleevent.time)
        {
            boolean flag = isSetEventType();
            boolean flag4 = simpleevent.isSetEventType();
            if ((!flag && !flag4 || flag && flag4 && eventType.equals(simpleevent.eventType)) && userId == simpleevent.userId && objectId == simpleevent.objectId)
            {
                boolean flag1 = isSetAuxData();
                boolean flag5 = simpleevent.isSetAuxData();
                if (!flag1 && !flag5 || flag1 && flag5 && auxData.equals(simpleevent.auxData))
                {
                    boolean flag2 = isSetUserIdStr();
                    boolean flag6 = simpleevent.isSetUserIdStr();
                    if (!flag2 && !flag6 || flag2 && flag6 && userIdStr.equals(simpleevent.userIdStr))
                    {
                        boolean flag3 = isSetObjectIdStr();
                        boolean flag7 = simpleevent.isSetObjectIdStr();
                        if (!flag3 && !flag7 || flag3 && flag7 && objectIdStr.equals(simpleevent.objectIdStr))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof SimpleEvent)) 
        {
            return false;
        }
        return equals((SimpleEvent)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public Map getAuxData()
    {
        return auxData;
    }

    public int getAuxDataSize()
    {
        if (auxData == null)
        {
            return 0;
        } else
        {
            return auxData.size();
        }
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SimpleEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getTime());

        case 2: // '\002'
            return getEventType();

        case 3: // '\003'
            return Long.valueOf(getUserId());

        case 4: // '\004'
            return Long.valueOf(getObjectId());

        case 5: // '\005'
            return getAuxData();

        case 6: // '\006'
            return getUserIdStr();

        case 7: // '\007'
            return getObjectIdStr();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public long getObjectId()
    {
        return objectId;
    }

    public String getObjectIdStr()
    {
        return objectIdStr;
    }

    public long getTime()
    {
        return time;
    }

    public long getUserId()
    {
        return userId;
    }

    public String getUserIdStr()
    {
        return userIdStr;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        boolean flag = isSetEventType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(eventType.getValue()));
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(userId));
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(objectId));
        flag = isSetAuxData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(auxData);
        }
        flag = isSetUserIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(userIdStr);
        }
        flag = isSetObjectIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(objectIdStr);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SimpleEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTime();

        case 2: // '\002'
            return isSetEventType();

        case 3: // '\003'
            return isSetUserId();

        case 4: // '\004'
            return isSetObjectId();

        case 5: // '\005'
            return isSetAuxData();

        case 6: // '\006'
            return isSetUserIdStr();

        case 7: // '\007'
            return isSetObjectIdStr();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAuxData()
    {
        return auxData != null;
    }

    public boolean isSetEventType()
    {
        return eventType != null;
    }

    public boolean isSetObjectId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetObjectIdStr()
    {
        return objectIdStr != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetUserIdStr()
    {
        return userIdStr != null;
    }

    public void putToAuxData(String s, String s1)
    {
        if (auxData == null)
        {
            auxData = new HashMap();
        }
        auxData.put(s, s1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public SimpleEvent setAuxData(Map map)
    {
        auxData = map;
        return this;
    }

    public void setAuxDataIsSet(boolean flag)
    {
        if (!flag)
        {
            auxData = null;
        }
    }

    public SimpleEvent setEventType(EventType eventtype)
    {
        eventType = eventtype;
        return this;
    }

    public void setEventTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            eventType = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SimpleEvent._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetEventType();
                return;
            } else
            {
                setEventType((EventType)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetUserId();
                return;
            } else
            {
                setUserId(((Long)obj).longValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetObjectId();
                return;
            } else
            {
                setObjectId(((Long)obj).longValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetAuxData();
                return;
            } else
            {
                setAuxData((Map)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetUserIdStr();
                return;
            } else
            {
                setUserIdStr((String)obj);
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetObjectIdStr();
            return;
        } else
        {
            setObjectIdStr((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public SimpleEvent setObjectId(long l)
    {
        objectId = l;
        setObjectIdIsSet(true);
        return this;
    }

    public void setObjectIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public SimpleEvent setObjectIdStr(String s)
    {
        objectIdStr = s;
        return this;
    }

    public void setObjectIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            objectIdStr = null;
        }
    }

    public SimpleEvent setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public SimpleEvent setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public SimpleEvent setUserIdStr(String s)
    {
        userIdStr = s;
        return this;
    }

    public void setUserIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            userIdStr = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("SimpleEvent(");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        stringbuilder.append(", ");
        stringbuilder.append("eventType:");
        if (eventType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(eventType);
        }
        stringbuilder.append(", ");
        stringbuilder.append("userId:");
        stringbuilder.append(userId);
        stringbuilder.append(", ");
        stringbuilder.append("objectId:");
        stringbuilder.append(objectId);
        stringbuilder.append(", ");
        stringbuilder.append("auxData:");
        if (auxData == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(auxData);
        }
        if (isSetUserIdStr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userIdStr:");
            if (userIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(userIdStr);
            }
        }
        if (isSetObjectIdStr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("objectIdStr:");
            if (objectIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objectIdStr);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAuxData()
    {
        auxData = null;
    }

    public void unsetEventType()
    {
        eventType = null;
    }

    public void unsetObjectId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetObjectIdStr()
    {
        objectIdStr = null;
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetUserIdStr()
    {
        userIdStr = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new SimpleEventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new SimpleEventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.USER_ID_STR, _Fields.OBJECT_ID_STR
        });
        obj = new EnumMap(com/pinterest/schemas/event/SimpleEvent$_Fields);
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.EVENT_TYPE, new FieldMetaData("eventType", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/EventType)));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.OBJECT_ID, new FieldMetaData("objectId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.AUX_DATA, new FieldMetaData("auxData", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.USER_ID_STR, new FieldMetaData("userIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.OBJECT_ID_STR, new FieldMetaData("objectIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/SimpleEvent, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields AUX_DATA;
        public static final _Fields EVENT_TYPE;
        public static final _Fields OBJECT_ID;
        public static final _Fields OBJECT_ID_STR;
        public static final _Fields TIME;
        public static final _Fields USER_ID;
        public static final _Fields USER_ID_STR;
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
                return TIME;

            case 2: // '\002'
                return EVENT_TYPE;

            case 3: // '\003'
                return USER_ID;

            case 4: // '\004'
                return OBJECT_ID;

            case 5: // '\005'
                return AUX_DATA;

            case 6: // '\006'
                return USER_ID_STR;

            case 7: // '\007'
                return OBJECT_ID_STR;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/SimpleEvent$_Fields, s);
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
            TIME = new _Fields("TIME", 0, (short)1, "time");
            EVENT_TYPE = new _Fields("EVENT_TYPE", 1, (short)2, "eventType");
            USER_ID = new _Fields("USER_ID", 2, (short)3, "userId");
            OBJECT_ID = new _Fields("OBJECT_ID", 3, (short)4, "objectId");
            AUX_DATA = new _Fields("AUX_DATA", 4, (short)5, "auxData");
            USER_ID_STR = new _Fields("USER_ID_STR", 5, (short)6, "userIdStr");
            OBJECT_ID_STR = new _Fields("OBJECT_ID_STR", 6, (short)7, "objectIdStr");
            $VALUES = (new _Fields[] {
                TIME, EVENT_TYPE, USER_ID, OBJECT_ID, AUX_DATA, USER_ID_STR, OBJECT_ID_STR
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/SimpleEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.TIME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.EVENT_TYPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.USER_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.OBJECT_ID.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.AUX_DATA.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.USER_ID_STR.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SimpleEvent$_Fields[_Fields.OBJECT_ID_STR.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class SimpleEventStandardSchemeFactory
        implements SchemeFactory
    {

        public SimpleEventStandardScheme getScheme()
        {
            return new SimpleEventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SimpleEventStandardSchemeFactory()
        {
        }

        SimpleEventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SimpleEventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, SimpleEvent simpleevent)
            {
                tprotocol.readStructBegin();
_L10:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_399;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 115
            //                           3 154
            //                           4 190
            //                           5 226
            //                           6 327
            //                           7 363;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_363;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L11:
                tprotocol.readFieldEnd();
                if (true) goto _L10; else goto _L9
_L9:
                if (((TField) (obj)).type == 10)
                {
                    simpleevent.time = tprotocol.readI64();
                    simpleevent.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L3:
                if (((TField) (obj)).type == 8)
                {
                    simpleevent.eventType = EventType.findByValue(tprotocol.readI32());
                    simpleevent.setEventTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L4:
                if (((TField) (obj)).type == 10)
                {
                    simpleevent.userId = tprotocol.readI64();
                    simpleevent.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L5:
                if (((TField) (obj)).type == 10)
                {
                    simpleevent.objectId = tprotocol.readI64();
                    simpleevent.setObjectIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L6:
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    simpleevent.auxData = new HashMap(((TMap) (obj)).size * 2);
                    for (int i = 0; i < ((TMap) (obj)).size; i++)
                    {
                        String s = tprotocol.readString();
                        String s1 = tprotocol.readString();
                        simpleevent.auxData.put(s, s1);
                    }

                    tprotocol.readMapEnd();
                    simpleevent.setAuxDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L7:
                if (((TField) (obj)).type == 11)
                {
                    simpleevent.userIdStr = tprotocol.readString();
                    simpleevent.setUserIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                if (((TField) (obj)).type == 11)
                {
                    simpleevent.objectIdStr = tprotocol.readString();
                    simpleevent.setObjectIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                simpleevent.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SimpleEvent)tbase);
            }

            public void write(TProtocol tprotocol, SimpleEvent simpleevent)
            {
                simpleevent.validate();
                tprotocol.writeStructBegin(SimpleEvent.STRUCT_DESC);
                tprotocol.writeFieldBegin(SimpleEvent.TIME_FIELD_DESC);
                tprotocol.writeI64(simpleevent.time);
                tprotocol.writeFieldEnd();
                if (simpleevent.eventType != null)
                {
                    tprotocol.writeFieldBegin(SimpleEvent.EVENT_TYPE_FIELD_DESC);
                    tprotocol.writeI32(simpleevent.eventType.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(SimpleEvent.USER_ID_FIELD_DESC);
                tprotocol.writeI64(simpleevent.userId);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldBegin(SimpleEvent.OBJECT_ID_FIELD_DESC);
                tprotocol.writeI64(simpleevent.objectId);
                tprotocol.writeFieldEnd();
                if (simpleevent.auxData != null)
                {
                    tprotocol.writeFieldBegin(SimpleEvent.AUX_DATA_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, simpleevent.auxData.size()));
                    java.util.Map.Entry entry;
                    for (Iterator iterator = simpleevent.auxData.entrySet().iterator(); iterator.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                if (simpleevent.userIdStr != null && simpleevent.isSetUserIdStr())
                {
                    tprotocol.writeFieldBegin(SimpleEvent.USER_ID_STR_FIELD_DESC);
                    tprotocol.writeString(simpleevent.userIdStr);
                    tprotocol.writeFieldEnd();
                }
                if (simpleevent.objectIdStr != null && simpleevent.isSetObjectIdStr())
                {
                    tprotocol.writeFieldBegin(SimpleEvent.OBJECT_ID_STR_FIELD_DESC);
                    tprotocol.writeString(simpleevent.objectIdStr);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SimpleEvent)tbase);
            }

            private SimpleEventStandardScheme()
            {
            }

            SimpleEventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class SimpleEventTupleSchemeFactory
        implements SchemeFactory
    {

        public SimpleEventTupleScheme getScheme()
        {
            return new SimpleEventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SimpleEventTupleSchemeFactory()
        {
        }

        SimpleEventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SimpleEventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, SimpleEvent simpleevent)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    simpleevent.time = tprotocol.readI64();
                    simpleevent.setTimeIsSet(true);
                }
                if (bitset.get(1))
                {
                    simpleevent.eventType = EventType.findByValue(tprotocol.readI32());
                    simpleevent.setEventTypeIsSet(true);
                }
                if (bitset.get(2))
                {
                    simpleevent.userId = tprotocol.readI64();
                    simpleevent.setUserIdIsSet(true);
                }
                if (bitset.get(3))
                {
                    simpleevent.objectId = tprotocol.readI64();
                    simpleevent.setObjectIdIsSet(true);
                }
                if (bitset.get(4))
                {
                    TMap tmap = new TMap((byte)11, (byte)11, tprotocol.readI32());
                    simpleevent.auxData = new HashMap(tmap.size * 2);
                    for (; i < tmap.size; i++)
                    {
                        String s = tprotocol.readString();
                        String s1 = tprotocol.readString();
                        simpleevent.auxData.put(s, s1);
                    }

                    simpleevent.setAuxDataIsSet(true);
                }
                if (bitset.get(5))
                {
                    simpleevent.userIdStr = tprotocol.readString();
                    simpleevent.setUserIdStrIsSet(true);
                }
                if (bitset.get(6))
                {
                    simpleevent.objectIdStr = tprotocol.readString();
                    simpleevent.setObjectIdStrIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SimpleEvent)tbase);
            }

            public void write(TProtocol tprotocol, SimpleEvent simpleevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (simpleevent.isSetTime())
                {
                    bitset.set(0);
                }
                if (simpleevent.isSetEventType())
                {
                    bitset.set(1);
                }
                if (simpleevent.isSetUserId())
                {
                    bitset.set(2);
                }
                if (simpleevent.isSetObjectId())
                {
                    bitset.set(3);
                }
                if (simpleevent.isSetAuxData())
                {
                    bitset.set(4);
                }
                if (simpleevent.isSetUserIdStr())
                {
                    bitset.set(5);
                }
                if (simpleevent.isSetObjectIdStr())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (simpleevent.isSetTime())
                {
                    tprotocol.writeI64(simpleevent.time);
                }
                if (simpleevent.isSetEventType())
                {
                    tprotocol.writeI32(simpleevent.eventType.getValue());
                }
                if (simpleevent.isSetUserId())
                {
                    tprotocol.writeI64(simpleevent.userId);
                }
                if (simpleevent.isSetObjectId())
                {
                    tprotocol.writeI64(simpleevent.objectId);
                }
                if (simpleevent.isSetAuxData())
                {
                    tprotocol.writeI32(simpleevent.auxData.size());
                    java.util.Map.Entry entry;
                    for (Iterator iterator = simpleevent.auxData.entrySet().iterator(); iterator.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                }
                if (simpleevent.isSetUserIdStr())
                {
                    tprotocol.writeString(simpleevent.userIdStr);
                }
                if (simpleevent.isSetObjectIdStr())
                {
                    tprotocol.writeString(simpleevent.objectIdStr);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SimpleEvent)tbase);
            }

            private SimpleEventTupleScheme()
            {
            }

            SimpleEventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
