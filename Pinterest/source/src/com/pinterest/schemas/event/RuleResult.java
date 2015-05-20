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

public class RuleResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ACTION_FIELD_DESC = new TField("action", (byte)8, (short)2);
    private static final TField DATA_FIELD_DESC = new TField("data", (byte)11, (short)4);
    private static final TField MESSAGE_FIELD_DESC = new TField("message", (byte)11, (short)3);
    private static final TField RULE_FIELD_DESC = new TField("rule", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("RuleResult");
    public static final Map metaDataMap;
    private static final Map schemes;
    public LimitAction action;
    public String data;
    public String message;
    public String rule;

    public RuleResult()
    {
    }

    public RuleResult(RuleResult ruleresult)
    {
        if (ruleresult.isSetRule())
        {
            rule = ruleresult.rule;
        }
        if (ruleresult.isSetAction())
        {
            action = ruleresult.action;
        }
        if (ruleresult.isSetMessage())
        {
            message = ruleresult.message;
        }
        if (ruleresult.isSetData())
        {
            data = ruleresult.data;
        }
    }

    public RuleResult(String s, LimitAction limitaction, String s1, String s2)
    {
        this();
        rule = s;
        action = limitaction;
        message = s1;
        data = s2;
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
        rule = null;
        action = null;
        message = null;
        data = null;
    }

    public int compareTo(RuleResult ruleresult)
    {
        if (getClass().equals(ruleresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(ruleresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetRule()).compareTo(Boolean.valueOf(ruleresult.isSetRule()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetRule())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(rule, ruleresult.rule);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetAction()).compareTo(Boolean.valueOf(ruleresult.isSetAction()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetAction())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(action, ruleresult.action);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetMessage()).compareTo(Boolean.valueOf(ruleresult.isSetMessage()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetMessage())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(message, ruleresult.message);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetData()).compareTo(Boolean.valueOf(ruleresult.isSetData()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(data, ruleresult.data);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RuleResult)obj);
    }

    public RuleResult deepCopy()
    {
        return new RuleResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RuleResult ruleresult)
    {
        if (ruleresult != null)
        {
            boolean flag = isSetRule();
            boolean flag4 = ruleresult.isSetRule();
            if (!flag && !flag4 || flag && flag4 && rule.equals(ruleresult.rule))
            {
                boolean flag1 = isSetAction();
                boolean flag5 = ruleresult.isSetAction();
                if (!flag1 && !flag5 || flag1 && flag5 && action.equals(ruleresult.action))
                {
                    boolean flag2 = isSetMessage();
                    boolean flag6 = ruleresult.isSetMessage();
                    if (!flag2 && !flag6 || flag2 && flag6 && message.equals(ruleresult.message))
                    {
                        boolean flag3 = isSetData();
                        boolean flag7 = ruleresult.isSetData();
                        if (!flag3 && !flag7 || flag3 && flag7 && data.equals(ruleresult.data))
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
        while (obj == null || !(obj instanceof RuleResult)) 
        {
            return false;
        }
        return equals((RuleResult)obj);
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

    public String getData()
    {
        return data;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RuleResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getRule();

        case 2: // '\002'
            return getAction();

        case 3: // '\003'
            return getMessage();

        case 4: // '\004'
            return getData();
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

    public String getRule()
    {
        return rule;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetRule();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(rule);
        }
        flag = isSetAction();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(action.getValue()));
        }
        flag = isSetMessage();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(message);
        }
        flag = isSetData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(data);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RuleResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetRule();

        case 2: // '\002'
            return isSetAction();

        case 3: // '\003'
            return isSetMessage();

        case 4: // '\004'
            return isSetData();
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

    public boolean isSetData()
    {
        return data != null;
    }

    public boolean isSetMessage()
    {
        return message != null;
    }

    public boolean isSetRule()
    {
        return rule != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public RuleResult setAction(LimitAction limitaction)
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

    public RuleResult setData(String s)
    {
        data = s;
        return this;
    }

    public void setDataIsSet(boolean flag)
    {
        if (!flag)
        {
            data = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.RuleResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetRule();
                return;
            } else
            {
                setRule((String)obj);
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
            if (obj == null)
            {
                unsetMessage();
                return;
            } else
            {
                setMessage((String)obj);
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetData();
            return;
        } else
        {
            setData((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RuleResult setMessage(String s)
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

    public RuleResult setRule(String s)
    {
        rule = s;
        return this;
    }

    public void setRuleIsSet(boolean flag)
    {
        if (!flag)
        {
            rule = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("RuleResult(");
        stringbuilder.append("rule:");
        if (rule == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(rule);
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
        stringbuilder.append("message:");
        if (message == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(message);
        }
        stringbuilder.append(", ");
        stringbuilder.append("data:");
        if (data == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(data);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAction()
    {
        action = null;
    }

    public void unsetData()
    {
        data = null;
    }

    public void unsetMessage()
    {
        message = null;
    }

    public void unsetRule()
    {
        rule = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RuleResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RuleResultTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/RuleResult$_Fields);
        ((Map) (obj)).put(_Fields.RULE, new FieldMetaData("rule", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ACTION, new FieldMetaData("action", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/LimitAction)));
        ((Map) (obj)).put(_Fields.MESSAGE, new FieldMetaData("message", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.DATA, new FieldMetaData("data", (byte)3, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/RuleResult, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ACTION;
        public static final _Fields DATA;
        public static final _Fields MESSAGE;
        public static final _Fields RULE;
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
                return RULE;

            case 2: // '\002'
                return ACTION;

            case 3: // '\003'
                return MESSAGE;

            case 4: // '\004'
                return DATA;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/RuleResult$_Fields, s);
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
            RULE = new _Fields("RULE", 0, (short)1, "rule");
            ACTION = new _Fields("ACTION", 1, (short)2, "action");
            MESSAGE = new _Fields("MESSAGE", 2, (short)3, "message");
            DATA = new _Fields("DATA", 3, (short)4, "data");
            $VALUES = (new _Fields[] {
                RULE, ACTION, MESSAGE, DATA
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/RuleResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields[_Fields.RULE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields[_Fields.ACTION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields[_Fields.MESSAGE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$RuleResult$_Fields[_Fields.DATA.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RuleResultStandardSchemeFactory
        implements SchemeFactory
    {

        public RuleResultStandardScheme getScheme()
        {
            return new RuleResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RuleResultStandardSchemeFactory()
        {
        }

        RuleResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RuleResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RuleResult ruleresult)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_214;
                }
                tfield.id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 103
            //                           3 142
            //                           4 178;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_178;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (tfield.type == 11)
                {
                    ruleresult.rule = tprotocol.readString();
                    ruleresult.setRuleIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L3:
                if (tfield.type == 8)
                {
                    ruleresult.action = LimitAction.findByValue(tprotocol.readI32());
                    ruleresult.setActionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L4:
                if (tfield.type == 11)
                {
                    ruleresult.message = tprotocol.readString();
                    ruleresult.setMessageIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                if (tfield.type == 11)
                {
                    ruleresult.data = tprotocol.readString();
                    ruleresult.setDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                ruleresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RuleResult)tbase);
            }

            public void write(TProtocol tprotocol, RuleResult ruleresult)
            {
                ruleresult.validate();
                tprotocol.writeStructBegin(RuleResult.STRUCT_DESC);
                if (ruleresult.rule != null)
                {
                    tprotocol.writeFieldBegin(RuleResult.RULE_FIELD_DESC);
                    tprotocol.writeString(ruleresult.rule);
                    tprotocol.writeFieldEnd();
                }
                if (ruleresult.action != null)
                {
                    tprotocol.writeFieldBegin(RuleResult.ACTION_FIELD_DESC);
                    tprotocol.writeI32(ruleresult.action.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (ruleresult.message != null)
                {
                    tprotocol.writeFieldBegin(RuleResult.MESSAGE_FIELD_DESC);
                    tprotocol.writeString(ruleresult.message);
                    tprotocol.writeFieldEnd();
                }
                if (ruleresult.data != null)
                {
                    tprotocol.writeFieldBegin(RuleResult.DATA_FIELD_DESC);
                    tprotocol.writeString(ruleresult.data);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RuleResult)tbase);
            }

            private RuleResultStandardScheme()
            {
            }

            RuleResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RuleResultTupleSchemeFactory
        implements SchemeFactory
    {

        public RuleResultTupleScheme getScheme()
        {
            return new RuleResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RuleResultTupleSchemeFactory()
        {
        }

        RuleResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RuleResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RuleResult ruleresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    ruleresult.rule = tprotocol.readString();
                    ruleresult.setRuleIsSet(true);
                }
                if (bitset.get(1))
                {
                    ruleresult.action = LimitAction.findByValue(tprotocol.readI32());
                    ruleresult.setActionIsSet(true);
                }
                if (bitset.get(2))
                {
                    ruleresult.message = tprotocol.readString();
                    ruleresult.setMessageIsSet(true);
                }
                if (bitset.get(3))
                {
                    ruleresult.data = tprotocol.readString();
                    ruleresult.setDataIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RuleResult)tbase);
            }

            public void write(TProtocol tprotocol, RuleResult ruleresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (ruleresult.isSetRule())
                {
                    bitset.set(0);
                }
                if (ruleresult.isSetAction())
                {
                    bitset.set(1);
                }
                if (ruleresult.isSetMessage())
                {
                    bitset.set(2);
                }
                if (ruleresult.isSetData())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (ruleresult.isSetRule())
                {
                    tprotocol.writeString(ruleresult.rule);
                }
                if (ruleresult.isSetAction())
                {
                    tprotocol.writeI32(ruleresult.action.getValue());
                }
                if (ruleresult.isSetMessage())
                {
                    tprotocol.writeString(ruleresult.message);
                }
                if (ruleresult.isSetData())
                {
                    tprotocol.writeString(ruleresult.data);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RuleResult)tbase);
            }

            private RuleResultTupleScheme()
            {
            }

            RuleResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
