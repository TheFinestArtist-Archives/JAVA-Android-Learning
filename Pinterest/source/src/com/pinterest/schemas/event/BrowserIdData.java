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

public class BrowserIdData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BROWSER_ID_FIELD_DESC = new TField("browserId", (byte)11, (short)1);
    private static final TField ENCODED_BROWSER_ID_FIELD_DESC = new TField("encodedBrowserId", (byte)11, (short)2);
    private static final TField STATE_FIELD_DESC = new TField("state", (byte)8, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("BrowserIdData");
    private static final int __STATE_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public String browserId;
    public String encodedBrowserId;
    public int state;

    public BrowserIdData()
    {
        __isset_bitfield = 0;
    }

    public BrowserIdData(BrowserIdData browseriddata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = browseriddata.__isset_bitfield;
        if (browseriddata.isSetBrowserId())
        {
            browserId = browseriddata.browserId;
        }
        if (browseriddata.isSetEncodedBrowserId())
        {
            encodedBrowserId = browseriddata.encodedBrowserId;
        }
        state = browseriddata.state;
    }

    public BrowserIdData(String s, String s1, int i)
    {
        this();
        browserId = s;
        encodedBrowserId = s1;
        state = i;
        setStateIsSet(true);
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
        browserId = null;
        encodedBrowserId = null;
        setStateIsSet(false);
        state = 0;
    }

    public int compareTo(BrowserIdData browseriddata)
    {
        if (getClass().equals(browseriddata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(browseriddata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetBrowserId()).compareTo(Boolean.valueOf(browseriddata.isSetBrowserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetBrowserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(browserId, browseriddata.browserId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetEncodedBrowserId()).compareTo(Boolean.valueOf(browseriddata.isSetEncodedBrowserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetEncodedBrowserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(encodedBrowserId, browseriddata.encodedBrowserId);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetState()).compareTo(Boolean.valueOf(browseriddata.isSetState()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetState())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(state, browseriddata.state);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((BrowserIdData)obj);
    }

    public BrowserIdData deepCopy()
    {
        return new BrowserIdData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(BrowserIdData browseriddata)
    {
        if (browseriddata != null)
        {
            boolean flag = isSetBrowserId();
            boolean flag2 = browseriddata.isSetBrowserId();
            if (!flag && !flag2 || flag && flag2 && browserId.equals(browseriddata.browserId))
            {
                boolean flag1 = isSetEncodedBrowserId();
                boolean flag3 = browseriddata.isSetEncodedBrowserId();
                if ((!flag1 && !flag3 || flag1 && flag3 && encodedBrowserId.equals(browseriddata.encodedBrowserId)) && state == browseriddata.state)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof BrowserIdData)) 
        {
            return false;
        }
        return equals((BrowserIdData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getBrowserId()
    {
        return browserId;
    }

    public String getEncodedBrowserId()
    {
        return encodedBrowserId;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.BrowserIdData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getBrowserId();

        case 2: // '\002'
            return getEncodedBrowserId();

        case 3: // '\003'
            return Integer.valueOf(getState());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public int getState()
    {
        return state;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetBrowserId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(browserId);
        }
        flag = isSetEncodedBrowserId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(encodedBrowserId);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Integer.valueOf(state));
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.BrowserIdData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetBrowserId();

        case 2: // '\002'
            return isSetEncodedBrowserId();

        case 3: // '\003'
            return isSetState();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBrowserId()
    {
        return browserId != null;
    }

    public boolean isSetEncodedBrowserId()
    {
        return encodedBrowserId != null;
    }

    public boolean isSetState()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public BrowserIdData setBrowserId(String s)
    {
        browserId = s;
        return this;
    }

    public void setBrowserIdIsSet(boolean flag)
    {
        if (!flag)
        {
            browserId = null;
        }
    }

    public BrowserIdData setEncodedBrowserId(String s)
    {
        encodedBrowserId = s;
        return this;
    }

    public void setEncodedBrowserIdIsSet(boolean flag)
    {
        if (!flag)
        {
            encodedBrowserId = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.BrowserIdData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetBrowserId();
                return;
            } else
            {
                setBrowserId((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetEncodedBrowserId();
                return;
            } else
            {
                setEncodedBrowserId((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetState();
            return;
        } else
        {
            setState(((Integer)obj).intValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public BrowserIdData setState(int i)
    {
        state = i;
        setStateIsSet(true);
        return this;
    }

    public void setStateIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("BrowserIdData(");
        stringbuilder.append("browserId:");
        if (browserId == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(browserId);
        }
        stringbuilder.append(", ");
        stringbuilder.append("encodedBrowserId:");
        if (encodedBrowserId == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(encodedBrowserId);
        }
        stringbuilder.append(", ");
        stringbuilder.append("state:");
        stringbuilder.append(state);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBrowserId()
    {
        browserId = null;
    }

    public void unsetEncodedBrowserId()
    {
        encodedBrowserId = null;
    }

    public void unsetState()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new BrowserIdDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new BrowserIdDataTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/BrowserIdData$_Fields);
        ((Map) (obj)).put(_Fields.BROWSER_ID, new FieldMetaData("browserId", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ENCODED_BROWSER_ID, new FieldMetaData("encodedBrowserId", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.STATE, new FieldMetaData("state", (byte)3, new FieldValueMetaData((byte)8)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/BrowserIdData, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BROWSER_ID;
        public static final _Fields ENCODED_BROWSER_ID;
        public static final _Fields STATE;
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
                return BROWSER_ID;

            case 2: // '\002'
                return ENCODED_BROWSER_ID;

            case 3: // '\003'
                return STATE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/BrowserIdData$_Fields, s);
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
            BROWSER_ID = new _Fields("BROWSER_ID", 0, (short)1, "browserId");
            ENCODED_BROWSER_ID = new _Fields("ENCODED_BROWSER_ID", 1, (short)2, "encodedBrowserId");
            STATE = new _Fields("STATE", 2, (short)3, "state");
            $VALUES = (new _Fields[] {
                BROWSER_ID, ENCODED_BROWSER_ID, STATE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/BrowserIdData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$BrowserIdData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$BrowserIdData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$BrowserIdData$_Fields[_Fields.BROWSER_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$BrowserIdData$_Fields[_Fields.ENCODED_BROWSER_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$BrowserIdData$_Fields[_Fields.STATE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class BrowserIdDataStandardSchemeFactory
        implements SchemeFactory
    {

        public BrowserIdDataStandardScheme getScheme()
        {
            return new BrowserIdDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private BrowserIdDataStandardSchemeFactory()
        {
        }

        BrowserIdDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class BrowserIdDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, BrowserIdData browseriddata)
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
                    browseriddata.browserId = tprotocol.readString();
                    browseriddata.setBrowserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 11)
                {
                    browseriddata.encodedBrowserId = tprotocol.readString();
                    browseriddata.setEncodedBrowserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 8)
                {
                    browseriddata.state = tprotocol.readI32();
                    browseriddata.setStateIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                browseriddata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (BrowserIdData)tbase);
            }

            public void write(TProtocol tprotocol, BrowserIdData browseriddata)
            {
                browseriddata.validate();
                tprotocol.writeStructBegin(BrowserIdData.STRUCT_DESC);
                if (browseriddata.browserId != null)
                {
                    tprotocol.writeFieldBegin(BrowserIdData.BROWSER_ID_FIELD_DESC);
                    tprotocol.writeString(browseriddata.browserId);
                    tprotocol.writeFieldEnd();
                }
                if (browseriddata.encodedBrowserId != null)
                {
                    tprotocol.writeFieldBegin(BrowserIdData.ENCODED_BROWSER_ID_FIELD_DESC);
                    tprotocol.writeString(browseriddata.encodedBrowserId);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(BrowserIdData.STATE_FIELD_DESC);
                tprotocol.writeI32(browseriddata.state);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (BrowserIdData)tbase);
            }

            private BrowserIdDataStandardScheme()
            {
            }

            BrowserIdDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class BrowserIdDataTupleSchemeFactory
        implements SchemeFactory
    {

        public BrowserIdDataTupleScheme getScheme()
        {
            return new BrowserIdDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private BrowserIdDataTupleSchemeFactory()
        {
        }

        BrowserIdDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class BrowserIdDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, BrowserIdData browseriddata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    browseriddata.browserId = tprotocol.readString();
                    browseriddata.setBrowserIdIsSet(true);
                }
                if (bitset.get(1))
                {
                    browseriddata.encodedBrowserId = tprotocol.readString();
                    browseriddata.setEncodedBrowserIdIsSet(true);
                }
                if (bitset.get(2))
                {
                    browseriddata.state = tprotocol.readI32();
                    browseriddata.setStateIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (BrowserIdData)tbase);
            }

            public void write(TProtocol tprotocol, BrowserIdData browseriddata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (browseriddata.isSetBrowserId())
                {
                    bitset.set(0);
                }
                if (browseriddata.isSetEncodedBrowserId())
                {
                    bitset.set(1);
                }
                if (browseriddata.isSetState())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (browseriddata.isSetBrowserId())
                {
                    tprotocol.writeString(browseriddata.browserId);
                }
                if (browseriddata.isSetEncodedBrowserId())
                {
                    tprotocol.writeString(browseriddata.encodedBrowserId);
                }
                if (browseriddata.isSetState())
                {
                    tprotocol.writeI32(browseriddata.state);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (BrowserIdData)tbase);
            }

            private BrowserIdDataTupleScheme()
            {
            }

            BrowserIdDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
