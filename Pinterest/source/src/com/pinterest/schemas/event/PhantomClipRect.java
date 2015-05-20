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

public class PhantomClipRect
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField HEIGHT_FIELD_DESC = new TField("height", (byte)6, (short)3);
    private static final TField LEFT_FIELD_DESC = new TField("left", (byte)6, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomClipRect");
    private static final TField TOP_FIELD_DESC = new TField("top", (byte)6, (short)1);
    private static final TField WIDTH_FIELD_DESC = new TField("width", (byte)6, (short)4);
    private static final int __HEIGHT_ISSET_ID = 2;
    private static final int __LEFT_ISSET_ID = 1;
    private static final int __TOP_ISSET_ID = 0;
    private static final int __WIDTH_ISSET_ID = 3;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public short height;
    public short left;
    public short top;
    public short width;

    public PhantomClipRect()
    {
        __isset_bitfield = 0;
    }

    public PhantomClipRect(PhantomClipRect phantomcliprect)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomcliprect.__isset_bitfield;
        top = phantomcliprect.top;
        left = phantomcliprect.left;
        height = phantomcliprect.height;
        width = phantomcliprect.width;
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
        setTopIsSet(false);
        top = 0;
        setLeftIsSet(false);
        left = 0;
        setHeightIsSet(false);
        height = 0;
        setWidthIsSet(false);
        width = 0;
    }

    public int compareTo(PhantomClipRect phantomcliprect)
    {
        if (getClass().equals(phantomcliprect.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomcliprect.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetTop()).compareTo(Boolean.valueOf(phantomcliprect.isSetTop()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetTop())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(top, phantomcliprect.top);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetLeft()).compareTo(Boolean.valueOf(phantomcliprect.isSetLeft()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetLeft())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(left, phantomcliprect.left);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetHeight()).compareTo(Boolean.valueOf(phantomcliprect.isSetHeight()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetHeight())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(height, phantomcliprect.height);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetWidth()).compareTo(Boolean.valueOf(phantomcliprect.isSetWidth()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetWidth())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(width, phantomcliprect.width);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomClipRect)obj);
    }

    public PhantomClipRect deepCopy()
    {
        return new PhantomClipRect(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomClipRect phantomcliprect)
    {
        if (phantomcliprect != null)
        {
            boolean flag = isSetTop();
            boolean flag4 = phantomcliprect.isSetTop();
            if (!flag && !flag4 || flag && flag4 && top == phantomcliprect.top)
            {
                boolean flag1 = isSetLeft();
                boolean flag5 = phantomcliprect.isSetLeft();
                if (!flag1 && !flag5 || flag1 && flag5 && left == phantomcliprect.left)
                {
                    boolean flag2 = isSetHeight();
                    boolean flag6 = phantomcliprect.isSetHeight();
                    if (!flag2 && !flag6 || flag2 && flag6 && height == phantomcliprect.height)
                    {
                        boolean flag3 = isSetWidth();
                        boolean flag7 = phantomcliprect.isSetWidth();
                        if (!flag3 && !flag7 || flag3 && flag7 && width == phantomcliprect.width)
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
        while (obj == null || !(obj instanceof PhantomClipRect)) 
        {
            return false;
        }
        return equals((PhantomClipRect)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomClipRect._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Short.valueOf(getTop());

        case 2: // '\002'
            return Short.valueOf(getLeft());

        case 3: // '\003'
            return Short.valueOf(getHeight());

        case 4: // '\004'
            return Short.valueOf(getWidth());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public short getHeight()
    {
        return height;
    }

    public short getLeft()
    {
        return left;
    }

    public short getTop()
    {
        return top;
    }

    public short getWidth()
    {
        return width;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetTop();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(top));
        }
        flag = isSetLeft();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(left));
        }
        flag = isSetHeight();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(height));
        }
        flag = isSetWidth();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(width));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomClipRect._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetTop();

        case 2: // '\002'
            return isSetLeft();

        case 3: // '\003'
            return isSetHeight();

        case 4: // '\004'
            return isSetWidth();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetHeight()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public boolean isSetLeft()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetTop()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetWidth()
    {
        return EncodingUtils.testBit(__isset_bitfield, 3);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomClipRect._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetTop();
                return;
            } else
            {
                setTop(((Short)obj).shortValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetLeft();
                return;
            } else
            {
                setLeft(((Short)obj).shortValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetHeight();
                return;
            } else
            {
                setHeight(((Short)obj).shortValue());
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetWidth();
            return;
        } else
        {
            setWidth(((Short)obj).shortValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomClipRect setHeight(short word0)
    {
        height = word0;
        setHeightIsSet(true);
        return this;
    }

    public void setHeightIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public PhantomClipRect setLeft(short word0)
    {
        left = word0;
        setLeftIsSet(true);
        return this;
    }

    public void setLeftIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public PhantomClipRect setTop(short word0)
    {
        top = word0;
        setTopIsSet(true);
        return this;
    }

    public void setTopIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public PhantomClipRect setWidth(short word0)
    {
        width = word0;
        setWidthIsSet(true);
        return this;
    }

    public void setWidthIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 3, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("PhantomClipRect(");
        boolean flag = true;
        if (isSetTop())
        {
            stringbuilder.append("top:");
            stringbuilder.append(top);
            flag = false;
        }
        boolean flag1 = flag;
        if (isSetLeft())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("left:");
            stringbuilder.append(left);
            flag1 = false;
        }
        if (isSetHeight())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("height:");
            stringbuilder.append(height);
            flag = flag2;
        } else
        {
            flag = flag1;
        }
        if (isSetWidth())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("width:");
            stringbuilder.append(width);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetHeight()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 2);
    }

    public void unsetLeft()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetTop()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetWidth()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomClipRectStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomClipRectTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.TOP, _Fields.LEFT, _Fields.HEIGHT, _Fields.WIDTH
        });
        obj = new EnumMap(com/pinterest/schemas/event/PhantomClipRect$_Fields);
        ((Map) (obj)).put(_Fields.TOP, new FieldMetaData("top", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.LEFT, new FieldMetaData("left", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.HEIGHT, new FieldMetaData("height", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.WIDTH, new FieldMetaData("width", (byte)2, new FieldValueMetaData((byte)6)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomClipRect, metaDataMap);
    }






    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields HEIGHT;
        public static final _Fields LEFT;
        public static final _Fields TOP;
        public static final _Fields WIDTH;
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
                return TOP;

            case 2: // '\002'
                return LEFT;

            case 3: // '\003'
                return HEIGHT;

            case 4: // '\004'
                return WIDTH;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomClipRect$_Fields, s);
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
            TOP = new _Fields("TOP", 0, (short)1, "top");
            LEFT = new _Fields("LEFT", 1, (short)2, "left");
            HEIGHT = new _Fields("HEIGHT", 2, (short)3, "height");
            WIDTH = new _Fields("WIDTH", 3, (short)4, "width");
            $VALUES = (new _Fields[] {
                TOP, LEFT, HEIGHT, WIDTH
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomClipRect$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields[_Fields.TOP.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields[_Fields.LEFT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields[_Fields.HEIGHT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomClipRect$_Fields[_Fields.WIDTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomClipRectStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomClipRectStandardScheme getScheme()
        {
            return new PhantomClipRectStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomClipRectStandardSchemeFactory()
        {
        }

        PhantomClipRectStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomClipRectStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomClipRect phantomcliprect)
            {
                tprotocol.readStructBegin();
_L7:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_211;
                }
                tfield.id;
                JVM INSTR tableswitch 1 4: default 52
            //                           1 67
            //                           2 103
            //                           3 139
            //                           4 175;
                   goto _L1 _L2 _L3 _L4 _L5
_L5:
                break MISSING_BLOCK_LABEL_175;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
                tprotocol.readFieldEnd();
                if (true) goto _L7; else goto _L6
_L6:
                if (tfield.type == 6)
                {
                    phantomcliprect.top = tprotocol.readI16();
                    phantomcliprect.setTopIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L3:
                if (tfield.type == 6)
                {
                    phantomcliprect.left = tprotocol.readI16();
                    phantomcliprect.setLeftIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
_L4:
                if (tfield.type == 6)
                {
                    phantomcliprect.height = tprotocol.readI16();
                    phantomcliprect.setHeightIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                if (tfield.type == 6)
                {
                    phantomcliprect.width = tprotocol.readI16();
                    phantomcliprect.setWidthIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L8
                tprotocol.readStructEnd();
                phantomcliprect.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomClipRect)tbase);
            }

            public void write(TProtocol tprotocol, PhantomClipRect phantomcliprect)
            {
                phantomcliprect.validate();
                tprotocol.writeStructBegin(PhantomClipRect.STRUCT_DESC);
                if (phantomcliprect.isSetTop())
                {
                    tprotocol.writeFieldBegin(PhantomClipRect.TOP_FIELD_DESC);
                    tprotocol.writeI16(phantomcliprect.top);
                    tprotocol.writeFieldEnd();
                }
                if (phantomcliprect.isSetLeft())
                {
                    tprotocol.writeFieldBegin(PhantomClipRect.LEFT_FIELD_DESC);
                    tprotocol.writeI16(phantomcliprect.left);
                    tprotocol.writeFieldEnd();
                }
                if (phantomcliprect.isSetHeight())
                {
                    tprotocol.writeFieldBegin(PhantomClipRect.HEIGHT_FIELD_DESC);
                    tprotocol.writeI16(phantomcliprect.height);
                    tprotocol.writeFieldEnd();
                }
                if (phantomcliprect.isSetWidth())
                {
                    tprotocol.writeFieldBegin(PhantomClipRect.WIDTH_FIELD_DESC);
                    tprotocol.writeI16(phantomcliprect.width);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomClipRect)tbase);
            }

            private PhantomClipRectStandardScheme()
            {
            }

            PhantomClipRectStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomClipRectTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomClipRectTupleScheme getScheme()
        {
            return new PhantomClipRectTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomClipRectTupleSchemeFactory()
        {
        }

        PhantomClipRectTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomClipRectTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomClipRect phantomcliprect)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(4);
                if (bitset.get(0))
                {
                    phantomcliprect.top = tprotocol.readI16();
                    phantomcliprect.setTopIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomcliprect.left = tprotocol.readI16();
                    phantomcliprect.setLeftIsSet(true);
                }
                if (bitset.get(2))
                {
                    phantomcliprect.height = tprotocol.readI16();
                    phantomcliprect.setHeightIsSet(true);
                }
                if (bitset.get(3))
                {
                    phantomcliprect.width = tprotocol.readI16();
                    phantomcliprect.setWidthIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomClipRect)tbase);
            }

            public void write(TProtocol tprotocol, PhantomClipRect phantomcliprect)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomcliprect.isSetTop())
                {
                    bitset.set(0);
                }
                if (phantomcliprect.isSetLeft())
                {
                    bitset.set(1);
                }
                if (phantomcliprect.isSetHeight())
                {
                    bitset.set(2);
                }
                if (phantomcliprect.isSetWidth())
                {
                    bitset.set(3);
                }
                tprotocol.writeBitSet(bitset, 4);
                if (phantomcliprect.isSetTop())
                {
                    tprotocol.writeI16(phantomcliprect.top);
                }
                if (phantomcliprect.isSetLeft())
                {
                    tprotocol.writeI16(phantomcliprect.left);
                }
                if (phantomcliprect.isSetHeight())
                {
                    tprotocol.writeI16(phantomcliprect.height);
                }
                if (phantomcliprect.isSetWidth())
                {
                    tprotocol.writeI16(phantomcliprect.width);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomClipRect)tbase);
            }

            private PhantomClipRectTupleScheme()
            {
            }

            PhantomClipRectTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
