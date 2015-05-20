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

public class PhantomRedirectHeaders
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField NAME_FIELD_DESC = new TField("name", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomRedirectHeaders");
    private static final TField VALUE_FIELD_DESC = new TField("value", (byte)11, (short)2);
    public static final Map metaDataMap;
    private static final Map schemes;
    public String name;
    public String value;

    public PhantomRedirectHeaders()
    {
    }

    public PhantomRedirectHeaders(PhantomRedirectHeaders phantomredirectheaders)
    {
        if (phantomredirectheaders.isSetName())
        {
            name = phantomredirectheaders.name;
        }
        if (phantomredirectheaders.isSetValue())
        {
            value = phantomredirectheaders.value;
        }
    }

    public PhantomRedirectHeaders(String s, String s1)
    {
        this();
        name = s;
        value = s1;
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
        name = null;
        value = null;
    }

    public int compareTo(PhantomRedirectHeaders phantomredirectheaders)
    {
        if (getClass().equals(phantomredirectheaders.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomredirectheaders.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetName()).compareTo(Boolean.valueOf(phantomredirectheaders.isSetName()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetName())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(name, phantomredirectheaders.name);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetValue()).compareTo(Boolean.valueOf(phantomredirectheaders.isSetValue()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetValue())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(value, phantomredirectheaders.value);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomRedirectHeaders)obj);
    }

    public PhantomRedirectHeaders deepCopy()
    {
        return new PhantomRedirectHeaders(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomRedirectHeaders phantomredirectheaders)
    {
        if (phantomredirectheaders != null)
        {
            boolean flag = isSetName();
            boolean flag2 = phantomredirectheaders.isSetName();
            if (!flag && !flag2 || flag && flag2 && name.equals(phantomredirectheaders.name))
            {
                boolean flag1 = isSetValue();
                boolean flag3 = phantomredirectheaders.isSetValue();
                if (!flag1 && !flag3 || flag1 && flag3 && value.equals(phantomredirectheaders.value))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PhantomRedirectHeaders)) 
        {
            return false;
        }
        return equals((PhantomRedirectHeaders)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectHeaders._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getName();

        case 2: // '\002'
            return getValue();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetName();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(name);
        }
        flag = isSetValue();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(value);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectHeaders._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetName();

        case 2: // '\002'
            return isSetValue();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetName()
    {
        return name != null;
    }

    public boolean isSetValue()
    {
        return value != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectHeaders._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetName();
                return;
            } else
            {
                setName((String)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetValue();
            return;
        } else
        {
            setValue((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomRedirectHeaders setName(String s)
    {
        name = s;
        return this;
    }

    public void setNameIsSet(boolean flag)
    {
        if (!flag)
        {
            name = null;
        }
    }

    public PhantomRedirectHeaders setValue(String s)
    {
        value = s;
        return this;
    }

    public void setValueIsSet(boolean flag)
    {
        if (!flag)
        {
            value = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PhantomRedirectHeaders(");
        stringbuilder.append("name:");
        if (name == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(name);
        }
        stringbuilder.append(", ");
        stringbuilder.append("value:");
        if (value == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(value);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetName()
    {
        name = null;
    }

    public void unsetValue()
    {
        value = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomRedirectHeadersStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomRedirectHeadersTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/PhantomRedirectHeaders$_Fields);
        ((Map) (obj)).put(_Fields.NAME, new FieldMetaData("name", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.VALUE, new FieldMetaData("value", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomRedirectHeaders, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields NAME;
        public static final _Fields VALUE;
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
                return NAME;

            case 2: // '\002'
                return VALUE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomRedirectHeaders$_Fields, s);
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
            NAME = new _Fields("NAME", 0, (short)1, "name");
            VALUE = new _Fields("VALUE", 1, (short)2, "value");
            $VALUES = (new _Fields[] {
                NAME, VALUE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomRedirectHeaders$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomRedirectHeaders$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomRedirectHeaders$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectHeaders$_Fields[_Fields.NAME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectHeaders$_Fields[_Fields.VALUE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomRedirectHeadersStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomRedirectHeadersStandardScheme getScheme()
        {
            return new PhantomRedirectHeadersStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRedirectHeadersStandardSchemeFactory()
        {
        }

        PhantomRedirectHeadersStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRedirectHeadersStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
            {
                tprotocol.readStructBegin();
_L2:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_131;
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
                if (tfield.type == 11)
                {
                    phantomredirectheaders.name = tprotocol.readString();
                    phantomredirectheaders.setNameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                if (tfield.type == 11)
                {
                    phantomredirectheaders.value = tprotocol.readString();
                    phantomredirectheaders.setValueIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                phantomredirectheaders.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRedirectHeaders)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
            {
                phantomredirectheaders.validate();
                tprotocol.writeStructBegin(PhantomRedirectHeaders.STRUCT_DESC);
                if (phantomredirectheaders.name != null)
                {
                    tprotocol.writeFieldBegin(PhantomRedirectHeaders.NAME_FIELD_DESC);
                    tprotocol.writeString(phantomredirectheaders.name);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectheaders.value != null)
                {
                    tprotocol.writeFieldBegin(PhantomRedirectHeaders.VALUE_FIELD_DESC);
                    tprotocol.writeString(phantomredirectheaders.value);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRedirectHeaders)tbase);
            }

            private PhantomRedirectHeadersStandardScheme()
            {
            }

            PhantomRedirectHeadersStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomRedirectHeadersTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomRedirectHeadersTupleScheme getScheme()
        {
            return new PhantomRedirectHeadersTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRedirectHeadersTupleSchemeFactory()
        {
        }

        PhantomRedirectHeadersTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRedirectHeadersTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    phantomredirectheaders.name = tprotocol.readString();
                    phantomredirectheaders.setNameIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomredirectheaders.value = tprotocol.readString();
                    phantomredirectheaders.setValueIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRedirectHeaders)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRedirectHeaders phantomredirectheaders)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomredirectheaders.isSetName())
                {
                    bitset.set(0);
                }
                if (phantomredirectheaders.isSetValue())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (phantomredirectheaders.isSetName())
                {
                    tprotocol.writeString(phantomredirectheaders.name);
                }
                if (phantomredirectheaders.isSetValue())
                {
                    tprotocol.writeString(phantomredirectheaders.value);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRedirectHeaders)tbase);
            }

            private PhantomRedirectHeadersTupleScheme()
            {
            }

            PhantomRedirectHeadersTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
