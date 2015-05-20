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

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationObjectType

public class RecommendationObject
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField OBJECT_ID_FIELD_DESC = new TField("objectId", (byte)10, (short)1);
    private static final TField OBJECT_TYPE_FIELD_DESC = new TField("objectType", (byte)8, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("RecommendationObject");
    private static final int __OBJECTID_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public long objectId;
    public RecommendationObjectType objectType;

    public RecommendationObject()
    {
        __isset_bitfield = 0;
    }

    public RecommendationObject(long l, RecommendationObjectType recommendationobjecttype)
    {
        this();
        objectId = l;
        setObjectIdIsSet(true);
        objectType = recommendationobjecttype;
    }

    public RecommendationObject(RecommendationObject recommendationobject)
    {
        __isset_bitfield = 0;
        __isset_bitfield = recommendationobject.__isset_bitfield;
        objectId = recommendationobject.objectId;
        if (recommendationobject.isSetObjectType())
        {
            objectType = recommendationobject.objectType;
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
        setObjectIdIsSet(false);
        objectId = 0L;
        objectType = null;
    }

    public int compareTo(RecommendationObject recommendationobject)
    {
        if (getClass().equals(recommendationobject.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(recommendationobject.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetObjectId()).compareTo(Boolean.valueOf(recommendationobject.isSetObjectId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetObjectId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectId, recommendationobject.objectId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetObjectType()).compareTo(Boolean.valueOf(recommendationobject.isSetObjectType()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetObjectType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectType, recommendationobject.objectType);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RecommendationObject)obj);
    }

    public RecommendationObject deepCopy()
    {
        return new RecommendationObject(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RecommendationObject recommendationobject)
    {
        if (recommendationobject != null && objectId == recommendationobject.objectId)
        {
            boolean flag = isSetObjectType();
            boolean flag1 = recommendationobject.isSetObjectType();
            if (!flag && !flag1 || flag && flag1 && objectType.equals(recommendationobject.objectType))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof RecommendationObject)) 
        {
            return false;
        }
        return equals((RecommendationObject)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationObject._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getObjectId());

        case 2: // '\002'
            return getObjectType();
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

    public RecommendationObjectType getObjectType()
    {
        return objectType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(objectId));
        boolean flag = isSetObjectType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(objectType.getValue()));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationObject._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetObjectId();

        case 2: // '\002'
            return isSetObjectType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetObjectId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetObjectType()
    {
        return objectType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationObject._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetObjectId();
                return;
            } else
            {
                setObjectId(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetObjectType();
            return;
        } else
        {
            setObjectType((RecommendationObjectType)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RecommendationObject setObjectId(long l)
    {
        objectId = l;
        setObjectIdIsSet(true);
        return this;
    }

    public void setObjectIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public RecommendationObject setObjectType(RecommendationObjectType recommendationobjecttype)
    {
        objectType = recommendationobjecttype;
        return this;
    }

    public void setObjectTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            objectType = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("RecommendationObject(");
        stringbuilder.append("objectId:");
        stringbuilder.append(objectId);
        stringbuilder.append(", ");
        stringbuilder.append("objectType:");
        if (objectType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(objectType);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetObjectId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetObjectType()
    {
        objectType = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RecommendationObjectStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RecommendationObjectTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/email_queued/RecommendationObject$_Fields);
        ((Map) (obj)).put(_Fields.OBJECT_ID, new FieldMetaData("objectId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.OBJECT_TYPE, new FieldMetaData("objectType", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/email_queued/RecommendationObjectType)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/RecommendationObject, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields OBJECT_ID;
        public static final _Fields OBJECT_TYPE;
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
                return OBJECT_ID;

            case 2: // '\002'
                return OBJECT_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationObject$_Fields, s);
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
            OBJECT_ID = new _Fields("OBJECT_ID", 0, (short)1, "objectId");
            OBJECT_TYPE = new _Fields("OBJECT_TYPE", 1, (short)2, "objectType");
            $VALUES = (new _Fields[] {
                OBJECT_ID, OBJECT_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationObject$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$RecommendationObject$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$RecommendationObject$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationObject$_Fields[_Fields.OBJECT_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationObject$_Fields[_Fields.OBJECT_TYPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RecommendationObjectStandardSchemeFactory
        implements SchemeFactory
    {

        public RecommendationObjectStandardScheme getScheme()
        {
            return new RecommendationObjectStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationObjectStandardSchemeFactory()
        {
        }

        RecommendationObjectStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationObjectStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RecommendationObject recommendationobject)
            {
                tprotocol.readStructBegin();
_L2:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_134;
                }
                switch (tfield.id)
                {
                default:
                    TProtocolUtil.skip(tprotocol, tfield.type);
                    break;

                case 1: // '\001'
                    break; /* Loop/switch isn't completed */

                case 2: // '\002'
                    break MISSING_BLOCK_LABEL_95;
                }
_L3:
                tprotocol.readFieldEnd();
                if (true) goto _L2; else goto _L1
_L1:
                if (tfield.type == 10)
                {
                    recommendationobject.objectId = tprotocol.readI64();
                    recommendationobject.setObjectIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                if (tfield.type == 8)
                {
                    recommendationobject.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    recommendationobject.setObjectTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                recommendationobject.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationObject)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationObject recommendationobject)
            {
                recommendationobject.validate();
                tprotocol.writeStructBegin(RecommendationObject.STRUCT_DESC);
                tprotocol.writeFieldBegin(RecommendationObject.OBJECT_ID_FIELD_DESC);
                tprotocol.writeI64(recommendationobject.objectId);
                tprotocol.writeFieldEnd();
                if (recommendationobject.objectType != null)
                {
                    tprotocol.writeFieldBegin(RecommendationObject.OBJECT_TYPE_FIELD_DESC);
                    tprotocol.writeI32(recommendationobject.objectType.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationObject)tbase);
            }

            private RecommendationObjectStandardScheme()
            {
            }

            RecommendationObjectStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RecommendationObjectTupleSchemeFactory
        implements SchemeFactory
    {

        public RecommendationObjectTupleScheme getScheme()
        {
            return new RecommendationObjectTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationObjectTupleSchemeFactory()
        {
        }

        RecommendationObjectTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationObjectTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RecommendationObject recommendationobject)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    recommendationobject.objectId = tprotocol.readI64();
                    recommendationobject.setObjectIdIsSet(true);
                }
                if (bitset.get(1))
                {
                    recommendationobject.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    recommendationobject.setObjectTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationObject)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationObject recommendationobject)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (recommendationobject.isSetObjectId())
                {
                    bitset.set(0);
                }
                if (recommendationobject.isSetObjectType())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (recommendationobject.isSetObjectId())
                {
                    tprotocol.writeI64(recommendationobject.objectId);
                }
                if (recommendationobject.isSetObjectType())
                {
                    tprotocol.writeI32(recommendationobject.objectType.getValue());
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationObject)tbase);
            }

            private RecommendationObjectTupleScheme()
            {
            }

            RecommendationObjectTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
