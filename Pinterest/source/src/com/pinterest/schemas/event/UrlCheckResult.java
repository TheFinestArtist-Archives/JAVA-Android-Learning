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
//            LimitResult, UrlTimingResult

public class UrlCheckResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BLOCK_REASON_FIELD_DESC = new TField("blockReason", (byte)11, (short)6);
    private static final TField REDIRECT_TIMINGS_FIELD_DESC = new TField("redirectTimings", (byte)15, (short)5);
    private static final TField RESULT_FIELD_DESC = new TField("result", (byte)12, (short)1);
    private static final TField SANITIZED_URL_FIELD_DESC = new TField("sanitizedUrl", (byte)11, (short)2);
    private static final TField STATUS_CODE_FIELD_DESC = new TField("statusCode", (byte)6, (short)4);
    private static final TStruct STRUCT_DESC = new TStruct("UrlCheckResult");
    private static final TField URL_FIELD_DESC = new TField("url", (byte)11, (short)3);
    private static final int __STATUSCODE_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public String blockReason;
    public List redirectTimings;
    public LimitResult result;
    public String sanitizedUrl;
    public short statusCode;
    public String url;

    public UrlCheckResult()
    {
        __isset_bitfield = 0;
    }

    public UrlCheckResult(LimitResult limitresult, String s, String s1, short word0, List list, String s2)
    {
        this();
        result = limitresult;
        sanitizedUrl = s;
        url = s1;
        statusCode = word0;
        setStatusCodeIsSet(true);
        redirectTimings = list;
        blockReason = s2;
    }

    public UrlCheckResult(UrlCheckResult urlcheckresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = urlcheckresult.__isset_bitfield;
        if (urlcheckresult.isSetResult())
        {
            result = new LimitResult(urlcheckresult.result);
        }
        if (urlcheckresult.isSetSanitizedUrl())
        {
            sanitizedUrl = urlcheckresult.sanitizedUrl;
        }
        if (urlcheckresult.isSetUrl())
        {
            url = urlcheckresult.url;
        }
        statusCode = urlcheckresult.statusCode;
        if (urlcheckresult.isSetRedirectTimings())
        {
            ArrayList arraylist = new ArrayList(urlcheckresult.redirectTimings.size());
            for (Iterator iterator = urlcheckresult.redirectTimings.iterator(); iterator.hasNext(); arraylist.add(new UrlTimingResult((UrlTimingResult)iterator.next()))) { }
            redirectTimings = arraylist;
        }
        if (urlcheckresult.isSetBlockReason())
        {
            blockReason = urlcheckresult.blockReason;
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

    public void addToRedirectTimings(UrlTimingResult urltimingresult)
    {
        if (redirectTimings == null)
        {
            redirectTimings = new ArrayList();
        }
        redirectTimings.add(urltimingresult);
    }

    public void clear()
    {
        result = null;
        sanitizedUrl = null;
        url = null;
        setStatusCodeIsSet(false);
        statusCode = 0;
        redirectTimings = null;
        blockReason = null;
    }

    public int compareTo(UrlCheckResult urlcheckresult)
    {
        if (getClass().equals(urlcheckresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(urlcheckresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetResult()).compareTo(Boolean.valueOf(urlcheckresult.isSetResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(result, urlcheckresult.result);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetSanitizedUrl()).compareTo(Boolean.valueOf(urlcheckresult.isSetSanitizedUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetSanitizedUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(sanitizedUrl, urlcheckresult.sanitizedUrl);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetUrl()).compareTo(Boolean.valueOf(urlcheckresult.isSetUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(url, urlcheckresult.url);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetStatusCode()).compareTo(Boolean.valueOf(urlcheckresult.isSetStatusCode()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetStatusCode())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(statusCode, urlcheckresult.statusCode);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetRedirectTimings()).compareTo(Boolean.valueOf(urlcheckresult.isSetRedirectTimings()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetRedirectTimings())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(redirectTimings, urlcheckresult.redirectTimings);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetBlockReason()).compareTo(Boolean.valueOf(urlcheckresult.isSetBlockReason()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetBlockReason())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(blockReason, urlcheckresult.blockReason);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((UrlCheckResult)obj);
    }

    public UrlCheckResult deepCopy()
    {
        return new UrlCheckResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(UrlCheckResult urlcheckresult)
    {
        if (urlcheckresult != null)
        {
            boolean flag = isSetResult();
            boolean flag5 = urlcheckresult.isSetResult();
            if (!flag && !flag5 || flag && flag5 && result.equals(urlcheckresult.result))
            {
                boolean flag1 = isSetSanitizedUrl();
                boolean flag6 = urlcheckresult.isSetSanitizedUrl();
                if (!flag1 && !flag6 || flag1 && flag6 && sanitizedUrl.equals(urlcheckresult.sanitizedUrl))
                {
                    boolean flag2 = isSetUrl();
                    boolean flag7 = urlcheckresult.isSetUrl();
                    if ((!flag2 && !flag7 || flag2 && flag7 && url.equals(urlcheckresult.url)) && statusCode == urlcheckresult.statusCode)
                    {
                        boolean flag3 = isSetRedirectTimings();
                        boolean flag8 = urlcheckresult.isSetRedirectTimings();
                        if (!flag3 && !flag8 || flag3 && flag8 && redirectTimings.equals(urlcheckresult.redirectTimings))
                        {
                            boolean flag4 = isSetBlockReason();
                            boolean flag9 = urlcheckresult.isSetBlockReason();
                            if (!flag4 && !flag9 || flag4 && flag9 && blockReason.equals(urlcheckresult.blockReason))
                            {
                                return true;
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
        while (obj == null || !(obj instanceof UrlCheckResult)) 
        {
            return false;
        }
        return equals((UrlCheckResult)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getBlockReason()
    {
        return blockReason;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlCheckResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getResult();

        case 2: // '\002'
            return getSanitizedUrl();

        case 3: // '\003'
            return getUrl();

        case 4: // '\004'
            return Short.valueOf(getStatusCode());

        case 5: // '\005'
            return getRedirectTimings();

        case 6: // '\006'
            return getBlockReason();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getRedirectTimings()
    {
        return redirectTimings;
    }

    public Iterator getRedirectTimingsIterator()
    {
        if (redirectTimings == null)
        {
            return null;
        } else
        {
            return redirectTimings.iterator();
        }
    }

    public int getRedirectTimingsSize()
    {
        if (redirectTimings == null)
        {
            return 0;
        } else
        {
            return redirectTimings.size();
        }
    }

    public LimitResult getResult()
    {
        return result;
    }

    public String getSanitizedUrl()
    {
        return sanitizedUrl;
    }

    public short getStatusCode()
    {
        return statusCode;
    }

    public String getUrl()
    {
        return url;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(result);
        }
        flag = isSetSanitizedUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(sanitizedUrl);
        }
        flag = isSetUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(url);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Short.valueOf(statusCode));
        flag = isSetRedirectTimings();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(redirectTimings);
        }
        flag = isSetBlockReason();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(blockReason);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlCheckResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetResult();

        case 2: // '\002'
            return isSetSanitizedUrl();

        case 3: // '\003'
            return isSetUrl();

        case 4: // '\004'
            return isSetStatusCode();

        case 5: // '\005'
            return isSetRedirectTimings();

        case 6: // '\006'
            return isSetBlockReason();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBlockReason()
    {
        return blockReason != null;
    }

    public boolean isSetRedirectTimings()
    {
        return redirectTimings != null;
    }

    public boolean isSetResult()
    {
        return result != null;
    }

    public boolean isSetSanitizedUrl()
    {
        return sanitizedUrl != null;
    }

    public boolean isSetStatusCode()
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

    public UrlCheckResult setBlockReason(String s)
    {
        blockReason = s;
        return this;
    }

    public void setBlockReasonIsSet(boolean flag)
    {
        if (!flag)
        {
            blockReason = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.UrlCheckResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetResult();
                return;
            } else
            {
                setResult((LimitResult)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetSanitizedUrl();
                return;
            } else
            {
                setSanitizedUrl((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetUrl();
                return;
            } else
            {
                setUrl((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetStatusCode();
                return;
            } else
            {
                setStatusCode(((Short)obj).shortValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetRedirectTimings();
                return;
            } else
            {
                setRedirectTimings((List)obj);
                return;
            }

        case 6: // '\006'
            break;
        }
        if (obj == null)
        {
            unsetBlockReason();
            return;
        } else
        {
            setBlockReason((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public UrlCheckResult setRedirectTimings(List list)
    {
        redirectTimings = list;
        return this;
    }

    public void setRedirectTimingsIsSet(boolean flag)
    {
        if (!flag)
        {
            redirectTimings = null;
        }
    }

    public UrlCheckResult setResult(LimitResult limitresult)
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

    public UrlCheckResult setSanitizedUrl(String s)
    {
        sanitizedUrl = s;
        return this;
    }

    public void setSanitizedUrlIsSet(boolean flag)
    {
        if (!flag)
        {
            sanitizedUrl = null;
        }
    }

    public UrlCheckResult setStatusCode(short word0)
    {
        statusCode = word0;
        setStatusCodeIsSet(true);
        return this;
    }

    public void setStatusCodeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public UrlCheckResult setUrl(String s)
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
        StringBuilder stringbuilder = new StringBuilder("UrlCheckResult(");
        stringbuilder.append("result:");
        if (result == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(result);
        }
        stringbuilder.append(", ");
        stringbuilder.append("sanitizedUrl:");
        if (sanitizedUrl == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(sanitizedUrl);
        }
        stringbuilder.append(", ");
        stringbuilder.append("url:");
        if (url == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(url);
        }
        stringbuilder.append(", ");
        stringbuilder.append("statusCode:");
        stringbuilder.append(statusCode);
        stringbuilder.append(", ");
        stringbuilder.append("redirectTimings:");
        if (redirectTimings == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(redirectTimings);
        }
        stringbuilder.append(", ");
        stringbuilder.append("blockReason:");
        if (blockReason == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(blockReason);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBlockReason()
    {
        blockReason = null;
    }

    public void unsetRedirectTimings()
    {
        redirectTimings = null;
    }

    public void unsetResult()
    {
        result = null;
    }

    public void unsetSanitizedUrl()
    {
        sanitizedUrl = null;
    }

    public void unsetStatusCode()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUrl()
    {
        url = null;
    }

    public void validate()
    {
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new UrlCheckResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new UrlCheckResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/UrlCheckResult$_Fields);
        ((Map) (obj)).put(_Fields.RESULT, new FieldMetaData("result", (byte)3, new StructMetaData((byte)12, com/pinterest/schemas/event/LimitResult)));
        ((Map) (obj)).put(_Fields.SANITIZED_URL, new FieldMetaData("sanitizedUrl", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.URL, new FieldMetaData("url", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.STATUS_CODE, new FieldMetaData("statusCode", (byte)3, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.REDIRECT_TIMINGS, new FieldMetaData("redirectTimings", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/UrlTimingResult))));
        ((Map) (obj)).put(_Fields.BLOCK_REASON, new FieldMetaData("blockReason", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/UrlCheckResult, metaDataMap);
    }








    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BLOCK_REASON;
        public static final _Fields REDIRECT_TIMINGS;
        public static final _Fields RESULT;
        public static final _Fields SANITIZED_URL;
        public static final _Fields STATUS_CODE;
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
                return RESULT;

            case 2: // '\002'
                return SANITIZED_URL;

            case 3: // '\003'
                return URL;

            case 4: // '\004'
                return STATUS_CODE;

            case 5: // '\005'
                return REDIRECT_TIMINGS;

            case 6: // '\006'
                return BLOCK_REASON;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/UrlCheckResult$_Fields, s);
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
            RESULT = new _Fields("RESULT", 0, (short)1, "result");
            SANITIZED_URL = new _Fields("SANITIZED_URL", 1, (short)2, "sanitizedUrl");
            URL = new _Fields("URL", 2, (short)3, "url");
            STATUS_CODE = new _Fields("STATUS_CODE", 3, (short)4, "statusCode");
            REDIRECT_TIMINGS = new _Fields("REDIRECT_TIMINGS", 4, (short)5, "redirectTimings");
            BLOCK_REASON = new _Fields("BLOCK_REASON", 5, (short)6, "blockReason");
            $VALUES = (new _Fields[] {
                RESULT, SANITIZED_URL, URL, STATUS_CODE, REDIRECT_TIMINGS, BLOCK_REASON
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/UrlCheckResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.RESULT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.SANITIZED_URL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.URL.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.STATUS_CODE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.REDIRECT_TIMINGS.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$UrlCheckResult$_Fields[_Fields.BLOCK_REASON.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class UrlCheckResultStandardSchemeFactory
        implements SchemeFactory
    {

        public UrlCheckResultStandardScheme getScheme()
        {
            return new UrlCheckResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private UrlCheckResultStandardSchemeFactory()
        {
        }

        UrlCheckResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class UrlCheckResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, UrlCheckResult urlcheckresult)
            {
                tprotocol.readStructBegin();
_L9:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_366;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 6: default 60
            //                           1 75
            //                           2 122
            //                           3 158
            //                           4 194
            //                           5 230
            //                           6 330;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
                break MISSING_BLOCK_LABEL_330;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
                tprotocol.readFieldEnd();
                if (true) goto _L9; else goto _L8
_L8:
                if (((TField) (obj)).type == 12)
                {
                    urlcheckresult.result = new LimitResult();
                    urlcheckresult.result.read(tprotocol);
                    urlcheckresult.setResultIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L3:
                if (((TField) (obj)).type == 11)
                {
                    urlcheckresult.sanitizedUrl = tprotocol.readString();
                    urlcheckresult.setSanitizedUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L4:
                if (((TField) (obj)).type == 11)
                {
                    urlcheckresult.url = tprotocol.readString();
                    urlcheckresult.setUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L5:
                if (((TField) (obj)).type == 6)
                {
                    urlcheckresult.statusCode = tprotocol.readI16();
                    urlcheckresult.setStatusCodeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L6:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    urlcheckresult.redirectTimings = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        UrlTimingResult urltimingresult = new UrlTimingResult();
                        urltimingresult.read(tprotocol);
                        urlcheckresult.redirectTimings.add(urltimingresult);
                    }

                    tprotocol.readListEnd();
                    urlcheckresult.setRedirectTimingsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
                if (((TField) (obj)).type == 11)
                {
                    urlcheckresult.blockReason = tprotocol.readString();
                    urlcheckresult.setBlockReasonIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
                tprotocol.readStructEnd();
                urlcheckresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (UrlCheckResult)tbase);
            }

            public void write(TProtocol tprotocol, UrlCheckResult urlcheckresult)
            {
                urlcheckresult.validate();
                tprotocol.writeStructBegin(UrlCheckResult.STRUCT_DESC);
                if (urlcheckresult.result != null)
                {
                    tprotocol.writeFieldBegin(UrlCheckResult.RESULT_FIELD_DESC);
                    urlcheckresult.result.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (urlcheckresult.sanitizedUrl != null)
                {
                    tprotocol.writeFieldBegin(UrlCheckResult.SANITIZED_URL_FIELD_DESC);
                    tprotocol.writeString(urlcheckresult.sanitizedUrl);
                    tprotocol.writeFieldEnd();
                }
                if (urlcheckresult.url != null)
                {
                    tprotocol.writeFieldBegin(UrlCheckResult.URL_FIELD_DESC);
                    tprotocol.writeString(urlcheckresult.url);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(UrlCheckResult.STATUS_CODE_FIELD_DESC);
                tprotocol.writeI16(urlcheckresult.statusCode);
                tprotocol.writeFieldEnd();
                if (urlcheckresult.redirectTimings != null)
                {
                    tprotocol.writeFieldBegin(UrlCheckResult.REDIRECT_TIMINGS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, urlcheckresult.redirectTimings.size()));
                    for (Iterator iterator = urlcheckresult.redirectTimings.iterator(); iterator.hasNext(); ((UrlTimingResult)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (urlcheckresult.blockReason != null)
                {
                    tprotocol.writeFieldBegin(UrlCheckResult.BLOCK_REASON_FIELD_DESC);
                    tprotocol.writeString(urlcheckresult.blockReason);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (UrlCheckResult)tbase);
            }

            private UrlCheckResultStandardScheme()
            {
            }

            UrlCheckResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class UrlCheckResultTupleSchemeFactory
        implements SchemeFactory
    {

        public UrlCheckResultTupleScheme getScheme()
        {
            return new UrlCheckResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private UrlCheckResultTupleSchemeFactory()
        {
        }

        UrlCheckResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class UrlCheckResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, UrlCheckResult urlcheckresult)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(6);
                if (bitset.get(0))
                {
                    urlcheckresult.result = new LimitResult();
                    urlcheckresult.result.read(tprotocol);
                    urlcheckresult.setResultIsSet(true);
                }
                if (bitset.get(1))
                {
                    urlcheckresult.sanitizedUrl = tprotocol.readString();
                    urlcheckresult.setSanitizedUrlIsSet(true);
                }
                if (bitset.get(2))
                {
                    urlcheckresult.url = tprotocol.readString();
                    urlcheckresult.setUrlIsSet(true);
                }
                if (bitset.get(3))
                {
                    urlcheckresult.statusCode = tprotocol.readI16();
                    urlcheckresult.setStatusCodeIsSet(true);
                }
                if (bitset.get(4))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    urlcheckresult.redirectTimings = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        UrlTimingResult urltimingresult = new UrlTimingResult();
                        urltimingresult.read(tprotocol);
                        urlcheckresult.redirectTimings.add(urltimingresult);
                    }

                    urlcheckresult.setRedirectTimingsIsSet(true);
                }
                if (bitset.get(5))
                {
                    urlcheckresult.blockReason = tprotocol.readString();
                    urlcheckresult.setBlockReasonIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (UrlCheckResult)tbase);
            }

            public void write(TProtocol tprotocol, UrlCheckResult urlcheckresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (urlcheckresult.isSetResult())
                {
                    bitset.set(0);
                }
                if (urlcheckresult.isSetSanitizedUrl())
                {
                    bitset.set(1);
                }
                if (urlcheckresult.isSetUrl())
                {
                    bitset.set(2);
                }
                if (urlcheckresult.isSetStatusCode())
                {
                    bitset.set(3);
                }
                if (urlcheckresult.isSetRedirectTimings())
                {
                    bitset.set(4);
                }
                if (urlcheckresult.isSetBlockReason())
                {
                    bitset.set(5);
                }
                tprotocol.writeBitSet(bitset, 6);
                if (urlcheckresult.isSetResult())
                {
                    urlcheckresult.result.write(tprotocol);
                }
                if (urlcheckresult.isSetSanitizedUrl())
                {
                    tprotocol.writeString(urlcheckresult.sanitizedUrl);
                }
                if (urlcheckresult.isSetUrl())
                {
                    tprotocol.writeString(urlcheckresult.url);
                }
                if (urlcheckresult.isSetStatusCode())
                {
                    tprotocol.writeI16(urlcheckresult.statusCode);
                }
                if (urlcheckresult.isSetRedirectTimings())
                {
                    tprotocol.writeI32(urlcheckresult.redirectTimings.size());
                    for (Iterator iterator = urlcheckresult.redirectTimings.iterator(); iterator.hasNext(); ((UrlTimingResult)iterator.next()).write(tprotocol)) { }
                }
                if (urlcheckresult.isSetBlockReason())
                {
                    tprotocol.writeString(urlcheckresult.blockReason);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (UrlCheckResult)tbase);
            }

            private UrlCheckResultTupleScheme()
            {
            }

            UrlCheckResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
