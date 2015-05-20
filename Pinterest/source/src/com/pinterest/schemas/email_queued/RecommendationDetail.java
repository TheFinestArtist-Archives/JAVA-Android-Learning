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
import java.util.List;
import java.util.Map;
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

public class RecommendationDetail
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField ALGO_TAG_FIELD_DESC = new TField("algoTag", (byte)11, (short)2);
    private static final TField ID_STRING_FIELD_DESC = new TField("idString", (byte)11, (short)1);
    private static final TField SOURCE_FIELD_DESC = new TField("source", (byte)11, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("RecommendationDetail");
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public String algoTag;
    public String idString;
    public String source;

    public RecommendationDetail()
    {
    }

    public RecommendationDetail(RecommendationDetail recommendationdetail)
    {
        if (recommendationdetail.isSetIdString())
        {
            idString = recommendationdetail.idString;
        }
        if (recommendationdetail.isSetAlgoTag())
        {
            algoTag = recommendationdetail.algoTag;
        }
        if (recommendationdetail.isSetSource())
        {
            source = recommendationdetail.source;
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

    public void clear()
    {
        idString = null;
        algoTag = null;
        source = null;
    }

    public int compareTo(RecommendationDetail recommendationdetail)
    {
        if (getClass().equals(recommendationdetail.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(recommendationdetail.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetIdString()).compareTo(Boolean.valueOf(recommendationdetail.isSetIdString()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetIdString())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(idString, recommendationdetail.idString);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetAlgoTag()).compareTo(Boolean.valueOf(recommendationdetail.isSetAlgoTag()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetAlgoTag())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(algoTag, recommendationdetail.algoTag);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetSource()).compareTo(Boolean.valueOf(recommendationdetail.isSetSource()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetSource())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(source, recommendationdetail.source);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((RecommendationDetail)obj);
    }

    public RecommendationDetail deepCopy()
    {
        return new RecommendationDetail(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(RecommendationDetail recommendationdetail)
    {
        if (recommendationdetail != null)
        {
            boolean flag = isSetIdString();
            boolean flag3 = recommendationdetail.isSetIdString();
            if (!flag && !flag3 || flag && flag3 && idString.equals(recommendationdetail.idString))
            {
                boolean flag1 = isSetAlgoTag();
                boolean flag4 = recommendationdetail.isSetAlgoTag();
                if (!flag1 && !flag4 || flag1 && flag4 && algoTag.equals(recommendationdetail.algoTag))
                {
                    boolean flag2 = isSetSource();
                    boolean flag5 = recommendationdetail.isSetSource();
                    if (!flag2 && !flag5 || flag2 && flag5 && source.equals(recommendationdetail.source))
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
        while (obj == null || !(obj instanceof RecommendationDetail)) 
        {
            return false;
        }
        return equals((RecommendationDetail)obj);
    }

    public _Fields fieldForId(int i)
    {
        return _Fields.findByThriftId(i);
    }

    public volatile TFieldIdEnum fieldForId(int i)
    {
        return fieldForId(i);
    }

    public String getAlgoTag()
    {
        return algoTag;
    }

    public Object getFieldValue(_Fields _pfields)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationDetail._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getIdString();

        case 2: // '\002'
            return getAlgoTag();

        case 3: // '\003'
            return getSource();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public String getIdString()
    {
        return idString;
    }

    public String getSource()
    {
        return source;
    }

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetIdString();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(idString);
        }
        flag = isSetAlgoTag();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(algoTag);
        }
        flag = isSetSource();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(source);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationDetail._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetIdString();

        case 2: // '\002'
            return isSetAlgoTag();

        case 3: // '\003'
            return isSetSource();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetAlgoTag()
    {
        return algoTag != null;
    }

    public boolean isSetIdString()
    {
        return idString != null;
    }

    public boolean isSetSource()
    {
        return source != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public RecommendationDetail setAlgoTag(String s)
    {
        algoTag = s;
        return this;
    }

    public void setAlgoTagIsSet(boolean flag)
    {
        if (!flag)
        {
            algoTag = null;
        }
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.RecommendationDetail._Fields[_pfields.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (obj == null)
            {
                unsetIdString();
                return;
            } else
            {
                setIdString((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAlgoTag();
                return;
            } else
            {
                setAlgoTag((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetSource();
            return;
        } else
        {
            setSource((String)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public RecommendationDetail setIdString(String s)
    {
        idString = s;
        return this;
    }

    public void setIdStringIsSet(boolean flag)
    {
        if (!flag)
        {
            idString = null;
        }
    }

    public RecommendationDetail setSource(String s)
    {
        source = s;
        return this;
    }

    public void setSourceIsSet(boolean flag)
    {
        if (!flag)
        {
            source = null;
        }
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("RecommendationDetail(");
        boolean flag = true;
        if (isSetIdString())
        {
            stringbuilder.append("idString:");
            if (idString == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(idString);
            }
            flag = false;
        }
        if (isSetAlgoTag())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("algoTag:");
            if (algoTag == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(algoTag);
                flag = flag1;
            }
        }
        if (isSetSource())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("source:");
            if (source == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(source);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAlgoTag()
    {
        algoTag = null;
    }

    public void unsetIdString()
    {
        idString = null;
    }

    public void unsetSource()
    {
        source = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new RecommendationDetailStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new RecommendationDetailTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.ID_STRING, _Fields.ALGO_TAG, _Fields.SOURCE
        });
        obj = new EnumMap(com/pinterest/schemas/email_queued/RecommendationDetail$_Fields);
        ((Map) (obj)).put(_Fields.ID_STRING, new FieldMetaData("idString", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.ALGO_TAG, new FieldMetaData("algoTag", (byte)2, new FieldValueMetaData((byte)11)));
        ((Map) (obj)).put(_Fields.SOURCE, new FieldMetaData("source", (byte)2, new FieldValueMetaData((byte)11)));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/RecommendationDetail, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields ALGO_TAG;
        public static final _Fields ID_STRING;
        public static final _Fields SOURCE;
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
                return ID_STRING;

            case 2: // '\002'
                return ALGO_TAG;

            case 3: // '\003'
                return SOURCE;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/RecommendationDetail$_Fields, s);
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
            ID_STRING = new _Fields("ID_STRING", 0, (short)1, "idString");
            ALGO_TAG = new _Fields("ALGO_TAG", 1, (short)2, "algoTag");
            SOURCE = new _Fields("SOURCE", 2, (short)3, "source");
            $VALUES = (new _Fields[] {
                ID_STRING, ALGO_TAG, SOURCE
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/RecommendationDetail$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$RecommendationDetail$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$RecommendationDetail$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationDetail$_Fields[_Fields.ID_STRING.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationDetail$_Fields[_Fields.ALGO_TAG.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$RecommendationDetail$_Fields[_Fields.SOURCE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class RecommendationDetailStandardSchemeFactory
        implements SchemeFactory
    {

        public RecommendationDetailStandardScheme getScheme()
        {
            return new RecommendationDetailStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationDetailStandardSchemeFactory()
        {
        }

        RecommendationDetailStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationDetailStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, RecommendationDetail recommendationdetail)
            {
                tprotocol.readStructBegin();
_L6:
                TField tfield;
                tfield = tprotocol.readFieldBegin();
                if (tfield.type == 0)
                {
                    break MISSING_BLOCK_LABEL_171;
                }
                tfield.id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 99
            //                           3 135;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_135;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (tfield.type == 11)
                {
                    recommendationdetail.idString = tprotocol.readString();
                    recommendationdetail.setIdStringIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
_L3:
                if (tfield.type == 11)
                {
                    recommendationdetail.algoTag = tprotocol.readString();
                    recommendationdetail.setAlgoTagIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                if (tfield.type == 11)
                {
                    recommendationdetail.source = tprotocol.readString();
                    recommendationdetail.setSourceIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, tfield.type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                recommendationdetail.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationDetail)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationDetail recommendationdetail)
            {
                recommendationdetail.validate();
                tprotocol.writeStructBegin(RecommendationDetail.STRUCT_DESC);
                if (recommendationdetail.idString != null && recommendationdetail.isSetIdString())
                {
                    tprotocol.writeFieldBegin(RecommendationDetail.ID_STRING_FIELD_DESC);
                    tprotocol.writeString(recommendationdetail.idString);
                    tprotocol.writeFieldEnd();
                }
                if (recommendationdetail.algoTag != null && recommendationdetail.isSetAlgoTag())
                {
                    tprotocol.writeFieldBegin(RecommendationDetail.ALGO_TAG_FIELD_DESC);
                    tprotocol.writeString(recommendationdetail.algoTag);
                    tprotocol.writeFieldEnd();
                }
                if (recommendationdetail.source != null && recommendationdetail.isSetSource())
                {
                    tprotocol.writeFieldBegin(RecommendationDetail.SOURCE_FIELD_DESC);
                    tprotocol.writeString(recommendationdetail.source);
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationDetail)tbase);
            }

            private RecommendationDetailStandardScheme()
            {
            }

            RecommendationDetailStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class RecommendationDetailTupleSchemeFactory
        implements SchemeFactory
    {

        public RecommendationDetailTupleScheme getScheme()
        {
            return new RecommendationDetailTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private RecommendationDetailTupleSchemeFactory()
        {
        }

        RecommendationDetailTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class RecommendationDetailTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, RecommendationDetail recommendationdetail)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    recommendationdetail.idString = tprotocol.readString();
                    recommendationdetail.setIdStringIsSet(true);
                }
                if (bitset.get(1))
                {
                    recommendationdetail.algoTag = tprotocol.readString();
                    recommendationdetail.setAlgoTagIsSet(true);
                }
                if (bitset.get(2))
                {
                    recommendationdetail.source = tprotocol.readString();
                    recommendationdetail.setSourceIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (RecommendationDetail)tbase);
            }

            public void write(TProtocol tprotocol, RecommendationDetail recommendationdetail)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (recommendationdetail.isSetIdString())
                {
                    bitset.set(0);
                }
                if (recommendationdetail.isSetAlgoTag())
                {
                    bitset.set(1);
                }
                if (recommendationdetail.isSetSource())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (recommendationdetail.isSetIdString())
                {
                    tprotocol.writeString(recommendationdetail.idString);
                }
                if (recommendationdetail.isSetAlgoTag())
                {
                    tprotocol.writeString(recommendationdetail.algoTag);
                }
                if (recommendationdetail.isSetSource())
                {
                    tprotocol.writeString(recommendationdetail.source);
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (RecommendationDetail)tbase);
            }

            private RecommendationDetailTupleScheme()
            {
            }

            RecommendationDetailTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
