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

public class LimitData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField OFFSITE_SCORE_FIELD_DESC = new TField("offsite_score", (byte)4, (short)3);
    private static final TField SANITIZED_URL_FIELD_DESC = new TField("sanitized_url", (byte)11, (short)4);
    private static final TField SIGNUP_SCORE_V1_FIELD_DESC = new TField("signup_score_v1", (byte)4, (short)2);
    private static final TField SIGNUP_SCORE_V2_FIELD_DESC = new TField("signup_score_v2", (byte)4, (short)1);
    private static final TField SIGNUP_SCORE_V3_FIELD_DESC = new TField("signup_score_v3", (byte)4, (short)5);
    private static final TStruct STRUCT_DESC = new TStruct("LimitData");
    private static final int __OFFSITE_SCORE_ISSET_ID = 2;
    private static final int __SIGNUP_SCORE_V1_ISSET_ID = 1;
    private static final int __SIGNUP_SCORE_V2_ISSET_ID = 0;
    private static final int __SIGNUP_SCORE_V3_ISSET_ID = 3;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public double offsite_score;
    public String sanitized_url;
    public double signup_score_v1;
    public double signup_score_v2;
    public double signup_score_v3;

    public LimitData()
    {
        __isset_bitfield = 0;
    }

    public LimitData(LimitData limitdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = limitdata.__isset_bitfield;
        signup_score_v2 = limitdata.signup_score_v2;
        signup_score_v1 = limitdata.signup_score_v1;
        offsite_score = limitdata.offsite_score;
        if (limitdata.isSetSanitized_url())
        {
            sanitized_url = limitdata.sanitized_url;
        }
        signup_score_v3 = limitdata.signup_score_v3;
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
        setSignup_score_v2IsSet(false);
        signup_score_v2 = 0.0D;
        setSignup_score_v1IsSet(false);
        signup_score_v1 = 0.0D;
        setOffsite_scoreIsSet(false);
        offsite_score = 0.0D;
        sanitized_url = null;
        setSignup_score_v3IsSet(false);
        signup_score_v3 = 0.0D;
    }

    public int compareTo(LimitData limitdata)
    {
        if (getClass().equals(limitdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(limitdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetSignup_score_v2()).compareTo(Boolean.valueOf(limitdata.isSetSignup_score_v2()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetSignup_score_v2())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(signup_score_v2, limitdata.signup_score_v2);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetSignup_score_v1()).compareTo(Boolean.valueOf(limitdata.isSetSignup_score_v1()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetSignup_score_v1())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(signup_score_v1, limitdata.signup_score_v1);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetOffsite_score()).compareTo(Boolean.valueOf(limitdata.isSetOffsite_score()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetOffsite_score())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(offsite_score, limitdata.offsite_score);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetSanitized_url()).compareTo(Boolean.valueOf(limitdata.isSetSanitized_url()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetSanitized_url())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(sanitized_url, limitdata.sanitized_url);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetSignup_score_v3()).compareTo(Boolean.valueOf(limitdata.isSetSignup_score_v3()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetSignup_score_v3())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(signup_score_v3, limitdata.signup_score_v3);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((LimitData)obj);
    }

    public LimitData deepCopy()
    {
        return new LimitData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(LimitData limitdata)
    {
        if (limitdata != null)
        {
            boolean flag = isSetSignup_score_v2();
            boolean flag5 = limitdata.isSetSignup_score_v2();
            if (!flag && !flag5 || flag && flag5 && signup_score_v2 == limitdata.signup_score_v2)
            {
                boolean flag1 = isSetSignup_score_v1();
                boolean flag6 = limitdata.isSetSignup_score_v1();
                if (!flag1 && !flag6 || flag1 && flag6 && signup_score_v1 == limitdata.signup_score_v1)
                {
                    boolean flag2 = isSetOffsite_score();
                    boolean flag7 = limitdata.isSetOffsite_score();
                    if (!flag2 && !flag7 || flag2 && flag7 && offsite_score == limitdata.offsite_score)
                    {
                        boolean flag3 = isSetSanitized_url();
                        boolean flag8 = limitdata.isSetSanitized_url();
                        if (!flag3 && !flag8 || flag3 && flag8 && sanitized_url.equals(limitdata.sanitized_url))
                        {
                            boolean flag4 = isSetSignup_score_v3();
                            boolean flag9 = limitdata.isSetSignup_score_v3();
                            if (!flag4 && !flag9 || flag4 && flag9 && signup_score_v3 == limitdata.signup_score_v3)
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
        while (obj == null || !(obj instanceof LimitData)) 
        {
            return false;
        }
        return equals((LimitData)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Double.valueOf(getSignup_score_v2());

        case 2: // '\002'
            return Double.valueOf(getSignup_score_v1());

        case 3: // '\003'
            return Double.valueOf(getOffsite_score());

        case 4: // '\004'
            return getSanitized_url();

        case 5: // '\005'
            return Double.valueOf(getSignup_score_v3());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public double getOffsite_score()
    {
        return offsite_score;
    }

    public String getSanitized_url()
    {
        return sanitized_url;
    }

    public double getSignup_score_v1()
    {
        return signup_score_v1;
    }

    public double getSignup_score_v2()
    {
        return signup_score_v2;
    }

    public double getSignup_score_v3()
    {
        return signup_score_v3;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetSignup_score_v2();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(signup_score_v2));
        }
        flag = isSetSignup_score_v1();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(signup_score_v1));
        }
        flag = isSetOffsite_score();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(offsite_score));
        }
        flag = isSetSanitized_url();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(sanitized_url);
        }
        flag = isSetSignup_score_v3();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(signup_score_v3));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetSignup_score_v2();

        case 2: // '\002'
            return isSetSignup_score_v1();

        case 3: // '\003'
            return isSetOffsite_score();

        case 4: // '\004'
            return isSetSanitized_url();

        case 5: // '\005'
            return isSetSignup_score_v3();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetOffsite_score()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetSanitized_url()
    {
        return sanitized_url != null;
    }

    public boolean isSetSignup_score_v1()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetSignup_score_v2()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetSignup_score_v3()
    {
        return EncodingUtils.testBit(__isset_bitfield, 3);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetSignup_score_v2();
                return;
            } else
            {
                setSignup_score_v2(((Double)obj).doubleValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetSignup_score_v1();
                return;
            } else
            {
                setSignup_score_v1(((Double)obj).doubleValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetOffsite_score();
                return;
            } else
            {
                setOffsite_score(((Double)obj).doubleValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetSanitized_url();
                return;
            } else
            {
                setSanitized_url((String)obj);
                return;
            }

        case 5: // '\005'
            break;
        }
        if (obj == null)
        {
            unsetSignup_score_v3();
            return;
        } else
        {
            setSignup_score_v3(((Double)obj).doubleValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public LimitData setOffsite_score(double d)
    {
        offsite_score = d;
        setOffsite_scoreIsSet(true);
        return this;
    }

    public void setOffsite_scoreIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public LimitData setSanitized_url(String s)
    {
        sanitized_url = s;
        return this;
    }

    public void setSanitized_urlIsSet(boolean flag)
    {
        if (!flag)
        {
            sanitized_url = null;
        }
    }

    public LimitData setSignup_score_v1(double d)
    {
        signup_score_v1 = d;
        setSignup_score_v1IsSet(true);
        return this;
    }

    public void setSignup_score_v1IsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public LimitData setSignup_score_v2(double d)
    {
        signup_score_v2 = d;
        setSignup_score_v2IsSet(true);
        return this;
    }

    public void setSignup_score_v2IsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public LimitData setSignup_score_v3(double d)
    {
        signup_score_v3 = d;
        setSignup_score_v3IsSet(true);
        return this;
    }

    public void setSignup_score_v3IsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 3, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("LimitData(");
        boolean flag1 = true;
        if (isSetSignup_score_v2())
        {
            stringbuilder.append("signup_score_v2:");
            stringbuilder.append(signup_score_v2);
            flag1 = false;
        }
        boolean flag = flag1;
        if (isSetSignup_score_v1())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("signup_score_v1:");
            stringbuilder.append(signup_score_v1);
            flag = false;
        }
        flag1 = flag;
        if (isSetOffsite_score())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("offsite_score:");
            stringbuilder.append(offsite_score);
            flag1 = false;
        }
        if (isSetSanitized_url())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("sanitized_url:");
            if (sanitized_url == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(sanitized_url);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetSignup_score_v3())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("signup_score_v3:");
            stringbuilder.append(signup_score_v3);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetOffsite_score()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetSanitized_url()
    {
        sanitized_url = null;
    }

    public void unsetSignup_score_v1()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetSignup_score_v2()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetSignup_score_v3()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 3);
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new LimitDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new LimitDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.SIGNUP_SCORE_V2, _Fields.SIGNUP_SCORE_V1, _Fields.OFFSITE_SCORE, _Fields.SANITIZED_URL, _Fields.SIGNUP_SCORE_V3
        });
        obj = new EnumMap(com/pinterest/schemas/event/LimitData$_Fields);
        ((Map) (obj)).put(_Fields.SIGNUP_SCORE_V2, new FieldMetaData("signup_score_v2", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.SIGNUP_SCORE_V1, new FieldMetaData("signup_score_v1", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.OFFSITE_SCORE, new FieldMetaData("offsite_score", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.SANITIZED_URL, new FieldMetaData("sanitized_url", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SIGNUP_SCORE_V3, new FieldMetaData("signup_score_v3", (byte)2, new FieldValueMetaData((byte)4)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/LimitData, metaDataMap);
    }







    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields OFFSITE_SCORE;
        public static final _Fields SANITIZED_URL;
        public static final _Fields SIGNUP_SCORE_V1;
        public static final _Fields SIGNUP_SCORE_V2;
        public static final _Fields SIGNUP_SCORE_V3;
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
                return SIGNUP_SCORE_V2;

            case 2: // '\002'
                return SIGNUP_SCORE_V1;

            case 3: // '\003'
                return OFFSITE_SCORE;

            case 4: // '\004'
                return SANITIZED_URL;

            case 5: // '\005'
                return SIGNUP_SCORE_V3;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/LimitData$_Fields, s);
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
            SIGNUP_SCORE_V2 = new _Fields("SIGNUP_SCORE_V2", 0, (short)1, "signup_score_v2");
            SIGNUP_SCORE_V1 = new _Fields("SIGNUP_SCORE_V1", 1, (short)2, "signup_score_v1");
            OFFSITE_SCORE = new _Fields("OFFSITE_SCORE", 2, (short)3, "offsite_score");
            SANITIZED_URL = new _Fields("SANITIZED_URL", 3, (short)4, "sanitized_url");
            SIGNUP_SCORE_V3 = new _Fields("SIGNUP_SCORE_V3", 4, (short)5, "signup_score_v3");
            $VALUES = (new _Fields[] {
                SIGNUP_SCORE_V2, SIGNUP_SCORE_V1, OFFSITE_SCORE, SANITIZED_URL, SIGNUP_SCORE_V3
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/LimitData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[_Fields.SIGNUP_SCORE_V2.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[_Fields.SIGNUP_SCORE_V1.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[_Fields.OFFSITE_SCORE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[_Fields.SANITIZED_URL.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitData$_Fields[_Fields.SIGNUP_SCORE_V3.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class LimitDataStandardSchemeFactory
        implements SchemeFactory
    {

        public LimitDataStandardScheme getScheme()
        {
            return new LimitDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private LimitDataStandardSchemeFactory()
        {
        }

        LimitDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class LimitDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, LimitData limitdata)
            {
                tprotocol.readStructBegin();
_L8:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_247;
                }
                tfield.id;
                JVM INSTR tableswitch 1 5: default 56
            //                           1 71
            //                           2 106
            //                           3 141
            //                           4 176
            //                           5 212;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
                break MISSING_BLOCK_LABEL_212;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
                tprotocol.readFieldEnd();
                if (true) goto _L8; else goto _L7
_L7:
                if (tfield.type == 4)
                {
                    limitdata.signup_score_v2 = tprotocol.readDouble();
                    limitdata.setSignup_score_v2IsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L3:
                if (tfield.type == 4)
                {
                    limitdata.signup_score_v1 = tprotocol.readDouble();
                    limitdata.setSignup_score_v1IsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L4:
                if (tfield.type == 4)
                {
                    limitdata.offsite_score = tprotocol.readDouble();
                    limitdata.setOffsite_scoreIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L5:
                if (tfield.type == 11)
                {
                    limitdata.sanitized_url = tprotocol.readString();
                    limitdata.setSanitized_urlIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                if (tfield.type == 4)
                {
                    limitdata.signup_score_v3 = tprotocol.readDouble();
                    limitdata.setSignup_score_v3IsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                tprotocol.readStructEnd();
                limitdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (LimitData)tbase);
            }

            public void write(TProtocol tprotocol, LimitData limitdata)
            {
                limitdata.validate();
                tprotocol.writeStructBegin(LimitData.STRUCT_DESC);
                if (limitdata.isSetSignup_score_v2())
                {
                    tprotocol.writeFieldBegin(LimitData.SIGNUP_SCORE_V2_FIELD_DESC);
                    tprotocol.writeDouble(limitdata.signup_score_v2);
                    tprotocol.writeFieldEnd();
                }
                if (limitdata.isSetSignup_score_v1())
                {
                    tprotocol.writeFieldBegin(LimitData.SIGNUP_SCORE_V1_FIELD_DESC);
                    tprotocol.writeDouble(limitdata.signup_score_v1);
                    tprotocol.writeFieldEnd();
                }
                if (limitdata.isSetOffsite_score())
                {
                    tprotocol.writeFieldBegin(LimitData.OFFSITE_SCORE_FIELD_DESC);
                    tprotocol.writeDouble(limitdata.offsite_score);
                    tprotocol.writeFieldEnd();
                }
                if (limitdata.sanitized_url != null && limitdata.isSetSanitized_url())
                {
                    tprotocol.writeFieldBegin(LimitData.SANITIZED_URL_FIELD_DESC);
                    tprotocol.writeString(limitdata.sanitized_url);
                    tprotocol.writeFieldEnd();
                }
                if (limitdata.isSetSignup_score_v3())
                {
                    tprotocol.writeFieldBegin(LimitData.SIGNUP_SCORE_V3_FIELD_DESC);
                    tprotocol.writeDouble(limitdata.signup_score_v3);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (LimitData)tbase);
            }

            private LimitDataStandardScheme()
            {
            }

            LimitDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class LimitDataTupleSchemeFactory
        implements SchemeFactory
    {

        public LimitDataTupleScheme getScheme()
        {
            return new LimitDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private LimitDataTupleSchemeFactory()
        {
        }

        LimitDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class LimitDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, LimitData limitdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(5);
                if (bitset.get(0))
                {
                    limitdata.signup_score_v2 = tprotocol.readDouble();
                    limitdata.setSignup_score_v2IsSet(true);
                }
                if (bitset.get(1))
                {
                    limitdata.signup_score_v1 = tprotocol.readDouble();
                    limitdata.setSignup_score_v1IsSet(true);
                }
                if (bitset.get(2))
                {
                    limitdata.offsite_score = tprotocol.readDouble();
                    limitdata.setOffsite_scoreIsSet(true);
                }
                if (bitset.get(3))
                {
                    limitdata.sanitized_url = tprotocol.readString();
                    limitdata.setSanitized_urlIsSet(true);
                }
                if (bitset.get(4))
                {
                    limitdata.signup_score_v3 = tprotocol.readDouble();
                    limitdata.setSignup_score_v3IsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (LimitData)tbase);
            }

            public void write(TProtocol tprotocol, LimitData limitdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (limitdata.isSetSignup_score_v2())
                {
                    bitset.set(0);
                }
                if (limitdata.isSetSignup_score_v1())
                {
                    bitset.set(1);
                }
                if (limitdata.isSetOffsite_score())
                {
                    bitset.set(2);
                }
                if (limitdata.isSetSanitized_url())
                {
                    bitset.set(3);
                }
                if (limitdata.isSetSignup_score_v3())
                {
                    bitset.set(4);
                }
                tprotocol.writeBitSet(bitset, 5);
                if (limitdata.isSetSignup_score_v2())
                {
                    tprotocol.writeDouble(limitdata.signup_score_v2);
                }
                if (limitdata.isSetSignup_score_v1())
                {
                    tprotocol.writeDouble(limitdata.signup_score_v1);
                }
                if (limitdata.isSetOffsite_score())
                {
                    tprotocol.writeDouble(limitdata.offsite_score);
                }
                if (limitdata.isSetSanitized_url())
                {
                    tprotocol.writeString(limitdata.sanitized_url);
                }
                if (limitdata.isSetSignup_score_v3())
                {
                    tprotocol.writeDouble(limitdata.signup_score_v3);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (LimitData)tbase);
            }

            private LimitDataTupleScheme()
            {
            }

            LimitDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
