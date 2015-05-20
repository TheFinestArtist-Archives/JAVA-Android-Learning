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
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

public class PinInsertion
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ADS_INSERTION_ID_FIELD_DESC = new TField("adsInsertionId", (byte)11, (short)2);
    private static final TField PIN_ID_FIELD_DESC = new TField("pinId", (byte)10, (short)1);
    private static final TField SLOT_FIELD_DESC = new TField("slot", (byte)6, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("PinInsertion");
    private static final int __PINID_ISSET_ID = 0;
    private static final int __SLOT_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public ByteBuffer adsInsertionId;
    public long pinId;
    public short slot;

    public PinInsertion()
    {
        __isset_bitfield = 0;
    }

    public PinInsertion(long l)
    {
        this();
        pinId = l;
        setPinIdIsSet(true);
    }

    public PinInsertion(PinInsertion pininsertion)
    {
        __isset_bitfield = 0;
        __isset_bitfield = pininsertion.__isset_bitfield;
        pinId = pininsertion.pinId;
        if (pininsertion.isSetAdsInsertionId())
        {
            adsInsertionId = TBaseHelper.copyBinary(pininsertion.adsInsertionId);
        }
        slot = pininsertion.slot;
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

    public void clear()
    {
        setPinIdIsSet(false);
        pinId = 0L;
        adsInsertionId = null;
        setSlotIsSet(false);
        slot = 0;
    }

    public int compareTo(PinInsertion pininsertion)
    {
        if (getClass().equals(pininsertion.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(pininsertion.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetPinId()).compareTo(Boolean.valueOf(pininsertion.isSetPinId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetPinId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pinId, pininsertion.pinId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetAdsInsertionId()).compareTo(Boolean.valueOf(pininsertion.isSetAdsInsertionId()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetAdsInsertionId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(adsInsertionId, pininsertion.adsInsertionId);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetSlot()).compareTo(Boolean.valueOf(pininsertion.isSetSlot()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetSlot())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(slot, pininsertion.slot);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PinInsertion)obj);
    }

    public PinInsertion deepCopy()
    {
        return new PinInsertion(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PinInsertion pininsertion)
    {
        if (pininsertion != null && pinId == pininsertion.pinId)
        {
            boolean flag = isSetAdsInsertionId();
            boolean flag2 = pininsertion.isSetAdsInsertionId();
            if (!flag && !flag2 || flag && flag2 && adsInsertionId.equals(pininsertion.adsInsertionId))
            {
                boolean flag1 = isSetSlot();
                boolean flag3 = pininsertion.isSetSlot();
                if (!flag1 && !flag3 || flag1 && flag3 && slot == pininsertion.slot)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PinInsertion)) 
        {
            return false;
        }
        return equals((PinInsertion)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertion._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getPinId());

        case 2: // '\002'
            return getAdsInsertionId();

        case 3: // '\003'
            return Short.valueOf(getSlot());
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

    public short getSlot()
    {
        return slot;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(pinId));
        boolean flag = isSetAdsInsertionId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(adsInsertionId);
        }
        flag = isSetSlot();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(slot));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertion._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetPinId();

        case 2: // '\002'
            return isSetAdsInsertionId();

        case 3: // '\003'
            return isSetSlot();
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

    public boolean isSetSlot()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PinInsertion setAdsInsertionId(ByteBuffer bytebuffer)
    {
        adsInsertionId = TBaseHelper.copyBinary(bytebuffer);
        return this;
    }

    public PinInsertion setAdsInsertionId(byte abyte0[])
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertion._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetPinId();
                return;
            } else
            {
                setPinId(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAdsInsertionId();
                return;
            } else
            {
                setAdsInsertionId((ByteBuffer)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetSlot();
            return;
        } else
        {
            setSlot(((Short)obj).shortValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PinInsertion setPinId(long l)
    {
        pinId = l;
        setPinIdIsSet(true);
        return this;
    }

    public void setPinIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PinInsertion setSlot(short word0)
    {
        slot = word0;
        setSlotIsSet(true);
        return this;
    }

    public void setSlotIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PinInsertion(");
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
        if (isSetSlot())
        {
            stringbuilder.append(", ");
            stringbuilder.append("slot:");
            stringbuilder.append(slot);
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

    public void unsetSlot()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PinInsertionStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PinInsertionTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.ADS_INSERTION_ID, _Fields.SLOT
        });
        obj = new EnumMap(com/pinterest/schemas/event/PinInsertion$_Fields);
        ((Map) (obj)).put(_Fields.PIN_ID, new FieldMetaData("pinId", (byte)1, new FieldValueMetaData((byte)10)));
        ((Map) (obj)).put(_Fields.ADS_INSERTION_ID, new FieldMetaData("adsInsertionId", (byte)2, new FieldValueMetaData((byte)11, true)));
        ((Map) (obj)).put(_Fields.SLOT, new FieldMetaData("slot", (byte)2, new FieldValueMetaData((byte)6)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PinInsertion, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ADS_INSERTION_ID;
        public static final _Fields PIN_ID;
        public static final _Fields SLOT;
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
                return PIN_ID;

            case 2: // '\002'
                return ADS_INSERTION_ID;

            case 3: // '\003'
                return SLOT;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PinInsertion$_Fields, s);
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
            PIN_ID = new _Fields("PIN_ID", 0, (short)1, "pinId");
            ADS_INSERTION_ID = new _Fields("ADS_INSERTION_ID", 1, (short)2, "adsInsertionId");
            SLOT = new _Fields("SLOT", 2, (short)3, "slot");
            $VALUES = (new _Fields[] {
                PIN_ID, ADS_INSERTION_ID, SLOT
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinInsertion$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PinInsertion$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PinInsertion$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertion$_Fields[_Fields.PIN_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertion$_Fields[_Fields.ADS_INSERTION_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertion$_Fields[_Fields.SLOT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PinInsertionStandardSchemeFactory
        implements SchemeFactory
    {

        public PinInsertionStandardScheme getScheme()
        {
            return new PinInsertionStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinInsertionStandardSchemeFactory()
        {
        }

        PinInsertionStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinInsertionStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PinInsertion pininsertion)
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
                if (tfield.type == 10)
                {
                    pininsertion.pinId = tprotocol.readI64();
                    pininsertion.setPinIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 11)
                {
                    pininsertion.adsInsertionId = tprotocol.readBinary();
                    pininsertion.setAdsInsertionIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 6)
                {
                    pininsertion.slot = tprotocol.readI16();
                    pininsertion.setSlotIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                if (!pininsertion.isSetPinId())
                {
                    throw new TProtocolException((new StringBuilder("Required field 'pinId' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    pininsertion.validate();
                    return;
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinInsertion)tbase);
            }

            public void write(TProtocol tprotocol, PinInsertion pininsertion)
            {
                pininsertion.validate();
                tprotocol.writeStructBegin(PinInsertion.STRUCT_DESC);
                tprotocol.writeFieldBegin(PinInsertion.PIN_ID_FIELD_DESC);
                tprotocol.writeI64(pininsertion.pinId);
                tprotocol.writeFieldEnd();
                if (pininsertion.adsInsertionId != null && pininsertion.isSetAdsInsertionId())
                {
                    tprotocol.writeFieldBegin(PinInsertion.ADS_INSERTION_ID_FIELD_DESC);
                    tprotocol.writeBinary(pininsertion.adsInsertionId);
                    tprotocol.writeFieldEnd();
                }
                if (pininsertion.isSetSlot())
                {
                    tprotocol.writeFieldBegin(PinInsertion.SLOT_FIELD_DESC);
                    tprotocol.writeI16(pininsertion.slot);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinInsertion)tbase);
            }

            private PinInsertionStandardScheme()
            {
            }

            PinInsertionStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PinInsertionTupleSchemeFactory
        implements SchemeFactory
    {

        public PinInsertionTupleScheme getScheme()
        {
            return new PinInsertionTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinInsertionTupleSchemeFactory()
        {
        }

        PinInsertionTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinInsertionTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PinInsertion pininsertion)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                pininsertion.pinId = tprotocol.readI64();
                pininsertion.setPinIdIsSet(true);
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    pininsertion.adsInsertionId = tprotocol.readBinary();
                    pininsertion.setAdsInsertionIdIsSet(true);
                }
                if (bitset.get(1))
                {
                    pininsertion.slot = tprotocol.readI16();
                    pininsertion.setSlotIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinInsertion)tbase);
            }

            public void write(TProtocol tprotocol, PinInsertion pininsertion)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                tprotocol.writeI64(pininsertion.pinId);
                BitSet bitset = new BitSet();
                if (pininsertion.isSetAdsInsertionId())
                {
                    bitset.set(0);
                }
                if (pininsertion.isSetSlot())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (pininsertion.isSetAdsInsertionId())
                {
                    tprotocol.writeBinary(pininsertion.adsInsertionId);
                }
                if (pininsertion.isSetSlot())
                {
                    tprotocol.writeI16(pininsertion.slot);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinInsertion)tbase);
            }

            private PinInsertionTupleScheme()
            {
            }

            PinInsertionTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
