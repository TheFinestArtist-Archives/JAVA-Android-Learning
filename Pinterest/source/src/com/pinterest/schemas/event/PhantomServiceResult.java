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
import org.apache.thrift.EncodingUtils;
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
//            PhantomScraperResult

public class PhantomServiceResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField HOST_FIELD_DESC = new TField("host", (byte)11, (short)2);
    private static final TField PHANTOM_RESULT_FIELD_DESC = new TField("phantomResult", (byte)15, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomServiceResult");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)3);
    private static final int __TIME_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public String host;
    public List phantomResult;
    public long time;

    public PhantomServiceResult()
    {
        __isset_bitfield = 0;
    }

    public PhantomServiceResult(PhantomServiceResult phantomserviceresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomserviceresult.__isset_bitfield;
        if (phantomserviceresult.isSetPhantomResult())
        {
            ArrayList arraylist = new ArrayList(phantomserviceresult.phantomResult.size());
            for (Iterator iterator = phantomserviceresult.phantomResult.iterator(); iterator.hasNext(); arraylist.add(new PhantomScraperResult((PhantomScraperResult)iterator.next()))) { }
            phantomResult = arraylist;
        }
        if (phantomserviceresult.isSetHost())
        {
            host = phantomserviceresult.host;
        }
        time = phantomserviceresult.time;
    }

    public PhantomServiceResult(List list, String s, long l)
    {
        this();
        phantomResult = list;
        host = s;
        time = l;
        setTimeIsSet(true);
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

    public void addToPhantomResult(PhantomScraperResult phantomscraperresult)
    {
        if (phantomResult == null)
        {
            phantomResult = new ArrayList();
        }
        phantomResult.add(phantomscraperresult);
    }

    public void clear()
    {
        phantomResult = null;
        host = null;
        setTimeIsSet(false);
        time = 0L;
    }

    public int compareTo(PhantomServiceResult phantomserviceresult)
    {
        if (getClass().equals(phantomserviceresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomserviceresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetPhantomResult()).compareTo(Boolean.valueOf(phantomserviceresult.isSetPhantomResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetPhantomResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(phantomResult, phantomserviceresult.phantomResult);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetHost()).compareTo(Boolean.valueOf(phantomserviceresult.isSetHost()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetHost())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(host, phantomserviceresult.host);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(phantomserviceresult.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, phantomserviceresult.time);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomServiceResult)obj);
    }

    public PhantomServiceResult deepCopy()
    {
        return new PhantomServiceResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomServiceResult phantomserviceresult)
    {
        if (phantomserviceresult != null)
        {
            boolean flag = isSetPhantomResult();
            boolean flag2 = phantomserviceresult.isSetPhantomResult();
            if (!flag && !flag2 || flag && flag2 && phantomResult.equals(phantomserviceresult.phantomResult))
            {
                boolean flag1 = isSetHost();
                boolean flag3 = phantomserviceresult.isSetHost();
                if ((!flag1 && !flag3 || flag1 && flag3 && host.equals(phantomserviceresult.host)) && time == phantomserviceresult.time)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PhantomServiceResult)) 
        {
            return false;
        }
        return equals((PhantomServiceResult)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getPhantomResult();

        case 2: // '\002'
            return getHost();

        case 3: // '\003'
            return Long.valueOf(getTime());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getHost()
    {
        return host;
    }

    public List getPhantomResult()
    {
        return phantomResult;
    }

    public Iterator getPhantomResultIterator()
    {
        if (phantomResult == null)
        {
            return null;
        } else
        {
            return phantomResult.iterator();
        }
    }

    public int getPhantomResultSize()
    {
        if (phantomResult == null)
        {
            return 0;
        } else
        {
            return phantomResult.size();
        }
    }

    public long getTime()
    {
        return time;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetPhantomResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(phantomResult);
        }
        flag = isSetHost();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(host);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetPhantomResult();

        case 2: // '\002'
            return isSetHost();

        case 3: // '\003'
            return isSetTime();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetHost()
    {
        return host != null;
    }

    public boolean isSetPhantomResult()
    {
        return phantomResult != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetPhantomResult();
                return;
            } else
            {
                setPhantomResult((List)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetHost();
                return;
            } else
            {
                setHost((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetTime();
            return;
        } else
        {
            setTime(((Long)obj).longValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomServiceResult setHost(String s)
    {
        host = s;
        return this;
    }

    public void setHostIsSet(boolean flag)
    {
        if (!flag)
        {
            host = null;
        }
    }

    public PhantomServiceResult setPhantomResult(List list)
    {
        phantomResult = list;
        return this;
    }

    public void setPhantomResultIsSet(boolean flag)
    {
        if (!flag)
        {
            phantomResult = null;
        }
    }

    public PhantomServiceResult setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PhantomServiceResult(");
        stringbuilder.append("phantomResult:");
        if (phantomResult == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(phantomResult);
        }
        stringbuilder.append(", ");
        stringbuilder.append("host:");
        if (host == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(host);
        }
        stringbuilder.append(", ");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetHost()
    {
        host = null;
    }

    public void unsetPhantomResult()
    {
        phantomResult = null;
    }

    public void unsetTime()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomServiceResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomServiceResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/PhantomServiceResult$_Fields);
        ((Map) (obj)).put(_Fields.PHANTOM_RESULT, new FieldMetaData("phantomResult", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomScraperResult))));
        ((Map) (obj)).put(_Fields.HOST, new FieldMetaData("host", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomServiceResult, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields HOST;
        public static final _Fields PHANTOM_RESULT;
        public static final _Fields TIME;
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
                return PHANTOM_RESULT;

            case 2: // '\002'
                return HOST;

            case 3: // '\003'
                return TIME;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomServiceResult$_Fields, s);
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
            PHANTOM_RESULT = new _Fields("PHANTOM_RESULT", 0, (short)1, "phantomResult");
            HOST = new _Fields("HOST", 1, (short)2, "host");
            TIME = new _Fields("TIME", 2, (short)3, "time");
            $VALUES = (new _Fields[] {
                PHANTOM_RESULT, HOST, TIME
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomServiceResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomServiceResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomServiceResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceResult$_Fields[_Fields.PHANTOM_RESULT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceResult$_Fields[_Fields.HOST.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceResult$_Fields[_Fields.TIME.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomServiceResultStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomServiceResultStandardScheme getScheme()
        {
            return new PhantomServiceResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomServiceResultStandardSchemeFactory()
        {
        }

        PhantomServiceResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomServiceResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
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
                    phantomserviceresult.phantomResult = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        PhantomScraperResult phantomscraperresult = new PhantomScraperResult();
                        phantomscraperresult.read(tprotocol);
                        phantomserviceresult.phantomResult.add(phantomscraperresult);
                    }

                    tprotocol.readListEnd();
                    phantomserviceresult.setPhantomResultIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
_L3:
                if (((TField) (obj)).type == 11)
                {
                    phantomserviceresult.host = tprotocol.readString();
                    phantomserviceresult.setHostIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                if (((TField) (obj)).type == 10)
                {
                    phantomserviceresult.time = tprotocol.readI64();
                    phantomserviceresult.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                phantomserviceresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomServiceResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
            {
                phantomserviceresult.validate();
                tprotocol.writeStructBegin(PhantomServiceResult.STRUCT_DESC);
                if (phantomserviceresult.phantomResult != null)
                {
                    tprotocol.writeFieldBegin(PhantomServiceResult.PHANTOM_RESULT_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, phantomserviceresult.phantomResult.size()));
                    for (Iterator iterator = phantomserviceresult.phantomResult.iterator(); iterator.hasNext(); ((PhantomScraperResult)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (phantomserviceresult.host != null)
                {
                    tprotocol.writeFieldBegin(PhantomServiceResult.HOST_FIELD_DESC);
                    tprotocol.writeString(phantomserviceresult.host);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(PhantomServiceResult.TIME_FIELD_DESC);
                tprotocol.writeI64(phantomserviceresult.time);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomServiceResult)tbase);
            }

            private PhantomServiceResultStandardScheme()
            {
            }

            PhantomServiceResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomServiceResultTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomServiceResultTupleScheme getScheme()
        {
            return new PhantomServiceResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomServiceResultTupleSchemeFactory()
        {
        }

        PhantomServiceResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomServiceResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    phantomserviceresult.phantomResult = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        PhantomScraperResult phantomscraperresult = new PhantomScraperResult();
                        phantomscraperresult.read(tprotocol);
                        phantomserviceresult.phantomResult.add(phantomscraperresult);
                    }

                    phantomserviceresult.setPhantomResultIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomserviceresult.host = tprotocol.readString();
                    phantomserviceresult.setHostIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomserviceresult.time = tprotocol.readI64();
                    phantomserviceresult.setTimeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomServiceResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomServiceResult phantomserviceresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomserviceresult.isSetPhantomResult())
                {
                    bitset.set(0);
                }
                if (phantomserviceresult.isSetHost())
                {
                    bitset.set(1);
                }
                if (phantomserviceresult.isSetTime())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (phantomserviceresult.isSetPhantomResult())
                {
                    tprotocol.writeI32(phantomserviceresult.phantomResult.size());
                    for (Iterator iterator = phantomserviceresult.phantomResult.iterator(); iterator.hasNext(); ((PhantomScraperResult)iterator.next()).write(tprotocol)) { }
                }
                if (phantomserviceresult.isSetHost())
                {
                    tprotocol.writeString(phantomserviceresult.host);
                }
                if (phantomserviceresult.isSetTime())
                {
                    tprotocol.writeI64(phantomserviceresult.time);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomServiceResult)tbase);
            }

            private PhantomServiceResultTupleScheme()
            {
            }

            PhantomServiceResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
