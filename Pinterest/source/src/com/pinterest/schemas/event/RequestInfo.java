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
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

public class RequestInfo
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField IP_ADDRESSES_FIELD_DESC = new TField("ipAddresses", (byte)15, (short)1);
    private static final TField REQUEST_HEADERS_FIELD_DESC = new TField("requestHeaders", (byte)13, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("RequestInfo");
    public static final Map metaDataMap;
    private static final Map schemes;
    public List ipAddresses;
    public Map requestHeaders;

    public RequestInfo()
    {
    }

    public RequestInfo(RequestInfo requestinfo)
    {
        if (requestinfo.isSetIpAddresses())
        {
            ipAddresses = new ArrayList(requestinfo.ipAddresses);
        }
        if (requestinfo.isSetRequestHeaders())
        {
            requestHeaders = new HashMap(requestinfo.requestHeaders);
        }
    }

    public RequestInfo(List list, Map map)
    {
        this();
        ipAddresses = list;
        requestHeaders = map;
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

    public void addToIpAddresses(String s)
    {
        if (ipAddresses == null)
        {
            ipAddresses = new ArrayList();
        }
        ipAddresses.add(s);
    }

    public void clear()
    {
        ipAddresses = null;
        requestHeaders = null;
    }

    public int compareTo(RequestInfo requestinfo)
    {
        if (getClass().equals(requestinfo.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(requestinfo.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetIpAddresses()).compareTo(Boolean.valueOf(requestinfo.isSetIpAddresses()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetIpAddresses())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(ipAddresses, requestinfo.ipAddresses);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetRequestHeaders()).compareTo(Boolean.valueOf(requestinfo.isSetRequestHeaders()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetRequestHeaders())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestHeaders, requestinfo.requestHeaders);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RequestInfo)obj);
    }

    public RequestInfo deepCopy()
    {
        return new RequestInfo(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RequestInfo requestinfo)
    {
        if (requestinfo != null)
        {
            boolean flag = isSetIpAddresses();
            boolean flag2 = requestinfo.isSetIpAddresses();
            if (!flag && !flag2 || flag && flag2 && ipAddresses.equals(requestinfo.ipAddresses))
            {
                boolean flag1 = isSetRequestHeaders();
                boolean flag3 = requestinfo.isSetRequestHeaders();
                if (!flag1 && !flag3 || flag1 && flag3 && requestHeaders.equals(requestinfo.requestHeaders))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof RequestInfo)) 
        {
            return false;
        }
        return equals((RequestInfo)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RequestInfo._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getIpAddresses();

        case 2: // '\002'
            return getRequestHeaders();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getIpAddresses()
    {
        return ipAddresses;
    }

    public Iterator getIpAddressesIterator()
    {
        if (ipAddresses == null)
        {
            return null;
        } else
        {
            return ipAddresses.iterator();
        }
    }

    public int getIpAddressesSize()
    {
        if (ipAddresses == null)
        {
            return 0;
        } else
        {
            return ipAddresses.size();
        }
    }

    public Map getRequestHeaders()
    {
        return requestHeaders;
    }

    public int getRequestHeadersSize()
    {
        if (requestHeaders == null)
        {
            return 0;
        } else
        {
            return requestHeaders.size();
        }
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetIpAddresses();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(ipAddresses);
        }
        flag = isSetRequestHeaders();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestHeaders);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RequestInfo._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetIpAddresses();

        case 2: // '\002'
            return isSetRequestHeaders();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetIpAddresses()
    {
        return ipAddresses != null;
    }

    public boolean isSetRequestHeaders()
    {
        return requestHeaders != null;
    }

    public void putToRequestHeaders(String s, String s1)
    {
        if (requestHeaders == null)
        {
            requestHeaders = new HashMap();
        }
        requestHeaders.put(s, s1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RequestInfo._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetIpAddresses();
                return;
            } else
            {
                setIpAddresses((List)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetRequestHeaders();
            return;
        } else
        {
            setRequestHeaders((Map)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RequestInfo setIpAddresses(List list)
    {
        ipAddresses = list;
        return this;
    }

    public void setIpAddressesIsSet(boolean flag)
    {
        if (!flag)
        {
            ipAddresses = null;
        }
    }

    public RequestInfo setRequestHeaders(Map map)
    {
        requestHeaders = map;
        return this;
    }

    public void setRequestHeadersIsSet(boolean flag)
    {
        if (!flag)
        {
            requestHeaders = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("RequestInfo(");
        stringbuilder.append("ipAddresses:");
        if (ipAddresses == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(ipAddresses);
        }
        stringbuilder.append(", ");
        stringbuilder.append("requestHeaders:");
        if (requestHeaders == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(requestHeaders);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetIpAddresses()
    {
        ipAddresses = null;
    }

    public void unsetRequestHeaders()
    {
        requestHeaders = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RequestInfoStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RequestInfoTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/RequestInfo$_Fields);
        ((Map) (obj)).put(_Fields.IP_ADDRESSES, new FieldMetaData("ipAddresses", (byte)3, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.REQUEST_HEADERS, new FieldMetaData("requestHeaders", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/RequestInfo, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields IP_ADDRESSES;
        public static final _Fields REQUEST_HEADERS;
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
                return IP_ADDRESSES;

            case 2: // '\002'
                return REQUEST_HEADERS;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/RequestInfo$_Fields, s);
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
            IP_ADDRESSES = new _Fields("IP_ADDRESSES", 0, (short)1, "ipAddresses");
            REQUEST_HEADERS = new _Fields("REQUEST_HEADERS", 1, (short)2, "requestHeaders");
            $VALUES = (new _Fields[] {
                IP_ADDRESSES, REQUEST_HEADERS
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/RequestInfo$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$RequestInfo$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$RequestInfo$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RequestInfo$_Fields[_Fields.IP_ADDRESSES.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RequestInfo$_Fields[_Fields.REQUEST_HEADERS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RequestInfoStandardSchemeFactory
        implements SchemeFactory
    {

        public RequestInfoStandardScheme getScheme()
        {
            return new RequestInfoStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RequestInfoStandardSchemeFactory()
        {
        }

        RequestInfoStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RequestInfoStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RequestInfo requestinfo)
            {
                tprotocol.readStructBegin();
_L2:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_251;
                }
                switch (((TField) (obj)).id)
                {
                default:
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                    break;

                case 1: // '\001'
                    break; /* Loop/switch isn't completed */

                case 2: // '\002'
                    break MISSING_BLOCK_LABEL_150;
                }
_L3:
                tprotocol.readFieldEnd();
                if (true) goto _L2; else goto _L1
_L1:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    requestinfo.ipAddresses = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        String s = tprotocol.readString();
                        requestinfo.ipAddresses.add(s);
                    }

                    tprotocol.readListEnd();
                    requestinfo.setIpAddressesIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L3
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    requestinfo.requestHeaders = new HashMap(((TMap) (obj)).size * 2);
                    for (int j = 0; j < ((TMap) (obj)).size; j++)
                    {
                        String s1 = tprotocol.readString();
                        String s2 = tprotocol.readString();
                        requestinfo.requestHeaders.put(s1, s2);
                    }

                    tprotocol.readMapEnd();
                    requestinfo.setRequestHeadersIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                requestinfo.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RequestInfo)tbase);
            }

            public void write(TProtocol tprotocol, RequestInfo requestinfo)
            {
                requestinfo.validate();
                tprotocol.writeStructBegin(RequestInfo.STRUCT_DESC);
                if (requestinfo.ipAddresses != null)
                {
                    tprotocol.writeFieldBegin(RequestInfo.IP_ADDRESSES_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)11, requestinfo.ipAddresses.size()));
                    for (Iterator iterator = requestinfo.ipAddresses.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (requestinfo.requestHeaders != null)
                {
                    tprotocol.writeFieldBegin(RequestInfo.REQUEST_HEADERS_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, requestinfo.requestHeaders.size()));
                    java.util.Map.Entry entry;
                    for (requestinfo = requestinfo.requestHeaders.entrySet().iterator(); requestinfo.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)requestinfo.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RequestInfo)tbase);
            }

            private RequestInfoStandardScheme()
            {
            }

            RequestInfoStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RequestInfoTupleSchemeFactory
        implements SchemeFactory
    {

        public RequestInfoTupleScheme getScheme()
        {
            return new RequestInfoTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RequestInfoTupleSchemeFactory()
        {
        }

        RequestInfoTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RequestInfoTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RequestInfo requestinfo)
            {
                boolean flag = false;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)11, tprotocol.readI32());
                    requestinfo.ipAddresses = new ArrayList(tlist.size);
                    for (int i = 0; i < tlist.size; i++)
                    {
                        String s1 = tprotocol.readString();
                        requestinfo.ipAddresses.add(s1);
                    }

                    requestinfo.setIpAddressesIsSet(true);
                }
                if (bitset.get(1))
                {
                    TMap tmap = new TMap((byte)11, (byte)11, tprotocol.readI32());
                    requestinfo.requestHeaders = new HashMap(tmap.size * 2);
                    for (int j = ((flag) ? 1 : 0); j < tmap.size; j++)
                    {
                        String s = tprotocol.readString();
                        String s2 = tprotocol.readString();
                        requestinfo.requestHeaders.put(s, s2);
                    }

                    requestinfo.setRequestHeadersIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RequestInfo)tbase);
            }

            public void write(TProtocol tprotocol, RequestInfo requestinfo)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (requestinfo.isSetIpAddresses())
                {
                    bitset.set(0);
                }
                if (requestinfo.isSetRequestHeaders())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (requestinfo.isSetIpAddresses())
                {
                    tprotocol.writeI32(requestinfo.ipAddresses.size());
                    for (Iterator iterator = requestinfo.ipAddresses.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                }
                if (requestinfo.isSetRequestHeaders())
                {
                    tprotocol.writeI32(requestinfo.requestHeaders.size());
                    java.util.Map.Entry entry;
                    for (requestinfo = requestinfo.requestHeaders.entrySet().iterator(); requestinfo.hasNext(); tprotocol.writeString((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)requestinfo.next();
                        tprotocol.writeString((String)entry.getKey());
                    }

                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RequestInfo)tbase);
            }

            private RequestInfoTupleScheme()
            {
            }

            RequestInfoTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
