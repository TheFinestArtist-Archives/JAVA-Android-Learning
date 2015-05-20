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

public class TestData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField KEY_FIELD_DESC = new TField("key", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("TestData");
    public static final Map metaDataMap;
    private static final Map schemes;
    public String key;

    public TestData()
    {
    }

    public TestData(TestData testdata)
    {
        if (testdata.isSetKey())
        {
            key = testdata.key;
        }
    }

    public TestData(String s)
    {
        this();
        key = s;
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
        key = null;
    }

    public int compareTo(TestData testdata)
    {
        if (getClass().equals(testdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(testdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetKey()).compareTo(Boolean.valueOf(testdata.isSetKey()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetKey())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(key, testdata.key);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((TestData)obj);
    }

    public TestData deepCopy()
    {
        return new TestData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(TestData testdata)
    {
        if (testdata != null)
        {
            boolean flag = isSetKey();
            boolean flag1 = testdata.isSetKey();
            if (!flag && !flag1 || flag && flag1 && key.equals(testdata.key))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof TestData)) 
        {
            return false;
        }
        return equals((TestData)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TestData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getKey();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getKey()
    {
        return key;
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
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TestData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetKey();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetKey()
    {
        return key != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TestData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (obj == null)
        {
            unsetKey();
            return;
        } else
        {
            setKey((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public TestData setKey(String s)
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

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("TestData(");
        stringbuilder.append("key:");
        if (key == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(key);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetKey()
    {
        key = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new TestDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new TestDataTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/TestData$_Fields);
        ((Map) (obj)).put(_Fields.KEY, new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/TestData, metaDataMap);
    }



    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields KEY;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/TestData$_Fields, s);
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
            $VALUES = (new _Fields[] {
                KEY
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/TestData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$TestData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$TestData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$TestData$_Fields[_Fields.KEY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
        }
    }


    private class TestDataStandardSchemeFactory
        implements SchemeFactory
    {

        public TestDataStandardScheme getScheme()
        {
            return new TestDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TestDataStandardSchemeFactory()
        {
        }

        TestDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TestDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, TestData testdata)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0) goto _L2; else goto _L1
_L1:
                tfield.id;
                JVM INSTR tableswitch 1 1: default 40
            //                           1 55;
                   goto _L3 _L4
_L3:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L5:
                tprotocol.readFieldEnd();
                continue; /* Loop/switch isn't completed */
_L4:
                if (tfield.type == 11)
                {
                    testdata.key = tprotocol.readString();
                    testdata.setKeyIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                if (true) goto _L5; else goto _L2
_L2:
                tprotocol.readStructEnd();
                testdata.validate();
                return;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TestData)tbase);
            }

            public void write(TProtocol tprotocol, TestData testdata)
            {
                testdata.validate();
                tprotocol.writeStructBegin(TestData.STRUCT_DESC);
                if (testdata.key != null)
                {
                    tprotocol.writeFieldBegin(TestData.KEY_FIELD_DESC);
                    tprotocol.writeString(testdata.key);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TestData)tbase);
            }

            private TestDataStandardScheme()
            {
            }

            TestDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class TestDataTupleSchemeFactory
        implements SchemeFactory
    {

        public TestDataTupleScheme getScheme()
        {
            return new TestDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TestDataTupleSchemeFactory()
        {
        }

        TestDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TestDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, TestData testdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                if (tprotocol.readBitSet(1).get(0))
                {
                    testdata.key = tprotocol.readString();
                    testdata.setKeyIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TestData)tbase);
            }

            public void write(TProtocol tprotocol, TestData testdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (testdata.isSetKey())
                {
                    bitset.set(0);
                }
                tprotocol.writeBitSet(bitset, 1);
                if (testdata.isSetKey())
                {
                    tprotocol.writeString(testdata.key);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TestData)tbase);
            }

            private TestDataTupleScheme()
            {
            }

            TestDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
