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
import java.util.Set;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.MapMetaData;
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
//            LimitAction, RuleResult, LimitData, SpamServiceResponseCode, 
//            SpamServiceResponseContext

public class LimitResult
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ACTION_FIELD_DESC = new TField("action", (byte)8, (short)1);
    private static final TField AUX_DATA_FIELD_DESC = new TField("aux_data", (byte)13, (short)7);
    private static final TField DATA_FIELD_DESC = new TField("data", (byte)12, (short)4);
    private static final TField MESSAGE_FIELD_DESC = new TField("message", (byte)11, (short)2);
    private static final TField RESPONSE_CODE_FIELD_DESC = new TField("response_code", (byte)8, (short)5);
    private static final TField RESPONSE_CONTEXT_FIELD_DESC = new TField("response_context", (byte)8, (short)6);
    private static final TField RULE_RESULTS_FIELD_DESC = new TField("ruleResults", (byte)15, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("LimitResult");
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public LimitAction action;
    public Map aux_data;
    public LimitData data;
    public String message;
    public SpamServiceResponseCode response_code;
    public SpamServiceResponseContext response_context;
    public List ruleResults;

    public LimitResult()
    {
    }

    public LimitResult(LimitAction limitaction, String s)
    {
        this();
        action = limitaction;
        message = s;
    }

    public LimitResult(LimitResult limitresult)
    {
        if (limitresult.isSetAction())
        {
            action = limitresult.action;
        }
        if (limitresult.isSetMessage())
        {
            message = limitresult.message;
        }
        if (limitresult.isSetRuleResults())
        {
            ArrayList arraylist = new ArrayList(limitresult.ruleResults.size());
            for (Iterator iterator = limitresult.ruleResults.iterator(); iterator.hasNext(); arraylist.add(new RuleResult((RuleResult)iterator.next()))) { }
            ruleResults = arraylist;
        }
        if (limitresult.isSetData())
        {
            data = new LimitData(limitresult.data);
        }
        if (limitresult.isSetResponse_code())
        {
            response_code = limitresult.response_code;
        }
        if (limitresult.isSetResponse_context())
        {
            response_context = limitresult.response_context;
        }
        if (limitresult.isSetAux_data())
        {
            HashMap hashmap = new HashMap(limitresult.aux_data.size());
            java.util.Map.Entry entry;
            for (limitresult = limitresult.aux_data.entrySet().iterator(); limitresult.hasNext(); hashmap.put((LimitAction)entry.getKey(), new ArrayList((List)entry.getValue())))
            {
                entry = (java.util.Map.Entry)limitresult.next();
            }

            aux_data = hashmap;
        }
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

    public void addToRuleResults(RuleResult ruleresult)
    {
        if (ruleResults == null)
        {
            ruleResults = new ArrayList();
        }
        ruleResults.add(ruleresult);
    }

    public void clear()
    {
        action = null;
        message = null;
        ruleResults = null;
        data = null;
        response_code = null;
        response_context = null;
        aux_data = null;
    }

    public int compareTo(LimitResult limitresult)
    {
        if (getClass().equals(limitresult.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(limitresult.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetAction()).compareTo(Boolean.valueOf(limitresult.isSetAction()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetAction())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(action, limitresult.action);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetMessage()).compareTo(Boolean.valueOf(limitresult.isSetMessage()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetMessage())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(message, limitresult.message);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetRuleResults()).compareTo(Boolean.valueOf(limitresult.isSetRuleResults()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetRuleResults())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(ruleResults, limitresult.ruleResults);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetData()).compareTo(Boolean.valueOf(limitresult.isSetData()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetData())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(data, limitresult.data);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetResponse_code()).compareTo(Boolean.valueOf(limitresult.isSetResponse_code()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetResponse_code())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(response_code, limitresult.response_code);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetResponse_context()).compareTo(Boolean.valueOf(limitresult.isSetResponse_context()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetResponse_context())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(response_context, limitresult.response_context);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetAux_data()).compareTo(Boolean.valueOf(limitresult.isSetAux_data()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetAux_data())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(aux_data, limitresult.aux_data);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((LimitResult)obj);
    }

    public LimitResult deepCopy()
    {
        return new LimitResult(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(LimitResult limitresult)
    {
        if (limitresult != null)
        {
            boolean flag = isSetAction();
            boolean flag7 = limitresult.isSetAction();
            if (!flag && !flag7 || flag && flag7 && action.equals(limitresult.action))
            {
                boolean flag1 = isSetMessage();
                boolean flag8 = limitresult.isSetMessage();
                if (!flag1 && !flag8 || flag1 && flag8 && message.equals(limitresult.message))
                {
                    boolean flag2 = isSetRuleResults();
                    boolean flag9 = limitresult.isSetRuleResults();
                    if (!flag2 && !flag9 || flag2 && flag9 && ruleResults.equals(limitresult.ruleResults))
                    {
                        boolean flag3 = isSetData();
                        boolean flag10 = limitresult.isSetData();
                        if (!flag3 && !flag10 || flag3 && flag10 && data.equals(limitresult.data))
                        {
                            boolean flag4 = isSetResponse_code();
                            boolean flag11 = limitresult.isSetResponse_code();
                            if (!flag4 && !flag11 || flag4 && flag11 && response_code.equals(limitresult.response_code))
                            {
                                boolean flag5 = isSetResponse_context();
                                boolean flag12 = limitresult.isSetResponse_context();
                                if (!flag5 && !flag12 || flag5 && flag12 && response_context.equals(limitresult.response_context))
                                {
                                    boolean flag6 = isSetAux_data();
                                    boolean flag13 = limitresult.isSetAux_data();
                                    if (!flag6 && !flag13 || flag6 && flag13 && aux_data.equals(limitresult.aux_data))
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
        while (obj == null || !(obj instanceof LimitResult)) 
        {
            return false;
        }
        return equals((LimitResult)obj);
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

    public Map getAux_data()
    {
        return aux_data;
    }

    public int getAux_dataSize()
    {
        if (aux_data == null)
        {
            return 0;
        } else
        {
            return aux_data.size();
        }
    }

    public LimitData getData()
    {
        return data;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getAction();

        case 2: // '\002'
            return getMessage();

        case 3: // '\003'
            return getRuleResults();

        case 4: // '\004'
            return getData();

        case 5: // '\005'
            return getResponse_code();

        case 6: // '\006'
            return getResponse_context();

        case 7: // '\007'
            return getAux_data();
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

    public SpamServiceResponseCode getResponse_code()
    {
        return response_code;
    }

    public SpamServiceResponseContext getResponse_context()
    {
        return response_context;
    }

    public List getRuleResults()
    {
        return ruleResults;
    }

    public Iterator getRuleResultsIterator()
    {
        if (ruleResults == null)
        {
            return null;
        } else
        {
            return ruleResults.iterator();
        }
    }

    public int getRuleResultsSize()
    {
        if (ruleResults == null)
        {
            return 0;
        } else
        {
            return ruleResults.size();
        }
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetAction();
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
        flag = isSetRuleResults();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(ruleResults);
        }
        flag = isSetData();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(data);
        }
        flag = isSetResponse_code();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(response_code.getValue()));
        }
        flag = isSetResponse_context();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(response_context.getValue()));
        }
        flag = isSetAux_data();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(aux_data);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitResult._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetAction();

        case 2: // '\002'
            return isSetMessage();

        case 3: // '\003'
            return isSetRuleResults();

        case 4: // '\004'
            return isSetData();

        case 5: // '\005'
            return isSetResponse_code();

        case 6: // '\006'
            return isSetResponse_context();

        case 7: // '\007'
            return isSetAux_data();
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

    public boolean isSetAux_data()
    {
        return aux_data != null;
    }

    public boolean isSetData()
    {
        return data != null;
    }

    public boolean isSetMessage()
    {
        return message != null;
    }

    public boolean isSetResponse_code()
    {
        return response_code != null;
    }

    public boolean isSetResponse_context()
    {
        return response_context != null;
    }

    public boolean isSetRuleResults()
    {
        return ruleResults != null;
    }

    public void putToAux_data(LimitAction limitaction, List list)
    {
        if (aux_data == null)
        {
            aux_data = new HashMap();
        }
        aux_data.put(limitaction, list);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public LimitResult setAction(LimitAction limitaction)
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

    public LimitResult setAux_data(Map map)
    {
        aux_data = map;
        return this;
    }

    public void setAux_dataIsSet(boolean flag)
    {
        if (!flag)
        {
            aux_data = null;
        }
    }

    public LimitResult setData(LimitData limitdata)
    {
        data = limitdata;
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.LimitResult._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetAction();
                return;
            } else
            {
                setAction((LimitAction)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetMessage();
                return;
            } else
            {
                setMessage((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetRuleResults();
                return;
            } else
            {
                setRuleResults((List)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetData();
                return;
            } else
            {
                setData((LimitData)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetResponse_code();
                return;
            } else
            {
                setResponse_code((SpamServiceResponseCode)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetResponse_context();
                return;
            } else
            {
                setResponse_context((SpamServiceResponseContext)obj);
                return;
            }

        case 7: // '\007'
            break;
        }
        if (obj == null)
        {
            unsetAux_data();
            return;
        } else
        {
            setAux_data((Map)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public LimitResult setMessage(String s)
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

    public LimitResult setResponse_code(SpamServiceResponseCode spamserviceresponsecode)
    {
        response_code = spamserviceresponsecode;
        return this;
    }

    public void setResponse_codeIsSet(boolean flag)
    {
        if (!flag)
        {
            response_code = null;
        }
    }

    public LimitResult setResponse_context(SpamServiceResponseContext spamserviceresponsecontext)
    {
        response_context = spamserviceresponsecontext;
        return this;
    }

    public void setResponse_contextIsSet(boolean flag)
    {
        if (!flag)
        {
            response_context = null;
        }
    }

    public LimitResult setRuleResults(List list)
    {
        ruleResults = list;
        return this;
    }

    public void setRuleResultsIsSet(boolean flag)
    {
        if (!flag)
        {
            ruleResults = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("LimitResult(");
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
        if (isSetRuleResults())
        {
            stringbuilder.append(", ");
            stringbuilder.append("ruleResults:");
            if (ruleResults == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(ruleResults);
            }
        }
        if (isSetData())
        {
            stringbuilder.append(", ");
            stringbuilder.append("data:");
            if (data == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(data);
            }
        }
        if (isSetResponse_code())
        {
            stringbuilder.append(", ");
            stringbuilder.append("response_code:");
            if (response_code == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(response_code);
            }
        }
        if (isSetResponse_context())
        {
            stringbuilder.append(", ");
            stringbuilder.append("response_context:");
            if (response_context == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(response_context);
            }
        }
        if (isSetAux_data())
        {
            stringbuilder.append(", ");
            stringbuilder.append("aux_data:");
            if (aux_data == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(aux_data);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAction()
    {
        action = null;
    }

    public void unsetAux_data()
    {
        aux_data = null;
    }

    public void unsetData()
    {
        data = null;
    }

    public void unsetMessage()
    {
        message = null;
    }

    public void unsetResponse_code()
    {
        response_code = null;
    }

    public void unsetResponse_context()
    {
        response_context = null;
    }

    public void unsetRuleResults()
    {
        ruleResults = null;
    }

    public void validate()
    {
        if (data != null)
        {
            data.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new LimitResultStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new LimitResultTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.RULE_RESULTS, _Fields.DATA, _Fields.RESPONSE_CODE, _Fields.RESPONSE_CONTEXT, _Fields.AUX_DATA
        });
        obj = new EnumMap(com/pinterest/schemas/event/LimitResult$_Fields);
        ((Map) (obj)).put(_Fields.ACTION, new FieldMetaData("action", (byte)3, new EnumMetaData((byte)16, com/pinterest/schemas/event/LimitAction)));
        ((Map) (obj)).put(_Fields.MESSAGE, new FieldMetaData("message", (byte)3, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.RULE_RESULTS, new FieldMetaData("ruleResults", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/RuleResult))));
        ((Map) (obj)).put(_Fields.DATA, new FieldMetaData("data", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/LimitData)));
        ((Map) (obj)).put(_Fields.RESPONSE_CODE, new FieldMetaData("response_code", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/SpamServiceResponseCode)));
        ((Map) (obj)).put(_Fields.RESPONSE_CONTEXT, new FieldMetaData("response_context", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/SpamServiceResponseContext)));
        ((Map) (obj)).put(_Fields.AUX_DATA, new FieldMetaData("aux_data", (byte)2, new MapMetaData((byte)13, new EnumMetaData((byte)16, com/pinterest/schemas/event/LimitAction), new ListMetaData((byte)15, new FieldValueMetaData((byte)10)))));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/LimitResult, metaDataMap);
    }









    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ACTION;
        public static final _Fields AUX_DATA;
        public static final _Fields DATA;
        public static final _Fields MESSAGE;
        public static final _Fields RESPONSE_CODE;
        public static final _Fields RESPONSE_CONTEXT;
        public static final _Fields RULE_RESULTS;
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
                return ACTION;

            case 2: // '\002'
                return MESSAGE;

            case 3: // '\003'
                return RULE_RESULTS;

            case 4: // '\004'
                return DATA;

            case 5: // '\005'
                return RESPONSE_CODE;

            case 6: // '\006'
                return RESPONSE_CONTEXT;

            case 7: // '\007'
                return AUX_DATA;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/LimitResult$_Fields, s);
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
            ACTION = new _Fields("ACTION", 0, (short)1, "action");
            MESSAGE = new _Fields("MESSAGE", 1, (short)2, "message");
            RULE_RESULTS = new _Fields("RULE_RESULTS", 2, (short)3, "ruleResults");
            DATA = new _Fields("DATA", 3, (short)4, "data");
            RESPONSE_CODE = new _Fields("RESPONSE_CODE", 4, (short)5, "response_code");
            RESPONSE_CONTEXT = new _Fields("RESPONSE_CONTEXT", 5, (short)6, "response_context");
            AUX_DATA = new _Fields("AUX_DATA", 6, (short)7, "aux_data");
            $VALUES = (new _Fields[] {
                ACTION, MESSAGE, RULE_RESULTS, DATA, RESPONSE_CODE, RESPONSE_CONTEXT, AUX_DATA
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/LimitResult$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.ACTION.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.MESSAGE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.RULE_RESULTS.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.DATA.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.RESPONSE_CODE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.RESPONSE_CONTEXT.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$LimitResult$_Fields[_Fields.AUX_DATA.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class LimitResultStandardSchemeFactory
        implements SchemeFactory
    {

        public LimitResultStandardScheme getScheme()
        {
            return new LimitResultStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private LimitResultStandardSchemeFactory()
        {
        }

        LimitResultStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class LimitResultStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, LimitResult limitresult)
            {
                tprotocol.readStructBegin();
_L10:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_538;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 7: default 64
            //                           1 79
            //                           2 118
            //                           3 154
            //                           4 254
            //                           5 301
            //                           6 340
            //                           7 379;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
                break MISSING_BLOCK_LABEL_379;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L11:
                tprotocol.readFieldEnd();
                if (true) goto _L10; else goto _L9
_L9:
                if (((TField) (obj)).type == 8)
                {
                    limitresult.action = LimitAction.findByValue(tprotocol.readI32());
                    limitresult.setActionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L3:
                if (((TField) (obj)).type == 11)
                {
                    limitresult.message = tprotocol.readString();
                    limitresult.setMessageIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L4:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    limitresult.ruleResults = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        RuleResult ruleresult = new RuleResult();
                        ruleresult.read(tprotocol);
                        limitresult.ruleResults.add(ruleresult);
                    }

                    tprotocol.readListEnd();
                    limitresult.setRuleResultsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L5:
                if (((TField) (obj)).type == 12)
                {
                    limitresult.data = new LimitData();
                    limitresult.data.read(tprotocol);
                    limitresult.setDataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L6:
                if (((TField) (obj)).type == 8)
                {
                    limitresult.response_code = SpamServiceResponseCode.findByValue(tprotocol.readI32());
                    limitresult.setResponse_codeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
_L7:
                if (((TField) (obj)).type == 8)
                {
                    limitresult.response_context = SpamServiceResponseContext.findByValue(tprotocol.readI32());
                    limitresult.setResponse_contextIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                if (((TField) (obj)).type == 13)
                {
                    obj = tprotocol.readMapBegin();
                    limitresult.aux_data = new HashMap(((TMap) (obj)).size * 2);
                    for (int j = 0; j < ((TMap) (obj)).size; j++)
                    {
                        LimitAction limitaction = LimitAction.findByValue(tprotocol.readI32());
                        TList tlist = tprotocol.readListBegin();
                        ArrayList arraylist = new ArrayList(tlist.size);
                        for (int k = 0; k < tlist.size; k++)
                        {
                            arraylist.add(Long.valueOf(tprotocol.readI64()));
                        }

                        tprotocol.readListEnd();
                        limitresult.aux_data.put(limitaction, arraylist);
                    }

                    tprotocol.readMapEnd();
                    limitresult.setAux_dataIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L11
                tprotocol.readStructEnd();
                limitresult.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (LimitResult)tbase);
            }

            public void write(TProtocol tprotocol, LimitResult limitresult)
            {
                limitresult.validate();
                tprotocol.writeStructBegin(LimitResult.STRUCT_DESC);
                if (limitresult.action != null)
                {
                    tprotocol.writeFieldBegin(LimitResult.ACTION_FIELD_DESC);
                    tprotocol.writeI32(limitresult.action.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.message != null)
                {
                    tprotocol.writeFieldBegin(LimitResult.MESSAGE_FIELD_DESC);
                    tprotocol.writeString(limitresult.message);
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.ruleResults != null && limitresult.isSetRuleResults())
                {
                    tprotocol.writeFieldBegin(LimitResult.RULE_RESULTS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, limitresult.ruleResults.size()));
                    for (Iterator iterator = limitresult.ruleResults.iterator(); iterator.hasNext(); ((RuleResult)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.data != null && limitresult.isSetData())
                {
                    tprotocol.writeFieldBegin(LimitResult.DATA_FIELD_DESC);
                    limitresult.data.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.response_code != null && limitresult.isSetResponse_code())
                {
                    tprotocol.writeFieldBegin(LimitResult.RESPONSE_CODE_FIELD_DESC);
                    tprotocol.writeI32(limitresult.response_code.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.response_context != null && limitresult.isSetResponse_context())
                {
                    tprotocol.writeFieldBegin(LimitResult.RESPONSE_CONTEXT_FIELD_DESC);
                    tprotocol.writeI32(limitresult.response_context.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (limitresult.aux_data != null && limitresult.isSetAux_data())
                {
                    tprotocol.writeFieldBegin(LimitResult.AUX_DATA_FIELD_DESC);
                    tprotocol.writeMapBegin(new TMap((byte)8, (byte)15, limitresult.aux_data.size()));
                    for (limitresult = limitresult.aux_data.entrySet().iterator(); limitresult.hasNext(); tprotocol.writeListEnd())
                    {
                        Object obj = (java.util.Map.Entry)limitresult.next();
                        tprotocol.writeI32(((LimitAction)((java.util.Map.Entry) (obj)).getKey()).getValue());
                        tprotocol.writeListBegin(new TList((byte)10, ((List)((java.util.Map.Entry) (obj)).getValue()).size()));
                        for (obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator(); ((Iterator) (obj)).hasNext(); tprotocol.writeI64(((Long)((Iterator) (obj)).next()).longValue())) { }
                    }

                    tprotocol.writeMapEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (LimitResult)tbase);
            }

            private LimitResultStandardScheme()
            {
            }

            LimitResultStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class LimitResultTupleSchemeFactory
        implements SchemeFactory
    {

        public LimitResultTupleScheme getScheme()
        {
            return new LimitResultTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private LimitResultTupleSchemeFactory()
        {
        }

        LimitResultTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class LimitResultTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, LimitResult limitresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(7);
                if (bitset.get(0))
                {
                    limitresult.action = LimitAction.findByValue(tprotocol.readI32());
                    limitresult.setActionIsSet(true);
                }
                if (bitset.get(1))
                {
                    limitresult.message = tprotocol.readString();
                    limitresult.setMessageIsSet(true);
                }
                if (bitset.get(2))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    limitresult.ruleResults = new ArrayList(tlist.size);
                    for (int i = 0; i < tlist.size; i++)
                    {
                        RuleResult ruleresult = new RuleResult();
                        ruleresult.read(tprotocol);
                        limitresult.ruleResults.add(ruleresult);
                    }

                    limitresult.setRuleResultsIsSet(true);
                }
                if (bitset.get(3))
                {
                    limitresult.data = new LimitData();
                    limitresult.data.read(tprotocol);
                    limitresult.setDataIsSet(true);
                }
                if (bitset.get(4))
                {
                    limitresult.response_code = SpamServiceResponseCode.findByValue(tprotocol.readI32());
                    limitresult.setResponse_codeIsSet(true);
                }
                if (bitset.get(5))
                {
                    limitresult.response_context = SpamServiceResponseContext.findByValue(tprotocol.readI32());
                    limitresult.setResponse_contextIsSet(true);
                }
                if (bitset.get(6))
                {
                    TMap tmap = new TMap((byte)8, (byte)15, tprotocol.readI32());
                    limitresult.aux_data = new HashMap(tmap.size * 2);
                    for (int j = 0; j < tmap.size; j++)
                    {
                        LimitAction limitaction = LimitAction.findByValue(tprotocol.readI32());
                        TList tlist1 = new TList((byte)10, tprotocol.readI32());
                        ArrayList arraylist = new ArrayList(tlist1.size);
                        for (int k = 0; k < tlist1.size; k++)
                        {
                            arraylist.add(Long.valueOf(tprotocol.readI64()));
                        }

                        limitresult.aux_data.put(limitaction, arraylist);
                    }

                    limitresult.setAux_dataIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (LimitResult)tbase);
            }

            public void write(TProtocol tprotocol, LimitResult limitresult)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (limitresult.isSetAction())
                {
                    bitset.set(0);
                }
                if (limitresult.isSetMessage())
                {
                    bitset.set(1);
                }
                if (limitresult.isSetRuleResults())
                {
                    bitset.set(2);
                }
                if (limitresult.isSetData())
                {
                    bitset.set(3);
                }
                if (limitresult.isSetResponse_code())
                {
                    bitset.set(4);
                }
                if (limitresult.isSetResponse_context())
                {
                    bitset.set(5);
                }
                if (limitresult.isSetAux_data())
                {
                    bitset.set(6);
                }
                tprotocol.writeBitSet(bitset, 7);
                if (limitresult.isSetAction())
                {
                    tprotocol.writeI32(limitresult.action.getValue());
                }
                if (limitresult.isSetMessage())
                {
                    tprotocol.writeString(limitresult.message);
                }
                if (limitresult.isSetRuleResults())
                {
                    tprotocol.writeI32(limitresult.ruleResults.size());
                    for (Iterator iterator = limitresult.ruleResults.iterator(); iterator.hasNext(); ((RuleResult)iterator.next()).write(tprotocol)) { }
                }
                if (limitresult.isSetData())
                {
                    limitresult.data.write(tprotocol);
                }
                if (limitresult.isSetResponse_code())
                {
                    tprotocol.writeI32(limitresult.response_code.getValue());
                }
                if (limitresult.isSetResponse_context())
                {
                    tprotocol.writeI32(limitresult.response_context.getValue());
                }
                if (limitresult.isSetAux_data())
                {
                    tprotocol.writeI32(limitresult.aux_data.size());
                    for (limitresult = limitresult.aux_data.entrySet().iterator(); limitresult.hasNext();)
                    {
                        Object obj = (java.util.Map.Entry)limitresult.next();
                        tprotocol.writeI32(((LimitAction)((java.util.Map.Entry) (obj)).getKey()).getValue());
                        tprotocol.writeI32(((List)((java.util.Map.Entry) (obj)).getValue()).size());
                        obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            tprotocol.writeI64(((Long)((Iterator) (obj)).next()).longValue());
                        }
                    }

                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (LimitResult)tbase);
            }

            private LimitResultTupleScheme()
            {
            }

            LimitResultTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
