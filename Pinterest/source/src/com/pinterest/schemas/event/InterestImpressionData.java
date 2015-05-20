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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
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
//            InterestImpression

public class InterestImpressionData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BLEND_TYPE_FIELD_DESC = new TField("blendType", (byte)11, (short)3);
    private static final TField INTEREST_IMPRESSIONS_FIELD_DESC = new TField("interestImpressions", (byte)15, (short)1);
    private static final TField ORDER_TYPE_FIELD_DESC = new TField("orderType", (byte)11, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("InterestImpressionData");
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public String blendType;
    public List interestImpressions;
    public String orderType;

    public InterestImpressionData()
    {
    }

    public InterestImpressionData(InterestImpressionData interestimpressiondata)
    {
        if (interestimpressiondata.isSetInterestImpressions())
        {
            ArrayList arraylist = new ArrayList(interestimpressiondata.interestImpressions.size());
            for (Iterator iterator = interestimpressiondata.interestImpressions.iterator(); iterator.hasNext(); arraylist.add(new InterestImpression((InterestImpression)iterator.next()))) { }
            interestImpressions = arraylist;
        }
        if (interestimpressiondata.isSetOrderType())
        {
            orderType = interestimpressiondata.orderType;
        }
        if (interestimpressiondata.isSetBlendType())
        {
            blendType = interestimpressiondata.blendType;
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

    public void addToInterestImpressions(InterestImpression interestimpression)
    {
        if (interestImpressions == null)
        {
            interestImpressions = new ArrayList();
        }
        interestImpressions.add(interestimpression);
    }

    public void clear()
    {
        interestImpressions = null;
        orderType = null;
        blendType = null;
    }

    public int compareTo(InterestImpressionData interestimpressiondata)
    {
        if (getClass().equals(interestimpressiondata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(interestimpressiondata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetInterestImpressions()).compareTo(Boolean.valueOf(interestimpressiondata.isSetInterestImpressions()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetInterestImpressions())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(interestImpressions, interestimpressiondata.interestImpressions);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetOrderType()).compareTo(Boolean.valueOf(interestimpressiondata.isSetOrderType()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetOrderType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(orderType, interestimpressiondata.orderType);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetBlendType()).compareTo(Boolean.valueOf(interestimpressiondata.isSetBlendType()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetBlendType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(blendType, interestimpressiondata.blendType);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((InterestImpressionData)obj);
    }

    public InterestImpressionData deepCopy()
    {
        return new InterestImpressionData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(InterestImpressionData interestimpressiondata)
    {
        if (interestimpressiondata != null)
        {
            boolean flag = isSetInterestImpressions();
            boolean flag3 = interestimpressiondata.isSetInterestImpressions();
            if (!flag && !flag3 || flag && flag3 && interestImpressions.equals(interestimpressiondata.interestImpressions))
            {
                boolean flag1 = isSetOrderType();
                boolean flag4 = interestimpressiondata.isSetOrderType();
                if (!flag1 && !flag4 || flag1 && flag4 && orderType.equals(interestimpressiondata.orderType))
                {
                    boolean flag2 = isSetBlendType();
                    boolean flag5 = interestimpressiondata.isSetBlendType();
                    if (!flag2 && !flag5 || flag2 && flag5 && blendType.equals(interestimpressiondata.blendType))
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
        while (obj == null || !(obj instanceof InterestImpressionData)) 
        {
            return false;
        }
        return equals((InterestImpressionData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getBlendType()
    {
        return blendType;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpressionData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getInterestImpressions();

        case 2: // '\002'
            return getOrderType();

        case 3: // '\003'
            return getBlendType();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getInterestImpressions()
    {
        return interestImpressions;
    }

    public Iterator getInterestImpressionsIterator()
    {
        if (interestImpressions == null)
        {
            return null;
        } else
        {
            return interestImpressions.iterator();
        }
    }

    public int getInterestImpressionsSize()
    {
        if (interestImpressions == null)
        {
            return 0;
        } else
        {
            return interestImpressions.size();
        }
    }

    public String getOrderType()
    {
        return orderType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetInterestImpressions();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(interestImpressions);
        }
        flag = isSetOrderType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(orderType);
        }
        flag = isSetBlendType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(blendType);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpressionData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetInterestImpressions();

        case 2: // '\002'
            return isSetOrderType();

        case 3: // '\003'
            return isSetBlendType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBlendType()
    {
        return blendType != null;
    }

    public boolean isSetInterestImpressions()
    {
        return interestImpressions != null;
    }

    public boolean isSetOrderType()
    {
        return orderType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public InterestImpressionData setBlendType(String s)
    {
        blendType = s;
        return this;
    }

    public void setBlendTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            blendType = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpressionData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetInterestImpressions();
                return;
            } else
            {
                setInterestImpressions((List)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetOrderType();
                return;
            } else
            {
                setOrderType((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetBlendType();
            return;
        } else
        {
            setBlendType((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public InterestImpressionData setInterestImpressions(List list)
    {
        interestImpressions = list;
        return this;
    }

    public void setInterestImpressionsIsSet(boolean flag)
    {
        if (!flag)
        {
            interestImpressions = null;
        }
    }

    public InterestImpressionData setOrderType(String s)
    {
        orderType = s;
        return this;
    }

    public void setOrderTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            orderType = null;
        }
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("InterestImpressionData(");
        boolean flag = true;
        if (isSetInterestImpressions())
        {
            stringbuilder.append("interestImpressions:");
            if (interestImpressions == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(interestImpressions);
            }
            flag = false;
        }
        if (isSetOrderType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("orderType:");
            if (orderType == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(orderType);
                flag = flag1;
            }
        }
        if (isSetBlendType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("blendType:");
            if (blendType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(blendType);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBlendType()
    {
        blendType = null;
    }

    public void unsetInterestImpressions()
    {
        interestImpressions = null;
    }

    public void unsetOrderType()
    {
        orderType = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new InterestImpressionDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new InterestImpressionDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.INTEREST_IMPRESSIONS, _Fields.ORDER_TYPE, _Fields.BLEND_TYPE
        });
        obj = new EnumMap(com/pinterest/schemas/event/InterestImpressionData$_Fields);
        ((Map) (obj)).put(_Fields.INTEREST_IMPRESSIONS, new FieldMetaData("interestImpressions", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/InterestImpression))));
        ((Map) (obj)).put(_Fields.ORDER_TYPE, new FieldMetaData("orderType", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.BLEND_TYPE, new FieldMetaData("blendType", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/InterestImpressionData, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BLEND_TYPE;
        public static final _Fields INTEREST_IMPRESSIONS;
        public static final _Fields ORDER_TYPE;
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
                return INTEREST_IMPRESSIONS;

            case 2: // '\002'
                return ORDER_TYPE;

            case 3: // '\003'
                return BLEND_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/InterestImpressionData$_Fields, s);
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
            INTEREST_IMPRESSIONS = new _Fields("INTEREST_IMPRESSIONS", 0, (short)1, "interestImpressions");
            ORDER_TYPE = new _Fields("ORDER_TYPE", 1, (short)2, "orderType");
            BLEND_TYPE = new _Fields("BLEND_TYPE", 2, (short)3, "blendType");
            $VALUES = (new _Fields[] {
                INTEREST_IMPRESSIONS, ORDER_TYPE, BLEND_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/InterestImpressionData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$InterestImpressionData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$InterestImpressionData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpressionData$_Fields[_Fields.INTEREST_IMPRESSIONS.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpressionData$_Fields[_Fields.ORDER_TYPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpressionData$_Fields[_Fields.BLEND_TYPE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class InterestImpressionDataStandardSchemeFactory
        implements SchemeFactory
    {

        public InterestImpressionDataStandardScheme getScheme()
        {
            return new InterestImpressionDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InterestImpressionDataStandardSchemeFactory()
        {
        }

        InterestImpressionDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InterestImpressionDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
            {
                tprotocol.readStructBegin();
_L6:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_235;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 163
            //                           3 199;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_199;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    interestimpressiondata.interestImpressions = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        InterestImpression interestimpression = new InterestImpression();
                        interestimpression.read(tprotocol);
                        interestimpressiondata.interestImpressions.add(interestimpression);
                    }

                    tprotocol.readListEnd();
                    interestimpressiondata.setInterestImpressionsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
_L3:
                if (((TField) (obj)).type == 11)
                {
                    interestimpressiondata.orderType = tprotocol.readString();
                    interestimpressiondata.setOrderTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                if (((TField) (obj)).type == 11)
                {
                    interestimpressiondata.blendType = tprotocol.readString();
                    interestimpressiondata.setBlendTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                interestimpressiondata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InterestImpressionData)tbase);
            }

            public void write(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
            {
                interestimpressiondata.validate();
                tprotocol.writeStructBegin(InterestImpressionData.STRUCT_DESC);
                if (interestimpressiondata.interestImpressions != null && interestimpressiondata.isSetInterestImpressions())
                {
                    tprotocol.writeFieldBegin(InterestImpressionData.INTEREST_IMPRESSIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, interestimpressiondata.interestImpressions.size()));
                    for (Iterator iterator = interestimpressiondata.interestImpressions.iterator(); iterator.hasNext(); ((InterestImpression)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (interestimpressiondata.orderType != null && interestimpressiondata.isSetOrderType())
                {
                    tprotocol.writeFieldBegin(InterestImpressionData.ORDER_TYPE_FIELD_DESC);
                    tprotocol.writeString(interestimpressiondata.orderType);
                    tprotocol.writeFieldEnd();
                }
                if (interestimpressiondata.blendType != null && interestimpressiondata.isSetBlendType())
                {
                    tprotocol.writeFieldBegin(InterestImpressionData.BLEND_TYPE_FIELD_DESC);
                    tprotocol.writeString(interestimpressiondata.blendType);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InterestImpressionData)tbase);
            }

            private InterestImpressionDataStandardScheme()
            {
            }

            InterestImpressionDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class InterestImpressionDataTupleSchemeFactory
        implements SchemeFactory
    {

        public InterestImpressionDataTupleScheme getScheme()
        {
            return new InterestImpressionDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InterestImpressionDataTupleSchemeFactory()
        {
        }

        InterestImpressionDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InterestImpressionDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    interestimpressiondata.interestImpressions = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        InterestImpression interestimpression = new InterestImpression();
                        interestimpression.read(tprotocol);
                        interestimpressiondata.interestImpressions.add(interestimpression);
                    }

                    interestimpressiondata.setInterestImpressionsIsSet(true);
                }
                if (bitset.get(1))
                {
                    interestimpressiondata.orderType = tprotocol.readString();
                    interestimpressiondata.setOrderTypeIsSet(true);
                }
                if (bitset.get(2))
                {
                    interestimpressiondata.blendType = tprotocol.readString();
                    interestimpressiondata.setBlendTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InterestImpressionData)tbase);
            }

            public void write(TProtocol tprotocol, InterestImpressionData interestimpressiondata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (interestimpressiondata.isSetInterestImpressions())
                {
                    bitset.set(0);
                }
                if (interestimpressiondata.isSetOrderType())
                {
                    bitset.set(1);
                }
                if (interestimpressiondata.isSetBlendType())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (interestimpressiondata.isSetInterestImpressions())
                {
                    tprotocol.writeI32(interestimpressiondata.interestImpressions.size());
                    for (Iterator iterator = interestimpressiondata.interestImpressions.iterator(); iterator.hasNext(); ((InterestImpression)iterator.next()).write(tprotocol)) { }
                }
                if (interestimpressiondata.isSetOrderType())
                {
                    tprotocol.writeString(interestimpressiondata.orderType);
                }
                if (interestimpressiondata.isSetBlendType())
                {
                    tprotocol.writeString(interestimpressiondata.blendType);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InterestImpressionData)tbase);
            }

            private InterestImpressionDataTupleScheme()
            {
            }

            InterestImpressionDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
