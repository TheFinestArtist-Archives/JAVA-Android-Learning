// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.transport.TIOStreamTransport;

// Referenced classes of package com.pinterest.schemas.event:
//            PinInsertion, PinViewType

public class PinInsertionEvent
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField INSERTIONS_FIELD_DESC = new TField("insertions", (byte)15, (short)3);
    private static final TField REQUEST_ID_FIELD_DESC = new TField("requestId", (byte)11, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("PinInsertionEvent");
    private static final TField TERM_FIELD_DESC = new TField("term", (byte)11, (short)6);
    private static final TField TIMESTAMP_FIELD_DESC = new TField("timestamp", (byte)10, (short)1);
    private static final TField USER_ID_FIELD_DESC = new TField("userId", (byte)10, (short)4);
    private static final TField VIEW_TYPE_FIELD_DESC = new TField("viewType", (byte)8, (short)5);
    private static final int __TIMESTAMP_ISSET_ID = 0;
    private static final int __USERID_ISSET_ID = 1;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public List insertions;
    public ByteBuffer requestId;
    public String term;
    public long timestamp;
    public long userId;
    public PinViewType viewType;

    public PinInsertionEvent()
    {
        __isset_bitfield = 0;
    }

    public PinInsertionEvent(long l, ByteBuffer bytebuffer, List list)
    {
        this();
        timestamp = l;
        setTimestampIsSet(true);
        requestId = TBaseHelper.copyBinary(bytebuffer);
        insertions = list;
    }

    public PinInsertionEvent(PinInsertionEvent pininsertionevent)
    {
        __isset_bitfield = 0;
        __isset_bitfield = pininsertionevent.__isset_bitfield;
        timestamp = pininsertionevent.timestamp;
        if (pininsertionevent.isSetRequestId())
        {
            requestId = TBaseHelper.copyBinary(pininsertionevent.requestId);
        }
        if (pininsertionevent.isSetInsertions())
        {
            ArrayList arraylist = new ArrayList(pininsertionevent.insertions.size());
            for (Iterator iterator = pininsertionevent.insertions.iterator(); iterator.hasNext(); arraylist.add(new PinInsertion((PinInsertion)iterator.next()))) { }
            insertions = arraylist;
        }
        userId = pininsertionevent.userId;
        if (pininsertionevent.isSetViewType())
        {
            viewType = pininsertionevent.viewType;
        }
        if (pininsertionevent.isSetTerm())
        {
            term = pininsertionevent.term;
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

    public void addToInsertions(PinInsertion pininsertion)
    {
        if (insertions == null)
        {
            insertions = new ArrayList();
        }
        insertions.add(pininsertion);
    }

    public ByteBuffer bufferForRequestId()
    {
        return TBaseHelper.copyBinary(requestId);
    }

    public void clear()
    {
        setTimestampIsSet(false);
        timestamp = 0L;
        requestId = null;
        insertions = null;
        setUserIdIsSet(false);
        userId = 0L;
        viewType = null;
        term = null;
    }

    public int compareTo(PinInsertionEvent pininsertionevent)
    {
        if (getClass().equals(pininsertionevent.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(pininsertionevent.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTimestamp()).compareTo(Boolean.valueOf(pininsertionevent.isSetTimestamp()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTimestamp())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(timestamp, pininsertionevent.timestamp);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetRequestId()).compareTo(Boolean.valueOf(pininsertionevent.isSetRequestId()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetRequestId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestId, pininsertionevent.requestId);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetInsertions()).compareTo(Boolean.valueOf(pininsertionevent.isSetInsertions()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetInsertions())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(insertions, pininsertionevent.insertions);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetUserId()).compareTo(Boolean.valueOf(pininsertionevent.isSetUserId()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetUserId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(userId, pininsertionevent.userId);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetViewType()).compareTo(Boolean.valueOf(pininsertionevent.isSetViewType()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetViewType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(viewType, pininsertionevent.viewType);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetTerm()).compareTo(Boolean.valueOf(pininsertionevent.isSetTerm()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetTerm())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(term, pininsertionevent.term);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PinInsertionEvent)obj);
    }

    public PinInsertionEvent deepCopy()
    {
        return new PinInsertionEvent(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PinInsertionEvent pininsertionevent)
    {
        if (pininsertionevent != null && timestamp == pininsertionevent.timestamp)
        {
            boolean flag = isSetRequestId();
            boolean flag5 = pininsertionevent.isSetRequestId();
            if (!flag && !flag5 || flag && flag5 && requestId.equals(pininsertionevent.requestId))
            {
                boolean flag1 = isSetInsertions();
                boolean flag6 = pininsertionevent.isSetInsertions();
                if (!flag1 && !flag6 || flag1 && flag6 && insertions.equals(pininsertionevent.insertions))
                {
                    boolean flag2 = isSetUserId();
                    boolean flag7 = pininsertionevent.isSetUserId();
                    if (!flag2 && !flag7 || flag2 && flag7 && userId == pininsertionevent.userId)
                    {
                        boolean flag3 = isSetViewType();
                        boolean flag8 = pininsertionevent.isSetViewType();
                        if (!flag3 && !flag8 || flag3 && flag8 && viewType.equals(pininsertionevent.viewType))
                        {
                            boolean flag4 = isSetTerm();
                            boolean flag9 = pininsertionevent.isSetTerm();
                            if (!flag4 && !flag9 || flag4 && flag9 && term.equals(pininsertionevent.term))
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
        while (obj == null || !(obj instanceof PinInsertionEvent)) 
        {
            return false;
        }
        return equals((PinInsertionEvent)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertionEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getTimestamp());

        case 2: // '\002'
            return getRequestId();

        case 3: // '\003'
            return getInsertions();

        case 4: // '\004'
            return Long.valueOf(getUserId());

        case 5: // '\005'
            return getViewType();

        case 6: // '\006'
            return getTerm();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getInsertions()
    {
        return insertions;
    }

    public Iterator getInsertionsIterator()
    {
        if (insertions == null)
        {
            return null;
        } else
        {
            return insertions.iterator();
        }
    }

    public int getInsertionsSize()
    {
        if (insertions == null)
        {
            return 0;
        } else
        {
            return insertions.size();
        }
    }

    public byte[] getRequestId()
    {
        setRequestId(TBaseHelper.rightSize(requestId));
        if (requestId == null)
        {
            return null;
        } else
        {
            return requestId.array();
        }
    }

    public String getTerm()
    {
        return term;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public long getUserId()
    {
        return userId;
    }

    public PinViewType getViewType()
    {
        return viewType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(timestamp));
        boolean flag = isSetRequestId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestId);
        }
        flag = isSetInsertions();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(insertions);
        }
        flag = isSetUserId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Long.valueOf(userId));
        }
        flag = isSetViewType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(viewType.getValue()));
        }
        flag = isSetTerm();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(term);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertionEvent._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTimestamp();

        case 2: // '\002'
            return isSetRequestId();

        case 3: // '\003'
            return isSetInsertions();

        case 4: // '\004'
            return isSetUserId();

        case 5: // '\005'
            return isSetViewType();

        case 6: // '\006'
            return isSetTerm();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetInsertions()
    {
        return insertions != null;
    }

    public boolean isSetRequestId()
    {
        return requestId != null;
    }

    public boolean isSetTerm()
    {
        return term != null;
    }

    public boolean isSetTimestamp()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetUserId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetViewType()
    {
        return viewType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinInsertionEvent._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTimestamp();
                return;
            } else
            {
                setTimestamp(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetRequestId();
                return;
            } else
            {
                setRequestId((ByteBuffer)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetInsertions();
                return;
            } else
            {
                setInsertions((List)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetUserId();
                return;
            } else
            {
                setUserId(((Long)obj).longValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetViewType();
                return;
            } else
            {
                setViewType((PinViewType)obj);
                return;
            }

        case 6: // '\006'
            break;
        }
        if (obj == null)
        {
            unsetTerm();
            return;
        } else
        {
            setTerm((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PinInsertionEvent setInsertions(List list)
    {
        insertions = list;
        return this;
    }

    public void setInsertionsIsSet(boolean flag)
    {
        if (!flag)
        {
            insertions = null;
        }
    }

    public PinInsertionEvent setRequestId(ByteBuffer bytebuffer)
    {
        requestId = TBaseHelper.copyBinary(bytebuffer);
        return this;
    }

    public PinInsertionEvent setRequestId(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = null;
        } else
        {
            abyte0 = ByteBuffer.wrap(Arrays.copyOf(abyte0, abyte0.length));
        }
        requestId = abyte0;
        return this;
    }

    public void setRequestIdIsSet(boolean flag)
    {
        if (!flag)
        {
            requestId = null;
        }
    }

    public PinInsertionEvent setTerm(String s)
    {
        term = s;
        return this;
    }

    public void setTermIsSet(boolean flag)
    {
        if (!flag)
        {
            term = null;
        }
    }

    public PinInsertionEvent setTimestamp(long l)
    {
        timestamp = l;
        setTimestampIsSet(true);
        return this;
    }

    public void setTimestampIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PinInsertionEvent setUserId(long l)
    {
        userId = l;
        setUserIdIsSet(true);
        return this;
    }

    public void setUserIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public PinInsertionEvent setViewType(PinViewType pinviewtype)
    {
        viewType = pinviewtype;
        return this;
    }

    public void setViewTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            viewType = null;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PinInsertionEvent(");
        stringbuilder.append("timestamp:");
        stringbuilder.append(timestamp);
        stringbuilder.append(", ");
        stringbuilder.append("requestId:");
        if (requestId == null)
        {
            stringbuilder.append("null");
        } else
        {
            TBaseHelper.toString(requestId, stringbuilder);
        }
        stringbuilder.append(", ");
        stringbuilder.append("insertions:");
        if (insertions == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(insertions);
        }
        if (isSetUserId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userId:");
            stringbuilder.append(userId);
        }
        if (isSetViewType())
        {
            stringbuilder.append(", ");
            stringbuilder.append("viewType:");
            if (viewType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(viewType);
            }
        }
        if (isSetTerm())
        {
            stringbuilder.append(", ");
            stringbuilder.append("term:");
            if (term == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(term);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetInsertions()
    {
        insertions = null;
    }

    public void unsetRequestId()
    {
        requestId = null;
    }

    public void unsetTerm()
    {
        term = null;
    }

    public void unsetTimestamp()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetUserId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetViewType()
    {
        viewType = null;
    }

    public void validate()
    {
        if (requestId == null)
        {
            throw new TProtocolException((new StringBuilder("Required field 'requestId' was not present! Struct: ")).append(toString()).toString());
        }
        if (insertions == null)
        {
            throw new TProtocolException((new StringBuilder("Required field 'insertions' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PinInsertionEventStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PinInsertionEventTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.USER_ID, _Fields.VIEW_TYPE, _Fields.TERM
        });
        obj = new EnumMap(com/pinterest/schemas/event/PinInsertionEvent$_Fields);
        ((Map) (obj)).put(_Fields.TIMESTAMP, new FieldMetaData("timestamp", (byte)1, new FieldValueMetaData((byte)10)));
        ((Map) (obj)).put(_Fields.REQUEST_ID, new FieldMetaData("requestId", (byte)1, new FieldValueMetaData((byte)11, true)));
        ((Map) (obj)).put(_Fields.INSERTIONS, new FieldMetaData("insertions", (byte)1, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/PinInsertion))));
        ((Map) (obj)).put(_Fields.USER_ID, new FieldMetaData("userId", (byte)2, new FieldValueMetaData((byte)10)));
        ((Map) (obj)).put(_Fields.VIEW_TYPE, new FieldMetaData("viewType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/PinViewType)));
        ((Map) (obj)).put(_Fields.TERM, new FieldMetaData("term", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PinInsertionEvent, metaDataMap);
    }








    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields INSERTIONS;
        public static final _Fields REQUEST_ID;
        public static final _Fields TERM;
        public static final _Fields TIMESTAMP;
        public static final _Fields USER_ID;
        public static final _Fields VIEW_TYPE;
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
                return TIMESTAMP;

            case 2: // '\002'
                return REQUEST_ID;

            case 3: // '\003'
                return INSERTIONS;

            case 4: // '\004'
                return USER_ID;

            case 5: // '\005'
                return VIEW_TYPE;

            case 6: // '\006'
                return TERM;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PinInsertionEvent$_Fields, s);
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
            TIMESTAMP = new _Fields("TIMESTAMP", 0, (short)1, "timestamp");
            REQUEST_ID = new _Fields("REQUEST_ID", 1, (short)2, "requestId");
            INSERTIONS = new _Fields("INSERTIONS", 2, (short)3, "insertions");
            USER_ID = new _Fields("USER_ID", 3, (short)4, "userId");
            VIEW_TYPE = new _Fields("VIEW_TYPE", 4, (short)5, "viewType");
            TERM = new _Fields("TERM", 5, (short)6, "term");
            $VALUES = (new _Fields[] {
                TIMESTAMP, REQUEST_ID, INSERTIONS, USER_ID, VIEW_TYPE, TERM
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinInsertionEvent$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.TIMESTAMP.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.REQUEST_ID.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.INSERTIONS.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.USER_ID.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.VIEW_TYPE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinInsertionEvent$_Fields[_Fields.TERM.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PinInsertionEventStandardSchemeFactory
        implements SchemeFactory
    {

        public PinInsertionEventStandardScheme getScheme()
        {
            return new PinInsertionEventStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinInsertionEventStandardSchemeFactory()
        {
        }

        PinInsertionEventStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinInsertionEventStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
            {
                tprotocol.readStructBegin();
_L9:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_358;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 6: default 60
            //                           1 75
            //                           2 111
            //                           3 147
            //                           4 247
            //                           5 283
            //                           6 322;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
                break MISSING_BLOCK_LABEL_322;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
                tprotocol.readFieldEnd();
                if (true) goto _L9; else goto _L8
_L8:
                if (((TField) (obj)).type == 10)
                {
                    pininsertionevent.timestamp = tprotocol.readI64();
                    pininsertionevent.setTimestampIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L3:
                if (((TField) (obj)).type == 11)
                {
                    pininsertionevent.requestId = tprotocol.readBinary();
                    pininsertionevent.setRequestIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L4:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    pininsertionevent.insertions = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        PinInsertion pininsertion = new PinInsertion();
                        pininsertion.read(tprotocol);
                        pininsertionevent.insertions.add(pininsertion);
                    }

                    tprotocol.readListEnd();
                    pininsertionevent.setInsertionsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L5:
                if (((TField) (obj)).type == 10)
                {
                    pininsertionevent.userId = tprotocol.readI64();
                    pininsertionevent.setUserIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
_L6:
                if (((TField) (obj)).type == 8)
                {
                    pininsertionevent.viewType = PinViewType.findByValue(tprotocol.readI32());
                    pininsertionevent.setViewTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
                if (((TField) (obj)).type == 11)
                {
                    pininsertionevent.term = tprotocol.readString();
                    pininsertionevent.setTermIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L10
                tprotocol.readStructEnd();
                if (!pininsertionevent.isSetTimestamp())
                {
                    throw new TProtocolException((new StringBuilder("Required field 'timestamp' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    pininsertionevent.validate();
                    return;
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinInsertionEvent)tbase);
            }

            public void write(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
            {
                pininsertionevent.validate();
                tprotocol.writeStructBegin(PinInsertionEvent.STRUCT_DESC);
                tprotocol.writeFieldBegin(PinInsertionEvent.TIMESTAMP_FIELD_DESC);
                tprotocol.writeI64(pininsertionevent.timestamp);
                tprotocol.writeFieldEnd();
                if (pininsertionevent.requestId != null)
                {
                    tprotocol.writeFieldBegin(PinInsertionEvent.REQUEST_ID_FIELD_DESC);
                    tprotocol.writeBinary(pininsertionevent.requestId);
                    tprotocol.writeFieldEnd();
                }
                if (pininsertionevent.insertions != null)
                {
                    tprotocol.writeFieldBegin(PinInsertionEvent.INSERTIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, pininsertionevent.insertions.size()));
                    for (Iterator iterator = pininsertionevent.insertions.iterator(); iterator.hasNext(); ((PinInsertion)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (pininsertionevent.isSetUserId())
                {
                    tprotocol.writeFieldBegin(PinInsertionEvent.USER_ID_FIELD_DESC);
                    tprotocol.writeI64(pininsertionevent.userId);
                    tprotocol.writeFieldEnd();
                }
                if (pininsertionevent.viewType != null && pininsertionevent.isSetViewType())
                {
                    tprotocol.writeFieldBegin(PinInsertionEvent.VIEW_TYPE_FIELD_DESC);
                    tprotocol.writeI32(pininsertionevent.viewType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (pininsertionevent.term != null && pininsertionevent.isSetTerm())
                {
                    tprotocol.writeFieldBegin(PinInsertionEvent.TERM_FIELD_DESC);
                    tprotocol.writeString(pininsertionevent.term);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinInsertionEvent)tbase);
            }

            private PinInsertionEventStandardScheme()
            {
            }

            PinInsertionEventStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PinInsertionEventTupleSchemeFactory
        implements SchemeFactory
    {

        public PinInsertionEventTupleScheme getScheme()
        {
            return new PinInsertionEventTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinInsertionEventTupleSchemeFactory()
        {
        }

        PinInsertionEventTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinInsertionEventTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                pininsertionevent.timestamp = tprotocol.readI64();
                pininsertionevent.setTimestampIsSet(true);
                pininsertionevent.requestId = tprotocol.readBinary();
                pininsertionevent.setRequestIdIsSet(true);
                Object obj = new TList((byte)12, tprotocol.readI32());
                pininsertionevent.insertions = new ArrayList(((TList) (obj)).size);
                for (int i = 0; i < ((TList) (obj)).size; i++)
                {
                    PinInsertion pininsertion = new PinInsertion();
                    pininsertion.read(tprotocol);
                    pininsertionevent.insertions.add(pininsertion);
                }

                pininsertionevent.setInsertionsIsSet(true);
                obj = tprotocol.readBitSet(3);
                if (((BitSet) (obj)).get(0))
                {
                    pininsertionevent.userId = tprotocol.readI64();
                    pininsertionevent.setUserIdIsSet(true);
                }
                if (((BitSet) (obj)).get(1))
                {
                    pininsertionevent.viewType = PinViewType.findByValue(tprotocol.readI32());
                    pininsertionevent.setViewTypeIsSet(true);
                }
                if (((BitSet) (obj)).get(2))
                {
                    pininsertionevent.term = tprotocol.readString();
                    pininsertionevent.setTermIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinInsertionEvent)tbase);
            }

            public void write(TProtocol tprotocol, PinInsertionEvent pininsertionevent)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                tprotocol.writeI64(pininsertionevent.timestamp);
                tprotocol.writeBinary(pininsertionevent.requestId);
                tprotocol.writeI32(pininsertionevent.insertions.size());
                for (Iterator iterator = pininsertionevent.insertions.iterator(); iterator.hasNext(); ((PinInsertion)iterator.next()).write(tprotocol)) { }
                BitSet bitset = new BitSet();
                if (pininsertionevent.isSetUserId())
                {
                    bitset.set(0);
                }
                if (pininsertionevent.isSetViewType())
                {
                    bitset.set(1);
                }
                if (pininsertionevent.isSetTerm())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (pininsertionevent.isSetUserId())
                {
                    tprotocol.writeI64(pininsertionevent.userId);
                }
                if (pininsertionevent.isSetViewType())
                {
                    tprotocol.writeI32(pininsertionevent.viewType.getValue());
                }
                if (pininsertionevent.isSetTerm())
                {
                    tprotocol.writeString(pininsertionevent.term);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinInsertionEvent)tbase);
            }

            private PinInsertionEventTupleScheme()
            {
            }

            PinInsertionEventTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
