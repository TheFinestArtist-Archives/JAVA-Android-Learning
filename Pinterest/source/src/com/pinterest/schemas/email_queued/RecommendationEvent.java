// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.email_queued;

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

// Referenced classes of package com.pinterest.schemas.email_queued:
//            RecommendationTriggerEvent, TypedRecommendationList

public class RecommendationEvent
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField RECOMMENDATIONS_FIELD_DESC = new TField("recommendations", (byte)15, (short)3);
    private static final TField RECOMMENDATION_EVENT_ID_FIELD_DESC = new TField("recommendationEventId", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("RecommendationEvent");
    private static final TField TRIGGER_EVENT_FIELD_DESC = new TField("triggerEvent", (byte)12, (short)2);
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public String recommendationEventId;
    public List recommendations;
    public RecommendationTriggerEvent triggerEvent;

    public RecommendationEvent()
    {
    }

    public RecommendationEvent(RecommendationEvent recommendationevent)
    {
        if (recommendationevent.isSetRecommendationEventId())
        {
            recommendationEventId = recommendationevent.recommendationEventId;
        }
        if (recommendationevent.isSetTriggerEvent())
        {
            triggerEvent = new RecommendationTriggerEvent(recommendationevent.triggerEvent);
        }
        if (recommendationevent.isSetRecommendations())
        {
            ArrayList arraylist = new ArrayList(recommendationevent.recommendations.size());
            for (recommendationevent = recommendationevent.recommendations.iterator(); recommendationevent.hasNext(); arraylist.add(new TypedRecommendationList((TypedRecommendationList)recommendationevent.next()))) { }
            recommendations = arraylist;
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

    public void addToRecommendations(TypedRecommendationList typedrecommendationlist)
    {
        if (recommendations == null)
        {
            recommendations = new ArrayList();
        }
        recommendations.add(typedrecommendationlist);
    }

    public void clear()
    {
        recommendationEventId = null;
        triggerEvent = null;
        recommendations = null;
    }

    public int compareTo(RecommendationEvent recommendationevent)
    {
        if (getClass().equals(recommendationevent.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(recommendationevent.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetRecommendationEventId()).compareTo(Boolean.valueOf(recommendationevent.isSetRecommendationEventId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetRecommendationEventId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendationEventId, recommendationevent.recommendationEventId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetTriggerEvent()).compareTo(Boolean.valueOf(recommendationevent.isSetTriggerEvent()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetTriggerEvent())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(triggerEvent, recommendationevent.triggerEvent);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetRecommendations()).compareTo(Boolean.valueOf(recommendationevent.isSetRecommendations()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetRecommendations())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendations, recommendationevent.recommendations);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RecommendationEvent)obj);
    }

    public RecommendationEvent deepCopy()
    {
        return new RecommendationEvent(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RecommendationEvent recommendationevent)
    {
        if (recommendationevent != null)
        {
            boolean flag = isSetRecommendationEventId();
            boolean flag3 = recommendationevent.isSetRecommendationEventId();
            if (!flag && !flag3 || flag && flag3 && recommendationEventId.equals(recommendationevent.recommendationEventId))
            {
                boolean flag1 = isSetTriggerEvent();
                boolean flag4 = recommendationevent.isSetTriggerEvent();
                if (!flag1 && !flag4 || flag1 && flag4 && triggerEvent.equals(recommendationevent.triggerEvent))
                {
                    boolean flag2 = isSetRecommendations();
                    boolean flag5 = recommendationevent.isSetRecommendations();
                    if (!flag2 && !flag5 || flag2 && flag5 && recommendations.equals(recommendationevent.recommendations))
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
        while (obj == null || !(obj instanceof RecommendationEvent)) 
        {
            return false;
        }
        return equals((RecommendationEvent)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getRecommendationEventId();

        case 2: // '\002'
            return getTriggerEvent();

        case 3: // '\003'
            return getRecommendations();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getRecommendationEventId()
    {
        return recommendationEventId;
    }

    public List getRecommendations()
    {
        return recommendations;
    }

    public Iterator getRecommendationsIterator()
    {
        if (recommendations == null)
        {
            return null;
        } else
        {
            return recommendations.iterator();
        }
    }

    public int getRecommendationsSize()
    {
        if (recommendations == null)
        {
            return 0;
        } else
        {
            return recommendations.size();
        }
    }

    public RecommendationTriggerEvent getTriggerEvent()
    {
        return triggerEvent;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetRecommendationEventId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendationEventId);
        }
        flag = isSetTriggerEvent();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(triggerEvent);
        }
        flag = isSetRecommendations();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendations);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetRecommendationEventId();

        case 2: // '\002'
            return isSetTriggerEvent();

        case 3: // '\003'
            return isSetRecommendations();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetRecommendationEventId()
    {
        return recommendationEventId != null;
    }

    public boolean isSetRecommendations()
    {
        return recommendations != null;
    }

    public boolean isSetTriggerEvent()
    {
        return triggerEvent != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationEvent._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetRecommendationEventId();
                return;
            } else
            {
                setRecommendationEventId((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetTriggerEvent();
                return;
            } else
            {
                setTriggerEvent((RecommendationTriggerEvent)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetRecommendations();
            return;
        } else
        {
            setRecommendations((List)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RecommendationEvent setRecommendationEventId(String s)
    {
        recommendationEventId = s;
        return this;
    }

    public void setRecommendationEventIdIsSet(boolean flag)
    {
        if (!flag)
        {
            recommendationEventId = null;
        }
    }

    public RecommendationEvent setRecommendations(List list)
    {
        recommendations = list;
        return this;
    }

    public void setRecommendationsIsSet(boolean flag)
    {
        if (!flag)
        {
            recommendations = null;
        }
    }

    public RecommendationEvent setTriggerEvent(RecommendationTriggerEvent recommendationtriggerevent)
    {
        triggerEvent = recommendationtriggerevent;
        return this;
    }

    public void setTriggerEventIsSet(boolean flag)
    {
        if (!flag)
        {
            triggerEvent = null;
        }
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("RecommendationEvent(");
        boolean flag = true;
        if (isSetRecommendationEventId())
        {
            stringbuilder.append("recommendationEventId:");
            if (recommendationEventId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(recommendationEventId);
            }
            flag = false;
        }
        if (isSetTriggerEvent())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("triggerEvent:");
            if (triggerEvent == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(triggerEvent);
                flag = flag1;
            }
        }
        if (isSetRecommendations())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("recommendations:");
            if (recommendations == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(recommendations);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetRecommendationEventId()
    {
        recommendationEventId = null;
    }

    public void unsetRecommendations()
    {
        recommendations = null;
    }

    public void unsetTriggerEvent()
    {
        triggerEvent = null;
    }

    public void validate()
    {
        if (triggerEvent != null)
        {
            triggerEvent.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RecommendationEventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RecommendationEventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.RECOMMENDATION_EVENT_ID, _Fields.TRIGGER_EVENT, _Fields.RECOMMENDATIONS
        });
        obj = new EnumMap(com/pinterest/schemas/email_queued/RecommendationEvent$_Fields);
        ((Map) (obj)).put(_Fields.RECOMMENDATION_EVENT_ID, new FieldMetaData("recommendationEventId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TRIGGER_EVENT, new FieldMetaData("triggerEvent", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/RecommendationTriggerEvent)));
        ((Map) (obj)).put(_Fields.RECOMMENDATIONS, new FieldMetaData("recommendations", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/TypedRecommendationList))));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/RecommendationEvent, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields RECOMMENDATIONS;
        public static final _Fields RECOMMENDATION_EVENT_ID;
        public static final _Fields TRIGGER_EVENT;
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
                return RECOMMENDATION_EVENT_ID;

            case 2: // '\002'
                return TRIGGER_EVENT;

            case 3: // '\003'
                return RECOMMENDATIONS;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationEvent$_Fields, s);
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
            RECOMMENDATION_EVENT_ID = new _Fields("RECOMMENDATION_EVENT_ID", 0, (short)1, "recommendationEventId");
            TRIGGER_EVENT = new _Fields("TRIGGER_EVENT", 1, (short)2, "triggerEvent");
            RECOMMENDATIONS = new _Fields("RECOMMENDATIONS", 2, (short)3, "recommendations");
            $VALUES = (new _Fields[] {
                RECOMMENDATION_EVENT_ID, TRIGGER_EVENT, RECOMMENDATIONS
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$RecommendationEvent$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$RecommendationEvent$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationEvent$_Fields[_Fields.RECOMMENDATION_EVENT_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationEvent$_Fields[_Fields.TRIGGER_EVENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationEvent$_Fields[_Fields.RECOMMENDATIONS.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RecommendationEventStandardSchemeFactory
        implements SchemeFactory
    {

        public RecommendationEventStandardScheme getScheme()
        {
            return new RecommendationEventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationEventStandardSchemeFactory()
        {
        }

        RecommendationEventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationEventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RecommendationEvent recommendationevent)
            {
                tprotocol.readStructBegin();
_L6:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_246;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 99
            //                           3 146;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_146;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (((TField) (obj)).type == 11)
                {
                    recommendationevent.recommendationEventId = tprotocol.readString();
                    recommendationevent.setRecommendationEventIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
_L3:
                if (((TField) (obj)).type == 12)
                {
                    recommendationevent.triggerEvent = new RecommendationTriggerEvent();
                    recommendationevent.triggerEvent.read(tprotocol);
                    recommendationevent.setTriggerEventIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    recommendationevent.recommendations = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        TypedRecommendationList typedrecommendationlist = new TypedRecommendationList();
                        typedrecommendationlist.read(tprotocol);
                        recommendationevent.recommendations.add(typedrecommendationlist);
                    }

                    tprotocol.readListEnd();
                    recommendationevent.setRecommendationsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                recommendationevent.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationEvent)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationEvent recommendationevent)
            {
                recommendationevent.validate();
                tprotocol.writeStructBegin(RecommendationEvent.STRUCT_DESC);
                if (recommendationevent.recommendationEventId != null && recommendationevent.isSetRecommendationEventId())
                {
                    tprotocol.writeFieldBegin(RecommendationEvent.RECOMMENDATION_EVENT_ID_FIELD_DESC);
                    tprotocol.writeString(recommendationevent.recommendationEventId);
                    tprotocol.writeFieldEnd();
                }
                if (recommendationevent.triggerEvent != null && recommendationevent.isSetTriggerEvent())
                {
                    tprotocol.writeFieldBegin(RecommendationEvent.TRIGGER_EVENT_FIELD_DESC);
                    recommendationevent.triggerEvent.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (recommendationevent.recommendations != null && recommendationevent.isSetRecommendations())
                {
                    tprotocol.writeFieldBegin(RecommendationEvent.RECOMMENDATIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, recommendationevent.recommendations.size()));
                    for (recommendationevent = recommendationevent.recommendations.iterator(); recommendationevent.hasNext(); ((TypedRecommendationList)recommendationevent.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationEvent)tbase);
            }

            private RecommendationEventStandardScheme()
            {
            }

            RecommendationEventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RecommendationEventTupleSchemeFactory
        implements SchemeFactory
    {

        public RecommendationEventTupleScheme getScheme()
        {
            return new RecommendationEventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationEventTupleSchemeFactory()
        {
        }

        RecommendationEventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationEventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RecommendationEvent recommendationevent)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    recommendationevent.recommendationEventId = tprotocol.readString();
                    recommendationevent.setRecommendationEventIdIsSet(true);
                }
                if (bitset.get(1))
                {
                    recommendationevent.triggerEvent = new RecommendationTriggerEvent();
                    recommendationevent.triggerEvent.read(tprotocol);
                    recommendationevent.setTriggerEventIsSet(true);
                }
                if (bitset.get(2))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    recommendationevent.recommendations = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        TypedRecommendationList typedrecommendationlist = new TypedRecommendationList();
                        typedrecommendationlist.read(tprotocol);
                        recommendationevent.recommendations.add(typedrecommendationlist);
                    }

                    recommendationevent.setRecommendationsIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationEvent)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationEvent recommendationevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (recommendationevent.isSetRecommendationEventId())
                {
                    bitset.set(0);
                }
                if (recommendationevent.isSetTriggerEvent())
                {
                    bitset.set(1);
                }
                if (recommendationevent.isSetRecommendations())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (recommendationevent.isSetRecommendationEventId())
                {
                    tprotocol.writeString(recommendationevent.recommendationEventId);
                }
                if (recommendationevent.isSetTriggerEvent())
                {
                    recommendationevent.triggerEvent.write(tprotocol);
                }
                if (recommendationevent.isSetRecommendations())
                {
                    tprotocol.writeI32(recommendationevent.recommendations.size());
                    for (recommendationevent = recommendationevent.recommendations.iterator(); recommendationevent.hasNext(); ((TypedRecommendationList)recommendationevent.next()).write(tprotocol)) { }
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationEvent)tbase);
            }

            private RecommendationEventTupleScheme()
            {
            }

            RecommendationEventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
