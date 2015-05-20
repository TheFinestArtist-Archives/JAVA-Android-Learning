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
//            PhantomRedirectHeaders

public class PhantomRedirectResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BODY_FIELD_DESC = new TField("body", (byte)11, (short)3);
    private static final TField HEADERS_FIELD_DESC = new TField("headers", (byte)15, (short)2);
    private static final TField REQUEST_TIME_FIELD_DESC = new TField("requestTime", (byte)11, (short)4);
    private static final TField RESPONSE_TIME_FIELD_DESC = new TField("responseTime", (byte)11, (short)5);
    private static final TField STATUS_FIELD_DESC = new TField("status", (byte)6, (short)6);
    private static final TField STATUS_TEXT_FIELD_DESC = new TField("statusText", (byte)11, (short)7);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomRedirectResult");
    private static final TField URL_FIELD_DESC = new TField("url", (byte)11, (short)1);
    private static final int __STATUS_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String body;
    public List headers;
    public String requestTime;
    public String responseTime;
    public short status;
    public String statusText;
    public String url;

    public PhantomRedirectResult()
    {
        __isset_bitfield = 0;
    }

    public PhantomRedirectResult(PhantomRedirectResult phantomredirectresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomredirectresult.__isset_bitfield;
        if (phantomredirectresult.isSetUrl())
        {
            url = phantomredirectresult.url;
        }
        if (phantomredirectresult.isSetHeaders())
        {
            ArrayList arraylist = new ArrayList(phantomredirectresult.headers.size());
            for (Iterator iterator = phantomredirectresult.headers.iterator(); iterator.hasNext(); arraylist.add(new PhantomRedirectHeaders((PhantomRedirectHeaders)iterator.next()))) { }
            headers = arraylist;
        }
        if (phantomredirectresult.isSetBody())
        {
            body = phantomredirectresult.body;
        }
        if (phantomredirectresult.isSetRequestTime())
        {
            requestTime = phantomredirectresult.requestTime;
        }
        if (phantomredirectresult.isSetResponseTime())
        {
            responseTime = phantomredirectresult.responseTime;
        }
        status = phantomredirectresult.status;
        if (phantomredirectresult.isSetStatusText())
        {
            statusText = phantomredirectresult.statusText;
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

    public void addToHeaders(PhantomRedirectHeaders phantomredirectheaders)
    {
        if (headers == null)
        {
            headers = new ArrayList();
        }
        headers.add(phantomredirectheaders);
    }

    public void clear()
    {
        url = null;
        headers = null;
        body = null;
        requestTime = null;
        responseTime = null;
        setStatusIsSet(false);
        status = 0;
        statusText = null;
    }

    public int compareTo(PhantomRedirectResult phantomredirectresult)
    {
        if (getClass().equals(phantomredirectresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomredirectresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetUrl()).compareTo(Boolean.valueOf(phantomredirectresult.isSetUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(url, phantomredirectresult.url);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetHeaders()).compareTo(Boolean.valueOf(phantomredirectresult.isSetHeaders()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetHeaders())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(headers, phantomredirectresult.headers);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetBody()).compareTo(Boolean.valueOf(phantomredirectresult.isSetBody()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetBody())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(body, phantomredirectresult.body);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetRequestTime()).compareTo(Boolean.valueOf(phantomredirectresult.isSetRequestTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetRequestTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestTime, phantomredirectresult.requestTime);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetResponseTime()).compareTo(Boolean.valueOf(phantomredirectresult.isSetResponseTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetResponseTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(responseTime, phantomredirectresult.responseTime);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetStatus()).compareTo(Boolean.valueOf(phantomredirectresult.isSetStatus()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetStatus())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(status, phantomredirectresult.status);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetStatusText()).compareTo(Boolean.valueOf(phantomredirectresult.isSetStatusText()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetStatusText())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(statusText, phantomredirectresult.statusText);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomRedirectResult)obj);
    }

    public PhantomRedirectResult deepCopy()
    {
        return new PhantomRedirectResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomRedirectResult phantomredirectresult)
    {
        if (phantomredirectresult != null)
        {
            boolean flag = isSetUrl();
            boolean flag7 = phantomredirectresult.isSetUrl();
            if (!flag && !flag7 || flag && flag7 && url.equals(phantomredirectresult.url))
            {
                boolean flag1 = isSetHeaders();
                boolean flag8 = phantomredirectresult.isSetHeaders();
                if (!flag1 && !flag8 || flag1 && flag8 && headers.equals(phantomredirectresult.headers))
                {
                    boolean flag2 = isSetBody();
                    boolean flag9 = phantomredirectresult.isSetBody();
                    if (!flag2 && !flag9 || flag2 && flag9 && body.equals(phantomredirectresult.body))
                    {
                        boolean flag3 = isSetRequestTime();
                        boolean flag10 = phantomredirectresult.isSetRequestTime();
                        if (!flag3 && !flag10 || flag3 && flag10 && requestTime.equals(phantomredirectresult.requestTime))
                        {
                            boolean flag4 = isSetResponseTime();
                            boolean flag11 = phantomredirectresult.isSetResponseTime();
                            if (!flag4 && !flag11 || flag4 && flag11 && responseTime.equals(phantomredirectresult.responseTime))
                            {
                                boolean flag5 = isSetStatus();
                                boolean flag12 = phantomredirectresult.isSetStatus();
                                if (!flag5 && !flag12 || flag5 && flag12 && status == phantomredirectresult.status)
                                {
                                    boolean flag6 = isSetStatusText();
                                    boolean flag13 = phantomredirectresult.isSetStatusText();
                                    if (!flag6 && !flag13 || flag6 && flag13 && statusText.equals(phantomredirectresult.statusText))
                                    {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PhantomRedirectResult)) 
        {
            return false;
        }
        return equals((PhantomRedirectResult)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getBody()
    {
        return body;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getUrl();

        case 2: // '\002'
            return getHeaders();

        case 3: // '\003'
            return getBody();

        case 4: // '\004'
            return getRequestTime();

        case 5: // '\005'
            return getResponseTime();

        case 6: // '\006'
            return Short.valueOf(getStatus());

        case 7: // '\007'
            return getStatusText();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getHeaders()
    {
        return headers;
    }

    public Iterator getHeadersIterator()
    {
        if (headers == null)
        {
            return null;
        } else
        {
            return headers.iterator();
        }
    }

    public int getHeadersSize()
    {
        if (headers == null)
        {
            return 0;
        } else
        {
            return headers.size();
        }
    }

    public String getRequestTime()
    {
        return requestTime;
    }

    public String getResponseTime()
    {
        return responseTime;
    }

    public short getStatus()
    {
        return status;
    }

    public String getStatusText()
    {
        return statusText;
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
        flag = isSetHeaders();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(headers);
        }
        flag = isSetBody();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(body);
        }
        flag = isSetRequestTime();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestTime);
        }
        flag = isSetResponseTime();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(responseTime);
        }
        flag = isSetStatus();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(status));
        }
        flag = isSetStatusText();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(statusText);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetUrl();

        case 2: // '\002'
            return isSetHeaders();

        case 3: // '\003'
            return isSetBody();

        case 4: // '\004'
            return isSetRequestTime();

        case 5: // '\005'
            return isSetResponseTime();

        case 6: // '\006'
            return isSetStatus();

        case 7: // '\007'
            return isSetStatusText();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBody()
    {
        return body != null;
    }

    public boolean isSetHeaders()
    {
        return headers != null;
    }

    public boolean isSetRequestTime()
    {
        return requestTime != null;
    }

    public boolean isSetResponseTime()
    {
        return responseTime != null;
    }

    public boolean isSetStatus()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetStatusText()
    {
        return statusText != null;
    }

    public boolean isSetUrl()
    {
        return url != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PhantomRedirectResult setBody(String s)
    {
        body = s;
        return this;
    }

    public void setBodyIsSet(boolean flag)
    {
        if (!flag)
        {
            body = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRedirectResult._Fields[_pfields.ordinal()])
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
            if (obj == null)
            {
                unsetHeaders();
                return;
            } else
            {
                setHeaders((List)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetBody();
                return;
            } else
            {
                setBody((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetRequestTime();
                return;
            } else
            {
                setRequestTime((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetResponseTime();
                return;
            } else
            {
                setResponseTime((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetStatus();
                return;
            } else
            {
                setStatus(((Short)obj).shortValue());
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetStatusText();
            return;
        } else
        {
            setStatusText((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomRedirectResult setHeaders(List list)
    {
        headers = list;
        return this;
    }

    public void setHeadersIsSet(boolean flag)
    {
        if (!flag)
        {
            headers = null;
        }
    }

    public PhantomRedirectResult setRequestTime(String s)
    {
        requestTime = s;
        return this;
    }

    public void setRequestTimeIsSet(boolean flag)
    {
        if (!flag)
        {
            requestTime = null;
        }
    }

    public PhantomRedirectResult setResponseTime(String s)
    {
        responseTime = s;
        return this;
    }

    public void setResponseTimeIsSet(boolean flag)
    {
        if (!flag)
        {
            responseTime = null;
        }
    }

    public PhantomRedirectResult setStatus(short word0)
    {
        status = word0;
        setStatusIsSet(true);
        return this;
    }

    public void setStatusIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PhantomRedirectResult setStatusText(String s)
    {
        statusText = s;
        return this;
    }

    public void setStatusTextIsSet(boolean flag)
    {
        if (!flag)
        {
            statusText = null;
        }
    }

    public PhantomRedirectResult setUrl(String s)
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
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("PhantomRedirectResult(");
        boolean flag1 = true;
        boolean flag;
        if (isSetUrl())
        {
            stringbuilder.append("url:");
            if (url == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(url);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetHeaders())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("headers:");
            if (headers == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(headers);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetBody())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("body:");
            if (body == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(body);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetRequestTime())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("requestTime:");
            if (requestTime == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(requestTime);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetResponseTime())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("responseTime:");
            if (responseTime == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(responseTime);
            }
            flag1 = false;
        }
        if (isSetStatus())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("status:");
            stringbuilder.append(status);
            flag = flag2;
        } else
        {
            flag = flag1;
        }
        if (isSetStatusText())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("statusText:");
            if (statusText == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(statusText);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBody()
    {
        body = null;
    }

    public void unsetHeaders()
    {
        headers = null;
    }

    public void unsetRequestTime()
    {
        requestTime = null;
    }

    public void unsetResponseTime()
    {
        responseTime = null;
    }

    public void unsetStatus()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetStatusText()
    {
        statusText = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomRedirectResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomRedirectResultTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.URL, _Fields.HEADERS, _Fields.BODY, _Fields.REQUEST_TIME, _Fields.RESPONSE_TIME, _Fields.STATUS, _Fields.STATUS_TEXT
        });
        obj = new EnumMap(com/pinterest/schemas/event/PhantomRedirectResult$_Fields);
        ((Map) (obj)).put(_Fields.URL, new FieldMetaData("url", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.HEADERS, new FieldMetaData("headers", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomRedirectHeaders))));
        ((Map) (obj)).put(_Fields.BODY, new FieldMetaData("body", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.REQUEST_TIME, new FieldMetaData("requestTime", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.RESPONSE_TIME, new FieldMetaData("responseTime", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.STATUS, new FieldMetaData("status", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.STATUS_TEXT, new FieldMetaData("statusText", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomRedirectResult, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BODY;
        public static final _Fields HEADERS;
        public static final _Fields REQUEST_TIME;
        public static final _Fields RESPONSE_TIME;
        public static final _Fields STATUS;
        public static final _Fields STATUS_TEXT;
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
                return HEADERS;

            case 3: // '\003'
                return BODY;

            case 4: // '\004'
                return REQUEST_TIME;

            case 5: // '\005'
                return RESPONSE_TIME;

            case 6: // '\006'
                return STATUS;

            case 7: // '\007'
                return STATUS_TEXT;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomRedirectResult$_Fields, s);
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
            HEADERS = new _Fields("HEADERS", 1, (short)2, "headers");
            BODY = new _Fields("BODY", 2, (short)3, "body");
            REQUEST_TIME = new _Fields("REQUEST_TIME", 3, (short)4, "requestTime");
            RESPONSE_TIME = new _Fields("RESPONSE_TIME", 4, (short)5, "responseTime");
            STATUS = new _Fields("STATUS", 5, (short)6, "status");
            STATUS_TEXT = new _Fields("STATUS_TEXT", 6, (short)7, "statusText");
            $VALUES = (new _Fields[] {
                URL, HEADERS, BODY, REQUEST_TIME, RESPONSE_TIME, STATUS, STATUS_TEXT
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomRedirectResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.URL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.HEADERS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.BODY.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.REQUEST_TIME.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.RESPONSE_TIME.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.STATUS.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRedirectResult$_Fields[_Fields.STATUS_TEXT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomRedirectResultStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomRedirectResultStandardScheme getScheme()
        {
            return new PhantomRedirectResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRedirectResultStandardSchemeFactory()
        {
        }

        PhantomRedirectResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRedirectResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
            {
                tprotocol.readStructBegin();
_L10:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_395;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 115
            //                           3 215
            //                           4 251
            //                           5 287
            //                           6 323
            //                           7 359;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_359;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L11:
                tprotocol.readFieldEnd();
                if (true) goto _L10; else goto _L9
_L9:
                if (((TField) (obj)).type == 11)
                {
                    phantomredirectresult.url = tprotocol.readString();
                    phantomredirectresult.setUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L3:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    phantomredirectresult.headers = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        PhantomRedirectHeaders phantomredirectheaders = new PhantomRedirectHeaders();
                        phantomredirectheaders.read(tprotocol);
                        phantomredirectresult.headers.add(phantomredirectheaders);
                    }

                    tprotocol.readListEnd();
                    phantomredirectresult.setHeadersIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L4:
                if (((TField) (obj)).type == 11)
                {
                    phantomredirectresult.body = tprotocol.readString();
                    phantomredirectresult.setBodyIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L5:
                if (((TField) (obj)).type == 11)
                {
                    phantomredirectresult.requestTime = tprotocol.readString();
                    phantomredirectresult.setRequestTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L6:
                if (((TField) (obj)).type == 11)
                {
                    phantomredirectresult.responseTime = tprotocol.readString();
                    phantomredirectresult.setResponseTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L7:
                if (((TField) (obj)).type == 6)
                {
                    phantomredirectresult.status = tprotocol.readI16();
                    phantomredirectresult.setStatusIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                if (((TField) (obj)).type == 11)
                {
                    phantomredirectresult.statusText = tprotocol.readString();
                    phantomredirectresult.setStatusTextIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                phantomredirectresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRedirectResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
            {
                phantomredirectresult.validate();
                tprotocol.writeStructBegin(PhantomRedirectResult.STRUCT_DESC);
                if (phantomredirectresult.url != null && phantomredirectresult.isSetUrl())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.URL_FIELD_DESC);
                    tprotocol.writeString(phantomredirectresult.url);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.headers != null && phantomredirectresult.isSetHeaders())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.HEADERS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, phantomredirectresult.headers.size()));
                    for (Iterator iterator = phantomredirectresult.headers.iterator(); iterator.hasNext(); ((PhantomRedirectHeaders)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.body != null && phantomredirectresult.isSetBody())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.BODY_FIELD_DESC);
                    tprotocol.writeString(phantomredirectresult.body);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.requestTime != null && phantomredirectresult.isSetRequestTime())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.REQUEST_TIME_FIELD_DESC);
                    tprotocol.writeString(phantomredirectresult.requestTime);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.responseTime != null && phantomredirectresult.isSetResponseTime())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.RESPONSE_TIME_FIELD_DESC);
                    tprotocol.writeString(phantomredirectresult.responseTime);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.isSetStatus())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.STATUS_FIELD_DESC);
                    tprotocol.writeI16(phantomredirectresult.status);
                    tprotocol.writeFieldEnd();
                }
                if (phantomredirectresult.statusText != null && phantomredirectresult.isSetStatusText())
                {
                    tprotocol.writeFieldBegin(PhantomRedirectResult.STATUS_TEXT_FIELD_DESC);
                    tprotocol.writeString(phantomredirectresult.statusText);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRedirectResult)tbase);
            }

            private PhantomRedirectResultStandardScheme()
            {
            }

            PhantomRedirectResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomRedirectResultTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomRedirectResultTupleScheme getScheme()
        {
            return new PhantomRedirectResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRedirectResultTupleSchemeFactory()
        {
        }

        PhantomRedirectResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRedirectResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    phantomredirectresult.url = tprotocol.readString();
                    phantomredirectresult.setUrlIsSet(true);
                }
                if (bitset.get(1))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    phantomredirectresult.headers = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        PhantomRedirectHeaders phantomredirectheaders = new PhantomRedirectHeaders();
                        phantomredirectheaders.read(tprotocol);
                        phantomredirectresult.headers.add(phantomredirectheaders);
                    }

                    phantomredirectresult.setHeadersIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomredirectresult.body = tprotocol.readString();
                    phantomredirectresult.setBodyIsSet(true);
                }
                if (bitset.get(3))
                {
                    phantomredirectresult.requestTime = tprotocol.readString();
                    phantomredirectresult.setRequestTimeIsSet(true);
                }
                if (bitset.get(4))
                {
                    phantomredirectresult.responseTime = tprotocol.readString();
                    phantomredirectresult.setResponseTimeIsSet(true);
                }
                if (bitset.get(5))
                {
                    phantomredirectresult.status = tprotocol.readI16();
                    phantomredirectresult.setStatusIsSet(true);
                }
                if (bitset.get(6))
                {
                    phantomredirectresult.statusText = tprotocol.readString();
                    phantomredirectresult.setStatusTextIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRedirectResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRedirectResult phantomredirectresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomredirectresult.isSetUrl())
                {
                    bitset.set(0);
                }
                if (phantomredirectresult.isSetHeaders())
                {
                    bitset.set(1);
                }
                if (phantomredirectresult.isSetBody())
                {
                    bitset.set(2);
                }
                if (phantomredirectresult.isSetRequestTime())
                {
                    bitset.set(3);
                }
                if (phantomredirectresult.isSetResponseTime())
                {
                    bitset.set(4);
                }
                if (phantomredirectresult.isSetStatus())
                {
                    bitset.set(5);
                }
                if (phantomredirectresult.isSetStatusText())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (phantomredirectresult.isSetUrl())
                {
                    tprotocol.writeString(phantomredirectresult.url);
                }
                if (phantomredirectresult.isSetHeaders())
                {
                    tprotocol.writeI32(phantomredirectresult.headers.size());
                    for (Iterator iterator = phantomredirectresult.headers.iterator(); iterator.hasNext(); ((PhantomRedirectHeaders)iterator.next()).write(tprotocol)) { }
                }
                if (phantomredirectresult.isSetBody())
                {
                    tprotocol.writeString(phantomredirectresult.body);
                }
                if (phantomredirectresult.isSetRequestTime())
                {
                    tprotocol.writeString(phantomredirectresult.requestTime);
                }
                if (phantomredirectresult.isSetResponseTime())
                {
                    tprotocol.writeString(phantomredirectresult.responseTime);
                }
                if (phantomredirectresult.isSetStatus())
                {
                    tprotocol.writeI16(phantomredirectresult.status);
                }
                if (phantomredirectresult.isSetStatusText())
                {
                    tprotocol.writeString(phantomredirectresult.statusText);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRedirectResult)tbase);
            }

            private PhantomRedirectResultTupleScheme()
            {
            }

            PhantomRedirectResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
