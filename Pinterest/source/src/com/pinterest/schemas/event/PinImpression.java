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
//            PinImpressionType

public class PinImpression
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField CACHED_FIELD_DESC = new TField("cached", (byte)2, (short)14);
    private static final TField COLUMN_INDEX_FIELD_DESC = new TField("columnIndex", (byte)6, (short)7);
    private static final TField END_TIME_FIELD_DESC = new TField("endTime", (byte)10, (short)5);
    private static final TField IMAGE_SIGNATURE_FIELD_DESC = new TField("imageSignature", (byte)11, (short)13);
    private static final TField IMAGE_URL_FIELD_DESC = new TField("imageURL", (byte)11, (short)12);
    private static final TField INSERTION_ID_FIELD_DESC = new TField("insertionId", (byte)11, (short)4);
    private static final TField LOOPS_FIELD_DESC = new TField("loops", (byte)4, (short)15);
    private static final TField PIN_ID_FIELD_DESC = new TField("pinId", (byte)10, (short)1);
    private static final TField PIN_ID_STR_FIELD_DESC = new TField("pinIdStr", (byte)11, (short)3);
    private static final TField RENDER_DURATION_FIELD_DESC = new TField("renderDuration", (byte)4, (short)11);
    private static final TField REQUEST_ID_FIELD_DESC = new TField("requestId", (byte)11, (short)9);
    private static final TField SLOT_INDEX_FIELD_DESC = new TField("slotIndex", (byte)6, (short)8);
    private static final TStruct STRUCT_DESC = new TStruct("PinImpression");
    private static final TField TIME_FIELD_DESC = new TField("time", (byte)10, (short)2);
    private static final TField TYPE_FIELD_DESC = new TField("type", (byte)8, (short)10);
    private static final TField Y_POSITION_FIELD_DESC = new TField("yPosition", (byte)8, (short)6);
    private static final int __CACHED_ISSET_ID = 7;
    private static final int __COLUMNINDEX_ISSET_ID = 4;
    private static final int __ENDTIME_ISSET_ID = 2;
    private static final int __LOOPS_ISSET_ID = 8;
    private static final int __PINID_ISSET_ID = 0;
    private static final int __RENDERDURATION_ISSET_ID = 6;
    private static final int __SLOTINDEX_ISSET_ID = 5;
    private static final int __TIME_ISSET_ID = 1;
    private static final int __YPOSITION_ISSET_ID = 3;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private short __isset_bitfield;
    public boolean cached;
    public short columnIndex;
    public long endTime;
    public String imageSignature;
    public String imageURL;
    public String insertionId;
    public double loops;
    public long pinId;
    public String pinIdStr;
    public double renderDuration;
    public String requestId;
    public short slotIndex;
    public long time;
    public PinImpressionType type;
    public int yPosition;

    public PinImpression()
    {
        __isset_bitfield = 0;
    }

    public PinImpression(long l, long l1)
    {
        this();
        pinId = l;
        setPinIdIsSet(true);
        time = l1;
        setTimeIsSet(true);
    }

    public PinImpression(PinImpression pinimpression)
    {
        __isset_bitfield = 0;
        __isset_bitfield = pinimpression.__isset_bitfield;
        pinId = pinimpression.pinId;
        time = pinimpression.time;
        if (pinimpression.isSetPinIdStr())
        {
            pinIdStr = pinimpression.pinIdStr;
        }
        if (pinimpression.isSetInsertionId())
        {
            insertionId = pinimpression.insertionId;
        }
        endTime = pinimpression.endTime;
        yPosition = pinimpression.yPosition;
        columnIndex = pinimpression.columnIndex;
        slotIndex = pinimpression.slotIndex;
        if (pinimpression.isSetRequestId())
        {
            requestId = pinimpression.requestId;
        }
        if (pinimpression.isSetType())
        {
            type = pinimpression.type;
        }
        renderDuration = pinimpression.renderDuration;
        if (pinimpression.isSetImageURL())
        {
            imageURL = pinimpression.imageURL;
        }
        if (pinimpression.isSetImageSignature())
        {
            imageSignature = pinimpression.imageSignature;
        }
        cached = pinimpression.cached;
        loops = pinimpression.loops;
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
        setPinIdIsSet(false);
        pinId = 0L;
        setTimeIsSet(false);
        time = 0L;
        pinIdStr = null;
        insertionId = null;
        setEndTimeIsSet(false);
        endTime = 0L;
        setYPositionIsSet(false);
        yPosition = 0;
        setColumnIndexIsSet(false);
        columnIndex = 0;
        setSlotIndexIsSet(false);
        slotIndex = 0;
        requestId = null;
        type = null;
        setRenderDurationIsSet(false);
        renderDuration = 0.0D;
        imageURL = null;
        imageSignature = null;
        setCachedIsSet(false);
        cached = false;
        setLoopsIsSet(false);
        loops = 0.0D;
    }

    public int compareTo(PinImpression pinimpression)
    {
        if (getClass().equals(pinimpression.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(pinimpression.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetPinId()).compareTo(Boolean.valueOf(pinimpression.isSetPinId()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetPinId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pinId, pinimpression.pinId);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetTime()).compareTo(Boolean.valueOf(pinimpression.isSetTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(time, pinimpression.time);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetPinIdStr()).compareTo(Boolean.valueOf(pinimpression.isSetPinIdStr()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetPinIdStr())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(pinIdStr, pinimpression.pinIdStr);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetInsertionId()).compareTo(Boolean.valueOf(pinimpression.isSetInsertionId()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetInsertionId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(insertionId, pinimpression.insertionId);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetEndTime()).compareTo(Boolean.valueOf(pinimpression.isSetEndTime()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetEndTime())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(endTime, pinimpression.endTime);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetYPosition()).compareTo(Boolean.valueOf(pinimpression.isSetYPosition()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetYPosition())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(yPosition, pinimpression.yPosition);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        j = Boolean.valueOf(isSetColumnIndex()).compareTo(Boolean.valueOf(pinimpression.isSetColumnIndex()));
        i = j;
        if (j != 0) goto _L4; else goto _L16
_L16:
        if (!isSetColumnIndex())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(columnIndex, pinimpression.columnIndex);
        i = j;
        if (j != 0) goto _L4; else goto _L17
_L17:
        j = Boolean.valueOf(isSetSlotIndex()).compareTo(Boolean.valueOf(pinimpression.isSetSlotIndex()));
        i = j;
        if (j != 0) goto _L4; else goto _L18
_L18:
        if (!isSetSlotIndex())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(slotIndex, pinimpression.slotIndex);
        i = j;
        if (j != 0) goto _L4; else goto _L19
_L19:
        j = Boolean.valueOf(isSetRequestId()).compareTo(Boolean.valueOf(pinimpression.isSetRequestId()));
        i = j;
        if (j != 0) goto _L4; else goto _L20
_L20:
        if (!isSetRequestId())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(requestId, pinimpression.requestId);
        i = j;
        if (j != 0) goto _L4; else goto _L21
_L21:
        j = Boolean.valueOf(isSetType()).compareTo(Boolean.valueOf(pinimpression.isSetType()));
        i = j;
        if (j != 0) goto _L4; else goto _L22
_L22:
        if (!isSetType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(type, pinimpression.type);
        i = j;
        if (j != 0) goto _L4; else goto _L23
_L23:
        j = Boolean.valueOf(isSetRenderDuration()).compareTo(Boolean.valueOf(pinimpression.isSetRenderDuration()));
        i = j;
        if (j != 0) goto _L4; else goto _L24
_L24:
        if (!isSetRenderDuration())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(renderDuration, pinimpression.renderDuration);
        i = j;
        if (j != 0) goto _L4; else goto _L25
_L25:
        j = Boolean.valueOf(isSetImageURL()).compareTo(Boolean.valueOf(pinimpression.isSetImageURL()));
        i = j;
        if (j != 0) goto _L4; else goto _L26
_L26:
        if (!isSetImageURL())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(imageURL, pinimpression.imageURL);
        i = j;
        if (j != 0) goto _L4; else goto _L27
_L27:
        j = Boolean.valueOf(isSetImageSignature()).compareTo(Boolean.valueOf(pinimpression.isSetImageSignature()));
        i = j;
        if (j != 0) goto _L4; else goto _L28
_L28:
        if (!isSetImageSignature())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(imageSignature, pinimpression.imageSignature);
        i = j;
        if (j != 0) goto _L4; else goto _L29
_L29:
        j = Boolean.valueOf(isSetCached()).compareTo(Boolean.valueOf(pinimpression.isSetCached()));
        i = j;
        if (j != 0) goto _L4; else goto _L30
_L30:
        if (!isSetCached())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(cached, pinimpression.cached);
        i = j;
        if (j != 0) goto _L4; else goto _L31
_L31:
        j = Boolean.valueOf(isSetLoops()).compareTo(Boolean.valueOf(pinimpression.isSetLoops()));
        i = j;
        if (j != 0) goto _L4; else goto _L32
_L32:
        if (!isSetLoops())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(loops, pinimpression.loops);
        i = j;
        if (j != 0) goto _L4; else goto _L33
_L33:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PinImpression)obj);
    }

    public PinImpression deepCopy()
    {
        return new PinImpression(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PinImpression pinimpression)
    {
        if (pinimpression != null && pinId == pinimpression.pinId && time == pinimpression.time)
        {
            boolean flag = isSetPinIdStr();
            boolean flag13 = pinimpression.isSetPinIdStr();
            if (!flag && !flag13 || flag && flag13 && pinIdStr.equals(pinimpression.pinIdStr))
            {
                boolean flag1 = isSetInsertionId();
                boolean flag14 = pinimpression.isSetInsertionId();
                if (!flag1 && !flag14 || flag1 && flag14 && insertionId.equals(pinimpression.insertionId))
                {
                    boolean flag2 = isSetEndTime();
                    boolean flag15 = pinimpression.isSetEndTime();
                    if (!flag2 && !flag15 || flag2 && flag15 && endTime == pinimpression.endTime)
                    {
                        boolean flag3 = isSetYPosition();
                        boolean flag16 = pinimpression.isSetYPosition();
                        if (!flag3 && !flag16 || flag3 && flag16 && yPosition == pinimpression.yPosition)
                        {
                            boolean flag4 = isSetColumnIndex();
                            boolean flag17 = pinimpression.isSetColumnIndex();
                            if (!flag4 && !flag17 || flag4 && flag17 && columnIndex == pinimpression.columnIndex)
                            {
                                boolean flag5 = isSetSlotIndex();
                                boolean flag18 = pinimpression.isSetSlotIndex();
                                if (!flag5 && !flag18 || flag5 && flag18 && slotIndex == pinimpression.slotIndex)
                                {
                                    boolean flag6 = isSetRequestId();
                                    boolean flag19 = pinimpression.isSetRequestId();
                                    if (!flag6 && !flag19 || flag6 && flag19 && requestId.equals(pinimpression.requestId))
                                    {
                                        boolean flag7 = isSetType();
                                        boolean flag20 = pinimpression.isSetType();
                                        if (!flag7 && !flag20 || flag7 && flag20 && type.equals(pinimpression.type))
                                        {
                                            boolean flag8 = isSetRenderDuration();
                                            boolean flag21 = pinimpression.isSetRenderDuration();
                                            if (!flag8 && !flag21 || flag8 && flag21 && renderDuration == pinimpression.renderDuration)
                                            {
                                                boolean flag9 = isSetImageURL();
                                                boolean flag22 = pinimpression.isSetImageURL();
                                                if (!flag9 && !flag22 || flag9 && flag22 && imageURL.equals(pinimpression.imageURL))
                                                {
                                                    boolean flag10 = isSetImageSignature();
                                                    boolean flag23 = pinimpression.isSetImageSignature();
                                                    if (!flag10 && !flag23 || flag10 && flag23 && imageSignature.equals(pinimpression.imageSignature))
                                                    {
                                                        boolean flag11 = isSetCached();
                                                        boolean flag24 = pinimpression.isSetCached();
                                                        if (!flag11 && !flag24 || flag11 && flag24 && cached == pinimpression.cached)
                                                        {
                                                            boolean flag12 = isSetLoops();
                                                            boolean flag25 = pinimpression.isSetLoops();
                                                            if (!flag12 && !flag25 || flag12 && flag25 && loops == pinimpression.loops)
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
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PinImpression)) 
        {
            return false;
        }
        return equals((PinImpression)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public short getColumnIndex()
    {
        return columnIndex;
    }

    public long getEndTime()
    {
        return endTime;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinImpression._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Long.valueOf(getPinId());

        case 2: // '\002'
            return Long.valueOf(getTime());

        case 3: // '\003'
            return getPinIdStr();

        case 4: // '\004'
            return getInsertionId();

        case 5: // '\005'
            return Long.valueOf(getEndTime());

        case 6: // '\006'
            return Integer.valueOf(getYPosition());

        case 7: // '\007'
            return Short.valueOf(getColumnIndex());

        case 8: // '\b'
            return Short.valueOf(getSlotIndex());

        case 9: // '\t'
            return getRequestId();

        case 10: // '\n'
            return getType();

        case 11: // '\013'
            return Double.valueOf(getRenderDuration());

        case 12: // '\f'
            return getImageURL();

        case 13: // '\r'
            return getImageSignature();

        case 14: // '\016'
            return Boolean.valueOf(isCached());

        case 15: // '\017'
            return Double.valueOf(getLoops());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getImageSignature()
    {
        return imageSignature;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public String getInsertionId()
    {
        return insertionId;
    }

    public double getLoops()
    {
        return loops;
    }

    public long getPinId()
    {
        return pinId;
    }

    public String getPinIdStr()
    {
        return pinIdStr;
    }

    public double getRenderDuration()
    {
        return renderDuration;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public short getSlotIndex()
    {
        return slotIndex;
    }

    public long getTime()
    {
        return time;
    }

    public PinImpressionType getType()
    {
        return type;
    }

    public int getYPosition()
    {
        return yPosition;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(pinId));
        arraylist.add(Boolean.valueOf(true));
        arraylist.add(Long.valueOf(time));
        boolean flag = isSetPinIdStr();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(pinIdStr);
        }
        flag = isSetInsertionId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(insertionId);
        }
        flag = isSetEndTime();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Long.valueOf(endTime));
        }
        flag = isSetYPosition();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(yPosition));
        }
        flag = isSetColumnIndex();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(columnIndex));
        }
        flag = isSetSlotIndex();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(slotIndex));
        }
        flag = isSetRequestId();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(requestId);
        }
        flag = isSetType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(type.getValue()));
        }
        flag = isSetRenderDuration();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(renderDuration));
        }
        flag = isSetImageURL();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(imageURL);
        }
        flag = isSetImageSignature();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(imageSignature);
        }
        flag = isSetCached();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(cached));
        }
        flag = isSetLoops();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(loops));
        }
        return arraylist.hashCode();
    }

    public boolean isCached()
    {
        return cached;
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinImpression._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetPinId();

        case 2: // '\002'
            return isSetTime();

        case 3: // '\003'
            return isSetPinIdStr();

        case 4: // '\004'
            return isSetInsertionId();

        case 5: // '\005'
            return isSetEndTime();

        case 6: // '\006'
            return isSetYPosition();

        case 7: // '\007'
            return isSetColumnIndex();

        case 8: // '\b'
            return isSetSlotIndex();

        case 9: // '\t'
            return isSetRequestId();

        case 10: // '\n'
            return isSetType();

        case 11: // '\013'
            return isSetRenderDuration();

        case 12: // '\f'
            return isSetImageURL();

        case 13: // '\r'
            return isSetImageSignature();

        case 14: // '\016'
            return isSetCached();

        case 15: // '\017'
            return isSetLoops();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetCached()
    {
        return EncodingUtils.testBit(__isset_bitfield, 7);
    }

    public boolean isSetColumnIndex()
    {
        return EncodingUtils.testBit(__isset_bitfield, 4);
    }

    public boolean isSetEndTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetImageSignature()
    {
        return imageSignature != null;
    }

    public boolean isSetImageURL()
    {
        return imageURL != null;
    }

    public boolean isSetInsertionId()
    {
        return insertionId != null;
    }

    public boolean isSetLoops()
    {
        return EncodingUtils.testBit(__isset_bitfield, 8);
    }

    public boolean isSetPinId()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetPinIdStr()
    {
        return pinIdStr != null;
    }

    public boolean isSetRenderDuration()
    {
        return EncodingUtils.testBit(__isset_bitfield, 6);
    }

    public boolean isSetRequestId()
    {
        return requestId != null;
    }

    public boolean isSetSlotIndex()
    {
        return EncodingUtils.testBit(__isset_bitfield, 5);
    }

    public boolean isSetTime()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetType()
    {
        return type != null;
    }

    public boolean isSetYPosition()
    {
        return EncodingUtils.testBit(__isset_bitfield, 3);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PinImpression setCached(boolean flag)
    {
        cached = flag;
        setCachedIsSet(true);
        return this;
    }

    public void setCachedIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 7, flag);
    }

    public PinImpression setColumnIndex(short word0)
    {
        columnIndex = word0;
        setColumnIndexIsSet(true);
        return this;
    }

    public void setColumnIndexIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 4, flag);
    }

    public PinImpression setEndTime(long l)
    {
        endTime = l;
        setEndTimeIsSet(true);
        return this;
    }

    public void setEndTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PinImpression._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetPinId();
                return;
            } else
            {
                setPinId(((Long)obj).longValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime(((Long)obj).longValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetPinIdStr();
                return;
            } else
            {
                setPinIdStr((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetInsertionId();
                return;
            } else
            {
                setInsertionId((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetEndTime();
                return;
            } else
            {
                setEndTime(((Long)obj).longValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetYPosition();
                return;
            } else
            {
                setYPosition(((Integer)obj).intValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetColumnIndex();
                return;
            } else
            {
                setColumnIndex(((Short)obj).shortValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetSlotIndex();
                return;
            } else
            {
                setSlotIndex(((Short)obj).shortValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetRequestId();
                return;
            } else
            {
                setRequestId((String)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetType();
                return;
            } else
            {
                setType((PinImpressionType)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetRenderDuration();
                return;
            } else
            {
                setRenderDuration(((Double)obj).doubleValue());
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetImageURL();
                return;
            } else
            {
                setImageURL((String)obj);
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetImageSignature();
                return;
            } else
            {
                setImageSignature((String)obj);
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetCached();
                return;
            } else
            {
                setCached(((Boolean)obj).booleanValue());
                return;
            }

        case 15: // '\017'
            break;
        }
        if (obj == null)
        {
            unsetLoops();
            return;
        } else
        {
            setLoops(((Double)obj).doubleValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PinImpression setImageSignature(String s)
    {
        imageSignature = s;
        return this;
    }

    public void setImageSignatureIsSet(boolean flag)
    {
        if (!flag)
        {
            imageSignature = null;
        }
    }

    public PinImpression setImageURL(String s)
    {
        imageURL = s;
        return this;
    }

    public void setImageURLIsSet(boolean flag)
    {
        if (!flag)
        {
            imageURL = null;
        }
    }

    public PinImpression setInsertionId(String s)
    {
        insertionId = s;
        return this;
    }

    public void setInsertionIdIsSet(boolean flag)
    {
        if (!flag)
        {
            insertionId = null;
        }
    }

    public PinImpression setLoops(double d)
    {
        loops = d;
        setLoopsIsSet(true);
        return this;
    }

    public void setLoopsIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 8, flag);
    }

    public PinImpression setPinId(long l)
    {
        pinId = l;
        setPinIdIsSet(true);
        return this;
    }

    public void setPinIdIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PinImpression setPinIdStr(String s)
    {
        pinIdStr = s;
        return this;
    }

    public void setPinIdStrIsSet(boolean flag)
    {
        if (!flag)
        {
            pinIdStr = null;
        }
    }

    public PinImpression setRenderDuration(double d)
    {
        renderDuration = d;
        setRenderDurationIsSet(true);
        return this;
    }

    public void setRenderDurationIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 6, flag);
    }

    public PinImpression setRequestId(String s)
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

    public PinImpression setSlotIndex(short word0)
    {
        slotIndex = word0;
        setSlotIndexIsSet(true);
        return this;
    }

    public void setSlotIndexIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 5, flag);
    }

    public PinImpression setTime(long l)
    {
        time = l;
        setTimeIsSet(true);
        return this;
    }

    public void setTimeIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public PinImpression setType(PinImpressionType pinimpressiontype)
    {
        type = pinimpressiontype;
        return this;
    }

    public void setTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            type = null;
        }
    }

    public PinImpression setYPosition(int i)
    {
        yPosition = i;
        setYPositionIsSet(true);
        return this;
    }

    public void setYPositionIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 3, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PinImpression(");
        stringbuilder.append("pinId:");
        stringbuilder.append(pinId);
        stringbuilder.append(", ");
        stringbuilder.append("time:");
        stringbuilder.append(time);
        if (isSetPinIdStr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("pinIdStr:");
            if (pinIdStr == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(pinIdStr);
            }
        }
        if (isSetInsertionId())
        {
            stringbuilder.append(", ");
            stringbuilder.append("insertionId:");
            if (insertionId == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(insertionId);
            }
        }
        if (isSetEndTime())
        {
            stringbuilder.append(", ");
            stringbuilder.append("endTime:");
            stringbuilder.append(endTime);
        }
        if (isSetYPosition())
        {
            stringbuilder.append(", ");
            stringbuilder.append("yPosition:");
            stringbuilder.append(yPosition);
        }
        if (isSetColumnIndex())
        {
            stringbuilder.append(", ");
            stringbuilder.append("columnIndex:");
            stringbuilder.append(columnIndex);
        }
        if (isSetSlotIndex())
        {
            stringbuilder.append(", ");
            stringbuilder.append("slotIndex:");
            stringbuilder.append(slotIndex);
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
        if (isSetType())
        {
            stringbuilder.append(", ");
            stringbuilder.append("type:");
            if (type == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(type);
            }
        }
        if (isSetRenderDuration())
        {
            stringbuilder.append(", ");
            stringbuilder.append("renderDuration:");
            stringbuilder.append(renderDuration);
        }
        if (isSetImageURL())
        {
            stringbuilder.append(", ");
            stringbuilder.append("imageURL:");
            if (imageURL == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(imageURL);
            }
        }
        if (isSetImageSignature())
        {
            stringbuilder.append(", ");
            stringbuilder.append("imageSignature:");
            if (imageSignature == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(imageSignature);
            }
        }
        if (isSetCached())
        {
            stringbuilder.append(", ");
            stringbuilder.append("cached:");
            stringbuilder.append(cached);
        }
        if (isSetLoops())
        {
            stringbuilder.append(", ");
            stringbuilder.append("loops:");
            stringbuilder.append(loops);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetCached()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 7);
    }

    public void unsetColumnIndex()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 4);
    }

    public void unsetEndTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetImageSignature()
    {
        imageSignature = null;
    }

    public void unsetImageURL()
    {
        imageURL = null;
    }

    public void unsetInsertionId()
    {
        insertionId = null;
    }

    public void unsetLoops()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 8);
    }

    public void unsetPinId()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetPinIdStr()
    {
        pinIdStr = null;
    }

    public void unsetRenderDuration()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 6);
    }

    public void unsetRequestId()
    {
        requestId = null;
    }

    public void unsetSlotIndex()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 5);
    }

    public void unsetTime()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetType()
    {
        type = null;
    }

    public void unsetYPosition()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PinImpressionStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PinImpressionTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.PIN_ID_STR, _Fields.INSERTION_ID, _Fields.END_TIME, _Fields.Y_POSITION, _Fields.COLUMN_INDEX, _Fields.SLOT_INDEX, _Fields.REQUEST_ID, _Fields.TYPE, _Fields.RENDER_DURATION, _Fields.IMAGE_URL, 
            _Fields.IMAGE_SIGNATURE, _Fields.CACHED, _Fields.LOOPS
        });
        obj = new EnumMap(com/pinterest/schemas/event/PinImpression$_Fields);
        ((Map) (obj)).put(_Fields.PIN_ID, new FieldMetaData("pinId", (byte)3, new FieldValueMetaData((byte)10, "Id")));
        ((Map) (obj)).put(_Fields.TIME, new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.PIN_ID_STR, new FieldMetaData("pinIdStr", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.INSERTION_ID, new FieldMetaData("insertionId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.END_TIME, new FieldMetaData("endTime", (byte)2, new FieldValueMetaData((byte)10, "Timestamp")));
        ((Map) (obj)).put(_Fields.Y_POSITION, new FieldMetaData("yPosition", (byte)2, new FieldValueMetaData((byte)8)));
        ((Map) (obj)).put(_Fields.COLUMN_INDEX, new FieldMetaData("columnIndex", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.SLOT_INDEX, new FieldMetaData("slotIndex", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.REQUEST_ID, new FieldMetaData("requestId", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.TYPE, new FieldMetaData("type", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/PinImpressionType)));
        ((Map) (obj)).put(_Fields.RENDER_DURATION, new FieldMetaData("renderDuration", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.IMAGE_URL, new FieldMetaData("imageURL", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.IMAGE_SIGNATURE, new FieldMetaData("imageSignature", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.CACHED, new FieldMetaData("cached", (byte)2, new FieldValueMetaData((byte)2)));
        ((Map) (obj)).put(_Fields.LOOPS, new FieldMetaData("loops", (byte)2, new FieldValueMetaData((byte)4)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PinImpression, metaDataMap);
    }

















    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields CACHED;
        public static final _Fields COLUMN_INDEX;
        public static final _Fields END_TIME;
        public static final _Fields IMAGE_SIGNATURE;
        public static final _Fields IMAGE_URL;
        public static final _Fields INSERTION_ID;
        public static final _Fields LOOPS;
        public static final _Fields PIN_ID;
        public static final _Fields PIN_ID_STR;
        public static final _Fields RENDER_DURATION;
        public static final _Fields REQUEST_ID;
        public static final _Fields SLOT_INDEX;
        public static final _Fields TIME;
        public static final _Fields TYPE;
        public static final _Fields Y_POSITION;
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
                return PIN_ID;

            case 2: // '\002'
                return TIME;

            case 3: // '\003'
                return PIN_ID_STR;

            case 4: // '\004'
                return INSERTION_ID;

            case 5: // '\005'
                return END_TIME;

            case 6: // '\006'
                return Y_POSITION;

            case 7: // '\007'
                return COLUMN_INDEX;

            case 8: // '\b'
                return SLOT_INDEX;

            case 9: // '\t'
                return REQUEST_ID;

            case 10: // '\n'
                return TYPE;

            case 11: // '\013'
                return RENDER_DURATION;

            case 12: // '\f'
                return IMAGE_URL;

            case 13: // '\r'
                return IMAGE_SIGNATURE;

            case 14: // '\016'
                return CACHED;

            case 15: // '\017'
                return LOOPS;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PinImpression$_Fields, s);
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
            PIN_ID = new _Fields("PIN_ID", 0, (short)1, "pinId");
            TIME = new _Fields("TIME", 1, (short)2, "time");
            PIN_ID_STR = new _Fields("PIN_ID_STR", 2, (short)3, "pinIdStr");
            INSERTION_ID = new _Fields("INSERTION_ID", 3, (short)4, "insertionId");
            END_TIME = new _Fields("END_TIME", 4, (short)5, "endTime");
            Y_POSITION = new _Fields("Y_POSITION", 5, (short)6, "yPosition");
            COLUMN_INDEX = new _Fields("COLUMN_INDEX", 6, (short)7, "columnIndex");
            SLOT_INDEX = new _Fields("SLOT_INDEX", 7, (short)8, "slotIndex");
            REQUEST_ID = new _Fields("REQUEST_ID", 8, (short)9, "requestId");
            TYPE = new _Fields("TYPE", 9, (short)10, "type");
            RENDER_DURATION = new _Fields("RENDER_DURATION", 10, (short)11, "renderDuration");
            IMAGE_URL = new _Fields("IMAGE_URL", 11, (short)12, "imageURL");
            IMAGE_SIGNATURE = new _Fields("IMAGE_SIGNATURE", 12, (short)13, "imageSignature");
            CACHED = new _Fields("CACHED", 13, (short)14, "cached");
            LOOPS = new _Fields("LOOPS", 14, (short)15, "loops");
            $VALUES = (new _Fields[] {
                PIN_ID, TIME, PIN_ID_STR, INSERTION_ID, END_TIME, Y_POSITION, COLUMN_INDEX, SLOT_INDEX, REQUEST_ID, TYPE, 
                RENDER_DURATION, IMAGE_URL, IMAGE_SIGNATURE, CACHED, LOOPS
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinImpression$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.PIN_ID.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.TIME.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.PIN_ID_STR.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.INSERTION_ID.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.END_TIME.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.Y_POSITION.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.COLUMN_INDEX.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.SLOT_INDEX.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.REQUEST_ID.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.TYPE.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.RENDER_DURATION.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.IMAGE_URL.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.IMAGE_SIGNATURE.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.CACHED.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PinImpression$_Fields[_Fields.LOOPS.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PinImpressionStandardSchemeFactory
        implements SchemeFactory
    {

        public PinImpressionStandardScheme getScheme()
        {
            return new PinImpressionStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinImpressionStandardSchemeFactory()
        {
        }

        PinImpressionStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinImpressionStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PinImpression pinimpression)
            {
                tprotocol.readStructBegin();
_L18:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_651;
                }
                tfield.id;
                JVM INSTR tableswitch 1 15: default 96
            //                           1 111
            //                           2 147
            //                           3 183
            //                           4 219
            //                           5 255
            //                           6 291
            //                           7 327
            //                           8 363
            //                           9 399
            //                           10 435
            //                           11 474
            //                           12 509
            //                           13 545
            //                           14 581
            //                           15 616;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L16:
                break MISSING_BLOCK_LABEL_616;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L19:
                tprotocol.readFieldEnd();
                if (true) goto _L18; else goto _L17
_L17:
                if (tfield.type == 10)
                {
                    pinimpression.pinId = tprotocol.readI64();
                    pinimpression.setPinIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L3:
                if (tfield.type == 10)
                {
                    pinimpression.time = tprotocol.readI64();
                    pinimpression.setTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L4:
                if (tfield.type == 11)
                {
                    pinimpression.pinIdStr = tprotocol.readString();
                    pinimpression.setPinIdStrIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L5:
                if (tfield.type == 11)
                {
                    pinimpression.insertionId = tprotocol.readString();
                    pinimpression.setInsertionIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L6:
                if (tfield.type == 10)
                {
                    pinimpression.endTime = tprotocol.readI64();
                    pinimpression.setEndTimeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L7:
                if (tfield.type == 8)
                {
                    pinimpression.yPosition = tprotocol.readI32();
                    pinimpression.setYPositionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L8:
                if (tfield.type == 6)
                {
                    pinimpression.columnIndex = tprotocol.readI16();
                    pinimpression.setColumnIndexIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L9:
                if (tfield.type == 6)
                {
                    pinimpression.slotIndex = tprotocol.readI16();
                    pinimpression.setSlotIndexIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L10:
                if (tfield.type == 11)
                {
                    pinimpression.requestId = tprotocol.readString();
                    pinimpression.setRequestIdIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L11:
                if (tfield.type == 8)
                {
                    pinimpression.type = PinImpressionType.findByValue(tprotocol.readI32());
                    pinimpression.setTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L12:
                if (tfield.type == 4)
                {
                    pinimpression.renderDuration = tprotocol.readDouble();
                    pinimpression.setRenderDurationIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L13:
                if (tfield.type == 11)
                {
                    pinimpression.imageURL = tprotocol.readString();
                    pinimpression.setImageURLIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L14:
                if (tfield.type == 11)
                {
                    pinimpression.imageSignature = tprotocol.readString();
                    pinimpression.setImageSignatureIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
_L15:
                if (tfield.type == 2)
                {
                    pinimpression.cached = tprotocol.readBool();
                    pinimpression.setCachedIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
                if (tfield.type == 4)
                {
                    pinimpression.loops = tprotocol.readDouble();
                    pinimpression.setLoopsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L19
                tprotocol.readStructEnd();
                pinimpression.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinImpression)tbase);
            }

            public void write(TProtocol tprotocol, PinImpression pinimpression)
            {
                pinimpression.validate();
                tprotocol.writeStructBegin(PinImpression.STRUCT_DESC);
                tprotocol.writeFieldBegin(PinImpression.PIN_ID_FIELD_DESC);
                tprotocol.writeI64(pinimpression.pinId);
                tprotocol.writeFieldEnd();
                tprotocol.writeFieldBegin(PinImpression.TIME_FIELD_DESC);
                tprotocol.writeI64(pinimpression.time);
                tprotocol.writeFieldEnd();
                if (pinimpression.pinIdStr != null && pinimpression.isSetPinIdStr())
                {
                    tprotocol.writeFieldBegin(PinImpression.PIN_ID_STR_FIELD_DESC);
                    tprotocol.writeString(pinimpression.pinIdStr);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.insertionId != null && pinimpression.isSetInsertionId())
                {
                    tprotocol.writeFieldBegin(PinImpression.INSERTION_ID_FIELD_DESC);
                    tprotocol.writeString(pinimpression.insertionId);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetEndTime())
                {
                    tprotocol.writeFieldBegin(PinImpression.END_TIME_FIELD_DESC);
                    tprotocol.writeI64(pinimpression.endTime);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetYPosition())
                {
                    tprotocol.writeFieldBegin(PinImpression.Y_POSITION_FIELD_DESC);
                    tprotocol.writeI32(pinimpression.yPosition);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetColumnIndex())
                {
                    tprotocol.writeFieldBegin(PinImpression.COLUMN_INDEX_FIELD_DESC);
                    tprotocol.writeI16(pinimpression.columnIndex);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetSlotIndex())
                {
                    tprotocol.writeFieldBegin(PinImpression.SLOT_INDEX_FIELD_DESC);
                    tprotocol.writeI16(pinimpression.slotIndex);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.requestId != null && pinimpression.isSetRequestId())
                {
                    tprotocol.writeFieldBegin(PinImpression.REQUEST_ID_FIELD_DESC);
                    tprotocol.writeString(pinimpression.requestId);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.type != null && pinimpression.isSetType())
                {
                    tprotocol.writeFieldBegin(PinImpression.TYPE_FIELD_DESC);
                    tprotocol.writeI32(pinimpression.type.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetRenderDuration())
                {
                    tprotocol.writeFieldBegin(PinImpression.RENDER_DURATION_FIELD_DESC);
                    tprotocol.writeDouble(pinimpression.renderDuration);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.imageURL != null && pinimpression.isSetImageURL())
                {
                    tprotocol.writeFieldBegin(PinImpression.IMAGE_URL_FIELD_DESC);
                    tprotocol.writeString(pinimpression.imageURL);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.imageSignature != null && pinimpression.isSetImageSignature())
                {
                    tprotocol.writeFieldBegin(PinImpression.IMAGE_SIGNATURE_FIELD_DESC);
                    tprotocol.writeString(pinimpression.imageSignature);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetCached())
                {
                    tprotocol.writeFieldBegin(PinImpression.CACHED_FIELD_DESC);
                    tprotocol.writeBool(pinimpression.cached);
                    tprotocol.writeFieldEnd();
                }
                if (pinimpression.isSetLoops())
                {
                    tprotocol.writeFieldBegin(PinImpression.LOOPS_FIELD_DESC);
                    tprotocol.writeDouble(pinimpression.loops);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinImpression)tbase);
            }

            private PinImpressionStandardScheme()
            {
            }

            PinImpressionStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PinImpressionTupleSchemeFactory
        implements SchemeFactory
    {

        public PinImpressionTupleScheme getScheme()
        {
            return new PinImpressionTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PinImpressionTupleSchemeFactory()
        {
        }

        PinImpressionTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PinImpressionTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PinImpression pinimpression)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(15);
                if (bitset.get(0))
                {
                    pinimpression.pinId = tprotocol.readI64();
                    pinimpression.setPinIdIsSet(true);
                }
                if (bitset.get(1))
                {
                    pinimpression.time = tprotocol.readI64();
                    pinimpression.setTimeIsSet(true);
                }
                if (bitset.get(2))
                {
                    pinimpression.pinIdStr = tprotocol.readString();
                    pinimpression.setPinIdStrIsSet(true);
                }
                if (bitset.get(3))
                {
                    pinimpression.insertionId = tprotocol.readString();
                    pinimpression.setInsertionIdIsSet(true);
                }
                if (bitset.get(4))
                {
                    pinimpression.endTime = tprotocol.readI64();
                    pinimpression.setEndTimeIsSet(true);
                }
                if (bitset.get(5))
                {
                    pinimpression.yPosition = tprotocol.readI32();
                    pinimpression.setYPositionIsSet(true);
                }
                if (bitset.get(6))
                {
                    pinimpression.columnIndex = tprotocol.readI16();
                    pinimpression.setColumnIndexIsSet(true);
                }
                if (bitset.get(7))
                {
                    pinimpression.slotIndex = tprotocol.readI16();
                    pinimpression.setSlotIndexIsSet(true);
                }
                if (bitset.get(8))
                {
                    pinimpression.requestId = tprotocol.readString();
                    pinimpression.setRequestIdIsSet(true);
                }
                if (bitset.get(9))
                {
                    pinimpression.type = PinImpressionType.findByValue(tprotocol.readI32());
                    pinimpression.setTypeIsSet(true);
                }
                if (bitset.get(10))
                {
                    pinimpression.renderDuration = tprotocol.readDouble();
                    pinimpression.setRenderDurationIsSet(true);
                }
                if (bitset.get(11))
                {
                    pinimpression.imageURL = tprotocol.readString();
                    pinimpression.setImageURLIsSet(true);
                }
                if (bitset.get(12))
                {
                    pinimpression.imageSignature = tprotocol.readString();
                    pinimpression.setImageSignatureIsSet(true);
                }
                if (bitset.get(13))
                {
                    pinimpression.cached = tprotocol.readBool();
                    pinimpression.setCachedIsSet(true);
                }
                if (bitset.get(14))
                {
                    pinimpression.loops = tprotocol.readDouble();
                    pinimpression.setLoopsIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PinImpression)tbase);
            }

            public void write(TProtocol tprotocol, PinImpression pinimpression)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (pinimpression.isSetPinId())
                {
                    bitset.set(0);
                }
                if (pinimpression.isSetTime())
                {
                    bitset.set(1);
                }
                if (pinimpression.isSetPinIdStr())
                {
                    bitset.set(2);
                }
                if (pinimpression.isSetInsertionId())
                {
                    bitset.set(3);
                }
                if (pinimpression.isSetEndTime())
                {
                    bitset.set(4);
                }
                if (pinimpression.isSetYPosition())
                {
                    bitset.set(5);
                }
                if (pinimpression.isSetColumnIndex())
                {
                    bitset.set(6);
                }
                if (pinimpression.isSetSlotIndex())
                {
                    bitset.set(7);
                }
                if (pinimpression.isSetRequestId())
                {
                    bitset.set(8);
                }
                if (pinimpression.isSetType())
                {
                    bitset.set(9);
                }
                if (pinimpression.isSetRenderDuration())
                {
                    bitset.set(10);
                }
                if (pinimpression.isSetImageURL())
                {
                    bitset.set(11);
                }
                if (pinimpression.isSetImageSignature())
                {
                    bitset.set(12);
                }
                if (pinimpression.isSetCached())
                {
                    bitset.set(13);
                }
                if (pinimpression.isSetLoops())
                {
                    bitset.set(14);
                }
                tprotocol.writeBitSet(bitset, 15);
                if (pinimpression.isSetPinId())
                {
                    tprotocol.writeI64(pinimpression.pinId);
                }
                if (pinimpression.isSetTime())
                {
                    tprotocol.writeI64(pinimpression.time);
                }
                if (pinimpression.isSetPinIdStr())
                {
                    tprotocol.writeString(pinimpression.pinIdStr);
                }
                if (pinimpression.isSetInsertionId())
                {
                    tprotocol.writeString(pinimpression.insertionId);
                }
                if (pinimpression.isSetEndTime())
                {
                    tprotocol.writeI64(pinimpression.endTime);
                }
                if (pinimpression.isSetYPosition())
                {
                    tprotocol.writeI32(pinimpression.yPosition);
                }
                if (pinimpression.isSetColumnIndex())
                {
                    tprotocol.writeI16(pinimpression.columnIndex);
                }
                if (pinimpression.isSetSlotIndex())
                {
                    tprotocol.writeI16(pinimpression.slotIndex);
                }
                if (pinimpression.isSetRequestId())
                {
                    tprotocol.writeString(pinimpression.requestId);
                }
                if (pinimpression.isSetType())
                {
                    tprotocol.writeI32(pinimpression.type.getValue());
                }
                if (pinimpression.isSetRenderDuration())
                {
                    tprotocol.writeDouble(pinimpression.renderDuration);
                }
                if (pinimpression.isSetImageURL())
                {
                    tprotocol.writeString(pinimpression.imageURL);
                }
                if (pinimpression.isSetImageSignature())
                {
                    tprotocol.writeString(pinimpression.imageSignature);
                }
                if (pinimpression.isSetCached())
                {
                    tprotocol.writeBool(pinimpression.cached);
                }
                if (pinimpression.isSetLoops())
                {
                    tprotocol.writeDouble(pinimpression.loops);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PinImpression)tbase);
            }

            private PinImpressionTupleScheme()
            {
            }

            PinImpressionTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
