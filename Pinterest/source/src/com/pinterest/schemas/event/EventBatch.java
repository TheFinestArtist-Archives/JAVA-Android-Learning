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
//            Event

public class EventBatch
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField EVENTS_FIELD_DESC = new TField("events", (byte)15, (short)1);
    private static final TField REPORT_TIME_FIELD_DESC = new TField("reportTime", (byte)10, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("EventBatch");
    private static final int __REPORTTIME_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final Map schemes;
    private byte __isset_bitfield;
    public List events;
    public long reportTime;

    public EventBatch()
    {
        __isset_bitfield = 0;
    }

    public EventBatch(EventBatch eventbatch)
    {
        __isset_bitfield = 0;
        __isset_bitfield = eventbatch.__isset_bitfield;
        if (eventbatch.isSetEvents())
        {
            ArrayList arraylist = new ArrayList(eventbatch.events.size());
            for (Iterator iterator = eventbatch.events.iterator(); iterator.hasNext(); arraylist.add(new Event((Event)iterator.next()))) { }
            events = arraylist;
        }
        reportTime = eventbatch.reportTime;
    }

    public EventBatch(List list, long l)
    {
        this();
        events = list;
        reportTime = l;
        setReportTimeIsSet(true);
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

    public void addToEvents(Event event)
    {
        if (events == null)
        {
            events = new ArrayList();
        }
        events.add(event);
    }

    public void clear()
    {
        events = null;
        setReportTimeIsSet(false);
        reportTime = 0L;
    }

    public int compareTo(EventBatch eventbatch)
    {
        if (getClass().equals(eventbatch.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(eventbatch.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetEvents()).compareTo(Boolean.valueOf(eventbatch.isSetEvents()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetEvents())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(events, eventbatch.events);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetReportTime()).compareTo(Boolean.valueOf(eventbatch.isSetReportTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetReportTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(reportTime, eventbatch.reportTime);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((EventBatch)obj);
    }

    public EventBatch deepCopy()
    {
        return new EventBatch(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(EventBatch eventbatch)
    {
        if (eventbatch != null)
        {
            boolean flag = isSetEvents();
            boolean flag1 = eventbatch.isSetEvents();
            if ((!flag && !flag1 || flag && flag1 && events.equals(eventbatch.events)) && reportTime == eventbatch.reportTime)
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof EventBatch)) 
        {
            return false;
        }
        return equals((EventBatch)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public List getEvents()
    {
        return events;
    }

    public Iterator getEventsIterator()
    {
        if (events == null)
        {
            return null;
        } else
        {
            return events.iterator();
        }
    }

    public int getEventsSize()
    {
        if (events == null)
        {
            return 0;
        } else
        {
            return events.size();
        }
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventBatch._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getEvents();

        case 2: // '\002'
            return Long.valueOf(getReportTime());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public long getReportTime()
    {
        return reportTime;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetEvents();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(events);
        }
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(reportTime));
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventBatch._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetEvents();

        case 2: // '\002'
            return isSetReportTime();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetEvents()
    {
        return events != null;
    }

    public boolean isSetReportTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public EventBatch setEvents(List list)
    {
        events = list;
        return this;
    }

    public void setEventsIsSet(boolean flag)
    {
        if (!flag)
        {
            events = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.EventBatch._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetEvents();
                return;
            } else
            {
                setEvents((List)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetReportTime();
            return;
        } else
        {
            setReportTime(((Long)obj).longValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public EventBatch setReportTime(long l)
    {
        reportTime = l;
        setReportTimeIsSet(true);
        return this;
    }

    public void setReportTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("EventBatch(");
        stringbuilder.append("events:");
        if (events == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(events);
        }
        stringbuilder.append(", ");
        stringbuilder.append("reportTime:");
        stringbuilder.append(reportTime);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetEvents()
    {
        events = null;
    }

    public void unsetReportTime()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new EventBatchStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new EventBatchTupleSchemeFactory(null));
        obj = new EnumMap(com/pinterest/schemas/event/EventBatch$_Fields);
        ((Map) (obj)).put(_Fields.EVENTS, new FieldMetaData("events", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/Event))));
        ((Map) (obj)).put(_Fields.REPORT_TIME, new FieldMetaData("reportTime", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/EventBatch, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields EVENTS;
        public static final _Fields REPORT_TIME;
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
                return EVENTS;

            case 2: // '\002'
                return REPORT_TIME;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/EventBatch$_Fields, s);
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
            EVENTS = new _Fields("EVENTS", 0, (short)1, "events");
            REPORT_TIME = new _Fields("REPORT_TIME", 1, (short)2, "reportTime");
            $VALUES = (new _Fields[] {
                EVENTS, REPORT_TIME
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/EventBatch$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$EventBatch$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$EventBatch$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventBatch$_Fields[_Fields.EVENTS.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$EventBatch$_Fields[_Fields.REPORT_TIME.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class EventBatchStandardSchemeFactory
        implements SchemeFactory
    {

        public EventBatchStandardScheme getScheme()
        {
            return new EventBatchStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventBatchStandardSchemeFactory()
        {
        }

        EventBatchStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventBatchStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, EventBatch eventbatch)
            {
                tprotocol.readStructBegin();
_L2:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_195;
                }
                switch (((TField) (obj)).id)
                {
                default:
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                    break;

                case 1: // '\001'
                    break; /* Loop/switch isn't completed */

                case 2: // '\002'
                    break MISSING_BLOCK_LABEL_159;
                }
_L3:
                tprotocol.readFieldEnd();
                if (true) goto _L2; else goto _L1
_L1:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    eventbatch.events = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        Event event = new Event();
                        event.read(tprotocol);
                        eventbatch.events.add(event);
                    }

                    tprotocol.readListEnd();
                    eventbatch.setEventsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L3
                if (((TField) (obj)).type == 10)
                {
                    eventbatch.reportTime = tprotocol.readI64();
                    eventbatch.setReportTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                eventbatch.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (EventBatch)tbase);
            }

            public void write(TProtocol tprotocol, EventBatch eventbatch)
            {
                eventbatch.validate();
                tprotocol.writeStructBegin(EventBatch.STRUCT_DESC);
                if (eventbatch.events != null)
                {
                    tprotocol.writeFieldBegin(EventBatch.EVENTS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, eventbatch.events.size()));
                    for (Iterator iterator = eventbatch.events.iterator(); iterator.hasNext(); ((Event)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldBegin(EventBatch.REPORT_TIME_FIELD_DESC);
                tprotocol.writeI64(eventbatch.reportTime);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (EventBatch)tbase);
            }

            private EventBatchStandardScheme()
            {
            }

            EventBatchStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class EventBatchTupleSchemeFactory
        implements SchemeFactory
    {

        public EventBatchTupleScheme getScheme()
        {
            return new EventBatchTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private EventBatchTupleSchemeFactory()
        {
        }

        EventBatchTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class EventBatchTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, EventBatch eventbatch)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    eventbatch.events = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        Event event = new Event();
                        event.read(tprotocol);
                        eventbatch.events.add(event);
                    }

                    eventbatch.setEventsIsSet(true);
                }
                if (bitset.get(1))
                {
                    eventbatch.reportTime = tprotocol.readI64();
                    eventbatch.setReportTimeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (EventBatch)tbase);
            }

            public void write(TProtocol tprotocol, EventBatch eventbatch)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (eventbatch.isSetEvents())
                {
                    bitset.set(0);
                }
                if (eventbatch.isSetReportTime())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (eventbatch.isSetEvents())
                {
                    tprotocol.writeI32(eventbatch.events.size());
                    for (Iterator iterator = eventbatch.events.iterator(); iterator.hasNext(); ((Event)iterator.next()).write(tprotocol)) { }
                }
                if (eventbatch.isSetReportTime())
                {
                    tprotocol.writeI64(eventbatch.reportTime);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (EventBatch)tbase);
            }

            private EventBatchTupleScheme()
            {
            }

            EventBatchTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
