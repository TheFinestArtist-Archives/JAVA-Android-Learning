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
import org.apache.thrift.meta_data.EnumMetaData;
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
//            UrlCheckResult, UrlCheckLevel

public class OffsiteServiceResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField CHECK_LEVEL_FIELD_DESC = new TField("checkLevel", (byte)8, (short)4);
    private static final TField HOST_FIELD_DESC = new TField("host", (byte)11, (short)2);
    private static final TField RESULTS_FIELD_DESC = new TField("results", (byte)15, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("OffsiteServiceResult");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)3);
    private static final int __TIME_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public UrlCheckLevel checkLevel;
    public String host;
    public List results;
    public long time;

    public OffsiteServiceResult()
    {
        __isset_bitfield = 0;
    }

    public OffsiteServiceResult(OffsiteServiceResult offsiteserviceresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = offsiteserviceresult.__isset_bitfield;
        if (offsiteserviceresult.isSetResults())
        {
            ArrayList arraylist = new ArrayList(offsiteserviceresult.results.size());
            for (Iterator iterator = offsiteserviceresult.results.iterator(); iterator.hasNext(); arraylist.add(new UrlCheckResult((UrlCheckResult)iterator.next()))) { }
            results = arraylist;
        }
        if (offsiteserviceresult.isSetHost())
        {
            host = offsiteserviceresult.host;
        }
        time = offsiteserviceresult.time;
        if (offsiteserviceresult.isSetCheckLevel())
        {
            checkLevel = offsiteserviceresult.checkLevel;
        }
    }

    public OffsiteServiceResult(List list, String s, long l, UrlCheckLevel urlchecklevel)
    {
        this();
        results = list;
        host = s;
        time = l;
        setTimeIsSet(true);
        checkLevel = urlchecklevel;
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

    public void addToResults(UrlCheckResult urlcheckresult)
    {
        if (results == null)
        {
            results = new ArrayList();
        }
        results.add(urlcheckresult);
    }

    public void clear()
    {
        results = null;
        host = null;
        setTimeIsSet(false);
        time = 0L;
        checkLevel = null;
    }

    public int compareTo(OffsiteServiceResult offsiteserviceresult)
    {
        if (getClass().equals(offsiteserviceresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(offsiteserviceresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetResults()).compareTo(Boolean.valueOf(offsiteserviceresult.isSetResults()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetResults())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(results, offsiteserviceresult.results);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetHost()).compareTo(Boolean.valueOf(offsiteserviceresult.isSetHost()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetHost())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(host, offsiteserviceresult.host);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(offsiteserviceresult.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, offsiteserviceresult.time);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetCheckLevel()).compareTo(Boolean.valueOf(offsiteserviceresult.isSetCheckLevel()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetCheckLevel())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(checkLevel, offsiteserviceresult.checkLevel);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((OffsiteServiceResult)obj);
    }

    public OffsiteServiceResult deepCopy()
    {
        return new OffsiteServiceResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(OffsiteServiceResult offsiteserviceresult)
    {
        if (offsiteserviceresult != null)
        {
            boolean flag = isSetResults();
            boolean flag3 = offsiteserviceresult.isSetResults();
            if (!flag && !flag3 || flag && flag3 && results.equals(offsiteserviceresult.results))
            {
                boolean flag1 = isSetHost();
                boolean flag4 = offsiteserviceresult.isSetHost();
                if ((!flag1 && !flag4 || flag1 && flag4 && host.equals(offsiteserviceresult.host)) && time == offsiteserviceresult.time)
                {
                    boolean flag2 = isSetCheckLevel();
                    boolean flag5 = offsiteserviceresult.isSetCheckLevel();
                    if (!flag2 && !flag5 || flag2 && flag5 && checkLevel.equals(offsiteserviceresult.checkLevel))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof OffsiteServiceResult)) 
        {
            return false;
        }
        return equals((OffsiteServiceResult)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public UrlCheckLevel getCheckLevel()
    {
        return checkLevel;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.OffsiteServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getResults();

        case 2: // '\002'
            return getHost();

        case 3: // '\003'
            return Long.valueOf(getTime());

        case 4: // '\004'
            return getCheckLevel();
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

    public List getResults()
    {
        return results;
    }

    public Iterator getResultsIterator()
    {
        if (results == null)
        {
            return null;
        } else
        {
            return results.iterator();
        }
    }

    public int getResultsSize()
    {
        if (results == null)
        {
            return 0;
        } else
        {
            return results.size();
        }
    }

    public long getTime()
    {
        return time;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetResults();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(results);
        }
        flag = isSetHost();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(host);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        flag = isSetCheckLevel();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(checkLevel.getValue()));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.OffsiteServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetResults();

        case 2: // '\002'
            return isSetHost();

        case 3: // '\003'
            return isSetTime();

        case 4: // '\004'
            return isSetCheckLevel();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetCheckLevel()
    {
        return checkLevel != null;
    }

    public boolean isSetHost()
    {
        return host != null;
    }

    public boolean isSetResults()
    {
        return results != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public OffsiteServiceResult setCheckLevel(UrlCheckLevel urlchecklevel)
    {
        checkLevel = urlchecklevel;
        return this;
    }

    public void setCheckLevelIsSet(boolean flag)
    {
        if (!flag)
        {
            checkLevel = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.OffsiteServiceResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetResults();
                return;
            } else
            {
                setResults((List)obj);
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
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime(((Long)obj).longValue());
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetCheckLevel();
            return;
        } else
        {
            setCheckLevel((UrlCheckLevel)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public OffsiteServiceResult setHost(String s)
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

    public OffsiteServiceResult setResults(List list)
    {
        results = list;
        return this;
    }

    public void setResultsIsSet(boolean flag)
    {
        if (!flag)
        {
            results = null;
        }
    }

    public OffsiteServiceResult setTime(long l)
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
        StringBuilder stringbuilder = new StringBuilder("OffsiteServiceResult(");
        stringbuilder.append("results:");
        if (results == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(results);
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
        stringbuilder.append(", ");
        stringbuilder.append("checkLevel:");
        if (checkLevel == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(checkLevel);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetCheckLevel()
    {
        checkLevel = null;
    }

    public void unsetHost()
    {
        host = null;
    }

    public void unsetResults()
    {
        results = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new OffsiteServiceResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new OffsiteServiceResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/OffsiteServiceResult$_Fields);
        ((Map) (obj)).put(_Fields.RESULTS, new FieldMetaData("results", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/UrlCheckResult))));
        ((Map) (obj)).put(_Fields.HOST, new FieldMetaData("host", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.CHECK_LEVEL, new FieldMetaData("checkLevel", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/UrlCheckLevel)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/OffsiteServiceResult, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields CHECK_LEVEL;
        public static final _Fields HOST;
        public static final _Fields RESULTS;
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
                return RESULTS;

            case 2: // '\002'
                return HOST;

            case 3: // '\003'
                return TIME;

            case 4: // '\004'
                return CHECK_LEVEL;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/OffsiteServiceResult$_Fields, s);
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
            RESULTS = new _Fields("RESULTS", 0, (short)1, "results");
            HOST = new _Fields("HOST", 1, (short)2, "host");
            TIME = new _Fields("TIME", 2, (short)3, "time");
            CHECK_LEVEL = new _Fields("CHECK_LEVEL", 3, (short)4, "checkLevel");
            $VALUES = (new _Fields[] {
                RESULTS, HOST, TIME, CHECK_LEVEL
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/OffsiteServiceResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields[_Fields.RESULTS.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields[_Fields.HOST.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields[_Fields.TIME.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$OffsiteServiceResult$_Fields[_Fields.CHECK_LEVEL.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class OffsiteServiceResultStandardSchemeFactory
        implements SchemeFactory
    {

        public OffsiteServiceResultStandardScheme getScheme()
        {
            return new OffsiteServiceResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private OffsiteServiceResultStandardSchemeFactory()
        {
        }

        OffsiteServiceResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class OffsiteServiceResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
            {
                tprotocol.readStructBegin();
_L7:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_278;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 167
            //                           3 203
            //                           4 239;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_239;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    offsiteserviceresult.results = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        UrlCheckResult urlcheckresult = new UrlCheckResult();
                        urlcheckresult.read(tprotocol);
                        offsiteserviceresult.results.add(urlcheckresult);
                    }

                    tprotocol.readListEnd();
                    offsiteserviceresult.setResultsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L8
_L3:
                if (((TField) (obj)).type == 11)
                {
                    offsiteserviceresult.host = tprotocol.readString();
                    offsiteserviceresult.setHostIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L8
_L4:
                if (((TField) (obj)).type == 10)
                {
                    offsiteserviceresult.time = tprotocol.readI64();
                    offsiteserviceresult.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L8
                if (((TField) (obj)).type == 8)
                {
                    offsiteserviceresult.checkLevel = UrlCheckLevel.findByValue(tprotocol.readI32());
                    offsiteserviceresult.setCheckLevelIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                offsiteserviceresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (OffsiteServiceResult)tbase);
            }

            public void write(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
            {
                offsiteserviceresult.validate();
                tprotocol.writeStructBegin(OffsiteServiceResult.STRUCT_DESC);
                if (offsiteserviceresult.results != null)
                {
                    tprotocol.writeFieldBegin(OffsiteServiceResult.RESULTS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, offsiteserviceresult.results.size()));
                    for (Iterator iterator = offsiteserviceresult.results.iterator(); iterator.hasNext(); ((UrlCheckResult)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (offsiteserviceresult.host != null)
                {
                    tprotocol.writeFieldBegin(OffsiteServiceResult.HOST_FIELD_DESC);
                    tprotocol.writeString(offsiteserviceresult.host);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(OffsiteServiceResult.TIME_FIELD_DESC);
                tprotocol.writeI64(offsiteserviceresult.time);
                tprotocol.writeFieldEnd();
                if (offsiteserviceresult.checkLevel != null)
                {
                    tprotocol.writeFieldBegin(OffsiteServiceResult.CHECK_LEVEL_FIELD_DESC);
                    tprotocol.writeI32(offsiteserviceresult.checkLevel.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (OffsiteServiceResult)tbase);
            }

            private OffsiteServiceResultStandardScheme()
            {
            }

            OffsiteServiceResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class OffsiteServiceResultTupleSchemeFactory
        implements SchemeFactory
    {

        public OffsiteServiceResultTupleScheme getScheme()
        {
            return new OffsiteServiceResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private OffsiteServiceResultTupleSchemeFactory()
        {
        }

        OffsiteServiceResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class OffsiteServiceResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    offsiteserviceresult.results = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        UrlCheckResult urlcheckresult = new UrlCheckResult();
                        urlcheckresult.read(tprotocol);
                        offsiteserviceresult.results.add(urlcheckresult);
                    }

                    offsiteserviceresult.setResultsIsSet(true);
                }
                if (bitset.get(1))
                {
                    offsiteserviceresult.host = tprotocol.readString();
                    offsiteserviceresult.setHostIsSet(true);
                }
                if (bitset.get(2))
                {
                    offsiteserviceresult.time = tprotocol.readI64();
                    offsiteserviceresult.setTimeIsSet(true);
                }
                if (bitset.get(3))
                {
                    offsiteserviceresult.checkLevel = UrlCheckLevel.findByValue(tprotocol.readI32());
                    offsiteserviceresult.setCheckLevelIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (OffsiteServiceResult)tbase);
            }

            public void write(TProtocol tprotocol, OffsiteServiceResult offsiteserviceresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (offsiteserviceresult.isSetResults())
                {
                    bitset.set(0);
                }
                if (offsiteserviceresult.isSetHost())
                {
                    bitset.set(1);
                }
                if (offsiteserviceresult.isSetTime())
                {
                    bitset.set(2);
                }
                if (offsiteserviceresult.isSetCheckLevel())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (offsiteserviceresult.isSetResults())
                {
                    tprotocol.writeI32(offsiteserviceresult.results.size());
                    for (Iterator iterator = offsiteserviceresult.results.iterator(); iterator.hasNext(); ((UrlCheckResult)iterator.next()).write(tprotocol)) { }
                }
                if (offsiteserviceresult.isSetHost())
                {
                    tprotocol.writeString(offsiteserviceresult.host);
                }
                if (offsiteserviceresult.isSetTime())
                {
                    tprotocol.writeI64(offsiteserviceresult.time);
                }
                if (offsiteserviceresult.isSetCheckLevel())
                {
                    tprotocol.writeI32(offsiteserviceresult.checkLevel.getValue());
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (OffsiteServiceResult)tbase);
            }

            private OffsiteServiceResultTupleScheme()
            {
            }

            OffsiteServiceResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
