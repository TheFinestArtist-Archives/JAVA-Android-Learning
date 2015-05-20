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

public class ElementData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField NETWORK_STORY_CELL_TYPE_FIELD_DESC = new TField("networkStoryCellType", (byte)11, (short)4);
    private static final TField NETWORK_STORY_TYPE_FIELD_DESC = new TField("networkStoryType", (byte)11, (short)3);
    private static final TField REPIN_BUTTON_GROUP_FIELD_DESC = new TField("repinButtonGroup", (byte)11, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("ElementData");
    private static final TField STUB_FIELD_DESC = new TField("stub", (byte)8, (short)1);
    private static final int __STUB_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String networkStoryCellType;
    public String networkStoryType;
    public String repinButtonGroup;
    public int stub;

    public ElementData()
    {
        __isset_bitfield = 0;
    }

    public ElementData(ElementData elementdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = elementdata.__isset_bitfield;
        stub = elementdata.stub;
        if (elementdata.isSetRepinButtonGroup())
        {
            repinButtonGroup = elementdata.repinButtonGroup;
        }
        if (elementdata.isSetNetworkStoryType())
        {
            networkStoryType = elementdata.networkStoryType;
        }
        if (elementdata.isSetNetworkStoryCellType())
        {
            networkStoryCellType = elementdata.networkStoryCellType;
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
        setStubIsSet(false);
        stub = 0;
        repinButtonGroup = null;
        networkStoryType = null;
        networkStoryCellType = null;
    }

    public int compareTo(ElementData elementdata)
    {
        if (getClass().equals(elementdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(elementdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetStub()).compareTo(Boolean.valueOf(elementdata.isSetStub()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetStub())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(stub, elementdata.stub);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetRepinButtonGroup()).compareTo(Boolean.valueOf(elementdata.isSetRepinButtonGroup()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetRepinButtonGroup())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(repinButtonGroup, elementdata.repinButtonGroup);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetNetworkStoryType()).compareTo(Boolean.valueOf(elementdata.isSetNetworkStoryType()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetNetworkStoryType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(networkStoryType, elementdata.networkStoryType);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetNetworkStoryCellType()).compareTo(Boolean.valueOf(elementdata.isSetNetworkStoryCellType()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetNetworkStoryCellType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(networkStoryCellType, elementdata.networkStoryCellType);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ElementData)obj);
    }

    public ElementData deepCopy()
    {
        return new ElementData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(ElementData elementdata)
    {
        if (elementdata != null)
        {
            boolean flag = isSetStub();
            boolean flag4 = elementdata.isSetStub();
            if (!flag && !flag4 || flag && flag4 && stub == elementdata.stub)
            {
                boolean flag1 = isSetRepinButtonGroup();
                boolean flag5 = elementdata.isSetRepinButtonGroup();
                if (!flag1 && !flag5 || flag1 && flag5 && repinButtonGroup.equals(elementdata.repinButtonGroup))
                {
                    boolean flag2 = isSetNetworkStoryType();
                    boolean flag6 = elementdata.isSetNetworkStoryType();
                    if (!flag2 && !flag6 || flag2 && flag6 && networkStoryType.equals(elementdata.networkStoryType))
                    {
                        boolean flag3 = isSetNetworkStoryCellType();
                        boolean flag7 = elementdata.isSetNetworkStoryCellType();
                        if (!flag3 && !flag7 || flag3 && flag7 && networkStoryCellType.equals(elementdata.networkStoryCellType))
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
        while (obj == null || !(obj instanceof ElementData)) 
        {
            return false;
        }
        return equals((ElementData)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ElementData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Integer.valueOf(getStub());

        case 2: // '\002'
            return getRepinButtonGroup();

        case 3: // '\003'
            return getNetworkStoryType();

        case 4: // '\004'
            return getNetworkStoryCellType();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getNetworkStoryCellType()
    {
        return networkStoryCellType;
    }

    public String getNetworkStoryType()
    {
        return networkStoryType;
    }

    public String getRepinButtonGroup()
    {
        return repinButtonGroup;
    }

    public int getStub()
    {
        return stub;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetStub();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(stub));
        }
        flag = isSetRepinButtonGroup();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(repinButtonGroup);
        }
        flag = isSetNetworkStoryType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(networkStoryType);
        }
        flag = isSetNetworkStoryCellType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(networkStoryCellType);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ElementData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetStub();

        case 2: // '\002'
            return isSetRepinButtonGroup();

        case 3: // '\003'
            return isSetNetworkStoryType();

        case 4: // '\004'
            return isSetNetworkStoryCellType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetNetworkStoryCellType()
    {
        return networkStoryCellType != null;
    }

    public boolean isSetNetworkStoryType()
    {
        return networkStoryType != null;
    }

    public boolean isSetRepinButtonGroup()
    {
        return repinButtonGroup != null;
    }

    public boolean isSetStub()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ElementData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetStub();
                return;
            } else
            {
                setStub(((Integer)obj).intValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetRepinButtonGroup();
                return;
            } else
            {
                setRepinButtonGroup((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetNetworkStoryType();
                return;
            } else
            {
                setNetworkStoryType((String)obj);
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetNetworkStoryCellType();
            return;
        } else
        {
            setNetworkStoryCellType((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public ElementData setNetworkStoryCellType(String s)
    {
        networkStoryCellType = s;
        return this;
    }

    public void setNetworkStoryCellTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            networkStoryCellType = null;
        }
    }

    public ElementData setNetworkStoryType(String s)
    {
        networkStoryType = s;
        return this;
    }

    public void setNetworkStoryTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            networkStoryType = null;
        }
    }

    public ElementData setRepinButtonGroup(String s)
    {
        repinButtonGroup = s;
        return this;
    }

    public void setRepinButtonGroupIsSet(boolean flag)
    {
        if (!flag)
        {
            repinButtonGroup = null;
        }
    }

    public ElementData setStub(int i)
    {
        stub = i;
        setStubIsSet(true);
        return this;
    }

    public void setStubIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("ElementData(");
        boolean flag = true;
        if (isSetStub())
        {
            stringbuilder.append("stub:");
            stringbuilder.append(stub);
            flag = false;
        }
        boolean flag1 = flag;
        if (isSetRepinButtonGroup())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("repinButtonGroup:");
            if (repinButtonGroup == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(repinButtonGroup);
            }
            flag1 = false;
        }
        if (isSetNetworkStoryType())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("networkStoryType:");
            if (networkStoryType == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(networkStoryType);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetNetworkStoryCellType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("networkStoryCellType:");
            if (networkStoryCellType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(networkStoryCellType);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetNetworkStoryCellType()
    {
        networkStoryCellType = null;
    }

    public void unsetNetworkStoryType()
    {
        networkStoryType = null;
    }

    public void unsetRepinButtonGroup()
    {
        repinButtonGroup = null;
    }

    public void unsetStub()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new ElementDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new ElementDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.STUB, _Fields.REPIN_BUTTON_GROUP, _Fields.NETWORK_STORY_TYPE, _Fields.NETWORK_STORY_CELL_TYPE
        });
        obj = new EnumMap(com/pinterest/schemas/event/ElementData$_Fields);
        ((Map) (obj)).put(_Fields.STUB, new FieldMetaData("stub", (byte)2, new FieldValueMetaData((byte)8)));
        ((Map) (obj)).put(_Fields.REPIN_BUTTON_GROUP, new FieldMetaData("repinButtonGroup", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.NETWORK_STORY_TYPE, new FieldMetaData("networkStoryType", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.NETWORK_STORY_CELL_TYPE, new FieldMetaData("networkStoryCellType", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/ElementData, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields NETWORK_STORY_CELL_TYPE;
        public static final _Fields NETWORK_STORY_TYPE;
        public static final _Fields REPIN_BUTTON_GROUP;
        public static final _Fields STUB;
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
                return STUB;

            case 2: // '\002'
                return REPIN_BUTTON_GROUP;

            case 3: // '\003'
                return NETWORK_STORY_TYPE;

            case 4: // '\004'
                return NETWORK_STORY_CELL_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/ElementData$_Fields, s);
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
            STUB = new _Fields("STUB", 0, (short)1, "stub");
            REPIN_BUTTON_GROUP = new _Fields("REPIN_BUTTON_GROUP", 1, (short)2, "repinButtonGroup");
            NETWORK_STORY_TYPE = new _Fields("NETWORK_STORY_TYPE", 2, (short)3, "networkStoryType");
            NETWORK_STORY_CELL_TYPE = new _Fields("NETWORK_STORY_CELL_TYPE", 3, (short)4, "networkStoryCellType");
            $VALUES = (new _Fields[] {
                STUB, REPIN_BUTTON_GROUP, NETWORK_STORY_TYPE, NETWORK_STORY_CELL_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ElementData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields[_Fields.STUB.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields[_Fields.REPIN_BUTTON_GROUP.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields[_Fields.NETWORK_STORY_TYPE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ElementData$_Fields[_Fields.NETWORK_STORY_CELL_TYPE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ElementDataStandardSchemeFactory
        implements SchemeFactory
    {

        public ElementDataStandardScheme getScheme()
        {
            return new ElementDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ElementDataStandardSchemeFactory()
        {
        }

        ElementDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ElementDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, ElementData elementdata)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_211;
                }
                tfield.id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 103
            //                           3 139
            //                           4 175;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_175;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (tfield.type == 8)
                {
                    elementdata.stub = tprotocol.readI32();
                    elementdata.setStubIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L3:
                if (tfield.type == 11)
                {
                    elementdata.repinButtonGroup = tprotocol.readString();
                    elementdata.setRepinButtonGroupIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L4:
                if (tfield.type == 11)
                {
                    elementdata.networkStoryType = tprotocol.readString();
                    elementdata.setNetworkStoryTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                if (tfield.type == 11)
                {
                    elementdata.networkStoryCellType = tprotocol.readString();
                    elementdata.setNetworkStoryCellTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                elementdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ElementData)tbase);
            }

            public void write(TProtocol tprotocol, ElementData elementdata)
            {
                elementdata.validate();
                tprotocol.writeStructBegin(ElementData.STRUCT_DESC);
                if (elementdata.isSetStub())
                {
                    tprotocol.writeFieldBegin(ElementData.STUB_FIELD_DESC);
                    tprotocol.writeI32(elementdata.stub);
                    tprotocol.writeFieldEnd();
                }
                if (elementdata.repinButtonGroup != null && elementdata.isSetRepinButtonGroup())
                {
                    tprotocol.writeFieldBegin(ElementData.REPIN_BUTTON_GROUP_FIELD_DESC);
                    tprotocol.writeString(elementdata.repinButtonGroup);
                    tprotocol.writeFieldEnd();
                }
                if (elementdata.networkStoryType != null && elementdata.isSetNetworkStoryType())
                {
                    tprotocol.writeFieldBegin(ElementData.NETWORK_STORY_TYPE_FIELD_DESC);
                    tprotocol.writeString(elementdata.networkStoryType);
                    tprotocol.writeFieldEnd();
                }
                if (elementdata.networkStoryCellType != null && elementdata.isSetNetworkStoryCellType())
                {
                    tprotocol.writeFieldBegin(ElementData.NETWORK_STORY_CELL_TYPE_FIELD_DESC);
                    tprotocol.writeString(elementdata.networkStoryCellType);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ElementData)tbase);
            }

            private ElementDataStandardScheme()
            {
            }

            ElementDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class ElementDataTupleSchemeFactory
        implements SchemeFactory
    {

        public ElementDataTupleScheme getScheme()
        {
            return new ElementDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ElementDataTupleSchemeFactory()
        {
        }

        ElementDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ElementDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, ElementData elementdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    elementdata.stub = tprotocol.readI32();
                    elementdata.setStubIsSet(true);
                }
                if (bitset.get(1))
                {
                    elementdata.repinButtonGroup = tprotocol.readString();
                    elementdata.setRepinButtonGroupIsSet(true);
                }
                if (bitset.get(2))
                {
                    elementdata.networkStoryType = tprotocol.readString();
                    elementdata.setNetworkStoryTypeIsSet(true);
                }
                if (bitset.get(3))
                {
                    elementdata.networkStoryCellType = tprotocol.readString();
                    elementdata.setNetworkStoryCellTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ElementData)tbase);
            }

            public void write(TProtocol tprotocol, ElementData elementdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (elementdata.isSetStub())
                {
                    bitset.set(0);
                }
                if (elementdata.isSetRepinButtonGroup())
                {
                    bitset.set(1);
                }
                if (elementdata.isSetNetworkStoryType())
                {
                    bitset.set(2);
                }
                if (elementdata.isSetNetworkStoryCellType())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (elementdata.isSetStub())
                {
                    tprotocol.writeI32(elementdata.stub);
                }
                if (elementdata.isSetRepinButtonGroup())
                {
                    tprotocol.writeString(elementdata.repinButtonGroup);
                }
                if (elementdata.isSetNetworkStoryType())
                {
                    tprotocol.writeString(elementdata.networkStoryType);
                }
                if (elementdata.isSetNetworkStoryCellType())
                {
                    tprotocol.writeString(elementdata.networkStoryCellType);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ElementData)tbase);
            }

            private ElementDataTupleScheme()
            {
            }

            ElementDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
