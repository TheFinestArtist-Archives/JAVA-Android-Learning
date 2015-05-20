// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

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

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationTriggerType, RecommendationObjectType

public class RecommendationTriggerEvent
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TStruct STRUCT_DESC = new TStruct("RecommendationTriggerEvent");
    private static final TField TRIGGER_OBJECT_ID_STR_FIELD_DESC = new TField("triggerObjectIdStr", (byte)11, (short)2);
    private static final TField TRIGGER_OBJECT_TYPE_FIELD_DESC = new TField("triggerObjectType", (byte)8, (short)3);
    private static final TField TRIGGER_TYPE_FIELD_DESC = new TField("triggerType", (byte)8, (short)1);
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public String triggerObjectIdStr;
    public RecommendationObjectType triggerObjectType;
    public RecommendationTriggerType triggerType;

    public RecommendationTriggerEvent()
    {
    }

    public RecommendationTriggerEvent(RecommendationTriggerEvent recommendationtriggerevent)
    {
        if (recommendationtriggerevent.isSetTriggerType())
        {
            triggerType = recommendationtriggerevent.triggerType;
        }
        if (recommendationtriggerevent.isSetTriggerObjectIdStr())
        {
            triggerObjectIdStr = recommendationtriggerevent.triggerObjectIdStr;
        }
        if (recommendationtriggerevent.isSetTriggerObjectType())
        {
            triggerObjectType = recommendationtriggerevent.triggerObjectType;
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        try
        {
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
        triggerType = null;
        triggerObjectIdStr = null;
        triggerObjectType = null;
    }

    public int compareTo(RecommendationTriggerEvent recommendationtriggerevent)
    {
        if (getClass().equals(recommendationtriggerevent.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(recommendationtriggerevent.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTriggerType()).compareTo(Boolean.valueOf(recommendationtriggerevent.isSetTriggerType()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTriggerType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(triggerType, recommendationtriggerevent.triggerType);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetTriggerObjectIdStr()).compareTo(Boolean.valueOf(recommendationtriggerevent.isSetTriggerObjectIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetTriggerObjectIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(triggerObjectIdStr, recommendationtriggerevent.triggerObjectIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetTriggerObjectType()).compareTo(Boolean.valueOf(recommendationtriggerevent.isSetTriggerObjectType()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetTriggerObjectType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(triggerObjectType, recommendationtriggerevent.triggerObjectType);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RecommendationTriggerEvent)obj);
    }

    public RecommendationTriggerEvent deepCopy()
    {
        return new RecommendationTriggerEvent(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RecommendationTriggerEvent recommendationtriggerevent)
    {
        if (recommendationtriggerevent != null)
        {
            boolean flag = isSetTriggerType();
            boolean flag3 = recommendationtriggerevent.isSetTriggerType();
            if (!flag && !flag3 || flag && flag3 && triggerType.equals(recommendationtriggerevent.triggerType))
            {
                boolean flag1 = isSetTriggerObjectIdStr();
                boolean flag4 = recommendationtriggerevent.isSetTriggerObjectIdStr();
                if (!flag1 && !flag4 || flag1 && flag4 && triggerObjectIdStr.equals(recommendationtriggerevent.triggerObjectIdStr))
                {
                    boolean flag2 = isSetTriggerObjectType();
                    boolean flag5 = recommendationtriggerevent.isSetTriggerObjectType();
                    if (!flag2 && !flag5 || flag2 && flag5 && triggerObjectType.equals(recommendationtriggerevent.triggerObjectType))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof RecommendationTriggerEvent)) 
        {
            return false;
        }
        return equals((RecommendationTriggerEvent)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationTriggerEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getTriggerType();

        case 2: // '\002'
            return getTriggerObjectIdStr();

        case 3: // '\003'
            return getTriggerObjectType();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getTriggerObjectIdStr()
    {
        return triggerObjectIdStr;
    }

    public RecommendationObjectType getTriggerObjectType()
    {
        return triggerObjectType;
    }

    public RecommendationTriggerType getTriggerType()
    {
        return triggerType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetTriggerType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(triggerType.getValue()));
        }
        flag = isSetTriggerObjectIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(triggerObjectIdStr);
        }
        flag = isSetTriggerObjectType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(triggerObjectType.getValue()));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationTriggerEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTriggerType();

        case 2: // '\002'
            return isSetTriggerObjectIdStr();

        case 3: // '\003'
            return isSetTriggerObjectType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetTriggerObjectIdStr()
    {
        return triggerObjectIdStr != null;
    }

    public boolean isSetTriggerObjectType()
    {
        return triggerObjectType != null;
    }

    public boolean isSetTriggerType()
    {
        return triggerType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationTriggerEvent._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTriggerType();
                return;
            } else
            {
                setTriggerType((RecommendationTriggerType)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetTriggerObjectIdStr();
                return;
            } else
            {
                setTriggerObjectIdStr((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetTriggerObjectType();
            return;
        } else
        {
            setTriggerObjectType((RecommendationObjectType)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RecommendationTriggerEvent setTriggerObjectIdStr(String s)
    {
        triggerObjectIdStr = s;
        return this;
    }

    public void setTriggerObjectIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            triggerObjectIdStr = null;
        }
    }

    public RecommendationTriggerEvent setTriggerObjectType(RecommendationObjectType recommendationobjecttype)
    {
        triggerObjectType = recommendationobjecttype;
        return this;
    }

    public void setTriggerObjectTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            triggerObjectType = null;
        }
    }

    public RecommendationTriggerEvent setTriggerType(RecommendationTriggerType recommendationtriggertype)
    {
        triggerType = recommendationtriggertype;
        return this;
    }

    public void setTriggerTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            triggerType = null;
        }
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("RecommendationTriggerEvent(");
        boolean flag = true;
        if (isSetTriggerType())
        {
            stringbuilder.append("triggerType:");
            if (triggerType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(triggerType);
            }
            flag = false;
        }
        if (isSetTriggerObjectIdStr())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("triggerObjectIdStr:");
            if (triggerObjectIdStr == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(triggerObjectIdStr);
                flag = flag1;
            }
        }
        if (isSetTriggerObjectType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("triggerObjectType:");
            if (triggerObjectType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(triggerObjectType);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetTriggerObjectIdStr()
    {
        triggerObjectIdStr = null;
    }

    public void unsetTriggerObjectType()
    {
        triggerObjectType = null;
    }

    public void unsetTriggerType()
    {
        triggerType = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RecommendationTriggerEventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RecommendationTriggerEventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.TRIGGER_TYPE, _Fields.TRIGGER_OBJECT_ID_STR, _Fields.TRIGGER_OBJECT_TYPE
        });
        obj = new EnumMap(com/pinterest/schemas/email_queued/RecommendationTriggerEvent$_Fields);
        ((Map) (obj)).put(_Fields.TRIGGER_TYPE, new FieldMetaData("triggerType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/email_queued/RecommendationTriggerType)));
        ((Map) (obj)).put(_Fields.TRIGGER_OBJECT_ID_STR, new FieldMetaData("triggerObjectIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TRIGGER_OBJECT_TYPE, new FieldMetaData("triggerObjectType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/email_queued/RecommendationObjectType)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/RecommendationTriggerEvent, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields TRIGGER_OBJECT_ID_STR;
        public static final _Fields TRIGGER_OBJECT_TYPE;
        public static final _Fields TRIGGER_TYPE;
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
                return TRIGGER_TYPE;

            case 2: // '\002'
                return TRIGGER_OBJECT_ID_STR;

            case 3: // '\003'
                return TRIGGER_OBJECT_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationTriggerEvent$_Fields, s);
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
            TRIGGER_TYPE = new _Fields("TRIGGER_TYPE", 0, (short)1, "triggerType");
            TRIGGER_OBJECT_ID_STR = new _Fields("TRIGGER_OBJECT_ID_STR", 1, (short)2, "triggerObjectIdStr");
            TRIGGER_OBJECT_TYPE = new _Fields("TRIGGER_OBJECT_TYPE", 2, (short)3, "triggerObjectType");
            $VALUES = (new _Fields[] {
                TRIGGER_TYPE, TRIGGER_OBJECT_ID_STR, TRIGGER_OBJECT_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationTriggerEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$RecommendationTriggerEvent$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$RecommendationTriggerEvent$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationTriggerEvent$_Fields[_Fields.TRIGGER_TYPE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationTriggerEvent$_Fields[_Fields.TRIGGER_OBJECT_ID_STR.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationTriggerEvent$_Fields[_Fields.TRIGGER_OBJECT_TYPE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RecommendationTriggerEventStandardSchemeFactory
        implements SchemeFactory
    {

        public RecommendationTriggerEventStandardScheme getScheme()
        {
            return new RecommendationTriggerEventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationTriggerEventStandardSchemeFactory()
        {
        }

        RecommendationTriggerEventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationTriggerEventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
            {
                tprotocol.readStructBegin();
_L6:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_177;
                }
                tfield.id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 102
            //                           3 138;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_138;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (tfield.type == 8)
                {
                    recommendationtriggerevent.triggerType = RecommendationTriggerType.findByValue(tprotocol.readI32());
                    recommendationtriggerevent.setTriggerTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 11)
                {
                    recommendationtriggerevent.triggerObjectIdStr = tprotocol.readString();
                    recommendationtriggerevent.setTriggerObjectIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 8)
                {
                    recommendationtriggerevent.triggerObjectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    recommendationtriggerevent.setTriggerObjectTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                recommendationtriggerevent.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationTriggerEvent)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
            {
                recommendationtriggerevent.validate();
                tprotocol.writeStructBegin(RecommendationTriggerEvent.STRUCT_DESC);
                if (recommendationtriggerevent.triggerType != null && recommendationtriggerevent.isSetTriggerType())
                {
                    tprotocol.writeFieldBegin(RecommendationTriggerEvent.TRIGGER_TYPE_FIELD_DESC);
                    tprotocol.writeI32(recommendationtriggerevent.triggerType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (recommendationtriggerevent.triggerObjectIdStr != null && recommendationtriggerevent.isSetTriggerObjectIdStr())
                {
                    tprotocol.writeFieldBegin(RecommendationTriggerEvent.TRIGGER_OBJECT_ID_STR_FIELD_DESC);
                    tprotocol.writeString(recommendationtriggerevent.triggerObjectIdStr);
                    tprotocol.writeFieldEnd();
                }
                if (recommendationtriggerevent.triggerObjectType != null && recommendationtriggerevent.isSetTriggerObjectType())
                {
                    tprotocol.writeFieldBegin(RecommendationTriggerEvent.TRIGGER_OBJECT_TYPE_FIELD_DESC);
                    tprotocol.writeI32(recommendationtriggerevent.triggerObjectType.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationTriggerEvent)tbase);
            }

            private RecommendationTriggerEventStandardScheme()
            {
            }

            RecommendationTriggerEventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RecommendationTriggerEventTupleSchemeFactory
        implements SchemeFactory
    {

        public RecommendationTriggerEventTupleScheme getScheme()
        {
            return new RecommendationTriggerEventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationTriggerEventTupleSchemeFactory()
        {
        }

        RecommendationTriggerEventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationTriggerEventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    recommendationtriggerevent.triggerType = RecommendationTriggerType.findByValue(tprotocol.readI32());
                    recommendationtriggerevent.setTriggerTypeIsSet(true);
                }
                if (bitset.get(1))
                {
                    recommendationtriggerevent.triggerObjectIdStr = tprotocol.readString();
                    recommendationtriggerevent.setTriggerObjectIdStrIsSet(true);
                }
                if (bitset.get(2))
                {
                    recommendationtriggerevent.triggerObjectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    recommendationtriggerevent.setTriggerObjectTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationTriggerEvent)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationTriggerEvent recommendationtriggerevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (recommendationtriggerevent.isSetTriggerType())
                {
                    bitset.set(0);
                }
                if (recommendationtriggerevent.isSetTriggerObjectIdStr())
                {
                    bitset.set(1);
                }
                if (recommendationtriggerevent.isSetTriggerObjectType())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (recommendationtriggerevent.isSetTriggerType())
                {
                    tprotocol.writeI32(recommendationtriggerevent.triggerType.getValue());
                }
                if (recommendationtriggerevent.isSetTriggerObjectIdStr())
                {
                    tprotocol.writeString(recommendationtriggerevent.triggerObjectIdStr);
                }
                if (recommendationtriggerevent.isSetTriggerObjectType())
                {
                    tprotocol.writeI32(recommendationtriggerevent.triggerObjectType.getValue());
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationTriggerEvent)tbase);
            }

            private RecommendationTriggerEventTupleScheme()
            {
            }

            RecommendationTriggerEventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
