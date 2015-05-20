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
//            PhantomRedirectResult

public class PhantomRawResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField BASE64_IMAGE_FIELD_DESC = new TField("base64Image", (byte)11, (short)3);
    private static final TField BASE_URL_FIELD_DESC = new TField("baseUrl", (byte)11, (short)1);
    private static final TField COMPLETED_FIELD_DESC = new TField("completed", (byte)2, (short)4);
    private static final TField MESSAGE_FIELD_DESC = new TField("message", (byte)11, (short)5);
    private static final TField REDIRECT_LIST_FIELD_DESC = new TField("redirectList", (byte)15, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomRawResult");
    private static final int __COMPLETED_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String base64Image;
    public String baseUrl;
    public boolean completed;
    public String message;
    public List redirectList;

    public PhantomRawResult()
    {
        __isset_bitfield = 0;
    }

    public PhantomRawResult(PhantomRawResult phantomrawresult)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomrawresult.__isset_bitfield;
        if (phantomrawresult.isSetBaseUrl())
        {
            baseUrl = phantomrawresult.baseUrl;
        }
        if (phantomrawresult.isSetRedirectList())
        {
            ArrayList arraylist = new ArrayList(phantomrawresult.redirectList.size());
            for (Iterator iterator = phantomrawresult.redirectList.iterator(); iterator.hasNext(); arraylist.add(new PhantomRedirectResult((PhantomRedirectResult)iterator.next()))) { }
            redirectList = arraylist;
        }
        if (phantomrawresult.isSetBase64Image())
        {
            base64Image = phantomrawresult.base64Image;
        }
        completed = phantomrawresult.completed;
        if (phantomrawresult.isSetMessage())
        {
            message = phantomrawresult.message;
        }
    }

    public PhantomRawResult(String s, boolean flag, String s1)
    {
        this();
        baseUrl = s;
        completed = flag;
        setCompletedIsSet(true);
        message = s1;
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

    public void addToRedirectList(PhantomRedirectResult phantomredirectresult)
    {
        if (redirectList == null)
        {
            redirectList = new ArrayList();
        }
        redirectList.add(phantomredirectresult);
    }

    public void clear()
    {
        baseUrl = null;
        redirectList = null;
        base64Image = null;
        setCompletedIsSet(false);
        completed = false;
        message = null;
    }

    public int compareTo(PhantomRawResult phantomrawresult)
    {
        if (getClass().equals(phantomrawresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomrawresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetBaseUrl()).compareTo(Boolean.valueOf(phantomrawresult.isSetBaseUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetBaseUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(baseUrl, phantomrawresult.baseUrl);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetRedirectList()).compareTo(Boolean.valueOf(phantomrawresult.isSetRedirectList()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetRedirectList())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(redirectList, phantomrawresult.redirectList);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetBase64Image()).compareTo(Boolean.valueOf(phantomrawresult.isSetBase64Image()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetBase64Image())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(base64Image, phantomrawresult.base64Image);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetCompleted()).compareTo(Boolean.valueOf(phantomrawresult.isSetCompleted()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetCompleted())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(completed, phantomrawresult.completed);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetMessage()).compareTo(Boolean.valueOf(phantomrawresult.isSetMessage()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetMessage())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(message, phantomrawresult.message);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomRawResult)obj);
    }

    public PhantomRawResult deepCopy()
    {
        return new PhantomRawResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomRawResult phantomrawresult)
    {
        if (phantomrawresult != null)
        {
            boolean flag = isSetBaseUrl();
            boolean flag4 = phantomrawresult.isSetBaseUrl();
            if (!flag && !flag4 || flag && flag4 && baseUrl.equals(phantomrawresult.baseUrl))
            {
                boolean flag1 = isSetRedirectList();
                boolean flag5 = phantomrawresult.isSetRedirectList();
                if (!flag1 && !flag5 || flag1 && flag5 && redirectList.equals(phantomrawresult.redirectList))
                {
                    boolean flag2 = isSetBase64Image();
                    boolean flag6 = phantomrawresult.isSetBase64Image();
                    if ((!flag2 && !flag6 || flag2 && flag6 && base64Image.equals(phantomrawresult.base64Image)) && completed == phantomrawresult.completed)
                    {
                        boolean flag3 = isSetMessage();
                        boolean flag7 = phantomrawresult.isSetMessage();
                        if (!flag3 && !flag7 || flag3 && flag7 && message.equals(phantomrawresult.message))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PhantomRawResult)) 
        {
            return false;
        }
        return equals((PhantomRawResult)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getBase64Image()
    {
        return base64Image;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRawResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getBaseUrl();

        case 2: // '\002'
            return getRedirectList();

        case 3: // '\003'
            return getBase64Image();

        case 4: // '\004'
            return Boolean.valueOf(isCompleted());

        case 5: // '\005'
            return getMessage();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getMessage()
    {
        return message;
    }

    public List getRedirectList()
    {
        return redirectList;
    }

    public Iterator getRedirectListIterator()
    {
        if (redirectList == null)
        {
            return null;
        } else
        {
            return redirectList.iterator();
        }
    }

    public int getRedirectListSize()
    {
        if (redirectList == null)
        {
            return 0;
        } else
        {
            return redirectList.size();
        }
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
        flag = isSetRedirectList();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(redirectList);
        }
        flag = isSetBase64Image();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(base64Image);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Boolean.valueOf(completed));
        flag = isSetMessage();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(message);
        }
        return arraylist.hashCode();
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRawResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetBaseUrl();

        case 2: // '\002'
            return isSetRedirectList();

        case 3: // '\003'
            return isSetBase64Image();

        case 4: // '\004'
            return isSetCompleted();

        case 5: // '\005'
            return isSetMessage();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetBase64Image()
    {
        return base64Image != null;
    }

    public boolean isSetBaseUrl()
    {
        return baseUrl != null;
    }

    public boolean isSetCompleted()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetMessage()
    {
        return message != null;
    }

    public boolean isSetRedirectList()
    {
        return redirectList != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PhantomRawResult setBase64Image(String s)
    {
        base64Image = s;
        return this;
    }

    public void setBase64ImageIsSet(boolean flag)
    {
        if (!flag)
        {
            base64Image = null;
        }
    }

    public PhantomRawResult setBaseUrl(String s)
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

    public PhantomRawResult setCompleted(boolean flag)
    {
        completed = flag;
        setCompletedIsSet(true);
        return this;
    }

    public void setCompletedIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomRawResult._Fields[_pfields.ordinal()])
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
                unsetRedirectList();
                return;
            } else
            {
                setRedirectList((List)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetBase64Image();
                return;
            } else
            {
                setBase64Image((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetCompleted();
                return;
            } else
            {
                setCompleted(((Boolean)obj).booleanValue());
                return;
            }

        case 5: // '\005'
            break;
        }
        if (obj == null)
        {
            unsetMessage();
            return;
        } else
        {
            setMessage((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomRawResult setMessage(String s)
    {
        message = s;
        return this;
    }

    public void setMessageIsSet(boolean flag)
    {
        if (!flag)
        {
            message = null;
        }
    }

    public PhantomRawResult setRedirectList(List list)
    {
        redirectList = list;
        return this;
    }

    public void setRedirectListIsSet(boolean flag)
    {
        if (!flag)
        {
            redirectList = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PhantomRawResult(");
        stringbuilder.append("baseUrl:");
        if (baseUrl == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(baseUrl);
        }
        if (isSetRedirectList())
        {
            stringbuilder.append(", ");
            stringbuilder.append("redirectList:");
            if (redirectList == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(redirectList);
            }
        }
        if (isSetBase64Image())
        {
            stringbuilder.append(", ");
            stringbuilder.append("base64Image:");
            if (base64Image == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(base64Image);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("completed:");
        stringbuilder.append(completed);
        stringbuilder.append(", ");
        stringbuilder.append("message:");
        if (message == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(message);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetBase64Image()
    {
        base64Image = null;
    }

    public void unsetBaseUrl()
    {
        baseUrl = null;
    }

    public void unsetCompleted()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetMessage()
    {
        message = null;
    }

    public void unsetRedirectList()
    {
        redirectList = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomRawResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomRawResultTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.REDIRECT_LIST, _Fields.BASE64_IMAGE
        });
        obj = new EnumMap(com/pinterest/schemas/event/PhantomRawResult$_Fields);
        ((Map) (obj)).put(_Fields.BASE_URL, new FieldMetaData("baseUrl", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.REDIRECT_LIST, new FieldMetaData("redirectList", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomRedirectResult))));
        ((Map) (obj)).put(_Fields.BASE64_IMAGE, new FieldMetaData("base64Image", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.COMPLETED, new FieldMetaData("completed", (byte)3, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.MESSAGE, new FieldMetaData("message", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomRawResult, metaDataMap);
    }







    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields BASE64_IMAGE;
        public static final _Fields BASE_URL;
        public static final _Fields COMPLETED;
        public static final _Fields MESSAGE;
        public static final _Fields REDIRECT_LIST;
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
                return REDIRECT_LIST;

            case 3: // '\003'
                return BASE64_IMAGE;

            case 4: // '\004'
                return COMPLETED;

            case 5: // '\005'
                return MESSAGE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomRawResult$_Fields, s);
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
            REDIRECT_LIST = new _Fields("REDIRECT_LIST", 1, (short)2, "redirectList");
            BASE64_IMAGE = new _Fields("BASE64_IMAGE", 2, (short)3, "base64Image");
            COMPLETED = new _Fields("COMPLETED", 3, (short)4, "completed");
            MESSAGE = new _Fields("MESSAGE", 4, (short)5, "message");
            $VALUES = (new _Fields[] {
                BASE_URL, REDIRECT_LIST, BASE64_IMAGE, COMPLETED, MESSAGE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomRawResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[_Fields.BASE_URL.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[_Fields.REDIRECT_LIST.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[_Fields.BASE64_IMAGE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[_Fields.COMPLETED.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomRawResult$_Fields[_Fields.MESSAGE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomRawResultStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomRawResultStandardScheme getScheme()
        {
            return new PhantomRawResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRawResultStandardSchemeFactory()
        {
        }

        PhantomRawResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRawResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomRawResult phantomrawresult)
            {
                tprotocol.readStructBegin();
_L8:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_314;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 5: default 56
            //                           1 71
            //                           2 107
            //                           3 207
            //                           4 243
            //                           5 278;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
                break MISSING_BLOCK_LABEL_278;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L9:
                tprotocol.readFieldEnd();
                if (true) goto _L8; else goto _L7
_L7:
                if (((TField) (obj)).type == 11)
                {
                    phantomrawresult.baseUrl = tprotocol.readString();
                    phantomrawresult.setBaseUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L9
_L3:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    phantomrawresult.redirectList = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        PhantomRedirectResult phantomredirectresult = new PhantomRedirectResult();
                        phantomredirectresult.read(tprotocol);
                        phantomrawresult.redirectList.add(phantomredirectresult);
                    }

                    tprotocol.readListEnd();
                    phantomrawresult.setRedirectListIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L9
_L4:
                if (((TField) (obj)).type == 11)
                {
                    phantomrawresult.base64Image = tprotocol.readString();
                    phantomrawresult.setBase64ImageIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L9
_L5:
                if (((TField) (obj)).type == 2)
                {
                    phantomrawresult.completed = tprotocol.readBool();
                    phantomrawresult.setCompletedIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L9
                if (((TField) (obj)).type == 11)
                {
                    phantomrawresult.message = tprotocol.readString();
                    phantomrawresult.setMessageIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L9
                tprotocol.readStructEnd();
                phantomrawresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRawResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRawResult phantomrawresult)
            {
                phantomrawresult.validate();
                tprotocol.writeStructBegin(PhantomRawResult.STRUCT_DESC);
                if (phantomrawresult.baseUrl != null)
                {
                    tprotocol.writeFieldBegin(PhantomRawResult.BASE_URL_FIELD_DESC);
                    tprotocol.writeString(phantomrawresult.baseUrl);
                    tprotocol.writeFieldEnd();
                }
                if (phantomrawresult.redirectList != null && phantomrawresult.isSetRedirectList())
                {
                    tprotocol.writeFieldBegin(PhantomRawResult.REDIRECT_LIST_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, phantomrawresult.redirectList.size()));
                    for (Iterator iterator = phantomrawresult.redirectList.iterator(); iterator.hasNext(); ((PhantomRedirectResult)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (phantomrawresult.base64Image != null && phantomrawresult.isSetBase64Image())
                {
                    tprotocol.writeFieldBegin(PhantomRawResult.BASE64_IMAGE_FIELD_DESC);
                    tprotocol.writeString(phantomrawresult.base64Image);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(PhantomRawResult.COMPLETED_FIELD_DESC);
                tprotocol.writeBool(phantomrawresult.completed);
                tprotocol.writeFieldEnd();
                if (phantomrawresult.message != null)
                {
                    tprotocol.writeFieldBegin(PhantomRawResult.MESSAGE_FIELD_DESC);
                    tprotocol.writeString(phantomrawresult.message);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRawResult)tbase);
            }

            private PhantomRawResultStandardScheme()
            {
            }

            PhantomRawResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomRawResultTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomRawResultTupleScheme getScheme()
        {
            return new PhantomRawResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomRawResultTupleSchemeFactory()
        {
        }

        PhantomRawResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomRawResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomRawResult phantomrawresult)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(5);
                if (bitset.get(0))
                {
                    phantomrawresult.baseUrl = tprotocol.readString();
                    phantomrawresult.setBaseUrlIsSet(true);
                }
                if (bitset.get(1))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    phantomrawresult.redirectList = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        PhantomRedirectResult phantomredirectresult = new PhantomRedirectResult();
                        phantomredirectresult.read(tprotocol);
                        phantomrawresult.redirectList.add(phantomredirectresult);
                    }

                    phantomrawresult.setRedirectListIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomrawresult.base64Image = tprotocol.readString();
                    phantomrawresult.setBase64ImageIsSet(true);
                }
                if (bitset.get(3))
                {
                    phantomrawresult.completed = tprotocol.readBool();
                    phantomrawresult.setCompletedIsSet(true);
                }
                if (bitset.get(4))
                {
                    phantomrawresult.message = tprotocol.readString();
                    phantomrawresult.setMessageIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomRawResult)tbase);
            }

            public void write(TProtocol tprotocol, PhantomRawResult phantomrawresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomrawresult.isSetBaseUrl())
                {
                    bitset.set(0);
                }
                if (phantomrawresult.isSetRedirectList())
                {
                    bitset.set(1);
                }
                if (phantomrawresult.isSetBase64Image())
                {
                    bitset.set(2);
                }
                if (phantomrawresult.isSetCompleted())
                {
                    bitset.set(3);
                }
                if (phantomrawresult.isSetMessage())
                {
                    bitset.set(4);
                }
                tprotocol.writeBitSet(bitset, 5);
                if (phantomrawresult.isSetBaseUrl())
                {
                    tprotocol.writeString(phantomrawresult.baseUrl);
                }
                if (phantomrawresult.isSetRedirectList())
                {
                    tprotocol.writeI32(phantomrawresult.redirectList.size());
                    for (Iterator iterator = phantomrawresult.redirectList.iterator(); iterator.hasNext(); ((PhantomRedirectResult)iterator.next()).write(tprotocol)) { }
                }
                if (phantomrawresult.isSetBase64Image())
                {
                    tprotocol.writeString(phantomrawresult.base64Image);
                }
                if (phantomrawresult.isSetCompleted())
                {
                    tprotocol.writeBool(phantomrawresult.completed);
                }
                if (phantomrawresult.isSetMessage())
                {
                    tprotocol.writeString(phantomrawresult.message);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomRawResult)tbase);
            }

            private PhantomRawResultTupleScheme()
            {
            }

            PhantomRawResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
