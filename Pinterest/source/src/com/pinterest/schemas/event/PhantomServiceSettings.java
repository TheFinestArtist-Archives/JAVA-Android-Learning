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
//            PhantomImageSettings

public class PhantomServiceSettings
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField IMAGE_FIELD_DESC = new TField("image", (byte)2, (short)1);
    private static final TField IMAGE_SETTINGS_FIELD_DESC = new TField("imageSettings", (byte)12, (short)2);
    private static final TField MAX_TIME_OUT_FIELD_DESC = new TField("maxTimeOut", (byte)6, (short)6);
    private static final TField RAW_RESULT_FIELD_DESC = new TField("rawResult", (byte)2, (short)7);
    private static final TField REDIRECT_BODY_FIELD_DESC = new TField("redirectBody", (byte)2, (short)5);
    private static final TField REDIRECT_HEADERS_FIELD_DESC = new TField("redirectHeaders", (byte)2, (short)4);
    private static final TField REDIRECT_URL_FIELD_DESC = new TField("redirectUrl", (byte)2, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomServiceSettings");
    private static final int __IMAGE_ISSET_ID = 0;
    private static final int __MAXTIMEOUT_ISSET_ID = 4;
    private static final int __RAWRESULT_ISSET_ID = 5;
    private static final int __REDIRECTBODY_ISSET_ID = 3;
    private static final int __REDIRECTHEADERS_ISSET_ID = 2;
    private static final int __REDIRECTURL_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public boolean image;
    public PhantomImageSettings imageSettings;
    public short maxTimeOut;
    public boolean rawResult;
    public boolean redirectBody;
    public boolean redirectHeaders;
    public boolean redirectUrl;

    public PhantomServiceSettings()
    {
        __isset_bitfield = 0;
    }

    public PhantomServiceSettings(PhantomServiceSettings phantomservicesettings)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomservicesettings.__isset_bitfield;
        image = phantomservicesettings.image;
        if (phantomservicesettings.isSetImageSettings())
        {
            imageSettings = new PhantomImageSettings(phantomservicesettings.imageSettings);
        }
        redirectUrl = phantomservicesettings.redirectUrl;
        redirectHeaders = phantomservicesettings.redirectHeaders;
        redirectBody = phantomservicesettings.redirectBody;
        maxTimeOut = phantomservicesettings.maxTimeOut;
        rawResult = phantomservicesettings.rawResult;
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
        setImageIsSet(false);
        image = false;
        imageSettings = null;
        setRedirectUrlIsSet(false);
        redirectUrl = false;
        setRedirectHeadersIsSet(false);
        redirectHeaders = false;
        setRedirectBodyIsSet(false);
        redirectBody = false;
        setMaxTimeOutIsSet(false);
        maxTimeOut = 0;
        setRawResultIsSet(false);
        rawResult = false;
    }

    public int compareTo(PhantomServiceSettings phantomservicesettings)
    {
        if (getClass().equals(phantomservicesettings.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomservicesettings.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetImage()).compareTo(Boolean.valueOf(phantomservicesettings.isSetImage()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetImage())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(image, phantomservicesettings.image);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetImageSettings()).compareTo(Boolean.valueOf(phantomservicesettings.isSetImageSettings()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetImageSettings())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(imageSettings, phantomservicesettings.imageSettings);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetRedirectUrl()).compareTo(Boolean.valueOf(phantomservicesettings.isSetRedirectUrl()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetRedirectUrl())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(redirectUrl, phantomservicesettings.redirectUrl);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetRedirectHeaders()).compareTo(Boolean.valueOf(phantomservicesettings.isSetRedirectHeaders()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetRedirectHeaders())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(redirectHeaders, phantomservicesettings.redirectHeaders);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetRedirectBody()).compareTo(Boolean.valueOf(phantomservicesettings.isSetRedirectBody()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetRedirectBody())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(redirectBody, phantomservicesettings.redirectBody);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetMaxTimeOut()).compareTo(Boolean.valueOf(phantomservicesettings.isSetMaxTimeOut()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetMaxTimeOut())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(maxTimeOut, phantomservicesettings.maxTimeOut);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetRawResult()).compareTo(Boolean.valueOf(phantomservicesettings.isSetRawResult()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetRawResult())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(rawResult, phantomservicesettings.rawResult);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomServiceSettings)obj);
    }

    public PhantomServiceSettings deepCopy()
    {
        return new PhantomServiceSettings(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomServiceSettings phantomservicesettings)
    {
        if (phantomservicesettings != null)
        {
            boolean flag = isSetImage();
            boolean flag7 = phantomservicesettings.isSetImage();
            if (!flag && !flag7 || flag && flag7 && image == phantomservicesettings.image)
            {
                boolean flag1 = isSetImageSettings();
                boolean flag8 = phantomservicesettings.isSetImageSettings();
                if (!flag1 && !flag8 || flag1 && flag8 && imageSettings.equals(phantomservicesettings.imageSettings))
                {
                    boolean flag2 = isSetRedirectUrl();
                    boolean flag9 = phantomservicesettings.isSetRedirectUrl();
                    if (!flag2 && !flag9 || flag2 && flag9 && redirectUrl == phantomservicesettings.redirectUrl)
                    {
                        boolean flag3 = isSetRedirectHeaders();
                        boolean flag10 = phantomservicesettings.isSetRedirectHeaders();
                        if (!flag3 && !flag10 || flag3 && flag10 && redirectHeaders == phantomservicesettings.redirectHeaders)
                        {
                            boolean flag4 = isSetRedirectBody();
                            boolean flag11 = phantomservicesettings.isSetRedirectBody();
                            if (!flag4 && !flag11 || flag4 && flag11 && redirectBody == phantomservicesettings.redirectBody)
                            {
                                boolean flag5 = isSetMaxTimeOut();
                                boolean flag12 = phantomservicesettings.isSetMaxTimeOut();
                                if (!flag5 && !flag12 || flag5 && flag12 && maxTimeOut == phantomservicesettings.maxTimeOut)
                                {
                                    boolean flag6 = isSetRawResult();
                                    boolean flag13 = phantomservicesettings.isSetRawResult();
                                    if (!flag6 && !flag13 || flag6 && flag13 && rawResult == phantomservicesettings.rawResult)
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
        while (obj == null || !(obj instanceof PhantomServiceSettings)) 
        {
            return false;
        }
        return equals((PhantomServiceSettings)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceSettings._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Boolean.valueOf(isImage());

        case 2: // '\002'
            return getImageSettings();

        case 3: // '\003'
            return Boolean.valueOf(isRedirectUrl());

        case 4: // '\004'
            return Boolean.valueOf(isRedirectHeaders());

        case 5: // '\005'
            return Boolean.valueOf(isRedirectBody());

        case 6: // '\006'
            return Short.valueOf(getMaxTimeOut());

        case 7: // '\007'
            return Boolean.valueOf(isRawResult());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public PhantomImageSettings getImageSettings()
    {
        return imageSettings;
    }

    public short getMaxTimeOut()
    {
        return maxTimeOut;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetImage();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(image));
        }
        flag = isSetImageSettings();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(imageSettings);
        }
        flag = isSetRedirectUrl();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(redirectUrl));
        }
        flag = isSetRedirectHeaders();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(redirectHeaders));
        }
        flag = isSetRedirectBody();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(redirectBody));
        }
        flag = isSetMaxTimeOut();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(maxTimeOut));
        }
        flag = isSetRawResult();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(rawResult));
        }
        return arraylist.hashCode();
    }

    public boolean isImage()
    {
        return image;
    }

    public boolean isRawResult()
    {
        return rawResult;
    }

    public boolean isRedirectBody()
    {
        return redirectBody;
    }

    public boolean isRedirectHeaders()
    {
        return redirectHeaders;
    }

    public boolean isRedirectUrl()
    {
        return redirectUrl;
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceSettings._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetImage();

        case 2: // '\002'
            return isSetImageSettings();

        case 3: // '\003'
            return isSetRedirectUrl();

        case 4: // '\004'
            return isSetRedirectHeaders();

        case 5: // '\005'
            return isSetRedirectBody();

        case 6: // '\006'
            return isSetMaxTimeOut();

        case 7: // '\007'
            return isSetRawResult();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetImage()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetImageSettings()
    {
        return imageSettings != null;
    }

    public boolean isSetMaxTimeOut()
    {
        return EncodingUtils.testBit(__isset_bitfield, 4);
    }

    public boolean isSetRawResult()
    {
        return EncodingUtils.testBit(__isset_bitfield, 5);
    }

    public boolean isSetRedirectBody()
    {
        return EncodingUtils.testBit(__isset_bitfield, 3);
    }

    public boolean isSetRedirectHeaders()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetRedirectUrl()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomServiceSettings._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetImage();
                return;
            } else
            {
                setImage(((Boolean)obj).booleanValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetImageSettings();
                return;
            } else
            {
                setImageSettings((PhantomImageSettings)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetRedirectUrl();
                return;
            } else
            {
                setRedirectUrl(((Boolean)obj).booleanValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetRedirectHeaders();
                return;
            } else
            {
                setRedirectHeaders(((Boolean)obj).booleanValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetRedirectBody();
                return;
            } else
            {
                setRedirectBody(((Boolean)obj).booleanValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetMaxTimeOut();
                return;
            } else
            {
                setMaxTimeOut(((Short)obj).shortValue());
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetRawResult();
            return;
        } else
        {
            setRawResult(((Boolean)obj).booleanValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomServiceSettings setImage(boolean flag)
    {
        image = flag;
        setImageIsSet(true);
        return this;
    }

    public void setImageIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PhantomServiceSettings setImageSettings(PhantomImageSettings phantomimagesettings)
    {
        imageSettings = phantomimagesettings;
        return this;
    }

    public void setImageSettingsIsSet(boolean flag)
    {
        if (!flag)
        {
            imageSettings = null;
        }
    }

    public PhantomServiceSettings setMaxTimeOut(short word0)
    {
        maxTimeOut = word0;
        setMaxTimeOutIsSet(true);
        return this;
    }

    public void setMaxTimeOutIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 4, flag);
    }

    public PhantomServiceSettings setRawResult(boolean flag)
    {
        rawResult = flag;
        setRawResultIsSet(true);
        return this;
    }

    public void setRawResultIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 5, flag);
    }

    public PhantomServiceSettings setRedirectBody(boolean flag)
    {
        redirectBody = flag;
        setRedirectBodyIsSet(true);
        return this;
    }

    public void setRedirectBodyIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 3, flag);
    }

    public PhantomServiceSettings setRedirectHeaders(boolean flag)
    {
        redirectHeaders = flag;
        setRedirectHeadersIsSet(true);
        return this;
    }

    public void setRedirectHeadersIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public PhantomServiceSettings setRedirectUrl(boolean flag)
    {
        redirectUrl = flag;
        setRedirectUrlIsSet(true);
        return this;
    }

    public void setRedirectUrlIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("PhantomServiceSettings(");
        boolean flag1 = true;
        if (isSetImage())
        {
            stringbuilder.append("image:");
            stringbuilder.append(image);
            flag1 = false;
        }
        boolean flag = flag1;
        if (isSetImageSettings())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("imageSettings:");
            if (imageSettings == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(imageSettings);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetRedirectUrl())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("redirectUrl:");
            stringbuilder.append(redirectUrl);
            flag1 = false;
        }
        flag = flag1;
        if (isSetRedirectHeaders())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("redirectHeaders:");
            stringbuilder.append(redirectHeaders);
            flag = false;
        }
        flag1 = flag;
        if (isSetRedirectBody())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("redirectBody:");
            stringbuilder.append(redirectBody);
            flag1 = false;
        }
        if (isSetMaxTimeOut())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("maxTimeOut:");
            stringbuilder.append(maxTimeOut);
            flag = flag2;
        } else
        {
            flag = flag1;
        }
        if (isSetRawResult())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("rawResult:");
            stringbuilder.append(rawResult);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetImage()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetImageSettings()
    {
        imageSettings = null;
    }

    public void unsetMaxTimeOut()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 4);
    }

    public void unsetRawResult()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 5);
    }

    public void unsetRedirectBody()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 3);
    }

    public void unsetRedirectHeaders()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetRedirectUrl()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void validate()
    {
        if (imageSettings != null)
        {
            imageSettings.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomServiceSettingsStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomServiceSettingsTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.IMAGE, _Fields.IMAGE_SETTINGS, _Fields.REDIRECT_URL, _Fields.REDIRECT_HEADERS, _Fields.REDIRECT_BODY, _Fields.MAX_TIME_OUT, _Fields.RAW_RESULT
        });
        obj = new EnumMap(com/pinterest/schemas/event/PhantomServiceSettings$_Fields);
        ((Map) (obj)).put(_Fields.IMAGE, new FieldMetaData("image", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.IMAGE_SETTINGS, new FieldMetaData("imageSettings", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomImageSettings)));
        ((Map) (obj)).put(_Fields.REDIRECT_URL, new FieldMetaData("redirectUrl", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.REDIRECT_HEADERS, new FieldMetaData("redirectHeaders", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.REDIRECT_BODY, new FieldMetaData("redirectBody", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.MAX_TIME_OUT, new FieldMetaData("maxTimeOut", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.RAW_RESULT, new FieldMetaData("rawResult", (byte)2, new FieldValueMetaData((byte)2)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomServiceSettings, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields IMAGE;
        public static final _Fields IMAGE_SETTINGS;
        public static final _Fields MAX_TIME_OUT;
        public static final _Fields RAW_RESULT;
        public static final _Fields REDIRECT_BODY;
        public static final _Fields REDIRECT_HEADERS;
        public static final _Fields REDIRECT_URL;
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
                return IMAGE;

            case 2: // '\002'
                return IMAGE_SETTINGS;

            case 3: // '\003'
                return REDIRECT_URL;

            case 4: // '\004'
                return REDIRECT_HEADERS;

            case 5: // '\005'
                return REDIRECT_BODY;

            case 6: // '\006'
                return MAX_TIME_OUT;

            case 7: // '\007'
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomServiceSettings$_Fields, s);
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
            IMAGE = new _Fields("IMAGE", 0, (short)1, "image");
            IMAGE_SETTINGS = new _Fields("IMAGE_SETTINGS", 1, (short)2, "imageSettings");
            REDIRECT_URL = new _Fields("REDIRECT_URL", 2, (short)3, "redirectUrl");
            REDIRECT_HEADERS = new _Fields("REDIRECT_HEADERS", 3, (short)4, "redirectHeaders");
            REDIRECT_BODY = new _Fields("REDIRECT_BODY", 4, (short)5, "redirectBody");
            MAX_TIME_OUT = new _Fields("MAX_TIME_OUT", 5, (short)6, "maxTimeOut");
            RAW_RESULT = new _Fields("RAW_RESULT", 6, (short)7, "rawResult");
            $VALUES = (new _Fields[] {
                IMAGE, IMAGE_SETTINGS, REDIRECT_URL, REDIRECT_HEADERS, REDIRECT_BODY, MAX_TIME_OUT, RAW_RESULT
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomServiceSettings$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.IMAGE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.IMAGE_SETTINGS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.REDIRECT_URL.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.REDIRECT_HEADERS.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.REDIRECT_BODY.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.MAX_TIME_OUT.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomServiceSettings$_Fields[_Fields.RAW_RESULT.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomServiceSettingsStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomServiceSettingsStandardScheme getScheme()
        {
            return new PhantomServiceSettingsStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomServiceSettingsStandardSchemeFactory()
        {
        }

        PhantomServiceSettingsStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomServiceSettingsStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
            {
                tprotocol.readStructBegin();
_L10:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_337;
                }
                tfield.id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 114
            //                           3 161
            //                           4 196
            //                           5 231
            //                           6 266
            //                           7 302;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_302;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L11:
                tprotocol.readFieldEnd();
                if (true) goto _L10; else goto _L9
_L9:
                if (tfield.type == 2)
                {
                    phantomservicesettings.image = tprotocol.readBool();
                    phantomservicesettings.setImageIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L3:
                if (tfield.type == 12)
                {
                    phantomservicesettings.imageSettings = new PhantomImageSettings();
                    phantomservicesettings.imageSettings.read(tprotocol);
                    phantomservicesettings.setImageSettingsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L4:
                if (tfield.type == 2)
                {
                    phantomservicesettings.redirectUrl = tprotocol.readBool();
                    phantomservicesettings.setRedirectUrlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L5:
                if (tfield.type == 2)
                {
                    phantomservicesettings.redirectHeaders = tprotocol.readBool();
                    phantomservicesettings.setRedirectHeadersIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L6:
                if (tfield.type == 2)
                {
                    phantomservicesettings.redirectBody = tprotocol.readBool();
                    phantomservicesettings.setRedirectBodyIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
_L7:
                if (tfield.type == 6)
                {
                    phantomservicesettings.maxTimeOut = tprotocol.readI16();
                    phantomservicesettings.setMaxTimeOutIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                if (tfield.type == 2)
                {
                    phantomservicesettings.rawResult = tprotocol.readBool();
                    phantomservicesettings.setRawResultIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                phantomservicesettings.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomServiceSettings)tbase);
            }

            public void write(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
            {
                phantomservicesettings.validate();
                tprotocol.writeStructBegin(PhantomServiceSettings.STRUCT_DESC);
                if (phantomservicesettings.isSetImage())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.IMAGE_FIELD_DESC);
                    tprotocol.writeBool(phantomservicesettings.image);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.imageSettings != null && phantomservicesettings.isSetImageSettings())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.IMAGE_SETTINGS_FIELD_DESC);
                    phantomservicesettings.imageSettings.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.isSetRedirectUrl())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.REDIRECT_URL_FIELD_DESC);
                    tprotocol.writeBool(phantomservicesettings.redirectUrl);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.isSetRedirectHeaders())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.REDIRECT_HEADERS_FIELD_DESC);
                    tprotocol.writeBool(phantomservicesettings.redirectHeaders);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.isSetRedirectBody())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.REDIRECT_BODY_FIELD_DESC);
                    tprotocol.writeBool(phantomservicesettings.redirectBody);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.isSetMaxTimeOut())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.MAX_TIME_OUT_FIELD_DESC);
                    tprotocol.writeI16(phantomservicesettings.maxTimeOut);
                    tprotocol.writeFieldEnd();
                }
                if (phantomservicesettings.isSetRawResult())
                {
                    tprotocol.writeFieldBegin(PhantomServiceSettings.RAW_RESULT_FIELD_DESC);
                    tprotocol.writeBool(phantomservicesettings.rawResult);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomServiceSettings)tbase);
            }

            private PhantomServiceSettingsStandardScheme()
            {
            }

            PhantomServiceSettingsStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomServiceSettingsTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomServiceSettingsTupleScheme getScheme()
        {
            return new PhantomServiceSettingsTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomServiceSettingsTupleSchemeFactory()
        {
        }

        PhantomServiceSettingsTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomServiceSettingsTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    phantomservicesettings.image = tprotocol.readBool();
                    phantomservicesettings.setImageIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomservicesettings.imageSettings = new PhantomImageSettings();
                    phantomservicesettings.imageSettings.read(tprotocol);
                    phantomservicesettings.setImageSettingsIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomservicesettings.redirectUrl = tprotocol.readBool();
                    phantomservicesettings.setRedirectUrlIsSet(true);
                }
                if (bitset.get(3))
                {
                    phantomservicesettings.redirectHeaders = tprotocol.readBool();
                    phantomservicesettings.setRedirectHeadersIsSet(true);
                }
                if (bitset.get(4))
                {
                    phantomservicesettings.redirectBody = tprotocol.readBool();
                    phantomservicesettings.setRedirectBodyIsSet(true);
                }
                if (bitset.get(5))
                {
                    phantomservicesettings.maxTimeOut = tprotocol.readI16();
                    phantomservicesettings.setMaxTimeOutIsSet(true);
                }
                if (bitset.get(6))
                {
                    phantomservicesettings.rawResult = tprotocol.readBool();
                    phantomservicesettings.setRawResultIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomServiceSettings)tbase);
            }

            public void write(TProtocol tprotocol, PhantomServiceSettings phantomservicesettings)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomservicesettings.isSetImage())
                {
                    bitset.set(0);
                }
                if (phantomservicesettings.isSetImageSettings())
                {
                    bitset.set(1);
                }
                if (phantomservicesettings.isSetRedirectUrl())
                {
                    bitset.set(2);
                }
                if (phantomservicesettings.isSetRedirectHeaders())
                {
                    bitset.set(3);
                }
                if (phantomservicesettings.isSetRedirectBody())
                {
                    bitset.set(4);
                }
                if (phantomservicesettings.isSetMaxTimeOut())
                {
                    bitset.set(5);
                }
                if (phantomservicesettings.isSetRawResult())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (phantomservicesettings.isSetImage())
                {
                    tprotocol.writeBool(phantomservicesettings.image);
                }
                if (phantomservicesettings.isSetImageSettings())
                {
                    phantomservicesettings.imageSettings.write(tprotocol);
                }
                if (phantomservicesettings.isSetRedirectUrl())
                {
                    tprotocol.writeBool(phantomservicesettings.redirectUrl);
                }
                if (phantomservicesettings.isSetRedirectHeaders())
                {
                    tprotocol.writeBool(phantomservicesettings.redirectHeaders);
                }
                if (phantomservicesettings.isSetRedirectBody())
                {
                    tprotocol.writeBool(phantomservicesettings.redirectBody);
                }
                if (phantomservicesettings.isSetMaxTimeOut())
                {
                    tprotocol.writeI16(phantomservicesettings.maxTimeOut);
                }
                if (phantomservicesettings.isSetRawResult())
                {
                    tprotocol.writeBool(phantomservicesettings.rawResult);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomServiceSettings)tbase);
            }

            private PhantomServiceSettingsTupleScheme()
            {
            }

            PhantomServiceSettingsTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
