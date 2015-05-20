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
//            ToastType, NagType, EducationType

public class ComponentData
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField DIGEST_STORY_TYPE_FIELD_DESC = new TField("digestStoryType", (byte)11, (short)5);
    private static final TField EDUCATION_TYPE_FIELD_DESC = new TField("educationType", (byte)8, (short)4);
    private static final TField NAG_TYPE_FIELD_DESC = new TField("nagType", (byte)8, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("ComponentData");
    private static final TField STUB_FIELD_DESC = new TField("stub", (byte)8, (short)1);
    private static final TField TOAST_TYPE_FIELD_DESC = new TField("toastType", (byte)8, (short)2);
    private static final int __STUB_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public String digestStoryType;
    public EducationType educationType;
    public NagType nagType;
    public int stub;
    public ToastType toastType;

    public ComponentData()
    {
        __isset_bitfield = 0;
    }

    public ComponentData(ComponentData componentdata)
    {
        __isset_bitfield = 0;
        __isset_bitfield = componentdata.__isset_bitfield;
        stub = componentdata.stub;
        if (componentdata.isSetToastType())
        {
            toastType = componentdata.toastType;
        }
        if (componentdata.isSetNagType())
        {
            nagType = componentdata.nagType;
        }
        if (componentdata.isSetEducationType())
        {
            educationType = componentdata.educationType;
        }
        if (componentdata.isSetDigestStoryType())
        {
            digestStoryType = componentdata.digestStoryType;
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

    public void clear()
    {
        setStubIsSet(false);
        stub = 0;
        toastType = null;
        nagType = null;
        educationType = null;
        digestStoryType = null;
    }

    public int compareTo(ComponentData componentdata)
    {
        if (getClass().equals(componentdata.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(componentdata.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetStub()).compareTo(Boolean.valueOf(componentdata.isSetStub()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetStub())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(stub, componentdata.stub);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetToastType()).compareTo(Boolean.valueOf(componentdata.isSetToastType()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetToastType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(toastType, componentdata.toastType);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetNagType()).compareTo(Boolean.valueOf(componentdata.isSetNagType()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetNagType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(nagType, componentdata.nagType);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        j = Boolean.valueOf(isSetEducationType()).compareTo(Boolean.valueOf(componentdata.isSetEducationType()));
        i = j;
        if (j != 0) goto _L4; else goto _L10
_L10:
        if (!isSetEducationType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(educationType, componentdata.educationType);
        i = j;
        if (j != 0) goto _L4; else goto _L11
_L11:
        j = Boolean.valueOf(isSetDigestStoryType()).compareTo(Boolean.valueOf(componentdata.isSetDigestStoryType()));
        i = j;
        if (j != 0) goto _L4; else goto _L12
_L12:
        if (!isSetDigestStoryType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(digestStoryType, componentdata.digestStoryType);
        i = j;
        if (j != 0) goto _L4; else goto _L13
_L13:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ComponentData)obj);
    }

    public ComponentData deepCopy()
    {
        return new ComponentData(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(ComponentData componentdata)
    {
        if (componentdata != null)
        {
            boolean flag = isSetStub();
            boolean flag5 = componentdata.isSetStub();
            if (!flag && !flag5 || flag && flag5 && stub == componentdata.stub)
            {
                boolean flag1 = isSetToastType();
                boolean flag6 = componentdata.isSetToastType();
                if (!flag1 && !flag6 || flag1 && flag6 && toastType.equals(componentdata.toastType))
                {
                    boolean flag2 = isSetNagType();
                    boolean flag7 = componentdata.isSetNagType();
                    if (!flag2 && !flag7 || flag2 && flag7 && nagType.equals(componentdata.nagType))
                    {
                        boolean flag3 = isSetEducationType();
                        boolean flag8 = componentdata.isSetEducationType();
                        if (!flag3 && !flag8 || flag3 && flag8 && educationType.equals(componentdata.educationType))
                        {
                            boolean flag4 = isSetDigestStoryType();
                            boolean flag9 = componentdata.isSetDigestStoryType();
                            if (!flag4 && !flag9 || flag4 && flag9 && digestStoryType.equals(componentdata.digestStoryType))
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
        while (obj == null || !(obj instanceof ComponentData)) 
        {
            return false;
        }
        return equals((ComponentData)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getDigestStoryType()
    {
        return digestStoryType;
    }

    public EducationType getEducationType()
    {
        return educationType;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ComponentData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return Integer.valueOf(getStub());

        case 2: // '\002'
            return getToastType();

        case 3: // '\003'
            return getNagType();

        case 4: // '\004'
            return getEducationType();

        case 5: // '\005'
            return getDigestStoryType();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public NagType getNagType()
    {
        return nagType;
    }

    public int getStub()
    {
        return stub;
    }

    public ToastType getToastType()
    {
        return toastType;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetStub();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(stub));
        }
        flag = isSetToastType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(toastType.getValue()));
        }
        flag = isSetNagType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(nagType.getValue()));
        }
        flag = isSetEducationType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(educationType.getValue()));
        }
        flag = isSetDigestStoryType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(digestStoryType);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ComponentData._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetStub();

        case 2: // '\002'
            return isSetToastType();

        case 3: // '\003'
            return isSetNagType();

        case 4: // '\004'
            return isSetEducationType();

        case 5: // '\005'
            return isSetDigestStoryType();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetDigestStoryType()
    {
        return digestStoryType != null;
    }

    public boolean isSetEducationType()
    {
        return educationType != null;
    }

    public boolean isSetNagType()
    {
        return nagType != null;
    }

    public boolean isSetStub()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public boolean isSetToastType()
    {
        return toastType != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public ComponentData setDigestStoryType(String s)
    {
        digestStoryType = s;
        return this;
    }

    public void setDigestStoryTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            digestStoryType = null;
        }
    }

    public ComponentData setEducationType(EducationType educationtype)
    {
        educationType = educationtype;
        return this;
    }

    public void setEducationTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            educationType = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.ComponentData._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetStub();
                return;
            } else
            {
                setStub(((Integer)obj).intValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetToastType();
                return;
            } else
            {
                setToastType((ToastType)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetNagType();
                return;
            } else
            {
                setNagType((NagType)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetEducationType();
                return;
            } else
            {
                setEducationType((EducationType)obj);
                return;
            }

        case 5: // '\005'
            break;
        }
        if (obj == null)
        {
            unsetDigestStoryType();
            return;
        } else
        {
            setDigestStoryType((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public ComponentData setNagType(NagType nagtype)
    {
        nagType = nagtype;
        return this;
    }

    public void setNagTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            nagType = null;
        }
    }

    public ComponentData setStub(int i)
    {
        stub = i;
        setStubIsSet(true);
        return this;
    }

    public void setStubIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public ComponentData setToastType(ToastType toasttype)
    {
        toastType = toasttype;
        return this;
    }

    public void setToastTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            toastType = null;
        }
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("ComponentData(");
        boolean flag1 = true;
        if (isSetStub())
        {
            stringbuilder.append("stub:");
            stringbuilder.append(stub);
            flag1 = false;
        }
        boolean flag = flag1;
        if (isSetToastType())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("toastType:");
            if (toastType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(toastType);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetNagType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("nagType:");
            if (nagType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(nagType);
            }
            flag1 = false;
        }
        if (isSetEducationType())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("educationType:");
            if (educationType == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(educationType);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetDigestStoryType())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("digestStoryType:");
            if (digestStoryType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(digestStoryType);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetDigestStoryType()
    {
        digestStoryType = null;
    }

    public void unsetEducationType()
    {
        educationType = null;
    }

    public void unsetNagType()
    {
        nagType = null;
    }

    public void unsetStub()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void unsetToastType()
    {
        toastType = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new ComponentDataStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new ComponentDataTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.STUB, _Fields.TOAST_TYPE, _Fields.NAG_TYPE, _Fields.EDUCATION_TYPE, _Fields.DIGEST_STORY_TYPE
        });
        obj = new EnumMap(com/pinterest/schemas/event/ComponentData$_Fields);
        ((Map) (obj)).put(_Fields.STUB, new FieldMetaData("stub", (byte)2, new FieldValueMetaData((byte)8)));
        ((Map) (obj)).put(_Fields.TOAST_TYPE, new FieldMetaData("toastType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/ToastType)));
        ((Map) (obj)).put(_Fields.NAG_TYPE, new FieldMetaData("nagType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/NagType)));
        ((Map) (obj)).put(_Fields.EDUCATION_TYPE, new FieldMetaData("educationType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/event/EducationType)));
        ((Map) (obj)).put(_Fields.DIGEST_STORY_TYPE, new FieldMetaData("digestStoryType", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/ComponentData, metaDataMap);
    }







    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields DIGEST_STORY_TYPE;
        public static final _Fields EDUCATION_TYPE;
        public static final _Fields NAG_TYPE;
        public static final _Fields STUB;
        public static final _Fields TOAST_TYPE;
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
                return STUB;

            case 2: // '\002'
                return TOAST_TYPE;

            case 3: // '\003'
                return NAG_TYPE;

            case 4: // '\004'
                return EDUCATION_TYPE;

            case 5: // '\005'
                return DIGEST_STORY_TYPE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/ComponentData$_Fields, s);
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
            STUB = new _Fields("STUB", 0, (short)1, "stub");
            TOAST_TYPE = new _Fields("TOAST_TYPE", 1, (short)2, "toastType");
            NAG_TYPE = new _Fields("NAG_TYPE", 2, (short)3, "nagType");
            EDUCATION_TYPE = new _Fields("EDUCATION_TYPE", 3, (short)4, "educationType");
            DIGEST_STORY_TYPE = new _Fields("DIGEST_STORY_TYPE", 4, (short)5, "digestStoryType");
            $VALUES = (new _Fields[] {
                STUB, TOAST_TYPE, NAG_TYPE, EDUCATION_TYPE, DIGEST_STORY_TYPE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/ComponentData$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[_Fields.STUB.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[_Fields.TOAST_TYPE.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[_Fields.NAG_TYPE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[_Fields.EDUCATION_TYPE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$ComponentData$_Fields[_Fields.DIGEST_STORY_TYPE.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class ComponentDataStandardSchemeFactory
        implements SchemeFactory
    {

        public ComponentDataStandardScheme getScheme()
        {
            return new ComponentDataStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ComponentDataStandardSchemeFactory()
        {
        }

        ComponentDataStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ComponentDataStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, ComponentData componentdata)
            {
                tprotocol.readStructBegin();
_L8:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_260;
                }
                tfield.id;
                JVM INSTR tableswitch 1 5: default 56
            //                           1 71
            //                           2 107
            //                           3 146
            //                           4 185
            //                           5 224;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
                break MISSING_BLOCK_LABEL_224;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L9:
                tprotocol.readFieldEnd();
                if (true) goto _L8; else goto _L7
_L7:
                if (tfield.type == 8)
                {
                    componentdata.stub = tprotocol.readI32();
                    componentdata.setStubIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L3:
                if (tfield.type == 8)
                {
                    componentdata.toastType = ToastType.findByValue(tprotocol.readI32());
                    componentdata.setToastTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L4:
                if (tfield.type == 8)
                {
                    componentdata.nagType = NagType.findByValue(tprotocol.readI32());
                    componentdata.setNagTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
_L5:
                if (tfield.type == 8)
                {
                    componentdata.educationType = EducationType.findByValue(tprotocol.readI32());
                    componentdata.setEducationTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                if (tfield.type == 11)
                {
                    componentdata.digestStoryType = tprotocol.readString();
                    componentdata.setDigestStoryTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L9
                tprotocol.readStructEnd();
                componentdata.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ComponentData)tbase);
            }

            public void write(TProtocol tprotocol, ComponentData componentdata)
            {
                componentdata.validate();
                tprotocol.writeStructBegin(ComponentData.STRUCT_DESC);
                if (componentdata.isSetStub())
                {
                    tprotocol.writeFieldBegin(ComponentData.STUB_FIELD_DESC);
                    tprotocol.writeI32(componentdata.stub);
                    tprotocol.writeFieldEnd();
                }
                if (componentdata.toastType != null && componentdata.isSetToastType())
                {
                    tprotocol.writeFieldBegin(ComponentData.TOAST_TYPE_FIELD_DESC);
                    tprotocol.writeI32(componentdata.toastType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (componentdata.nagType != null && componentdata.isSetNagType())
                {
                    tprotocol.writeFieldBegin(ComponentData.NAG_TYPE_FIELD_DESC);
                    tprotocol.writeI32(componentdata.nagType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (componentdata.educationType != null && componentdata.isSetEducationType())
                {
                    tprotocol.writeFieldBegin(ComponentData.EDUCATION_TYPE_FIELD_DESC);
                    tprotocol.writeI32(componentdata.educationType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (componentdata.digestStoryType != null && componentdata.isSetDigestStoryType())
                {
                    tprotocol.writeFieldBegin(ComponentData.DIGEST_STORY_TYPE_FIELD_DESC);
                    tprotocol.writeString(componentdata.digestStoryType);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ComponentData)tbase);
            }

            private ComponentDataStandardScheme()
            {
            }

            ComponentDataStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class ComponentDataTupleSchemeFactory
        implements SchemeFactory
    {

        public ComponentDataTupleScheme getScheme()
        {
            return new ComponentDataTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private ComponentDataTupleSchemeFactory()
        {
        }

        ComponentDataTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class ComponentDataTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, ComponentData componentdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(5);
                if (bitset.get(0))
                {
                    componentdata.stub = tprotocol.readI32();
                    componentdata.setStubIsSet(true);
                }
                if (bitset.get(1))
                {
                    componentdata.toastType = ToastType.findByValue(tprotocol.readI32());
                    componentdata.setToastTypeIsSet(true);
                }
                if (bitset.get(2))
                {
                    componentdata.nagType = NagType.findByValue(tprotocol.readI32());
                    componentdata.setNagTypeIsSet(true);
                }
                if (bitset.get(3))
                {
                    componentdata.educationType = EducationType.findByValue(tprotocol.readI32());
                    componentdata.setEducationTypeIsSet(true);
                }
                if (bitset.get(4))
                {
                    componentdata.digestStoryType = tprotocol.readString();
                    componentdata.setDigestStoryTypeIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (ComponentData)tbase);
            }

            public void write(TProtocol tprotocol, ComponentData componentdata)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (componentdata.isSetStub())
                {
                    bitset.set(0);
                }
                if (componentdata.isSetToastType())
                {
                    bitset.set(1);
                }
                if (componentdata.isSetNagType())
                {
                    bitset.set(2);
                }
                if (componentdata.isSetEducationType())
                {
                    bitset.set(3);
                }
                if (componentdata.isSetDigestStoryType())
                {
                    bitset.set(4);
                }
                tprotocol.writeBitSet(bitset, 5);
                if (componentdata.isSetStub())
                {
                    tprotocol.writeI32(componentdata.stub);
                }
                if (componentdata.isSetToastType())
                {
                    tprotocol.writeI32(componentdata.toastType.getValue());
                }
                if (componentdata.isSetNagType())
                {
                    tprotocol.writeI32(componentdata.nagType.getValue());
                }
                if (componentdata.isSetEducationType())
                {
                    tprotocol.writeI32(componentdata.educationType.getValue());
                }
                if (componentdata.isSetDigestStoryType())
                {
                    tprotocol.writeString(componentdata.digestStoryType);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (ComponentData)tbase);
            }

            private ComponentDataTupleScheme()
            {
            }

            ComponentDataTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
