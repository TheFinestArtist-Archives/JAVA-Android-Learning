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

public class InterestImpression
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField IMAGE_SIGNATURE_FIELD_DESC = new TField("imageSignature", (byte)11, (short)3);
    private static final TField INTEREST_SIZE_FIELD_DESC = new TField("interestSize", (byte)3, (short)2);
    private static final TField KEY_FIELD_DESC = new TField("key", (byte)11, (short)1);
    private static final TField LIST_POSITION_FIELD_DESC = new TField("listPosition", (byte)6, (short)4);
    private static final TStruct STRUCT_DESC = new TStruct("InterestImpression");
    private static final int __INTERESTSIZE_ISSET_ID = 0;
    private static final int __LISTPOSITION_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String imageSignature;
    public byte interestSize;
    public String key;
    public short listPosition;

    public InterestImpression()
    {
        __isset_bitfield = 0;
    }

    public InterestImpression(InterestImpression interestimpression)
    {
        __isset_bitfield = 0;
        __isset_bitfield = interestimpression.__isset_bitfield;
        if (interestimpression.isSetKey())
        {
            key = interestimpression.key;
        }
        interestSize = interestimpression.interestSize;
        if (interestimpression.isSetImageSignature())
        {
            imageSignature = interestimpression.imageSignature;
        }
        listPosition = interestimpression.listPosition;
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
        key = null;
        setInterestSizeIsSet(false);
        interestSize = 0;
        imageSignature = null;
        setListPositionIsSet(false);
        listPosition = 0;
    }

    public int compareTo(InterestImpression interestimpression)
    {
        if (getClass().equals(interestimpression.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(interestimpression.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetKey()).compareTo(Boolean.valueOf(interestimpression.isSetKey()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetKey())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(key, interestimpression.key);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetInterestSize()).compareTo(Boolean.valueOf(interestimpression.isSetInterestSize()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetInterestSize())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(interestSize, interestimpression.interestSize);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetImageSignature()).compareTo(Boolean.valueOf(interestimpression.isSetImageSignature()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetImageSignature())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(imageSignature, interestimpression.imageSignature);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetListPosition()).compareTo(Boolean.valueOf(interestimpression.isSetListPosition()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetListPosition())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(listPosition, interestimpression.listPosition);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((InterestImpression)obj);
    }

    public InterestImpression deepCopy()
    {
        return new InterestImpression(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(InterestImpression interestimpression)
    {
        if (interestimpression != null)
        {
            boolean flag = isSetKey();
            boolean flag4 = interestimpression.isSetKey();
            if (!flag && !flag4 || flag && flag4 && key.equals(interestimpression.key))
            {
                boolean flag1 = isSetInterestSize();
                boolean flag5 = interestimpression.isSetInterestSize();
                if (!flag1 && !flag5 || flag1 && flag5 && interestSize == interestimpression.interestSize)
                {
                    boolean flag2 = isSetImageSignature();
                    boolean flag6 = interestimpression.isSetImageSignature();
                    if (!flag2 && !flag6 || flag2 && flag6 && imageSignature.equals(interestimpression.imageSignature))
                    {
                        boolean flag3 = isSetListPosition();
                        boolean flag7 = interestimpression.isSetListPosition();
                        if (!flag3 && !flag7 || flag3 && flag7 && listPosition == interestimpression.listPosition)
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
        while (obj == null || !(obj instanceof InterestImpression)) 
        {
            return false;
        }
        return equals((InterestImpression)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpression._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getKey();

        case 2: // '\002'
            return Byte.valueOf(getInterestSize());

        case 3: // '\003'
            return getImageSignature();

        case 4: // '\004'
            return Short.valueOf(getListPosition());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getImageSignature()
    {
        return imageSignature;
    }

    public byte getInterestSize()
    {
        return interestSize;
    }

    public String getKey()
    {
        return key;
    }

    public short getListPosition()
    {
        return listPosition;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetKey();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(key);
        }
        flag = isSetInterestSize();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Byte.valueOf(interestSize));
        }
        flag = isSetImageSignature();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(imageSignature);
        }
        flag = isSetListPosition();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(listPosition));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpression._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetKey();

        case 2: // '\002'
            return isSetInterestSize();

        case 3: // '\003'
            return isSetImageSignature();

        case 4: // '\004'
            return isSetListPosition();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetImageSignature()
    {
        return imageSignature != null;
    }

    public boolean isSetInterestSize()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetKey()
    {
        return key != null;
    }

    public boolean isSetListPosition()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.InterestImpression._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetKey();
                return;
            } else
            {
                setKey((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetInterestSize();
                return;
            } else
            {
                setInterestSize(((Byte)obj).byteValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetImageSignature();
                return;
            } else
            {
                setImageSignature((String)obj);
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetListPosition();
            return;
        } else
        {
            setListPosition(((Short)obj).shortValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public InterestImpression setImageSignature(String s)
    {
        imageSignature = s;
        return this;
    }

    public void setImageSignatureIsSet(boolean flag)
    {
        if (!flag)
        {
            imageSignature = null;
        }
    }

    public InterestImpression setInterestSize(byte byte0)
    {
        interestSize = byte0;
        setInterestSizeIsSet(true);
        return this;
    }

    public void setInterestSizeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public InterestImpression setKey(String s)
    {
        key = s;
        return this;
    }

    public void setKeyIsSet(boolean flag)
    {
        if (!flag)
        {
            key = null;
        }
    }

    public InterestImpression setListPosition(short word0)
    {
        listPosition = word0;
        setListPositionIsSet(true);
        return this;
    }

    public void setListPositionIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("InterestImpression(");
        boolean flag = true;
        boolean flag1;
        if (isSetKey())
        {
            stringbuilder.append("key:");
            if (key == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(key);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetInterestSize())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("interestSize:");
            stringbuilder.append(interestSize);
            flag1 = false;
        }
        if (isSetImageSignature())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("imageSignature:");
            if (imageSignature == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(imageSignature);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetListPosition())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("listPosition:");
            stringbuilder.append(listPosition);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetImageSignature()
    {
        imageSignature = null;
    }

    public void unsetInterestSize()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetKey()
    {
        key = null;
    }

    public void unsetListPosition()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new InterestImpressionStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new InterestImpressionTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.KEY, _Fields.INTEREST_SIZE, _Fields.IMAGE_SIGNATURE, _Fields.LIST_POSITION
        });
        obj = new EnumMap(com/pinterest/schemas/event/InterestImpression$_Fields);
        ((Map) (obj)).put(_Fields.KEY, new FieldMetaData("key", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.INTEREST_SIZE, new FieldMetaData("interestSize", (byte)2, new FieldValueMetaData((byte)3)));
        ((Map) (obj)).put(_Fields.IMAGE_SIGNATURE, new FieldMetaData("imageSignature", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.LIST_POSITION, new FieldMetaData("listPosition", (byte)2, new FieldValueMetaData((byte)6)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/InterestImpression, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields IMAGE_SIGNATURE;
        public static final _Fields INTEREST_SIZE;
        public static final _Fields KEY;
        public static final _Fields LIST_POSITION;
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
                return KEY;

            case 2: // '\002'
                return INTEREST_SIZE;

            case 3: // '\003'
                return IMAGE_SIGNATURE;

            case 4: // '\004'
                return LIST_POSITION;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/InterestImpression$_Fields, s);
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
            KEY = new _Fields("KEY", 0, (short)1, "key");
            INTEREST_SIZE = new _Fields("INTEREST_SIZE", 1, (short)2, "interestSize");
            IMAGE_SIGNATURE = new _Fields("IMAGE_SIGNATURE", 2, (short)3, "imageSignature");
            LIST_POSITION = new _Fields("LIST_POSITION", 3, (short)4, "listPosition");
            $VALUES = (new _Fields[] {
                KEY, INTEREST_SIZE, IMAGE_SIGNATURE, LIST_POSITION
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/InterestImpression$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields[_Fields.KEY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields[_Fields.INTEREST_SIZE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields[_Fields.IMAGE_SIGNATURE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$InterestImpression$_Fields[_Fields.LIST_POSITION.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class InterestImpressionStandardSchemeFactory
        implements SchemeFactory
    {

        public InterestImpressionStandardScheme getScheme()
        {
            return new InterestImpressionStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InterestImpressionStandardSchemeFactory()
        {
        }

        InterestImpressionStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InterestImpressionStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, InterestImpression interestimpression)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_210;
                }
                tfield.id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 103
            //                           3 138
            //                           4 174;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_174;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (tfield.type == 11)
                {
                    interestimpression.key = tprotocol.readString();
                    interestimpression.setKeyIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L3:
                if (tfield.type == 3)
                {
                    interestimpression.interestSize = tprotocol.readByte();
                    interestimpression.setInterestSizeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L4:
                if (tfield.type == 11)
                {
                    interestimpression.imageSignature = tprotocol.readString();
                    interestimpression.setImageSignatureIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                if (tfield.type == 6)
                {
                    interestimpression.listPosition = tprotocol.readI16();
                    interestimpression.setListPositionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                interestimpression.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InterestImpression)tbase);
            }

            public void write(TProtocol tprotocol, InterestImpression interestimpression)
            {
                interestimpression.validate();
                tprotocol.writeStructBegin(InterestImpression.STRUCT_DESC);
                if (interestimpression.key != null && interestimpression.isSetKey())
                {
                    tprotocol.writeFieldBegin(InterestImpression.KEY_FIELD_DESC);
                    tprotocol.writeString(interestimpression.key);
                    tprotocol.writeFieldEnd();
                }
                if (interestimpression.isSetInterestSize())
                {
                    tprotocol.writeFieldBegin(InterestImpression.INTEREST_SIZE_FIELD_DESC);
                    tprotocol.writeByte(interestimpression.interestSize);
                    tprotocol.writeFieldEnd();
                }
                if (interestimpression.imageSignature != null && interestimpression.isSetImageSignature())
                {
                    tprotocol.writeFieldBegin(InterestImpression.IMAGE_SIGNATURE_FIELD_DESC);
                    tprotocol.writeString(interestimpression.imageSignature);
                    tprotocol.writeFieldEnd();
                }
                if (interestimpression.isSetListPosition())
                {
                    tprotocol.writeFieldBegin(InterestImpression.LIST_POSITION_FIELD_DESC);
                    tprotocol.writeI16(interestimpression.listPosition);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InterestImpression)tbase);
            }

            private InterestImpressionStandardScheme()
            {
            }

            InterestImpressionStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class InterestImpressionTupleSchemeFactory
        implements SchemeFactory
    {

        public InterestImpressionTupleScheme getScheme()
        {
            return new InterestImpressionTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private InterestImpressionTupleSchemeFactory()
        {
        }

        InterestImpressionTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class InterestImpressionTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, InterestImpression interestimpression)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    interestimpression.key = tprotocol.readString();
                    interestimpression.setKeyIsSet(true);
                }
                if (bitset.get(1))
                {
                    interestimpression.interestSize = tprotocol.readByte();
                    interestimpression.setInterestSizeIsSet(true);
                }
                if (bitset.get(2))
                {
                    interestimpression.imageSignature = tprotocol.readString();
                    interestimpression.setImageSignatureIsSet(true);
                }
                if (bitset.get(3))
                {
                    interestimpression.listPosition = tprotocol.readI16();
                    interestimpression.setListPositionIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (InterestImpression)tbase);
            }

            public void write(TProtocol tprotocol, InterestImpression interestimpression)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (interestimpression.isSetKey())
                {
                    bitset.set(0);
                }
                if (interestimpression.isSetInterestSize())
                {
                    bitset.set(1);
                }
                if (interestimpression.isSetImageSignature())
                {
                    bitset.set(2);
                }
                if (interestimpression.isSetListPosition())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (interestimpression.isSetKey())
                {
                    tprotocol.writeString(interestimpression.key);
                }
                if (interestimpression.isSetInterestSize())
                {
                    tprotocol.writeByte(interestimpression.interestSize);
                }
                if (interestimpression.isSetImageSignature())
                {
                    tprotocol.writeString(interestimpression.imageSignature);
                }
                if (interestimpression.isSetListPosition())
                {
                    tprotocol.writeI16(interestimpression.listPosition);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (InterestImpression)tbase);
            }

            private InterestImpressionTupleScheme()
            {
            }

            InterestImpressionTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
