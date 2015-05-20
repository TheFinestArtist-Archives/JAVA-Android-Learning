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

public class VisualObject
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField H_FIELD_DESC = new TField("h", (byte)4, (short)6);
    private static final TField OBJECT_INDEX_FIELD_DESC = new TField("objectIndex", (byte)6, (short)2);
    private static final TField OBJECT_TYPE_FIELD_DESC = new TField("objectType", (byte)11, (short)1);
    private static final TStruct STRUCT_DESC = new TStruct("VisualObject");
    private static final TField W_FIELD_DESC = new TField("w", (byte)4, (short)5);
    private static final TField X_FIELD_DESC = new TField("x", (byte)4, (short)3);
    private static final TField Y_FIELD_DESC = new TField("y", (byte)4, (short)4);
    private static final int __H_ISSET_ID = 4;
    private static final int __OBJECTINDEX_ISSET_ID = 0;
    private static final int __W_ISSET_ID = 3;
    private static final int __X_ISSET_ID = 1;
    private static final int __Y_ISSET_ID = 2;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public double h;
    public short objectIndex;
    public String objectType;
    public double w;
    public double x;
    public double y;

    public VisualObject()
    {
        __isset_bitfield = 0;
    }

    public VisualObject(VisualObject visualobject)
    {
        __isset_bitfield = 0;
        __isset_bitfield = visualobject.__isset_bitfield;
        if (visualobject.isSetObjectType())
        {
            objectType = visualobject.objectType;
        }
        objectIndex = visualobject.objectIndex;
        x = visualobject.x;
        y = visualobject.y;
        w = visualobject.w;
        h = visualobject.h;
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
        objectType = null;
        setObjectIndexIsSet(false);
        objectIndex = 0;
        setXIsSet(false);
        x = 0.0D;
        setYIsSet(false);
        y = 0.0D;
        setWIsSet(false);
        w = 0.0D;
        setHIsSet(false);
        h = 0.0D;
    }

    public int compareTo(VisualObject visualobject)
    {
        if (getClass().equals(visualobject.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(visualobject.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetObjectType()).compareTo(Boolean.valueOf(visualobject.isSetObjectType()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetObjectType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectType, visualobject.objectType);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetObjectIndex()).compareTo(Boolean.valueOf(visualobject.isSetObjectIndex()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetObjectIndex())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectIndex, visualobject.objectIndex);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetX()).compareTo(Boolean.valueOf(visualobject.isSetX()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetX())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(x, visualobject.x);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetY()).compareTo(Boolean.valueOf(visualobject.isSetY()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetY())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(y, visualobject.y);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetW()).compareTo(Boolean.valueOf(visualobject.isSetW()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetW())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(w, visualobject.w);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        j = Boolean.valueOf(isSetH()).compareTo(Boolean.valueOf(visualobject.isSetH()));
        i = j;
        if (j != 0) goto _L4; else goto _L14
_L14:
        if (!isSetH())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(h, visualobject.h);
        i = j;
        if (j != 0) goto _L4; else goto _L15
_L15:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VisualObject)obj);
    }

    public VisualObject deepCopy()
    {
        return new VisualObject(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(VisualObject visualobject)
    {
        if (visualobject != null)
        {
            boolean flag = isSetObjectType();
            boolean flag6 = visualobject.isSetObjectType();
            if (!flag && !flag6 || flag && flag6 && objectType.equals(visualobject.objectType))
            {
                boolean flag1 = isSetObjectIndex();
                boolean flag7 = visualobject.isSetObjectIndex();
                if (!flag1 && !flag7 || flag1 && flag7 && objectIndex == visualobject.objectIndex)
                {
                    boolean flag2 = isSetX();
                    boolean flag8 = visualobject.isSetX();
                    if (!flag2 && !flag8 || flag2 && flag8 && x == visualobject.x)
                    {
                        boolean flag3 = isSetY();
                        boolean flag9 = visualobject.isSetY();
                        if (!flag3 && !flag9 || flag3 && flag9 && y == visualobject.y)
                        {
                            boolean flag4 = isSetW();
                            boolean flag10 = visualobject.isSetW();
                            if (!flag4 && !flag10 || flag4 && flag10 && w == visualobject.w)
                            {
                                boolean flag5 = isSetH();
                                boolean flag11 = visualobject.isSetH();
                                if (!flag5 && !flag11 || flag5 && flag11 && h == visualobject.h)
                                {
                                    return true;
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
        while (obj == null || !(obj instanceof VisualObject)) 
        {
            return false;
        }
        return equals((VisualObject)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObject._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getObjectType();

        case 2: // '\002'
            return Short.valueOf(getObjectIndex());

        case 3: // '\003'
            return Double.valueOf(getX());

        case 4: // '\004'
            return Double.valueOf(getY());

        case 5: // '\005'
            return Double.valueOf(getW());

        case 6: // '\006'
            return Double.valueOf(getH());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public double getH()
    {
        return h;
    }

    public short getObjectIndex()
    {
        return objectIndex;
    }

    public String getObjectType()
    {
        return objectType;
    }

    public double getW()
    {
        return w;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetObjectType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(objectType);
        }
        flag = isSetObjectIndex();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(objectIndex));
        }
        flag = isSetX();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(x));
        }
        flag = isSetY();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(y));
        }
        flag = isSetW();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(w));
        }
        flag = isSetH();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Double.valueOf(h));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObject._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetObjectType();

        case 2: // '\002'
            return isSetObjectIndex();

        case 3: // '\003'
            return isSetX();

        case 4: // '\004'
            return isSetY();

        case 5: // '\005'
            return isSetW();

        case 6: // '\006'
            return isSetH();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetH()
    {
        return EncodingUtils.testBit(__isset_bitfield, 4);
    }

    public boolean isSetObjectIndex()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetObjectType()
    {
        return objectType != null;
    }

    public boolean isSetW()
    {
        return EncodingUtils.testBit(__isset_bitfield, 3);
    }

    public boolean isSetX()
    {
        return EncodingUtils.testBit(__isset_bitfield, 1);
    }

    public boolean isSetY()
    {
        return EncodingUtils.testBit(__isset_bitfield, 2);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObject._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetObjectType();
                return;
            } else
            {
                setObjectType((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetObjectIndex();
                return;
            } else
            {
                setObjectIndex(((Short)obj).shortValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetX();
                return;
            } else
            {
                setX(((Double)obj).doubleValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetY();
                return;
            } else
            {
                setY(((Double)obj).doubleValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetW();
                return;
            } else
            {
                setW(((Double)obj).doubleValue());
                return;
            }

        case 6: // '\006'
            break;
        }
        if (obj == null)
        {
            unsetH();
            return;
        } else
        {
            setH(((Double)obj).doubleValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public VisualObject setH(double d)
    {
        h = d;
        setHIsSet(true);
        return this;
    }

    public void setHIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 4, flag);
    }

    public VisualObject setObjectIndex(short word0)
    {
        objectIndex = word0;
        setObjectIndexIsSet(true);
        return this;
    }

    public void setObjectIndexIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public VisualObject setObjectType(String s)
    {
        objectType = s;
        return this;
    }

    public void setObjectTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            objectType = null;
        }
    }

    public VisualObject setW(double d)
    {
        w = d;
        setWIsSet(true);
        return this;
    }

    public void setWIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 3, flag);
    }

    public VisualObject setX(double d)
    {
        x = d;
        setXIsSet(true);
        return this;
    }

    public void setXIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 1, flag);
    }

    public VisualObject setY(double d)
    {
        y = d;
        setYIsSet(true);
        return this;
    }

    public void setYIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 2, flag);
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("VisualObject(");
        boolean flag1 = true;
        if (isSetObjectType())
        {
            stringbuilder.append("objectType:");
            boolean flag;
            if (objectType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objectType);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetObjectIndex())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("objectIndex:");
            stringbuilder.append(objectIndex);
            flag = false;
        }
        flag1 = flag;
        if (isSetX())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("x:");
            stringbuilder.append(x);
            flag1 = false;
        }
        flag = flag1;
        if (isSetY())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("y:");
            stringbuilder.append(y);
            flag = false;
        }
        if (isSetW())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("w:");
            stringbuilder.append(w);
            flag = flag2;
        }
        if (isSetH())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("h:");
            stringbuilder.append(h);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetH()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 4);
    }

    public void unsetObjectIndex()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetObjectType()
    {
        objectType = null;
    }

    public void unsetW()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 3);
    }

    public void unsetX()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 1);
    }

    public void unsetY()
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new VisualObjectStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new VisualObjectTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.OBJECT_TYPE, _Fields.OBJECT_INDEX, _Fields.X, _Fields.Y, _Fields.W, _Fields.H
        });
        obj = new EnumMap(com/pinterest/schemas/event/VisualObject$_Fields);
        ((Map) (obj)).put(_Fields.OBJECT_TYPE, new FieldMetaData("objectType", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.OBJECT_INDEX, new FieldMetaData("objectIndex", (byte)2, new FieldValueMetaData((byte)6)));
        ((Map) (obj)).put(_Fields.X, new FieldMetaData("x", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.Y, new FieldMetaData("y", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.W, new FieldMetaData("w", (byte)2, new FieldValueMetaData((byte)4)));
        ((Map) (obj)).put(_Fields.H, new FieldMetaData("h", (byte)2, new FieldValueMetaData((byte)4)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/VisualObject, metaDataMap);
    }








    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields H;
        public static final _Fields OBJECT_INDEX;
        public static final _Fields OBJECT_TYPE;
        public static final _Fields W;
        public static final _Fields X;
        public static final _Fields Y;
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
                return OBJECT_TYPE;

            case 2: // '\002'
                return OBJECT_INDEX;

            case 3: // '\003'
                return X;

            case 4: // '\004'
                return Y;

            case 5: // '\005'
                return W;

            case 6: // '\006'
                return H;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/VisualObject$_Fields, s);
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
            OBJECT_TYPE = new _Fields("OBJECT_TYPE", 0, (short)1, "objectType");
            OBJECT_INDEX = new _Fields("OBJECT_INDEX", 1, (short)2, "objectIndex");
            X = new _Fields("X", 2, (short)3, "x");
            Y = new _Fields("Y", 3, (short)4, "y");
            W = new _Fields("W", 4, (short)5, "w");
            H = new _Fields("H", 5, (short)6, "h");
            $VALUES = (new _Fields[] {
                OBJECT_TYPE, OBJECT_INDEX, X, Y, W, H
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/VisualObject$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.OBJECT_TYPE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.OBJECT_INDEX.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.X.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.Y.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.W.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObject$_Fields[_Fields.H.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class VisualObjectStandardSchemeFactory
        implements SchemeFactory
    {

        public VisualObjectStandardScheme getScheme()
        {
            return new VisualObjectStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private VisualObjectStandardSchemeFactory()
        {
        }

        VisualObjectStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class VisualObjectStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, VisualObject visualobject)
            {
                tprotocol.readStructBegin();
_L9:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_287;
                }
                tfield.id;
                JVM INSTR tableswitch 1 6: default 60
            //                           1 75
            //                           2 111
            //                           3 147
            //                           4 182
            //                           5 217
            //                           6 252;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
                break MISSING_BLOCK_LABEL_252;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L10:
                tprotocol.readFieldEnd();
                if (true) goto _L9; else goto _L8
_L8:
                if (tfield.type == 11)
                {
                    visualobject.objectType = tprotocol.readString();
                    visualobject.setObjectTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
_L3:
                if (tfield.type == 6)
                {
                    visualobject.objectIndex = tprotocol.readI16();
                    visualobject.setObjectIndexIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
_L4:
                if (tfield.type == 4)
                {
                    visualobject.x = tprotocol.readDouble();
                    visualobject.setXIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
_L5:
                if (tfield.type == 4)
                {
                    visualobject.y = tprotocol.readDouble();
                    visualobject.setYIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
_L6:
                if (tfield.type == 4)
                {
                    visualobject.w = tprotocol.readDouble();
                    visualobject.setWIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
                if (tfield.type == 4)
                {
                    visualobject.h = tprotocol.readDouble();
                    visualobject.setHIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L10
                tprotocol.readStructEnd();
                visualobject.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (VisualObject)tbase);
            }

            public void write(TProtocol tprotocol, VisualObject visualobject)
            {
                visualobject.validate();
                tprotocol.writeStructBegin(VisualObject.STRUCT_DESC);
                if (visualobject.objectType != null && visualobject.isSetObjectType())
                {
                    tprotocol.writeFieldBegin(VisualObject.OBJECT_TYPE_FIELD_DESC);
                    tprotocol.writeString(visualobject.objectType);
                    tprotocol.writeFieldEnd();
                }
                if (visualobject.isSetObjectIndex())
                {
                    tprotocol.writeFieldBegin(VisualObject.OBJECT_INDEX_FIELD_DESC);
                    tprotocol.writeI16(visualobject.objectIndex);
                    tprotocol.writeFieldEnd();
                }
                if (visualobject.isSetX())
                {
                    tprotocol.writeFieldBegin(VisualObject.X_FIELD_DESC);
                    tprotocol.writeDouble(visualobject.x);
                    tprotocol.writeFieldEnd();
                }
                if (visualobject.isSetY())
                {
                    tprotocol.writeFieldBegin(VisualObject.Y_FIELD_DESC);
                    tprotocol.writeDouble(visualobject.y);
                    tprotocol.writeFieldEnd();
                }
                if (visualobject.isSetW())
                {
                    tprotocol.writeFieldBegin(VisualObject.W_FIELD_DESC);
                    tprotocol.writeDouble(visualobject.w);
                    tprotocol.writeFieldEnd();
                }
                if (visualobject.isSetH())
                {
                    tprotocol.writeFieldBegin(VisualObject.H_FIELD_DESC);
                    tprotocol.writeDouble(visualobject.h);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (VisualObject)tbase);
            }

            private VisualObjectStandardScheme()
            {
            }

            VisualObjectStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class VisualObjectTupleSchemeFactory
        implements SchemeFactory
    {

        public VisualObjectTupleScheme getScheme()
        {
            return new VisualObjectTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private VisualObjectTupleSchemeFactory()
        {
        }

        VisualObjectTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class VisualObjectTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, VisualObject visualobject)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(6);
                if (bitset.get(0))
                {
                    visualobject.objectType = tprotocol.readString();
                    visualobject.setObjectTypeIsSet(true);
                }
                if (bitset.get(1))
                {
                    visualobject.objectIndex = tprotocol.readI16();
                    visualobject.setObjectIndexIsSet(true);
                }
                if (bitset.get(2))
                {
                    visualobject.x = tprotocol.readDouble();
                    visualobject.setXIsSet(true);
                }
                if (bitset.get(3))
                {
                    visualobject.y = tprotocol.readDouble();
                    visualobject.setYIsSet(true);
                }
                if (bitset.get(4))
                {
                    visualobject.w = tprotocol.readDouble();
                    visualobject.setWIsSet(true);
                }
                if (bitset.get(5))
                {
                    visualobject.h = tprotocol.readDouble();
                    visualobject.setHIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (VisualObject)tbase);
            }

            public void write(TProtocol tprotocol, VisualObject visualobject)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (visualobject.isSetObjectType())
                {
                    bitset.set(0);
                }
                if (visualobject.isSetObjectIndex())
                {
                    bitset.set(1);
                }
                if (visualobject.isSetX())
                {
                    bitset.set(2);
                }
                if (visualobject.isSetY())
                {
                    bitset.set(3);
                }
                if (visualobject.isSetW())
                {
                    bitset.set(4);
                }
                if (visualobject.isSetH())
                {
                    bitset.set(5);
                }
                tprotocol.writeBitSet(bitset, 6);
                if (visualobject.isSetObjectType())
                {
                    tprotocol.writeString(visualobject.objectType);
                }
                if (visualobject.isSetObjectIndex())
                {
                    tprotocol.writeI16(visualobject.objectIndex);
                }
                if (visualobject.isSetX())
                {
                    tprotocol.writeDouble(visualobject.x);
                }
                if (visualobject.isSetY())
                {
                    tprotocol.writeDouble(visualobject.y);
                }
                if (visualobject.isSetW())
                {
                    tprotocol.writeDouble(visualobject.w);
                }
                if (visualobject.isSetH())
                {
                    tprotocol.writeDouble(visualobject.h);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (VisualObject)tbase);
            }

            private VisualObjectTupleScheme()
            {
            }

            VisualObjectTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
