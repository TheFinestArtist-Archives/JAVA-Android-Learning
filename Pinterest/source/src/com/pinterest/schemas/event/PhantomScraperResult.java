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
//            PhantomRawResult

public class PhantomScraperResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField AMZ_URL_FIELD_DESC = new TField("amzUrl", (byte)11, (short)2);
    private static final TField BASE_URL_FIELD_DESC = new TField("baseUrl", (byte)11, (short)1);
    private static final TField RAW_RESULT_FIELD_DESC = new TField("rawResult", (byte)12, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomScraperResult");
    public static final Map metaDataMap;
    private static final Map schemes;
    public String amzUrl;
    public String baseUrl;
    public PhantomRawResult rawResult;

    public PhantomScraperResult()
    {
    }

    public PhantomScraperResult(PhantomScraperResult phantomscraperresult)
    {
        if (phantomscraperresult.isSetBaseUrl())
        {
            baseUrl = phantomscraperresult.baseUrl;
        }
        if (phantomscraperresult.isSetAmzUrl())
        {
            amzUrl = phantomscraperresult.amzUrl;
        }
        if (phantomscraperresult.isSetRawResult())
        {
            rawResult = new PhantomRawResult(phantomscraperresult.rawResult);
        }
    }

    public PhantomScraperResult(String s, String s1, PhantomRawResult phantomrawresult)
    {
        this();
        baseUrl = s;
        amzUrl = s1;
        rawResult = phantomrawresult;
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
        baseUrl = null;
        amzUrl = null;
        rawResult = null;
    }

    public int compareTo(PhantomScraperResult phantomscraperresult)
    {
        if (getClass().equals(phantomscraperresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomscraperresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetBaseUrl()).compareTo(Boolean.valueOf(phantomscraperresult.isSetBaseUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetBaseUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(baseUrl, phantomscraperresult.baseUrl);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetAmzUrl()).compareTo(Boolean.valueOf(phantomscraperresult.isSetAmzUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetAmzUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(amzUrl, phantomscraperresult.amzUrl);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetRawResult()).compareTo(Boolean.valueOf(phantomscraperresult.isSetRawResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetRawResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(rawResult, phantomscraperresult.rawResult);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomScraperResult)obj);
    }

    public PhantomScraperResult deepCopy()
    {
        return new PhantomScraperResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomScraperResult phantomscraperresult)
    {
        if (phantomscraperresult != null)
        {
            boolean flag = isSetBaseUrl();
            boolean flag3 = phantomscraperresult.isSetBaseUrl();
            if (!flag && !flag3 || flag && flag3 && baseUrl.equals(phantomscraperresult.baseUrl))
            {
                boolean flag1 = isSetAmzUrl();
                boolean flag4 = phantomscraperresult.isSetAmzUrl();
                if (!flag1 && !flag4 || flag1 && flag4 && amzUrl.equals(phantomscraperresult.amzUrl))
                {
                    boolean flag2 = isSetRawResult();
                    boolean flag5 = phantomscraperresult.isSetRawResult();
                    if (!flag2 && !flag5 || flag2 && flag5 && rawResult.equals(phantomscraperresult.rawResult))
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
        while (obj == null || !(obj instanceof PhantomScraperResult)) 
        {
            return false;
        }
        return equals((PhantomScraperResult)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getAmzUrl()
    {
        return amzUrl;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomScraperResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getBaseUrl();

        case 2: // '\002'
            return getAmzUrl();

        case 3: // '\003'
            return getRawResult();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public PhantomRawResult getRawResult()
    {
        return rawResult;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetBaseUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(baseUrl);
        }
        flag = isSetAmzUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(amzUrl);
        }
        flag = isSetRawResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(rawResult);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomScraperResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetBaseUrl();

        case 2: // '\002'
            return isSetAmzUrl();

        case 3: // '\003'
            return isSetRawResult();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAmzUrl()
    {
        return amzUrl != null;
    }

    public boolean isSetBaseUrl()
    {
        return baseUrl != null;
    }

    public boolean isSetRawResult()
    {
        return rawResult != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PhantomScraperResult setAmzUrl(String s)
    {
        amzUrl = s;
        return this;
    }

    public void setAmzUrlIsSet(boolean flag)
    {
        if (!flag)
        {
            amzUrl = null;
        }
    }

    public PhantomScraperResult setBaseUrl(String s)
    {
        baseUrl = s;
        return this;
    }

    public void setBaseUrlIsSet(boolean flag)
    {
        if (!flag)
        {
            baseUrl = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomScraperResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetBaseUrl();
                return;
            } else
            {
                setBaseUrl((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAmzUrl();
                return;
            } else
            {
                setAmzUrl((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetRawResult();
            return;
        } else
        {
            setRawResult((PhantomRawResult)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomScraperResult setRawResult(PhantomRawResult phantomrawresult)
    {
        rawResult = phantomrawresult;
        return this;
    }

    public void setRawResultIsSet(boolean flag)
    {
        if (!flag)
        {
            rawResult = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PhantomScraperResult(");
        stringbuilder.append("baseUrl:");
        if (baseUrl == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(baseUrl);
        }
        stringbuilder.append(", ");
        stringbuilder.append("amzUrl:");
        if (amzUrl == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(amzUrl);
        }
        stringbuilder.append(", ");
        stringbuilder.append("rawResult:");
        if (rawResult == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(rawResult);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAmzUrl()
    {
        amzUrl = null;
    }

    public void unsetBaseUrl()
    {
        baseUrl = null;
    }

    public void unsetRawResult()
    {
        rawResult = null;
    }

    public void validate()
    {
        if (rawResult != null)
        {
            rawResult.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomScraperResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomScraperResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/PhantomScraperResult$_Fields);
        ((Map) (obj)).put(_Fields.BASE_URL, new FieldMetaData("baseUrl", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.AMZ_URL, new FieldMetaData("amzUrl", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.RAW_RESULT, new FieldMetaData("rawResult", (byte)3, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomRawResult)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomScraperResult, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields AMZ_URL;
        public static final _Fields BASE_URL;
        public static final _Fields RAW_RESULT;
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
                return BASE_URL;

            case 2: // '\002'
                return AMZ_URL;

            case 3: // '\003'
                return RAW_RESULT;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomScraperResult$_Fields, s);
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
            BASE_URL = new _Fields("BASE_URL", 0, (short)1, "baseUrl");
            AMZ_URL = new _Fields("AMZ_URL", 1, (short)2, "amzUrl");
            RAW_RESULT = new _Fields("RAW_RESULT", 2, (short)3, "rawResult");
            $VALUES = (new _Fields[] {
                BASE_URL, AMZ_URL, RAW_RESULT
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomScraperResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomScraperResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomScraperResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomScraperResult$_Fields[_Fields.BASE_URL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomScraperResult$_Fields[_Fields.AMZ_URL.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomScraperResult$_Fields[_Fields.RAW_RESULT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomScraperResultStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomScraperResultStandardScheme getScheme()
        {
            return new PhantomScraperResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomScraperResultStandardSchemeFactory()
        {
        }

        PhantomScraperResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomScraperResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
            {
                tprotocol.readStructBegin();
_L6:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_182;
                }
                tfield.id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 99
            //                           3 135;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_135;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (tfield.type == 11)
                {
                    phantomscraperresult.baseUrl = tprotocol.readString();
                    phantomscraperresult.setBaseUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 11)
                {
                    phantomscraperresult.amzUrl = tprotocol.readString();
                    phantomscraperresult.setAmzUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 12)
                {
                    phantomscraperresult.rawResult = new PhantomRawResult();
                    phantomscraperresult.rawResult.read(tprotocol);
                    phantomscraperresult.setRawResultIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                phantomscraperresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomScraperResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
            {
                phantomscraperresult.validate();
                tprotocol.writeStructBegin(PhantomScraperResult.STRUCT_DESC);
                if (phantomscraperresult.baseUrl != null)
                {
                    tprotocol.writeFieldBegin(PhantomScraperResult.BASE_URL_FIELD_DESC);
                    tprotocol.writeString(phantomscraperresult.baseUrl);
                    tprotocol.writeFieldEnd();
                }
                if (phantomscraperresult.amzUrl != null)
                {
                    tprotocol.writeFieldBegin(PhantomScraperResult.AMZ_URL_FIELD_DESC);
                    tprotocol.writeString(phantomscraperresult.amzUrl);
                    tprotocol.writeFieldEnd();
                }
                if (phantomscraperresult.rawResult != null)
                {
                    tprotocol.writeFieldBegin(PhantomScraperResult.RAW_RESULT_FIELD_DESC);
                    phantomscraperresult.rawResult.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomScraperResult)tbase);
            }

            private PhantomScraperResultStandardScheme()
            {
            }

            PhantomScraperResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomScraperResultTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomScraperResultTupleScheme getScheme()
        {
            return new PhantomScraperResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomScraperResultTupleSchemeFactory()
        {
        }

        PhantomScraperResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomScraperResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    phantomscraperresult.baseUrl = tprotocol.readString();
                    phantomscraperresult.setBaseUrlIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomscraperresult.amzUrl = tprotocol.readString();
                    phantomscraperresult.setAmzUrlIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomscraperresult.rawResult = new PhantomRawResult();
                    phantomscraperresult.rawResult.read(tprotocol);
                    phantomscraperresult.setRawResultIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomScraperResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomScraperResult phantomscraperresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomscraperresult.isSetBaseUrl())
                {
                    bitset.set(0);
                }
                if (phantomscraperresult.isSetAmzUrl())
                {
                    bitset.set(1);
                }
                if (phantomscraperresult.isSetRawResult())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (phantomscraperresult.isSetBaseUrl())
                {
                    tprotocol.writeString(phantomscraperresult.baseUrl);
                }
                if (phantomscraperresult.isSetAmzUrl())
                {
                    tprotocol.writeString(phantomscraperresult.amzUrl);
                }
                if (phantomscraperresult.isSetRawResult())
                {
                    phantomscraperresult.rawResult.write(tprotocol);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomScraperResult)tbase);
            }

            private PhantomScraperResultTupleScheme()
            {
            }

            PhantomScraperResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
