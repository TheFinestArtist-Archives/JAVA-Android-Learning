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
import org.apache.thrift.meta_data.EnumMetaData;
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
//            RecommendationObjectType, RecommendationDetail

public class TypedRecommendationList
    implements Serializable, Cloneable, Comparable, TBase
{

    private static final TField OBJECT_TYPE_FIELD_DESC = new TField("objectType", (byte)8, (short)1);
    private static final TField RECOMMENDATIONS_FIELD_DESC = new TField("recommendations", (byte)15, (short)2);
    private static final TField RECOMMENDATION_DETAILS_FIELD_DESC = new TField("recommendationDetails", (byte)15, (short)3);
    private static final TStruct STRUCT_DESC = new TStruct("TypedRecommendationList");
    public static final Map metaDataMap;
    private static final _Fields optionals[];
    private static final Map schemes;
    public RecommendationObjectType objectType;
    public List recommendationDetails;
    public List recommendations;

    public TypedRecommendationList()
    {
    }

    public TypedRecommendationList(TypedRecommendationList typedrecommendationlist)
    {
        if (typedrecommendationlist.isSetObjectType())
        {
            objectType = typedrecommendationlist.objectType;
        }
        if (typedrecommendationlist.isSetRecommendations())
        {
            recommendations = new ArrayList(typedrecommendationlist.recommendations);
        }
        if (typedrecommendationlist.isSetRecommendationDetails())
        {
            ArrayList arraylist = new ArrayList(typedrecommendationlist.recommendationDetails.size());
            for (typedrecommendationlist = typedrecommendationlist.recommendationDetails.iterator(); typedrecommendationlist.hasNext(); arraylist.add(new RecommendationDetail((RecommendationDetail)typedrecommendationlist.next()))) { }
            recommendationDetails = arraylist;
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

    public void addToRecommendationDetails(RecommendationDetail recommendationdetail)
    {
        if (recommendationDetails == null)
        {
            recommendationDetails = new ArrayList();
        }
        recommendationDetails.add(recommendationdetail);
    }

    public void addToRecommendations(String s)
    {
        if (recommendations == null)
        {
            recommendations = new ArrayList();
        }
        recommendations.add(s);
    }

    public void clear()
    {
        objectType = null;
        recommendations = null;
        recommendationDetails = null;
    }

    public int compareTo(TypedRecommendationList typedrecommendationlist)
    {
        if (getClass().equals(typedrecommendationlist.getClass())) goto _L2; else goto _L1
_L1:
        int i = getClass().getName().compareTo(typedrecommendationlist.getClass().getName());
_L4:
        return i;
_L2:
        int j;
        j = Boolean.valueOf(isSetObjectType()).compareTo(Boolean.valueOf(typedrecommendationlist.isSetObjectType()));
        i = j;
        if (j != 0) goto _L4; else goto _L3
_L3:
        if (!isSetObjectType())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(objectType, typedrecommendationlist.objectType);
        i = j;
        if (j != 0) goto _L4; else goto _L5
_L5:
        j = Boolean.valueOf(isSetRecommendations()).compareTo(Boolean.valueOf(typedrecommendationlist.isSetRecommendations()));
        i = j;
        if (j != 0) goto _L4; else goto _L6
_L6:
        if (!isSetRecommendations())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendations, typedrecommendationlist.recommendations);
        i = j;
        if (j != 0) goto _L4; else goto _L7
_L7:
        j = Boolean.valueOf(isSetRecommendationDetails()).compareTo(Boolean.valueOf(typedrecommendationlist.isSetRecommendationDetails()));
        i = j;
        if (j != 0) goto _L4; else goto _L8
_L8:
        if (!isSetRecommendationDetails())
        {
            break; /* Loop/switch isn't completed */
        }
        j = TBaseHelper.compareTo(recommendationDetails, typedrecommendationlist.recommendationDetails);
        i = j;
        if (j != 0) goto _L4; else goto _L9
_L9:
        return 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((TypedRecommendationList)obj);
    }

    public TypedRecommendationList deepCopy()
    {
        return new TypedRecommendationList(this);
    }

    public volatile TBase deepCopy()
    {
        return deepCopy();
    }

    public boolean equals(TypedRecommendationList typedrecommendationlist)
    {
        if (typedrecommendationlist != null)
        {
            boolean flag = isSetObjectType();
            boolean flag3 = typedrecommendationlist.isSetObjectType();
            if (!flag && !flag3 || flag && flag3 && objectType.equals(typedrecommendationlist.objectType))
            {
                boolean flag1 = isSetRecommendations();
                boolean flag4 = typedrecommendationlist.isSetRecommendations();
                if (!flag1 && !flag4 || flag1 && flag4 && recommendations.equals(typedrecommendationlist.recommendations))
                {
                    boolean flag2 = isSetRecommendationDetails();
                    boolean flag5 = typedrecommendationlist.isSetRecommendationDetails();
                    if (!flag2 && !flag5 || flag2 && flag5 && recommendationDetails.equals(typedrecommendationlist.recommendationDetails))
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
        while (obj == null || !(obj instanceof TypedRecommendationList)) 
        {
            return false;
        }
        return equals((TypedRecommendationList)obj);
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
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.TypedRecommendationList._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return getObjectType();

        case 2: // '\002'
            return getRecommendations();

        case 3: // '\003'
            return getRecommendationDetails();
        }
    }

    public volatile Object getFieldValue(TFieldIdEnum tfieldidenum)
    {
        return getFieldValue((_Fields)tfieldidenum);
    }

    public RecommendationObjectType getObjectType()
    {
        return objectType;
    }

    public List getRecommendationDetails()
    {
        return recommendationDetails;
    }

    public Iterator getRecommendationDetailsIterator()
    {
        if (recommendationDetails == null)
        {
            return null;
        } else
        {
            return recommendationDetails.iterator();
        }
    }

    public int getRecommendationDetailsSize()
    {
        if (recommendationDetails == null)
        {
            return 0;
        } else
        {
            return recommendationDetails.size();
        }
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

    public int hashCode()
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = isSetObjectType();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(Integer.valueOf(objectType.getValue()));
        }
        flag = isSetRecommendations();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendations);
        }
        flag = isSetRecommendationDetails();
        arraylist.add(Boolean.valueOf(flag));
        if (flag)
        {
            arraylist.add(recommendationDetails);
        }
        return arraylist.hashCode();
    }

    public boolean isSet(_Fields _pfields)
    {
        if (_pfields == null)
        {
            throw new IllegalArgumentException();
        }
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.TypedRecommendationList._Fields[_pfields.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return isSetObjectType();

        case 2: // '\002'
            return isSetRecommendations();

        case 3: // '\003'
            return isSetRecommendationDetails();
        }
    }

    public volatile boolean isSet(TFieldIdEnum tfieldidenum)
    {
        return isSet((_Fields)tfieldidenum);
    }

    public boolean isSetObjectType()
    {
        return objectType != null;
    }

    public boolean isSetRecommendationDetails()
    {
        return recommendationDetails != null;
    }

    public boolean isSetRecommendations()
    {
        return recommendations != null;
    }

    public void read(TProtocol tprotocol)
    {
        ((SchemeFactory)schemes.get(tprotocol.getScheme())).getScheme().read(tprotocol, this);
    }

    public void setFieldValue(_Fields _pfields, Object obj)
    {
        switch (_cls1..SwitchMap.com.pinterest.schemas.email_queued.TypedRecommendationList._Fields[_pfields.ordinal()])
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
                setObjectType((RecommendationObjectType)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetRecommendations();
                return;
            } else
            {
                setRecommendations((List)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetRecommendationDetails();
            return;
        } else
        {
            setRecommendationDetails((List)obj);
            return;
        }
    }

    public volatile void setFieldValue(TFieldIdEnum tfieldidenum, Object obj)
    {
        setFieldValue((_Fields)tfieldidenum, obj);
    }

    public TypedRecommendationList setObjectType(RecommendationObjectType recommendationobjecttype)
    {
        objectType = recommendationobjecttype;
        return this;
    }

    public void setObjectTypeIsSet(boolean flag)
    {
        if (!flag)
        {
            objectType = null;
        }
    }

    public TypedRecommendationList setRecommendationDetails(List list)
    {
        recommendationDetails = list;
        return this;
    }

    public void setRecommendationDetailsIsSet(boolean flag)
    {
        if (!flag)
        {
            recommendationDetails = null;
        }
    }

    public TypedRecommendationList setRecommendations(List list)
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

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("TypedRecommendationList(");
        boolean flag = true;
        if (isSetObjectType())
        {
            stringbuilder.append("objectType:");
            if (objectType == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(objectType);
            }
            flag = false;
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
                flag = flag1;
            } else
            {
                stringbuilder.append(recommendations);
                flag = flag1;
            }
        }
        if (isSetRecommendationDetails())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("recommendationDetails:");
            if (recommendationDetails == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(recommendationDetails);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetObjectType()
    {
        objectType = null;
    }

    public void unsetRecommendationDetails()
    {
        recommendationDetails = null;
    }

    public void unsetRecommendations()
    {
        recommendations = null;
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
        ((Map) (obj)).put(org/apache/thrift/scheme/StandardScheme, new TypedRecommendationListStandardSchemeFactory(null));
        schemes.put(org/apache/thrift/scheme/TupleScheme, new TypedRecommendationListTupleSchemeFactory(null));
        optionals = (new _Fields[] {
            _Fields.OBJECT_TYPE, _Fields.RECOMMENDATIONS, _Fields.RECOMMENDATION_DETAILS
        });
        obj = new EnumMap(com/pinterest/schemas/email_queued/TypedRecommendationList$_Fields);
        ((Map) (obj)).put(_Fields.OBJECT_TYPE, new FieldMetaData("objectType", (byte)2, new EnumMetaData((byte)16, com/pinterest/schemas/email_queued/RecommendationObjectType)));
        ((Map) (obj)).put(_Fields.RECOMMENDATIONS, new FieldMetaData("recommendations", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        ((Map) (obj)).put(_Fields.RECOMMENDATION_DETAILS, new FieldMetaData("recommendationDetails", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/pinterest/schemas/email_queued/RecommendationDetail))));
        metaDataMap = Collections.unmodifiableMap(((Map) (obj)));
        FieldMetaData.addStructMetaDataMap(com/pinterest/schemas/email_queued/TypedRecommendationList, metaDataMap);
    }





    private class _Fields extends Enum
        implements TFieldIdEnum
    {

        private static final _Fields $VALUES[];
        public static final _Fields OBJECT_TYPE;
        public static final _Fields RECOMMENDATIONS;
        public static final _Fields RECOMMENDATION_DETAILS;
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
                return RECOMMENDATIONS;

            case 3: // '\003'
                return RECOMMENDATION_DETAILS;
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
            return (_Fields)Enum.valueOf(com/pinterest/schemas/email_queued/TypedRecommendationList$_Fields, s);
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
            RECOMMENDATIONS = new _Fields("RECOMMENDATIONS", 1, (short)2, "recommendations");
            RECOMMENDATION_DETAILS = new _Fields("RECOMMENDATION_DETAILS", 2, (short)3, "recommendationDetails");
            $VALUES = (new _Fields[] {
                OBJECT_TYPE, RECOMMENDATIONS, RECOMMENDATION_DETAILS
            });
            byName = new HashMap();
            _Fields _lfields;
            for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/email_queued/TypedRecommendationList$_Fields).iterator(); iterator.hasNext(); byName.put(_lfields.getFieldName(), _lfields))
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

        static final int $SwitchMap$com$pinterest$schemas$email_queued$TypedRecommendationList$_Fields[];

        static 
        {
            $SwitchMap$com$pinterest$schemas$email_queued$TypedRecommendationList$_Fields = new int[_Fields.values().length];
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$TypedRecommendationList$_Fields[_Fields.OBJECT_TYPE.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$TypedRecommendationList$_Fields[_Fields.RECOMMENDATIONS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$pinterest$schemas$email_queued$TypedRecommendationList$_Fields[_Fields.RECOMMENDATION_DETAILS.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class TypedRecommendationListStandardSchemeFactory
        implements SchemeFactory
    {

        public TypedRecommendationListStandardScheme getScheme()
        {
            return new TypedRecommendationListStandardScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TypedRecommendationListStandardSchemeFactory()
        {
        }

        TypedRecommendationListStandardSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TypedRecommendationListStandardScheme extends StandardScheme
        {

            public void read(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
            {
                tprotocol.readStructBegin();
_L6:
                Object obj;
                obj = tprotocol.readFieldBegin();
                if (((TField) (obj)).type == 0)
                {
                    break MISSING_BLOCK_LABEL_293;
                }
                ((TField) (obj)).id;
                JVM INSTR tableswitch 1 3: default 48
            //                           1 63
            //                           2 102
            //                           3 193;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_193;
_L2:
                break; /* Loop/switch isn't completed */
_L1:
                TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L7:
                tprotocol.readFieldEnd();
                if (true) goto _L6; else goto _L5
_L5:
                if (((TField) (obj)).type == 8)
                {
                    typedrecommendationlist.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    typedrecommendationlist.setObjectTypeIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
_L3:
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    typedrecommendationlist.recommendations = new ArrayList(((TList) (obj)).size);
                    for (int i = 0; i < ((TList) (obj)).size; i++)
                    {
                        String s = tprotocol.readString();
                        typedrecommendationlist.recommendations.add(s);
                    }

                    tprotocol.readListEnd();
                    typedrecommendationlist.setRecommendationsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                if (((TField) (obj)).type == 15)
                {
                    obj = tprotocol.readListBegin();
                    typedrecommendationlist.recommendationDetails = new ArrayList(((TList) (obj)).size);
                    for (int j = 0; j < ((TList) (obj)).size; j++)
                    {
                        RecommendationDetail recommendationdetail = new RecommendationDetail();
                        recommendationdetail.read(tprotocol);
                        typedrecommendationlist.recommendationDetails.add(recommendationdetail);
                    }

                    tprotocol.readListEnd();
                    typedrecommendationlist.setRecommendationDetailsIsSet(true);
                } else
                {
                    TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
                }
                  goto _L7
                tprotocol.readStructEnd();
                typedrecommendationlist.validate();
                return;
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TypedRecommendationList)tbase);
            }

            public void write(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
            {
                typedrecommendationlist.validate();
                tprotocol.writeStructBegin(TypedRecommendationList.STRUCT_DESC);
                if (typedrecommendationlist.objectType != null && typedrecommendationlist.isSetObjectType())
                {
                    tprotocol.writeFieldBegin(TypedRecommendationList.OBJECT_TYPE_FIELD_DESC);
                    tprotocol.writeI32(typedrecommendationlist.objectType.getValue());
                    tprotocol.writeFieldEnd();
                }
                if (typedrecommendationlist.recommendations != null && typedrecommendationlist.isSetRecommendations())
                {
                    tprotocol.writeFieldBegin(TypedRecommendationList.RECOMMENDATIONS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)11, typedrecommendationlist.recommendations.size()));
                    for (Iterator iterator = typedrecommendationlist.recommendations.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                if (typedrecommendationlist.recommendationDetails != null && typedrecommendationlist.isSetRecommendationDetails())
                {
                    tprotocol.writeFieldBegin(TypedRecommendationList.RECOMMENDATION_DETAILS_FIELD_DESC);
                    tprotocol.writeListBegin(new TList((byte)12, typedrecommendationlist.recommendationDetails.size()));
                    for (typedrecommendationlist = typedrecommendationlist.recommendationDetails.iterator(); typedrecommendationlist.hasNext(); ((RecommendationDetail)typedrecommendationlist.next()).write(tprotocol)) { }
                    tprotocol.writeListEnd();
                    tprotocol.writeFieldEnd();
                }
                tprotocol.writeFieldStop();
                tprotocol.writeStructEnd();
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TypedRecommendationList)tbase);
            }

            private TypedRecommendationListStandardScheme()
            {
            }

            TypedRecommendationListStandardScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class TypedRecommendationListTupleSchemeFactory
        implements SchemeFactory
    {

        public TypedRecommendationListTupleScheme getScheme()
        {
            return new TypedRecommendationListTupleScheme(null);
        }

        public volatile IScheme getScheme()
        {
            return getScheme();
        }

        private TypedRecommendationListTupleSchemeFactory()
        {
        }

        TypedRecommendationListTupleSchemeFactory(_cls1 _pcls1)
        {
            this();
        }

        private class TypedRecommendationListTupleScheme extends TupleScheme
        {

            public void read(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
            {
                boolean flag = false;
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = tprotocol.readBitSet(3);
                if (bitset.get(0))
                {
                    typedrecommendationlist.objectType = RecommendationObjectType.findByValue(tprotocol.readI32());
                    typedrecommendationlist.setObjectTypeIsSet(true);
                }
                if (bitset.get(1))
                {
                    TList tlist1 = new TList((byte)11, tprotocol.readI32());
                    typedrecommendationlist.recommendations = new ArrayList(tlist1.size);
                    for (int i = 0; i < tlist1.size; i++)
                    {
                        String s = tprotocol.readString();
                        typedrecommendationlist.recommendations.add(s);
                    }

                    typedrecommendationlist.setRecommendationsIsSet(true);
                }
                if (bitset.get(2))
                {
                    TList tlist = new TList((byte)12, tprotocol.readI32());
                    typedrecommendationlist.recommendationDetails = new ArrayList(tlist.size);
                    for (int j = ((flag) ? 1 : 0); j < tlist.size; j++)
                    {
                        RecommendationDetail recommendationdetail = new RecommendationDetail();
                        recommendationdetail.read(tprotocol);
                        typedrecommendationlist.recommendationDetails.add(recommendationdetail);
                    }

                    typedrecommendationlist.setRecommendationDetailsIsSet(true);
                }
            }

            public volatile void read(TProtocol tprotocol, TBase tbase)
            {
                read(tprotocol, (TypedRecommendationList)tbase);
            }

            public void write(TProtocol tprotocol, TypedRecommendationList typedrecommendationlist)
            {
                tprotocol = (TTupleProtocol)tprotocol;
                BitSet bitset = new BitSet();
                if (typedrecommendationlist.isSetObjectType())
                {
                    bitset.set(0);
                }
                if (typedrecommendationlist.isSetRecommendations())
                {
                    bitset.set(1);
                }
                if (typedrecommendationlist.isSetRecommendationDetails())
                {
                    bitset.set(2);
                }
                tprotocol.writeBitSet(bitset, 3);
                if (typedrecommendationlist.isSetObjectType())
                {
                    tprotocol.writeI32(typedrecommendationlist.objectType.getValue());
                }
                if (typedrecommendationlist.isSetRecommendations())
                {
                    tprotocol.writeI32(typedrecommendationlist.recommendations.size());
                    for (Iterator iterator = typedrecommendationlist.recommendations.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next())) { }
                }
                if (typedrecommendationlist.isSetRecommendationDetails())
                {
                    tprotocol.writeI32(typedrecommendationlist.recommendationDetails.size());
                    for (typedrecommendationlist = typedrecommendationlist.recommendationDetails.iterator(); typedrecommendationlist.hasNext(); ((RecommendationDetail)typedrecommendationlist.next()).write(tprotocol)) { }
                }
            }

            public volatile void write(TProtocol tprotocol, TBase tbase)
            {
                write(tprotocol, (TypedRecommendationList)tbase);
            }

            private TypedRecommendationListTupleScheme()
            {
            }

            TypedRecommendationListTupleScheme(_cls1 _pcls1)
            {
                this();
            }
        }

    }

}
