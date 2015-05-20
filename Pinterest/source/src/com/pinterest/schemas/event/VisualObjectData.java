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
//            VisualObject

public class VisualObjectData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField OBJECTS_FIELD_DESC = new TField("objects", (byte)15, (short)1);
    private static final TField SELECTED_OBJECT_INDEX_FIELD_DESC = new TField("selectedObjectIndex", (byte)6, (short)3);
    private static final TField SIMLIST_VERSION_FIELD_DESC = new TField("simlistVersion", (byte)11, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("VisualObjectData");
    private static final int __SELECTEDOBJECTINDEX_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public List objects;
    public short selectedObjectIndex;
    public String simlistVersion;

    public VisualObjectData()
    {
        __isset_bitfield = 0;
    }

    public VisualObjectData(VisualObjectData visualobjectdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = visualobjectdata.__isset_bitfield;
        if (visualobjectdata.isSetObjects())
        {
            ArrayList arraylist = new ArrayList(visualobjectdata.objects.size());
            for (Iterator iterator = visualobjectdata.objects.iterator(); iterator.hasNext(); arraylist.add(new VisualObject((VisualObject)iterator.next()))) { }
            objects = arraylist;
        }
        if (visualobjectdata.isSetSimlistVersion())
        {
            simlistVersion = visualobjectdata.simlistVersion;
        }
        selectedObjectIndex = visualobjectdata.selectedObjectIndex;
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

    public void addToObjects(VisualObject visualobject)
    {
        if (objects == null)
        {
            objects = new ArrayList();
        }
        objects.add(visualobject);
    }

    public void clear()
    {
        objects = null;
        simlistVersion = null;
        setSelectedObjectIndexIsSet(false);
        selectedObjectIndex = 0;
    }

    public int compareTo(VisualObjectData visualobjectdata)
    {
        if (getClass().equals(visualobjectdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(visualobjectdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetObjects()).compareTo(Boolean.valueOf(visualobjectdata.isSetObjects()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetObjects())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objects, visualobjectdata.objects);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetSimlistVersion()).compareTo(Boolean.valueOf(visualobjectdata.isSetSimlistVersion()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetSimlistVersion())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(simlistVersion, visualobjectdata.simlistVersion);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetSelectedObjectIndex()).compareTo(Boolean.valueOf(visualobjectdata.isSetSelectedObjectIndex()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetSelectedObjectIndex())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(selectedObjectIndex, visualobjectdata.selectedObjectIndex);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VisualObjectData)obj);
    }

    public VisualObjectData deepCopy()
    {
        return new VisualObjectData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(VisualObjectData visualobjectdata)
    {
        if (visualobjectdata != null)
        {
            boolean flag = isSetObjects();
            boolean flag3 = visualobjectdata.isSetObjects();
            if (!flag && !flag3 || flag && flag3 && objects.equals(visualobjectdata.objects))
            {
                boolean flag1 = isSetSimlistVersion();
                boolean flag4 = visualobjectdata.isSetSimlistVersion();
                if (!flag1 && !flag4 || flag1 && flag4 && simlistVersion.equals(visualobjectdata.simlistVersion))
                {
                    boolean flag2 = isSetSelectedObjectIndex();
                    boolean flag5 = visualobjectdata.isSetSelectedObjectIndex();
                    if (!flag2 && !flag5 || flag2 && flag5 && selectedObjectIndex == visualobjectdata.selectedObjectIndex)
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
        while (obj == null || !(obj instanceof VisualObjectData)) 
        {
            return false;
        }
        return equals((VisualObjectData)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObjectData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getObjects();

        case 2: // '\002'
            return getSimlistVersion();

        case 3: // '\003'
            return Short.valueOf(getSelectedObjectIndex());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public List getObjects()
    {
        return objects;
    }

    public Iterator getObjectsIterator()
    {
        if (objects == null)
        {
            return null;
        } else
        {
            return objects.iterator();
        }
    }

    public int getObjectsSize()
    {
        if (objects == null)
        {
            return 0;
        } else
        {
            return objects.size();
        }
    }

    public short getSelectedObjectIndex()
    {
        return selectedObjectIndex;
    }

    public String getSimlistVersion()
    {
        return simlistVersion;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetObjects();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(objects);
        }
        flag = isSetSimlistVersion();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(simlistVersion);
        }
        flag = isSetSelectedObjectIndex();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Short.valueOf(selectedObjectIndex));
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObjectData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetObjects();

        case 2: // '\002'
            return isSetSimlistVersion();

        case 3: // '\003'
            return isSetSelectedObjectIndex();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetObjects()
    {
        return objects != null;
    }

    public boolean isSetSelectedObjectIndex()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetSimlistVersion()
    {
        return simlistVersion != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.VisualObjectData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetObjects();
                return;
            } else
            {
                setObjects((List)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetSimlistVersion();
                return;
            } else
            {
                setSimlistVersion((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetSelectedObjectIndex();
            return;
        } else
        {
            setSelectedObjectIndex(((Short)obj).shortValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public VisualObjectData setObjects(List list)
    {
        objects = list;
        return this;
    }

    public void setObjectsIsSet(boolean flag)
    {
        if (!flag)
        {
            objects = null;
        }
    }

    public VisualObjectData setSelectedObjectIndex(short word0)
    {
        selectedObjectIndex = word0;
        setSelectedObjectIndexIsSet(true);
        return this;
    }

    public void setSelectedObjectIndexIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public VisualObjectData setSimlistVersion(String s)
    {
        simlistVersion = s;
        return this;
    }

    public void setSimlistVersionIsSet(boolean flag)
    {
        if (!flag)
        {
            simlistVersion = null;
        }
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("VisualObjectData(");
        boolean flag = true;
        if (isSetObjects())
        {
            stringbuilder.append("objects:");
            if (objects == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objects);
            }
            flag = false;
        }
        if (isSetSimlistVersion())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("simlistVersion:");
            if (simlistVersion == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(simlistVersion);
                flag = flag1;
            }
        }
        if (isSetSelectedObjectIndex())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("selectedObjectIndex:");
            stringbuilder.append(selectedObjectIndex);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetObjects()
    {
        objects = null;
    }

    public void unsetSelectedObjectIndex()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetSimlistVersion()
    {
        simlistVersion = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new VisualObjectDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new VisualObjectDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.OBJECTS, _Fields.SIMLIST_VERSION, _Fields.SELECTED_OBJECT_INDEX
        });
        obj = new EnumMap(com/pinterest/schemas/event/VisualObjectData$_Fields);
        ((Map) (obj)).put(_Fields.OBJECTS, new FieldMetaData("objects", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/event/VisualObject))));
        ((Map) (obj)).put(_Fields.SIMLIST_VERSION, new FieldMetaData("simlistVersion", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SELECTED_OBJECT_INDEX, new FieldMetaData("selectedObjectIndex", (byte)2, new FieldValueMetaData((byte)6)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/VisualObjectData, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields OBJECTS;
        public static final _Fields SELECTED_OBJECT_INDEX;
        public static final _Fields SIMLIST_VERSION;
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
                return OBJECTS;

            case 2: // '\002'
                return SIMLIST_VERSION;

            case 3: // '\003'
                return SELECTED_OBJECT_INDEX;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/VisualObjectData$_Fields, s);
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
            OBJECTS = new _Fields("OBJECTS", 0, (short)1, "objects");
            SIMLIST_VERSION = new _Fields("SIMLIST_VERSION", 1, (short)2, "simlistVersion");
            SELECTED_OBJECT_INDEX = new _Fields("SELECTED_OBJECT_INDEX", 2, (short)3, "selectedObjectIndex");
            $VALUES = (new _Fields[] {
                OBJECTS, SIMLIST_VERSION, SELECTED_OBJECT_INDEX
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/VisualObjectData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$VisualObjectData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$VisualObjectData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObjectData$_Fields[_Fields.OBJECTS.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObjectData$_Fields[_Fields.SIMLIST_VERSION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$VisualObjectData$_Fields[_Fields.SELECTED_OBJECT_INDEX.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class VisualObjectDataStandardSchemeFactory
        implements SchemeFactory
    {

        public VisualObjectDataStandardScheme getScheme()
        {
            return new VisualObjectDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private VisualObjectDataStandardSchemeFactory()
        {
        }

        VisualObjectDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class VisualObjectDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, VisualObjectData visualobjectdata)
            {
                tprotocol.readStructBegin();
_L6:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_235;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 163
            //                           3 199;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_199;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    visualobjectdata.objects = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        VisualObject visualobject = new VisualObject();
                        visualobject.read(tprotocol);
                        visualobjectdata.objects.add(visualobject);
                    }

                    tprotocol.readListEnd();
                    visualobjectdata.setObjectsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
_L3:
                if (((TField) (obj)).type == 11)
                {
                    visualobjectdata.simlistVersion = tprotocol.readString();
                    visualobjectdata.setSimlistVersionIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                if (((TField) (obj)).type == 6)
                {
                    visualobjectdata.selectedObjectIndex = tprotocol.readI16();
                    visualobjectdata.setSelectedObjectIndexIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                visualobjectdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (VisualObjectData)tbase);
            }

            public void write(TProtocol tprotocol, VisualObjectData visualobjectdata)
            {
                visualobjectdata.validate();
                tprotocol.writeStructBegin(VisualObjectData.STRUCT_DESC);
                if (visualobjectdata.objects != null && visualobjectdata.isSetObjects())
                {
                    tprotocol.writeFieldBegin(VisualObjectData.OBJECTS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, visualobjectdata.objects.size()));
                    for (Iterator iterator = visualobjectdata.objects.iterator(); iterator.hasNext(); ((VisualObject)iterator.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (visualobjectdata.simlistVersion != null && visualobjectdata.isSetSimlistVersion())
                {
                    tprotocol.writeFieldBegin(VisualObjectData.SIMLIST_VERSION_FIELD_DESC);
                    tprotocol.writeString(visualobjectdata.simlistVersion);
                    tprotocol.writeFieldEnd();
                }
                if (visualobjectdata.isSetSelectedObjectIndex())
                {
                    tprotocol.writeFieldBegin(VisualObjectData.SELECTED_OBJECT_INDEX_FIELD_DESC);
                    tprotocol.writeI16(visualobjectdata.selectedObjectIndex);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (VisualObjectData)tbase);
            }

            private VisualObjectDataStandardScheme()
            {
            }

            VisualObjectDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class VisualObjectDataTupleSchemeFactory
        implements SchemeFactory
    {

        public VisualObjectDataTupleScheme getScheme()
        {
            return new VisualObjectDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private VisualObjectDataTupleSchemeFactory()
        {
        }

        VisualObjectDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class VisualObjectDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, VisualObjectData visualobjectdata)
            {
                int i = 0;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    visualobjectdata.objects = new ArrayList(tlist.size);
                    for (; i < tlist.size; i++)
                    {
                        VisualObject visualobject = new VisualObject();
                        visualobject.read(tprotocol);
                        visualobjectdata.objects.add(visualobject);
                    }

                    visualobjectdata.setObjectsIsSet(true);
                }
                if (bitset.get(1))
                {
                    visualobjectdata.simlistVersion = tprotocol.readString();
                    visualobjectdata.setSimlistVersionIsSet(true);
                }
                if (bitset.get(2))
                {
                    visualobjectdata.selectedObjectIndex = tprotocol.readI16();
                    visualobjectdata.setSelectedObjectIndexIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (VisualObjectData)tbase);
            }

            public void write(TProtocol tprotocol, VisualObjectData visualobjectdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (visualobjectdata.isSetObjects())
                {
                    bitset.set(0);
                }
                if (visualobjectdata.isSetSimlistVersion())
                {
                    bitset.set(1);
                }
                if (visualobjectdata.isSetSelectedObjectIndex())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (visualobjectdata.isSetObjects())
                {
                    tprotocol.writeI32(visualobjectdata.objects.size());
                    for (Iterator iterator = visualobjectdata.objects.iterator(); iterator.hasNext(); ((VisualObject)iterator.next()).write(tprotocol)) { }
                }
                if (visualobjectdata.isSetSimlistVersion())
                {
                    tprotocol.writeString(visualobjectdata.simlistVersion);
                }
                if (visualobjectdata.isSetSelectedObjectIndex())
                {
                    tprotocol.writeI16(visualobjectdata.selectedObjectIndex);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (VisualObjectData)tbase);
            }

            private VisualObjectDataTupleScheme()
            {
            }

            VisualObjectDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
