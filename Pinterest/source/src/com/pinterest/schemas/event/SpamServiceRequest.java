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
//            RequestInfo, LimitResult

public class SpamServiceRequest
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField HOST_FIELD_DESC = new TField("host", (byte)11, (short)3);
    private static final TField REQUEST_FIELD_DESC = new TField("request", (byte)12, (short)1);
    private static final TField RESULT_FIELD_DESC = new TField("result", (byte)12, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("SpamServiceRequest");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)4);
    private static final int __TIME_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public String host;
    public RequestInfo request;
    public LimitResult result;
    public long time;

    public SpamServiceRequest()
    {
        __isset_bitfield = 0;
    }

    public SpamServiceRequest(RequestInfo requestinfo, LimitResult limitresult, String s, long l)
    {
        this();
        request = requestinfo;
        result = limitresult;
        host = s;
        time = l;
        setTimeIsSet(true);
    }

    public SpamServiceRequest(SpamServiceRequest spamservicerequest)
    {
        __isset_bitfield = 0;
        __isset_bitfield = spamservicerequest.__isset_bitfield;
        if (spamservicerequest.isSetRequest())
        {
            request = new RequestInfo(spamservicerequest.request);
        }
        if (spamservicerequest.isSetResult())
        {
            result = new LimitResult(spamservicerequest.result);
        }
        if (spamservicerequest.isSetHost())
        {
            host = spamservicerequest.host;
        }
        time = spamservicerequest.time;
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
        request = null;
        result = null;
        host = null;
        setTimeIsSet(false);
        time = 0L;
    }

    public int compareTo(SpamServiceRequest spamservicerequest)
    {
        if (getClass().equals(spamservicerequest.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(spamservicerequest.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetRequest()).compareTo(Boolean.valueOf(spamservicerequest.isSetRequest()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetRequest())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(request, spamservicerequest.request);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetResult()).compareTo(Boolean.valueOf(spamservicerequest.isSetResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(result, spamservicerequest.result);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetHost()).compareTo(Boolean.valueOf(spamservicerequest.isSetHost()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetHost())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(host, spamservicerequest.host);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(spamservicerequest.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, spamservicerequest.time);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SpamServiceRequest)obj);
    }

    public SpamServiceRequest deepCopy()
    {
        return new SpamServiceRequest(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(SpamServiceRequest spamservicerequest)
    {
        if (spamservicerequest != null)
        {
            boolean flag = isSetRequest();
            boolean flag3 = spamservicerequest.isSetRequest();
            if (!flag && !flag3 || flag && flag3 && request.equals(spamservicerequest.request))
            {
                boolean flag1 = isSetResult();
                boolean flag4 = spamservicerequest.isSetResult();
                if (!flag1 && !flag4 || flag1 && flag4 && result.equals(spamservicerequest.result))
                {
                    boolean flag2 = isSetHost();
                    boolean flag5 = spamservicerequest.isSetHost();
                    if ((!flag2 && !flag5 || flag2 && flag5 && host.equals(spamservicerequest.host)) && time == spamservicerequest.time)
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
        while (obj == null || !(obj instanceof SpamServiceRequest)) 
        {
            return false;
        }
        return equals((SpamServiceRequest)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SpamServiceRequest._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getRequest();

        case 2: // '\002'
            return getResult();

        case 3: // '\003'
            return getHost();

        case 4: // '\004'
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

    public RequestInfo getRequest()
    {
        return request;
    }

    public LimitResult getResult()
    {
        return result;
    }

    public long getTime()
    {
        return time;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetRequest();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(request);
        }
        flag = isSetResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(result);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SpamServiceRequest._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetRequest();

        case 2: // '\002'
            return isSetResult();

        case 3: // '\003'
            return isSetHost();

        case 4: // '\004'
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

    public boolean isSetRequest()
    {
        return request != null;
    }

    public boolean isSetResult()
    {
        return result != null;
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SpamServiceRequest._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetRequest();
                return;
            } else
            {
                setRequest((RequestInfo)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetResult();
                return;
            } else
            {
                setResult((LimitResult)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetHost();
                return;
            } else
            {
                setHost((String)obj);
                return;
            }

        case 4: // '\004'
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

    public SpamServiceRequest setHost(String s)
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

    public SpamServiceRequest setRequest(RequestInfo requestinfo)
    {
        request = requestinfo;
        return this;
    }

    public void setRequestIsSet(boolean flag)
    {
        if (!flag)
        {
            request = null;
        }
    }

    public SpamServiceRequest setResult(LimitResult limitresult)
    {
        result = limitresult;
        return this;
    }

    public void setResultIsSet(boolean flag)
    {
        if (!flag)
        {
            result = null;
        }
    }

    public SpamServiceRequest setTime(long l)
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
        StringBuilder stringbuilder = new StringBuilder("SpamServiceRequest(");
        stringbuilder.append("request:");
        if (request == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(request);
        }
        stringbuilder.append(", ");
        stringbuilder.append("result:");
        if (result == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(result);
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

    public void unsetRequest()
    {
        request = null;
    }

    public void unsetResult()
    {
        result = null;
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void validate()
    {
        if (request != null)
        {
            request.validate();
        }
        if (result != null)
        {
            result.validate();
        }
    }

    public void write(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().write(tprotocol, this);
    }

    static 
    {
        Object obj = new HashMap();
        schemes = ((Map) (obj));
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new SpamServiceRequestStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new SpamServiceRequestTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/SpamServiceRequest$_Fields);
        ((Map) (obj)).put(_Fields.REQUEST, new FieldMetaData("request", (byte)3, new StructMetaData((byte)12, com/pinterest/schemas/event/RequestInfo)));
        ((Map) (obj)).put(_Fields.RESULT, new FieldMetaData("result", (byte)3, new StructMetaData((byte)12, com/pinterest/schemas/event/LimitResult)));
        ((Map) (obj)).put(_Fields.HOST, new FieldMetaData("host", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/SpamServiceRequest, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields HOST;
        public static final _Fields REQUEST;
        public static final _Fields RESULT;
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
                return REQUEST;

            case 2: // '\002'
                return RESULT;

            case 3: // '\003'
                return HOST;

            case 4: // '\004'
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/SpamServiceRequest$_Fields, s);
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
            REQUEST = new _Fields("REQUEST", 0, (short)1, "request");
            RESULT = new _Fields("RESULT", 1, (short)2, "result");
            HOST = new _Fields("HOST", 2, (short)3, "host");
            TIME = new _Fields("TIME", 3, (short)4, "time");
            $VALUES = (new _Fields[] {
                REQUEST, RESULT, HOST, TIME
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/SpamServiceRequest$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields[_Fields.REQUEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields[_Fields.RESULT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields[_Fields.HOST.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SpamServiceRequest$_Fields[_Fields.TIME.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class SpamServiceRequestStandardSchemeFactory
        implements SchemeFactory
    {

        public SpamServiceRequestStandardScheme getScheme()
        {
            return new SpamServiceRequestStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SpamServiceRequestStandardSchemeFactory()
        {
        }

        SpamServiceRequestStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SpamServiceRequestStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_233;
                }
                tfield.id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 114
            //                           3 161
            //                           4 197;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_197;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (tfield.type == 12)
                {
                    spamservicerequest.request = new RequestInfo();
                    spamservicerequest.request.read(tprotocol);
                    spamservicerequest.setRequestIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L3:
                if (tfield.type == 12)
                {
                    spamservicerequest.result = new LimitResult();
                    spamservicerequest.result.read(tprotocol);
                    spamservicerequest.setResultIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L4:
                if (tfield.type == 11)
                {
                    spamservicerequest.host = tprotocol.readString();
                    spamservicerequest.setHostIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                if (tfield.type == 10)
                {
                    spamservicerequest.time = tprotocol.readI64();
                    spamservicerequest.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                spamservicerequest.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SpamServiceRequest)tbase);
            }

            public void write(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
            {
                spamservicerequest.validate();
                tprotocol.writeStructBegin(SpamServiceRequest.STRUCT_DESC);
                if (spamservicerequest.request != null)
                {
                    tprotocol.writeFieldBegin(SpamServiceRequest.REQUEST_FIELD_DESC);
                    spamservicerequest.request.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (spamservicerequest.result != null)
                {
                    tprotocol.writeFieldBegin(SpamServiceRequest.RESULT_FIELD_DESC);
                    spamservicerequest.result.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (spamservicerequest.host != null)
                {
                    tprotocol.writeFieldBegin(SpamServiceRequest.HOST_FIELD_DESC);
                    tprotocol.writeString(spamservicerequest.host);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(SpamServiceRequest.TIME_FIELD_DESC);
                tprotocol.writeI64(spamservicerequest.time);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SpamServiceRequest)tbase);
            }

            private SpamServiceRequestStandardScheme()
            {
            }

            SpamServiceRequestStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class SpamServiceRequestTupleSchemeFactory
        implements SchemeFactory
    {

        public SpamServiceRequestTupleScheme getScheme()
        {
            return new SpamServiceRequestTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SpamServiceRequestTupleSchemeFactory()
        {
        }

        SpamServiceRequestTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SpamServiceRequestTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    spamservicerequest.request = new RequestInfo();
                    spamservicerequest.request.read(tprotocol);
                    spamservicerequest.setRequestIsSet(true);
                }
                if (bitset.get(1))
                {
                    spamservicerequest.result = new LimitResult();
                    spamservicerequest.result.read(tprotocol);
                    spamservicerequest.setResultIsSet(true);
                }
                if (bitset.get(2))
                {
                    spamservicerequest.host = tprotocol.readString();
                    spamservicerequest.setHostIsSet(true);
                }
                if (bitset.get(3))
                {
                    spamservicerequest.time = tprotocol.readI64();
                    spamservicerequest.setTimeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SpamServiceRequest)tbase);
            }

            public void write(TProtocol tprotocol, SpamServiceRequest spamservicerequest)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (spamservicerequest.isSetRequest())
                {
                    bitset.set(0);
                }
                if (spamservicerequest.isSetResult())
                {
                    bitset.set(1);
                }
                if (spamservicerequest.isSetHost())
                {
                    bitset.set(2);
                }
                if (spamservicerequest.isSetTime())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (spamservicerequest.isSetRequest())
                {
                    spamservicerequest.request.write(tprotocol);
                }
                if (spamservicerequest.isSetResult())
                {
                    spamservicerequest.result.write(tprotocol);
                }
                if (spamservicerequest.isSetHost())
                {
                    tprotocol.writeString(spamservicerequest.host);
                }
                if (spamservicerequest.isSetTime())
                {
                    tprotocol.writeI64(spamservicerequest.time);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SpamServiceRequest)tbase);
            }

            private SpamServiceRequestTupleScheme()
            {
            }

            SpamServiceRequestTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
