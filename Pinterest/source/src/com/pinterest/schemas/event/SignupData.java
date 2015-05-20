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
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

public class SignupData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField MEDIUM_FIELD_DESC = new TField("medium", (byte)11, (short)2);
    private static final TField REFERRER_TYPE_FIELD_DESC = new TField("referrerType", (byte)11, (short)5);
    private static final TField SOCIAL_ID_FIELD_DESC = new TField("socialId", (byte)11, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("SignupData");
    private static final TField USER_AGENT_FIELD_DESC = new TField("userAgent", (byte)11, (short)4);
    private static final TField VIA_FIELD_DESC = new TField("via", (byte)11, (short)1);
    public static final Map metaDataMap;
    private static final Map schemes;
    public String medium;
    public String referrerType;
    public String socialId;
    public String userAgent;
    public String via;

    public SignupData()
    {
    }

    public SignupData(SignupData signupdata)
    {
        if (signupdata.isSetVia())
        {
            via = signupdata.via;
        }
        if (signupdata.isSetMedium())
        {
            medium = signupdata.medium;
        }
        if (signupdata.isSetSocialId())
        {
            socialId = signupdata.socialId;
        }
        if (signupdata.isSetUserAgent())
        {
            userAgent = signupdata.userAgent;
        }
        if (signupdata.isSetReferrerType())
        {
            referrerType = signupdata.referrerType;
        }
    }

    public SignupData(String s, String s1, String s2, String s3, String s4)
    {
        this();
        via = s;
        medium = s1;
        socialId = s2;
        userAgent = s3;
        referrerType = s4;
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
        via = null;
        medium = null;
        socialId = null;
        userAgent = null;
        referrerType = null;
    }

    public int compareTo(SignupData signupdata)
    {
        if (getClass().equals(signupdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(signupdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetVia()).compareTo(Boolean.valueOf(signupdata.isSetVia()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetVia())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(via, signupdata.via);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetMedium()).compareTo(Boolean.valueOf(signupdata.isSetMedium()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetMedium())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(medium, signupdata.medium);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetSocialId()).compareTo(Boolean.valueOf(signupdata.isSetSocialId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetSocialId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(socialId, signupdata.socialId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetUserAgent()).compareTo(Boolean.valueOf(signupdata.isSetUserAgent()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetUserAgent())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userAgent, signupdata.userAgent);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetReferrerType()).compareTo(Boolean.valueOf(signupdata.isSetReferrerType()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetReferrerType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(referrerType, signupdata.referrerType);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SignupData)obj);
    }

    public SignupData deepCopy()
    {
        return new SignupData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(SignupData signupdata)
    {
        if (signupdata != null)
        {
            boolean flag = isSetVia();
            boolean flag5 = signupdata.isSetVia();
            if (!flag && !flag5 || flag && flag5 && via.equals(signupdata.via))
            {
                boolean flag1 = isSetMedium();
                boolean flag6 = signupdata.isSetMedium();
                if (!flag1 && !flag6 || flag1 && flag6 && medium.equals(signupdata.medium))
                {
                    boolean flag2 = isSetSocialId();
                    boolean flag7 = signupdata.isSetSocialId();
                    if (!flag2 && !flag7 || flag2 && flag7 && socialId.equals(signupdata.socialId))
                    {
                        boolean flag3 = isSetUserAgent();
                        boolean flag8 = signupdata.isSetUserAgent();
                        if (!flag3 && !flag8 || flag3 && flag8 && userAgent.equals(signupdata.userAgent))
                        {
                            boolean flag4 = isSetReferrerType();
                            boolean flag9 = signupdata.isSetReferrerType();
                            if (!flag4 && !flag9 || flag4 && flag9 && referrerType.equals(signupdata.referrerType))
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
        while (obj == null || !(obj instanceof SignupData)) 
        {
            return false;
        }
        return equals((SignupData)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SignupData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getVia();

        case 2: // '\002'
            return getMedium();

        case 3: // '\003'
            return getSocialId();

        case 4: // '\004'
            return getUserAgent();

        case 5: // '\005'
            return getReferrerType();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getMedium()
    {
        return medium;
    }

    public String getReferrerType()
    {
        return referrerType;
    }

    public String getSocialId()
    {
        return socialId;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public String getVia()
    {
        return via;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetVia();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(via);
        }
        flag = isSetMedium();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(medium);
        }
        flag = isSetSocialId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(socialId);
        }
        flag = isSetUserAgent();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(userAgent);
        }
        flag = isSetReferrerType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(referrerType);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SignupData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetVia();

        case 2: // '\002'
            return isSetMedium();

        case 3: // '\003'
            return isSetSocialId();

        case 4: // '\004'
            return isSetUserAgent();

        case 5: // '\005'
            return isSetReferrerType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetMedium()
    {
        return medium != null;
    }

    public boolean isSetReferrerType()
    {
        return referrerType != null;
    }

    public boolean isSetSocialId()
    {
        return socialId != null;
    }

    public boolean isSetUserAgent()
    {
        return userAgent != null;
    }

    public boolean isSetVia()
    {
        return via != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.SignupData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetVia();
                return;
            } else
            {
                setVia((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetMedium();
                return;
            } else
            {
                setMedium((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetSocialId();
                return;
            } else
            {
                setSocialId((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetUserAgent();
                return;
            } else
            {
                setUserAgent((String)obj);
                return;
            }

        case 5: // '\005'
            break;
        }
        if (obj == null)
        {
            unsetReferrerType();
            return;
        } else
        {
            setReferrerType((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public SignupData setMedium(String s)
    {
        medium = s;
        return this;
    }

    public void setMediumIsSet(boolean flag)
    {
        if (!flag)
        {
            medium = null;
        }
    }

    public SignupData setReferrerType(String s)
    {
        referrerType = s;
        return this;
    }

    public void setReferrerTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            referrerType = null;
        }
    }

    public SignupData setSocialId(String s)
    {
        socialId = s;
        return this;
    }

    public void setSocialIdIsSet(boolean flag)
    {
        if (!flag)
        {
            socialId = null;
        }
    }

    public SignupData setUserAgent(String s)
    {
        userAgent = s;
        return this;
    }

    public void setUserAgentIsSet(boolean flag)
    {
        if (!flag)
        {
            userAgent = null;
        }
    }

    public SignupData setVia(String s)
    {
        via = s;
        return this;
    }

    public void setViaIsSet(boolean flag)
    {
        if (!flag)
        {
            via = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("SignupData(");
        stringbuilder.append("via:");
        if (via == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(via);
        }
        stringbuilder.append(", ");
        stringbuilder.append("medium:");
        if (medium == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(medium);
        }
        stringbuilder.append(", ");
        stringbuilder.append("socialId:");
        if (socialId == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(socialId);
        }
        stringbuilder.append(", ");
        stringbuilder.append("userAgent:");
        if (userAgent == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(userAgent);
        }
        stringbuilder.append(", ");
        stringbuilder.append("referrerType:");
        if (referrerType == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(referrerType);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetMedium()
    {
        medium = null;
    }

    public void unsetReferrerType()
    {
        referrerType = null;
    }

    public void unsetSocialId()
    {
        socialId = null;
    }

    public void unsetUserAgent()
    {
        userAgent = null;
    }

    public void unsetVia()
    {
        via = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new SignupDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new SignupDataTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/SignupData$_Fields);
        ((Map) (obj)).put(_Fields.VIA, new FieldMetaData("via", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.MEDIUM, new FieldMetaData("medium", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SOCIAL_ID, new FieldMetaData("socialId", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.USER_AGENT, new FieldMetaData("userAgent", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.REFERRER_TYPE, new FieldMetaData("referrerType", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/SignupData, metaDataMap);
    }







    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields MEDIUM;
        public static final _Fields REFERRER_TYPE;
        public static final _Fields SOCIAL_ID;
        public static final _Fields USER_AGENT;
        public static final _Fields VIA;
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
                return VIA;

            case 2: // '\002'
                return MEDIUM;

            case 3: // '\003'
                return SOCIAL_ID;

            case 4: // '\004'
                return USER_AGENT;

            case 5: // '\005'
                return REFERRER_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/SignupData$_Fields, s);
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
            VIA = new _Fields("VIA", 0, (short)1, "via");
            MEDIUM = new _Fields("MEDIUM", 1, (short)2, "medium");
            SOCIAL_ID = new _Fields("SOCIAL_ID", 2, (short)3, "socialId");
            USER_AGENT = new _Fields("USER_AGENT", 3, (short)4, "userAgent");
            REFERRER_TYPE = new _Fields("REFERRER_TYPE", 4, (short)5, "referrerType");
            $VALUES = (new _Fields[] {
                VIA, MEDIUM, SOCIAL_ID, USER_AGENT, REFERRER_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/SignupData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[_Fields.VIA.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[_Fields.MEDIUM.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[_Fields.SOCIAL_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[_Fields.USER_AGENT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$SignupData$_Fields[_Fields.REFERRER_TYPE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class SignupDataStandardSchemeFactory
        implements SchemeFactory
    {

        public SignupDataStandardScheme getScheme()
        {
            return new SignupDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SignupDataStandardSchemeFactory()
        {
        }

        SignupDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SignupDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, SignupData signupdata)
            {
                tprotocol.readStructBegin();
_L8:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_251;
                }
                tfield.id;
                JVM INSTR tableswitch 1 5: default 56
            //                           1 71
            //                           2 107
            //                           3 143
            //                           4 179
            //                           5 215;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
                break MISSING_BLOCK_LABEL_215;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
                tprotocol.readFieldEnd();
                if (true) goto _L8; else goto _L7
_L7:
                if (tfield.type == 11)
                {
                    signupdata.via = tprotocol.readString();
                    signupdata.setViaIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L3:
                if (tfield.type == 11)
                {
                    signupdata.medium = tprotocol.readString();
                    signupdata.setMediumIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L4:
                if (tfield.type == 11)
                {
                    signupdata.socialId = tprotocol.readString();
                    signupdata.setSocialIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L5:
                if (tfield.type == 11)
                {
                    signupdata.userAgent = tprotocol.readString();
                    signupdata.setUserAgentIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                if (tfield.type == 11)
                {
                    signupdata.referrerType = tprotocol.readString();
                    signupdata.setReferrerTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                tprotocol.readStructEnd();
                signupdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SignupData)tbase);
            }

            public void write(TProtocol tprotocol, SignupData signupdata)
            {
                signupdata.validate();
                tprotocol.writeStructBegin(SignupData.STRUCT_DESC);
                if (signupdata.via != null)
                {
                    tprotocol.writeFieldBegin(SignupData.VIA_FIELD_DESC);
                    tprotocol.writeString(signupdata.via);
                    tprotocol.writeFieldEnd();
                }
                if (signupdata.medium != null)
                {
                    tprotocol.writeFieldBegin(SignupData.MEDIUM_FIELD_DESC);
                    tprotocol.writeString(signupdata.medium);
                    tprotocol.writeFieldEnd();
                }
                if (signupdata.socialId != null)
                {
                    tprotocol.writeFieldBegin(SignupData.SOCIAL_ID_FIELD_DESC);
                    tprotocol.writeString(signupdata.socialId);
                    tprotocol.writeFieldEnd();
                }
                if (signupdata.userAgent != null)
                {
                    tprotocol.writeFieldBegin(SignupData.USER_AGENT_FIELD_DESC);
                    tprotocol.writeString(signupdata.userAgent);
                    tprotocol.writeFieldEnd();
                }
                if (signupdata.referrerType != null)
                {
                    tprotocol.writeFieldBegin(SignupData.REFERRER_TYPE_FIELD_DESC);
                    tprotocol.writeString(signupdata.referrerType);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SignupData)tbase);
            }

            private SignupDataStandardScheme()
            {
            }

            SignupDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class SignupDataTupleSchemeFactory
        implements SchemeFactory
    {

        public SignupDataTupleScheme getScheme()
        {
            return new SignupDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private SignupDataTupleSchemeFactory()
        {
        }

        SignupDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class SignupDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, SignupData signupdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(5);
                if (bitset.get(0))
                {
                    signupdata.via = tprotocol.readString();
                    signupdata.setViaIsSet(true);
                }
                if (bitset.get(1))
                {
                    signupdata.medium = tprotocol.readString();
                    signupdata.setMediumIsSet(true);
                }
                if (bitset.get(2))
                {
                    signupdata.socialId = tprotocol.readString();
                    signupdata.setSocialIdIsSet(true);
                }
                if (bitset.get(3))
                {
                    signupdata.userAgent = tprotocol.readString();
                    signupdata.setUserAgentIsSet(true);
                }
                if (bitset.get(4))
                {
                    signupdata.referrerType = tprotocol.readString();
                    signupdata.setReferrerTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (SignupData)tbase);
            }

            public void write(TProtocol tprotocol, SignupData signupdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (signupdata.isSetVia())
                {
                    bitset.set(0);
                }
                if (signupdata.isSetMedium())
                {
                    bitset.set(1);
                }
                if (signupdata.isSetSocialId())
                {
                    bitset.set(2);
                }
                if (signupdata.isSetUserAgent())
                {
                    bitset.set(3);
                }
                if (signupdata.isSetReferrerType())
                {
                    bitset.set(4);
                }
                tprotocol.writeBitSet(bitset, 5);
                if (signupdata.isSetVia())
                {
                    tprotocol.writeString(signupdata.via);
                }
                if (signupdata.isSetMedium())
                {
                    tprotocol.writeString(signupdata.medium);
                }
                if (signupdata.isSetSocialId())
                {
                    tprotocol.writeString(signupdata.socialId);
                }
                if (signupdata.isSetUserAgent())
                {
                    tprotocol.writeString(signupdata.userAgent);
                }
                if (signupdata.isSetReferrerType())
                {
                    tprotocol.writeString(signupdata.referrerType);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (SignupData)tbase);
            }

            private SignupDataTupleScheme()
            {
            }

            SignupDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
