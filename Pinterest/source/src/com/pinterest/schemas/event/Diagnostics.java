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

public class Diagnostics
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField HOSTNAME_FIELD_DESC = new TField("hostname", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("Diagnostics");
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public String hostname;

    public Diagnostics()
    {
    }

    public Diagnostics(Diagnostics diagnostics)
    {
        if (diagnostics.isSetHostname())
        {
            hostname = diagnostics.hostname;
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
        hostname = null;
    }

    public int compareTo(Diagnostics diagnostics)
    {
        if (getClass().equals(diagnostics.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(diagnostics.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetHostname()).compareTo(Boolean.valueOf(diagnostics.isSetHostname()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetHostname())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(hostname, diagnostics.hostname);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Diagnostics)obj);
    }

    public Diagnostics deepCopy()
    {
        return new Diagnostics(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(Diagnostics diagnostics)
    {
        if (diagnostics != null)
        {
            boolean flag = isSetHostname();
            boolean flag1 = diagnostics.isSetHostname();
            if (!flag && !flag1 || flag && flag1 && hostname.equals(diagnostics.hostname))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Diagnostics)) 
        {
            return false;
        }
        return equals((Diagnostics)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Diagnostics._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getHostname();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getHostname()
    {
        return hostname;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetHostname();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(hostname);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Diagnostics._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetHostname();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetHostname()
    {
        return hostname != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.Diagnostics._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (obj == null)
        {
            unsetHostname();
            return;
        } else
        {
            setHostname((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public Diagnostics setHostname(String s)
    {
        hostname = s;
        return this;
    }

    public void setHostnameIsSet(boolean flag)
    {
        if (!flag)
        {
            hostname = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Diagnostics(");
        if (isSetHostname())
        {
            stringbuilder.append("hostname:");
            if (hostname == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(hostname);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetHostname()
    {
        hostname = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new DiagnosticsStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new DiagnosticsTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.HOSTNAME
        });
        obj = new EnumMap(com/pinterest/schemas/event/Diagnostics$_Fields);
        ((Map) (obj)).put(_Fields.HOSTNAME, new FieldMetaData("hostname", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/Diagnostics, metaDataMap);
    }



    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields HOSTNAME;
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
                return HOSTNAME;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/Diagnostics$_Fields, s);
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
            HOSTNAME = new _Fields("HOSTNAME", 0, (short)1, "hostname");
            $VALUES = (new _Fields[] {
                HOSTNAME
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/Diagnostics$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$Diagnostics$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$Diagnostics$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$Diagnostics$_Fields[_Fields.HOSTNAME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
        }
    }


    private class DiagnosticsStandardSchemeFactory
        implements SchemeFactory
    {

        public DiagnosticsStandardScheme getScheme()
        {
            return new DiagnosticsStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private DiagnosticsStandardSchemeFactory()
        {
        }

        DiagnosticsStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class DiagnosticsStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, Diagnostics diagnostics)
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
                    diagnostics.hostname = tprotocol.readString();
                    diagnostics.setHostnameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                if (true) goto _L5; else goto _L2
_L2:
                tprotocol.readStructEnd();
                diagnostics.validate();
                return;
                if (true) goto _L7; else goto _L6
_L6:
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Diagnostics)tbase);
            }

            public void write(TProtocol tprotocol, Diagnostics diagnostics)
            {
                diagnostics.validate();
                tprotocol.writeStructBegin(Diagnostics.STRUCT_DESC);
                if (diagnostics.hostname != null && diagnostics.isSetHostname())
                {
                    tprotocol.writeFieldBegin(Diagnostics.HOSTNAME_FIELD_DESC);
                    tprotocol.writeString(diagnostics.hostname);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Diagnostics)tbase);
            }

            private DiagnosticsStandardScheme()
            {
            }

            DiagnosticsStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class DiagnosticsTupleSchemeFactory
        implements SchemeFactory
    {

        public DiagnosticsTupleScheme getScheme()
        {
            return new DiagnosticsTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private DiagnosticsTupleSchemeFactory()
        {
        }

        DiagnosticsTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class DiagnosticsTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, Diagnostics diagnostics)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                if (tprotocol.readBitSet(1).get(0))
                {
                    diagnostics.hostname = tprotocol.readString();
                    diagnostics.setHostnameIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (Diagnostics)tbase);
            }

            public void write(TProtocol tprotocol, Diagnostics diagnostics)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (diagnostics.isSetHostname())
                {
                    bitset.set(0);
                }
                tprotocol.writeBitSet(bitset, 1);
                if (diagnostics.isSetHostname())
                {
                    tprotocol.writeString(diagnostics.hostname);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (Diagnostics)tbase);
            }

            private DiagnosticsTupleScheme()
            {
            }

            DiagnosticsTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
