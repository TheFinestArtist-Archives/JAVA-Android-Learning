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

public class UrlTimingResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TStruct STRUCT_DESC = new TStruct("UrlTimingResult");
    private static final TField TIMING_FIELD_DESC = new TField("timing", (byte)10, (short)2);
    private static final TField URL_FIELD_DESC = new TField("url", (byte)11, (short)1);
    private static final int __TIMING_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public long timing;
    public String url;

    public UrlTimingResult()
    {
        __isset_bitfield = 0;
    }

    public UrlTimingResult(UrlTimingResult urltimingresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = urltimingresult.__isset_bitfield;
        if (urltimingresult.isSetUrl())
        {
            url = urltimingresult.url;
        }
        timing = urltimingresult.timing;
    }

    public UrlTimingResult(String s, long l)
    {
        this();
        url = s;
        timing = l;
        setTimingIsSet(true);
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
        url = null;
        setTimingIsSet(false);
        timing = 0L;
    }

    public int compareTo(UrlTimingResult urltimingresult)
    {
        if (getClass().equals(urltimingresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(urltimingresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetUrl()).compareTo(Boolean.valueOf(urltimingresult.isSetUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(url, urltimingresult.url);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetTiming()).compareTo(Boolean.valueOf(urltimingresult.isSetTiming()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetTiming())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(timing, urltimingresult.timing);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((UrlTimingResult)obj);
    }

    public UrlTimingResult deepCopy()
    {
        return new UrlTimingResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(UrlTimingResult urltimingresult)
    {
        if (urltimingresult != null)
        {
            boolean flag = isSetUrl();
            boolean flag1 = urltimingresult.isSetUrl();
            if ((!flag && !flag1 || flag && flag1 && url.equals(urltimingresult.url)) && timing == urltimingresult.timing)
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof UrlTimingResult)) 
        {
            return false;
        }
        return equals((UrlTimingResult)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlTimingResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getUrl();

        case 2: // '\002'
            return Long.valueOf(getTiming());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public long getTiming()
    {
        return timing;
    }

    public String getUrl()
    {
        return url;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(url);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(timing));
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlTimingResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetUrl();

        case 2: // '\002'
            return isSetTiming();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetTiming()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetUrl()
    {
        return url != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlTimingResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetUrl();
                return;
            } else
            {
                setUrl((String)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetTiming();
            return;
        } else
        {
            setTiming(((Long)obj).longValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public UrlTimingResult setTiming(long l)
    {
        timing = l;
        setTimingIsSet(true);
        return this;
    }

    public void setTimingIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public UrlTimingResult setUrl(String s)
    {
        url = s;
        return this;
    }

    public void setUrlIsSet(boolean flag)
    {
        if (!flag)
        {
            url = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("UrlTimingResult(");
        stringbuilder.append("url:");
        if (url == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(url);
        }
        stringbuilder.append(", ");
        stringbuilder.append("timing:");
        stringbuilder.append(timing);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetTiming()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUrl()
    {
        url = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new UrlTimingResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new UrlTimingResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/UrlTimingResult$_Fields);
        ((Map) (obj)).put(_Fields.URL, new FieldMetaData("url", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TIMING, new FieldMetaData("timing", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/UrlTimingResult, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields TIMING;
        public static final _Fields URL;
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
                return URL;

            case 2: // '\002'
                return TIMING;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/UrlTimingResult$_Fields, s);
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
            URL = new _Fields("URL", 0, (short)1, "url");
            TIMING = new _Fields("TIMING", 1, (short)2, "timing");
            $VALUES = (new _Fields[] {
                URL, TIMING
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/UrlTimingResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$UrlTimingResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$UrlTimingResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlTimingResult$_Fields[_Fields.URL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlTimingResult$_Fields[_Fields.TIMING.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class UrlTimingResultStandardSchemeFactory
        implements SchemeFactory
    {

        public UrlTimingResultStandardScheme getScheme()
        {
            return new UrlTimingResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private UrlTimingResultStandardSchemeFactory()
        {
        }

        UrlTimingResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class UrlTimingResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, UrlTimingResult urltimingresult)
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
                    urltimingresult.url = tprotocol.readString();
                    urltimingresult.setUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                if (tfield.type == 10)
                {
                    urltimingresult.timing = tprotocol.readI64();
                    urltimingresult.setTimingIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                urltimingresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (UrlTimingResult)tbase);
            }

            public void write(TProtocol tprotocol, UrlTimingResult urltimingresult)
            {
                urltimingresult.validate();
                tprotocol.writeStructBegin(UrlTimingResult.STRUCT_DESC);
                if (urltimingresult.url != null)
                {
                    tprotocol.writeFieldBegin(UrlTimingResult.URL_FIELD_DESC);
                    tprotocol.writeString(urltimingresult.url);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(UrlTimingResult.TIMING_FIELD_DESC);
                tprotocol.writeI64(urltimingresult.timing);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (UrlTimingResult)tbase);
            }

            private UrlTimingResultStandardScheme()
            {
            }

            UrlTimingResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class UrlTimingResultTupleSchemeFactory
        implements SchemeFactory
    {

        public UrlTimingResultTupleScheme getScheme()
        {
            return new UrlTimingResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private UrlTimingResultTupleSchemeFactory()
        {
        }

        UrlTimingResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class UrlTimingResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, UrlTimingResult urltimingresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    urltimingresult.url = tprotocol.readString();
                    urltimingresult.setUrlIsSet(true);
                }
                if (bitset.get(1))
                {
                    urltimingresult.timing = tprotocol.readI64();
                    urltimingresult.setTimingIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (UrlTimingResult)tbase);
            }

            public void write(TProtocol tprotocol, UrlTimingResult urltimingresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (urltimingresult.isSetUrl())
                {
                    bitset.set(0);
                }
                if (urltimingresult.isSetTiming())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (urltimingresult.isSetUrl())
                {
                    tprotocol.writeString(urltimingresult.url);
                }
                if (urltimingresult.isSetTiming())
                {
                    tprotocol.writeI64(urltimingresult.timing);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (UrlTimingResult)tbase);
            }

            private UrlTimingResultTupleScheme()
            {
            }

            UrlTimingResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
