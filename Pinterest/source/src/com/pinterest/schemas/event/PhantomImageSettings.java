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
//            PhantomClipRect

public class PhantomImageSettings
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField CLIP_RECT_FIELD_DESC = new TField("clipRect", (byte)12, (short)1);
    private static final TField LOAD_IMAGES_FIELD_DESC = new TField("loadImages", (byte)2, (short)2);
    private static final TStruct STRUCT_DESC = new TStruct("PhantomImageSettings");
    private static final int __LOADIMAGES_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    private byte __isset_bitfield;
    public PhantomClipRect clipRect;
    public boolean loadImages;

    public PhantomImageSettings()
    {
        __isset_bitfield = 0;
    }

    public PhantomImageSettings(PhantomImageSettings phantomimagesettings)
    {
        __isset_bitfield = 0;
        __isset_bitfield = phantomimagesettings.__isset_bitfield;
        if (phantomimagesettings.isSetClipRect())
        {
            clipRect = new PhantomClipRect(phantomimagesettings.clipRect);
        }
        loadImages = phantomimagesettings.loadImages;
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
        clipRect = null;
        setLoadImagesIsSet(false);
        loadImages = false;
    }

    public int compareTo(PhantomImageSettings phantomimagesettings)
    {
        if (getClass().equals(phantomimagesettings.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(phantomimagesettings.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetClipRect()).compareTo(Boolean.valueOf(phantomimagesettings.isSetClipRect()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetClipRect())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(clipRect, phantomimagesettings.clipRect);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetLoadImages()).compareTo(Boolean.valueOf(phantomimagesettings.isSetLoadImages()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetLoadImages())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(loadImages, phantomimagesettings.loadImages);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((PhantomImageSettings)obj);
    }

    public PhantomImageSettings deepCopy()
    {
        return new PhantomImageSettings(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(PhantomImageSettings phantomimagesettings)
    {
        if (phantomimagesettings != null)
        {
            boolean flag = isSetClipRect();
            boolean flag2 = phantomimagesettings.isSetClipRect();
            if (!flag && !flag2 || flag && flag2 && clipRect.equals(phantomimagesettings.clipRect))
            {
                boolean flag1 = isSetLoadImages();
                boolean flag3 = phantomimagesettings.isSetLoadImages();
                if (!flag1 && !flag3 || flag1 && flag3 && loadImages == phantomimagesettings.loadImages)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof PhantomImageSettings)) 
        {
            return false;
        }
        return equals((PhantomImageSettings)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public PhantomClipRect getClipRect()
    {
        return clipRect;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomImageSettings._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getClipRect();

        case 2: // '\002'
            return Boolean.valueOf(isLoadImages());
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetClipRect();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(clipRect);
        }
        flag = isSetLoadImages();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Boolean.valueOf(loadImages));
        }
        return arraylist.hashCode();
    }

    public boolean isLoadImages()
    {
        return loadImages;
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomImageSettings._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetClipRect();

        case 2: // '\002'
            return isSetLoadImages();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetClipRect()
    {
        return clipRect != null;
    }

    public boolean isSetLoadImages()
    {
        return EncodingUtils.testBit(__isset_bitfield, 0);
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public PhantomImageSettings setClipRect(PhantomClipRect phantomcliprect)
    {
        clipRect = phantomcliprect;
        return this;
    }

    public void setClipRectIsSet(boolean flag)
    {
        if (!flag)
        {
            clipRect = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.event.PhantomImageSettings._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetClipRect();
                return;
            } else
            {
                setClipRect((PhantomClipRect)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetLoadImages();
            return;
        } else
        {
            setLoadImages(((Boolean)obj).booleanValue());
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public PhantomImageSettings setLoadImages(boolean flag)
    {
        loadImages = flag;
        setLoadImagesIsSet(true);
        return this;
    }

    public void setLoadImagesIsSet(boolean flag)
    {
        __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, 0, flag);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PhantomImageSettings(");
        boolean flag = true;
        if (isSetClipRect())
        {
            stringbuilder.append("clipRect:");
            if (clipRect == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(clipRect);
            }
            flag = false;
        }
        if (isSetLoadImages())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("loadImages:");
            stringbuilder.append(loadImages);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetClipRect()
    {
        clipRect = null;
    }

    public void unsetLoadImages()
    {
        __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, 0);
    }

    public void validate()
    {
        if (clipRect != null)
        {
            clipRect.validate();
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new PhantomImageSettingsStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new PhantomImageSettingsTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.CLIP_RECT, _Fields.LOAD_IMAGES
        });
        obj = new EnumMap(com/pinterest/schemas/event/PhantomImageSettings$_Fields);
        ((Map) (obj)).put(_Fields.CLIP_RECT, new FieldMetaData("clipRect", (byte)2, new StructMetaData((byte)12, com/pinterest/schemas/event/PhantomClipRect)));
        ((Map) (obj)).put(_Fields.LOAD_IMAGES, new FieldMetaData("loadImages", (byte)2, new FieldValueMetaData((byte)2)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/event/PhantomImageSettings, metaDataMap);
    }




    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields CLIP_RECT;
        public static final _Fields LOAD_IMAGES;
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
                return CLIP_RECT;

            case 2: // '\002'
                return LOAD_IMAGES;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/event/PhantomImageSettings$_Fields, s);
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
            CLIP_RECT = new _Fields("CLIP_RECT", 0, (short)1, "clipRect");
            LOAD_IMAGES = new _Fields("LOAD_IMAGES", 1, (short)2, "loadImages");
            $VALUES = (new _Fields[] {
                CLIP_RECT, LOAD_IMAGES
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomImageSettings$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$event$PhantomImageSettings$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$event$PhantomImageSettings$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomImageSettings$_Fields[_Fields.CLIP_RECT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$event$PhantomImageSettings$_Fields[_Fields.LOAD_IMAGES.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class PhantomImageSettingsStandardSchemeFactory
        implements SchemeFactory
    {

        public PhantomImageSettingsStandardScheme getScheme()
        {
            return new PhantomImageSettingsStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomImageSettingsStandardSchemeFactory()
        {
        }

        PhantomImageSettingsStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomImageSettingsStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
            {
                tprotocol.readStructBegin();
_L2:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_141;
                }
                switch (tfield.id)
                {
                default:
                    TProtocolUtil.skip(tprotocol, tfield.type);
                    break;

                case 1: // '\001'
                    break; /* Loop/switch isn't completed */

                case 2: // '\002'
                    break MISSING_BLOCK_LABEL_106;
                }
_L3:
                tprotocol.readFieldEnd();
                if (true) goto _L2; else goto _L1
_L1:
                if (tfield.type == 12)
                {
                    phantomimagesettings.clipRect = new PhantomClipRect();
                    phantomimagesettings.clipRect.read(tprotocol);
                    phantomimagesettings.setClipRectIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                if (tfield.type == 2)
                {
                    phantomimagesettings.loadImages = tprotocol.readBool();
                    phantomimagesettings.setLoadImagesIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L3
                tprotocol.readStructEnd();
                phantomimagesettings.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomImageSettings)tbase);
            }

            public void write(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
            {
                phantomimagesettings.validate();
                tprotocol.writeStructBegin(PhantomImageSettings.STRUCT_DESC);
                if (phantomimagesettings.clipRect != null && phantomimagesettings.isSetClipRect())
                {
                    tprotocol.writeFieldBegin(PhantomImageSettings.CLIP_RECT_FIELD_DESC);
                    phantomimagesettings.clipRect.write(tprotocol);
                    tprotocol.writeFieldEnd();
                }
                if (phantomimagesettings.isSetLoadImages())
                {
                    tprotocol.writeFieldBegin(PhantomImageSettings.LOAD_IMAGES_FIELD_DESC);
                    tprotocol.writeBool(phantomimagesettings.loadImages);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomImageSettings)tbase);
            }

            private PhantomImageSettingsStandardScheme()
            {
            }

            PhantomImageSettingsStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class PhantomImageSettingsTupleSchemeFactory
        implements SchemeFactory
    {

        public PhantomImageSettingsTupleScheme getScheme()
        {
            return new PhantomImageSettingsTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private PhantomImageSettingsTupleSchemeFactory()
        {
        }

        PhantomImageSettingsTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class PhantomImageSettingsTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(2);
                if (bitset.get(0))
                {
                    phantomimagesettings.clipRect = new PhantomClipRect();
                    phantomimagesettings.clipRect.read(tprotocol);
                    phantomimagesettings.setClipRectIsSet(true);
                }
                if (bitset.get(1))
                {
                    phantomimagesettings.loadImages = tprotocol.readBool();
                    phantomimagesettings.setLoadImagesIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (PhantomImageSettings)tbase);
            }

            public void write(TProtocol tprotocol, PhantomImageSettings phantomimagesettings)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (phantomimagesettings.isSetClipRect())
                {
                    bitset.set(0);
                }
                if (phantomimagesettings.isSetLoadImages())
                {
                    bitset.set(1);
                }
                tprotocol.writeBitSet(bitset, 2);
                if (phantomimagesettings.isSetClipRect())
                {
                    phantomimagesettings.clipRect.write(tprotocol);
                }
                if (phantomimagesettings.isSetLoadImages())
                {
                    tprotocol.writeBool(phantomimagesettings.loadImages);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (PhantomImageSettings)tbase);
            }

            private PhantomImageSettingsTupleScheme()
            {
            }

            PhantomImageSettingsTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
