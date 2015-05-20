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
import org.apache.thrift.meta_data.EnumMetaData;
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

// Referenced classes of package com.pinterest.schemas.event:
//            AppType

public class ExperimentActivation
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField APP_TYPE_FIELD_DESC = new TField("appType", (byte)8, (short)6);
    private static final TField CONTEXT_INFO_FIELD_DESC = new TField("contextInfo", (byte)11, (short)14);
    private static final TField COUNTRY_FIELD_DESC = new TField("country", (byte)11, (short)10);
    private static final TField EXPERIMENT_GROUP_FIELD_DESC = new TField("experimentGroup", (byte)11, (short)5);
    private static final TField EXPERIMENT_HASH_FIELD_DESC = new TField("experimentHash", (byte)11, (short)2);
    private static final TField EXPERIMENT_INFO_FIELD_DESC = new TField("experimentInfo", (byte)11, (short)13);
    private static final TField EXPERIMENT_NAME_FIELD_DESC = new TField("experimentName", (byte)11, (short)3);
    private static final TField EXPERIMENT_VERSION_FIELD_DESC = new TField("experimentVersion", (byte)8, (short)4);
    private static final TField IP_ADDRESS_FIELD_DESC = new TField("ipAddress", (byte)11, (short)11);
    private static final TField REQUEST_ID_FIELD_DESC = new TField("requestId", (byte)11, (short)7);
    private static final TField SESSION_ID_FIELD_DESC = new TField("sessionId", (byte)11, (short)9);
    private static final TStruct STRUCT_DESC = new TStruct("ExperimentActivation");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)1);
    private static final TField UNIQUE_ID_FIELD_DESC = new TField("uniqueId", (byte)11, (short)12);
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)8);
    private static final int __EXPERIMENTVERSION_ISSET_ID = 1;
    private static final int __TIME_ISSET_ID = 0;
    private static final int __USERID_ISSET_ID = 2;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public AppType appType;
    public String contextInfo;
    public String country;
    public String experimentGroup;
    public String experimentHash;
    public String experimentInfo;
    public String experimentName;
    public int experimentVersion;
    public String ipAddress;
    public String requestId;
    public String sessionId;
    public long time;
    public String uniqueId;
    public long userId;

    public ExperimentActivation()
    {
        __isset_bitfield = 0;
    }

    public ExperimentActivation(long l, String s, String s1, int i, String s2)
    {
        this();
        time = l;
        setTimeIsSet(true);
        experimentHash = s;
        experimentName = s1;
        experimentVersion = i;
        setExperimentVersionIsSet(true);
        experimentGroup = s2;
    }

    public ExperimentActivation(ExperimentActivation experimentactivation)
    {
        __isset_bitfield = 0;
        __isset_bitfield = experimentactivation.__isset_bitfield;
        time = experimentactivation.time;
        if (experimentactivation.isSetExperimentHash())
        {
            experimentHash = experimentactivation.experimentHash;
        }
        if (experimentactivation.isSetExperimentName())
        {
            experimentName = experimentactivation.experimentName;
        }
        experimentVersion = experimentactivation.experimentVersion;
        if (experimentactivation.isSetExperimentGroup())
        {
            experimentGroup = experimentactivation.experimentGroup;
        }
        if (experimentactivation.isSetAppType())
        {
            appType = experimentactivation.appType;
        }
        if (experimentactivation.isSetRequestId())
        {
            requestId = experimentactivation.requestId;
        }
        userId = experimentactivation.userId;
        if (experimentactivation.isSetSessionId())
        {
            sessionId = experimentactivation.sessionId;
        }
        if (experimentactivation.isSetCountry())
        {
            country = experimentactivation.country;
        }
        if (experimentactivation.isSetIpAddress())
        {
            ipAddress = experimentactivation.ipAddress;
        }
        if (experimentactivation.isSetUniqueId())
        {
            uniqueId = experimentactivation.uniqueId;
        }
        if (experimentactivation.isSetExperimentInfo())
        {
            experimentInfo = experimentactivation.experimentInfo;
        }
        if (experimentactivation.isSetContextInfo())
        {
            contextInfo = experimentactivation.contextInfo;
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

    public void clear()
    {
        setTimeIsSet(false);
        time = 0L;
        experimentHash = null;
        experimentName = null;
        setExperimentVersionIsSet(false);
        experimentVersion = 0;
        experimentGroup = null;
        appType = null;
        requestId = null;
        setUserIdIsSet(false);
        userId = 0L;
        sessionId = null;
        country = null;
        ipAddress = null;
        uniqueId = null;
        experimentInfo = null;
        contextInfo = null;
    }

    public int compareTo(ExperimentActivation experimentactivation)
    {
        if (getClass().equals(experimentactivation.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(experimentactivation.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(experimentactivation.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, experimentactivation.time);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetExperimentHash()).compareTo(Boolean.valueOf(experimentactivation.isSetExperimentHash()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetExperimentHash())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experimentHash, experimentactivation.experimentHash);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetExperimentName()).compareTo(Boolean.valueOf(experimentactivation.isSetExperimentName()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetExperimentName())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experimentName, experimentactivation.experimentName);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetExperimentVersion()).compareTo(Boolean.valueOf(experimentactivation.isSetExperimentVersion()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetExperimentVersion())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experimentVersion, experimentactivation.experimentVersion);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetExperimentGroup()).compareTo(Boolean.valueOf(experimentactivation.isSetExperimentGroup()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetExperimentGroup())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experimentGroup, experimentactivation.experimentGroup);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetAppType()).compareTo(Boolean.valueOf(experimentactivation.isSetAppType()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetAppType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(appType, experimentactivation.appType);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetRequestId()).compareTo(Boolean.valueOf(experimentactivation.isSetRequestId()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetRequestId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestId, experimentactivation.requestId);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(experimentactivation.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, experimentactivation.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        j = Boolean.valueOf(isSetSessionId()).compareTo(Boolean.valueOf(experimentactivation.isSetSessionId()));
        i = j;
        if (j != 0) goto _L4; else goto _L20
_L20:
        if (!isSetSessionId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(sessionId, experimentactivation.sessionId);
        i = j;
        if (j != 0) goto _L4; else goto _L21
_L21:
        j = Boolean.valueOf(isSetCountry()).compareTo(Boolean.valueOf(experimentactivation.isSetCountry()));
        i = j;
        if (j != 0) goto _L4; else goto _L22
_L22:
        if (!isSetCountry())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(country, experimentactivation.country);
        i = j;
        if (j != 0) goto _L4; else goto _L23
_L23:
        j = Boolean.valueOf(isSetIpAddress()).compareTo(Boolean.valueOf(experimentactivation.isSetIpAddress()));
        i = j;
        if (j != 0) goto _L4; else goto _L24
_L24:
        if (!isSetIpAddress())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(ipAddress, experimentactivation.ipAddress);
        i = j;
        if (j != 0) goto _L4; else goto _L25
_L25:
        j = Boolean.valueOf(isSetUniqueId()).compareTo(Boolean.valueOf(experimentactivation.isSetUniqueId()));
        i = j;
        if (j != 0) goto _L4; else goto _L26
_L26:
        if (!isSetUniqueId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(uniqueId, experimentactivation.uniqueId);
        i = j;
        if (j != 0) goto _L4; else goto _L27
_L27:
        j = Boolean.valueOf(isSetExperimentInfo()).compareTo(Boolean.valueOf(experimentactivation.isSetExperimentInfo()));
        i = j;
        if (j != 0) goto _L4; else goto _L28
_L28:
        if (!isSetExperimentInfo())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(experimentInfo, experimentactivation.experimentInfo);
        i = j;
        if (j != 0) goto _L4; else goto _L29
_L29:
        j = Boolean.valueOf(isSetContextInfo()).compareTo(Boolean.valueOf(experimentactivation.isSetContextInfo()));
        i = j;
        if (j != 0) goto _L4; else goto _L30
_L30:
        if (!isSetContextInfo())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(contextInfo, experimentactivation.contextInfo);
        i = j;
        if (j != 0) goto _L4; else goto _L31
_L31:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ExperimentActivation)obj);
    }

    public ExperimentActivation deepCopy()
    {
        return new ExperimentActivation(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(ExperimentActivation experimentactivation)
    {
        if (experimentactivation != null && time == experimentactivation.time)
        {
            boolean flag = isSetExperimentHash();
            boolean flag12 = experimentactivation.isSetExperimentHash();
            if (!flag && !flag12 || flag && flag12 && experimentHash.equals(experimentactivation.experimentHash))
            {
                boolean flag1 = isSetExperimentName();
                boolean flag13 = experimentactivation.isSetExperimentName();
                if ((!flag1 && !flag13 || flag1 && flag13 && experimentName.equals(experimentactivation.experimentName)) && experimentVersion == experimentactivation.experimentVersion)
                {
                    boolean flag2 = isSetExperimentGroup();
                    boolean flag14 = experimentactivation.isSetExperimentGroup();
                    if (!flag2 && !flag14 || flag2 && flag14 && experimentGroup.equals(experimentactivation.experimentGroup))
                    {
                        boolean flag3 = isSetAppType();
                        boolean flag15 = experimentactivation.isSetAppType();
                        if (!flag3 && !flag15 || flag3 && flag15 && appType.equals(experimentactivation.appType))
                        {
                            boolean flag4 = isSetRequestId();
                            boolean flag16 = experimentactivation.isSetRequestId();
                            if (!flag4 && !flag16 || flag4 && flag16 && requestId.equals(experimentactivation.requestId))
                            {
                                boolean flag5 = isSetUserId();
                                boolean flag17 = experimentactivation.isSetUserId();
                                if (!flag5 && !flag17 || flag5 && flag17 && userId == experimentactivation.userId)
                                {
                                    boolean flag6 = isSetSessionId();
                                    boolean flag18 = experimentactivation.isSetSessionId();
                                    if (!flag6 && !flag18 || flag6 && flag18 && sessionId.equals(experimentactivation.sessionId))
                                    {
                                        boolean flag7 = isSetCountry();
                                        boolean flag19 = experimentactivation.isSetCountry();
                                        if (!flag7 && !flag19 || flag7 && flag19 && country.equals(experimentactivation.country))
                                        {
                                            boolean flag8 = isSetIpAddress();
                                            boolean flag20 = experimentactivation.isSetIpAddress();
                                            if (!flag8 && !flag20 || flag8 && flag20 && ipAddress.equals(experimentactivation.ipAddress))
                                            {
                                                boolean flag9 = isSetUniqueId();
                                                boolean flag21 = experimentactivation.isSetUniqueId();
                                                if (!flag9 && !flag21 || flag9 && flag21 && uniqueId.equals(experimentactivation.uniqueId))
                                                {
                                                    boolean flag10 = isSetExperimentInfo();
                                                    boolean flag22 = experimentactivation.isSetExperimentInfo();
                                                    if (!flag10 && !flag22 || flag10 && flag22 && experimentInfo.equals(experimentactivation.experimentInfo))
                                                    {
                                                        boolean flag11 = isSetContextInfo();
                                                        boolean flag23 = experimentactivation.isSetContextInfo();
                                                        if (!flag11 && !flag23 || flag11 && flag23 && contextInfo.equals(experimentactivation.contextInfo))
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
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof ExperimentActivation)) 
        {
            return false;
        }
        return equals((ExperimentActivation)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public AppType getAppType()
    {
        return appType;
    }

    public String getContextInfo()
    {
        return contextInfo;
    }

    public String getCountry()
    {
        return country;
    }

    public String getExperimentGroup()
    {
        return experimentGroup;
    }

    public String getExperimentHash()
    {
        return experimentHash;
    }

    public String getExperimentInfo()
    {
        return experimentInfo;
    }

    public String getExperimentName()
    {
        return experimentName;
    }

    public int getExperimentVersion()
    {
        return experimentVersion;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ExperimentActivation._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getTime());

        case 2: // '\002'
            return getExperimentHash();

        case 3: // '\003'
            return getExperimentName();

        case 4: // '\004'
            return Integer.valueOf(getExperimentVersion());

        case 5: // '\005'
            return getExperimentGroup();

        case 6: // '\006'
            return getAppType();

        case 7: // '\007'
            return getRequestId();

        case 8: // '\b'
            return Long.valueOf(getUserId());

        case 9: // '\t'
            return getSessionId();

        case 10: // '\n'
            return getCountry();

        case 11: // '\013'
            return getIpAddress();

        case 12: // '\f'
            return getUniqueId();

        case 13: // '\r'
            return getExperimentInfo();

        case 14: // '\016'
            return getContextInfo();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public long getTime()
    {
        return time;
    }

    public String getUniqueId()
    {
        return uniqueId;
    }

    public long getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        boolean flag = isSetExperimentHash();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(experimentHash);
        }
        flag = isSetExperimentName();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(experimentName);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Integer.valueOf(experimentVersion));
        flag = isSetExperimentGroup();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(experimentGroup);
        }
        flag = isSetAppType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(appType.getValue()));
        }
        flag = isSetRequestId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestId);
        }
        flag = isSetUserId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Long.valueOf(userId));
        }
        flag = isSetSessionId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(sessionId);
        }
        flag = isSetCountry();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(country);
        }
        flag = isSetIpAddress();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(ipAddress);
        }
        flag = isSetUniqueId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(uniqueId);
        }
        flag = isSetExperimentInfo();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(experimentInfo);
        }
        flag = isSetContextInfo();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(contextInfo);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ExperimentActivation._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTime();

        case 2: // '\002'
            return isSetExperimentHash();

        case 3: // '\003'
            return isSetExperimentName();

        case 4: // '\004'
            return isSetExperimentVersion();

        case 5: // '\005'
            return isSetExperimentGroup();

        case 6: // '\006'
            return isSetAppType();

        case 7: // '\007'
            return isSetRequestId();

        case 8: // '\b'
            return isSetUserId();

        case 9: // '\t'
            return isSetSessionId();

        case 10: // '\n'
            return isSetCountry();

        case 11: // '\013'
            return isSetIpAddress();

        case 12: // '\f'
            return isSetUniqueId();

        case 13: // '\r'
            return isSetExperimentInfo();

        case 14: // '\016'
            return isSetContextInfo();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAppType()
    {
        return appType != null;
    }

    public boolean isSetContextInfo()
    {
        return contextInfo != null;
    }

    public boolean isSetCountry()
    {
        return country != null;
    }

    public boolean isSetExperimentGroup()
    {
        return experimentGroup != null;
    }

    public boolean isSetExperimentHash()
    {
        return experimentHash != null;
    }

    public boolean isSetExperimentInfo()
    {
        return experimentInfo != null;
    }

    public boolean isSetExperimentName()
    {
        return experimentName != null;
    }

    public boolean isSetExperimentVersion()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetIpAddress()
    {
        return ipAddress != null;
    }

    public boolean isSetRequestId()
    {
        return requestId != null;
    }

    public boolean isSetSessionId()
    {
        return sessionId != null;
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetUniqueId()
    {
        return uniqueId != null;
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public ExperimentActivation setAppType(AppType apptype)
    {
        appType = apptype;
        return this;
    }

    public void setAppTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            appType = null;
        }
    }

    public ExperimentActivation setContextInfo(String s)
    {
        contextInfo = s;
        return this;
    }

    public void setContextInfoIsSet(boolean flag)
    {
        if (!flag)
        {
            contextInfo = null;
        }
    }

    public ExperimentActivation setCountry(String s)
    {
        country = s;
        return this;
    }

    public void setCountryIsSet(boolean flag)
    {
        if (!flag)
        {
            country = null;
        }
    }

    public ExperimentActivation setExperimentGroup(String s)
    {
        experimentGroup = s;
        return this;
    }

    public void setExperimentGroupIsSet(boolean flag)
    {
        if (!flag)
        {
            experimentGroup = null;
        }
    }

    public ExperimentActivation setExperimentHash(String s)
    {
        experimentHash = s;
        return this;
    }

    public void setExperimentHashIsSet(boolean flag)
    {
        if (!flag)
        {
            experimentHash = null;
        }
    }

    public ExperimentActivation setExperimentInfo(String s)
    {
        experimentInfo = s;
        return this;
    }

    public void setExperimentInfoIsSet(boolean flag)
    {
        if (!flag)
        {
            experimentInfo = null;
        }
    }

    public ExperimentActivation setExperimentName(String s)
    {
        experimentName = s;
        return this;
    }

    public void setExperimentNameIsSet(boolean flag)
    {
        if (!flag)
        {
            experimentName = null;
        }
    }

    public ExperimentActivation setExperimentVersion(int i)
    {
        experimentVersion = i;
        setExperimentVersionIsSet(true);
        return this;
    }

    public void setExperimentVersionIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ExperimentActivation._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetExperimentHash();
                return;
            } else
            {
                setExperimentHash((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetExperimentName();
                return;
            } else
            {
                setExperimentName((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetExperimentVersion();
                return;
            } else
            {
                setExperimentVersion(((Integer)obj).intValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetExperimentGroup();
                return;
            } else
            {
                setExperimentGroup((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAppType();
                return;
            } else
            {
                setAppType((AppType)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetRequestId();
                return;
            } else
            {
                setRequestId((String)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetUserId();
                return;
            } else
            {
                setUserId(((Long)obj).longValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetSessionId();
                return;
            } else
            {
                setSessionId((String)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetCountry();
                return;
            } else
            {
                setCountry((String)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetIpAddress();
                return;
            } else
            {
                setIpAddress((String)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetUniqueId();
                return;
            } else
            {
                setUniqueId((String)obj);
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetExperimentInfo();
                return;
            } else
            {
                setExperimentInfo((String)obj);
                return;
            }

        case 14: // '\016'
            break;
        }
        if (obj == null)
        {
            unsetContextInfo();
            return;
        } else
        {
            setContextInfo((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public ExperimentActivation setIpAddress(String s)
    {
        ipAddress = s;
        return this;
    }

    public void setIpAddressIsSet(boolean flag)
    {
        if (!flag)
        {
            ipAddress = null;
        }
    }

    public ExperimentActivation setRequestId(String s)
    {
        requestId = s;
        return this;
    }

    public void setRequestIdIsSet(boolean flag)
    {
        if (!flag)
        {
            requestId = null;
        }
    }

    public ExperimentActivation setSessionId(String s)
    {
        sessionId = s;
        return this;
    }

    public void setSessionIdIsSet(boolean flag)
    {
        if (!flag)
        {
            sessionId = null;
        }
    }

    public ExperimentActivation setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public ExperimentActivation setUniqueId(String s)
    {
        uniqueId = s;
        return this;
    }

    public void setUniqueIdIsSet(boolean flag)
    {
        if (!flag)
        {
            uniqueId = null;
        }
    }

    public ExperimentActivation setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ExperimentActivation(");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        stringbuilder.append(", ");
        stringbuilder.append("experimentHash:");
        if (experimentHash == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(experimentHash);
        }
        stringbuilder.append(", ");
        stringbuilder.append("experimentName:");
        if (experimentName == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(experimentName);
        }
        stringbuilder.append(", ");
        stringbuilder.append("experimentVersion:");
        stringbuilder.append(experimentVersion);
        stringbuilder.append(", ");
        stringbuilder.append("experimentGroup:");
        if (experimentGroup == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(experimentGroup);
        }
        if (isSetAppType())
        {
            stringbuilder.append(", ");
            stringbuilder.append("appType:");
            if (appType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(appType);
            }
        }
        if (isSetRequestId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("requestId:");
            if (requestId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(requestId);
            }
        }
        if (isSetUserId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userId:");
            stringbuilder.append(userId);
        }
        if (isSetSessionId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("sessionId:");
            if (sessionId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(sessionId);
            }
        }
        if (isSetCountry())
        {
            stringbuilder.append(", ");
            stringbuilder.append("country:");
            if (country == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(country);
            }
        }
        if (isSetIpAddress())
        {
            stringbuilder.append(", ");
            stringbuilder.append("ipAddress:");
            if (ipAddress == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(ipAddress);
            }
        }
        if (isSetUniqueId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("uniqueId:");
            if (uniqueId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(uniqueId);
            }
        }
        if (isSetExperimentInfo())
        {
            stringbuilder.append(", ");
            stringbuilder.append("experimentInfo:");
            if (experimentInfo == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(experimentInfo);
            }
        }
        if (isSetContextInfo())
        {
            stringbuilder.append(", ");
            stringbuilder.append("contextInfo:");
            if (contextInfo == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(contextInfo);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAppType()
    {
        appType = null;
    }

    public void unsetContextInfo()
    {
        contextInfo = null;
    }

    public void unsetCountry()
    {
        country = null;
    }

    public void unsetExperimentGroup()
    {
        experimentGroup = null;
    }

    public void unsetExperimentHash()
    {
        experimentHash = null;
    }

    public void unsetExperimentInfo()
    {
        experimentInfo = null;
    }

    public void unsetExperimentName()
    {
        experimentName = null;
    }

    public void unsetExperimentVersion()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetIpAddress()
    {
        ipAddress = null;
    }

    public void unsetRequestId()
    {
        requestId = null;
    }

    public void unsetSessionId()
    {
        sessionId = null;
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUniqueId()
    {
        uniqueId = null;
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new ExperimentActivationStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new ExperimentActivationTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.APP_TYPE, _Fields.REQUEST_ID, _Fields.USER_ID, _Fields.SESSION_ID, _Fields.COUNTRY, _Fields.IP_ADDRESS, _Fields.UNIQUE_ID, _Fields.EXPERIMENT_INFO, _Fields.CONTEXT_INFO
        });
        obj = new EnumMap(com/pinterest/schemas/event/ExperimentActivation$_Fields);
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.EXPERIMENT_HASH, new FieldMetaData("experimentHash", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.EXPERIMENT_NAME, new FieldMetaData("experimentName", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.EXPERIMENT_VERSION, new FieldMetaData("experimentVersion", (byte)3, new FieldValueMetaData((byte)8)));
        ((Map) (obj)).put(_Fields.EXPERIMENT_GROUP, new FieldMetaData("experimentGroup", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.APP_TYPE, new FieldMetaData("appType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/AppType)));
        ((Map) (obj)).put(_Fields.REQUEST_ID, new FieldMetaData("requestId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)2, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.SESSION_ID, new FieldMetaData("sessionId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.COUNTRY, new FieldMetaData("country", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.IP_ADDRESS, new FieldMetaData("ipAddress", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.UNIQUE_ID, new FieldMetaData("uniqueId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.EXPERIMENT_INFO, new FieldMetaData("experimentInfo", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.CONTEXT_INFO, new FieldMetaData("contextInfo", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/ExperimentActivation, metaDataMap);
    }
















    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields APP_TYPE;
        public static final _Fields CONTEXT_INFO;
        public static final _Fields COUNTRY;
        public static final _Fields EXPERIMENT_GROUP;
        public static final _Fields EXPERIMENT_HASH;
        public static final _Fields EXPERIMENT_INFO;
        public static final _Fields EXPERIMENT_NAME;
        public static final _Fields EXPERIMENT_VERSION;
        public static final _Fields IP_ADDRESS;
        public static final _Fields REQUEST_ID;
        public static final _Fields SESSION_ID;
        public static final _Fields TIME;
        public static final _Fields UNIQUE_ID;
        public static final _Fields USER_ID;
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
                return TIME;

            case 2: // '\002'
                return EXPERIMENT_HASH;

            case 3: // '\003'
                return EXPERIMENT_NAME;

            case 4: // '\004'
                return EXPERIMENT_VERSION;

            case 5: // '\005'
                return EXPERIMENT_GROUP;

            case 6: // '\006'
                return APP_TYPE;

            case 7: // '\007'
                return REQUEST_ID;

            case 8: // '\b'
                return USER_ID;

            case 9: // '\t'
                return SESSION_ID;

            case 10: // '\n'
                return COUNTRY;

            case 11: // '\013'
                return IP_ADDRESS;

            case 12: // '\f'
                return UNIQUE_ID;

            case 13: // '\r'
                return EXPERIMENT_INFO;

            case 14: // '\016'
                return CONTEXT_INFO;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/ExperimentActivation$_Fields, s);
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
            TIME = new _Fields("TIME", 0, (short)1, "time");
            EXPERIMENT_HASH = new _Fields("EXPERIMENT_HASH", 1, (short)2, "experimentHash");
            EXPERIMENT_NAME = new _Fields("EXPERIMENT_NAME", 2, (short)3, "experimentName");
            EXPERIMENT_VERSION = new _Fields("EXPERIMENT_VERSION", 3, (short)4, "experimentVersion");
            EXPERIMENT_GROUP = new _Fields("EXPERIMENT_GROUP", 4, (short)5, "experimentGroup");
            APP_TYPE = new _Fields("APP_TYPE", 5, (short)6, "appType");
            REQUEST_ID = new _Fields("REQUEST_ID", 6, (short)7, "requestId");
            USER_ID = new _Fields("USER_ID", 7, (short)8, "userId");
            SESSION_ID = new _Fields("SESSION_ID", 8, (short)9, "sessionId");
            COUNTRY = new _Fields("COUNTRY", 9, (short)10, "country");
            IP_ADDRESS = new _Fields("IP_ADDRESS", 10, (short)11, "ipAddress");
            UNIQUE_ID = new _Fields("UNIQUE_ID", 11, (short)12, "uniqueId");
            EXPERIMENT_INFO = new _Fields("EXPERIMENT_INFO", 12, (short)13, "experimentInfo");
            CONTEXT_INFO = new _Fields("CONTEXT_INFO", 13, (short)14, "contextInfo");
            $VALUES = (new _Fields[] {
                TIME, EXPERIMENT_HASH, EXPERIMENT_NAME, EXPERIMENT_VERSION, EXPERIMENT_GROUP, APP_TYPE, REQUEST_ID, USER_ID, SESSION_ID, COUNTRY, 
                IP_ADDRESS, UNIQUE_ID, EXPERIMENT_INFO, CONTEXT_INFO
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ExperimentActivation$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.TIME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.EXPERIMENT_HASH.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.EXPERIMENT_NAME.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.EXPERIMENT_VERSION.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.EXPERIMENT_GROUP.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.APP_TYPE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.REQUEST_ID.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.USER_ID.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.SESSION_ID.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.COUNTRY.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.IP_ADDRESS.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.UNIQUE_ID.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.EXPERIMENT_INFO.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ExperimentActivation$_Fields[_Fields.CONTEXT_INFO.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ExperimentActivationStandardSchemeFactory
        implements SchemeFactory
    {

        public ExperimentActivationStandardScheme getScheme()
        {
            return new ExperimentActivationStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ExperimentActivationStandardSchemeFactory()
        {
        }

        ExperimentActivationStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ExperimentActivationStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, ExperimentActivation experimentactivation)
            {
                tprotocol.readStructBegin();
_L17:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_614;
                }
                tfield.id;
                JVM INSTR tableswitch 1 14: default 92
            //                           1 107
            //                           2 143
            //                           3 179
            //                           4 215
            //                           5 251
            //                           6 287
            //                           7 326
            //                           8 362
            //                           9 398
            //                           10 434
            //                           11 470
            //                           12 506
            //                           13 542
            //                           14 578;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L15:
                break MISSING_BLOCK_LABEL_578;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L18:
                tprotocol.readFieldEnd();
                if (true) goto _L17; else goto _L16
_L16:
                if (tfield.type == 10)
                {
                    experimentactivation.time = tprotocol.readI64();
                    experimentactivation.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L3:
                if (tfield.type == 11)
                {
                    experimentactivation.experimentHash = tprotocol.readString();
                    experimentactivation.setExperimentHashIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L4:
                if (tfield.type == 11)
                {
                    experimentactivation.experimentName = tprotocol.readString();
                    experimentactivation.setExperimentNameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L5:
                if (tfield.type == 8)
                {
                    experimentactivation.experimentVersion = tprotocol.readI32();
                    experimentactivation.setExperimentVersionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L6:
                if (tfield.type == 11)
                {
                    experimentactivation.experimentGroup = tprotocol.readString();
                    experimentactivation.setExperimentGroupIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L7:
                if (tfield.type == 8)
                {
                    experimentactivation.appType = AppType.findByValue(tprotocol.readI32());
                    experimentactivation.setAppTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L8:
                if (tfield.type == 11)
                {
                    experimentactivation.requestId = tprotocol.readString();
                    experimentactivation.setRequestIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L9:
                if (tfield.type == 10)
                {
                    experimentactivation.userId = tprotocol.readI64();
                    experimentactivation.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L10:
                if (tfield.type == 11)
                {
                    experimentactivation.sessionId = tprotocol.readString();
                    experimentactivation.setSessionIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L11:
                if (tfield.type == 11)
                {
                    experimentactivation.country = tprotocol.readString();
                    experimentactivation.setCountryIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L12:
                if (tfield.type == 11)
                {
                    experimentactivation.ipAddress = tprotocol.readString();
                    experimentactivation.setIpAddressIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L13:
                if (tfield.type == 11)
                {
                    experimentactivation.uniqueId = tprotocol.readString();
                    experimentactivation.setUniqueIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
_L14:
                if (tfield.type == 11)
                {
                    experimentactivation.experimentInfo = tprotocol.readString();
                    experimentactivation.setExperimentInfoIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
                if (tfield.type == 11)
                {
                    experimentactivation.contextInfo = tprotocol.readString();
                    experimentactivation.setContextInfoIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L18
                tprotocol.readStructEnd();
                experimentactivation.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ExperimentActivation)tbase);
            }

            public void write(TProtocol tprotocol, ExperimentActivation experimentactivation)
            {
                experimentactivation.validate();
                tprotocol.writeStructBegin(ExperimentActivation.STRUCT_DESC);
                tprotocol.writeFieldBegin(ExperimentActivation.TIME_FIELD_DESC);
                tprotocol.writeI64(experimentactivation.time);
                tprotocol.writeFieldEnd();
                if (experimentactivation.experimentHash != null)
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.EXPERIMENT_HASH_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.experimentHash);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.experimentName != null)
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.EXPERIMENT_NAME_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.experimentName);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(ExperimentActivation.EXPERIMENT_VERSION_FIELD_DESC);
                tprotocol.writeI32(experimentactivation.experimentVersion);
                tprotocol.writeFieldEnd();
                if (experimentactivation.experimentGroup != null)
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.EXPERIMENT_GROUP_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.experimentGroup);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.appType != null && experimentactivation.isSetAppType())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.APP_TYPE_FIELD_DESC);
                    tprotocol.writeI32(experimentactivation.appType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.requestId != null && experimentactivation.isSetRequestId())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.REQUEST_ID_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.requestId);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.isSetUserId())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.USER_ID_FIELD_DESC);
                    tprotocol.writeI64(experimentactivation.userId);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.sessionId != null && experimentactivation.isSetSessionId())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.SESSION_ID_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.sessionId);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.country != null && experimentactivation.isSetCountry())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.COUNTRY_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.country);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.ipAddress != null && experimentactivation.isSetIpAddress())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.IP_ADDRESS_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.ipAddress);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.uniqueId != null && experimentactivation.isSetUniqueId())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.UNIQUE_ID_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.uniqueId);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.experimentInfo != null && experimentactivation.isSetExperimentInfo())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.EXPERIMENT_INFO_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.experimentInfo);
                    tprotocol.writeFieldEnd();
                }
                if (experimentactivation.contextInfo != null && experimentactivation.isSetContextInfo())
                {
                    tprotocol.writeFieldBegin(ExperimentActivation.CONTEXT_INFO_FIELD_DESC);
                    tprotocol.writeString(experimentactivation.contextInfo);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ExperimentActivation)tbase);
            }

            private ExperimentActivationStandardScheme()
            {
            }

            ExperimentActivationStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class ExperimentActivationTupleSchemeFactory
        implements SchemeFactory
    {

        public ExperimentActivationTupleScheme getScheme()
        {
            return new ExperimentActivationTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ExperimentActivationTupleSchemeFactory()
        {
        }

        ExperimentActivationTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ExperimentActivationTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, ExperimentActivation experimentactivation)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(14);
                if (bitset.get(0))
                {
                    experimentactivation.time = tprotocol.readI64();
                    experimentactivation.setTimeIsSet(true);
                }
                if (bitset.get(1))
                {
                    experimentactivation.experimentHash = tprotocol.readString();
                    experimentactivation.setExperimentHashIsSet(true);
                }
                if (bitset.get(2))
                {
                    experimentactivation.experimentName = tprotocol.readString();
                    experimentactivation.setExperimentNameIsSet(true);
                }
                if (bitset.get(3))
                {
                    experimentactivation.experimentVersion = tprotocol.readI32();
                    experimentactivation.setExperimentVersionIsSet(true);
                }
                if (bitset.get(4))
                {
                    experimentactivation.experimentGroup = tprotocol.readString();
                    experimentactivation.setExperimentGroupIsSet(true);
                }
                if (bitset.get(5))
                {
                    experimentactivation.appType = AppType.findByValue(tprotocol.readI32());
                    experimentactivation.setAppTypeIsSet(true);
                }
                if (bitset.get(6))
                {
                    experimentactivation.requestId = tprotocol.readString();
                    experimentactivation.setRequestIdIsSet(true);
                }
                if (bitset.get(7))
                {
                    experimentactivation.userId = tprotocol.readI64();
                    experimentactivation.setUserIdIsSet(true);
                }
                if (bitset.get(8))
                {
                    experimentactivation.sessionId = tprotocol.readString();
                    experimentactivation.setSessionIdIsSet(true);
                }
                if (bitset.get(9))
                {
                    experimentactivation.country = tprotocol.readString();
                    experimentactivation.setCountryIsSet(true);
                }
                if (bitset.get(10))
                {
                    experimentactivation.ipAddress = tprotocol.readString();
                    experimentactivation.setIpAddressIsSet(true);
                }
                if (bitset.get(11))
                {
                    experimentactivation.uniqueId = tprotocol.readString();
                    experimentactivation.setUniqueIdIsSet(true);
                }
                if (bitset.get(12))
                {
                    experimentactivation.experimentInfo = tprotocol.readString();
                    experimentactivation.setExperimentInfoIsSet(true);
                }
                if (bitset.get(13))
                {
                    experimentactivation.contextInfo = tprotocol.readString();
                    experimentactivation.setContextInfoIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ExperimentActivation)tbase);
            }

            public void write(TProtocol tprotocol, ExperimentActivation experimentactivation)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (experimentactivation.isSetTime())
                {
                    bitset.set(0);
                }
                if (experimentactivation.isSetExperimentHash())
                {
                    bitset.set(1);
                }
                if (experimentactivation.isSetExperimentName())
                {
                    bitset.set(2);
                }
                if (experimentactivation.isSetExperimentVersion())
                {
                    bitset.set(3);
                }
                if (experimentactivation.isSetExperimentGroup())
                {
                    bitset.set(4);
                }
                if (experimentactivation.isSetAppType())
                {
                    bitset.set(5);
                }
                if (experimentactivation.isSetRequestId())
                {
                    bitset.set(6);
                }
                if (experimentactivation.isSetUserId())
                {
                    bitset.set(7);
                }
                if (experimentactivation.isSetSessionId())
                {
                    bitset.set(8);
                }
                if (experimentactivation.isSetCountry())
                {
                    bitset.set(9);
                }
                if (experimentactivation.isSetIpAddress())
                {
                    bitset.set(10);
                }
                if (experimentactivation.isSetUniqueId())
                {
                    bitset.set(11);
                }
                if (experimentactivation.isSetExperimentInfo())
                {
                    bitset.set(12);
                }
                if (experimentactivation.isSetContextInfo())
                {
                    bitset.set(13);
                }
                tprotocol.writeBitSet(bitset, 14);
                if (experimentactivation.isSetTime())
                {
                    tprotocol.writeI64(experimentactivation.time);
                }
                if (experimentactivation.isSetExperimentHash())
                {
                    tprotocol.writeString(experimentactivation.experimentHash);
                }
                if (experimentactivation.isSetExperimentName())
                {
                    tprotocol.writeString(experimentactivation.experimentName);
                }
                if (experimentactivation.isSetExperimentVersion())
                {
                    tprotocol.writeI32(experimentactivation.experimentVersion);
                }
                if (experimentactivation.isSetExperimentGroup())
                {
                    tprotocol.writeString(experimentactivation.experimentGroup);
                }
                if (experimentactivation.isSetAppType())
                {
                    tprotocol.writeI32(experimentactivation.appType.getValue());
                }
                if (experimentactivation.isSetRequestId())
                {
                    tprotocol.writeString(experimentactivation.requestId);
                }
                if (experimentactivation.isSetUserId())
                {
                    tprotocol.writeI64(experimentactivation.userId);
                }
                if (experimentactivation.isSetSessionId())
                {
                    tprotocol.writeString(experimentactivation.sessionId);
                }
                if (experimentactivation.isSetCountry())
                {
                    tprotocol.writeString(experimentactivation.country);
                }
                if (experimentactivation.isSetIpAddress())
                {
                    tprotocol.writeString(experimentactivation.ipAddress);
                }
                if (experimentactivation.isSetUniqueId())
                {
                    tprotocol.writeString(experimentactivation.uniqueId);
                }
                if (experimentactivation.isSetExperimentInfo())
                {
                    tprotocol.writeString(experimentactivation.experimentInfo);
                }
                if (experimentactivation.isSetContextInfo())
                {
                    tprotocol.writeString(experimentactivation.contextInfo);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ExperimentActivation)tbase);
            }

            private ExperimentActivationTupleScheme()
            {
            }

            ExperimentActivationTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
