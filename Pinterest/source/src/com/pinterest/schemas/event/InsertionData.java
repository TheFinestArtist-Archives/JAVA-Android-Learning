// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

public class InsertionData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ADS_INSERTION_ID_FIELD_DESC = new TField("adsInsertionId", (byte)11, (short)3);
    private static final TField PIN_ID_FIELD_DESC = new TField("pinId", (byte)10, (short)2);
    private static final TField REQUEST_ID_FIELD_DESC = new TField("requestId", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("InsertionData");
    private static final int __PINID_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public ByteBuffer adsInsertionId;
    public long pinId;
    public ByteBuffer requestId;

    public InsertionData()
    {
        __isset_bitfield = 0;
    }

    public InsertionData(InsertionData insertiondata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = insertiondata.__isset_bitfield;
        if (insertiondata.isSetRequestId())
        {
            requestId = TBaseHelper.copyBinary(insertiondata.requestId);
        }
        pinId = insertiondata.pinId;
        if (insertiondata.isSetAdsInsertionId())
        {
            adsInsertionId = TBaseHelper.copyBinary(insertiondata.adsInsertionId);
        }
    }

    public InsertionData(ByteBuffer bytebuffer, long l)
    {
        this();
        requestId = TBaseHelper.copyBinary(bytebuffer);
        pinId = l;
        setPinIdIsSet(true);
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

    public ByteBuffer bufferForAdsInsertionId()
    {
        return TBaseHelper.copyBinary(adsInsertionId);
    }

    public ByteBuffer bufferForRequestId()
    {
        return TBaseHelper.copyBinary(requestId);
    }

    public void clear()
    {
        requestId = null;
        setPinIdIsSet(false);
        pinId = 0L;
        adsInsertionId = null;
    }

    public int compareTo(InsertionData insertiondata)
    {
        if (getClass().equals(insertiondata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(insertiondata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetRequestId()).compareTo(Boolean.valueOf(insertiondata.isSetRequestId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetRequestId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestId, insertiondata.requestId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetPinId()).compareTo(Boolean.valueOf(insertiondata.isSetPinId()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetPinId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pinId, insertiondata.pinId);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetAdsInsertionId()).compareTo(Boolean.valueOf(insertiondata.isSetAdsInsertionId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetAdsInsertionId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(adsInsertionId, insertiondata.adsInsertionId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((InsertionData)obj);
    }

    public InsertionData deepCopy()
    {
        return new InsertionData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(InsertionData insertiondata)
    {
        if (insertiondata != null)
        {
            boolean flag = isSetRequestId();
            boolean flag2 = insertiondata.isSetRequestId();
            if ((!flag && !flag2 || flag && flag2 && requestId.equals(insertiondata.requestId)) && pinId == insertiondata.pinId)
            {
                boolean flag1 = isSetAdsInsertionId();
                boolean flag3 = insertiondata.isSetAdsInsertionId();
                if (!flag1 && !flag3 || flag1 && flag3 && adsInsertionId.equals(insertiondata.adsInsertionId))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof InsertionData)) 
        {
            return false;
        }
        return equals((InsertionData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public byte[] getAdsInsertionId()
    {
        setAdsInsertionId(TBaseHelper.rightSize(adsInsertionId));
        if (adsInsertionId == null)
        {
            return null;
        } else
        {
            return adsInsertionId.array();
        }
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InsertionData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getRequestId();

        case 2: // '\002'
            return Long.valueOf(getPinId());

        case 3: // '\003'
            return getAdsInsertionId();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public long getPinId()
    {
        return pinId;
    }

    public byte[] getRequestId()
    {
        setRequestId(TBaseHelper.rightSize(requestId));
        if (requestId == null)
        {
            return null;
        } else
        {
            return requestId.array();
        }
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetRequestId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestId);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(pinId));
        flag = isSetAdsInsertionId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(adsInsertionId);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InsertionData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetRequestId();

        case 2: // '\002'
            return isSetPinId();

        case 3: // '\003'
            return isSetAdsInsertionId();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAdsInsertionId()
    {
        return adsInsertionId != null;
    }

    public boolean isSetPinId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetRequestId()
    {
        return requestId != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public InsertionData setAdsInsertionId(ByteBuffer bytebuffer)
    {
        adsInsertionId = TBaseHelper.copyBinary(bytebuffer);
        return this;
    }

    public InsertionData setAdsInsertionId(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = null;
        } else
        {
            abyte0 = ByteBuffer.wrap(Arrays.copyOf(abyte0, abyte0.length));
        }
        adsInsertionId = abyte0;
        return this;
    }

    public void setAdsInsertionIdIsSet(boolean flag)
    {
        if (!flag)
        {
            adsInsertionId = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InsertionData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetRequestId();
                return;
            } else
            {
                setRequestId((ByteBuffer)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetPinId();
                return;
            } else
            {
                setPinId(((Long)obj).longValue());
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetAdsInsertionId();
            return;
        } else
        {
            setAdsInsertionId((ByteBuffer)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public InsertionData setPinId(long l)
    {
        pinId = l;
        setPinIdIsSet(true);
        return this;
    }

    public void setPinIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public InsertionData setRequestId(ByteBuffer bytebuffer)
    {
        requestId = TBaseHelper.copyBinary(bytebuffer);
        return this;
    }

    public InsertionData setRequestId(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = null;
        } else
        {
            abyte0 = ByteBuffer.wrap(Arrays.copyOf(abyte0, abyte0.length));
        }
        requestId = abyte0;
        return this;
    }

    public void setRequestIdIsSet(boolean flag)
    {
        if (!flag)
        {
            requestId = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("InsertionData(");
        stringbuilder.append("requestId:");
        if (requestId == null)
        {
            stringbuilder.append("null");
        } else
        {
            TBaseHelper.toString(requestId, stringbuilder);
        }
        stringbuilder.append(", ");
        stringbuilder.append("pinId:");
        stringbuilder.append(pinId);
        if (isSetAdsInsertionId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adsInsertionId:");
            if (adsInsertionId == null)
            {
                stringbuilder.append("null");
            } else
            {
                TBaseHelper.toString(adsInsertionId, stringbuilder);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdsInsertionId()
    {
        adsInsertionId = null;
    }

    public void unsetPinId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetRequestId()
    {
        requestId = null;
    }

    public void validate()
    {
        if (requestId == null)
        {
            throw new TProtocolException((new StringBuilder("Required field 'requestId' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public void write(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().write(tprotocol, this);
    }

    static 
    {
        Object obj = new HashMap();
        schemes = ((Map) (obj));
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new InsertionDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new InsertionDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.ADS_INSERTION_ID
        });
        obj = new EnumMap(com/pinterest/schemas/event/InsertionData$_Fields);
        ((Map) (obj)).put(_Fields.REQUEST_ID, new FieldMetaData("requestId", (byte)1, new FieldValueMetaData((byte)11, true)));
        ((Map) (obj)).put(_Fields.PIN_ID, new FieldMetaData("pinId", (byte)1, new FieldValueMetaData((byte)10)));
        ((Map) (obj)).put(_Fields.ADS_INSERTION_ID, new FieldMetaData("adsInsertionId", (byte)2, new FieldValueMetaData((byte)11, true)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/InsertionData, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ADS_INSERTION_ID;
        public static final _Fields PIN_ID;
        public static final _Fields REQUEST_ID;
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
                return REQUEST_ID;

            case 2: // '\002'
                return PIN_ID;

            case 3: // '\003'
                return ADS_INSERTION_ID;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/InsertionData$_Fields, s);
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
            REQUEST_ID = new _Fields("REQUEST_ID", 0, (short)1, "requestId");
            PIN_ID = new _Fields("PIN_ID", 1, (short)2, "pinId");
            ADS_INSERTION_ID = new _Fields("ADS_INSERTION_ID", 2, (short)3, "adsInsertionId");
            $VALUES = (new _Fields[] {
                REQUEST_ID, PIN_ID, ADS_INSERTION_ID
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/InsertionData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$InsertionData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$InsertionData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InsertionData$_Fields[_Fields.REQUEST_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InsertionData$_Fields[_Fields.PIN_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InsertionData$_Fields[_Fields.ADS_INSERTION_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class InsertionDataStandardSchemeFactory
        implements SchemeFactory
    {

        public InsertionDataStandardScheme getScheme()
        {
            return new InsertionDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InsertionDataStandardSchemeFactory()
        {
        }

        InsertionDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InsertionDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, InsertionData insertiondata)
            {
                tprotocol.readStructBegin();
_L6:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_171;
                }
                tfield.id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 99
            //                           3 135;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_135;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (tfield.type == 11)
                {
                    insertiondata.requestId = tprotocol.readBinary();
                    insertiondata.setRequestIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 10)
                {
                    insertiondata.pinId = tprotocol.readI64();
                    insertiondata.setPinIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 11)
                {
                    insertiondata.adsInsertionId = tprotocol.readBinary();
                    insertiondata.setAdsInsertionIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                if (!insertiondata.isSetPinId())
                {
                    throw new TProtocolException((new StringBuilder("Required field 'pinId' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    insertiondata.validate();
                    return;
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InsertionData)tbase);
            }

            public void write(TProtocol tprotocol, InsertionData insertiondata)
            {
                insertiondata.validate();
                tprotocol.writeStructBegin(InsertionData.STRUCT_DESC);
                if (insertiondata.requestId != null)
                {
                    tprotocol.writeFieldBegin(InsertionData.REQUEST_ID_FIELD_DESC);
                    tprotocol.writeBinary(insertiondata.requestId);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(InsertionData.PIN_ID_FIELD_DESC);
                tprotocol.writeI64(insertiondata.pinId);
                tprotocol.writeFieldEnd();
                if (insertiondata.adsInsertionId != null && insertiondata.isSetAdsInsertionId())
                {
                    tprotocol.writeFieldBegin(InsertionData.ADS_INSERTION_ID_FIELD_DESC);
                    tprotocol.writeBinary(insertiondata.adsInsertionId);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InsertionData)tbase);
            }

            private InsertionDataStandardScheme()
            {
            }

            InsertionDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class InsertionDataTupleSchemeFactory
        implements SchemeFactory
    {

        public InsertionDataTupleScheme getScheme()
        {
            return new InsertionDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InsertionDataTupleSchemeFactory()
        {
        }

        InsertionDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InsertionDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, InsertionData insertiondata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                insertiondata.requestId = tprotocol.readBinary();
                insertiondata.setRequestIdIsSet(true);
                insertiondata.pinId = tprotocol.readI64();
                insertiondata.setPinIdIsSet(true);
                if (tprotocol.readBitSet(1).get(0))
                {
                    insertiondata.adsInsertionId = tprotocol.readBinary();
                    insertiondata.setAdsInsertionIdIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InsertionData)tbase);
            }

            public void write(TProtocol tprotocol, InsertionData insertiondata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                tprotocol.writeBinary(insertiondata.requestId);
                tprotocol.writeI64(insertiondata.pinId);
                BitSet bitset = new BitSet();
                if (insertiondata.isSetAdsInsertionId())
                {
                    bitset.set(0);
                }
                tprotocol.writeBitSet(bitset, 1);
                if (insertiondata.isSetAdsInsertionId())
                {
                    tprotocol.writeBinary(insertiondata.adsInsertionId);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InsertionData)tbase);
            }

            private InsertionDataTupleScheme()
            {
            }

            InsertionDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
