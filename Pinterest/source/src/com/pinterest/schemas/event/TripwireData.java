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
//            LimitAction

public class TripwireData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ACTION_FIELD_DESC = new TField("action", (byte)8, (short)2);
    private static final TField RULE_NAME_FIELD_DESC = new TField("ruleName", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("TripwireData");
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)3);
    private static final int __USERID_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public LimitAction action;
    public String ruleName;
    public long userId;

    public TripwireData()
    {
        __isset_bitfield = 0;
    }

    public TripwireData(TripwireData tripwiredata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = tripwiredata.__isset_bitfield;
        if (tripwiredata.isSetRuleName())
        {
            ruleName = tripwiredata.ruleName;
        }
        if (tripwiredata.isSetAction())
        {
            action = tripwiredata.action;
        }
        userId = tripwiredata.userId;
    }

    public TripwireData(String s, LimitAction limitaction, long l)
    {
        this();
        ruleName = s;
        action = limitaction;
        userId = l;
        setUserIdIsSet(true);
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
        ruleName = null;
        action = null;
        setUserIdIsSet(false);
        userId = 0L;
    }

    public int compareTo(TripwireData tripwiredata)
    {
        if (getClass().equals(tripwiredata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(tripwiredata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetRuleName()).compareTo(Boolean.valueOf(tripwiredata.isSetRuleName()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetRuleName())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(ruleName, tripwiredata.ruleName);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetAction()).compareTo(Boolean.valueOf(tripwiredata.isSetAction()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetAction())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(action, tripwiredata.action);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(tripwiredata.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, tripwiredata.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((TripwireData)obj);
    }

    public TripwireData deepCopy()
    {
        return new TripwireData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(TripwireData tripwiredata)
    {
        if (tripwiredata != null)
        {
            boolean flag = isSetRuleName();
            boolean flag2 = tripwiredata.isSetRuleName();
            if (!flag && !flag2 || flag && flag2 && ruleName.equals(tripwiredata.ruleName))
            {
                boolean flag1 = isSetAction();
                boolean flag3 = tripwiredata.isSetAction();
                if ((!flag1 && !flag3 || flag1 && flag3 && action.equals(tripwiredata.action)) && userId == tripwiredata.userId)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof TripwireData)) 
        {
            return false;
        }
        return equals((TripwireData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public LimitAction getAction()
    {
        return action;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TripwireData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getRuleName();

        case 2: // '\002'
            return getAction();

        case 3: // '\003'
            return Long.valueOf(getUserId());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getRuleName()
    {
        return ruleName;
    }

    public long getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetRuleName();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(ruleName);
        }
        flag = isSetAction();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(action.getValue()));
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(userId));
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TripwireData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetRuleName();

        case 2: // '\002'
            return isSetAction();

        case 3: // '\003'
            return isSetUserId();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAction()
    {
        return action != null;
    }

    public boolean isSetRuleName()
    {
        return ruleName != null;
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public TripwireData setAction(LimitAction limitaction)
    {
        action = limitaction;
        return this;
    }

    public void setActionIsSet(boolean flag)
    {
        if (!flag)
        {
            action = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.TripwireData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetRuleName();
                return;
            } else
            {
                setRuleName((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAction();
                return;
            } else
            {
                setAction((LimitAction)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetUserId();
            return;
        } else
        {
            setUserId(((Long)obj).longValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public TripwireData setRuleName(String s)
    {
        ruleName = s;
        return this;
    }

    public void setRuleNameIsSet(boolean flag)
    {
        if (!flag)
        {
            ruleName = null;
        }
    }

    public TripwireData setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("TripwireData(");
        stringbuilder.append("ruleName:");
        if (ruleName == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(ruleName);
        }
        stringbuilder.append(", ");
        stringbuilder.append("action:");
        if (action == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(action);
        }
        stringbuilder.append(", ");
        stringbuilder.append("userId:");
        stringbuilder.append(userId);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAction()
    {
        action = null;
    }

    public void unsetRuleName()
    {
        ruleName = null;
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new TripwireDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new TripwireDataTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/TripwireData$_Fields);
        ((Map) (obj)).put(_Fields.RULE_NAME, new FieldMetaData("ruleName", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ACTION, new FieldMetaData("action", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/LimitAction)));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/TripwireData, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ACTION;
        public static final _Fields RULE_NAME;
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
                return RULE_NAME;

            case 2: // '\002'
                return ACTION;

            case 3: // '\003'
                return USER_ID;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/TripwireData$_Fields, s);
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
            RULE_NAME = new _Fields("RULE_NAME", 0, (short)1, "ruleName");
            ACTION = new _Fields("ACTION", 1, (short)2, "action");
            USER_ID = new _Fields("USER_ID", 2, (short)3, "userId");
            $VALUES = (new _Fields[] {
                RULE_NAME, ACTION, USER_ID
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/TripwireData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$TripwireData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$TripwireData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$TripwireData$_Fields[_Fields.RULE_NAME.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$TripwireData$_Fields[_Fields.ACTION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$TripwireData$_Fields[_Fields.USER_ID.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class TripwireDataStandardSchemeFactory
        implements SchemeFactory
    {

        public TripwireDataStandardScheme getScheme()
        {
            return new TripwireDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TripwireDataStandardSchemeFactory()
        {
        }

        TripwireDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TripwireDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, TripwireData tripwiredata)
            {
                tprotocol.readStructBegin();
_L6:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_174;
                }
                tfield.id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 99
            //                           3 138;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_138;
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
                    tripwiredata.ruleName = tprotocol.readString();
                    tripwiredata.setRuleNameIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 8)
                {
                    tripwiredata.action = LimitAction.findByValue(tprotocol.readI32());
                    tripwiredata.setActionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 10)
                {
                    tripwiredata.userId = tprotocol.readI64();
                    tripwiredata.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                tripwiredata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TripwireData)tbase);
            }

            public void write(TProtocol tprotocol, TripwireData tripwiredata)
            {
                tripwiredata.validate();
                tprotocol.writeStructBegin(TripwireData.STRUCT_DESC);
                if (tripwiredata.ruleName != null)
                {
                    tprotocol.writeFieldBegin(TripwireData.RULE_NAME_FIELD_DESC);
                    tprotocol.writeString(tripwiredata.ruleName);
                    tprotocol.writeFieldEnd();
                }
                if (tripwiredata.action != null)
                {
                    tprotocol.writeFieldBegin(TripwireData.ACTION_FIELD_DESC);
                    tprotocol.writeI32(tripwiredata.action.getValue());
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(TripwireData.USER_ID_FIELD_DESC);
                tprotocol.writeI64(tripwiredata.userId);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TripwireData)tbase);
            }

            private TripwireDataStandardScheme()
            {
            }

            TripwireDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class TripwireDataTupleSchemeFactory
        implements SchemeFactory
    {

        public TripwireDataTupleScheme getScheme()
        {
            return new TripwireDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TripwireDataTupleSchemeFactory()
        {
        }

        TripwireDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TripwireDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, TripwireData tripwiredata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    tripwiredata.ruleName = tprotocol.readString();
                    tripwiredata.setRuleNameIsSet(true);
                }
                if (bitset.get(1))
                {
                    tripwiredata.action = LimitAction.findByValue(tprotocol.readI32());
                    tripwiredata.setActionIsSet(true);
                }
                if (bitset.get(2))
                {
                    tripwiredata.userId = tprotocol.readI64();
                    tripwiredata.setUserIdIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TripwireData)tbase);
            }

            public void write(TProtocol tprotocol, TripwireData tripwiredata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (tripwiredata.isSetRuleName())
                {
                    bitset.set(0);
                }
                if (tripwiredata.isSetAction())
                {
                    bitset.set(1);
                }
                if (tripwiredata.isSetUserId())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (tripwiredata.isSetRuleName())
                {
                    tprotocol.writeString(tripwiredata.ruleName);
                }
                if (tripwiredata.isSetAction())
                {
                    tprotocol.writeI32(tripwiredata.action.getValue());
                }
                if (tripwiredata.isSetUserId())
                {
                    tprotocol.writeI64(tripwiredata.userId);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TripwireData)tbase);
            }

            private TripwireDataTupleScheme()
            {
            }

            TripwireDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
